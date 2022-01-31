import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class xff
  implements ViewTreeObserver.OnPreDrawListener
{
  xff(xfc paramxfc) {}
  
  public boolean onPreDraw()
  {
    xfc.a(this.a).start();
    xfc.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xff
 * JD-Core Version:    0.7.0.1
 */