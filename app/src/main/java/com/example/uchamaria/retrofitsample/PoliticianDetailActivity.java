package com.example.uchamaria.retrofitsample;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

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
    @InjectView(R.id.partyName)
    TextView mPartyName;
    @InjectView(R.id.educationalQualification)
    TextView mEducationalQualification;
    @InjectView(R.id.main_content)
    LinearLayout mainContent;

    PoliticianModel mPoliticianModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_politician_detail);
        ButterKnife.inject(this);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        mPoliticianModel = (PoliticianModel) bundle.get("politicianDetails");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mToolbar.setTitle(mPoliticianModel.getPoliticianName());
        mToolbar.setSubtitleTextColor(Color.WHITE);
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setSubtitle("Area : " + mPoliticianModel.getConstituencyName());


        mPartyName.setText(mPoliticianModel.getPartyName());
        mEducationalQualification.setText(mPoliticianModel.getPoliticianEducation());
//        mAddress.setText(mPoliticianModel.getPoliticianAddress());
//        Currency.getInstance(Locale.getDefault());
//        Currency.getInstance(Currency.getInstance(new Locale("hi", "IN")).getSymbol());
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        Currency currency = Currency.getInstance(new Locale("en", "IN"));
        numberFormat.setCurrency(currency);
        mAssets.setText(numberFormat.format(Integer.parseInt(mPoliticianModel
                .getPoliticianTotalAssets())));
        mLiabilities.setText(numberFormat.format(Integer.parseInt(mPoliticianModel
                .getPoliticianLiabilities
                        ())));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                break;
            case R.id.action_email:
                handleOnClickEmail();
                break;
            case R.id.action_call:
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:9900878571"));
                startActivity(callIntent);
        }
        return true;
    }

    private void handleOnClickEmail() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        if (!TextUtils.isEmpty(mPoliticianModel.getPoliticianEmailId())) {
            intent.putExtra(Intent.EXTRA_EMAIL, mPoliticianModel.getPoliticianEmailId());
            intent.setType("text/html");
            startActivity(Intent.createChooser(intent, "Send mail"));
        } else {
            Toast.makeText(getApplicationContext(), "Sorry no email-id found", Toast.LENGTH_LONG)
                    .show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_politician_detail, menu);
        return true;
    }
}
