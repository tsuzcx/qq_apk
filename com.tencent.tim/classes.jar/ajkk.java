import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.multicard.MultiCardRootLayout;
import com.tencent.mobileqq.multicard.MultiCardRootLayout.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FitSystemWindowsRelativeLayout.b;
import java.lang.ref.WeakReference;

public class ajkk
  implements FitSystemWindowsRelativeLayout.b
{
  int mActivePointerId;
  float mInitialMotionX;
  float mInitialMotionY;
  float mLastMotionX;
  float mLastMotionY;
  final int mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(this.c.getContext()));
  
  public ajkk(MultiCardRootLayout paramMultiCardRootLayout) {}
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    MultiCardRootLayout.a(this.c, false);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      if (MultiCardRootLayout.a(this.c) != null)
      {
        MultiCardRootLayout.a locala = (MultiCardRootLayout.a)MultiCardRootLayout.a(this.c).get();
        if (locala != null) {
          MultiCardRootLayout.a(this.c, locala.al(paramMotionEvent));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("placeholder", 2, "onInterceptTouchEvent() called with: ev = [" + paramMotionEvent + "], intercept = " + MultiCardRootLayout.a(this.c));
      }
      return MultiCardRootLayout.a(this.c);
      float f1 = paramMotionEvent.getX();
      this.mInitialMotionX = f1;
      this.mLastMotionX = f1;
      f1 = paramMotionEvent.getY();
      this.mInitialMotionY = f1;
      this.mLastMotionY = f1;
      this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      continue;
      int i = this.mActivePointerId;
      if (i != -1)
      {
        i = MotionEventCompat.findPointerIndex(paramMotionEvent, i);
        if ((i >= 0) && (i <= paramMotionEvent.getPointerCount() - 1))
        {
          float f2 = MotionEventCompat.getX(paramMotionEvent, i);
          f1 = Math.abs(f2 - this.mInitialMotionX);
          float f3 = MotionEventCompat.getY(paramMotionEvent, i) - this.mLastMotionY;
          float f4 = Math.abs(f3);
          if ((f4 > this.mTouchSlop) && (f4 * 0.5F > f1))
          {
            MultiCardRootLayout.a(this.c, false);
            if (f3 > 0.0F) {}
            for (f1 = this.mInitialMotionY + this.mTouchSlop;; f1 = this.mInitialMotionY - this.mTouchSlop)
            {
              this.mLastMotionY = f1;
              this.mLastMotionX = f2;
              break;
            }
          }
          if (f1 > this.mTouchSlop) {
            MultiCardRootLayout.a(this.c, true);
          } else if (QLog.isColorLevel()) {
            QLog.d("placeholder", 2, "onInterceptTouchEvent() called with: ev = [" + paramMotionEvent + "] do nothing");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajkk
 * JD-Core Version:    0.7.0.1
 */