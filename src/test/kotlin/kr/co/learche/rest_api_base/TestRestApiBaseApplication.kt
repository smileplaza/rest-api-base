package kr.co.learche.rest_api_base

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
	fromApplication<RestApiBaseApplication>().with(TestcontainersConfiguration::class).run(*args)
}
