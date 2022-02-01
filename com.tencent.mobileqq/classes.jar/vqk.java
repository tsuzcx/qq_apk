import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

class vqk
  implements Animator.AnimatorListener
{
  vqk(vqj paramvqj) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    vqj.a(this.a).removeAnimatorListener(this);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    vqj.a(this.a).setVisibility(8);
    vqj.a(this.a).removeAnimatorListener(this);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqk
 * JD-Core Version:    0.7.0.1
 */