package com.example.datatransfer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // *** Переменные ***
    // Социальное положение, ставим по умолчанию на всякий случай
    public String SocialStatus = "Student";
    // Галочки
    // По умолчанию пусто
    // Если нажаты то записываем сюда
    public String CheckedBoxes = "";
    // Намерение (для переключения экранов)
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Для выбора статуса
    public void onRadioClick(View view) {
        // Switch не работает с R.id в новых версиях
        if (view.getId() == R.id.radioButton_Scholar){
            SocialStatus = "Школьник";
        } else if (view.getId() == R.id.radioButton_Student){
            SocialStatus = "Студент";
        } else if (view.getId() == R.id.radioButton_Worker){
            SocialStatus = "Рабочий";
        }
    }

    // Для нажатия на кнопку ОК
    public void onClick(View view) {
        // Создаем объекты для ФИО и года
        // ФИО
        EditText editTextName = findViewById(R.id.editText_Name);
        // Год
        EditText editTextYear = findViewById(R.id.editText_YearBirth);
        // Для статуса не создаем, будем получать
        // от функции onRadioClick

        // Для галочек тоже не создаем

        // Намерение использования второго экрана
        intent = new Intent(MainActivity.this, SecondActivity.class);

        // Закидываем данные в intent
        intent.putExtra("Name", editTextName.getText().toString());
        intent.putExtra("Year", editTextYear.getText().toString());
        intent.putExtra("Social", SocialStatus);
        intent.putExtra("Additions", CheckedBoxes);

        // Включаем второй экран
        startActivity(intent);
    }

    // При нажатии на галочки
    // Добавляем текст
    public void onClickCheck(View view) {
        CheckedBoxes = "";
        CheckBox box = findViewById(R.id.checkBox_Foreign);
        if (box.isChecked()){
            CheckedBoxes += box.getText().toString() + "\n";
        }
        box = findViewById(R.id.checkBox_Married);
        if (box.isChecked()){
            CheckedBoxes += box.getText().toString() + "\n";
        }

    }
}