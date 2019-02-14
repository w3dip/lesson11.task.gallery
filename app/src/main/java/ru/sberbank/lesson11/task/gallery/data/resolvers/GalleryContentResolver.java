package ru.sberbank.lesson11.task.gallery.data.resolvers;

import android.content.ContentResolver;
import android.database.Cursor;

import com.google.common.collect.Lists;

import java.util.List;

import static android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
import static android.provider.MediaStore.MediaColumns.DATA;
import static android.provider.MediaStore.MediaColumns.DATE_ADDED;

public class GalleryContentResolver {
    private List<String> images = Lists.newArrayList();
    private String[] projection = { DATA };
    private ContentResolver cr;

    public GalleryContentResolver(ContentResolver cr) {
        this.cr = cr;
    }

    public List<String> getAll() {
        try (Cursor cursor = cr.query(EXTERNAL_CONTENT_URI, projection, null, null, DATE_ADDED + " DESC")) {
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    images.add(cursor.getString(cursor.getColumnIndexOrThrow(DATA)));
                }
            }
        }
        return images;
    }
}
