import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.tencent.mobileqq.loverzone.LoveZoneTabRedDotView;

public class aiwj
  implements Drawable.Callback
{
  public aiwj(LoveZoneTabRedDotView paramLoveZoneTabRedDotView) {}
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    this.b.invalidate();
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    this.b.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    this.b.unscheduleDrawable(paramDrawable, paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiwj
 * JD-Core Version:    0.7.0.1
 */