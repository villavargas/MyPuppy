package mx.com.officedepot.mypuppy;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.content.Intent;
import java.util.ArrayList;

import mx.com.officedepot.mypuppy.adapter.PageAdapter;
import mx.com.officedepot.mypuppy.vista.Fragment_recyclerview;
import mx.com.officedepot.mypuppy.vista.fragment_per;

public class MainActivity extends AppCompatActivity {

    Toolbar miActionBar;
    ImageButton ib;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

       /* if (miActionBar != null) {
            setSupportActionBar(miActionBar);
        }*/


       ib = (ImageButton) findViewById(R.id.estrellita);

        ib.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FavoritePet.class);
                startActivity(i);
            }
        });

}


    public ArrayList<Fragment> addFragments(){

        ArrayList<Fragment> fragments = new ArrayList<>();


        fragments.add(new Fragment_recyclerview());
        fragments.add(new fragment_per());

        return fragments;
    }


    private void setUpViewPager(){

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), addFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_panda);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.mAbout:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;

            case R.id.mContact:
                Intent i = new Intent(this, ContactActivity.class);
                startActivity(i);
                break;

        }

        return true;
    }
}
