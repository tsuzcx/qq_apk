import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.tim.cloudfile.anima.DynamicButton;
import com.tencent.tim.cloudfile.anima.DynamicButton.a;

public class atjn
  implements Animation.AnimationListener
{
  public atjn(DynamicButton paramDynamicButton, DynamicButton.a parama) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new AlphaAnimation(1.0F, 0.0F);
    paramAnimation.setDuration(DynamicButton.a.b(this.a));
    paramAnimation.setFillAfter(true);
    paramAnimation.setAnimationListener(new atjo(this));
    this.c.startAnimation(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atjn
 * JD-Core Version:    0.7.0.1
 */