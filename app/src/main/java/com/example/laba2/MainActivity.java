package com.example.laba2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final int REQUEST_CODE_PHOTO = 1;
    private final int REQUEST_CODE_GALLERY = 100;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Аватарка
        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.led_iv_sm);

        //Кнопка - выбор из галереи приложения
        //Активити с явным Намерением, а так же с возвратом результата
        findViewById(R.id.Choise).setOnClickListener(v->{
            Intent i = new Intent(this, Choise.class);
            startActivityForResult(i, REQUEST_CODE_GALLERY);
        });

        //Кнопка - сделать фото
        //Активити с неявным намеринием и возвтратом резулльтата
        findViewById(R.id.Photo).setOnClickListener(v->{
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i, REQUEST_CODE_PHOTO);
        });
    }

    //Обработчиик возвратов результатов
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Если код действия от Фотоопарата
        if (requestCode == REQUEST_CODE_PHOTO && resultCode == RESULT_OK) {
            // Фотка сделана, извлекаем картинку
            Bitmap thumbnailBitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(thumbnailBitmap);
        }
        //Если код действия - выбор из галереи
        if (requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK) {
            if (data != null) {
                int Id = data.getIntExtra("result", 0);
                if (Id == 1)
                    imageView.setImageDrawable(getDrawable(R.drawable.led_iv_sm));
                else if (Id == 2)
                    imageView.setImageDrawable(getDrawable(R.drawable.led_vas_jk_nr));
                else if (Id == 3)
                    imageView.setImageDrawable(getDrawable(R.drawable.lseya_laugh_pio_norm));
            }
        }
    }
}
