package com.example.mohit.cardview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

/**
 * Created by mohit on 20/5/16.
 */
public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder> {

    LayoutInflater inflater;
    List<Person> data = Collections.emptyList();
    myViewHolder holder;

    myAdapter(Context context, List<Person> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }


    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_view,parent,false);
        holder = new myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        Person curr = data.get(position);
        holder.tvname.setText(curr.getName());
        holder.tvid.setText(curr.getId());
        holder.image.setImageResource(R.drawable.logo);

    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvname;
        TextView tvid;
        ImageView image;

        public myViewHolder(View itemView) {
            super(itemView);
            tvname = (TextView) itemView.findViewById(R.id.textname);
            tvid = (TextView) itemView.findViewById(R.id.textnumber);
            image = (ImageView) itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getPosition();
            Toast.makeText(view.getContext(),data.get(position).getName()+ " " + data.get(position).getId(), Toast.LENGTH_SHORT).show();
        }
    }


}
