import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class xfd
  implements Animator.AnimatorListener
{
  xfd(xfc paramxfc) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    if (xfc.a(this.a) != null) {
      xfc.a(this.a).a();
    }
  }
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xfd
 * JD-Core Version:    0.7.0.1
 */