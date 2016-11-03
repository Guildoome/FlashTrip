package com.example.a34011_73_07.flashtrip;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

/**
 * Created by 34011-73-07 on 02/11/2016.
 */

public class Resto extends AppCompatActivity {
    TextView titre;
    TextView description;
    ImageView photo;
    FeatureCoverFlow coverFlow;
    CoverFlowAdapter adapter;
    ArrayList<Game> games;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        coverFlow = (FeatureCoverFlow) findViewById(R.id.coverflow);

        settingDummyData();
        adapter = new CoverFlowAdapter(this, games);
        coverFlow.setAdapter(adapter);
        coverFlow.setOnScrollPositionListener(onScrollListener());
       // photo = (ImageView) findViewById(R.id.photo);
        titre = (TextView) findViewById(R.id.textetitre);
        description = (TextView) findViewById(R.id.textedesc);

        titre.setText("Restaurant");
        description.setText("Vous trouverez le Qr code sur la porte d'entrée");

      //  photo.setImageResource(R.mipmap.restaurant);
        final ImageView click_retour = (ImageView) findViewById(R.id.click_retour);
        final ImageView click_allez = (ImageView) findViewById(R.id.click_allez);
        final ImageView click_telephoner = (ImageView) findViewById(R.id.telephoner);

        click_retour.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                finish();
            }
        });

        click_allez.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent sendIntent = new Intent();

                startActivity(sendIntent);

            }
        });
        click_telephoner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0467690331"));
                int permissionCheck = ContextCompat.checkSelfPermission(Resto.this,
                        Manifest.permission.CALL_PHONE);
                startActivity(intent);
            }
        });
    }
    private FeatureCoverFlow.OnScrollPositionListener onScrollListener() {
        return new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                Log.v("Accueil", "position: " + position);
            }

            @Override
            public void onScrolling() {
                Log.i("Accueil", "scrolling");
            }
        };
    }

    private void settingDummyData() {
        games = new ArrayList<>();
        games.add(new Game(R.drawable.accueil));
        games.add(new Game(R.drawable.resto));
        games.add(new Game(R.drawable.dl));
        games.add(new Game(R.drawable.cdi));

    }
}