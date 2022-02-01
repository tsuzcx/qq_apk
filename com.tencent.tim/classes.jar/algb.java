import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.profile.view.BreatheEffectView;

public class algb
  extends AnimatorListenerAdapter
{
  public algb(BreatheEffectView paramBreatheEffectView) {}
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    this.a.dFB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     algb
 * JD-Core Version:    0.7.0.1
 */