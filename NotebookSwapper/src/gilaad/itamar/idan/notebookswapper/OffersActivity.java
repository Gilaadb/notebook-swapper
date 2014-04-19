package gilaad.itamar.idan.notebookswapper;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class OffersActivity extends Activity {
	public static String EXTRA_OFFERID = "notebookId";
	private UserData m_userData;
	private long m_lOfferID;
	private TextView m_tvOfferID;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);
        m_userData = (UserData)getIntent().getSerializableExtra(UserData.USER_DATA);
        m_lOfferID = getIntent().getLongExtra(EXTRA_OFFERID, -1);
        m_tvOfferID = (TextView)findViewById(R.id.offerID);
        m_tvOfferID.setText(Long.toString(m_lOfferID));
	}

}
