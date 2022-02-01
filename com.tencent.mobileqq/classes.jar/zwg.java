import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class zwg
  implements ViewTreeObserver.OnPreDrawListener
{
  zwg(zwd paramzwd) {}
  
  public boolean onPreDraw()
  {
    zwd.a(this.a).start();
    zwd.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwg
 * JD-Core Version:    0.7.0.1
 */