package ru.sberbank.lesson11.task.gallery.domain.mapper;

public interface Mapper<T,V> {
    V map(T from);
}
