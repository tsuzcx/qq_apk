import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

class vjs
  implements Animator.AnimatorListener
{
  vjs(vjo paramvjo) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    vjo.b(this.a).removeAnimatorListener(this);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    vjo.c(this.a);
    vjo.b(this.a).setVisibility(8);
    vjo.b(this.a).removeAnimatorListener(this);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjs
 * JD-Core Version:    0.7.0.1
 */