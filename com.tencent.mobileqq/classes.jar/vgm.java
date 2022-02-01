import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.view.View;

class vgm
  implements Drawable.Callback
{
  vgm(vgl paramvgl) {}
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    this.a.e();
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if (vgl.a(this.a) != null)
    {
      View localView = vgl.a(this.a).a();
      if (localView != null) {
        localView.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
      }
    }
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if (vgl.a(this.a) != null)
    {
      View localView = vgl.a(this.a).a();
      if (localView != null) {
        localView.unscheduleDrawable(paramDrawable, paramRunnable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgm
 * JD-Core Version:    0.7.0.1
 */