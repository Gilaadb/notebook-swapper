package gilaad.itamar.idan.notebookswapper;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class WishActivity extends Activity {
	public static String EXTRA_OFFERID = "notebookId";
	private UserData m_userData;
	private long m_lWishID;
	private TextView m_tvWishID;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);
        m_userData = (UserData)getIntent().getSerializableExtra(UserData.USER_DATA);
        m_lWishID = getIntent().getLongExtra(EXTRA_OFFERID, -1);
        m_tvWishID = (TextView)findViewById(R.id.offerID);
        m_tvWishID.setText(Long.toString(m_lWishID));
	}

}