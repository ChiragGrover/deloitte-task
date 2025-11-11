package com.deloitte.deloittetask.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.deloitte.deloittetask.features.user.UserDetailScreen
import com.deloitte.deloittetask.features.user.UserListScreen
import com.deloitte.deloittetask.features.user.UserViewModel
import com.deloitte.deloittetask.navigation.Routes.USER_DETAIL_ARG_ROUTE
import com.deloitte.deloittetask.navigation.Routes.USER_DETAIL_ROUTE
import com.deloitte.deloittetask.navigation.Routes.USER_LIST_ROUTE
import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

object Routes {
    const val USER_LIST_ROUTE = "user_list_route"
    const val USER_DETAIL_ROUTE = "user_detail_route"
    const val USER_DETAIL_ARG_ROUTE = "user_detail_route/{userJson}"
}

@Composable
fun AppNavGraph(controller: NavHostController) {
    val viewModel: UserViewModel = hiltViewModel()
    NavHost(navController = controller, startDestination = USER_LIST_ROUTE) {
        composable(USER_LIST_ROUTE) {
            UserListScreen(viewModel) {
                val userJson =
                    URLEncoder.encode(Gson().toJson(it), StandardCharsets.UTF_8.toString())
                controller.navigate("$USER_DETAIL_ROUTE/$userJson")
            }
        }
        composable(
            USER_DETAIL_ARG_ROUTE,
            arguments = listOf(navArgument("userJson") { type = NavType.StringType })
        ) {
            val userJson = it.arguments?.getString("userJson")?:""
            UserDetailScreen(userJson) {
                controller.popBackStack()
            }
        }
    }
}