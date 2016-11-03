package com.example.a34011_73_07.flashtrip;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
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
                int permissionCheck = ContextCompat.checkSelfPermission(Cdi.this,
                        Manifest.permission.CALL_PHONE);
                startActivity(intent);
            }
        });
    }
}