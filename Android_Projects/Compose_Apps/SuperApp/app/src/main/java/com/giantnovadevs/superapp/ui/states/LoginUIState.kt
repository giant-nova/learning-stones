package com.giantnovadevs.superapp.ui.states

data class LoginUIState(
		var email: String = "",
		var password: String = "",
		
		var emailError: Boolean = false,
		var passwordError: Boolean = false
)