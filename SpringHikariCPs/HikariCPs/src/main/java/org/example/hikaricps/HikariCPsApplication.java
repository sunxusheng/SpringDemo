package org.example.hikaricps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
public class HikariCPsApplication implements CommandLineRunner {

//    @Autowired
//    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(HikariCPsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        try (Connection connection = dataSource.getConnection();
//             Statement statement = connection.createStatement()) {
//            // 创建一个示例表
//            statement.executeUpdate("CREATE TABLE IF NOT EXISTS test_table (id SERIAL PRIMARY KEY, name VARCHAR(255))");
//            // 插入一条数据
//            statement.executeUpdate("INSERT INTO test_table (name) VALUES ('test_name')");
//            // 查询数据
//            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM test_table")) {
//                while (resultSet.next()) {
//                    System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name"));
//                }
//            }
//
//
//        }
        while (true) {
            Thread.sleep(5000);
        }
    }

}
