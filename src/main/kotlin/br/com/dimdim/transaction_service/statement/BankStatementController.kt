
package br.com.dimdim.transaction_service.statement

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/statements")
class BankStatementController(private val bankStatementService: BankStatementService) {

    @GetMapping("/{customerId}")
    fun getStatement(@PathVariable customerId: String): List<BankStatement> {
        return bankStatementService.findByCustomerId(customerId)
    }
}
