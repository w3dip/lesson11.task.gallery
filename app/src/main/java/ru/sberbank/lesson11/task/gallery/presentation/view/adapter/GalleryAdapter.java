package ru.sberbank.lesson11.task.gallery.presentation.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.sberbank.lesson11.task.gallery.R;
import ru.sberbank.lesson11.task.gallery.presentation.view.activity.ImagePreviewActivity;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {
    public static final String IMAGE_URL = "ru.sberbank.lesson11.task.gallery.IMAGE_URL";

    private final LayoutInflater inflater;
    //private List<Drawable> gallery = Collections.emptyList();
    private List<String> gallery = Collections.emptyList();
    private Context context;

    public static class GalleryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image) ImageView image;
        String url;
        GalleryViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
            image.setOnClickListener((item) -> {
                Context context = item.getRootView().getContext();
                Intent intent = new Intent(context, ImagePreviewActivity.class);
                intent.putExtra(IMAGE_URL, url);
                context.startActivity(intent);
            });
        }
    }

    public GalleryAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public GalleryViewHolder onCreateViewHolder(ViewGroup parent,
                                                 int viewType) {
        View view = inflater.inflate(R.layout.image_layout, parent, false);
        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(metrics.widthPixels / 3, metrics.widthPixels / 3);
        view.setLayoutParams(layoutParams);
        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GalleryViewHolder holder, int position) {
        String url = gallery.get(position);
        Glide.with(context)
                .load(Uri.fromFile(new File(url)))
                .thumbnail(0.1f)
                .into(holder.image);
        holder.url = url;
    }

    public void setGallery(List<String> gallery) {
        this.gallery = gallery;
    }

    /*public void setGallery(List<Drawable> gallery) {
        this.gallery = gallery;
        notifyDataSetChanged();
    }*/

    @Override
    public int getItemCount() {
        return gallery != null ? gallery.size() : 0;
    }
}
