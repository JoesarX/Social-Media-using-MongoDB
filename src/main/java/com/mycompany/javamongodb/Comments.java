/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javamongodb;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

/**
 *
 * @author eagui
 */
public class Comments {
    @BsonProperty(value = "_id")
    ObjectId id;
    String postid;
    String email;
    String contenido;

    public Comments() {
    }

    public Comments(String idd,String email, String contenido) {
        this.email = email;
        this.contenido = contenido;
        this.postid = idd;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }
    
    

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Comments{" + "id=" + id + ", postid=" + postid + ", email=" + email + ", contenido=" + contenido + '}';
    }

    
    
}
