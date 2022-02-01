import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class rey
  implements Animation.AnimationListener
{
  rey(View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.val$view.setAnimation(null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rey
 * JD-Core Version:    0.7.0.1
 */