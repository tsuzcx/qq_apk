import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

class unj
  implements Animator.AnimatorListener
{
  unj(unh paramunh) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    unh.a(this.a).removeAnimatorListener(this);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    unh.b(this.a);
    unh.a(this.a).setVisibility(8);
    unh.a(this.a).removeAnimatorListener(this);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     unj
 * JD-Core Version:    0.7.0.1
 */