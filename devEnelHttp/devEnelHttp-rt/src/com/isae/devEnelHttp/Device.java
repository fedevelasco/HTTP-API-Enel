package com.isae.devEnelHttp;

import java.util.ArrayList;

public class Device {
    String did;
    ArrayList<Parameter> parameters;

    //Constructor
    public Device(String did){
        this.did = did;
        this.parameters = new ArrayList<Parameter>();
    }

    //Getters
    public String getDid(){
        return this.did;
    }

    public Parameter getParameter(int i){
        return this.parameters.get(i);
    }

    public int getParameterSize(){
        return this.parameters.size();
    }

    //Setters
    public void setDid(String did){
        this.did = did;
    }

    public void addParameter(Parameter p){
        this.parameters.add(p);
    }

    public void removeParameter(int i){
        this.parameters.remove(i);
    }

    public void changeParameter(int i, Parameter p){
        this.parameters.set(i, p);
    }
}
