package com.example.jake.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.Queue;
import java.util.Stack;


/**
 * Created by Jake on 11/3/2016.
 */

public class DoodleView extends View {

    private Stack<MyPaint> currLines = new Stack<MyPaint>();
    private Stack<MyPaint> redoLines = new Stack<MyPaint>();
    MyPaint nextPaint = new MyPaint();

    public DoodleView(Context context) {
        super(context);
        init(null, 0);
    }

    public DoodleView(Context context, AttributeSet attr) {
        super(context, attr);
        init(attr,0);
    }

    public DoodleView(Context context, AttributeSet attr, int defStyle) {
        super(context, attr);
        init(attr,defStyle);
    }

    private void init(AttributeSet attr, int defStyle) {

        MyPaint firstPaint = new MyPaint();

    }


    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (MyPaint line : currLines) {
            canvas.drawPath(line.path,line.paint);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float touchX = motionEvent.getX();
        float touchY = motionEvent.getY();
        MyPaint currPaint;

        if (!MainActivity.drawerOpen) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    nextPaint.path.moveTo(touchX, touchY);
                    currLines.push(nextPaint);
                    break;
                case MotionEvent.ACTION_MOVE:
                    currPaint = currLines.pop();
                    currPaint.path.lineTo(touchX, touchY);
                    currLines.push(currPaint);
                    break;
                case MotionEvent.ACTION_UP:
                    MyPaint newNextPaint = new MyPaint(nextPaint);
                    nextPaint = newNextPaint;
                    break;
            }
        }
        invalidate();
        return true;
    }

    public void clear() {

        redoLines = new Stack<MyPaint>();
        currLines = new Stack<MyPaint>();
        invalidate();
    }

    public void undo() {

        if (!currLines.isEmpty()) {
            MyPaint lastLine = currLines.pop();
            redoLines.push(lastLine);

            invalidate();
        }
    }

    public void redo() {

        if (!redoLines.isEmpty()) {
            MyPaint lastLine = redoLines.pop();
            currLines.push(lastLine);

            invalidate();
        }
    }


    public void updateWidth(int widthIn) {

        nextPaint.paint.setStrokeWidth(widthIn);
    }

    public void updateOpacity(int opacityIn) {

        nextPaint.paint.setAlpha(opacityIn);
    }

    public void updateRed(int redIn, View preview) {
        int currColor = nextPaint.paint.getColor();
        int newColor = Color.rgb(redIn,Color.green(currColor),Color.blue(currColor));
        nextPaint.paint.setColor(newColor);

        preview.setBackgroundColor(newColor);
    }

    public void updateGreen(int greenIn, View preview) {
        int currColor = nextPaint.paint.getColor();
        int newColor = Color.rgb(Color.red(currColor),greenIn,Color.blue(currColor));
        nextPaint.paint.setColor(newColor);


        preview.setBackgroundColor(newColor);
    }

    public void updateBlue(int blueIn, View preview) {
        int currColor = nextPaint.paint.getColor();
        int newColor = Color.rgb(Color.red(currColor),Color.green(currColor),blueIn);
        nextPaint.paint.setColor(newColor);

        preview.setBackgroundColor(newColor);
    }

}
