
package com.mycompany.javamongodb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

/**
 *
 * @author eagui
 */
public class Posts {
    @BsonProperty(value = "_id")
    ObjectId id;
    String bemail;
    String epost;
    Date cfecha;
    List<Comments> acomments;
    String furl;
    String dpicName ;

    public Posts(String bemail, String epost, Date cfecha, List<Comments> acomments, String furl, String dpicName) {
        this.bemail = bemail;
        this.epost = epost;
        this.cfecha = cfecha;
        this.acomments = acomments;
        this.furl = furl;
        this.dpicName = dpicName;
    }

    public ObjectId getId() {
        return id;
    }

    public Posts() {
    }
    
    

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getBemail() {
        return bemail;
    }

    public void setBemail(String bemail) {
        this.bemail = bemail;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public Date getCfecha() {
        return cfecha;
    }

    public void setCfecha(Date cfecha) {
        this.cfecha = cfecha;
    }

    public List<Comments> getAcomments() {
        return acomments;
    }

    public void setAcomments(List<Comments> acomments) {
        this.acomments = acomments;
    }

    public String getFurl() {
        return furl;
    }

    public void setFurl(String furl) {
        this.furl = furl;
    }

    public String getDpicName() {
        return dpicName;
    }

    public void setDpicName(String dpicName) {
        this.dpicName = dpicName;
    }

    @Override
    public String toString() {
        return "Posts{" + "id=" + id + ", bemail=" + bemail + ", epost=" + epost + ", cfecha=" + cfecha + ", acomments=" + acomments + ", furl=" + furl + ", dpicName=" + dpicName + '}';
    }

    
    
}
