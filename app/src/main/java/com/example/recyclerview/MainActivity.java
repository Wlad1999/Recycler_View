package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    String cars[], descriptions[];
    int images[] = {R.drawable.bmw,R.drawable.audi,R.drawable.mercedes};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Создание объекта
        recyclerView = findViewById(R.id.recyclerView);


        //Передаем значения нашим переменным из массивов
        cars = getResources().getStringArray(R.array.cars);
        descriptions = getResources().getStringArray(R.array.description);


        // Создаем объект адаптера
        MyAdapter adapter = new MyAdapter(this,cars,descriptions,images);


        //Передаем его виджету спсиска
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
