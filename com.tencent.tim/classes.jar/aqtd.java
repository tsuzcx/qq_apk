import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class aqtd
  implements Drawable.Callback
{
  aqtd(aqtc paramaqtc, aqtb.a.a parama) {}
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Aqtb$a$a != null) {
      this.jdField_a_of_type_Aqtb$a$a.invalidateDrawable(paramDrawable);
    }
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqtd
 * JD-Core Version:    0.7.0.1
 */