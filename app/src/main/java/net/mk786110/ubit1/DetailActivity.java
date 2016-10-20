package net.mk786110.ubit1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import net.mk786110.ubit1.Handler.DbHandler;
import net.mk786110.ubit1.entity.Profile;

/**
 * Created by mkumail on 10/20/16.
 */

public class DetailActivity  extends AppCompatActivity {

    public static Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView name=(TextView)findViewById(R.id.nameDetailText);
        TextView phone=(TextView)findViewById(R.id.phoneDetailText);
        TextView hobby=(TextView)findViewById(R.id.hobbyDetailText);
        TextView gender=(TextView)findViewById(R.id.genderDetailText);
        TextView aboutme=(TextView)findViewById(R.id.abouDetailtmeText);
        TextView email=(TextView)findViewById(R.id.emailDetailText);
        TextView dof=(TextView)findViewById(R.id.dobDetailText);


        name.setText(profile.getName());
        phone.setText(profile.getPhone());
        hobby.setText(profile.getHobby());
        gender.setText(profile.getGender());
        aboutme.setText(profile.getAboutme());
        email.setText(profile.getEmail());
        dof.setText(profile.getDob());


    }

    public void  onClickEdit(View view)
    {
        AddActivity.Editprofile=profile;
        Intent intent=new Intent(this,AddActivity.class);
        startActivity(intent);
    }
    public void  onClickDelete(View view)
    {
        DbHandler dbHandler=new DbHandler(this);
        dbHandler.deleteProfile(Integer.parseInt(profile.getId()));
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
