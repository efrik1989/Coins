package com.example.k.coins.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Coin {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int year;
    private int coinValue;
    private String photoUrl;
    private String category;
    private String country;
    private String state;
    private String coinEmitterTown;
    private double price;
    private String coinQuality;
    private int coinQuantityInChest;
    private int coinCode;
    private String coinEmittingPeriod;
    private String coinTypeEmitting;
    private String coinMaterial;
    private String coinGurtDescription;
    private String avesReverseRelation;
    private String avesDescription;
    private String reverseDescription;
    private String coinForm;
    private String coinWeight;
    private double diameter;
    private double thickness;
    private String coinDesignAuthor;
    private int circulation;
    private String currencyName;


    public Coin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCoinValue() {
        return coinValue;
    }

    public void setCoinValue(int coinValue) {
        this.coinValue = coinValue;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCoinEmitterTown() {
        return coinEmitterTown;
    }

    public void setCoinEmitterTown(String coinEmitterTown) {
        this.coinEmitterTown = coinEmitterTown;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCoinQuality() {
        return coinQuality;
    }

    public void setCoinQuality(String coinQuality) {
        this.coinQuality = coinQuality;
    }

    public int getCoinQuantityInChest() {
        return coinQuantityInChest;
    }

    public void setCoinQuantityInChest(int coinQuantityInChest) {
        this.coinQuantityInChest = coinQuantityInChest;
    }

    public int getCoinCode() {
        return coinCode;
    }

    public void setCoinCode(int coinCode) {
        this.coinCode = coinCode;
    }

    public String getCoinEmittingPeriod() {
        return coinEmittingPeriod;
    }

    public void setCoinEmittingPeriod(String coinEmittingPeriod) {
        this.coinEmittingPeriod = coinEmittingPeriod;
    }

    public String getCoinTypeEmitting() {
        return coinTypeEmitting;
    }

    public void setCoinTypeEmitting(String coinTypeEmitting) {
        this.coinTypeEmitting = coinTypeEmitting;
    }

    public String getCoinMaterial() {
        return coinMaterial;
    }

    public void setCoinMaterial(String coinMaterial) {
        this.coinMaterial = coinMaterial;
    }

    public String getCoinGurtDescription() {
        return coinGurtDescription;
    }

    public void setCoinGurtDescription(String coinGurtDescription) {
        this.coinGurtDescription = coinGurtDescription;
    }

    public String getAvesReverseRelation() {
        return avesReverseRelation;
    }

    public void setAvesReverseRelation(String avesReverseRelation) {
        this.avesReverseRelation = avesReverseRelation;
    }

    public String getAvesDescription() {
        return avesDescription;
    }

    public void setAvesDescription(String avesDescription) {
        this.avesDescription = avesDescription;
    }

    public String getReverseDescription() {
        return reverseDescription;
    }

    public void setReverseDescription(String reverseDescription) {
        this.reverseDescription = reverseDescription;
    }

    public String getCoinForm() {
        return coinForm;
    }

    public void setCoinForm(String coinForm) {
        this.coinForm = coinForm;
    }

    public String getCoinWeight() {
        return coinWeight;
    }

    public void setCoinWeight(String coinWeight) {
        this.coinWeight = coinWeight;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public String getCoinDesignAuthor() {
        return coinDesignAuthor;
    }

    public void setCoinDesignAuthor(String coinDesignAuthor) {
        this.coinDesignAuthor = coinDesignAuthor;
    }

    public int getCirculation() {
        return circulation;
    }

    public void setCirculation(int circulation) {
        this.circulation = circulation;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }
}
