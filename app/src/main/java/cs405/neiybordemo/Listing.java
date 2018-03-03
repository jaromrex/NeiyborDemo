package cs405.neiybordemo;

import android.location.Address;

/**
 * Created by Donny on 3/2/2018.
 */

public class Listing {

    //probably want some kind of ID for the space
    private String ListingID;
    //name given
    private String ListingName;
    //garage, basement, bedroom, rv pad, or other
    private SpaceType spaceType;
    //availability time
    private AvailabilityType availabilityType;
    //text description
    private String description;
    //address
    private Address listAddress;

    //features
    private boolean hasClimateControl;
    private boolean hasSmokeFree;
    private boolean hasSmokeDetectors;
    private boolean hasPrivateEntrance;
    private boolean hasLockedArea;
    private boolean hasPetFree;

    //sizing
    private int length;
    private int width;
    private int monthlyPrice;

    //photos

    public Listing(){

    }

    public String getListingID() {
        return ListingID;
    }

    public void setListingID(String listingID) {
        ListingID = listingID;
    }

    public String getListingName() {
        return ListingName;
    }

    public void setListingName(String listingName) {
        ListingName = listingName;
    }

    public SpaceType getSpaceType() {
        return spaceType;
    }

    public void setSpaceType(SpaceType spaceType) {
        this.spaceType = spaceType;
    }

    public AvailabilityType getAvailabilityType() {
        return availabilityType;
    }

    public void setAvailabilityType(AvailabilityType availabilityType) {
        this.availabilityType = availabilityType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getListAddress() {
        return listAddress;
    }

    public void setListAddress(Address listAddress) {
        this.listAddress = listAddress;
    }

    public boolean isHasClimateControl() {
        return hasClimateControl;
    }

    public void setHasClimateControl(boolean hasClimateControl) {
        this.hasClimateControl = hasClimateControl;
    }

    public boolean isHasSmokeFree() {
        return hasSmokeFree;
    }

    public void setHasSmokeFree(boolean hasSmokeFree) {
        this.hasSmokeFree = hasSmokeFree;
    }

    public boolean isHasSmokeDetectors() {
        return hasSmokeDetectors;
    }

    public void setHasSmokeDetectors(boolean hasSmokeDetectors) {
        this.hasSmokeDetectors = hasSmokeDetectors;
    }

    public boolean isHasPrivateEntrance() {
        return hasPrivateEntrance;
    }

    public void setHasPrivateEntrance(boolean hasPrivateEntrance) {
        this.hasPrivateEntrance = hasPrivateEntrance;
    }

    public boolean isHasLockedArea() {
        return hasLockedArea;
    }

    public void setHasLockedArea(boolean hasLockedArea) {
        this.hasLockedArea = hasLockedArea;
    }

    public boolean isHasPetFree() {
        return hasPetFree;
    }

    public void setHasPetFree(boolean hasPetFree) {
        this.hasPetFree = hasPetFree;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getMonthlyPrice() {
        return monthlyPrice;
    }

    public void setMonthlyPrice(int monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }
}

