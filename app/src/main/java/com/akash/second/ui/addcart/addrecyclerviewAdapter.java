package com.akash.second.ui.addcart;

import android.content.Context;
import android.os.Build;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.akash.second.R;
import com.akash.second.ui.Dbhandler.DBHandler;
import com.akash.second.ui.home.foods;
import com.akash.second.ui.addcart.addrecyclerviewAdapter;
import com.akash.second.ui.home.recycleviewAdapter;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;



    public class addrecyclerviewAdapter extends RecyclerView.Adapter<addrecyclerviewAdapter.ViewHolder>   {
        public List<addcartfood> cartfood=new ArrayList<>();
        private Context context;
        public ArrayList<String> str;
        private DBHandler mydb;

        public addrecyclerviewAdapter(Context context){
            this.context=context;

        }

        @NonNull
        @Override
        public addrecyclerviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view= LayoutInflater.from(parent.getContext()).inflate((R.layout.addrecyclerview),parent,false);
            ViewHolder holder=new ViewHolder(view);
            return holder;
        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onBindViewHolder(@NonNull addrecyclerviewAdapter.ViewHolder holder, final int position) {
            holder.name.setText(cartfood.get(position).getName());
            holder.price.setText(String.valueOf(cartfood.get(position).getPrice()));
            holder.quant.setText(String.valueOf(cartfood.get(position).getQuantity()));



//            Glide.with(context)
//                    .asBitmap()
//                    .load(food.get(position).getImageurl())
//                    .into(holder.image);
//            if(food.get(position).isIsexpand()){
//                TransitionManager.beginDelayedTransition(holder.card);
//                holder.expandrel.setVisibility(View.VISIBLE);
//                holder.shortdesc.setVisibility(View.GONE);
//                holder.downarrow.setVisibility(View.GONE );
//
//            }
//            else{
//                TransitionManager.beginDelayedTransition(holder.card);
//                holder.expandrel.setVisibility(View.GONE);
//                holder.downarrow.setVisibility(View.VISIBLE);
//                holder.shortdesc.setVisibility(View.VISIBLE);
//            }

        }


        @Override
        public int getItemCount() {
            return cartfood.size();
        }

        public void setaddcartfood(List<addcartfood> food) {
            this.cartfood = food;
            notifyDataSetChanged();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            private TextView name;
//            private TextView shortdesc;
//            private RelativeLayout part;
//            private ImageView image;
 //           private Button button;
            private CardView card;

            private ImageView addimg,minusimg;
            private TextView quant,price;
            private ImageView delimg;


            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                name=itemView.findViewById(R.id.foodName2);
                // image=itemView.findViewById(R.id.image);
               // shortdesc=itemView.findViewById(R.id.shortdesc);
                //expandrel=itemView.findViewById(R.id.parent2);
                //uparrow=itemView.findViewById(R.id.uparrow);
               // card=itemView.findViewById(R.id.card2);
               // longdesc=itemView.findViewById(R.id.longdesc);
               // downarrow=itemView.findViewById(R.id.downarrow);
               // uparrow=itemView.findViewById(R.id.uparrow);
               minusimg=itemView.findViewById(R.id.btnminus2);
               addimg=itemView.findViewById(R.id.btnadd2);
                quant=itemView.findViewById(R.id.quantityval2);
                price=itemView.findViewById(R.id.price_val2);
                delimg=itemView.findViewById(R.id.deleteimg2);

                delimg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        addcartfood adfood=cartfood.get(getAdapterPosition());
                        int id=adfood.getId();
                        mydb=new DBHandler(itemView.getContext());
                        mydb.deleteaddcart(id);
                        cartfood.remove(adfood);
                        notifyDataSetChanged();

                    }
                });


                minusimg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        addcartfood food1=cartfood.get(getAdapterPosition());
                        int count =-1;
                        food1.changedquant(count);
                        notifyItemChanged(getAdapterPosition());

                    }
                });

                addimg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        addcartfood food1=cartfood.get(getAdapterPosition());
                        int count=1;
                        food1.changedquant(count);
                        notifyItemChanged(getAdapterPosition());

                  }
                });






            }
        }
    }




