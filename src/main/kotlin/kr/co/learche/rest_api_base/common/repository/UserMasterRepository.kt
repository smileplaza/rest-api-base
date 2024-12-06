package kr.co.learche.rest_api_base.common.repository

import kr.co.learche.rest_api_base.common.domain.UserMaster
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserMasterRepository : JpaRepository<UserMaster, UUID> {
    fun findByEmail(email: String): UserMaster?
}
