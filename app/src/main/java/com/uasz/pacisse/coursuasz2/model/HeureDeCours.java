package com.uasz.pacisse.coursuasz2.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Créé par Dr Cissé, le 23/05/2023 à 10:44
 */
public class HeureDeCours implements Serializable {
    private int heure;
    private int minute;

    public HeureDeCours() {
    }

    public HeureDeCours(int heure, int minute) {
        this.heure = heure;
        this.minute = minute;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    @Override
    public String toString() {
        String h, m;
        if (minute == 0)
            m = "00";
        else
            m = String.valueOf(minute);
        if (heure < 10)
            h = "0" + heure;
        else
            h = String.valueOf(heure);
        return h + "H" + m;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HeureDeCours)) return false;
        HeureDeCours that = (HeureDeCours) o;
        return getHeure() == that.getHeure() && getMinute() == that.getMinute();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeure(), getMinute());
    }
}
