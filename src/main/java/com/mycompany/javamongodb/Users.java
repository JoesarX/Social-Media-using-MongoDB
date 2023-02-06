/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javamongodb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

/**
 *
 * @author eagui
 */


   public class Users implements Serializable{
    private static final long serialVersionUID = 1L;
    @BsonProperty(value = "_id")
    ObjectId id;
    String aemail;
    String bnombres;
    String capellidos; 
    String dpassword;
    String ebirthDate;
    String fbio;
    List<String> gfriends = new ArrayList<>();
    List<String> hrequests = new ArrayList<>(); 
    String iadrPropic;
    ArrayList<String> jadrPosts = new ArrayList();
    String kadrBack;
    int config;
     List<ObjectId> lreposts = new ArrayList<>(); 

    public Users(String apellidos, String bio, String birthDate, String email,ArrayList<String> friends, String nombres,String password,ArrayList<String> requests) {
        this.aemail = email;
        this.bnombres = nombres;
        this.capellidos = apellidos;
        this.dpassword = password;
        this.ebirthDate = birthDate;
        this.fbio = bio;
        this.gfriends = friends;
        this.hrequests = requests;
        this.iadrPropic = "";
        this.kadrBack = "";
	this.config = 0;
    }

    public String getFbio() {
        return fbio;
    }

    public void setFbio(String fbio) {
        this.fbio = fbio;
    }
    
    public int getConfig() {
        return config;
    }

    public void setConfig(int config) {
        this.config = config;
    }
    

    public Users() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getAemail() {
        return aemail;
    }

    public void setAemail(String aemail) {
        this.aemail = aemail;
    }

    

    public String getBnombres() {
        return bnombres;
    }

    public void setBnombres(String bnombres) {
        this.bnombres = bnombres;
    }

    public String getCapellidos() {
        return capellidos;
    }

    public void setCapellidos(String capellidos) {
        this.capellidos = capellidos;
    }

    public String getDpassword() {
        return dpassword;
    }

    public void setDpassword(String dpassword) {
        this.dpassword = dpassword;
    }

    public String getEbirthDate() {
        return ebirthDate;
    }

    public void setEbirthDate(String ebirthDate) {
        this.ebirthDate = ebirthDate;
    }

    public List<String> getGfriends() {
        return gfriends;
    }

    public void setGfriends(List<String> gfriends) {
        this.gfriends = gfriends;
    }

    public List<String> getHrequests() {
        return hrequests;
    }

    public void setHrequests(List<String> hrequests) {
        this.hrequests = hrequests;
    }

    public String getIadrPropic() {
        return iadrPropic;
    }

    public void setIadrPropic(String iadrPropic) {
        this.iadrPropic = iadrPropic;
    }

    public ArrayList<String> getJadrPosts() {
        return jadrPosts;
    }

    public void setJadrPosts(ArrayList<String> jadrPosts) {
        this.jadrPosts = jadrPosts;
    }

  
    public String getKadrBack() {
        return kadrBack;
    }

    public void setKadrBack(String kadrBack) {
        this.kadrBack = kadrBack;
    }

    public List<ObjectId> getLreposts() {
        return lreposts;
    }

    public void setLreposts(List<ObjectId> lreposts) {
        this.lreposts = lreposts;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", aemail=" + aemail + ", bnombres=" + bnombres + ", capellidos=" + capellidos + ", dpassword=" + dpassword + ", ebirthDate=" + ebirthDate + ", fbio=" + fbio + ", gfriends=" + gfriends + ", hrequests=" + hrequests + ", iadrPropic=" + iadrPropic + ", jadrPosts=" + jadrPosts + ", kadrBack=" + kadrBack + ", config=" + config + ", lreposts=" + lreposts + '}';
    }
    
    

  

    

}

