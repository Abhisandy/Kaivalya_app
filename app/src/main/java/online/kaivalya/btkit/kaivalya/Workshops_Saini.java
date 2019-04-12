package online.kaivalya.btkit.kaivalya;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class Workshops_Saini extends AppCompatActivity  implements View.OnClickListener{

    private CardView Android,Web_development;
    private Context mContext;
    private Activity mActivity;
    private PopupWindow mpopupWindow;
    private LinearLayout linearLayout;
    Dialog dialog;
    TextView textView_close,textView_android,textView_web,textView_coming;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saini_workshops);

        //getActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.TabColor)));


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        mContext = getApplicationContext();

        Android = (CardView)findViewById(R.id.android);
        Web_development = (CardView)findViewById(R.id.web_development);



        Android.setOnClickListener(this);
        Web_development.setOnClickListener(this);

        dialog = new Dialog(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.android:
                dialog.setContentView(R.layout.android_workshop);
                textView_close = (TextView)dialog.findViewById(R.id.close_txt_android);
                textView_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;

            case R.id.web_development:
                dialog.setContentView(R.layout.web_development_workshop);
                textView_close = (TextView)dialog.findViewById(R.id.close_txt_web);
                textView_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;


        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
