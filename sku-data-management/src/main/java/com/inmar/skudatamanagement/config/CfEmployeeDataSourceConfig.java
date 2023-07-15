package com.inmar.skudatamanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * CfConsentDataSourceConfig class is used to configure the datasource details.
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.inmar.skudatamanagement.repository"}, entityManagerFactoryRef = "cfConsentEntityManager", transactionManagerRef = "cfConsentTransactionManager")
@EnableTransactionManagement
@Profile("dev")
public class CfEmployeeDataSourceConfig {
    @Autowired
    DatabaseProperties databaseProperties;

    @Bean(name = "cfConsentdataSource")
    @Primary
    public DataSource cfConsentdataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(databaseProperties.getJdbcUrl());
        dataSourceBuilder.username(databaseProperties.getUsername());
        dataSourceBuilder.password(databaseProperties.getPassword());
        return dataSourceBuilder.build();

    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean cfConsentEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(cfConsentdataSource());
        em.setPackagesToScan("com.inmar.skudatamanagement.entity");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());

        return em;
    }

    @Bean
    @Primary
    public PlatformTransactionManager cfConsentTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(cfConsentEntityManager().getObject());

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.show_sql", "false");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
        return properties;
    }
}
