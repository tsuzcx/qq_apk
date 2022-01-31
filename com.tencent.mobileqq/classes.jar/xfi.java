import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class xfi
  implements ViewTreeObserver.OnPreDrawListener
{
  xfi(xff paramxff) {}
  
  public boolean onPreDraw()
  {
    xff.a(this.a).start();
    xff.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xfi
 * JD-Core Version:    0.7.0.1
 */