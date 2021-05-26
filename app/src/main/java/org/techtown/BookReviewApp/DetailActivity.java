package org.techtown.BookReviewApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    DetailActivity detailActivity = DetailActivity.this;
    Button finishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView title_inform = findViewById(R.id.title_inform);
        TextView author_inform = findViewById(R.id.author_inform);
        TextView inside_inform = findViewById(R.id.inside_inform);

        inside_inform.setMovementMethod(new ScrollingMovementMethod());

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String author = intent.getStringExtra("author");
        String inside = intent.getStringExtra("inside");

        title_inform.setText(title);
        author_inform.setText(author);
        inside_inform.setText(inside);

        finishButton = findViewById(R.id.finishButton);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                detailActivity.finish();
            }
        });
    }
}
