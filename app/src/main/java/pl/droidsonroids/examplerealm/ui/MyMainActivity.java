package pl.droidsonroids.examplerealm.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import pl.droidsonroids.examplerealm.R;
import pl.droidsonroids.examplerealm.ui.edition.MyEditionFragment;
import pl.droidsonroids.examplerealm.ui.list.MyListFragment;

public class MyMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.edition_container, new MyEditionFragment())
                    .add(R.id.list_container, new MyListFragment())
                    .commit();
        }
    }

}
