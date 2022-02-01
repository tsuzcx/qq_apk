import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer.c;

public class arkw
  implements Animator.AnimatorListener
{
  public arkw(FloatingScreenContainer paramFloatingScreenContainer) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    FloatingScreenContainer.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    FloatingScreenContainer.a(this.a).removeAllListeners();
    if (FloatingScreenContainer.a(this.a) != null) {
      FloatingScreenContainer.a(this.a).ejP();
    }
    FloatingScreenContainer.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    FloatingScreenContainer.a(this.a, true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (FloatingScreenContainer.a(this.a) != null) {
      FloatingScreenContainer.a(this.a).ejO();
    }
    FloatingScreenContainer.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arkw
 * JD-Core Version:    0.7.0.1
 */