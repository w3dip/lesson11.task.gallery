package ru.sberbank.lesson11.task.gallery.presentation.view.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.Collections;
import java.util.List;

import ru.sberbank.lesson11.task.gallery.presentation.view.fragment.ScreenSlidePageFragment;

public class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
    public static final String IMAGE_URL = "ru.sberbank.lesson11.task.gallery.IMAGE_URL";

    private List<String> gallery = Collections.emptyList();

    public ScreenSlidePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment image = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putCharSequence(IMAGE_URL, gallery.get(i));
        image.setArguments(args);
        return image;
    }

    @Override
    public int getCount() {
        return gallery != null ? gallery.size() : 0;
    }

    public void setGallery(List<String> gallery) {
        this.gallery = gallery;
    }
}
