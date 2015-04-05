
package com.epam.repository.template;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration(locations = {"classpath:/springConfigTest.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class UTRepositoryTestsTemplate extends RepositoryTestsTemplate {
    
}
