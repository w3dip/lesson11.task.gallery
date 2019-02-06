package ru.sberbank.lesson11.task.gallery.presentation.resolvers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GalleryContentResolver {
    public static final Uri MEDIA_STORE_URI = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    private Cursor cursor;
    private List<String> images = new ArrayList<>();
    private String[] projection = { MediaStore.MediaColumns.DATA };
    private String sortOrder = MediaStore.Images.ImageColumns.DATE_ADDED + " DESC";
    private ContentResolver cr;
    private String path = null;

    public GalleryContentResolver(ContentResolver cr) {
        this.cr = cr;
    }

    public List<String> getAll() {
        cursor = cr.query(MEDIA_STORE_URI, projection, null, null, sortOrder);
        if (cursor != null) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            while (cursor.moveToNext()) {
                path = cursor.getString(column_index);
                images.add(path);
            }
            cursor.close();
        }
        return images;
    }
}
