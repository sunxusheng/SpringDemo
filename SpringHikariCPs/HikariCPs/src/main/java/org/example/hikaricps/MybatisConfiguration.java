package org.example.hikaricps;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@MapperScan(basePackages = {"org.example.hikaricps.**.mapper"})
@PropertySource("classpath:application.properties")
public class MybatisConfiguration {

    /**
     * This is a Constant definition for TRANSACTION_TIMEOUT.
     */
    public static final int TRANSACTION_TIMEOUT = 30;

    @Bean
    ConfigurationCustomizer mybatisConfigurationCustomizer() {
        return configuration -> {
            configuration.setLazyLoadingEnabled(true);
            configuration.setAggressiveLazyLoading(false);
        };
    }

    /**
     * Spring container will initialize a bean whose name is dataSource.
     *
     * @return a DataSource instance
     */
    @Bean
    public DataSource dataSource(DataSourceConfigProperties properties) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(properties.getDriverClassName());
        hikariConfig.setJdbcUrl(properties.getUrl());
        hikariConfig.setUsername(properties.getUsername());
        hikariConfig.setPassword(properties.getPassword());
        //hikariConfig.setPoolName(properties.getHikariProperties().getPoolName());
        hikariConfig.setAutoCommit(properties.getHikariProperties().isAutoCommit());
        hikariConfig.setConnectionTimeout(properties.getHikariProperties().getConnectionTimeout());
        hikariConfig.setIdleTimeout(properties.getHikariProperties().getIdleTimeout());
        hikariConfig.setMaximumPoolSize(properties.getHikariProperties().getMaximumPoolSize());
        hikariConfig.setMinimumIdle(properties.getHikariProperties().getMinimumIdle());
        hikariConfig.setRegisterMbeans(false);
//        hikariConfig.addDataSourceProperty(PGProperty.SSL_MODE.getName(), SslMode.VERIFY_FULL.value);
//        hikariConfig.addDataSourceProperty(PGProperty.SSL_ROOT_CERT.getName(), System.getenv("DB_SSL_ROOT_CERT"));

        return new HikariDataSource(hikariConfig);
    }
}
