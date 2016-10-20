package net.mk786110.ubit1.datasource;

import android.content.Context;

import net.mk786110.ubit1.Handler.DbHandler;
import net.mk786110.ubit1.entity.Profile;

import java.util.ArrayList;

/**
 * Created by mkumail on 10/20/16.
 */


public class ProfileDatasoure {

    Context context;

    public ProfileDatasoure(Context context) {
        this.context = context;
    }

    public ArrayList<Profile> getData() {

        ArrayList<Profile> arrayList=new ArrayList<>();

        DbHandler dbHandler = new DbHandler(context);
        arrayList= dbHandler.getAllProfile();


        return arrayList;
    }
}