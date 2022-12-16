package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    private final NewsItem[] news = new NewsItem[12];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        int news1 = R.drawable.news1;
        int news2 = R.drawable.news2;
        int news3 = R.drawable.news3;
        int news4 = R.drawable.news4;
        int news5 = R.drawable.news5;
        int news6 = R.drawable.news6;

        news[0] = new NewsItem("Сенсация на ЧМ-22", "Один из фаворитов турнира, сборная Бразилии, сенсационно вылетела в ¼ финала.", 15, news1, false);
        news[1] = new NewsItem("Голы в матче Бразилия - Хорватия", "Бразилия: Неймар(105+1′). Хорватия: Б.Петкович(117′)", 10, news1, false);
        news[2] = new NewsItem("Месси идёт за трофеем", "Аргентина обыграла Нидерланды в серии пенальти и вышла в полуфинал ЧМ-2022.", 121, news2, false);
        news[3] = new NewsItem("Голы в матче Аргентина - Нидерланды", "Голы. Аргентина: Н.Молина(35′), Л.Месси(П)(73′). Нидерланды: В.Вегхрост(83′, 90+11′)", 123, news2, false);
        news[4] = new NewsItem("Драма Криштиану Роналду", "Португалия проиграла Марокко в четвертьфинале Чемпионата Мира по футболу.", 5, news3, false);
        news[5] = new NewsItem("Голы в матче Португалия - Марокко", "Голы. Марокко: Ю.Эн-Несери(42′).", 13, news3, false);
        news[6] = new NewsItem("Франция в полуфинале!", "Франция подтвердила свой статус действующего чемпиона мира в игре против Англии.", 56, news4, false);
        news[7] = new NewsItem("Голы в матче Франция - Англия", "Голы. Франция: О.Тчуамени(17′), О.Жиру(78′). Англия: Г.Кейн(П)(54′)", 77, news4, false);
        news[8] = new NewsItem("Аргентина выходит в финал!", "Во вторник вечером Аргентина обыграла Хорватию со счётом 3:0. Лионель Месси в своём последнем чемпионате получит шанс выиграть долгожданный трофей.", 176, news5, false);
        news[9] = new NewsItem("Голы в матче Аргентина - Хорватия", "Голы. Аргентина: Л.Месси(П)(34′), Х.Альварес(39′, 69′).", 98, news5, false);
        news[10] = new NewsItem("О таком финале мы могли только мечтать...", "Франция и Мбаппе против Аргентины и Месси! Что может быть лучше! " +
                "Ну а Марокко сразится с Хорватией в матче за третье место.", 145, news6, false);
        news[11] = new NewsItem("Голы в матче Франция - Марокко", "Голы. Франция: Т.Эрнандес(5′), Р.К.Муани(79′).", 152, news6, false);


        binding.newsList.setAdapter(new MyAdapter(this, news));
    }



}