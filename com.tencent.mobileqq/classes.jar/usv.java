import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

class usv
  implements Animator.AnimatorListener
{
  usv(usu paramusu) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    usu.a(this.a).removeAnimatorListener(this);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    usu.a(this.a).setVisibility(8);
    usu.a(this.a).removeAnimatorListener(this);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     usv
 * JD-Core Version:    0.7.0.1
 */