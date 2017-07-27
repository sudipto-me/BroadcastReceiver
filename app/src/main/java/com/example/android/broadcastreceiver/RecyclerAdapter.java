package com.example.android.broadcastreceiver;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Android on 7/27/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    ArrayList<IncomingNumber> arrayList = new ArrayList<>();

    public RecyclerAdapter(ArrayList<IncomingNumber>arrayList){
        this.arrayList = arrayList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview,parent,false);
       MyViewHolder mvh = new MyViewHolder(view);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_id.setText(Integer.toString(arrayList.get(position).getId()));
        holder.tv_number.setText(arrayList.get(position).getValue());

    }



    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView tv_id,tv_number;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_id = (TextView)itemView.findViewById(R.id.tv_id);
            tv_number = (TextView)itemView.findViewById(R.id.tv_number);
        }
    }
}
