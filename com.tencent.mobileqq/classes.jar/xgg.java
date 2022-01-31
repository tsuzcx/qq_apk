import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class xgg
  implements Animation.AnimationListener
{
  xgg(xge paramxge) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (xge.a(this.a) != null)
    {
      xge.a(this.a).clearAnimation();
      xge.a(this.a).startAnimation(xge.a(this.a));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xgg
 * JD-Core Version:    0.7.0.1
 */