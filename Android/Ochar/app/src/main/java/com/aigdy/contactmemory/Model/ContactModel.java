package com.aigdy.contactmemory.Model;

/**
 * Created by aigdy on 9/12/2016 AD.
 */
public class  ContactModel {
    private String name;
    private String tel;

    public ContactModel(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
