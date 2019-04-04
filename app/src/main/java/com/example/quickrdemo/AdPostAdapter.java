package com.example.quickrdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class AdPostAdapter extends RecyclerView.Adapter<AdPostAdapter.AdPostAdapterViewHolder>{

    private Bitmap mAdImageId[];
    private String mAdTitle[];
    private String mAdPrice[];

    @NonNull
    @Override
    public AdPostAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.ad_post_items;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        return new AdPostAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdPostAdapterViewHolder adPostAdapterViewHolder, int i) {
        Bitmap currentAdImage = mAdImageId[i];
        String currentAdTitle = mAdTitle[i];
        String currentAdPrice = mAdPrice[i];
        adPostAdapterViewHolder.mAdImage.setImageBitmap(currentAdImage);
        adPostAdapterViewHolder.mTitle.setText(currentAdTitle);
        adPostAdapterViewHolder.mPrice.setText(currentAdPrice);
    }

    @Override
    public int getItemCount() {
        if(mAdImageId.length == 0){
            return 0;
        }else{
            return mAdImageId.length;
        }
    }

    public class AdPostAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView mAdImage;
        TextView mTitle;
        TextView mPrice;
        ImageView markFav;
        public AdPostAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            mAdImage = itemView.findViewById(R.id.ad_post_image);
            mTitle = itemView.findViewById(R.id.product_title_tv);
            mPrice = itemView.findViewById(R.id.price_tv);
            markFav = itemView.findViewById(R.id.fav_ad_item);
        }

        @Override
        public void onClick(View v) {
            markFav.setBackgroundColor(itemView.getResources().getColor(R.color.colorForMarkFav));
        }
    }

    public void setAdImageId(Bitmap[] adImageId) {

        mAdImageId = adImageId;
        notifyDataSetChanged();

    }
    public void setAdTitle(String[] adTitle) {

        mAdTitle = adTitle;
    }
    public void setAdPrice(String[] adPrice) {

        mAdPrice = adPrice;
    }
}
