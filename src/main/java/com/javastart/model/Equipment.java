package com.javastart.model;

import com.javastart.constraint.SerialNo;

public class Equipment {
    private String name;
    private String userId;
    @SerialNo(startsWith = "EQ", codeLength = 4)
    private String serialNo;

    public Equipment(String name, String userId, String serialNo) {
        this.name = name;
        this.userId = userId;
        this.serialNo = serialNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }
}
