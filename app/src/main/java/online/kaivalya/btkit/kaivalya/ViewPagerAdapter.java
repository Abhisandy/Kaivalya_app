package online.kaivalya.btkit.kaivalya;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by HP on 26-03-2018.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments=new ArrayList<>();
    ArrayList<String> tabTitles=new ArrayList<>();

    public  ViewPagerAdapter(FragmentManager fm){

        super(fm);

    }


    @Override
    public Fragment getItem(int position) {


        return  fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position);
    }

    public void addFragments(Fragment fr, String s) {
        this.fragments.add(fr);
        this.tabTitles.add(s);
    }
}

