
package br.com.dimdim.transaction_service.statement

import org.springframework.stereotype.Service

@Service
class BankStatementService(private val bankStatementRepository: BankStatementRepository) {

    fun findByCustomerId(customerId: String): List<BankStatement> {
        return bankStatementRepository.findByCustomerId(customerId)
    }
}
