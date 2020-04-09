package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
   String data1[], data2[];
   int img[];
   Context context;

    public MyAdapter(Context c, String cars[], String descriptions[], int images[]){
        context = c;
        data1 = cars;
        data2 = descriptions;
        img = images;

    }
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Преобразуем макет в дерево объектов
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        // Меняем содержимое виджетов
        holder.name.setText(data1[position]);
        holder.description.setText(data2[position]);
        holder.image.setImageResource(img[position]);

        //Налазиваем работу отклика
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Передаем значения
                Intent intent = new Intent(context,SecondActivity.class);
                intent.putExtra("data1",data1[position]);
                intent.putExtra("data2",data2[position]);
                intent.putExtra("image",img[position]);
                //Запускаем второй интент
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return img.length;
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{

        TextView name, description;
        ImageView image;
        ConstraintLayout layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.mainTitle);
            description = itemView.findViewById(R.id.subTitle);
            image = itemView.findViewById(R.id.images);
            layout = itemView.findViewById(R.id.MainLayout);
        }
    }
}
