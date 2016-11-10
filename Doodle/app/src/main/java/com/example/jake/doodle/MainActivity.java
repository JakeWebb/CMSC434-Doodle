package com.example.jake.doodle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    protected static boolean drawerOpen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button clearButton = (Button) findViewById(R.id.clearButton);
        clearButton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               final DoodleView canvas = (DoodleView) findViewById(R.id.canvas);
                                               canvas.clear();
                                           }
                                       }

        );

        Button undoButton = (Button) findViewById(R.id.undoButton);
        undoButton.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              final DoodleView canvas = (DoodleView) findViewById(R.id.canvas);
                                              canvas.undo();
                                          }
                                      }

        );

        Button redoButton = (Button) findViewById(R.id.redoButton);
        redoButton.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              final DoodleView canvas = (DoodleView) findViewById(R.id.canvas);
                                              canvas.redo();
                                          }
                                      }

        );

        SeekBar widthBar = (SeekBar) findViewById(R.id.widthSeekBar);
        widthBar.setProgress(50);
        widthBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                DoodleView canvas = (DoodleView) findViewById(R.id.canvas);
                int width = seekBar.getProgress();
                canvas.updateWidth(width);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar opacityBar = (SeekBar) findViewById(R.id.opacitySeekBar);
        opacityBar.setProgress(50);
        opacityBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                DoodleView canvas = (DoodleView) findViewById(R.id.canvas);
                int opacity = seekBar.getProgress();
                opacity = (int) ((double) opacity / 100 * 255);
                canvas.updateOpacity(opacity);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar redBar = (SeekBar) findViewById(R.id.redSeekBar);
        redBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                DoodleView canvas = (DoodleView) findViewById(R.id.canvas);
                int red = seekBar.getProgress();
                red = (int) ((double) red / 100 * 255);

                View preview = findViewById(R.id.previewPane);

                canvas.updateRed(red,preview);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        SeekBar greenBar = (SeekBar) findViewById(R.id.greenSeekBar);
        greenBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                DoodleView canvas = (DoodleView) findViewById(R.id.canvas);
                int green = seekBar.getProgress();
                green = (int) ((double) green / 100 * 255);
                View preview = findViewById(R.id.previewPane);
                canvas.updateGreen(green,preview);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar blueBar = (SeekBar) findViewById(R.id.blueSeekBar);
        blueBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                DoodleView canvas = (DoodleView) findViewById(R.id.canvas);
                int blue = seekBar.getProgress();
                blue = (int) ((double) blue / 100 * 255);
                View preview = findViewById(R.id.previewPane);
                canvas.updateBlue(blue,preview);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                drawerOpen = true;
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

                drawerOpen = false;
                invalidateOptionsMenu();
            }
        };


    }
}
