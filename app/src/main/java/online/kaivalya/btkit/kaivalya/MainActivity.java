package online.kaivalya.btkit.kaivalya;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
private VideoView mVideoView;
    Toolbar t;
    ActionBarDrawerToggle act;
    DrawerLayout drawerLayout;
    NavigationView nv;
    FragmentTransaction ft;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        t=(Toolbar)findViewById(R.id.toolbar);

        setSupportActionBar(t);
        getSupportActionBar().setTitle("");

       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Status bar :: Transparent
        Window window = this.getWindow();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }


        setSupportActionBar(t);

        drawerLayout=(DrawerLayout)findViewById(R.id.drawerlayout);

        act=new ActionBarDrawerToggle(this,drawerLayout,t,R.string.drawer_open,R.string.drawer_close);

        drawerLayout.addDrawerListener(act);
        ft=getSupportFragmentManager().beginTransaction();
        ft.add(R.id.main_container,new MainFragment());
        ft.commit();

        nv=(NavigationView)findViewById(R.id.navigation_view);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        ft=getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.main_container,new MainFragment());
                        ft.commit();
                        getSupportActionBar().setTitle("");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.events:
                        ft=getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.main_container,new Sponsors());
                        ft.commit();
                        getSupportActionBar().setTitle("Sponsors");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.work:
                        ft=getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.main_container,new ContactUs());
                        ft.commit();
                        getSupportActionBar().setTitle("Contact Us");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.part:
                        ft=getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.main_container,new Developers());
                        ft.commit();
                        getSupportActionBar().setTitle("");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.btk:
                        ft=getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.main_container,new Query());
                        ft.commit();
                        getSupportActionBar().setTitle("Query");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.eee:
                        item.setChecked(false);
                        drawerLayout.closeDrawers();


                        Intent i=new Intent(MainActivity.this,EventSaini.class);
                        startActivity(i);

                        break;
                   

                }
                return false;
            }
        });






    }
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        act.syncState();

        super.onPostCreate(savedInstanceState);
    }


}
