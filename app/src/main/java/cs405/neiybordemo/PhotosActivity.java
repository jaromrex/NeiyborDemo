package cs405.neiybordemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.List;

/**
 * Created by Jarom on 3/5/18.
 */

public class PhotosActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    Bitmap testBitmap = null;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar_photos);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Photo");
        button = (Button) findViewById(R.id.add_photo_button);
        button.setBackgroundColor(Color.argb(255, 0, 125, 255));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });
    }

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
            List<Listing> listings = UserSingleton.Instance().getUserListings();
            listings.get(listings.size()-1).setPhoto(testBitmap);
            //listings.get(listings.size()-1).setPhotoResource(R.drawable.example);
            Intent intent = new Intent(this, CompleteActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
