import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

class vbr
  implements Animator.AnimatorListener
{
  vbr(vbq paramvbq) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    vbq.a(this.a).removeAnimatorListener(this);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    vbq.a(this.a).setVisibility(8);
    vbq.a(this.a).removeAnimatorListener(this);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbr
 * JD-Core Version:    0.7.0.1
 */