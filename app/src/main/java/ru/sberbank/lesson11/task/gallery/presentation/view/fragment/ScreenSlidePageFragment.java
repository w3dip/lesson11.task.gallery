package ru.sberbank.lesson11.task.gallery.presentation.view.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.sberbank.lesson11.task.gallery.R;

import static ru.sberbank.lesson11.task.gallery.presentation.view.adapter.ScreenSlidePagerAdapter.IMAGE_URL;

public class ScreenSlidePageFragment extends Fragment {

    @BindView(R.id.image)
    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            String url = getArguments().getString(IMAGE_URL);
            Glide.with(view.getRootView().getContext())
                    .load(Uri.fromFile(new File(url)))
                    .thumbnail(0.1f)
                    .into(imageView);
        }
    }
}
