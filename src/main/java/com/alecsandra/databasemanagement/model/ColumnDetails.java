package com.alecsandra.databasemanagement.model;

public enum ColumnDetails {
    COLUMN_NAME("COLUMN_NAME"),
    DATA_TYPE("DATA_TYPE"),
    COLUMN_SIZE("COLUMN_SIZE"),
    DECIMAL_DIGITS("DECIMAL_DIGITS"),
    IS_NULLABLE("IS_NULLABLE"),
    IS_AUTOINCREMENT("DATA_TYPE");


    private String value;

    ColumnDetails(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
