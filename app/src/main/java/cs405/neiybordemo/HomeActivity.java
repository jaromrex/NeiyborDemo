package cs405.neiybordemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jarom on 3/2/18.
 */

public class HomeActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    Bitmap testBitmap = null;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            testBitmap = (Bitmap) extras.get("data");
            ArrayList<Listing> listings = UserSingleton.Instance().getUserListings();
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
            RecyclerViewAdapter adapter = new RecyclerViewAdapter(listings, getApplication());
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(UserSingleton.Instance().getUserListings(), getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        if(UserSingleton.Instance().getUserListings().size() == 0) {
            showNoSpaces();
        }
        else {
            showSpaces();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        updateSpaceListings();
    }

    public void updateSpaceListings() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        List<Listing> userListings = UserSingleton.Instance().getUserListings();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(UserSingleton.Instance().getUserListings(), getApplication());
        recyclerView.setAdapter(adapter);
    }

    public void showNoSpaces() {
        View recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setVisibility(View.GONE);
        View image = findViewById(R.id.no_spaces_image);
        image.setVisibility(View.VISIBLE);
    }

    public void showSpaces() {
        View image = findViewById(R.id.no_spaces_image);
        image.setVisibility(View.GONE);
        View recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return true;
    }

    public void beginCreateListingActivity() {
        Intent intent = new Intent(this, CreateListingActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_addListing:
                beginCreateListingActivity();

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
