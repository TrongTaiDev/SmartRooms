package dev.trongtai.smartrooms.classes;

/**
 * Created by HK on 27/03/2018.
 */

public class Persion {
    private int id;

    private String name;

    public Persion(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
