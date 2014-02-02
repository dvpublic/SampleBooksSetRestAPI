package com.example.samplebookssetrestapi.utils;

public class Common {
    /** http://stackoverflow.com/questions/309424/read-convert-an-inputstream-to-a-string */
    public static String convertStreamToString(java.io.InputStream is, String charsetName) {
        java.util.Scanner s = new java.util.Scanner(is, charsetName).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    } 
}
