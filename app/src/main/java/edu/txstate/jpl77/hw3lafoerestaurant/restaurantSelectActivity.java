package edu.txstate.jpl77.hw3lafoerestaurant;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class restaurantSelectActivity extends ListActivity {

    List<restaurant> list = new ArrayList<restaurant>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        restaurant restaurant1 = new restaurant();
        restaurant1.setId(101);
        restaurant1.setName("Maruchan Ramen");
        restaurant1.setCity("Austin Texas");
        restaurant1.setUrl("https://www.maruchan.com/");
        restaurant1.setPhoneNum("512-803-9648");
        restaurant1.setCostPerPerson(30.00);
        list.add(restaurant1);

        restaurant restaurant2 = new restaurant();
        restaurant2.setId(102);
        restaurant2.setName("Dickeys BBQ");
        restaurant2.setCity("Austin Texas");
        restaurant2.setUrl("https://www.dickeys.com/");
        restaurant2.setPhoneNum("512-393-1100");
        restaurant2.setCostPerPerson(25.30);
        list.add(restaurant2);


        restaurant restaurant3 = new restaurant();
        restaurant3.setId(103);
        restaurant3.setName("Pho");
        restaurant3.setCity("Houston Texas");
        restaurant3.setUrl("https://phoquehuong.com/");
        restaurant3.setPhoneNum("(512) 382-0048");
        restaurant3.setCostPerPerson(35.00);
        list.add(restaurant3);


        restaurant restaurant4 = new restaurant();
        restaurant4.setId(104);
        restaurant4.setName("Taqueria");
        restaurant4.setCity("Austin Texas");
        restaurant4.setUrl("https://www.aztecamex.com/");
        restaurant4.setPhoneNum("512-828-1909");
        restaurant4.setCostPerPerson(38.55);
        list.add(restaurant4);


        restaurant restaurant5 = new restaurant();
        restaurant5.setId(105);
        restaurant5.setName("Pasha's");
        restaurant5.setCity("San Antonio");
        restaurant5.setUrl("https://gopasha.com/");
        restaurant5.setPhoneNum("210-433-9292");
        restaurant5.setCostPerPerson(32.00);
        list.add(restaurant5);

        setListAdapter(new ArrayAdapter<restaurant>(restaurantSelectActivity.this, R.layout.activity_restaurant_select, R.id.txtLayout, list));

    }
    protected void onListItemClick(ListView l, View v, int position, long id){
        restaurant selectedRestaurant = list.get(position);

        DecimalFormat df = new DecimalFormat("###,###.##");
        Toast.makeText(restaurantSelectActivity.this, "Cost per person is: $" + df.format(selectedRestaurant.getCostPerPerson()), Toast.LENGTH_LONG).show();

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(restaurantSelectActivity.this);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("KeyID", selectedRestaurant.getId());
        editor.putString("KeyName", selectedRestaurant.getName());
        editor.putString("KeyCity", selectedRestaurant.getCity());
        editor.putString("KeyUrl", selectedRestaurant.getUrl());
        editor.putString("KeyPhoneNum", selectedRestaurant.getPhoneNum());
        editor.putFloat("KeyCost", (float) selectedRestaurant.getCostPerPerson());

        editor.commit();

        startActivity(new Intent(restaurantSelectActivity.this, calculateActivity.class));


    }

}