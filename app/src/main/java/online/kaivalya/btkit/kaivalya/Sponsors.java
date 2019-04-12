package online.kaivalya.btkit.kaivalya;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;


public class Sponsors extends Fragment {

    private CardView Android,Web_development,WorkShop1,WorkShop2;
    private Context mContext;
    private Activity mActivity;
    private PopupWindow mpopupWindow;
    private LinearLayout linearLayout;
    Dialog dialog;
    TextView textView_close,textView_android,textView_web,textView_coming;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_sponsors, container, false);


        return v;
    }


}
