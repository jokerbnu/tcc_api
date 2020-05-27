package com.freitas.tcc.enumeration;

public enum StatusRange {
    NEAR(1, "NEAR"),
    MEDIUM(2, "MEDIUM"),
    FAR(3, "FAR");

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

    StatusRange(int id, String value){
        this.id = id;
        this.value = value;
    }
}
