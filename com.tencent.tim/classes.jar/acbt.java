import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;

final class acbt
  implements Animation.AnimationListener
{
  acbt(View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.AX != null) && (this.AX.getVisibility() == 0))
    {
      paramAnimation = AnimationUtils.loadAnimation(this.AX.getContext(), 2130772298);
      paramAnimation.setAnimationListener(this);
      this.AX.startAnimation(paramAnimation);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acbt
 * JD-Core Version:    0.7.0.1
 */