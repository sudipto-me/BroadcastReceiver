package com.example.android.broadcastreceiver;

/**
 * Created by Android on 7/27/2017.
 */

public class IncomingNumber {

    public int id;
    public String value;

    public IncomingNumber(int id,String value){
        this.setId(id);
        this.setValue(value);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
