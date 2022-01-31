import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;

final class tmh
  extends AnimatorListenerAdapter
{
  tmh(Animator.AnimatorListener paramAnimatorListener) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    this.a.onAnimationCancel(paramAnimator);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    urk.b("Q.qqstory.playernew.AnimationUtils", "doExitAnimation, onAnimationEnd");
    this.a.onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    this.a.onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tmh
 * JD-Core Version:    0.7.0.1
 */