package kr.co.learche.rest_api_base.helloworld.repository

import kr.co.learche.rest_api_base.helloworld.domain.BoringHelloWorld
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface BoringHelloWorldRepository :
    JpaRepository<BoringHelloWorld, UUID>