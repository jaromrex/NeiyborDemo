package cs405.neiybordemo;

import android.support.v4.app.Fragment;
import android.text.TextUtils;

import com.tech.freak.wizardpager.model.ModelCallbacks;
import com.tech.freak.wizardpager.model.Page;
import com.tech.freak.wizardpager.model.ReviewItem;

import java.util.ArrayList;

/**
 * Created by Donny on 3/5/2018.
 */

public class ListingPricingPage extends Page {

    public static final String LENGTH_DATA_KEY = "length";
    public static final String WIDTH_DATA_KEY = "width";
    public static final String PRICE_DATA_KEY = "price";

    public ListingPricingPage(ModelCallbacks callbacks, String title) {
        super(callbacks, title);
    }

    @Override
    public Fragment createFragment() {
        return ListingPricingFragment.create(getKey());
    }

    @Override
    public void getReviewItems(ArrayList<ReviewItem> dest) {
        dest.add(new ReviewItem("Space Length", mData.getString(LENGTH_DATA_KEY), getKey(), -1));
        dest.add(new ReviewItem("Space Width", mData.getString(WIDTH_DATA_KEY), getKey(), -1));
        dest.add(new ReviewItem("Space Price", mData.getString(PRICE_DATA_KEY), getKey(), -1));
    }

    @Override
    public boolean isCompleted() {
        return !TextUtils.isEmpty(mData.getString(LENGTH_DATA_KEY));
    }

}
