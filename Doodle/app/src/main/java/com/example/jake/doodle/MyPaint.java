package com.example.jake.doodle;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by Jake on 11/3/2016.
 */

public class MyPaint {
    public Path path;
    public Paint paint;

    public MyPaint() {
        path = new Path();
        paint = new Paint();

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(50);
        paint.setAntiAlias(true);
        paint.setAlpha(50);
        paint.setStyle(Paint.Style.STROKE);
    }

    public MyPaint(MyPaint oldPaint) {
        path = new Path();
        paint = new Paint();

        paint.setColor(oldPaint.paint.getColor());
        paint.setStrokeWidth(oldPaint.paint.getStrokeWidth());
        paint.setAlpha(oldPaint.paint.getAlpha());
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
    }
}
