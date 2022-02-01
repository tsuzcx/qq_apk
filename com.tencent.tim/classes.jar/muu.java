import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class muu
  implements Animation.AnimationListener
{
  muu(View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.val$view.setTag(-1, null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     muu
 * JD-Core Version:    0.7.0.1
 */