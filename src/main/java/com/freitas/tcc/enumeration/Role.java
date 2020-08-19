package com.freitas.tcc.enumeration;

public enum Role {
    ADMIN(1, "ADMIN"),
    USER(2, "USER");

    private Integer id;
    private String value;

    public Integer getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    Role(int id, String value){
        this.id = id;
        this.value = value;
    }
}
