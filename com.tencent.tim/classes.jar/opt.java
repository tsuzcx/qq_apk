import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class opt
  implements Animation.AnimationListener
{
  opt(View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.val$view.getTag(-1) != null) && (((Integer)this.val$view.getTag(-1)).intValue() == 8))
    {
      this.val$view.clearAnimation();
      this.val$view.setVisibility(8);
      this.val$view.setTag(-1, null);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     opt
 * JD-Core Version:    0.7.0.1
 */