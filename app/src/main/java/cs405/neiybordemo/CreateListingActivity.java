package cs405.neiybordemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.tech.freak.wizardpager.*;
import com.tech.freak.wizardpager.model.AbstractWizardModel;
import com.tech.freak.wizardpager.model.ModelCallbacks;
import com.tech.freak.wizardpager.model.Page;
import com.tech.freak.wizardpager.model.ReviewItem;
import com.tech.freak.wizardpager.ui.PageFragmentCallbacks;
import com.tech.freak.wizardpager.ui.ReviewFragment;
import com.tech.freak.wizardpager.ui.StepPagerStrip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;




/**
 * Created by Donny on 3/3/2018.
 */

public class CreateListingActivity extends FragmentActivity implements
        PageFragmentCallbacks,
        ReviewFragment.Callbacks,
        ModelCallbacks{

    private ViewPager mPager;
    private MyPagerAdapter mPagerAdapter;

    private boolean mEditingAfterReview;

    private AbstractWizardModel createListingModel = new ListingWizardModel(this);

    private boolean mConsumePageSelectedEvent;

    private Button mNextButton;
    private Button mPrevButton;

    public List<Page> mCurrentPageSequence;
    private StepPagerStrip mStepPagerStrip;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_listing);

        if (savedInstanceState != null) {
            createListingModel.load(savedInstanceState.getBundle("model"));
        }

        createListingModel.registerListener(this);

        mPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(mPagerAdapter);
        mStepPagerStrip = (StepPagerStrip) findViewById(R.id.strip);
        mStepPagerStrip.setOnPageSelectedListener(new StepPagerStrip.OnPageSelectedListener() {
            @Override
            public void onPageStripSelected(int position) {
                position = Math.min(mPagerAdapter.getCount() - 1, position);
                if (mPager.getCurrentItem() != position) {
                    mPager.setCurrentItem(position);
                }
            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mPrevButton = (Button) findViewById(R.id.prev_button);
        mPrevButton.setTextColor(Color.GRAY);

        mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                mStepPagerStrip.setCurrentPage(position);

                if (mConsumePageSelectedEvent) {
                    mConsumePageSelectedEvent = false;
                    return;
                }

                mEditingAfterReview = false;
                updateBottomBar();
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPager.getCurrentItem() == mCurrentPageSequence.size()) {
                    Listing theListing = new Listing();
                    ArrayList<ReviewItem> reviewItems = new ArrayList<ReviewItem>();
                    for (Page page : mCurrentPageSequence) {
                        page.getReviewItems(reviewItems);
                    }
                    for (ReviewItem item : reviewItems){
                        /*
                        case "" : theListing.(item.getDisplayValue());
                                break;
                         */

                        switch (item.getTitle()){
                            case "Space Name": theListing.setListingName(item.getDisplayValue());
                                break;
                            case "Description" : theListing.setDescription(item.getDisplayValue());
                                break;
                            case "Address" : theListing.setListAddress(item.getDisplayValue());
                                break;
                            case "Listing City" : theListing.setListCity(item.getDisplayValue());
                                break;
                            case "Listing State" : theListing.setListState(item.getDisplayValue());
                                break;
                            case "Listing Zip" : theListing.setListZip(item.getDisplayValue());
                                break;
                            case "Type of space" :
                                switch (item.getDisplayValue()){
                                    case "Basement": theListing.setSpaceType(SpaceType.Basement); break;
                                    case "Bedroom": theListing.setSpaceType(SpaceType.Bedroom); break;
                                    case "Garage": theListing.setSpaceType(SpaceType.Garage); break;
                                    case "RV Pad": theListing.setSpaceType(SpaceType.RV_Pad); break;
                                    case "Other": theListing.setSpaceType(SpaceType.Other); break;
                                    default:break;
                                }
                                break;
                            case "Availability" : switch (item.getDisplayValue()){
                                case "24/7": theListing.setAvailabilityType(AvailabilityType.AnyTime); break;
                                case "Business Hours": theListing.setAvailabilityType(AvailabilityType.BusinessHours); break;
                                case "By Appointment Only": theListing.setAvailabilityType(AvailabilityType.AppointmentOnly); break;
                                default:break;
                            }
                                break;
                            case "Features" :
                                String fullFeatures = item.getDisplayValue();
                                if(fullFeatures.contains("Climate Control")){
                                    theListing.setHasClimateControl(true);
                                }
                                if(fullFeatures.contains("Smoke free")){
                                    theListing.setHasSmokeFree(true);
                                }
                                if(fullFeatures.contains("Smoke detectors")){
                                    theListing.setHasSmokeDetectors(true);
                                }
                                if(fullFeatures.contains("Private entrance")){
                                    theListing.setHasPrivateEntrance(true);
                                }
                                if(fullFeatures.contains("Locked area")){
                                    theListing.setHasLockedArea(true);
                                }
                                if(fullFeatures.contains("Pet free")){
                                    theListing.setHasPetFree(true);
                                }
                                break;
                            //length
                            case "Length" : theListing.setLength(Integer.parseInt(item.getDisplayValue()));
                                break;
                            //width
                            case "Width" : theListing.setWidth(Integer.parseInt(item.getDisplayValue()));
                                break;
                            // size
                            case "Size" : theListing.setSize(item.getDisplayValue());
                                break;
                            //monthly price
                            case "Price" : theListing.setMonthlyPrice(Integer.parseInt(item.getDisplayValue()));
                                break;

                            default:break;
                        }
                    }
                    UserSingleton.Instance().addListing(theListing);
                    beginPhotosActivity();
                    finish();
                }
                else {
                    if (mEditingAfterReview) {
                        mPager.setCurrentItem(mPagerAdapter.getCount() - 1);
                    } else {
                        mPager.setCurrentItem(mPager.getCurrentItem() + 1);
                    }
                }
            }
        });

        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPager.setCurrentItem(mPager.getCurrentItem() - 1);
            }
        });

        onPageTreeChanged();
        updateBottomBar();
    }

    public void beginPhotosActivity() {
        Intent intent = new Intent(this, PhotosActivity.class);
        startActivity(intent);
    }

    @Override
    public void onPageDataChanged(Page page) {
        if (page.isRequired()) {
            if (recalculateCutOffPage()) {
                mPagerAdapter.notifyDataSetChanged();
                updateBottomBar();
            }
        }
    }

    @Override
    public void onPageTreeChanged() {
        mCurrentPageSequence = createListingModel.getCurrentPageSequence();
        recalculateCutOffPage();
        mStepPagerStrip.setPageCount(mCurrentPageSequence.size() + 1); // + 1 = review step
        mPagerAdapter.notifyDataSetChanged();
        updateBottomBar();
    }

    private boolean recalculateCutOffPage() {
        // Cut off the pager adapter at first required page that isn't completed
        int cutOffPage = mCurrentPageSequence.size() + 1;
        for (int i = 0; i < mCurrentPageSequence.size(); i++) {
            Page page = mCurrentPageSequence.get(i);
            if (page.isRequired() && !page.isCompleted()) {
                cutOffPage = i;
                break;
            }
        }

        if (mPagerAdapter.getCutOffPage() != cutOffPage) {
            mPagerAdapter.setCutOffPage(cutOffPage);
            return true;
        }

        return false;
    }

    @Override
    public Page onGetPage(String key) {
        return createListingModel.findByKey(key);
    }

    @Override
    public AbstractWizardModel onGetModel() {
        return createListingModel;
    }

    @Override
    public void onEditScreenAfterReview(String pageKey) {
        for (int i = mCurrentPageSequence.size() - 1; i >= 0; i--) {
            if (mCurrentPageSequence.get(i).getKey().equals(pageKey)) {
                mConsumePageSelectedEvent = true;
                mEditingAfterReview = true;
                mPager.setCurrentItem(i);
                updateBottomBar();
                break;
            }
        }
    }

    private void updateBottomBar() {
        int position = mPager.getCurrentItem();
        if (position == mCurrentPageSequence.size()) {
            mNextButton.setText(R.string.finish_listing);
            mNextButton.setBackgroundColor(Color.argb(255, 0, 125, 255));
            mNextButton.setTextAppearance(this, R.style.TextAppearanceFinish);
        } else {
            mNextButton.setText(mEditingAfterReview
                    ? R.string.review
                    : R.string.next);
            mNextButton.setBackgroundResource(R.drawable.selectable_item_background);
            TypedValue v = new TypedValue();
            getTheme().resolveAttribute(android.R.attr.textAppearanceMedium, v, true);
            mNextButton.setTextAppearance(this, v.resourceId);
            mNextButton.setEnabled(position != mPagerAdapter.getCutOffPage());
        }

        mPrevButton.setVisibility(position <= 0 ? View.INVISIBLE : View.VISIBLE);
    }

    public class MyPagerAdapter extends FragmentStatePagerAdapter {
        private int mCutOffPage;
        private Fragment mPrimaryItem;

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            if (i >= mCurrentPageSequence.size()) {
                return new ReviewFragment();
            }

            return mCurrentPageSequence.get(i).createFragment();
        }

        @Override
        public int getItemPosition(Object object) {
            // TODO: be smarter about this
            if (object == mPrimaryItem) {
                // Re-use the current fragment (its position never changes)
                return POSITION_UNCHANGED;
            }

            return POSITION_NONE;
        }

        @Override
        public void setPrimaryItem(ViewGroup container, int position, Object object) {
            super.setPrimaryItem(container, position, object);
            mPrimaryItem = (Fragment) object;
        }

        @Override
        public int getCount() {
            if (mCurrentPageSequence == null) {
                return 0;
            }
            return Math.min(mCutOffPage + 1, mCurrentPageSequence.size() + 1);
        }

        public void setCutOffPage(int cutOffPage) {
            if (cutOffPage < 0) {
                cutOffPage = Integer.MAX_VALUE;
            }
            mCutOffPage = cutOffPage;
        }

        public int getCutOffPage() {
            return mCutOffPage;
        }
    }

}

