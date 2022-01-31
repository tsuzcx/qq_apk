import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.FrameLayout;

class wrw
  implements Animator.AnimatorListener
{
  wrw(wrt paramwrt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    wrt.a(this.a, null);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (wrt.a(this.a) != null) {
      wrt.a(this.a).a(3);
    }
    if (wrt.a(this.a) != null)
    {
      wrt.a(this.a).setAlpha(0.0F);
      wrt.a(this.a, null);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wrw
 * JD-Core Version:    0.7.0.1
 */