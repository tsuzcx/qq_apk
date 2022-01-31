import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class xgd
  implements Animation.AnimationListener
{
  xgd(xgb paramxgb) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (xgb.a(this.a) != null)
    {
      xgb.a(this.a).clearAnimation();
      xgb.a(this.a).startAnimation(xgb.a(this.a));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xgd
 * JD-Core Version:    0.7.0.1
 */