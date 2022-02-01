import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

class utw
  implements Animator.AnimatorListener
{
  utw(utv paramutv) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    utv.a(this.a).removeAnimatorListener(this);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    utv.a(this.a).setVisibility(8);
    utv.a(this.a).removeAnimatorListener(this);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     utw
 * JD-Core Version:    0.7.0.1
 */