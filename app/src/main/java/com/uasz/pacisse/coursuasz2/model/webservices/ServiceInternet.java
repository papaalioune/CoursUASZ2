package com.uasz.pacisse.coursuasz2.model.webservices;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

/**
 * Créé par Dr Cissé, le 20/05/2023 à 11:00
 */
public class ServiceInternet {
    private InputStream is = null;
    private JSONObject jObj = null ;
    private JSONArray jsonArray = null;

    private String json = "";
    HttpURLConnection urlConnection = null;

    public boolean connexionDisponible(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public RetoursOperationsGEDT requetteHttp(String url, String method, Map<String, String> params) {
        RetoursOperationsGEDT retoursOperationsGEDT = new RetoursOperationsGEDT();
        try {
            Uri.Builder builder = new Uri.Builder();
            URL urlObj;
            String encodedParams = "";
            if (params != null) {
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    builder.appendQueryParameter(entry.getKey(), entry.getValue());
                }
            }
            if (builder.build().getEncodedQuery() != null) {
                encodedParams =  builder.build().getEncodedQuery();

            }
            if ("GET".equals(method)) {
                url = url + "?" + encodedParams;
                urlObj = new URL(url);
                urlConnection = (HttpURLConnection) urlObj.openConnection();
                urlConnection.setRequestMethod(method);
                urlConnection.connect();
                is = urlConnection.getInputStream();
                retoursOperationsGEDT.setValeurRetourOperationsGEDT(urlConnection.getResponseCode());
            } else {
                urlObj = new URL(url);
                urlConnection = (HttpURLConnection) urlObj.openConnection();
                urlConnection.setRequestMethod(method);
                urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                urlConnection.setRequestProperty("Content-Length", String.valueOf(encodedParams.getBytes().length));
                urlConnection.connect();
                urlConnection.getOutputStream().write(encodedParams.getBytes());
                urlConnection.getOutputStream().flush();
                is = urlConnection.getInputStream();
                retoursOperationsGEDT.setValeurRetourOperationsGEDT(urlConnection.getResponseCode());
                System.out.println("urlConnection.getResponseCode() = " + urlConnection.getResponseCode());
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString();
            //jObj = new JSONObject(json);
            jsonArray = new JSONArray(json);
            retoursOperationsGEDT.setDataAsArray(jsonArray);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        } catch (Exception e) {
            Log.e("Exception", "Error parsing data " + e.toString());
        }
        return retoursOperationsGEDT;

    }
}
