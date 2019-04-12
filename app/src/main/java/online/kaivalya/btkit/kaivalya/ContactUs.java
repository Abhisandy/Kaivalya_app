package online.kaivalya.btkit.kaivalya;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class ContactUs extends Fragment implements View.OnClickListener {
    ImageView imageView1,imageView2;
    public static String FACEBOOK_URL = "https://www.facebook.com/btkitcodingclub";
    public static String FACEBOOK_PAGE_ID = "btkitcodingclub";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_contact_us, container, false);

        TextView tv=(TextView) view.findViewById(R.id.tv22);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, "btkitcodingclub@gmail.com");
                emailIntent.setType("text/plain");
                startActivity(Intent.createChooser(emailIntent, "btkitcodingclub@gmail.com"));
            }
        });



        imageView1 = (ImageView)view.findViewById(R.id.con1);
        imageView2 = (ImageView)view.findViewById(R.id.con2);
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);


       ImageView imageView11 = (ImageView)view.findViewById(R.id.iv11);
        ImageView imageView21 = (ImageView)view.findViewById(R.id.iv22);

        imageView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
                String facebookUrl = getFacebookPageURL(getActivity());
                facebookIntent.setData(Uri.parse(facebookUrl));
                startActivity(facebookIntent);
            }
        });


imageView21.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String url = "https://www.twitter.com/btkitcodingclub";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
});





        return view;
    }



    public  boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(getContext(),android.Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG","Permission is granted");
                return true;
            } else {

                Log.v("TAG","Permission is revoked");
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG","Permission is granted");
            return true;
        }
    }




    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {

            case 1: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getActivity(), "Permission granted", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(getActivity(), "Permission denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }



    private void callconA() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:9756283293"));
        startActivity(callIntent);
    }
    private void callconB() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:9997109184"));
        startActivity(callIntent);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.con1:
                if(isPermissionGranted()){
                    callconA();
                }
                break;
            case R.id.con2:
                if(isPermissionGranted()){
                    callconB();
                }
                break;


        }

    }


    //method to get the right URL to use in the intent
    public String getFacebookPageURL(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            } else { //older versions of fb app
                return "fb://page/" + FACEBOOK_PAGE_ID;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return FACEBOOK_URL; //normal web url
        }
    }
}
