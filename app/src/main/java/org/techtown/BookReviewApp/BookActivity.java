package org.techtown.BookReviewApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import static org.techtown.BookReviewApp.InputActivity.booklist;

public class BookActivity extends AppCompatActivity {
    BookActivity bookActivity = BookActivity.this;
    BookAdapter adapter;
    Button inputButton2;
    Button mainButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        final RecyclerView recyclerView = findViewById(R.id.recycle);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new BookAdapter(booklist);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new BookAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos, String title, String author, String inside) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);

                title = adapter.items.get(pos).getTitle();
                author = adapter.items.get(pos).getAuthor();
                inside = adapter.items.get(pos).getInside();

                intent.putExtra("title", title);
                intent.putExtra("author", author);
        intent.putExtra("inside", inside);
        startActivity(intent);
    }
});


        inputButton2 = findViewById(R.id.inputButton2);
        inputButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InputActivity.class);
                startActivity(intent);
                bookActivity.finish();
            }
        });

        mainButton2 = findViewById(R.id.mainButton2);
        mainButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                bookActivity.finish();
            }
        });

    }


}
