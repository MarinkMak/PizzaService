
package com.epam.repository.template;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration(locations = {"classpath:/springConfig.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class ITRepositoryTestsTemplate extends RepositoryTestsTemplate {
    
}
