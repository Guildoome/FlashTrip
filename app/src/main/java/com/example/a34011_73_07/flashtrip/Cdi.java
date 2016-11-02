package com.example.a34011_73_07.flashtrip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 34011-73-07 on 02/11/2016.
 */

public class Cdi extends Activity {
    TextView titre;
    TextView description;
    ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        photo = (ImageView) findViewById(R.id.photo);
        titre = (TextView) findViewById(R.id.textetitre);
        description = (TextView) findViewById(R.id.textedesc);

        titre.setText("Concepteurs développeurs informatique");
        description.setText("Vous trouverez le Qr code sur la porte d'entrée");

        photo.setImageResource(R.mipmap.accueilphoto);
        final ImageView click_retour = (ImageView) findViewById(R.id.click_retour);
        final ImageView click_allez = (ImageView) findViewById(R.id.click_allez);
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
    }
}