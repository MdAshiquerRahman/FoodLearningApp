from rest_framework import viewsets, status
from rest_framework.permissions import IsAuthenticated, IsAuthenticatedOrReadOnly
from rest_framework.decorators import action, api_view, permission_classes
from rest_framework.response import Response
from django.shortcuts import get_object_or_404
from django.views.decorators.csrf import csrf_exempt

from .models import Video, VideoComment, VideoWatchHistory
from .serializers import VideoSerializer, VideoCommentSerializer, VideoWatchHistorySerializer

class VideoViewSet(viewsets.ModelViewSet):
    queryset = Video.objects.all()
    serializer_class = VideoSerializer
    permission_classes = [IsAuthenticatedOrReadOnly]

    def get_serializer_context(self):
        context = super().get_serializer_context()
        context.update({"request": self.request})
        return context

    def perform_create(self, serializer):
        serializer.save(uploaded_by=self.request.user)

    @action(detail=False, methods=['get'], permission_classes=[IsAuthenticated], url_path='liked-videos')
    def liked_videos(self, request):
        liked_videos = request.user.liked_videos.all()
        serializer = self.get_serializer(liked_videos, many=True)
        return Response(serializer.data)
    @action(
        detail=False,
        methods=['get'],
        permission_classes=[IsAuthenticated],
        url_path='favorite-videos'
    )
    def favorite_videos(self, request):
        user = request.user
        favorite_videos = user.favorite_videos.all()
        page = self.paginate_queryset(favorite_videos)
        if page is not None:
            serializer = self.get_serializer(page, many=True)
            return self.get_paginated_response(serializer.data)

        serializer = self.get_serializer(favorite_videos, many=True)
        return Response(serializer.data)


class VideoCommentViewSet(viewsets.ModelViewSet):
    queryset = VideoComment.objects.all()
    serializer_class = VideoCommentSerializer
    permission_classes = [IsAuthenticatedOrReadOnly]

    def perform_create(self, serializer):
        serializer.save(user=self.request.user)

    def destroy(self, request, *args, **kwargs):
        comment = self.get_object()
        # Only allow deletion if the requesting user is the comment owner
        if comment.user == request.user:
            self.perform_destroy(comment)
            return Response(status=status.HTTP_204_NO_CONTENT)
        return Response(
            {"detail": "You do not have permission to delete this comment."},
            status=status.HTTP_403_FORBIDDEN
        )

@api_view(['GET', 'POST'])
@permission_classes([IsAuthenticated])
def toggle_like(request, video_id):
    video = get_object_or_404(Video, id=video_id)
    user = request.user

    if request.method == 'GET':
        liked = user in video.likes.all()
        return Response({'liked': liked, 'total_likes': video.total_likes()})

    if user in video.likes.all():
        video.likes.remove(user)
        liked = False
    else:
        video.likes.add(user)
        video.dislikes.remove(user)  # optional
        liked = True

    return Response({'liked': liked, 'total_likes': video.total_likes()})


@api_view(['GET', 'POST'])
@permission_classes([IsAuthenticated])
def toggle_dislike(request, video_id):
    video = get_object_or_404(Video, id=video_id)
    user = request.user

    if request.method == 'GET':
        disliked = user in video.dislikes.all()
        return Response({'disliked': disliked, 'total_dislikes': video.total_dislikes()})

    if user in video.dislikes.all():
        video.dislikes.remove(user)
        disliked = False
    else:
        video.dislikes.add(user)
        video.likes.remove(user)  # optional
        disliked = True

    return Response({'disliked': disliked, 'total_dislikes': video.total_dislikes()})


@api_view(['POST'])
@permission_classes([IsAuthenticated])
def toggle_favorite(request, video_id):
    video = get_object_or_404(Video, id=video_id)
    user = request.user

    if user in video.favorites.all():
        video.favorites.remove(user)
        favorited = False
    else:
        video.favorites.add(user)
        favorited = True

    return Response({'favorited': favorited})



@api_view(['POST'])
@permission_classes([IsAuthenticated])
@csrf_exempt
def add_to_watch_history(request, video_id):
    video = get_object_or_404(Video, id=video_id)
    history, created = VideoWatchHistory.objects.get_or_create(user=request.user, video=video)
    return Response({'message': 'Video added to watch history'}, status=status.HTTP_200_OK)

@api_view(['GET'])
@permission_classes([IsAuthenticated])
def get_watch_history(request):
    history_qs = VideoWatchHistory.objects.filter(user=request.user)
    serializer = VideoWatchHistorySerializer(history_qs, many=True, context={'request': request})
    return Response(serializer.data)