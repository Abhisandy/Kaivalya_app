package online.kaivalya.btkit.kaivalya;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class upcomfrag extends Fragment {
    ViewPager viewPager;
TabLayout tt;
ViewPagerAdapter viewPagerAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_upcomfrag, container, false);
        tt=(TabLayout)v.findViewById(R.id.tablayout);
        viewPager=(ViewPager)v.findViewById(R.id.viewpager);

        viewPagerAdapter=new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        viewPagerAdapter.addFragments(new gAMBIT(),"GAMBIT");
        viewPagerAdapter.addFragments(new Kaiv(),"KAIVDROID");
        viewPagerAdapter.addFragments(new WebMaster(),"WEB MASTER");
        viewPagerAdapter.addFragments(new RuRitchie(),"R U RITCHIE");
        viewPagerAdapter.addFragments(new RainForest(),"RAIN FOREST MINDS");

        viewPager.setAdapter(viewPagerAdapter);
        tt.setupWithViewPager(viewPager);

        return v;
    }
}
