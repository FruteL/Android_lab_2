package com.example.laba2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class Choise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Объявление Кнопок-Картинок
        setContentView(R.layout.activity_choise);
        ImageButton im1 = findViewById(R.id.imageButton5);
        ImageButton im2 = findViewById(R.id.imageButton6);
        ImageButton im3 = findViewById(R.id.imageButton7);
        im1.setImageDrawable(getDrawable(R.drawable.led_iv_sm));
        im2.setImageDrawable(getDrawable(R.drawable.led_vas_jk_nr));
        im3.setImageDrawable(getDrawable(R.drawable.lseya_laugh_pio_norm));

        //Слушатели на кнопки
        im1.setOnClickListener(v->{
            Intent intent = new Intent();
            intent.putExtra("result", 1);
            setResult(RESULT_OK,intent);
            finish();
        });
        im2.setOnClickListener(v->{
            Intent intent = new Intent();
            intent.putExtra("result", 2);
            setResult(RESULT_OK,intent);
            finish();
        });
        im3.setOnClickListener(v->{
            Intent intent = new Intent();
            intent.putExtra("result", 3);
            setResult(RESULT_OK,intent);
            finish();
        });
    }
    //обработки на случай возврата
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        setResult(RESULT_CANCELED);
    }
}

