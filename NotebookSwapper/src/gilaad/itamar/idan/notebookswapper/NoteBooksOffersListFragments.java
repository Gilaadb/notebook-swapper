package gilaad.itamar.idan.notebookswapper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class NoteBooksOffersListFragments extends Fragment
{
	private UserData userData;
	private ListView lvNotebooks;

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notebooks, container, false);
        lvNotebooks = (ListView)rootView.findViewById(R.id.lstNotebooks);
        lvNotebooks.setAdapter(new SimpleListViewAdapter(getActivity(),"offersListItem"));
        lvNotebooks.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				IOnOffersItemPickedListner listner = (IOnOffersItemPickedListner)getActivity();
				listner.OnOffersItemPicked(id);
			}
        	
		});
        return rootView;
	}

	public void setUserData(UserData userData) {
		this.userData = userData;
	}
	
}
