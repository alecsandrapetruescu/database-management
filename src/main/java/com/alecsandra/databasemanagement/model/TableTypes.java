package com.alecsandra.databasemanagement.model;

public enum TableTypes {
    TABLE("TABLE"),
    VIEW("VIEW"),
    SYSTEM_TABLE("SYSTEM TABLE"),
    GLOBAL_TEMPORARY("GLOBAL TEMPORARY"),
    LOCAL_TEMPORARY("LOCAL TEMPORARY"),
    ALIAS("ALIAS"),
    SYNONYM("SYNONYM");

    private String value;

    TableTypes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
