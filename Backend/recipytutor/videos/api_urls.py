from django.urls import path, include
from rest_framework.routers import DefaultRouter
from .api_views import (
    VideoViewSet,
    VideoCommentViewSet,
    toggle_like,
    toggle_dislike,
    toggle_favorite
)

router = DefaultRouter()
router.register(r'upload-videos', VideoViewSet, basename='video')
router.register(r'video-comments', VideoCommentViewSet, basename='video-comment')

urlpatterns = [
    path('', include(router.urls)),
    path('toggle-like/<int:video_id>/', toggle_like, name='toggle-like'),
    path('toggle-dislike/<int:video_id>/', toggle_dislike, name='toggle-dislike'),
    path('toggle-favorite/<int:video_id>/', toggle_favorite, name='toggle-favorite'),
]

from .api_views import add_to_watch_history, get_watch_history

urlpatterns += [
    path('add-to-history/<int:video_id>/', add_to_watch_history, name='add-to-history'),
    path('watch-history/', get_watch_history, name='watch-history'),
]
