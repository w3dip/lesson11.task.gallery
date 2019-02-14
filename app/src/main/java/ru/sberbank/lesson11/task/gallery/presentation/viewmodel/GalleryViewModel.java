package ru.sberbank.lesson11.task.gallery.presentation.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.List;

import ru.sberbank.lesson11.task.gallery.data.repository.GalleryRepositoryImpl;
import ru.sberbank.lesson11.task.gallery.domain.interactor.Callback;
import ru.sberbank.lesson11.task.gallery.domain.interactor.usecase.GelAllImagesInteractor;
import ru.sberbank.lesson11.task.gallery.domain.repository.GalleryRepository;

public class GalleryViewModel extends AndroidViewModel implements Callback<List<String>> {
    private List<String> images;

    public GalleryViewModel(@NonNull Application application) {
        super(application);
        GalleryRepository repository = new GalleryRepositoryImpl(application.getApplicationContext());
        GelAllImagesInteractor allImagesInteractor = new GelAllImagesInteractor(repository, this);
        allImagesInteractor.execute();
    }

    public List<String> getImages() {
        return images;
    }

    @Override
    public void handle(List<String> images) {
        this.images = images;
    }
}
