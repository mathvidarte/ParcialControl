package com.example.moverpersonajeparcial.model;

public class Posicion {

    private String msn;
    private String id;
    private String type = "posicion";


    public Posicion (String msn, String id){
        this.msn = msn;
        this.id = id;
    }

    public Posicion (){

    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
