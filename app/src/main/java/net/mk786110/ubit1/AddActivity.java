package net.mk786110.ubit1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.mk786110.ubit1.Handler.DbHandler;
import net.mk786110.ubit1.entity.Profile;

import static java.sql.Types.NULL;

public class AddActivity extends AppCompatActivity {

    public static Profile Editprofile;

    EditText name_edit_text, phone_edit_text, email_edit_text, gender_edit_text, hobby_edit_text,
            aboutme_edit_text, dateofbirth_edit_text, image_edit_text;
    Button editButton,insertButton;
    Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        context=this;

        name_edit_text = (EditText) findViewById(R.id.name_edit_text);
        phone_edit_text = (EditText) findViewById(R.id.phone_edit_text);
        email_edit_text = (EditText) findViewById(R.id.email_edit_text);
        gender_edit_text = (EditText) findViewById(R.id.gender_edit_text);
        hobby_edit_text = (EditText) findViewById(R.id.hobby_edit_text);
        aboutme_edit_text = (EditText) findViewById(R.id.aboutme_edit_text);
        dateofbirth_edit_text = (EditText) findViewById(R.id.dateofbirth_edit_text);
        image_edit_text = (EditText) findViewById(R.id.image_edit_text);
        editButton=(Button) findViewById(R.id.editbutton);
        insertButton=(Button) findViewById(R.id.insertbutton);

        if (Editprofile != null) {


            editButton.setVisibility(View.VISIBLE);
            insertButton.setVisibility(View.GONE);


            name_edit_text.setText(Editprofile.getName());
            phone_edit_text.setText(Editprofile.getPhone());
            hobby_edit_text.setText(Editprofile.getHobby());
            gender_edit_text.setText(Editprofile.getGender());
            aboutme_edit_text.setText(Editprofile.getAboutme());
            email_edit_text.setText(Editprofile.getEmail());
            dateofbirth_edit_text.setText(Editprofile.getDob());
        } else {
            name_edit_text.setText("");
            phone_edit_text.setText("");
            hobby_edit_text.setText("");
            gender_edit_text.setText("");
            aboutme_edit_text.setText("");
            email_edit_text.setText("");
            dateofbirth_edit_text.setText("");
        }

        editButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Profile profile = new Profile();
                DbHandler dbHandler = new DbHandler(context);
                profile.setId(Editprofile.getId());
                profile.setName(name_edit_text.getText().toString());
                profile.setPhone(phone_edit_text.getText().toString());
                profile.setEmail(email_edit_text.getText().toString());
                profile.setGender(gender_edit_text.getText().toString());
                profile.setHobby(hobby_edit_text.getText().toString());
                profile.setAboutme(aboutme_edit_text.getText().toString());
                profile.setDob(dateofbirth_edit_text.getText().toString());

                dbHandler.updateProfile(profile);

                Intent intent =new Intent(context,MainActivity.class);
                startActivity(intent);


            }
        } );
    }

    public void saveProfile(View view) {
        Profile profile = new Profile();
        DbHandler dbHandler = new DbHandler(this);
        profile.setName(name_edit_text.getText().toString());
        profile.setPhone(phone_edit_text.getText().toString());
        profile.setEmail(email_edit_text.getText().toString());
        profile.setGender(gender_edit_text.getText().toString());
        profile.setHobby(hobby_edit_text.getText().toString());
        profile.setAboutme(aboutme_edit_text.getText().toString());
        profile.setDob(dateofbirth_edit_text.getText().toString());

        long getID = dbHandler.registerProfile(profile);

        if (getID > 0) {
            Toast.makeText(this, "Profile Inserted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }


    }

   /* public void onClickEdit(View view) {
        Button editButton=(Button) findViewById(R.id.editbutton);
        editButton.setVisibility(View.VISIBLE);




    }*/
}
