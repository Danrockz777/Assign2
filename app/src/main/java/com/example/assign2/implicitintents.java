package com.example.assign2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.VideoView;

public class implicitintents extends AppCompatActivity {

    private EditText mWebsiteEditText;
    private EditText mLocationText;
    public  EditText msharetext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicitintents);
        //Added video
        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
        String uriPath2 = "android.resource://"+getPackageName()+"/"+R.raw.cafevidfinal;
        Uri uri2 = Uri.parse(uriPath2);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri2);
        videoView.requestFocus();
        videoView.start();
    }

    //Open our website
    public void openWebsite(View view) {
        mWebsiteEditText=findViewById(R.id.website_edittext);
        String url = mWebsiteEditText.getText().toString();
        Uri webpage=Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW,webpage);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
            Log.d("Successful Launched ","Implicit Intent Works !");

        }else{
            Log.d("ImplicitIntents :","Can't handle this");
        }

    }

    //Open Location
    public void openLocation(View view) {
        mLocationText=findViewById(R.id.location_edittext);
        String loc= mLocationText.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
            Log.d("Successful Launched ","Implicit Intent Works !");
        }else{
            Log.d("This sucks :","Can't handle this");
        }

    }
    //Share Text



    public void sharing(View view) {
        msharetext=findViewById(R.id.share_edittext);
        String txt = msharetext.getText().toString();
        String mimeType="text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.setchoosertitle)
                .setText(txt)
                .startChooser();
    }
}