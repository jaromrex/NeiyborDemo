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


}

