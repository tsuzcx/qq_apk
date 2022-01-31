import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class yty
  implements ViewTreeObserver.OnPreDrawListener
{
  yty(ytv paramytv) {}
  
  public boolean onPreDraw()
  {
    ytv.a(this.a).start();
    ytv.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yty
 * JD-Core Version:    0.7.0.1
 */