package com.alecsandra.databasemanagement;

import com.alecsandra.databasemanagement.model.Column;
import com.alecsandra.databasemanagement.service.DatabaseManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.util.Map;

@SpringBootApplication
public class DatabaseManagementApplication implements ApplicationRunner {

    @Autowired
    DatabaseManagementService service;

    @Autowired
    DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(DatabaseManagementApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {

        service.getTableTypes();


        service.getCatalogs();
        service.getTables();
        Map<String, Column> map = service.getColumns("user_management", "user");
        String column = "id";
        if (service.hasColumn(map, column)) {
            System.out.println(true);
        }


    }


}
