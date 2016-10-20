package net.mk786110.ubit1.adaptor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import net.mk786110.ubit1.R;
import net.mk786110.ubit1.entity.Profile;

import java.util.ArrayList;

/**
 * Created by mkumail on 10/20/16.
 */

public class ProfileAdaptor extends ArrayAdapter<Profile> {

    Context context;
    public ProfileAdaptor(Context context, int resource, ArrayList<Profile> object) {
        super(context, resource, object);
        this.context=context;


    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        Profile profile=getItem(position);

        LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowview=(View) layoutInflater.inflate(R.layout.row,parent,false);

        TextView name=(TextView) rowview.findViewById(R.id.nameText);
        TextView phone=(TextView) rowview.findViewById(R.id.phoneText);
        TextView email=(TextView) rowview.findViewById(R.id.emailText);
//        TextView aboutme=(TextView) rowview.findViewById(R.id.aboutmeText);
//        TextView dob=(TextView) rowview.findViewById(R.id.dobText);
//        TextView gender=(TextView) rowview.findViewById(R.id.genderText);
//        TextView hobby=(TextView) rowview.findViewById(R.id.hobbyText);


        name.setText(profile.getName());
        phone.setText(profile.getPhone());
        email.setText(profile.getEmail());
//        aboutme.setText(profile.getAboutme());
//        dob.setText(profile.getDob());
//        gender.setText(profile.getGender());
//        hobby.setText(profile.getHobby());

        return  rowview;

    }
}
