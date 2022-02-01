import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class ayje
  implements Animation.AnimationListener
{
  ayje(View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.val$view.setAnimation(null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayje
 * JD-Core Version:    0.7.0.1
 */