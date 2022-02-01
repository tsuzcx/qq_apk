import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;

public class alwq
  implements GLGestureListener
{
  private ViewPager mViewPager;
  
  public alwq(ViewPager paramViewPager)
  {
    this.mViewPager = paramViewPager;
  }
  
  public int onGetPriority()
  {
    return 1002;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = paramMotionEvent.getPointerCount();
    paramMotionEvent.getAction();
    if ((i == 1) && (!paramBoolean) && (this.mViewPager != null) && (this.mViewPager.isShown())) {}
    try
    {
      this.mViewPager.onTouchEvent(paramMotionEvent);
      if ((i != 2) || (!paramBoolean) || (this.mViewPager == null) || (!this.mViewPager.isShown())) {}
    }
    catch (Exception localException)
    {
      try
      {
        if (GLGestureProxy.getInstance().checkSecendFinger(paramMotionEvent))
        {
          paramMotionEvent = GLGestureProxy.getInstance().getSecendFingerMotionEvent(paramMotionEvent);
          this.mViewPager.onTouchEvent(paramMotionEvent);
          paramMotionEvent.recycle();
        }
        return false;
        localException = localException;
        localException.printStackTrace();
      }
      catch (Exception paramMotionEvent)
      {
        for (;;)
        {
          paramMotionEvent.printStackTrace();
        }
      }
    }
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.mViewPager = paramViewPager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alwq
 * JD-Core Version:    0.7.0.1
 */