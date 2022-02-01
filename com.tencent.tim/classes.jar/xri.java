import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class xri
  implements Animation.AnimationListener
{
  xri(xrh paramxrh) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (xrh.a(this.b) != null) {
      xrh.a(this.b).onShow();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xri
 * JD-Core Version:    0.7.0.1
 */