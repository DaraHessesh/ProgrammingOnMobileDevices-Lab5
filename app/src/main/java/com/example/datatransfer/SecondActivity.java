package com.example.datatransfer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Второй layout
        setContentView(R.layout.activity_second);

        // Буфер для временного хранения строк
        String buffer = "";
        // Объект для обращения к полям текста
        TextView textView;

        // Закидываем данные из intent в строки
        // ФИО
        buffer = getIntent().getStringExtra("Name");
        textView = findViewById(R.id.textViewSecond_Name);
        textView.setText(buffer);

        // Год
        buffer = getIntent().getStringExtra("Year");
        textView = findViewById(R.id.textViewSecond_Birthday);
        textView.setText(buffer);

        // Статус
        buffer = getIntent().getStringExtra("Social");
        textView = findViewById(R.id.textViewSecond_Status);
        textView.setText(buffer);

        // Галочки
        buffer = getIntent().getStringExtra("Additions");
        textView = findViewById(R.id.textViewSecond_additions);
        textView.setText(buffer);

    }

}
