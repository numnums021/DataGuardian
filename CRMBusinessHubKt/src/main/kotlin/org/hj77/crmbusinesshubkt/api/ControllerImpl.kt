package org.hj77.crmbusinesshubkt.api

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ControllerImpl : Controller {

    @PostMapping("/client")
    override fun getClient(@RequestBody param: String): String? {
        return "123";
    }

    @PostMapping("/client/find")
    override fun findClient(str: String?): String? {
        TODO("Not yet implemented")
    }

    @PostMapping("/client/account/last-operations")
    override fun lastOperations(str: String?): String? {
        TODO("Not yet implemented")
    }

    @PostMapping("client/contact/save")
    override fun saveClient(str: String?): String? {
        TODO("Not yet implemented")
    }

    @PostMapping("client/level")
    override fun clientLevel(str: String?): String? {
        TODO("Not yet implemented")
    }

    @PostMapping("client/account/loan-payment")
    override fun clientLoanPayment(str: String?): String? {
        TODO("Not yet implemented")
    }
}