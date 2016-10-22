package dozapps.com.education;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

/**
 * Created by vaironl on 10/22/16.
 */
public class HomeActivity extends Activity {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    AboutFragment aboutFragment;
    SelectionFragment selectionFragment;


    public HomeActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        selectionFragment = new SelectionFragment();

        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack("home");


        fragmentTransaction.add(R.id.fragmentContainer, selectionFragment);

        fragmentTransaction.commit();

    }
}
