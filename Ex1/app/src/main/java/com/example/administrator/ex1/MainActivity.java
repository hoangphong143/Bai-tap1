package com.example.administrator.ex1;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.toString();
    private FloatingActionButton fbNewNote;
    private SubActionButton btCameraNote;
    private SubActionButton btBlankNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setupUI();
        addListener();






    }

    private void addListener() {
        btCameraNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: camera");

            }
        });
        btBlankNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: blank");
                Intent intend = new Intent(MainActivity.this, DrawActivity.class);
                startActivity(intend);
            }
        });
    }

    private void setupUI() {
        fbNewNote= (FloatingActionButton) findViewById(R.id.fb_new_note);
        SubActionButton.Builder sabBuilder= new SubActionButton.Builder(this);
        btCameraNote = sabBuilder.setBackgroundDrawable (getResources().getDrawable(R.drawable.ic_photo_camera_black_24dp))
                .build();
        btBlankNote= sabBuilder.setBackgroundDrawable (getResources().getDrawable(R.drawable.ic_brush_black_24dp))
                .build();

        FloatingActionMenu floatingActionMenu=new FloatingActionMenu.Builder(this)
                .addSubActionView(btCameraNote)
                .addSubActionView(btBlankNote)
                .attachTo(fbNewNote)
                .build();
    }
}
