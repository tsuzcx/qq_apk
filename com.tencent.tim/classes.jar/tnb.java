import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.gdtad.views.videoimax.TransitionContext;

public class tnb
  extends AnimatorListenerAdapter
{
  public tnb(TransitionContext paramTransitionContext) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    this.a.onAnimationEnd();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.a.onAnimationEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tnb
 * JD-Core Version:    0.7.0.1
 */