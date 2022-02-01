package dov.com.qq.im.ae.mode;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class AECaptureModeSelectPager
  extends ViewPager
{
  private boolean disableScroll;
  
  public AECaptureModeSelectPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public AECaptureModeSelectPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (!this.disableScroll) && (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return (!this.disableScroll) && (super.onTouchEvent(paramMotionEvent));
  }
  
  public void setDisableScroll(boolean paramBoolean)
  {
    this.disableScroll = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.mode.AECaptureModeSelectPager
 * JD-Core Version:    0.7.0.1
 */