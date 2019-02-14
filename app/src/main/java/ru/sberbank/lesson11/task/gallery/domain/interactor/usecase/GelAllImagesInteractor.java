package ru.sberbank.lesson11.task.gallery.domain.interactor.usecase;

import java.util.List;

import ru.sberbank.lesson11.task.gallery.domain.interactor.Callback;
import ru.sberbank.lesson11.task.gallery.domain.interactor.Interactor;
import ru.sberbank.lesson11.task.gallery.domain.repository.GalleryRepository;

public class GelAllImagesInteractor implements Interactor {
    private GalleryRepository repository;
    private Callback<List<String>> callback;

    public GelAllImagesInteractor(GalleryRepository repository, Callback<List<String>> callback) {
        this.repository = repository;
        this.callback = callback;
    }

    @Override
    public void execute() {
        callback.handle(repository.getAll());
    }
}
