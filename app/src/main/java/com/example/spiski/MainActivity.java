package com.example.spiski;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<State> states = new ArrayList<State>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // начальная инициализация списка
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);
        // определяем слушателя нажатия элемента в списке
        StateAdapter.OnStateClickListener stateClickListener = new StateAdapter.OnStateClickListener() {
            @Override
            public void onStateClick(State state, int position) {

                Toast.makeText(getApplicationContext(), "Был выбран пункт " + state.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        };
        // создаем адаптер
        StateAdapter adapter = new StateAdapter(this, states, stateClickListener);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
    }
    private void setInitialData(){

        states.add(new State ("Nissan Skyline GTR", "Skyline славится своим мощным 2,6-литровым рядным шестицилиндровым двигателем.", R.drawable.nissan));
        states.add(new State ("Ford Mustang", "Cпортивное авто с длинным капотом, небольшой кабиной, фастбэком и маленьким багажником.", R.drawable.ford));
        states.add(new State ("Lada Priora", "Мощный двигатель и отличная разгонная динамика, доступная стоимость авто, большие возможности для тюнинга машины.", R.drawable.lada));
        states.add(new State ("Poscshe 911", "Легендарная модель 911 с высокой максимальной скоростью", R.drawable.porche));
        states.add(new State ("Chevrolet Camaro", "Американский маслкар, выпускающийся подразделением Chevrolet корпорации General Motors с 1966 года.", R.drawable.chevrolet));
    }

    
}