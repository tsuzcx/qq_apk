import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class ops
  implements Animation.AnimationListener
{
  ops(View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.val$view.setTag(-1, null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ops
 * JD-Core Version:    0.7.0.1
 */