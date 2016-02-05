package pl.droidsonroids.examplerealm.model;

import io.realm.RealmObject;
import io.realm.annotations.Required;

public class MyBook extends RealmObject {

    @Required
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

}