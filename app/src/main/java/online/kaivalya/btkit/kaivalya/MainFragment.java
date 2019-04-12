package online.kaivalya.btkit.kaivalya;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;
import com.plattysoft.leonids.ParticleSystem;

import java.util.Date;

import cn.iwgang.countdownview.CountdownView;


public class MainFragment extends Fragment {
    Toolbar t;
    ActionBarDrawerToggle act;
    DrawerLayout drawerLayout;
    NavigationView nv;
    FragmentTransaction ft;
    private ParticleSystem ps;
    private ParticleSystem ps1;
    private ParticleSystem ps2;

    private VideoView mVideoView;
    private final int SPLASH_DISPLAY_LENGTH = 600;
    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);
//        mVideoView=(VideoView)v.findViewById(R.id.bgvideoView);
//        Uri uri= Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.gg);
//        mVideoView.setVideoURI(uri);
//        mVideoView.start();
//
//        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mediaPlayer) {
//                mediaPlayer.setLooping(true);
//            }
//        });


//        new ParticleSystem(getActivity(), 80, R.drawable.alp, 10000)
//                .setSpeedModuleAndAngleRange(0f, 0.3f, 180, 180)
//                .setRotationSpeed(144)
//                .setAcceleration(0.00005f, 90)
//                .emit(v.findViewById(R.id.emiter_top_right), 8);
//
//        new ParticleSystem(getActivity(), 80, R.drawable.beta, 10000)
//                .setSpeedModuleAndAngleRange(0f, 0.3f, 0, 0)
//                .setRotationSpeed(144)
//                .setAcceleration(0.00005f, 90)
//                .emit(v.findViewById(R.id.emiter_top_left), 8);
        CircleMenu circleMenu = (CircleMenu)v.findViewById(R.id.circle_menu);

        circleMenu.setMainMenu( Color.parseColor("#FF736F6F"), R.drawable.kk,  R.drawable.crs)

                .addSubMenu(Color.parseColor("#30A400"), R.drawable.eve)
                .addSubMenu(Color.parseColor("#01579B"), R.drawable.reg)
                .addSubMenu(Color.parseColor("#8A39FF"),  R.drawable.lap)
                .addSubMenu(Color.parseColor("#FFCA28"), R.drawable.about)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {

                    @Override
                    public void onMenuSelected(int index) {

                        switch (index){
                            case 0:
                                new Handler().postDelayed(new Runnable(){
                                    @Override
                                    public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                                        Intent mainIntent = new Intent(getContext(),EventSaini.class);
                                        startActivity(mainIntent);

                                    }
                                }, SPLASH_DISPLAY_LENGTH);

                             break;
                            case 1:
                                new Handler().postDelayed(new Runnable(){
                                    @Override
                                    public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                                        Intent mainIntent = new Intent(getContext(),Register_saini.class);
                                        startActivity(mainIntent);

                                    }
                                }, SPLASH_DISPLAY_LENGTH);
                                break;
                            case 2:
                                new Handler().postDelayed(new Runnable(){
                                    @Override
                                    public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                                        Intent mainIntent = new Intent(getContext(),Workshops_Saini.class);
                                        startActivity(mainIntent);

                                    }
                                }, SPLASH_DISPLAY_LENGTH);
                                break;
                            case 3:
                                new Handler().postDelayed(new Runnable(){
                                    @Override
                                    public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                                        Intent mainIntent = new Intent(getContext(),AboutKaiv.class);
                                        startActivity(mainIntent);

                                    }
                                }, SPLASH_DISPLAY_LENGTH);
                                 break;


                        }




                    }

                }).setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {

            @Override
            public void onMenuOpened() {}

            @Override
            public void onMenuClosed() {}

        });

        CountdownView mCvCountdownViewTest2 = (CountdownView)v.findViewById(R.id.cv_countdownViewTest2);
        mCvCountdownViewTest2.setTag("test2");
        String dK="04/18/2018 00:00:00";

        Date d=new Date();
        long curr=d.getTime();

        Date d1=new Date(dK);
        long f=d1.getTime();

        f=f-curr;
        long da=f/(24*60*60*1000);

        mCvCountdownViewTest2.start(f);



//    @Override
//    public void onResume() {
//        super.onResume();
//    mVideoView.start();
//    }
return v;

    }
}
