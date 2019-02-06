package ru.sberbank.lesson11.task.gallery.domain.repository;

import android.arch.lifecycle.LiveData;
import android.graphics.drawable.Drawable;

import java.util.List;

public interface GalleryRepository {
    LiveData<List<Drawable>> getAll();
    LiveData<Drawable> getImage();
}
