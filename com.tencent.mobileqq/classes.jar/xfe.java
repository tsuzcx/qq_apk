import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class xfe
  implements Animator.AnimatorListener
{
  xfe(xfc paramxfc) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (xfc.a(this.a) != null) {
      xfc.a(this.a).a();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (xfc.a(this.a) != null) {
      xfc.a(this.a).a();
    }
    if (xfc.a(this.a) != null)
    {
      xfc.a(xfc.a(this.a), null);
      xfc.a(this.a).a();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (xfc.a(this.a) != null) {
      xfc.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xfe
 * JD-Core Version:    0.7.0.1
 */