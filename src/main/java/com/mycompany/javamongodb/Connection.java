/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javamongodb;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import javax.swing.JOptionPane;
//import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import java.util.List;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.bson.conversions.Bson;

/**
 *
 * @author HP
 */
public class Connection {

    public MongoClient createConnection() {
        MongoClient mongo = null;
        String server = "localhost";
        int port = 27017;
        try {
            //mongo = new MongoClient(server,port);
            mongo = MongoClients.create();
            //List<String> nombresBasesDeDatos = mongo.getDatabase("dbMongo");
            MongoDatabase database = mongo.getDatabase("Mini_RS");
            // MongoCollection<Document> toys = database.getCollection(“toys”);
            MongoCollection<Document> Customer = database.getCollection("Users");
          //  Bson filter = Filters.gt("city", "Berlin");
           // System.out.println(Customer.find(filter));

            System.out.println(database.getName());

            System.out.println("aja");

            //JOptionPane.showMessageDialog(null, "La coneccion fue existosa." + Customer.toString());
        } catch (MongoException e) {
            JOptionPane.showMessageDialog(null, "Error en la conneccion a MongoDB, error: " + e.toString());
        }
        return mongo;
    }

}
