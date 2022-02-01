import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;

class xrj
  implements Animation.AnimationListener
{
  xrj(xrh paramxrh) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (xrh.a(this.b) != null) {
      xrh.a(this.b).setVisibility(8);
    }
    if (xrh.a(this.b) != null) {
      xrh.a(this.b).onHide();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xrj
 * JD-Core Version:    0.7.0.1
 */