package com.alecsandra.databasemanagement;

import com.alecsandra.databasemanagement.model.Column;
import com.alecsandra.databasemanagement.service.DatabaseMetaDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class Application implements ApplicationRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Autowired
    DatabaseMetaDataService databaseMetaDataService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        String catalog = "demo";
        String table = "user";
        String column = "id";


        databaseMetaDataService.getTableTypes();


        databaseMetaDataService.getCatalogs();
        databaseMetaDataService.getTables();

        Map<String, Column> map = databaseMetaDataService.getColumns(catalog, table);

        if (databaseMetaDataService.hasColumn(map, column)) {
            LOGGER.info("Table {} has column {}", table, column);
        }
    }
}
