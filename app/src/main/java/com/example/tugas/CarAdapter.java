package com.example.tugas;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {

    private ArrayList<Car> dataList;

    public CarAdapter(ArrayList<Car> data) {
        this.dataList = data;
    }

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_item, parent, false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
    holder.tv_CarName.setText(dataList.get(position).getName());
    holder.tv_CarDetails.setText(dataList.get(position).getDetail() + "...");
    holder.iv_CarPhoto.setImageResource(dataList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return (dataList !=null) ? dataList.size() : 0;
    }

    public class CarViewHolder extends RecyclerView.ViewHolder{
        TextView tv_CarName;
        TextView tv_CarDetails;
        ImageView iv_CarPhoto;

        public CarViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_CarName = itemView.findViewById(R.id.tv_CarName);
            tv_CarDetails = itemView.findViewById(R.id.tv_CarDetail);
            iv_CarPhoto = itemView.findViewById(R.id.iv_CarPhoto);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent a = new Intent(v.getContext(), SecondActivity.class);
                    a.putExtra("name", tv_CarName.getText());
                    a.putExtra("details", (String) tv_CarDetails.getTag());
                    a.putExtra("photos", (int) iv_CarPhoto.getTag());
                    v.getContext().startActivity(a);
                }
            });
        }
    }
}
