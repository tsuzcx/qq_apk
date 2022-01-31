import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class yyn
  implements ViewTreeObserver.OnPreDrawListener
{
  yyn(yyk paramyyk) {}
  
  public boolean onPreDraw()
  {
    yyk.a(this.a).start();
    yyk.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yyn
 * JD-Core Version:    0.7.0.1
 */