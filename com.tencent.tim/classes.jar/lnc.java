import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class lnc
  implements Animation.AnimationListener
{
  lnc(lnb paramlnb, View paramView, Animation paramAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.kC.startAnimation(this.T);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lnc
 * JD-Core Version:    0.7.0.1
 */