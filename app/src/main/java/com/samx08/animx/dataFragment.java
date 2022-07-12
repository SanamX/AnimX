package com.samx08.animx;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.samx08.animx.adapters.ViewPageAdapter;

public class dataFragment extends Fragment {

    TabLayout tabLayout;
    TabItem tab1,tab2,tab3;
    ViewPager viewPager;
    ViewPageAdapter viewPageAdapter;

    View view;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.activity_home,container,false);

        tabLayout=view.findViewById(R.id.tablayout);
        viewPager=view.findViewById(R.id.viewpager);

        tab1=view.findViewById(R.id.item1);
        tab2=view.findViewById(R.id.item2);
        tab3=view.findViewById(R.id.item3);

        viewPageAdapter = new ViewPageAdapter(getFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(viewPageAdapter);


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0)
                {
                    viewPageAdapter.notifyDataSetChanged();
                }
                else if(tab.getPosition()==1)
                {
                    viewPageAdapter.notifyDataSetChanged();
                }
                else if(tab.getPosition()==2)
                {
                    viewPageAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        return view;
    }
}
