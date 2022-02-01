import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

class uml
  implements Animator.AnimatorListener
{
  uml(umj paramumj) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    umj.a(this.a).removeAnimatorListener(this);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    umj.b(this.a);
    umj.a(this.a).setVisibility(8);
    umj.a(this.a).removeAnimatorListener(this);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uml
 * JD-Core Version:    0.7.0.1
 */