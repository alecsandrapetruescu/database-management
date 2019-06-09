package com.alecsandra.databasemanagement.model;

import java.sql.Types;

public class Column {
    private String name;
    private String type;
    private String size;
    private String decimalDigits;
    private String isNullable;
    private String isAutoIncrement;

    private Column(Builder builder) {
        this.name = builder.name;
        this.type = builder.type;
        this.size = builder.size;
        this.decimalDigits = builder.decimalDigits;
        this.isNullable = builder.isNullable;
        this.isAutoIncrement = builder.isAutoIncrement;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public String getDecimalDigits() {
        return decimalDigits;
    }

    public String getIsNullable() {
        return isNullable;
    }

    public String getIsAutoIncrement() {
        return isAutoIncrement;
    }

    public static class Builder {
        private String name;
        private String type;
        private String size;
        private String decimalDigits;
        private String isNullable;
        private String isAutoIncrement;

        public Builder(String name, String type) {
            this.name = name;
            this.type = type;
        }

        public Builder withSize(String size) {
            this.size = size;
            return this;
        }

        public Builder withDecimalDigits(String decimalDigits) {
            this.decimalDigits = decimalDigits;
            return this;
        }

        public Builder withIsNullable(String isNullable) {
            this.isNullable = isNullable;
            return this;
        }

        public Builder withIsAutoIncrement(String isAutoIncrement) {
            this.isAutoIncrement = isAutoIncrement;
            return this;
        }

        public Column build() {
            return new Column(this);
        }
    }

    @Override
    public String toString() {
        return "Column{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", decimalDigits='" + decimalDigits + '\'' +
                ", isNullable='" + isNullable + '\'' +
                ", isAutoIncrement='" + isAutoIncrement + '\'' +
                '}';
    }
}
