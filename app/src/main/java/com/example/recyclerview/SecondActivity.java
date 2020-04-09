package com.example.recyclerview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    ImageView image;
    TextView titles, descriptions;

    String data1, data2;
    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);

        //Нахождение объектов
        image = findViewById(R.id.car);
        titles = findViewById(R.id.mainText);
        descriptions = findViewById(R.id.subText);

        //Вызов методов
        getData();
        setData();
    }

    //Метод который принимает значения
    private void getData(){
        if(getIntent().hasExtra("image") && getIntent().hasExtra("data1") && getIntent().hasExtra("data2")){
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            myImage = getIntent().getIntExtra("image",1);
        }
        else {
            Toast.makeText(this,"No data",Toast.LENGTH_SHORT).show();
        }
    }

    //Метод установливает значения
    private void setData(){
        titles.setText(data1);
        descriptions.setText(data2);
        image.setImageResource(myImage);
    }
}
