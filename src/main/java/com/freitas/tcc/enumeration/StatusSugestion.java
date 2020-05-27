package com.freitas.tcc.enumeration;

public enum StatusSugestion {
    PENDING(1, "PENDING"),
    IN_PROGESS(2, "IN_PROGRESS"),
    ACCEPT(3, "ACCEPTED"),
    CANCELATE(4, "CANCELATED"),
    COMPLETE(5, "COMPLETE");

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

    StatusSugestion(int id, String value){
        this.id = id;
        this.value = value;
    }
}
