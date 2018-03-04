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

    public static final String NAME_DATA_KEY = "name";
    public static final String EMAIL_DATA_KEY = "email";

    public ListingAddressPage(ModelCallbacks callbacks, String title) {
        super(callbacks, title);
    }


    @Override
    public Fragment createFragment() {
        return ListingAddressFragment.create(getKey());
    }

    @Override
    public void getReviewItems(ArrayList<ReviewItem> dest) {

    }

    @Override
    public boolean isCompleted() {
        return !TextUtils.isEmpty(mData.getString(NAME_DATA_KEY));
    }
}
