package id.ac.uvers.donoryuk;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class ReqDarahActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private DarahTabAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_req_darah);

        tabLayout = findViewById(R.id.darah_tab);
        viewPager = findViewById(R.id.darah_view_pager);

        tabLayout.addTab(tabLayout.newTab().setText("Bantuan"));
        tabLayout.addTab(tabLayout.newTab().setText("Data Diri"));
        tabLayout.setTabGravity(tabLayout.GRAVITY_FILL);

        adapter = new DarahTabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}