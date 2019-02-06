package ru.sberbank.lesson11.task.gallery.domain.interactor.usecase;

import ru.sberbank.lesson11.task.gallery.domain.interactor.Interactor;
import ru.sberbank.lesson11.task.gallery.domain.repository.GalleryRepository;

public class GelAllImagesInteractor implements Interactor {
    private GalleryRepository repository;

    public GelAllImagesInteractor(GalleryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getAll();
    }
}
