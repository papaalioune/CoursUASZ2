package com.uasz.pacisse.coursuasz2.utilitaire;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Créé par Dr Cissé, le 09/05/2023 à 08:57
 */
public class DataConverter {
    public enum DateType {
        SHORT, LONG, SHORT_, LONG_
    }

    public static String toString(Date date, DateType dt) {
        try {
            SimpleDateFormat sdf;
            switch (dt) {
                case SHORT: {
                    sdf = new SimpleDateFormat(Constantes.Regex.SHORT_DATE_FORMAT);
                }
                break;
                case SHORT_: {
                    sdf = new SimpleDateFormat(Constantes.Regex.SHORT_DATE_FORMAT_);
                }
                break;
                case LONG_: {
                    sdf = new SimpleDateFormat(Constantes.Regex.LONG_DATE_FORMAT_);
                }
                break;
                default: {
                    sdf = new SimpleDateFormat(Constantes.Regex.LONG_DATE_FORMAT);
                }
            }
            return sdf.format(date);
        } catch (Exception e) {
            return "";
        }
    }

    public static Date toDate(String value, DateType dt) throws ParseException {
        try {
            SimpleDateFormat sdf;
            switch (dt) {
                case LONG: {
                    sdf = new SimpleDateFormat(Constantes.Regex.LONG_DATE_FORMAT);
                }
                break;
                case LONG_: {
                    sdf = new SimpleDateFormat(Constantes.Regex.LONG_DATE_FORMAT_);
                }
                break;
                case SHORT_: {
                    sdf = new SimpleDateFormat(Constantes.Regex.SHORT_DATE_FORMAT_);
                }
                break;
                default: {
                    sdf = new SimpleDateFormat(Constantes.Regex.SHORT_DATE_FORMAT);
                }
            }
            return sdf.parse(value);
        } catch (ParseException e) {
            return null;
        }

    }
}
