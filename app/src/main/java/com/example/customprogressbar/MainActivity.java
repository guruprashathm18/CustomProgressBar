package com.example.customprogressbar;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    ProgressBar progressBar1;

    ProgressBar progressBar3;

    int progressValue=0;

    Button button1;
    Button button2;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar1 = (ProgressBar) findViewById(R.id.progressBar1);
        progressBar3 = (ProgressBar) findViewById(R.id.progressBar3);
        button1 = (Button) findViewById(R.id.add);
        button2 = (Button) findViewById(R.id.sub);





        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(progressValue<100)
                {
                    progressValue+=5;
                    progressBar1.setVisibility(View.GONE);
                    progressBar3.setVisibility(View.GONE);
                    progressBar.setProgress(progressValue);
                    progressBar1.setProgress(progressValue);
                       // progressBar1.setProgress(progressValue);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(progressValue>0)
                {
                    progressValue-=5;
                    if(progressValue<=0)progressBar1.setVisibility(View.GONE);
                    if( (progressValue>0 && progressValue<=5) &&  progressBar1.getVisibility() == View.VISIBLE){
                        progressBar1.setProgress(120-60);
                    }
                    if(progressValue == 10) {
                        progressBar1.setProgress(120);
                        progressBar1.setVisibility(View.VISIBLE);
                        progressBar3.setVisibility(View.GONE);
                    }

                    if(progressValue > 10 && progressValue == 15) {
                        progressBar3.setVisibility(View.VISIBLE);
                    }
                    else progressBar.setProgress(progressValue);
                  //  progressBar1.setProgress(progressValue);}
                }
            }
        });

    }
}