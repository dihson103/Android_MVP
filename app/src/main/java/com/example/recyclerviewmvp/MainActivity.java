package com.example.recyclerviewmvp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemsInterface {

    private static final int MY_REQUEST_CODE = 1000;
    private static final int MY_REQUEST_UPDATE = 1111;
    public List<Item> items;
    Button addNewBtn;
    RecyclerView recyclerView;
    private ItemPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        addNewBtn = findViewById(R.id.btn_add);
        presenter = new ItemPresenter(this);
        items = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items, this));

        addNewBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, InputActivity.class);
            startActivityForResult(intent, MY_REQUEST_CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String email = data.getStringExtra("key_email");
        String name = data.getStringExtra("key_name");
        int index = data.getIntExtra("key_index", -1);

        if(MY_REQUEST_CODE == requestCode && resultCode == RESULT_OK){
            presenter.addNewItem(new Item(name, email, R.drawable.haha));
        } else if (MY_REQUEST_UPDATE == requestCode && resultCode == RESULT_OK && index != -1) {
            presenter.update(index, new Item(name, email, R.drawable.haha));
        }
    }

    @Override
    public void addNewItem(Item item) {
        items.add(item);
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items, this));
    }

    @Override
    public void deleteItem(int index) {
        items.remove(index);
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items, this));
    }

    @Override
    public void goToUpdate(int index) {
        Intent intent = new Intent(this, InputActivity.class);
        intent.putExtra("key_index", index);
        intent.putExtra("key_name", items.get(index).getName());
        intent.putExtra("key_email", items.get(index).getEmail());
        startActivityForResult(intent, MY_REQUEST_UPDATE);
    }

    @Override
    public void updateItem(int index, Item item) {
        items.get(index).setName(item.getName());
        items.get(index).setEmail(item.getEmail());
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items, this));
    }
}