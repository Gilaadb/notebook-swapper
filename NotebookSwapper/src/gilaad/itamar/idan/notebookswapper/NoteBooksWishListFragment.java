package gilaad.itamar.idan.notebookswapper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class NoteBooksWishListFragment extends Fragment {
	
	private UserData userData;
	private ListView lvNotebooks;

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notebooks, container, false);
        lvNotebooks = (ListView)rootView.findViewById(R.id.lstNotebooks);
        lvNotebooks.setAdapter(new SimpleListViewAdapter(getActivity(),"wishListItem"));
        return rootView;
	}

	public void setUserData(UserData userData) {
		this.userData = userData;
	}
	
}
