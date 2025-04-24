package com.example.practice.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practice.MyApp
import com.example.practice.screen.auth.AuthScreen
import com.example.practice.screen.auth.LoginScreen
import com.example.practice.screen.auth.SignUpScreen
import com.example.practice.viewmodel.AuthViewModel
import com.example.practice.viewmodel.VideoViewModel
import kotlinx.coroutines.delay


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigation(
    modifier: Modifier
) {
    val viewModel: AuthViewModel = viewModel()
    val navController = rememberNavController()
    val context = LocalContext.current

    // Observe the login state from AuthViewModel reactively
    val isLoggedIn = viewModel.isLoggedIn.collectAsState(initial = false)
    val isReady = remember { mutableStateOf(false) }

    // Delay rendering for 1 second (e.g., splash screen or initialization)
    LaunchedEffect(Unit) {
        delay(1000)
        isReady.value = true
    }

    // Check login status and update ViewModel
    LaunchedEffect(context) {
        viewModel.checkLoginStatus(context)
    }

    val startDestination = if (isLoggedIn.value) "myapp" else "auth"

//    NavHost(navController = navController, startDestination = startDestination) {
//        composable("auth") {
//            AuthScreen(
//                modifier = modifier,
//                navController = navController,
//                isReadyToRender = isReady.value
//            )
//        }
//        composable("signup") {
//            SignUpScreen(modifier, navController, viewModel)
//        }
//        composable("login") {
//            LoginScreen(modifier, navController, viewModel, context)
//        }
//        composable("myapp") {
//            // Check login state before displaying MyApp
//            if (!isLoggedIn.value) {
//                // Redirect to the login screen
//                navController.navigate("auth") {
//                    popUpTo("auth") { inclusive = true } // Clears the navigation stack
//                }
//            } else {
//                MyApp(
//                    modifier = modifier,
//                    viewModel = viewModel,
//                    videoViewModel = videoViewModel,
//                    context = context
//                )
//            }
//        }
//    }

    NavHost(navController = navController, startDestination = startDestination) {
        composable("auth") {
            AuthScreen(
                modifier = Modifier,
                navController = navController
            )
        }
        composable("signup") {
            SignUpScreen(modifier = Modifier, navController = navController, viewModel = viewModel())
        }
        composable("login") {
            LoginScreen(
                modifier = Modifier,
                navController = navController,
                viewModel = viewModel(),
                context = LocalContext.current
            )
        }
        composable("myapp") {
            MyApp(
                modifier = Modifier,
                viewModel = viewModel(),
                videoViewModel = viewModel(),
                context = LocalContext.current,
                parentNavController = navController
            )
        }
    }
}