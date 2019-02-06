package ru.sberbank.lesson11.task.gallery.presentation.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import java.util.List;

import ru.sberbank.lesson11.task.gallery.data.repository.GalleryRepositoryImpl;
import ru.sberbank.lesson11.task.gallery.domain.interactor.usecase.GelAllImagesInteractor;
import ru.sberbank.lesson11.task.gallery.domain.repository.GalleryRepository;
import ru.sberbank.lesson11.task.gallery.presentation.resolvers.GalleryContentResolver;

public class GalleryViewModel extends AndroidViewModel {
    //private LiveData<List<Drawable>> images;
    private List<String> images;

    public GalleryViewModel(@NonNull Application application) {
        super(application);
        /*GalleryRepository repository = new GalleryRepositoryImpl(application.getApplicationContext());
        GelAllImagesInteractor allImagesInteractor = new GelAllImagesInteractor(repository);
        allImagesInteractor.execute();*/
        GalleryContentResolver contentResolver = new GalleryContentResolver(application.getApplicationContext().getContentResolver());
        images = contentResolver.getAll();
    }

    public List<String> getImages() {
        return images;
    }

    /*public LiveData<List<Drawable>> getImages() {
        return images;
    }*/
}
