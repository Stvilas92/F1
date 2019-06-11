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
public class Driver {

    public static final String DATE_BIRTH = "DateOfBirth";
    public static final String PERMANET_NUMBER = "PermanentNumber";
    public static final String CODE = "code";
    public static final String DRIVER_ID = "driverId";
    public static final String FAMILY_NAME = "FamilyName";
    public static final String GIVEN_NAME = "GivenName";
    public static final String URL = "url";
    public static final String NACIONALITY = "Nationality";

    private String dateOfBirth, code, driverID, familyName, givenName, url, nacionality;
    private int permanentNumber;

    public Driver(JSONObject object) throws JSONException{
        dateOfBirth = object.getString(DATE_BIRTH);
        code = object.getString(CODE);
        driverID = object.getString(DRIVER_ID);
        familyName = object.getString(FAMILY_NAME);
        givenName = object.getString(GIVEN_NAME);
        url = object.getString(URL);
        nacionality = object.getString(NACIONALITY);
        permanentNumber = object.getInt(PERMANET_NUMBER);
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
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

    public int getPermanentNumber() {
        return permanentNumber;
    }

    public void setPermanentNumber(int permanentNumber) {
        this.permanentNumber = permanentNumber;
    }
    
}
