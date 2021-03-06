package com.alecsandra.databasemanagement.model;

public enum TableDescription {
     TABLE_CAT("TABLE_CAT"),
     TABLE_SCHEM("TABLE_SCHEM"),
     TABLE_NAME("TABLE_NAME"),
     TABLE_TYPE("TABLE_TYPE"),
     REMARKS("REMARKS"),
     TYPE_CAT("TYPE_CAT"),
     TYPE_SCHEM("TYPE_SCHEM"),
     TYPE_NAME("TYPE_NAME"),
     SELF_REFERENCING_COL_NAME("SELF_REFERENCING_COL_NAME"),
     REF_GENERATION("REF_GENERATION");

    private String value;

    TableDescription(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
