package com.example.ubereatsclone.utils;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.ubereatsclone.R;
import com.example.ubereatsclone.modelClass.ImageObjects;
import com.example.ubereatsclone.modelClass.MainModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PageAdapter extends PagerAdapter {

    private ArrayList<ImageObjects> images;
    private Context context;
    private ImageView mPagerImage;

    public PageAdapter(ArrayList<ImageObjects> images, Context context) {
        this.images = images;
        this.context = context;
    }


    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView  = LayoutInflater.from(context).inflate(R.layout.pager_image_layout, container, false);
        mPagerImage = itemView.findViewById(R.id.pager_image);
        Picasso.get().load(images.get(position).getImageUrls()).into(mPagerImage);

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
