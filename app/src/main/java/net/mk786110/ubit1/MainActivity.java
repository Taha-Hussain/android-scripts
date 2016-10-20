package net.mk786110.ubit1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import net.mk786110.ubit1.adaptor.ProfileAdaptor;
import net.mk786110.ubit1.datasource.ProfileDatasoure;
import net.mk786110.ubit1.entity.Profile;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ProfileAdaptor profileAdaptor;
    ProfileDatasoure profileDatasoure;
    ArrayList<Profile> arrayList=new ArrayList<>();

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        ListView  listView=(ListView) findViewById(R.id.listData);

        profileDatasoure=new ProfileDatasoure(context);

        arrayList=profileDatasoure.getData();

        profileAdaptor=new ProfileAdaptor(context,R.layout.row,arrayList);

        listView.setAdapter(profileAdaptor);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Profile theProfile=arrayList.get(position);

                DetailActivity.profile=theProfile;
                Intent intent=new Intent(context,DetailActivity.class);
                startActivity(intent);

            }
        });
    }
}
