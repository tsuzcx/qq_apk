import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;

class xgh
  implements Animation.AnimationListener
{
  xgh(xge paramxge) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (xge.a(this.a) != null) {
      xge.a(this.a).setVisibility(4);
    }
    if (xge.a(this.a) != null) {
      xge.a(this.a).setAlpha(1.0F);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xgh
 * JD-Core Version:    0.7.0.1
 */