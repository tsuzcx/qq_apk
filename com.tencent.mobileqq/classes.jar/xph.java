import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;

final class xph
  extends AnimatorListenerAdapter
{
  xph(Animator.AnimatorListener paramAnimatorListener) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    this.a.onAnimationCancel(paramAnimator);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    yuk.b("Q.qqstory.playernew.AnimationUtils", "doExitAnimation, onAnimationEnd");
    this.a.onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    this.a.onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xph
 * JD-Core Version:    0.7.0.1
 */