package kr.co.learche.rest_api_base.common.service.sign

import kr.co.learche.rest_api_base.common.advice.PasswordNotMatchExceptionCustom
import kr.co.learche.rest_api_base.common.advice.UserExistExceptionCustom
import kr.co.learche.rest_api_base.common.advice.UserNotFoundExceptionCustom
import kr.co.learche.rest_api_base.common.config.security.JwtTokenProvider
import kr.co.learche.rest_api_base.common.domain.UserMaster
import kr.co.learche.rest_api_base.common.dto.sign.request.SignInRequestDto
import kr.co.learche.rest_api_base.common.dto.sign.request.SignUpRequestDto
import kr.co.learche.rest_api_base.common.dto.sign.response.SignInResponseDto
import kr.co.learche.rest_api_base.common.repository.UserMasterRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class SignService(
    private val userMasterRepository: UserMasterRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider
) {
    fun signUp(signUpRequestDto: SignUpRequestDto) {
        val user = userMasterRepository.findByEmail(signUpRequestDto.email)

        if (user != null) {
            throw UserExistExceptionCustom()
        }

        val roles = mutableListOf<String>()
        roles.add("ROLE_USER")

        userMasterRepository.save(
            UserMaster(
                email = signUpRequestDto.email,
                password = passwordEncoder.encode(signUpRequestDto.password),
                nickName = signUpRequestDto.nickname,
                createUser = SIGN_UP_SERVICE_NAME,
                updateUser = SIGN_UP_SERVICE_NAME,
                roles = roles
            )
        )
    }

    fun signIn(signInRequestDto: SignInRequestDto): SignInResponseDto {

        val user = userMasterRepository.findByEmail(signInRequestDto.email)
            ?: throw UserNotFoundExceptionCustom()

        if (!passwordEncoder.matches(
                signInRequestDto.password, user.password)) {
            throw PasswordNotMatchExceptionCustom()
        }

        val jwtInfo = jwtTokenProvider.createToken(
            user.id.toString(), user.roles)

        return SignInResponseDto(
            token = jwtInfo.token,
            utcExpirationDate = jwtInfo.utcExpirationDate,
            roles = user.roles
        )
    }

    companion object{
        const val SIGN_UP_SERVICE_NAME = "SIGN_UP"
    }
}
