package cs405.neiybordemo;

import android.graphics.Bitmap;
import android.location.Address;
import android.widget.ImageView;

import java.util.Locale;

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
    private String listAddress;
    private String listCity;
    private String listState;
    private String listZip;
    //photo of storage space
    private Bitmap photo = null;
    private int photoResource;

    //features
    private boolean hasClimateControl = false;
    private boolean hasSmokeFree = false;
    private boolean hasSmokeDetectors = false;
    private boolean hasPrivateEntrance = false;
    private boolean hasLockedArea = false;
    private boolean hasPetFree = false;

    //sizing
    private int length;
    private int width;
    private int monthlyPrice;

    static public Listing createDummyListing() {
        Listing listing = new Listing();
        listing.setListingID("dummy");
        listing.setListingName("Garage Storage");
        listing.setSpaceType(SpaceType.Garage);
        listing.setAvailabilityType(AvailabilityType.AnyTime);
        listing.setDescription("Extra Space in half of garage");
        //listing.setListAddress(new Address(new Locale("en", "US")));
        listing.setHasPrivateEntrance(true);
        listing.setHasPetFree(true);
        listing.setLength(20);
        listing.setWidth(20);
        listing.setMonthlyPrice(120);
        return listing;
    }

    public Listing(){
        photoResource = R.mipmap.ic_launcher_logo;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    public int getPhotoResource() {
        return photoResource;
    }

    public void setPhotoResource(int photoResource) {
        this.photoResource = photoResource;
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
    /*
    public Address getListAddress() {
        return listAddress;
    }

    public void setListAddress(Address listAddress) {
        this.listAddress = listAddress;
    }
    */
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

    public String getListAddress() {
        return listAddress;
    }

    public void setListAddress(String listAddress) {
        this.listAddress = listAddress;
    }

    public String getListCity() {
        return listCity;
    }

    public void setListCity(String listCity) {
        this.listCity = listCity;
    }

    public String getListState() {
        return listState;
    }

    public void setListState(String listState) {
        this.listState = listState;
    }

    public String getListZip() {
        return listZip;
    }

    public void setListZip(String listZip) {
        this.listZip = listZip;
    }
}

