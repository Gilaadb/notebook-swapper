package gilaad.itamar.idan.notebookswapper;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity {

	/*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		UserData userData = (UserData)getIntent().getSerializableExtra(UserData.USER_DATA);
        if (savedInstanceState == null) {
        	NoteBooksFragment noteBooksFragment= new NoteBooksFragment();
        	noteBooksFragment.setUserData(userData);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, noteBooksFragment)
                    .commit();
        }
    }*/


	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserData userData = (UserData)getIntent().getSerializableExtra(UserData.USER_DATA);
        
	    final ActionBar actionBar = getActionBar();
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	
	    Tab tab1 = actionBar.newTab().setText("My Books").setIcon(android.R.drawable.btn_dialog);
	    NoteBooksOffersListFragments offersFragment = new NoteBooksOffersListFragments();
	    offersFragment.setUserData(userData);
		tab1.setTabListener(new MyTabListner(offersFragment));
	    actionBar.addTab(tab1);
	    
	    Tab tab2 = actionBar.newTab().setText("Wish List").setIcon(android.R.drawable.alert_dark_frame);
	    NoteBooksWishListFragment wishFragment = new NoteBooksWishListFragment();
	    wishFragment.setUserData(userData);
		tab2.setTabListener(new MyTabListner(wishFragment));
	    actionBar.addTab(tab2);

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



}
