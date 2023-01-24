package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import com.example.myapplication.Tile;
import com.example.myapplication.Bird;

import com.example.myapplication.R;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private final Bitmap background;
    private static final int FPS = 60;
    private SurfaceHolder surfaceHolder;
    private DrawThread drawThread;
    private Bird bird;
    private Tile pipe;
    private final Paint paint = new Paint();




    public GameView(Context context) {
        super(context);
        background = BitmapFactory.decodeResource(context.getResources(), R.drawable.back);
        drawThread = new DrawThread();
        getHolder().addCallback(this);
    }

    private void init() {
        bird = new Bird(getContext(), 200, getHeight() / 2f);
        pipe = new Tile(getContext(), getHeight(), getWidth());
        pipe.points = 0;
    }

    private void gameOver(Canvas canvas) {
        paint.setColor(Color.RED);
        paint.setTextSize(80);
        canvas.drawText("Score: " + pipe.points + " points", 100, getHeight() / 2f, paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(50);
        paint.setFakeBoldText(true);
        canvas.drawText("-tap anywhere to restart-", 100, (getHeight() / 2f) + 100, paint);

    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        init();
        drawThread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }

    private void drawFrames (Canvas canvas) {
        Rect rect = new Rect(0, 0, getWidth(), getHeight());
        canvas.drawBitmap(background, null, rect, null);
        canvas.drawBitmap(bird.getSprite(), bird.x, bird.y, null);
        canvas.drawBitmap(pipe.getToppipe(), pipe.x, 0, null);
        canvas.drawBitmap(pipe.getBottompipe(), pipe.x, getHeight() - pipe.getBottompipe().getHeight(), null);
        paint.setColor(Color.BLACK);
        paint.setTextSize(100);
        canvas.drawText(pipe.points + "", getWidth() - 150, 80, paint);

    }

    private void update(Canvas canvas) {
        bird.update();
        pipe.update();
        if (pipe.isCollision(bird) || bird.y <= 0 || bird.y >= getHeight()) {
            drawThread.running = false;
            gameOver(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        bird.fly();
        if (!drawThread.running) {
            drawThread = new DrawThread();
            init();
            drawThread.start();
        }
        return super.onTouchEvent(event);
    }

    private class DrawThread extends Thread {
        private volatile boolean running = true;

        @Override
        public void run() {
            Canvas canvas;
            while(running) {
                canvas = surfaceHolder.lockCanvas();
                try {
                    sleep(1000 / FPS);
                    drawFrames(canvas);
                    update(canvas);
                } catch (Exception e) {
                    Log.e("RRR", "run", e);
                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }

}
