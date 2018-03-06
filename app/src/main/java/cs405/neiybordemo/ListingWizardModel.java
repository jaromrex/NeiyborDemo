package cs405.neiybordemo;

import android.content.Context;

import com.tech.freak.wizardpager.model.AbstractWizardModel;
import com.tech.freak.wizardpager.model.MultipleFixedChoicePage;
import com.tech.freak.wizardpager.model.PageList;
import com.tech.freak.wizardpager.model.SingleFixedChoicePage;

/**
 * Created by Donny on 3/3/2018.
 */

public class ListingWizardModel extends AbstractWizardModel {

    public ListingWizardModel(Context context) {
        super(context);
    }

    @Override
    protected PageList onNewRootPageList() {
        return new PageList(
                new ListingDescriptionPage(this, "Description")
                    .setRequired(true),

                new ListingAddressPage(this, "Address")
                    .setRequired(true),

                new SingleFixedChoicePage(this, "Type of space")
                    .setChoices("Basement", "Bedroom", "Garage", "RV Pad", "Other")
                    .setRequired(true),

                new SingleFixedChoicePage(this, "Availability")
                    .setChoices("24/7", "Business Hours", "By Appointment Only")
                    .setRequired(true),

                new MultipleFixedChoicePage(this, "Features")
                    .setChoices("Climate Control", "Smoke free", "Smoke detectors", "Private entrance", "Locked area", "Pet free")
                    .setRequired(false),

                new ListingPricingPage(this, "Pricing")
                    .setRequired(true)
        );
    }
}



//