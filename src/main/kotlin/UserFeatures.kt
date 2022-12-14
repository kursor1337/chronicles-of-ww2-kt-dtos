package com.kursor.chroniclesofww2.features

import kotlinx.serialization.Serializable


@Serializable
data class UserInfo(
    val username: String,
    val score: Int
)

@Serializable
data class ChangePasswordReceiveDTO(
    val currentPassword: String,
    val newPassword: String
)

@Serializable
data class ChangePasswordResponseDTO(
    val token: String?,
    val message: String
)

@Serializable
data class UpdateUserInfoReceiveDTO(
    val updatedUserInfo: UserInfo
)

@Serializable
data class UpdateUserInfoResponseDTO(
    val message: String
)

@Serializable
data class DeleteUserReceiveDTO(
    val login: String,
    val password: String
)

@Serializable
data class DeleteUserResponseDTO(
    val message: String
)

@Serializable
data class AccountInfo(
    val login: String,
    val username: String,
    val score: Int,
    val placeInLeaderboard: Int
)

@Serializable
data class LeaderboardInfoResponseDTO(
    val top: List<UserInfo>
)

@Serializable
data class LeaderboardInfoReceiveDTO(
    val quantity: Int
)

object UserInfoMessages {
    const val SUCCESS = "Success"
    const val NO_SUCH_USER = LoginErrorMessages.NO_SUCH_USER
}
