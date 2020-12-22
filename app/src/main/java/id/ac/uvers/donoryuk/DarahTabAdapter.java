package id.ac.uvers.donoryuk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class DarahTabAdapter extends FragmentPagerAdapter {

    private final String[] titles = { "Bantuan", "Data Diri" };
    private final Fragment[] fragments = { new recyclerView(), new dataDiri() };

    public DarahTabAdapter(FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getCount() {
        return Math.max(fragments.length, 0);
    }
}

