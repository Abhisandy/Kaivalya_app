package online.kaivalya.btkit.kaivalya;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class Query extends Fragment {
   WebView webView;
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_query, container, false);

        webView = (WebView)v.findViewById(R.id.web_);
        progressBar = (ProgressBar)v.findViewById(R.id.progressBar);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSejS8KpDgqq6xKYcC9bNVL-YH7IO6LlgokEF4xLgFlMd6bylA/viewform?usp=sf_link");
        webView.setHorizontalScrollBarEnabled(false);



        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
                progressBar.setVisibility(View.INVISIBLE);
            }

        });


        return v;
    }



}
