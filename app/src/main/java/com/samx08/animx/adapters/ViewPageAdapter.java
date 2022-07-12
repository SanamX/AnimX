package com.samx08.animx.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.samx08.animx.fragments.Anime;
import com.samx08.animx.fragments.Manga;
import com.samx08.animx.fragments.WatchList;


public class ViewPageAdapter extends FragmentPagerAdapter {
    private int numoftabs;
    public ViewPageAdapter(@NonNull FragmentManager fm,int numOfTabs) {
        super(fm);
        this.numoftabs=numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                return new Anime();
            case 1:
                return new Manga();
            case 2:
                 return new WatchList();
            default:
                 return null;
    }

}

    @Override
    public int getCount() {
        return numoftabs;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
