package com.tencent.qqmail.activity.media;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.view.imageview.QMGestureImageView;

public class ImageViewPager
  extends ViewPager
{
  private static final String TAG = "ImageViewPager";
  private PointF last;
  private int mInChildViewType;
  private PointF mPagerDownPointer = null;
  
  public ImageViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private float[] handleMotionEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
    case 0: 
      for (;;)
      {
        return null;
        this.last = new PointF(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
      }
    }
    paramMotionEvent = new PointF(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
    return new float[] { paramMotionEvent.x - this.last.x, paramMotionEvent.y - this.last.y };
  }
  
  private int inChildView(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent != null) {
      try
      {
        paramMotionEvent = handleMotionEvent(paramMotionEvent);
        QMGestureImageView localQMGestureImageView = ((ImagePagerAdapter)getAdapter()).getGestureImageView();
        if ((paramMotionEvent == null) || (localQMGestureImageView == null)) {
          break label159;
        }
        if ((localQMGestureImageView != null) && (paramMotionEvent != null) && (paramMotionEvent[0] > 0.0F) && ((int)(localQMGestureImageView.getScaledWidth() / 2 - localQMGestureImageView.getImageX()) > 0)) {
          return -1;
        }
        if ((localQMGestureImageView != null) && (paramMotionEvent != null) && (paramMotionEvent[0] < 0.0F))
        {
          float f1 = localQMGestureImageView.getScaledWidth() / 2;
          float f2 = localQMGestureImageView.getImageX();
          int i = localQMGestureImageView.getWidth();
          if (f1 + f2 - i > 20.0F) {
            return 1;
          }
        }
      }
      catch (Exception paramMotionEvent)
      {
        QMLog.log(6, "ImageViewPager", "" + paramMotionEvent.getMessage());
        return 0;
      }
    } else {
      return 0;
    }
    label159:
    return 0;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    this.mInChildViewType = inChildView(paramMotionEvent);
    boolean bool1;
    if ((paramMotionEvent.getAction() & 0xFF) == 1) {
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
    }
    do
    {
      do
      {
        return bool1;
        if ((paramMotionEvent.getAction() & 0xFF) == 0) {
          this.mPagerDownPointer = null;
        }
        bool1 = bool2;
      } while (this.mInChildViewType != 0);
      bool1 = bool2;
    } while (paramMotionEvent.getPointerCount() > 1);
    if (this.mPagerDownPointer == null) {
      this.mPagerDownPointer = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
    }
    try
    {
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
      return bool1;
    }
    catch (Exception paramMotionEvent)
    {
      QMLog.log(5, "ImageViewPager", "onInterceptTouchEvent: " + paramMotionEvent.getMessage());
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.ImageViewPager
 * JD-Core Version:    0.7.0.1
 */