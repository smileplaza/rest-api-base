package kr.co.learche.rest_api_base.common.dto.sign.request

import jakarta.validation.constraints.Email

data class SignUpRequestDto(
    @field:Email
    var email: String,
    var password: String,
    var nickname: String
)
