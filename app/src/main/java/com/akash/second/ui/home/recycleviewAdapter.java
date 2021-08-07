package com.akash.second.ui.home;


import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.akash.second.R;
import com.akash.second.ui.addcart.addcartfood;
import com.bumptech.glide.Glide;
import com.akash.second.ui.Dbhandler.DBHandler;

import java.util.ArrayList;
import java.util.List;

public class recycleviewAdapter extends RecyclerView.Adapter<recycleviewAdapter.ViewHolder>   {
    public List<foods> food=new ArrayList<>();
    private Context context;
    public ArrayList<String> str;
    public DBHandler mydb;

    public recycleviewAdapter(Context context){
        this.context=context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

               View view= LayoutInflater.from(parent.getContext()).inflate((R.layout.recyclerview),parent,false);
               ViewHolder holder=new ViewHolder(view);
                return holder;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.foodname.setText(food.get(position).getFoodName());
        holder.shortdesc.setText(food.get(position).getShortdesc());
        holder.longdesc.setText(food.get(position).getLongdesc());
        holder.quant.setText(String.valueOf(food.get(position).getval()));

        Glide.with(context)
                .asBitmap()
                .load(food.get(position).getImageurl())
                .into(holder.image);
        if(food.get(position).isIsexpand()){
            TransitionManager.beginDelayedTransition(holder.card);
            holder.expandrel.setVisibility(View.VISIBLE);
            holder.shortdesc.setVisibility(View.GONE);
            holder.downarrow.setVisibility(View.GONE );

        }
        else{
            TransitionManager.beginDelayedTransition(holder.card);
            holder.expandrel.setVisibility(View.GONE);
            holder.downarrow.setVisibility(View.VISIBLE);
            holder.shortdesc.setVisibility(View.VISIBLE);
        }

    }


    @Override
    public int getItemCount() {
        return food.size();
    }

    public void setfood(List<foods> food) {
        this.food = food;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView foodname;
        private TextView shortdesc;
        private RelativeLayout part;
        private ImageView image;
        private ImageView addcartbutton;
        private CardView card;

        private RelativeLayout expandrel;
        private TextView longdesc;
        private ImageView uparrow,downarrow,addimg,minusimg;
        private TextView quant;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            foodname=itemView.findViewById(R.id.foodName);
            image=itemView.findViewById(R.id.image);
            shortdesc=itemView.findViewById(R.id.shortdesc);
            expandrel=itemView.findViewById(R.id.parent2);
            uparrow=itemView.findViewById(R.id.uparrow);
            card=itemView.findViewById(R.id.card);
            longdesc=itemView.findViewById(R.id.longdesc);
            downarrow=itemView.findViewById(R.id.downarrow);
            uparrow=itemView.findViewById(R.id.uparrow);
            minusimg=itemView.findViewById(R.id.btnadd);
            addimg=itemView.findViewById(R.id.btnadd1);
            quant=itemView.findViewById(R.id.quantityval);
            addcartbutton=itemView.findViewById(R.id.addcartbtn);

            addcartbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    foods food1=food.get(getAdapterPosition());
                    String name= food1.getFoodName();
                    int price=food1.getPrice();
                    int quantiy=food1.getval();
                    mydb=new DBHandler(itemView.getContext());
                    mydb.addcartinsert(name,price,quantiy);
                }
            });
            minusimg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    foods food1=food.get(getAdapterPosition());
                    int count =-1;
                    food1.addincr(count);
                    notifyItemChanged(getAdapterPosition());

                }
            });

            addimg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    foods food1=food.get(getAdapterPosition());
                    int count=1;
                    food1.addincr(count);
                    notifyItemChanged(getAdapterPosition());

                }
            });
            downarrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    foods food1=food.get(getAdapterPosition());
                    food1.setIsexpand(!food1.isIsexpand());
                    notifyItemChanged(getAdapterPosition());
                }
            });
            uparrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    foods food1=food.get(getAdapterPosition());
                    food1.setIsexpand(!food1.isIsexpand());
                    notifyItemChanged(getAdapterPosition());
                }
            });



        }
    }
}


