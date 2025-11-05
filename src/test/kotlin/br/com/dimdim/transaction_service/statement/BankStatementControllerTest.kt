
package br.com.dimdim.transaction_service.statement

import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.math.BigDecimal
import java.time.LocalDateTime

@WebMvcTest(BankStatementController::class)
class BankStatementControllerTest @Autowired constructor(
    private val mockMvc: MockMvc,
    @MockBean private val bankStatementService: BankStatementService,
) {

    @Test
    fun `should get statement`() {
        val statement = BankStatement(
            id = 1,
            customerId = "123",
            transactionId = "456",
            transactionType = "DEBIT",
            transactionValue = BigDecimal.TEN,
            transactionDate = LocalDateTime.now(),
            description = "Test"
        )
        `when`(bankStatementService.findByCustomerId("123")).thenReturn(listOf(statement))

        mockMvc.perform(get("/statements/123"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.[0].id").value(1))
            .andExpect(jsonPath("$.[0].customerId").value("123"))
    }
}
