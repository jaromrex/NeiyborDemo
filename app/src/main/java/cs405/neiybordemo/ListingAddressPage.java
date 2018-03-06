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
        String str = mData.getString(ADDRESS_DATA_KEY) + "\n" + mData.getString(CITY_DATA_KEY) + ", " +
                        mData.getString(STATE_DATA_KEY) + "  " + mData.getString(ZIP_DATA_KEY);
        dest.add(new ReviewItem("Address", str, getKey(), -1));
    }

    @Override
    public boolean isCompleted() {
        return !TextUtils.isEmpty(mData.getString(ADDRESS_DATA_KEY));
    }
}
