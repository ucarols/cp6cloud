
package br.com.dimdim.transaction_service.statement

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
data class BankStatement(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val customerId: String,
    val transactionId: String,
    val transactionType: String,
    val transactionValue: BigDecimal,
    val transactionDate: LocalDateTime,
    val description: String
)
