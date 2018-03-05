package cs405.neiybordemo;

import android.support.v4.app.Fragment;

import com.tech.freak.wizardpager.model.ModelCallbacks;
import com.tech.freak.wizardpager.model.Page;
import com.tech.freak.wizardpager.model.ReviewItem;

import java.util.ArrayList;
import android.text.TextUtils;

/**
 * Created by Donny on 3/3/2018.
 */

public class ListingAddressPage extends Page {

    public static final String ADDRESS_DATA_KEY = "address";
    public static final String CITY_DATA_KEY = "city";
    public static final String STATE_DATA_KEY = "state";
    public static final String ZIP_DATA_KEY = "zip";

    public ListingAddressPage(ModelCallbacks callbacks, String title) {
        super(callbacks, title);
    }


    @Override
    public Fragment createFragment() {
        return ListingAddressFragment.create(getKey());
    }

    @Override
    public void getReviewItems(ArrayList<ReviewItem> dest) {
        dest.add(new ReviewItem("Listing Address", mData.getString(ADDRESS_DATA_KEY), getKey(), -1));
        dest.add(new ReviewItem("Listing City", mData.getString(CITY_DATA_KEY), getKey(), -1));
        dest.add(new ReviewItem("Listing State", mData.getString(STATE_DATA_KEY), getKey(), -1));
        dest.add(new ReviewItem("Listing Zip", mData.getString(ZIP_DATA_KEY), getKey(), -1));
    }

    @Override
    public boolean isCompleted() {
        return !TextUtils.isEmpty(mData.getString(ADDRESS_DATA_KEY));
    }
}
