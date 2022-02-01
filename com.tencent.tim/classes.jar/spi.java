import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class spi
  implements ViewTreeObserver.OnPreDrawListener
{
  spi(spf paramspf) {}
  
  public boolean onPreDraw()
  {
    spf.a(this.d).start();
    spf.a(this.d).getViewTreeObserver().removeOnPreDrawListener(this);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     spi
 * JD-Core Version:    0.7.0.1
 */