package kr.co.learche.rest_api_base.common.dto.jwt

import java.util.Date

data class TokenResponseDto (
    val token: String,
    val utcExpirationDate: Date,
    val roles: MutableList<String>
)
