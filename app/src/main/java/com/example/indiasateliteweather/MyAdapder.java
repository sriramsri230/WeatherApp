package com.example.indiasateliteweather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class MyAdapder extends RecyclerView.Adapter<MyAdapder.MyViewHolder> {

    private final RecylerViewInterface recylerViewInterface;

    Context context;
    ArrayList<DataModel> dataModels;


    public MyAdapder(Context context, ArrayList<DataModel> datamodels, RecylerViewInterface recylerViewInterface){
        this.context=context;
        this.dataModels=datamodels;
        this.recylerViewInterface=recylerViewInterface;
    }

    @NonNull
    @Override
    public MyAdapder.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.recyler_view_row,parent,false);
        return new MyAdapder.MyViewHolder(view,recylerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapder.MyViewHolder holder, int position) {

        holder.mapnames.setText(dataModels.get(position).getName());

        String imageUrl = dataModels.get(position).getImageUrl()+ "?timestamp="+System.currentTimeMillis();

        Picasso.get()
                .load(dataModels.get(position).getImageUrl())
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(holder.imageview);


    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public  static  class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageview ;
        TextView mapnames;

        public MyViewHolder(@NonNull View itemView, RecylerViewInterface recylerViewInterface) {
            super(itemView);
            imageview =itemView.findViewById(R.id.imageView);
            mapnames = itemView.findViewById(R.id.textView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recylerViewInterface!=null){
                        int pos =getAdapterPosition();

                        if (pos!=RecyclerView.NO_POSITION){
                            recylerViewInterface.OnItemClick(pos);
                        }

                    }
                }
            });
        }
    }
}
