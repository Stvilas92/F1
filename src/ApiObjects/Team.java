/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApiObjects;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author alejavilas92
 */
public class Team {

    private String id, name, url, nacionality;
    private static final String NAME_CONSTRUCTOR_KEY = "Name";
    private static final String ID_CONSTRUCTOR_KEY = "constructorId";
    private static final String NACIONALITY_CONSTRUCTOR_KEY = "Nationality";
    private static final String URL_CONSTRUCTOR_KEY = "url";

    /**
     *
     * @param object
     * @throws JSONException
     */
    public Team(JSONObject object)throws JSONException {
        id = object.getString(ID_CONSTRUCTOR_KEY);
        name = object.getString(NAME_CONSTRUCTOR_KEY);
        url = object.getString(URL_CONSTRUCTOR_KEY);
        nacionality = object.getString(NACIONALITY_CONSTRUCTOR_KEY);
    }

    /**
     *
     * @param id
     * @param name
     * @param url
     * @param nacionality
     */
    public Team(String id, String name, String url, String nacionality) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.nacionality = nacionality;
    }

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNacionality() {
        return nacionality;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }
    
    

}
