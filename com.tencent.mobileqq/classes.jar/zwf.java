import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class zwf
  implements Animator.AnimatorListener
{
  zwf(zwd paramzwd) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (zwd.a(this.a) != null) {
      zwd.a(this.a).a();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (zwd.a(this.a) != null) {
      zwd.a(this.a).a();
    }
    if (zwd.a(this.a) != null)
    {
      zwd.a(zwd.a(this.a), null);
      zwd.a(this.a).a();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (zwd.a(this.a) != null) {
      zwd.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwf
 * JD-Core Version:    0.7.0.1
 */