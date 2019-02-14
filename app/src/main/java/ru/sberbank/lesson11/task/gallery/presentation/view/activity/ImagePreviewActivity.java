package ru.sberbank.lesson11.task.gallery.presentation.view.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.sberbank.lesson11.task.gallery.R;
import ru.sberbank.lesson11.task.gallery.presentation.view.adapter.ScreenSlidePagerAdapter;
import ru.sberbank.lesson11.task.gallery.presentation.viewmodel.GalleryViewModel;

import static ru.sberbank.lesson11.task.gallery.presentation.view.adapter.GalleryAdapter.IMAGE_URL;

public class ImagePreviewActivity extends FragmentActivity {

    @BindView(R.id.pager)
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_preview);
        ButterKnife.bind(this);

        GalleryViewModel galleryViewModel = ViewModelProviders.of(this).get(GalleryViewModel.class);
        ScreenSlidePagerAdapter pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        List<String> gallery = galleryViewModel.getImages();
        pagerAdapter.setGallery(gallery);
        pager.setAdapter(pagerAdapter);
        pager.setCurrentItem(gallery.indexOf(getIntent().getStringExtra(IMAGE_URL)));
    }
}
