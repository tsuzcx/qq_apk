import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.FrameLayout;

class wrt
  implements Animator.AnimatorListener
{
  wrt(wrq paramwrq) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    wrq.a(this.a, null);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (wrq.a(this.a) != null) {
      wrq.a(this.a).a(3);
    }
    if (wrq.a(this.a) != null)
    {
      wrq.a(this.a).setAlpha(0.0F);
      wrq.a(this.a, null);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wrt
 * JD-Core Version:    0.7.0.1
 */