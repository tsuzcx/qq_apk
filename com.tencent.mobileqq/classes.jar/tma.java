import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class tma
  implements Animation.AnimationListener
{
  tma(View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setTag(-1, null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tma
 * JD-Core Version:    0.7.0.1
 */