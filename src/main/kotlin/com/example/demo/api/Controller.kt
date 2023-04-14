package com.example.demo.api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    @GetMapping(path = ["/api/{param}/request"])
    fun getRequest(
        @PathVariable(name = "param", required = true)
        param: String,
    ): ResponseEntity<Void> {
        println("Requested request with param $param")
        return ResponseEntity.ok().build()
    }
}