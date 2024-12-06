package kr.co.learche.rest_api_base

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import

@Import(TestcontainersConfiguration::class)
@SpringBootTest
class RestApiBaseApplicationTests {

	@Test
	fun contextLoads() {
	}

}
