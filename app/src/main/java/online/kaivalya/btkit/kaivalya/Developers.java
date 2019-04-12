package online.kaivalya.btkit.kaivalya;

import android.Manifest;
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
import android.widget.Toast;


public class Developers extends Fragment implements View.OnClickListener{

    ImageView imageView,img_s,img_g;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_developers, container, false);

        imageView = (ImageView)view.findViewById(R.id.call_abhi);
        img_g = (ImageView)view.findViewById(R.id.call_g);
        img_s = (ImageView)view.findViewById(R.id.call_s);

        imageView.setOnClickListener(this);
        img_g.setOnClickListener(this);
        img_s.setOnClickListener(this);


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
                    callA();

                } else {
                    Toast.makeText(getActivity(), "Permission denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }



    private void callA() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:8791070321"));
        startActivity(callIntent);
    }
    private void callB() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:9795198870"));
        startActivity(callIntent);
    }
    private void callC() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:8006668210"));
        startActivity(callIntent);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.call_g:
                if(isPermissionGranted()){
                    callB();
                }
            break;
            case R.id.call_abhi:
                if(isPermissionGranted()){
                    callC();
                }
                break;
            case R.id.call_s:
                if(isPermissionGranted()){
                    callA();
                }
                break;

        }

    }
}
