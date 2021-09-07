package com.example.prework1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> items;

    Button addbut;
    EditText itemadd;
    RecyclerView rvitems;
    ItemsAdapter itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addbut = findViewById(R.id.addbut);
        itemadd = findViewById(R.id.itemadd);
        rvitems = findViewById(R.id.rvitems);

        loadItems();

        ItemsAdapter.OnLongClickListener onLongClickListener = new ItemsAdapter.OnLongClickListener() {
            @Override
            public void onItemLongClicked(int position) {
                @Override
                public void onItemLongClicked(int position) {
                    // delete the item from model
                    items.remove(position);
                    // notifiy the adapter
                    itemsAdapter.notifyItemRemoved(position);
                    Toast.makeText(getApplicationContext(), "Item was removed", Toast.LENGTH_SHORT).show();
                    saveItems();
                }
        };
        final ItemsAdapter itemsAdapter;
        itemsAdapter = new ItemsAdapter(items);
        rvitems.setAdapter(itemsAdapter);
        rvitems.setLayoutManager(new LinearLayoutManager(this));

        addbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String todoItem = itemadd.getText().toString();
                // Add item to the model
                items.add(todoItem);
                // Notifiy Adapter that an item is inserted
                itemsAdapter.notifyItemInserted(items.size()-1);
                itemadd.setText("");
                Toast.makeText(getApplicationContext(), "Item was added", Toast.LENGTH_SHORT).show();
                saveItems();
            }
        });
    }
    private File getDataFile(){
        return new File(getFilesDir(), "data.txt");
    }
    // This function will load items by reading every line of the data file
    private void loadItems(){
        try {
            items = new ArrayList<>(FileUtils.readLines(getDataFile(), Charset.defaultCharset()));
        } catch (IOException e) {
            Log.e("MainActivity", "Error reading items", e);
            items = new ArrayList<>();
        }
    }
    // This functopn saves items by writing them into the data file
    private void saveItems(){
        try {
            FileUtils.writeLines(getDataFile(), items);
        } catch (IOException e) {
            Log.e("MainActivity", "Error reading items", e);
        }
    }
}

    private void loadItems() {
    }

