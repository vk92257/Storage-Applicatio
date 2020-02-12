package com.e.storage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ArrayList<String >  list = new ArrayList<String>();
        list.add("vivek");
        list.add("kumar");
        list.add("coding");
        list.add("karat");
        list.add("hai");
        SharedPreferences sharedPreferences  =  this.getSharedPreferences("com.e.storage",Context.MODE_PRIVATE);
        try {
            sharedPreferences.edit().putString("friends",ObjectSerializer.serialize(list)).apply();
            Log.i("this is the message ",ObjectSerializer.serialize(list));
        }catch (Exception e ){e.printStackTrace();}
            ArrayList<String> newFriends = new ArrayList<String>();

        try {
           newFriends= (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("friends",ObjectSerializer.serialize(new ArrayList<String>())));
            Log.i("output is : ",newFriends.toString());
        }catch (Exception e ){
            e.printStackTrace();
        }

        /*
        SharedPreferences sharedPreferences  = this. getSharedPreferences("com.e.storage", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(" username-1"," kumar" ).apply();
        String username = sharedPreferences.getString(" username","");
        String username1 = sharedPreferences.getString(" username-1","");
        Log.i("this is username  : " ,""+username+" "+username1);

    */

    }

}
