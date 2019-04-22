package com.example.good;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guoGuangYao();

    }

    @Deprecated
    private void guoGuangYao(){
        Toast.makeText(this,"郭光耀",Toast.LENGTH_SHORT).show();
    }
}
