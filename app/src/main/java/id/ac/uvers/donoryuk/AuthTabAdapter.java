package id.ac.uvers.donoryuk;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class AuthTabAdapter extends FragmentPagerAdapter {

    private final String[] titles = { "Login", "Register" };
    private final Fragment[] fragments = { new LoginTabFragment(), new RegisterTabFragment() };

    public AuthTabAdapter(FragmentManager fm) {
        super(fm);
        Log.d("TAG", "Masuk Sini");
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        Log.d("Test", "position: " + position);
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

