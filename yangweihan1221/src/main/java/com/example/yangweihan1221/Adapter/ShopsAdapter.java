package com.example.yangweihan1221.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yangweihan1221.Bean.ShopBean;
import com.example.yangweihan1221.R;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ShopsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ShopBean.DataBean> list;

    public ShopsAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public void setList(List<ShopBean.DataBean> list) {
        if (list != null){
            this.list = list;
        }
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.shops_item,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.shops_item_title.setText(list.get(i).getTitle());
        holder.shops_item_price.setText(list.get(i).getPrice()+"");
        /*String images = list.get(i).getImages();

        Pattern pattern = Pattern.compile("\\|");
        String[] splie = pattern.split(images);
        Glide.with(context).load(splie[0]).into(holder.shops_item_image);*/
        String url = list.get(i).getImages().split("\\|")[0].replace("https","http");
    }

    @Override
    public int getItemCount() {
        return 0;
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView shops_item_image;
        private TextView shops_item_title,shops_item_price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shops_item_image = itemView.findViewById(R.id.shops_item_image);
            shops_item_price = itemView.findViewById(R.id.shops_item_price);
            shops_item_title = itemView.findViewById(R.id.shops_item_title);
        }
    }
}
