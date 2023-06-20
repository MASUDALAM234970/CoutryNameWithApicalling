package com.error41.coutryname.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.error41.coutryname.R;
import com.error41.coutryname.model.Result__1;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHoder> {

    private ArrayList<Result__1> result__1s;

    public CountryAdapter(ArrayList<Result__1> result__1s) {
        this.result__1s = result__1s;
    }

    @NonNull
    @Override
    public CountryViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());

         View view= layoutInflater.inflate(R.layout.item_view,parent,false);
         return  new CountryViewHoder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHoder holder, int position) {

            holder.textView.setText( result__1s.get(position).getName());
            holder.textView1.setText( result__1s.get(position).getRegion());
            holder.textView2.setText( result__1s.get(position).getCode());

    }

    @Override
    public int getItemCount() {
        return result__1s.size();
    }

    // View Holder

    class  CountryViewHoder extends RecyclerView.ViewHolder{

         TextView textView ,textView1 , textView2;
        public CountryViewHoder(@NonNull View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.text21213);
            textView1=itemView.findViewById(R.id.text123);
            textView2=itemView.findViewById(R.id.text1234);
        }
    }

}
