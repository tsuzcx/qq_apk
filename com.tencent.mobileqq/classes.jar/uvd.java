import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

class uvd
  implements Animator.AnimatorListener
{
  uvd(uvb paramuvb) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    uvb.a(this.a).removeAnimatorListener(this);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    uvb.b(this.a);
    uvb.a(this.a).setVisibility(8);
    uvb.a(this.a).removeAnimatorListener(this);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uvd
 * JD-Core Version:    0.7.0.1
 */