package org.example.hikaricps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.datasource")
@EnableConfigurationProperties({DataSourceConfigProperties.HikariProperties.class})
@PropertySource("classpath:application.properties")
public class DataSourceConfigProperties {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Autowired
    private HikariProperties hikariProperties;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HikariProperties getHikariProperties() {
        return hikariProperties;
    }

    public void setHikariProperties(HikariProperties hikariProperties) {
        this.hikariProperties = hikariProperties;
    }

    @ConfigurationProperties(ignoreUnknownFields = false, prefix="spring.datasource.hikari")
    public static class HikariProperties {
        private String poolName;
        private boolean autoCommit;
        private long connectionTimeout;
        private long idleTimeout;
        private int maximumPoolSize;
        private int minimumIdle;

        public String getPoolName() {
            return poolName;
        }

        public void setPoolName(String poolName) {
            this.poolName = poolName;
        }

        public boolean isAutoCommit() {
            return autoCommit;
        }

        public void setAutoCommit(boolean autoCommit) {
            this.autoCommit = autoCommit;
        }

        public long getConnectionTimeout() {
            return connectionTimeout;
        }

        public void setConnectionTimeout(long connectionTimeout) {
            this.connectionTimeout = connectionTimeout;
        }

        public long getIdleTimeout() {
            return idleTimeout;
        }

        public void setIdleTimeout(long idleTimeout) {
            this.idleTimeout = idleTimeout;
        }

        public int getMaximumPoolSize() {
            return maximumPoolSize;
        }

        public void setMaximumPoolSize(int maximumPoolSize) {
            this.maximumPoolSize = maximumPoolSize;
        }

        public int getMinimumIdle() {
            return minimumIdle;
        }

        public void setMinimumIdle(int minimumIdle) {
            this.minimumIdle = minimumIdle;
        }
    }
}
