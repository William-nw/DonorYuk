package id.ac.uvers.donoryuk;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class LoginAdapter extends FragmentPagerAdapter {

    private Context context;
    int totalTabs;

    public LoginAdapter(FragmentManager fm, Context context, int totalTabs){}
    super(fm);
    this.context = context;
    this.totalTabs = totalTabs;
}


    @Override
    public long getItemId(int position) {
        return totalTabs
    }

public Fragment getItem(int positioin){
    switch (positioin){
        case 0:
            LoginTabFragment loginTabFragment = new LoginTabFragment();
            return loginTabFragment;
        case 1:
            RegisterTabFragment registerTabFragment = new RegisterTabFragment();
            return  registerTabFragment;
        default:
            return null;
    }

}

