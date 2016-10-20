package net.mk786110.ubit1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);



    }

    public void onClickAdd(View view)
    {
        AddActivity.Editprofile = null;
        Intent intent=new Intent(this,AddActivity.class);
        startActivity(intent);

    }


    public void onClickShow(View view)
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
