package com.example.anttieek.testi;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by anttieek on 7.5.2018.
 */

@Entity
public class Taksi {

    @PrimaryKey
    private int taxiID;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "baseFee")
    private Double baseFee;

    @ColumnInfo(name = "oneOrTwo")
    private Double oneOrTwo;

    @ColumnInfo(name = "threeOrFour")
    private Double threeOrFour;

    @ColumnInfo(name = "fiveOrSix")
    private Double fiveOrSix;

    @ColumnInfo(name = "sixOrMore")
    private Double sixOrMore;

    public int getTaxiID() {
        return taxiID;
    }

    public void setTaxiID(int taxiID) {
        this.taxiID = taxiID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Taksi(Double baseFee, Double oneOrTwo, Double threeOrFour, Double fiveOrSix, Double sixOrMore) {
        this.baseFee = baseFee;
        this.oneOrTwo = oneOrTwo;
        this.threeOrFour = threeOrFour;
        this.fiveOrSix = fiveOrSix;
        this.sixOrMore = sixOrMore;
    }


    public Double getBaseFee() {
        return baseFee;
    }

    public void setBaseFee(Double baseFee) {
        this.baseFee = baseFee;
    }

    public Double getOneOrTwo() {
        return oneOrTwo;
    }

    public void setOneOrTwo(Double oneOrTwo) {
        this.oneOrTwo = oneOrTwo;
    }

    public Double getThreeOrFour() {
        return threeOrFour;
    }

    public void setThreeOrFour(Double threeOrFour) {
        this.threeOrFour = threeOrFour;
    }

    public Double getFiveOrSix() {
        return fiveOrSix;
    }

    public void setFiveOrSix(Double fiveOrSix) {
        this.fiveOrSix = fiveOrSix;
    }

    public Double getSixOrMore() {
        return sixOrMore;
    }

    public void setSixOrMore(Double sixOrMore) {
        this.sixOrMore = sixOrMore;
    }
}
