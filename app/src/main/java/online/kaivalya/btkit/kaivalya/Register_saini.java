package online.kaivalya.btkit.kaivalya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class Register_saini extends AppCompatActivity {

    WebView webView;
    ProgressBar progressBar_registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_saini);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar11);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(0xFFFFFFFF);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
getSupportActionBar().setTitle("Registration");




        webView = (WebView)findViewById(R.id.web_view_saini);
        progressBar_registration = (ProgressBar)findViewById(R.id.progress_registration);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://kaivalya.online/registration/");
        webView.setHorizontalScrollBarEnabled(false);

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
                progressBar_registration.setVisibility(View.INVISIBLE);
            }

        });


    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
