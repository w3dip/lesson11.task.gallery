package ru.sberbank.lesson11.task.gallery.data.repository;

import android.arch.lifecycle.LiveData;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.List;

import ru.sberbank.lesson11.task.gallery.domain.repository.GalleryRepository;

public class GalleryRepositoryImpl implements GalleryRepository {
    private ContentResolver contentResolver;

    public GalleryRepositoryImpl(Context context) {
        this.contentResolver = context.getContentResolver();
    }

    @Override
    public LiveData<List<Drawable>> getAll() {
        return null;
    }

    @Override
    public LiveData<Drawable> getImage() {
        return null;
    }
}
