package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FoodListAdapter foodListAdapter;
    ArrayList<Food> foodList;
    private RecyclerView.LayoutManager linearLayoutManager, gridLayoutManager;

    Button btnChange;
    boolean layoutType = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recyclerView = findViewById(R.id.recyclerView);
        btnChange = findViewById(R.id.btnChange);
        foodList = new ArrayList<>();

        foodList.add(new Food(R.drawable.audi_a6,"Audi A6","2021y", 55000));
        foodList.add(new Food(R.drawable.lexus_rx330,"Lexus RX 330","2006y", 12000));
        foodList.add(new Food(R.drawable.bmw525,"BMW 525","1992y", 4700));

        foodListAdapter = new FoodListAdapter(this, foodList);

        linearLayoutManager = new LinearLayoutManager(this);
        gridLayoutManager= new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(foodListAdapter);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutType = !layoutType;
                if(layoutType) {
                    recyclerView.setLayoutManager(gridLayoutManager);
                }else {
                    recyclerView.setLayoutManager(linearLayoutManager);
                }

                foodListAdapter.notifyDataSetChanged();
            }
        })

    }
}