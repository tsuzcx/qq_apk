import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;

class xge
  implements Animation.AnimationListener
{
  xge(xgb paramxgb) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (xgb.a(this.a) != null) {
      xgb.a(this.a).setVisibility(4);
    }
    if (xgb.a(this.a) != null) {
      xgb.a(this.a).setAlpha(1.0F);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xge
 * JD-Core Version:    0.7.0.1
 */