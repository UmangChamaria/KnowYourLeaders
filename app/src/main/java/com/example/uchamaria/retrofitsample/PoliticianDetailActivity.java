package com.example.uchamaria.retrofitsample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class PoliticianDetailActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "cheese_name";
    @InjectView(R.id.toolbar)
    Toolbar mToolbar;
    @InjectView(R.id.assets)
    TextView mAssets;
    @InjectView(R.id.liabilities)
    TextView mLiabilities;
    @InjectView(R.id.address)
    TextView mAddress;
    @InjectView(R.id.criminal_record)
    LinearLayout mCriminalRecordLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_politician_detail);
        ButterKnife.inject(this);
        Intent intent = getIntent();
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setSupportActionBar(toolbar);
//        mToolbar.setTitle();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                break;
            case R.id.action_email :
                Intent intent=new Intent(Intent.ACTION_SEND);
                String[] recipients={"xyz@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                intent.setType("text/html");
                startActivity(Intent.createChooser(intent, "Send mail"));
                break;
            case R.id.action_call :
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:9900878571"));
                startActivity(callIntent);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_politician_detail, menu);
        return true;
    }
}
