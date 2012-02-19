package com.devcamp.server.service;

import com.devcamp.server.model.PoiData;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.query.Query;
import com.mongodb.Mongo;


import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MongoService {

    private Mongo mongo;
    private Datastore ds ;
    private Morphia morphia;
    //private static final String DB_NAME="mongo-stoxx";
    private static final String DB_NAME="mongo-stoxx";
    private static final String URL_DB="localhost";
    private static final int PORT =27017;
    //private static final int PORT =10000;


    public MongoService(){
//        this.init();
    }

    public void init(){

        try {
            mongo = new Mongo(URL_DB, PORT);
            //mongo.
            //mongo.dropDatabase(DB_NAME);

            morphia = new Morphia().map(com.devcamp.server.model.PoiData.class);
            ds = morphia.createDatastore(mongo, DB_NAME);
            //ds = morphia.createDatastore(mongo,"db", "6ff94ce3-d644-4945-a1a4-1b9b31cb10d4","7fcea415-54c8-42ea-b6b6-33c088839d64".toCharArray());

        } catch (Exception e) {
            throw new RuntimeException("Error Initializing MongoDB .." + e);
        }

    }


    public void savePoisToDb(List<PoiData> list){
        for (PoiData p : list){
            p.setLoc();
            ds.save(p);
        }
    }



    public List<PoiData> getDataFromDBByCategory(String category){
        Query<PoiData> query = ds.createQuery(PoiData.class).field("category").equal(category);
        return query.asList();
    }

    public List<PoiData> getPoisNearBy(PoiData p){
        //List<PoiData> datas = ds.find(PoiData.class).field("");
        return null;
    }

    public List<PoiData> getFromFile(String file){
        List<PoiData> list = new ArrayList<PoiData>();
        URL url = MongoService.class.getResource(file);
        File csvFile = new File(url.getFile());

        BufferedReader buffer;
        try {
            buffer = new BufferedReader(new FileReader(csvFile));
            String line;

            while ((line =buffer.readLine())!=null) {

                String[] splitted = line.split("\\t");
                PoiData poiData= new PoiData();
                poiData.setTitre(splitted[0]);
                poiData.setDescription(splitted[1]);
                poiData.setAddresse(splitted[2]);
                poiData.setLatitude(Double.valueOf(splitted[3]));
                poiData.setLongitude(Double.valueOf(splitted[4]));
                poiData.setCategory(splitted[5]);
                poiData.setLoc();
                list.add(poiData);

            }

        }

        catch (FileNotFoundException e) {

            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();

        }

        return list;

    }


    public List<PoiData> getAllPois(){
        String[] files = new String[]{"/MH-Ile-de-France.txt-fr_utf8_monument_opendata.paris.csv",
                "/Arbres_remarquables_utf8_arbre_opendata.paris_new.csv",
                //"/voies_actuelles.csv"
        };
        List<PoiData> list = new ArrayList<PoiData>();

        for (String file : files){
            list.addAll(getFromFile(file));

        }


        return list;
    }

    //TODO Erase it
    public  List<PoiData> getPoisFromFiles(){

        List<PoiData> list = new ArrayList<PoiData>();
        URL url = MongoService.class.getResource("/MH-Ile-de-France.txt-fr_utf8_monument_opendata.paris.csv");
        File csvFile = new File(url.getFile());

        BufferedReader buffer;
        try {
            buffer = new BufferedReader(new FileReader(csvFile));
            String line;

            while ((line =buffer.readLine())!=null) {

                String[] splitted = line.split("\\t");
                PoiData poiData= new PoiData();
                poiData.setTitre(splitted[0]);
                poiData.setDescription(splitted[1]);
                poiData.setAddresse(splitted[2]);
                poiData.setLatitude(Double.valueOf(splitted[3]));
                poiData.setLongitude(Double.valueOf(splitted[4]));
                poiData.setCategory(splitted[5]);
                poiData.setLoc();
                list.add(poiData);

            }

        }

        catch (FileNotFoundException e) {

            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();

        }

        return list;
    }





    public String initMongoCloud(){
        this.init();
        List<PoiData> list = this.getAllPois();
        for (PoiData data : list){
            System.out.println(data);
        }

        this.savePoisToDb(list);



        return "Done";
    }



    public Datastore getDs() {
        return ds;
    }

    public void setDs(Datastore ds) {
        this.ds = ds;
    }

    public Mongo getMongo() {
        return mongo;
    }

    public void setMongo(Mongo mongo) {
        this.mongo = mongo;
    }

    public Morphia getMorphia() {
        return morphia;
    }


    public void setMorphia(Morphia morphia) {
        this.morphia = morphia;
    }

    public static void main(String[] args){
        MongoService mongoService = new MongoService();
        mongoService.init();
        List<PoiData> list = mongoService.getAllPois();
        for (PoiData data : list){
            System.out.println(data);
        }

        mongoService.savePoisToDb(list);
    }



}
