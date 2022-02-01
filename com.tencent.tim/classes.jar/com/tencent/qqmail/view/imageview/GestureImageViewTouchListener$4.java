package com.tencent.qqmail.view.imageview;

import android.util.Log;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;

class GestureImageViewTouchListener$4
  extends GestureDetector.SimpleOnGestureListener
{
  GestureImageViewTouchListener$4(GestureImageViewTouchListener paramGestureImageViewTouchListener, QMGestureImageView paramQMGestureImageView) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    Log.d("download", "onDoubleTap");
    GestureImageViewTouchListener.access$500(this.this$0, paramMotionEvent);
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    Log.d("download", "onLongPress");
    if (GestureImageViewTouchListener.access$700(this.this$0) != null) {
      GestureImageViewTouchListener.access$700(this.this$0).onLongClick(this.val$image);
    }
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (!GestureImageViewTouchListener.access$400(this.this$0))
    {
      Log.d("download", "onSingleTapConfirmed");
      if (GestureImageViewTouchListener.access$600(this.this$0) != null)
      {
        GestureImageViewTouchListener.access$600(this.this$0).onClick(this.val$image);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.imageview.GestureImageViewTouchListener.4
 * JD-Core Version:    0.7.0.1
 */