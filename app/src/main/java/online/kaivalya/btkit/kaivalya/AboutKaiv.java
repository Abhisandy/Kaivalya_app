package online.kaivalya.btkit.kaivalya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import me.biubiubiu.justifytext.library.JustifyTextView;

public class AboutKaiv extends AppCompatActivity {

    JustifyTextView justifyTextView1,justifyTextView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_kaiv);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        justifyTextView1 = (JustifyTextView)findViewById(R.id.jus1);

        justifyTextView1.setText("Geographically, we are located amidst the hills of North India. To some, we might merely be a valley in Himalayas but we speak Technology. We are the Computing Club of BTKIT Dwarahat, Uttarakhand and we proudly present Kaivalya 2K18, one of its own kind in India. Bipin Tripathi, Kumaun Institute of Technology, Dwarahat is a Technical Institute of Uttarakhand Government that is situated near the hills of District Almora.");

    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
