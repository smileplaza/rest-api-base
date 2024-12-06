package kr.co.learche.rest_api_base.common.service.user

import kr.co.learche.rest_api_base.common.dto.user.UsersResponseDto
import kr.co.learche.rest_api_base.common.repository.UserMasterRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userMasterRepository: UserMasterRepository
) {

    fun getAllUsers(): MutableList<UsersResponseDto> {
        val usersResponse: MutableList<UsersResponseDto> = mutableListOf()

        userMasterRepository.findAll().map {
            userMaster ->
            usersResponse.add(
                UsersResponseDto(
                    email = userMaster.email,
                    nickName = userMaster.nickName,
                    roles = userMaster.roles
                )
            )
        }

        return usersResponse
    }
}
