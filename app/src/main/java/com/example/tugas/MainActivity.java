package com.example.tugas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv_Content;
    ArrayList<Car> car = new ArrayList<>();

    private static Resources resources;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resources = getResources();
        rv_Content = findViewById(R.id.rv_content);
        rv_Content.setHasFixedSize(true);
        car.addAll(CarData.getListData());
        rv_Content.setLayoutManager(new LinearLayoutManager(this));
        CarAdapter adapter = new CarAdapter(car);
        rv_Content.setAdapter(adapter);

    }

    public static Resources getResource() {
        return  resources;
    }
}