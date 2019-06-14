package com.alecsandra.databasemanagement;

import com.alecsandra.databasemanagement.model.Column;
import com.alecsandra.databasemanagement.service.DatabaseManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.util.Map;

@SpringBootApplication
public class Application implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseManagementService.class);

    @Autowired
    DatabaseManagementService service;

    @Autowired
    DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {

        service.getTableTypes();


        service.getCatalogs();
        service.getTables();
        String catalog = "user_management";
        String table = "user";
        Map<String, Column> map = service.getColumns(catalog, table);
        String column = "id";
        if (service.hasColumn(map, column)) {
            LOGGER.info("Table {} has column {}", table,  column);
        }


    }


}
