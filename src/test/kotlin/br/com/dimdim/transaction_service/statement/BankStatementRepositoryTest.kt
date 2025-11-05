
package br.com.dimdim.transaction_service.statement

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import java.math.BigDecimal
import java.time.LocalDateTime

@DataJpaTest
class BankStatementRepositoryTest @Autowired constructor(
    val entityManager: TestEntityManager,
    val bankStatementRepository: BankStatementRepository
) {

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
        entityManager.persist(statement)
        entityManager.flush()

        val statements = bankStatementRepository.findByCustomerId("123")

        assertThat(statements).hasSize(1)
        assertThat(statements[0]).isEqualTo(statement)
    }
}
