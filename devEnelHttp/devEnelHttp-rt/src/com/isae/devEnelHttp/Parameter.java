package com.isae.devEnelHttp;

public class Parameter {
    String p;
    String v;

    //Contructor

    public Parameter(String p, String v) {
        this.p = p;
        this.v = v;
    }

    //Getters
    public String getP() {
        return this.p;
    }

    public String getV() {
        return this.v;
    }

    //Setters
    public void setP(String p){
        this.p =p;
    }

    public void setV(String v){
        this.v =v;
    }
}
