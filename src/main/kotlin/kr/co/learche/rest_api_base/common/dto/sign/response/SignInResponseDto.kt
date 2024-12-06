package kr.co.learche.rest_api_base.common.dto.sign.response

import java.util.Date

data class SignInResponseDto(
    val token: String,
    val utcExpirationDate: Date,
    val roles: MutableList<String>
)
