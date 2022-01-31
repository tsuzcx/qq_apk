import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.apollo.store.ApolloDiyTextFragment.AndroidBug5497Workaround;

public class ysr
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public ysr(ApolloDiyTextFragment.AndroidBug5497Workaround paramAndroidBug5497Workaround) {}
  
  public void onGlobalLayout()
  {
    ApolloDiyTextFragment.AndroidBug5497Workaround.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ysr
 * JD-Core Version:    0.7.0.1
 */