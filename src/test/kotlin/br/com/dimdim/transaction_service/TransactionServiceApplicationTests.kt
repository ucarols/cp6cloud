package br.com.dimdim.transaction_service

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import br.com.dimdim.transaction_service.statement.BankStatementController
import org.assertj.core.api.Assertions.assertThat

@SpringBootTest
class TransactionServiceApplicationTests {

	@Autowired
	private lateinit var controller: BankStatementController

	@Test
	fun contextLoads() {
		assertThat(this.controller).isNotNull()
	}

}
