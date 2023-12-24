package com.example.indiasateliteweather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;


import com.example.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MapDisplayActivity extends AppCompatActivity implements RecylerViewInterface{


    ArrayList<DataModel> datamodel = new ArrayList<>();
    int[] imdlogo={R.drawable.imd_logo,R.drawable.imd_logo,R.drawable.imd_logo,R.drawable.imd_logo,R.drawable.imd_logo,R.drawable.imd_logo,R.drawable.imd_logo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapactivity_main);

        ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("India Satellite Map");
            actionBar.setSubtitle("Indian Maps Only");


        BottomNavigationView bottomNavigationView =findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.map);


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.map) {
                    startActivity(new Intent(getApplicationContext(), MapDisplayActivity.class));
                    overridePendingTransition(0, 0);
                }   else if (itemId == R.id.about) {
                    startActivity(new Intent(getApplicationContext(), AboutPageViewerActivity.class));
                    overridePendingTransition(0, 0);
                }

                return false;
            }

        });


        RecyclerView recyclerView=findViewById(R.id.mRecyclerView);
        datamodels();
        MyAdapder adapder=new MyAdapder(this, datamodel,this);
        recyclerView.setAdapter(adapder);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void datamodels(){
        String[] mapnames=getResources().getStringArray(R.array.IMDMap);
        String[] imageUrls ={
                "https://mausam.imd.gov.in/Satellite/3Dasiasec_ir1.jpg",
                "https://mausam.imd.gov.in/Satellite/3Dasiasec_vis.jpg",
                "https://mausam.imd.gov.in/Satellite/3Dasiasec_wv.jpg",
                "https://mausam.imd.gov.in/Satellite/3Dasiasec_ctbt.jpg",
                "https://mausam.imd.gov.in/Satellite/3Dglobe_ir1.jpg",
                "https://mausam.imd.gov.in/Satellite/3Dglobe_vis.jpg",
                "https://mausam.imd.gov.in/Satellite/3Dglobe_wv.jpg",
                "https://mausam.imd.gov.in/Satellite/Converted/IR1.gif",
                "https://mausam.imd.gov.in/Satellite/Converted/VIS.gif",
                "https://mausam.imd.gov.in/Satellite/Converted/WV.gif"
        };

        String[] descriptions = {

                //Asia 1
                "The infrared 1 channel (10.8 µm) belongs to the Infrared window region (10-12µm) of the electromagnetic spectrum. It provides quantitative measurements of temperature of the underlying surface or clouds. The greatest advantage of IR images is it' round the clock (day & night) availability. In black and white IR imagery, white shades i.e. high brightness represents cold areas (higher cloud heights) whereas black shades (low brightness) indicates warm surfaces or low cloud height. Therefore height estimation of different layers of clouds is easier by analyzing IR imagery in comparison to other imagery.\n\n"
                        +"* Reveals surface and cloud temperatures\n" +
                        "* Used for storm intensity and rainfall estimation\n" +
                        "* Used for tracking cloud features in time to estimate atmospheric motion.",
                   //Asia 2

                "The channel (0.65µm) lies in the visible region (0.4µm - 0.7µm) of the electromagnetic spectrum which can be seen with naked eye. Hence this channel is known as the Visible channel. The incoming solar radiation in this channel is reflected by Clouds and Ground. The amount of reflection depends on the type of reflective surface. Visible imagery is very useful for distinguishing clouds, land, and sea/ocean. Different types of clouds reflect in different amounts based on their physical properties like amount and size of raindrops / ice crystals and its density. Cumulonimbus clouds appear brightest. Thick (low / medium) clouds like cumulus, stratus, stratocumulus appear comparatively brighter than the thin (Higher) clouds like cirrus. Sea surface appear darker in this imagery.\n\n"
                        +"Summary\n" +
                        "* Sees scattered and reflected energy\n" +
                        "* Available during Daytime only\n" +
                        "* Sees clouds and earth surface\n" +
                        "* Sensitive to soil, water, and cloud type\n" +
                        "* Sees fog in daytime\n" +
                        "* Used for tracking cloud features in time to estimate atmospheric motion",


                //Asia 3
                "Moisture or water vapour is present in the troposphere at different levels. This Water vapour absorbs and re-radiates electromagnetic radiation in the absorption band 6 -7 µm. This property is used for detecting presence of moisture in the middle and upper levels (600 -300 hPa) of the atmosphere. Dark region or black portion in WV imagery indicates an area of high temperature and the dryness of upper and middle atmosphere and bright region or white portion in WV imagery depicts an area of low temperature and moist upper and middle atmosphere or presence of tall/high cloud. WV image also provides information about the swirling middle tropospheric wind patterns and jet streams.\n\n"
                        +"Summary\n" +
                        "* Sensitive to moisture\n" +
                        "* Shows variations in upper tropospheric moisture\n" +
                        "* Typically senses upper half of troposphere; higher in moist and lower in dry regions\n" +
                        "* Atmospheric wave structures are very apparent; short waves readily seen\n" +
                        "* Tracking features in sequences of water vapour images useful for inferring atmospheric motion (particularly moisture)",

                //Asia 4
                "Brightness Temperature (BT) is the temperature of that body when it is assumed as a perfectly black body (i.e. Emissivity =1). Though Cloud is not a perfectly black body, however for derivation of Cloud Top Brightness Temperature (CTBT), cloud is assumed as a black body. In CTBT contour image, the CTBT contours are plotted over the grey count of thermal infrared (IR-1) band of imager payload. These contours provide the quantitative measurement of CTBT. The value of CTBT corresponds to the vertical growth and intensity of convective clouds. The more negative value of CTBT corresponds to higher vertical growth and intensity.",


                //Global 1
                "The infrared 1 channel (10.8 µm) belongs to the Infrared window region (10-12µm) of the electromagnetic spectrum. It provides quantitative measurements of temperature of the underlying surface or clouds. The greatest advantage of IR images is it' round the clock (day & night) availability. In black and white IR imagery, white shades i.e. high brightness represents cold areas (higher cloud heights) whereas black shades (low brightness) indicates warm surfaces or low cloud height. Therefore height estimation of different layers of clouds is easier by analyzing IR imagery in comparison to other imagery.\n\n "+

                        "* Reveals surface and cloud temperatures  \n\n" +
                        "* Used for storm intensity and rainfall estimation\n\n" +
                        "* Used for tracking cloud features in time to estimate atmospheric motion.",

                //Global 2
                "The channel (0.65µm) lies in the visible region (0.4µm - 0.7µm) of the electromagnetic spectrum which can be seen with naked eye. Hence this channel is known as the Visible channel. The incoming solar radiation in this channel is reflected by Clouds and Ground. The amount of reflection depends on the type of reflective surface. Visible imagery is very useful for distinguishing clouds, land, and sea/ocean. Different types of clouds reflect in different amounts based on their physical properties like amount and size of raindrops / ice crystals and its density. Cumulonimbus clouds appear brightest. Thick (low / medium) clouds like cumulus, stratus, stratocumulus appear comparatively brighter than the thin (Higher) clouds like cirrus. Sea surface appear darker in this imagery.\n\n" +
                        "Summary\n\n" +
                        "* Sees scattered and reflected energy\n\n" +
                        "* Available during Daytime only\n\n" +
                        "* Sees clouds and earth surface\n\n" +
                        "* Sensitive to soil, water, and cloud type\n\n" +
                        "* Sees fog in daytime\n\n" +
                        "* Used for tracking cloud features in time to estimate atmospheric motion",

                //Global 3

                "Moisture or water vapour is present in the troposphere at different levels. This Water vapour absorbs and re-radiates electromagnetic radiation in the absorption band 6 -7 µm. This property is used for detecting presence of moisture in the middle and upper levels (600 -300 hPa) of the atmosphere. Dark region or black portion in WV imagery indicates an area of high temperature and the dryness of upper and middle atmosphere and bright region or white portion in WV imagery depicts an area of low temperature and moist upper and middle atmosphere or presence of tall/high cloud. WV image also provides information about the swirling middle tropospheric wind patterns and jet streams.\n\n" +
                        "Summary\n\n" +
                        "* Sensitive to moisture\n\n" +
                        "* Shows variations in upper tropospheric moisture\n\n" +
                        "* Typically senses upper half of troposphere; higher in moist and lower in dry regions\n\n" +
                        "* Atmospheric wave structures are very apparent; short waves readily seen\n\n" +
                        "* Tracking features in sequences of water vapour images useful for inferring atmospheric motion (particularly moisture)",

                 //Animation 1
                "The infrared 1 channel (10.8 µm) belongs to the Infrared window region (10-12µm) of the electromagnetic spectrum. It provides quantitative measurements of temperature of the underlying surface or clouds. The greatest advantage of IR images is it' round the clock (day & night) availability. In black and white IR imagery, white shades i.e. high brightness represents cold areas (higher cloud heights) whereas black shades (low brightness) indicates warm surfaces or low cloud height. Therefore height estimation of different layers of clouds is easier by analyzing IR imagery in comparison to other imagery.\n\n"+
                        "* Reveals surface and cloud temperatures\n\n" +
                        "* Used for storm intensity and rainfall estimation\n\n" +
                        "* Used for tracking cloud features in time to estimate atmospheric motion." ,

                  //Amimation 2
                "The channel (0.65µm) lies in the visible region (0.4µm - 0.7µm) of the electromagnetic spectrum which can be seen with naked eye. Hence this channel is known as the Visible channel. The incoming solar radiation in this channel is reflected by Clouds and Ground. The amount of reflection depends on the type of reflective surface. Visible imagery is very useful for distinguishing clouds, land, and sea/ocean. Different types of clouds reflect in different amounts based on their physical properties like amount and size of raindrops / ice crystals and its density. Cumulonimbus clouds appear brightest. Thick (low / medium) clouds like cumulus, stratus, stratocumulus appear comparatively brighter than the thin (Higher) clouds like cirrus. Sea surface appear darker in this imagery.\n\n" +
                        "Summary\n\n" +
                        "* Sees scattered and reflected energy\n\n" +
                        "* Available during Daytime only\n\n" +
                        "* Sees clouds and earth surface\n\n" +
                        "* Sensitive to soil, water, and cloud type\n\n" +
                        "* Sees fog in daytime\n\n" +
                        "* Used for tracking cloud features in time to estimate atmospheric motion",

                //Animation 3
                "Moisture or water vapour is present in the troposphere at different levels. This Water vapour absorbs and re-radiates electromagnetic radiation in the absorption band 6 -7 µm. This property is used for detecting presence of moisture in the middle and upper levels (600 -300 hPa) of the atmosphere. Dark region or black portion in WV imagery indicates an area of high temperature and the dryness of upper and middle atmosphere and bright region or white portion in WV imagery depicts an area of low temperature and moist upper and middle atmosphere or presence of tall/high cloud. WV image also provides information about the swirling middle tropospheric wind patterns and jet streams.\n\n" +
                        "Summary\n\n" +
                        "* Sensitive to moisture\n\n" +
                        "* Shows variations in upper tropospheric moisture\n\n" +
                        "* Typically senses upper half of troposphere; higher in moist and lower in dry regions\n\n" +
                        "* Atmospheric wave structures are very apparent; short waves readily seen\n\n" +
                        "* Tracking features in sequences of water vapour images useful for inferring atmospheric motion (particularly moisture)"// New description
        };

        for (int i=0; i< mapnames.length;i++ )
            datamodel.add(new DataModel(imageUrls[i], mapnames[i], descriptions[i]));
    }

    @Override
    public void OnItemClick(int position) {

        Intent intent =new Intent(MapDisplayActivity.this, MapViewerActivity.class);
        intent.putExtra("NAME",datamodel.get(position).getName());
        intent.putExtra("IMAGE",datamodel.get(position).getImageUrl());
        intent.putExtra("DESCRIPTION", datamodel.get(position).getDescription());
        startActivity(intent);

    }
}