package com.example.redcholove.hotshopname;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by redcholove on 2016/8/28.
 */
public class HotShopAdapter extends RecyclerView.Adapter
        <HotShopAdapter.HotShopViewHolder>{
    private Context context;
    private ArrayList<HotShop> hotShops;

    public HotShopAdapter(Context context, ArrayList<HotShop> hotShops){
        this.context = context;
        this.hotShops = hotShops;
    }

    @Override
    public HotShopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.from(parent.getContext())
                .inflate(R.layout.hotshop_cardview_layout, parent, false);

        HotShopViewHolder hotShopViewHolder = new HotShopViewHolder(view);
        return hotShopViewHolder;
    }

    @Override
    public void onBindViewHolder(HotShopViewHolder holder, int position) {

        HotShop hotShop = hotShops.get(position);
        holder.tvShopName.setText(hotShop.ShopName);
        holder.tvShopPhonenum.setText(hotShop.ShopPhonenum);
        Picasso.with(context).
                load("http://192.168.0.101/RedFood/img/" + hotShop.ShopIcon).
                placeholder(R.drawable.pp).
                error(android.R.drawable.stat_notify_error).
                into(holder.ivShopIcon);
    }
    @Override
    public int getItemCount() {
        if(hotShops != null){
            return hotShops.size();
        }
        return 0;
    }

    //ViewHolder class
    public static class HotShopViewHolder extends RecyclerView.ViewHolder{

        public CardView cvChannel;
        public ImageView ivShopIcon;
        public TextView tvShopName,tvShopPhonenum;

        public HotShopViewHolder(View itemView) {
            super(itemView);
            cvChannel = (CardView)itemView.findViewById(R.id.cvChannel);
            ivShopIcon = (ImageView)itemView.findViewById(R.id.ivShopIcon);
            tvShopName = (TextView)itemView.findViewById(R.id.tvShopName);
            tvShopPhonenum = (TextView)itemView.findViewById(R.id.tvShopPhonenum);

        }
    }
}
