package kr.co.learche.rest_api_base.common.dto.user

data class UsersResponseDto(
    val email: String,
    val nickName: String,
    val roles: MutableList<String>
)
