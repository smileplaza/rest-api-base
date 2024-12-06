package kr.co.learche.rest_api_base.common.controller

import kr.co.learche.rest_api_base.common.dto.user.UsersResponseDto
import kr.co.learche.rest_api_base.common.model.response.MutableListResult
import kr.co.learche.rest_api_base.common.service.response.ResponseService
import kr.co.learche.rest_api_base.common.service.user.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users/v1")
class UserController(
    private val userService: UserService,
    private val responseService: ResponseService
) {

    @GetMapping
    fun getAllUsers(): ResponseEntity<MutableListResult<UsersResponseDto>> {
        return ResponseEntity.ok()
            .body(responseService.mutableListResult(
                userService.getAllUsers()
            ))
    }
}
