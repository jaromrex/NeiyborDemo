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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jarom on 3/2/18.
 */

public class HomeActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    View mImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("My Spaces");
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(UserSingleton.Instance().getUserListings(), getApplication());
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mImageView = findViewById(R.id.no_spaces_image);
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
        if(UserSingleton.Instance().getUserListings().size() > 0) {
            showSpaces();
            updateSpaceListings();
        }
    }

    public void updateSpaceListings() {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(UserSingleton.Instance().getUserListings(), getApplication());
        mRecyclerView.setAdapter(adapter);
    }

    public void showNoSpaces() {
        mRecyclerView.setVisibility(View.GONE);
        mImageView.setVisibility(View.VISIBLE);
    }

    public void showSpaces() {
        mImageView.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
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
