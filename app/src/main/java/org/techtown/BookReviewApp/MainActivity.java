package org.techtown.BookReviewApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button inputButton;
    Button informButton;
    private long backKeyPressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputButton = findViewById(R.id.inputButton);
        inputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InputActivity.class);
                startActivity(intent);
            }
        });

        informButton = findViewById(R.id.informButton);
        informButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BookActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        if(backKeyPressedTime == 0){
            Toast.makeText(MainActivity.this, "한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
            backKeyPressedTime = System.currentTimeMillis();
        }
        else{
            int second = (int) (System.currentTimeMillis() - backKeyPressedTime);

            if(second > 2000){
                Toast.makeText(MainActivity.this, "한번더 누르면 종료됩니다." , Toast.LENGTH_SHORT).show();
                backKeyPressedTime = 0;
            }
            else{
                moveTaskToBack(true);
                ActivityCompat.finishAffinity(this);
                Process.killProcess(Process.myPid());
                //프로세스와 백그라운드 인텐트 모든 내용을 종료시킴
            }
        }
    }
}
