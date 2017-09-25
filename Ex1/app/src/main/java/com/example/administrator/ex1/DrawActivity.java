package com.example.administrator.ex1;

import android.content.DialogInterface;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

public class DrawActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG =DrawActivity.class.toString() ;
    private ImageView ivPickColour;
    private ImageView ivDone;
    private int CurrentColour= 0xf28e2b;
    private RadioGroup radioGroup;
    private int currentSize=10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        setupUI();
        adddListener();
        
    }

    private void adddListener() {
        ivPickColour.setOnClickListener(this);
        ivDone.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.thin: {
                        currentSize=5;
                        break;
                    }
                    case R.id.Med: {
                        currentSize =10;
                        break;
                    }
                    case R.id.Strong: {
                        currentSize =15;
                        break;
                    }
                }
                Log.d(TAG, "onCheckedChanged:" +currentSize);

            }
        });

    }

    private void setupUI() {
        ivPickColour = (ImageView) findViewById(R.id.iv_pick_colour);
        ivPickColour.setColorFilter(CurrentColour);
        ivDone = (ImageView) findViewById(R.id.iv_done);
        radioGroup= (RadioGroup) findViewById(R.id.gr_pen_size);
        radioGroup.check(R.id.Med);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId() ){
            case R.id.iv_done: {
                break;
            }
            case R.id.iv_pick_colour: {
                pickColour();
                break;
            }
        }

    }

    private void pickColour() {
        ColorPickerDialogBuilder
                .with(this)
                .setTitle("Choose your colour")
                .initialColor(CurrentColour)
                .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                .density(12)
                .setPositiveButton("ok", new ColorPickerClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, Integer[] integers) {
                        ivPickColour.setColorFilter(i);
                        CurrentColour=i;
                    }
                })
                .build()
                .show();


    }

}
