package gilaad.itamar.idan.notebookswapper;

import gilaad.itamar.idan.notebookswapper.dbhandler.AbstractDataManager;
import gilaad.itamar.idan.notebookswapper.dbhandler.LocalDBDataManager;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements TabListener,IOnOffersItemPickedListner {

	private UserData m_userData;
	private Timer m_lTime;

	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        if (null == AbstractDataManager.getManager())
        {
        	AbstractDataManager.setManager(new LocalDBDataManager(this));	
        }
        m_lTime=null;
        m_userData = (UserData)getIntent().getSerializableExtra(UserData.USER_DATA);
        
	    final ActionBar actionBar = getActionBar();
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	
	    Tab tab1 = actionBar.newTab().setText("My Books").setIcon(android.R.drawable.btn_dialog);
	    NoteBooksOffersListFragments offersFragment = new NoteBooksOffersListFragments();
	    offersFragment.setUserData(m_userData);
		tab1.setTabListener(this);
	    actionBar.addTab(tab1);
	    
	    Tab tab2 = actionBar.newTab().setText("Wish List").setIcon(android.R.drawable.alert_dark_frame);
	    NoteBooksWishListFragment wishFragment = new NoteBooksWishListFragment();
	    wishFragment.setUserData(m_userData);
		tab2.setTabListener(this);
	    actionBar.addTab(tab2);
	    
	    ViewPager pageView = (ViewPager)findViewById(R.id.pager);
	    pageView.setAdapter(new SimpleFragmentPagerAdapter(getSupportFragmentManager(),offersFragment,wishFragment));
	    pageView.setOnPageChangeListener(
	            new ViewPager.SimpleOnPageChangeListener() {
	                @Override
	                public void onPageSelected(int position) {
	                    getActionBar().setSelectedNavigationItem(position);
	                }
	            });
	    
	    

	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter{

		private Fragment m_offersFragment;
		private Fragment m_wishFragment;

		public SimpleFragmentPagerAdapter(FragmentManager fm, Fragment offersFragment, Fragment wishFragment) {
			super(fm);
			m_offersFragment = offersFragment;
			m_wishFragment = wishFragment;
		}

		@Override
		public Fragment getItem(int i) {
			switch (i)
			{
				case 0: return m_offersFragment;
				case 1: return m_wishFragment;
				default: return null;
			}
		}

		@Override
		public int getCount() {
			return 2;
		}
    	
    }


	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void OnOffersItemPicked(long id) {
		Intent intent = new Intent(this,OfferActivity.class);
		intent.putExtra(UserData.USER_DATA, m_userData);
		intent.putExtra(OfferActivity.EXTRA_OFFERID, id);
		startActivity(intent);
	}
	
	@Override
	public void onBackPressed() {
		if (null == m_lTime)
		{
			m_lTime = new Timer();
			m_lTime.schedule(new TimerTask() {	
				@Override
				public void run() {
					m_lTime = null;
				}
			}, new Date(Calendar.getInstance().getTimeInMillis() + TimeUnit.SECONDS.toMillis(3)));
			Toast.makeText(this, "Press back again to quit the program", Toast.LENGTH_SHORT).show();			
		}
		else
		{
			m_lTime.cancel();
			finish();
		}
	}
}
