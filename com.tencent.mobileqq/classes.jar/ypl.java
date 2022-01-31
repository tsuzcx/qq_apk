import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.apollo.store.ApolloDiyTextFragment.AndroidBug5497Workaround;

public class ypl
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public ypl(ApolloDiyTextFragment.AndroidBug5497Workaround paramAndroidBug5497Workaround) {}
  
  public void onGlobalLayout()
  {
    ApolloDiyTextFragment.AndroidBug5497Workaround.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ypl
 * JD-Core Version:    0.7.0.1
 */