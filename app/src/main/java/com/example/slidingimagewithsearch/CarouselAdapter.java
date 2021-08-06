package com.example.slidingimagewithsearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CarouselAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList<Carousel> mstudents;
    private LayoutInflater mLayoutInflater;

    public CarouselAdapter(Context context, ArrayList<Carousel> students) {
        this.mContext = context;
        this.mstudents = students;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);

        Picasso.get().load(mstudents.get(position).getImage()).into(itemView.<ImageView>findViewById(R.id.imageView));
        //Glide.with(mContext).load(mstudents.get(position).getImage()).into(itemView.<ImageView>findViewById(R.id.imageView));

        container.addView(itemView);
        return itemView;
    }

    @Override
    public int getCount() {
        return mstudents.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ConstraintLayout) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return object == (ConstraintLayout)view;
    }
}
