package kr.co.learche.rest_api_base.common.service.security

import kr.co.learche.rest_api_base.common.advice.UserNotFoundExceptionCustom
import kr.co.learche.rest_api_base.common.repository.UserMasterRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserDetailsServiceCustom(
    private val userMasterRepository: UserMasterRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        return userMasterRepository.findById(
            UUID.fromString(username)
        ).orElseThrow { UserNotFoundExceptionCustom() }
    }
}
