import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;

class wmi
{
  private WeakReference<wmh> a;
  
  public wmi(wmh paramwmh)
  {
    this.a = new WeakReference(paramwmh);
  }
  
  @Nullable
  public wmh a()
  {
    return (wmh)this.a.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wmi
 * JD-Core Version:    0.7.0.1
 */