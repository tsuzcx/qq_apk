package cooperation.qzone;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.TopGestureDetector;

public class QZoneTopGestureLayout
  extends TopGestureLayout
{
  private static boolean dnZ = true;
  private static boolean doa = true;
  
  public QZoneTopGestureLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public QZoneTopGestureLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static void WI(boolean paramBoolean)
  {
    doa = paramBoolean;
  }
  
  public static void setBackEnabled(boolean paramBoolean)
  {
    dnZ = paramBoolean;
  }
  
  public void init(Context paramContext)
  {
    dnZ = true;
    doa = true;
    this.mTopGestureDetector = new GestureDetector(paramContext, new a(paramContext), new Handler(Looper.getMainLooper()));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!doa) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  class a
    extends TopGestureLayout.TopGestureDetector
  {
    a(Context paramContext)
    {
      super(paramContext);
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
        return false;
      }
      if (!QZoneTopGestureLayout.dnZ) {
        QZoneTopGestureLayout.b(QZoneTopGestureLayout.this, -1);
      }
      if (QZoneTopGestureLayout.a(QZoneTopGestureLayout.this)) {
        return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      paramFloat2 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      float f = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat2);
      if (QZoneTopGestureLayout.a(QZoneTopGestureLayout.this, 1))
      {
        if ((paramFloat2 < 0.0F) && (f < 0.5F) && (QZoneTopGestureLayout.this.mOnFlingGesture != null) && (paramFloat1 > 500.0F))
        {
          QZoneTopGestureLayout.c(QZoneTopGestureLayout.this, -1);
          QZoneTopGestureLayout.this.mOnFlingGesture.flingLToR();
          return true;
        }
      }
      else if ((QZoneTopGestureLayout.b(QZoneTopGestureLayout.this, 0)) && (paramFloat2 > 0.0F) && (f < 0.5F) && (QZoneTopGestureLayout.this.mOnFlingGesture != null) && (-1.0F * paramFloat1 > 500.0F))
      {
        QZoneTopGestureLayout.d(QZoneTopGestureLayout.this, -1);
        QZoneTopGestureLayout.this.mOnFlingGesture.flingRToL();
        return true;
      }
      return false;
    }
    
    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if (!QZoneTopGestureLayout.dnZ) {
        QZoneTopGestureLayout.a(QZoneTopGestureLayout.this, -1);
      }
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneTopGestureLayout
 * JD-Core Version:    0.7.0.1
 */