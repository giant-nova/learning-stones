package com.example.navigationScreenApp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation(){
	val navController = rememberNavController()
	NavHost(navController = navController, startDestination = Screen.MainScreen.route){
		composable(route = Screen.MainScreen.route){
			MainScreen(navController = navController)
		}
		composable(
			route = Screen.DetailScreen.route + "/{name}",
			arguments = listOf(
				navArgument("name"){
					type = NavType.StringType
					defaultValue = "kunal"
					nullable = true
				}
			)
		){
			entry ->
			DetailScreen(name = entry.arguments?.getString("name"))
		}
	}
}

@Composable
fun MainScreen(navController: NavController){
	var text by remember {
		mutableStateOf("")
	}
	Column(
		verticalArrangement = Arrangement.Center,
		modifier= Modifier
			.fillMaxWidth()
			.padding(horizontal = 50.dp)
		
	) {
		TextField(
			value = text,
			onValueChange = {
				text = it
			},
			modifier = Modifier
				.fillMaxWidth()
		)
		Spacer(modifier = Modifier.height(8.dp) )
		Button(
			onClick = {
				navController.navigate(Screen.DetailScreen.withArgs(text))
			},
//			modifier = Modifier.align(Alignment.)
		) {
				Text(text = "To Detail Screen")
		}
	}
}

@Composable
fun DetailScreen(name: String?){
	Box(
	){
		Text(text = "Hello $name")
	}
}

//@Preview
//@Composable
//fun MainScreenPreview(){
//	MainScreen(navController = NavController(context =))
//}