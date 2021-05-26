package org.techtown.BookReviewApp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class InputActivity extends AppCompatActivity {
    static ArrayList<Book> booklist = new ArrayList<Book>();

    Activity InputActivity = InputActivity.this;
    EditText titleEdit;
    EditText authorEdit;
    EditText insideEdit;

    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        titleEdit = findViewById(R.id.titleEdit);
        authorEdit = findViewById(R.id.authorEdit);
        insideEdit = findViewById(R.id.insideEdit);

        saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(titleEdit.getText().toString().isEmpty()){
                    makeToast("제목을 적어주세요");
                }
                else if(authorEdit.getText().toString().isEmpty()){
                    makeToast("저자를 적어주세요");
                }
                else if(insideEdit.getText().toString().isEmpty()){
                    makeToast("내용을 적어주세요");
                }
                else{
                    String title = titleEdit.getText().toString();
                    String author = authorEdit.getText().toString();
                    String inside = insideEdit.getText().toString();

                    Book addBook = new Book(title,author,inside);
                    booklist.add(addBook);

                    Toast.makeText(getApplicationContext(),"저장되었습니다",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), BookActivity.class);
                    startActivity(intent);
                    InputActivity.finish();
                }
            }
        });
    }

    public void makeToast(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }
}
