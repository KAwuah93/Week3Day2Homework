package com.example.week3day2homework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "TAG_MainActivity";

    //Creating the views variables
    RecyclerView recyclerView;
    Button populate;
    Button clear;
    ArrayList<Animal> Troupe;
    RecyclerView.LayoutManager layoutManager;
    AnimalRVAdapter animalRVAdapter;

    MyBroadcastReceiver myBr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Binding the Views.
        recyclerView = findViewById(R.id.RecyclerView);
        populate = findViewById(R.id.generate);
        clear = findViewById(R.id.clear);

        //Population
        myBr = new MyBroadcastReceiver();
        Troupe = new ArrayList<>();

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        animalRVAdapter = new AnimalRVAdapter(Troupe);
        recyclerView.setAdapter(animalRVAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter("populate");
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intentFilter.addAction(Intent.ACTION_BATTERY_LOW);
        intentFilter.addAction(Intent.ACTION_ATTACH_DATA);
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        
        registerReceiver(myBr,intentFilter);
    }
    @Override
    protected void onStop(){
        super.onStop();
        unregisterReceiver(myBr);
    }
    public ArrayList<Animal> generate(int x){
            ArrayList<Animal> passed = new ArrayList<>();
            for(int i = 0; i < x; i++){
                //Randomized animal is added to the list
                passed.add(new Animal());
            }
            return passed;
    }

    public void repopulate(View view) {
        Intent intent = new Intent();
        //Bundle bundle = new Bundle();
        //bundle.putInt("value", 20);

        //replace with action
        intent.setAction("populate");
        //intent.putExtras(bundle);
        //intent.setAction(MyIntentService.POPULATE_NUM_ONE);
        //startService(intent);

        sendBroadcast(intent);
        //overloaded sendbroadcast method (intent, permission name)
        //sendBroadcast(intent, "broadcast.populate");
    }

    class MyBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent){
            String action = intent.getAction();
            switch(action){
                case "populate":
                    Troupe = generate(20);
                    Log.d(TAG, "onReceive: Troupe: " + Troupe.toString());
                    animalRVAdapter = new AnimalRVAdapter(Troupe);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(animalRVAdapter);
                    break;
                case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                    Toast.makeText(context, "Airplane mode has been activated", Toast.LENGTH_SHORT).show();
                    break;
                case Intent.ACTION_BATTERY_LOW:
                    Toast.makeText(context, "Your phone is low battery", Toast.LENGTH_SHORT).show();
                    break;
                case Intent.ACTION_ATTACH_DATA:
                    Toast.makeText(context, "ATTACH DATA", Toast.LENGTH_SHORT).show();
                    break;
                case Intent.ACTION_POWER_CONNECTED:
                    Toast.makeText(context, "Power Cord has been attached", Toast.LENGTH_SHORT).show();
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    Toast.makeText(context, "Power has been disconnected", Toast.LENGTH_SHORT).show();
                    break;

            }
            //Bundle bundle = intent.getExtras();
//            //Get Action instead (use switch)
//            final int count = bundle.getInt("value");
//            Log.d("Help me", "onReceive: Is it going through?");
//            ArrayList<Animal> Temp = generate(count);
//            Troupe = Temp;
//            //notifying the Adapter
//            animalRVAdapter.notifyDataSetChanged();

        }
    }
}
