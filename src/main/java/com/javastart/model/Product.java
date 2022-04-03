package com.javastart.model;

import com.javastart.constraint.SerialNo;

public class Product {
    private String name;
    private String description;
    @SerialNo(startsWith = "PL", codeLength = 5)
    private String serialNo;

    public Product(String name, String description, String serialNo) {
        this.name = name;
        this.description = description;
        this.serialNo = serialNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }
}
