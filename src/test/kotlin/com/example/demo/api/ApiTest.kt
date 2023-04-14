package com.example.demo.api

import com.example.demo.DemoApplication
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [DemoApplication::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiTest {

    @LocalServerPort
    internal var port: Int = 0

    @Test
    fun `Missing path parameter returns 404`() {
        // This works as expected with and without Actuator
        val response1 = khttp.get(
            url = "http://localhost:$port/huppifluppi/request"
        )
        Assertions.assertThat(response1.statusCode).isEqualTo(HttpStatus.OK.value())

        // This returns 200 with and 400 without Actuator
        val response2 = khttp.get(
            url = "http://localhost:$port//request"
        )
        Assertions.assertThat(response2.statusCode).isEqualTo(HttpStatus.BAD_REQUEST.value())
    }
}