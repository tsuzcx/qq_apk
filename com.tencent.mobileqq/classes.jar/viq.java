import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.view.View;

class viq
  implements Drawable.Callback
{
  viq(vip paramvip) {}
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    this.a.e();
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if (vip.a(this.a) != null)
    {
      View localView = vip.a(this.a).a();
      if (localView != null) {
        localView.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
      }
    }
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if (vip.a(this.a) != null)
    {
      View localView = vip.a(this.a).a();
      if (localView != null) {
        localView.unscheduleDrawable(paramDrawable, paramRunnable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     viq
 * JD-Core Version:    0.7.0.1
 */