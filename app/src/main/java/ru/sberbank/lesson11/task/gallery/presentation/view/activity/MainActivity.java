package ru.sberbank.lesson11.task.gallery.presentation.view.activity;

import android.Manifest;
import android.arch.lifecycle.ViewModelProviders;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.sberbank.lesson11.task.gallery.R;
import ru.sberbank.lesson11.task.gallery.presentation.view.adapter.GalleryAdapter;
import ru.sberbank.lesson11.task.gallery.presentation.viewmodel.GalleryViewModel;

public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 123;

    @BindView(R.id.gallery)
    RecyclerView recyclerGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        checkPermissions();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    takePhotos();
                }
                break;
        }
    }

    private void checkPermissions() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
        } else {
            takePhotos();
        }

    }

    private void takePhotos() {
        GalleryViewModel galleryViewModel = ViewModelProviders.of(this).get(GalleryViewModel.class);
        /*galleryViewModel.getImages().observe(this, gallery -> {
            GalleryAdapter adapter = new GalleryAdapter(this);
            adapter.setGallery(gallery);
            recyclerGallery.setAdapter(adapter);
            recyclerGallery.setLayoutManager(new GridLayoutManager(this, 4));
        });*/
        GalleryAdapter adapter = new GalleryAdapter(this);
        adapter.setGallery(galleryViewModel.getImages());
        recyclerGallery.setAdapter(adapter);
        recyclerGallery.setLayoutManager(new GridLayoutManager(this, 3));
    }
}
