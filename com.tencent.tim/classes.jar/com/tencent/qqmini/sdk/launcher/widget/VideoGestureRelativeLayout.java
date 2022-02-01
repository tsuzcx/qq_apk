package com.tencent.qqmini.sdk.launcher.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class VideoGestureRelativeLayout
  extends FrameLayout
{
  private static final int BRIGHTNESS = 2;
  private static final int FF_REW = 3;
  private static final int NONE = 0;
  private static final String TAG = "gesturetest";
  private static final int VOLUME = 1;
  private boolean hasFF_REW = false;
  private GestureDetector mGestureDetector;
  private VideoPlayerOnGestureListener mOnGestureListener;
  private int mScrollMode = 0;
  private VideoGestureListener mVideoGestureListener;
  private int offsetX = 1;
  
  public VideoGestureRelativeLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public VideoGestureRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mOnGestureListener = new VideoPlayerOnGestureListener(this);
    this.mGestureDetector = new GestureDetector(paramContext, this.mOnGestureListener);
    this.mGestureDetector.setIsLongpressEnabled(false);
    setOnTouchListener(new VideoGestureRelativeLayout.1(this));
  }
  
  public void setVideoGestureListener(VideoGestureListener paramVideoGestureListener)
  {
    this.mVideoGestureListener = paramVideoGestureListener;
  }
  
  public static abstract interface VideoGestureListener
  {
    public abstract void onBrightnessGesture(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2);
    
    public abstract void onDoubleTapGesture(MotionEvent paramMotionEvent);
    
    public abstract void onDown(MotionEvent paramMotionEvent);
    
    public abstract void onEndFF_REW(MotionEvent paramMotionEvent);
    
    public abstract void onProgressGesture(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2);
    
    public abstract void onSingleTapGesture(MotionEvent paramMotionEvent);
    
    public abstract void onVolumeGesture(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2);
  }
  
  public class VideoPlayerOnGestureListener
    extends GestureDetector.SimpleOnGestureListener
  {
    private VideoGestureRelativeLayout videoGestureRelativeLayout;
    
    public VideoPlayerOnGestureListener(VideoGestureRelativeLayout paramVideoGestureRelativeLayout)
    {
      this.videoGestureRelativeLayout = paramVideoGestureRelativeLayout;
    }
    
    public boolean onContextClick(MotionEvent paramMotionEvent)
    {
      Log.d("gesturetest", "onContextClick: ");
      return true;
    }
    
    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      Log.d("gesturetest", "onDoubleTap: ");
      if (VideoGestureRelativeLayout.this.mVideoGestureListener != null) {
        VideoGestureRelativeLayout.this.mVideoGestureListener.onDoubleTapGesture(paramMotionEvent);
      }
      return super.onDoubleTap(paramMotionEvent);
    }
    
    public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
    {
      Log.d("gesturetest", "onDoubleTapEvent: ");
      return super.onDoubleTapEvent(paramMotionEvent);
    }
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      Log.d("gesturetest", "onDown: ");
      VideoGestureRelativeLayout.access$002(VideoGestureRelativeLayout.this, false);
      VideoGestureRelativeLayout.access$302(VideoGestureRelativeLayout.this, 0);
      if (VideoGestureRelativeLayout.this.mVideoGestureListener != null) {
        VideoGestureRelativeLayout.this.mVideoGestureListener.onDown(paramMotionEvent);
      }
      return true;
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      Log.d("gesturetest", "onFling: ");
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    
    public void onLongPress(MotionEvent paramMotionEvent)
    {
      Log.d("gesturetest", "onLongPress: ");
      super.onLongPress(paramMotionEvent);
    }
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      Log.d("gesturetest", "onScroll: e1:" + paramMotionEvent1.getX() + "," + paramMotionEvent1.getY());
      Log.d("gesturetest", "onScroll: e2:" + paramMotionEvent2.getX() + "," + paramMotionEvent2.getY());
      Log.d("gesturetest", "onScroll: X:" + paramFloat1 + "  Y:" + paramFloat2);
      switch (VideoGestureRelativeLayout.this.mScrollMode)
      {
      default: 
        return true;
      case 0: 
        Log.d("gesturetest", "NONE: ");
        if (Math.abs(paramFloat1) - Math.abs(paramFloat2) > VideoGestureRelativeLayout.this.offsetX)
        {
          VideoGestureRelativeLayout.access$302(VideoGestureRelativeLayout.this, 3);
          return true;
        }
        if (paramMotionEvent1.getX() < VideoGestureRelativeLayout.this.getWidth() / 2)
        {
          VideoGestureRelativeLayout.access$302(VideoGestureRelativeLayout.this, 2);
          return true;
        }
        VideoGestureRelativeLayout.access$302(VideoGestureRelativeLayout.this, 1);
        return true;
      case 1: 
        if (VideoGestureRelativeLayout.this.mVideoGestureListener != null) {
          VideoGestureRelativeLayout.this.mVideoGestureListener.onVolumeGesture(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        }
        Log.d("gesturetest", "VOLUME: ");
        return true;
      case 2: 
        if (VideoGestureRelativeLayout.this.mVideoGestureListener != null) {
          VideoGestureRelativeLayout.this.mVideoGestureListener.onBrightnessGesture(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        }
        Log.d("gesturetest", "BRIGHTNESS: ");
        return true;
      }
      if (VideoGestureRelativeLayout.this.mVideoGestureListener != null) {
        VideoGestureRelativeLayout.this.mVideoGestureListener.onProgressGesture(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      VideoGestureRelativeLayout.access$002(VideoGestureRelativeLayout.this, true);
      Log.d("gesturetest", "FF_REW: ");
      return true;
    }
    
    public void onShowPress(MotionEvent paramMotionEvent)
    {
      Log.d("gesturetest", "onShowPress: ");
      super.onShowPress(paramMotionEvent);
    }
    
    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      Log.d("gesturetest", "onSingleTapConfirmed: ");
      if (VideoGestureRelativeLayout.this.mVideoGestureListener != null) {
        VideoGestureRelativeLayout.this.mVideoGestureListener.onSingleTapGesture(paramMotionEvent);
      }
      return super.onSingleTapConfirmed(paramMotionEvent);
    }
    
    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      Log.d("gesturetest", "onSingleTapUp: ");
      return super.onSingleTapUp(paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.widget.VideoGestureRelativeLayout
 * JD-Core Version:    0.7.0.1
 */