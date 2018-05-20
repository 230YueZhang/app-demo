package org.zy.demonew.modelview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.zy.demonew.R;
import org.zy.demonew.twoway.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openBasic(View view) {
        startActivity(new Intent(this, BasicFuncActivity.class));
    }

    public void openBaseObj(View view) {
        startActivity(new Intent(this, BaseObservableObjectActivity.class));
    }

    public void openObservableFields(View view) {
        startActivity(new Intent(this, ObservableFieldObjectActivity.class));
    }

    public void openObservableCollections(View view) {
        startActivity(new Intent(this, ObservableCollectionActivity.class));
    }

    public void openListViewActivity(View view) {
        startActivity(new Intent(this, ListViewActivity.class));
    }

    public void openRecyclerViewActivity(View view) {
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }

    public void openLoginActivity(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }
}
