package com.tencent.qqmail.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;
import com.tencent.qqmail.utilities.log.QMLog;
import java.lang.reflect.Field;

public class NoSkipSeekBar
  extends SeekBar
{
  private static final String TAG = "NoSkipSeekBar";
  private boolean isDragging;
  
  public NoSkipSeekBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public NoSkipSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NoSkipSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean isWithinThumb(MotionEvent paramMotionEvent)
  {
    if (getThumb() == null) {
      return false;
    }
    return getThumb().getBounds().contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
  }
  
  public Drawable getThumb()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getThumb();
    }
    try
    {
      Object localObject = Class.forName("android.widget.AbsSeekBar").getDeclaredField("mThumb");
      ((Field)localObject).setAccessible(true);
      localObject = (Drawable)((Field)localObject).get(this);
      return localObject;
    }
    catch (Exception localException)
    {
      QMLog.log(5, "NoSkipSeekBar", "getThumb", localException);
    }
    return null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((!isEnabled()) || (getThumb() == null))
    {
      bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      if (!isWithinThumb(paramMotionEvent)) {
        break;
      }
      this.isDragging = true;
      return super.onTouchEvent(paramMotionEvent);
      this.isDragging = false;
      if (isWithinThumb(paramMotionEvent)) {
        return super.onTouchEvent(paramMotionEvent);
      }
      getThumb().getBounds();
      return true;
      if (!this.isDragging)
      {
        return true;
        this.isDragging = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.NoSkipSeekBar
 * JD-Core Version:    0.7.0.1
 */