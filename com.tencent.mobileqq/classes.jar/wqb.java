import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class wqb
  implements Animator.AnimatorListener
{
  wqb(wqa paramwqa) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    if (wqa.a(this.a) != null) {
      wqa.a(this.a).a();
    }
  }
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wqb
 * JD-Core Version:    0.7.0.1
 */