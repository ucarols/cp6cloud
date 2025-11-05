
package br.com.dimdim.transaction_service.statement

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BankStatementRepository : JpaRepository<BankStatement, Long> {
    fun findByCustomerId(customerId: String): List<BankStatement>
}
