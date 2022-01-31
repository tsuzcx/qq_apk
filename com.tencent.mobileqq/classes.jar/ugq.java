import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class ugq
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ugq(ugk paramugk) {}
  
  public void onGlobalLayout()
  {
    int i = ugk.a(this.a).getHeight();
    if (i != ugk.b(this.a)) {
      ugk.a(this.a, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ugq
 * JD-Core Version:    0.7.0.1
 */