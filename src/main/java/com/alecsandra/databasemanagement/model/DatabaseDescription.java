package com.alecsandra.databasemanagement.model;

public enum DatabaseDescription {
    CATALOG("TABLE_CAT"),
    SCHEMA("TABLE_SCHEM"),
    TABLE_TYPE("TABLE_TYPE");

    private String value;

    DatabaseDescription(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
