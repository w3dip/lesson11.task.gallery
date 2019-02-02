package ru.sberbank.lesson11.task.gallery.domain.interactor;

public interface Callback<T> {
    void handle(T value);
}
