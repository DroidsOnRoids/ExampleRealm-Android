package pl.droidsonroids.examplerealm.ui.edition;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmResults;
import pl.droidsonroids.examplerealm.R;
import pl.droidsonroids.examplerealm.model.MyBook;

public class MyEditionFragment extends Fragment {

    @Bind(R.id.edit_title) EditText mEditTitle;

    private Realm mRealm;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRealm = Realm.getInstance(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edition, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mRealm.close();
    }

    @OnClick(R.id.button_add)
    public void onAddClick() {
        mRealm.beginTransaction();
        MyBook book = mRealm.createObject(MyBook.class);
        book.setTitle(getTrimmedTitle());
        mRealm.commitTransaction();
    }

    @OnClick(R.id.button_remove)
    public void onRemoveClick() {
        mRealm.beginTransaction();
        RealmResults<MyBook> books = mRealm.where(MyBook.class).equalTo("title", getTrimmedTitle()).findAll();
        if(!books.isEmpty()) {
            for(int i = books.size() - 1; i >= 0; i--) {
                books.get(i).removeFromRealm();
            }
        }
        mRealm.commitTransaction();
    }

    private String getTrimmedTitle() {
        return mEditTitle.getText().toString().trim();
    }
}
