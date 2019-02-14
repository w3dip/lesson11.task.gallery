package ru.sberbank.lesson11.task.gallery.data.repository;

import android.content.Context;

import java.util.List;

import ru.sberbank.lesson11.task.gallery.data.resolvers.GalleryContentResolver;
import ru.sberbank.lesson11.task.gallery.domain.repository.GalleryRepository;

public class GalleryRepositoryImpl implements GalleryRepository {
    private GalleryContentResolver contentResolver;

    public GalleryRepositoryImpl(Context context) {
        this.contentResolver = new GalleryContentResolver(context.getContentResolver());
    }

    @Override
    public List<String> getAll() {
        return contentResolver.getAll();
    }
}
