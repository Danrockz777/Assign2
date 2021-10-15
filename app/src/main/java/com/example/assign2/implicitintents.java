package com.example.assign2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class implicitintents extends AppCompatActivity {

    private EditText mWebsiteEditText;
    private EditText mLocationText;
    public  EditText msharetext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicitintents);
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