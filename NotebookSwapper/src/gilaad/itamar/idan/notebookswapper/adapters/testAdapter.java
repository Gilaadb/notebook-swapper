package gilaad.itamar.idan.notebookswapper.adapters;

import gilaad.itamar.idan.notebookswapper.R;
import gilaad.itamar.idan.notebookswapper.dbhandler.AbstractDataManager;
import gilaad.itamar.idan.notebookswapper.dbitems.iface.ICourse;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class testAdapter extends BaseAdapter {

	ArrayList<ICourse> m_Courses;
	Context m_context;
	
	public testAdapter(Context context) {
		m_Courses = AbstractDataManager.getManager().getAllCourses();
		m_context = context;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return m_Courses.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return m_Courses.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inf = LayoutInflater.from(m_context);
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
		ICourse item = (ICourse) getItem(position);
		t.setText(item.getCourseName());
		return view;
	}

}
