package com.mongoCrud.mongoCrud.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "memes")
public class Meme {

    @Id
    private String id;
    private String name;

    public Meme(String name){
        this.name = name;
    }

    public Meme(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
