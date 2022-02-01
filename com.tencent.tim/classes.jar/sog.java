import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class sog
  implements ViewTreeObserver.OnPreDrawListener
{
  sog(sof paramsof, View paramView) {}
  
  public boolean onPreDraw()
  {
    this.val$view.getViewTreeObserver().removeOnPreDrawListener(this);
    sof.a(this.a, this.val$view);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sog
 * JD-Core Version:    0.7.0.1
 */