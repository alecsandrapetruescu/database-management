package com.alecsandra.databasemanagement.service;

import com.alecsandra.databasemanagement.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Service
public class DatabaseMetaDataService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseMetaDataService.class);

    @Autowired
    private DataSource dataSource;

    private DatabaseMetaData databaseMetaData;

    public DatabaseMetaDataService() {
        //
    }

    @PostConstruct
    private void init() {
        try (Connection connection = dataSource.getConnection()) {
            this.databaseMetaData = connection.getMetaData();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public void getTableTypes() {
        LOGGER.info("Get TableTypes:");
        try (ResultSet resultSet = databaseMetaData.getTableTypes()) {
            while (resultSet.next()) {
                LOGGER.info(resultSet.getString(DatabaseDescription.TABLE_TYPE.getValue()));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public void getCatalogs() {
        LOGGER.info("Get catalogs:");
        try (ResultSet resultSet = databaseMetaData.getCatalogs()) {
            while (resultSet.next()) {
                LOGGER.info("Catalog: {}", resultSet.getString(DatabaseDescription.CATALOG.getValue()));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public void getTables() {
        LOGGER.info("Get tables of type: {}", TableTypes.TABLE.getValue());
        try (ResultSet resultSet = databaseMetaData.getTables(null, null, null, new String[]{TableTypes.TABLE.getValue()})) {

            while (resultSet.next()) {

                LOGGER.info(resultSet.getString(TableDescription.TABLE_NAME.getValue()));

            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public Map<String, Column> getColumns(String catalog, String table) {
        LOGGER.info("Get columns for catalog: {}, table: {}", catalog, table);

        Map<String, Column> columns = new HashMap<>();
        Column column;
        try (ResultSet results = databaseMetaData.getColumns(catalog, null, table, null)) {
            while (results.next()) {

                column = new Column
                        .Builder(results.getString(ColumnDetails.COLUMN_NAME.getValue()), results.getString(ColumnDetails.DATA_TYPE.getValue()))
                        .withSize(results.getString(ColumnDetails.COLUMN_SIZE.getValue()))
                        .withDecimalDigits(results.getString(ColumnDetails.DECIMAL_DIGITS.getValue()))
                        .withIsNullable(results.getString(ColumnDetails.IS_NULLABLE.getValue()))
                        .withIsAutoIncrement(results.getString(ColumnDetails.IS_AUTOINCREMENT.getValue()))
                        .build();
                LOGGER.info(column.toString());
                columns.putIfAbsent(column.getName(), column);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }

        return columns;
    }

    public boolean hasColumn(Map<String, Column> map, String column) {
        return map.containsKey(column);
    }
}
