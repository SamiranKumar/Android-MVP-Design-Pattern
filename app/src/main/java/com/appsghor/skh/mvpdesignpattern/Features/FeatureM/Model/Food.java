package com.appsghor.skh.mvpdesignpattern.Features.FeatureM.Model;

/**
 * Created by samir on 6/6/2017.
 */

public class Food {

    private int id;
    private String Name;
    private String descriptiom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescriptiom() {
        return descriptiom;
    }

    public void setDescriptiom(String descriptiom) {
        this.descriptiom = descriptiom;
    }
}
