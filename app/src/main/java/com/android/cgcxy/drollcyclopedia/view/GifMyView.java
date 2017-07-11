package com.android.cgcxy.drollcyclopedia.view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.io.InputStream;


/**
 * Created by chuangguo.qi on 2017/7/11.
 */

public class GifMyView extends View {

    private Movie movie;
    long mStart;
    private String TAG="GifMyView";
    private boolean isStartPlay=false;

    public GifMyView(Context context) {
        this(context,null);
    }

    public GifMyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public GifMyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (movie!=null){
            setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
        }
    }


    private int measureWidth(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        int result = movie.width();
        if (specMode == MeasureSpec.AT_MOST) {
            return result;
        } else if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        }
        Log.i(TAG, "measureWidth: "+result);
        return result;
    }

    private int measureHeight(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        int result = movie.height();
        if (specMode == MeasureSpec.AT_MOST) {
            return result;
        } else if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        }
        Log.i(TAG, "measureHeight: "+result);
        return result;
    }


    public void setPath(String path){

         movie = Movie.decodeFile(path);
         invalidate();
         Log.i(TAG, "setPath: ");
    }

    public void setBytes(byte[] bytes,int leng){

        movie=Movie.decodeByteArray(bytes,0,leng);
        invalidate();
    }

    public void setInputStream(InputStream inputStream){
        movie = Movie.decodeStream(inputStream);
        invalidate();
    }

    public void setStartPlay(){
        isStartPlay=true;
        mStart=0;
        invalidate();

    }
    public void setPusePlay(){
        isStartPlay=false;
        mStart=0;

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (movie==null){
            return;
        }
        int duration = movie.duration();
        long now = android.os.SystemClock.uptimeMillis();
        if(mStart == 0){
            mStart = now;
        }
        movie.setTime((int) ((now - mStart) % duration));
        movie.draw(canvas,0, 0);
        if (isStartPlay) {
            invalidate();
        }
    }
}
