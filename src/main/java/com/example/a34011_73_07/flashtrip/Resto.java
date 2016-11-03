package com.example.a34011_73_07.flashtrip;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 34011-73-07 on 02/11/2016.
 */

public class Resto extends Activity {
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

        titre.setText("Restaurant");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            description.setText(Html.fromHtml("",Html.FROM_HTML_MODE_LEGACY));
        } else {

            description.setText(Html.fromHtml("<h2>Horaires</h2>\n" +
                    "<ul>\n" +
                    "<li>12h-14h</li>\n" +
                    "</ul>\n" +
                    "\n" +
                    "Téléphone : 00.00.00.00.00<br/>\n" +
                    "Mail : a@b.com"));
        }

        photo.setImageResource(R.mipmap.restaurant);
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
                Uri gmmIntentUri = Uri.parse("google.navigation:q=43.565716, 3.845629&mode=w");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}