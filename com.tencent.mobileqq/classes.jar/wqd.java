import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class wqd
  implements ViewTreeObserver.OnPreDrawListener
{
  wqd(wqa paramwqa) {}
  
  public boolean onPreDraw()
  {
    wqa.a(this.a).start();
    wqa.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wqd
 * JD-Core Version:    0.7.0.1
 */