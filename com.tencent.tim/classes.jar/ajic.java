import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.multiaio.MultiAIOItemFragment;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FitSystemWindowsRelativeLayout.b;

public class ajic
  implements FitSystemWindowsRelativeLayout.b
{
  int mActivePointerId;
  float mInitialMotionX;
  float mInitialMotionY;
  float mLastMotionX;
  float mLastMotionY;
  final int mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(this.this$0.getActivity()));
  
  public ajic(MultiAIOItemFragment paramMultiAIOItemFragment) {}
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOItemFragment", 2, "onInterceptTouchEvent() called with: ev = [" + paramMotionEvent + "], intercept = " + bool1);
      }
      return bool1;
      float f1 = paramMotionEvent.getX();
      this.mInitialMotionX = f1;
      this.mLastMotionX = f1;
      f1 = paramMotionEvent.getY();
      this.mInitialMotionY = f1;
      this.mLastMotionY = f1;
      this.mActivePointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      bool1 = bool2;
      continue;
      int i = this.mActivePointerId;
      bool1 = bool2;
      if (i != -1)
      {
        i = MotionEventCompat.findPointerIndex(paramMotionEvent, i);
        bool1 = bool2;
        if (i >= 0)
        {
          bool1 = bool2;
          if (i <= paramMotionEvent.getPointerCount() - 1)
          {
            float f2 = MotionEventCompat.getX(paramMotionEvent, i);
            f1 = Math.abs(f2 - this.mInitialMotionX);
            float f3 = MotionEventCompat.getY(paramMotionEvent, i) - this.mLastMotionY;
            float f4 = Math.abs(f3);
            if ((f4 > this.mTouchSlop) && (f4 * 0.5F > f1)) {
              if (f3 > 0.0F)
              {
                f1 = this.mInitialMotionY + this.mTouchSlop;
                label250:
                this.mLastMotionY = f1;
                this.mLastMotionX = f2;
                bool1 = false;
              }
            }
            for (;;)
            {
              MultiAIOBaseViewPager localMultiAIOBaseViewPager = MultiAIOItemFragment.a(this.this$0);
              bool2 = bool1;
              if (localMultiAIOBaseViewPager != null)
              {
                bool2 = bool1;
                if (localMultiAIOBaseViewPager.getCurrentItem() != MultiAIOItemFragment.a(this.this$0)) {
                  bool2 = true;
                }
              }
              bool1 = bool2;
              break;
              f1 = this.mInitialMotionY - this.mTouchSlop;
              break label250;
              if (f1 > this.mTouchSlop)
              {
                bool1 = true;
              }
              else
              {
                if (QLog.isColorLevel()) {
                  QLog.d("MultiAIOItemFragment", 2, "onInterceptTouchEvent() called with: ev = [" + paramMotionEvent + "] do nothing");
                }
                bool1 = false;
              }
            }
            bool1 = true;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajic
 * JD-Core Version:    0.7.0.1
 */