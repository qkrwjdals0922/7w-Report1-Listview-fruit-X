package com.pjm0922;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> items;
    ArrayAdapter<String> adapter;
    ListView listView;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Report1");

        listView = findViewById(android.R.id.list);
        items = new ArrayList<>();
        items.add("사과");
        items.add("배");
        items.add("귤");
        items.add("바나나");
        items.add("복숭아");
        items.add("수박");
    }

    @Override
    protected void onResume() {
        super.onResume();
        {
            adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_multiple_choice, items);
            listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        }
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int i, long l) {
                String mes = "" + items.get(i);
                Toast.makeText(getBaseContext(), mes, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void mOnClick(View v) {
        EditText editText = findViewById(R.id.EDT_name);
        switch (v.getId()) {
            case R.id.add:
                String text = editText.getText().toString();
                if (text.length() != 0) {
                    items.add(text);
                    editText.setText("");
                    adapter.notifyDataSetChanged();
                }
                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;

    }

    private void all_O() {
        for (int i = 0; i < arrayList.size(); i++) {
            listView.setItemChecked(i, true);
        }
    }

    private void all_X() {
        for (int i = 0; i < arrayList.size(); i++) {
            listView.setItemChecked(i, false);
        }
    }

    private void exit() {
        finish();
    }
}