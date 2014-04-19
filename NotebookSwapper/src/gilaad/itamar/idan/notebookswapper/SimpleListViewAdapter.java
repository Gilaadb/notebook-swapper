package gilaad.itamar.idan.notebookswapper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SimpleListViewAdapter extends BaseAdapter{

	int size = 10;
	private Context context;
	private String s;
	
	public SimpleListViewAdapter(Context context,String s)
	{
		this.context = context;
		this.s = s;
		
	}
	
	@Override
	public int getCount() {
		return size;
	}

	@Override
	public Object getItem(int position) {
		return s;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inf = LayoutInflater.from(context);
		View view;
		if (null == convertView)
		{
			 view = inf.inflate(R.layout.wishlist_item, null);
		}
		else
		{
			view = convertView;
		}
		TextView t = (TextView)view.findViewById(R.id.txtNotebook);
		t.setText((String)getItem(position));
		return view;
	}



}
