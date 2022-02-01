package cooperation.vip.ad;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.View;

public class AnimationDrawableProxyView
  extends View
{
  private View mDelegateView;
  
  public AnimationDrawableProxyView(Context paramContext, View paramView, Drawable paramDrawable)
  {
    super(paramContext);
    this.mDelegateView = paramView;
    setBackgroundDrawable(paramDrawable);
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    this.mDelegateView.invalidate();
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    long l = SystemClock.uptimeMillis();
    this.mDelegateView.postDelayed(paramRunnable, paramLong - l);
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    this.mDelegateView.removeCallbacks(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.vip.ad.AnimationDrawableProxyView
 * JD-Core Version:    0.7.0.1
 */