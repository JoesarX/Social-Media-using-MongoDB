/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
//
package com.mycompany.javamongodb;

/*import com.mongodb.DB;
import com.mongodb.MongoException;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;*/
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import com.mongodb.client.MongoClient;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;
import static com.mongodb.client.model.Updates.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.bson.conversions.Bson;

public class JavaMongoDb {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        //    Connection CC = new Connection();
        //  CC.createConnection();
        //  MongoDatabase database = CC.getDatabase("my_database");
        MongoClient client = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = client.getDatabase("Mini_RS");
        MongoCollection<Document> users = database.getCollection("Users");
        // System.out.println(database.getName());

        /*   Document toy = new Document("User", "burgosf") .append("ages", new Document("min", 5)); 
        ObjectId id = users.insertOne(toy).getInsertedId().asObjectId().getValue();
        Document yoyo = users.find(new Document("name", "yoyo")).first(); System.out.println(yoyo.toJson());*/
        System.out.println(client.listDatabaseNames());
        //   client.
        //System.out.println("hello");
        MongoDatabase db = client.getDatabase("Mini_RS");
        MongoCollection<Document> coll = db.getCollection("Users");

        //create
        /*   try {
            InsertOneResult result = coll.insertOne(new Document()
                    .append("_id", new ObjectId())
                    .append("User", "adrianburgosf")
                    .append("Password", "12345"));
            System.out.println("Success! Inserted document id: " + result.getInsertedId());
        } catch (MongoException me) {
            System.err.println("Unable to insert due to an error: " + me);
        }
        //read
        FindIterable<Document> iterDoc = coll.find();
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        //update
        Document query = new Document().append("User", "adrianburgosf");
        Bson updates = Updates.combine(
                Updates.set("Password", "321"));
        //Updates.addToSet("genres", "Sports"),
        //    Updates.currentTimestamp("lastUpdated"));
        UpdateOptions options = new UpdateOptions().upsert(true);
        try {
            UpdateResult result = coll.updateOne(query, updates, options);
            System.out.println("Modified document count: " + result.getModifiedCount());
            System.out.println("Upserted id: " + result.getUpsertedId()); // only contains a value when an upsert is performed
        } catch (MongoException me) {
            System.err.println("Unable to update due to an error: " + me);
        }
        //delete
        Bson query2 = eq("User", "adrianburgosf");
        try {
            DeleteResult result = coll.deleteOne(query2);
            System.out.println("Deleted document count: " + result.getDeletedCount());
        } catch (MongoException me) {
            System.err.println("Unable to delete due to an error: " + me);
        }*/
        Bson projectionFields = Projections.fields(
                Projections.include("email", "Nombres","Apellidos","BirthDate"),
                Projections.excludeId());
        Document doc = coll.find(eq("Nombres", "Adrian Alexis"))
                .projection(projectionFields)
               
                .first();
        if (doc == null) {
            System.out.println("No results found.");
        } else {
            System.out.println(doc.toJson());
        }

    }
}
