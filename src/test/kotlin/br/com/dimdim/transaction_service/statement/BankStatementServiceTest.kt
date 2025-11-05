
package br.com.dimdim.transaction_service.statement

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import java.math.BigDecimal
import java.time.LocalDateTime

@ExtendWith(MockitoExtension::class)
class BankStatementServiceTest {

    @InjectMocks
    private lateinit var bankStatementService: BankStatementService

    @Mock
    private lateinit var bankStatementRepository: BankStatementRepository

    @Test
    fun `should find by customer id`() {
        val statement = BankStatement(
            customerId = "123",
            transactionId = "456",
            transactionType = "DEBIT",
            transactionValue = BigDecimal.TEN,
            transactionDate = LocalDateTime.now(),
            description = "Test"
        )
        `when`(bankStatementRepository.findByCustomerId("123")).thenReturn(listOf(statement))

        val statements = bankStatementService.findByCustomerId("123")

        assertThat(statements).hasSize(1)
        assertThat(statements[0]).isEqualTo(statement)
    }
}
