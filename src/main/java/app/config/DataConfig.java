package app.config;

import com.sun.xml.internal.stream.buffer.sax.Properties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories("app.dao")
@EnableTransactionManagement

public class DataConfig {


    @Bean
    DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.
                setDriverClassName("com.mysql.jdbc.Driver");
        hikariConfig.
                setJdbcUrl("jdbc:mysql://localhost:3306/shop?createDatabaseIfNotExist=true");
        hikariConfig.
                setUsername("root");
        hikariConfig.
                setPassword("root");

        hikariConfig.
                addDataSourceProperty
                        ("dataSource.cachePrepStmts", "true");
        hikariConfig.
                addDataSourceProperty
                        ("dataSource.prepStmtCacheSize", "250");
        hikariConfig.
                addDataSourceProperty
                        ("dataSource.prepStmtCacheSqlLimit", "2048");
        hikariConfig.
                addDataSourceProperty
                        ("dataSource.useServerPrepStmts", "true");


        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);

        return hikariDataSource;
    }

    @Bean
    JpaVendorAdapter vendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        vendorAdapter.setDatabase(Database.MYSQL);
        return vendorAdapter;
    }


    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean factoryBean =
                new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaVendorAdapter(vendorAdapter());
        factoryBean.setPackagesToScan("app.model");

        java.util.Properties properties =
                new java.util.Properties();
        properties.put("hibernate.hbm2ddl.auto", "update");
        factoryBean.setJpaProperties(properties);
            return factoryBean;
    }

    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }
}
