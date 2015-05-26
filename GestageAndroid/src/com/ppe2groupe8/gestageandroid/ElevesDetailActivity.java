package com.ppe2groupe8.gestageandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ElevesDetailActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.liste_eleves_en_stage);
    String pays = getIntent().getExtras().getString("pays");
    TextView tv = (TextView) findViewById(R.id.listViewEleves);
    tv.setText(pays);
  }

}

