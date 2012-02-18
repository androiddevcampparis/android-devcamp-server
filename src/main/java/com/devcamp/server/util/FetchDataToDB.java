package com.devcamp.server.util;

/**
 * Created by IntelliJ IDEA.
 * User: sam
 * Date: 2/18/12
 * Time: 1:49 AM

 */

import com.devcamp.server.model.Monument;

import java.util.List;

/**
 * Fetch Data to the Database
 */

public final class FetchDataToDB {
    final String ARBRES_RESOURCE_URL=" ";


    /**
     * Parse le fichier des monuments et suvagarde chaque objet dans la base.
     */
    public static void storeMonuments(){
        List<Monument> monuments = new ProcessMonumentFile().parseTextFile();

        for (Monument monument : monuments){

            //store monument into db

        }



    }





}
