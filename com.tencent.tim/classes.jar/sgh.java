import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.FrameLayout;

class sgh
  implements Animator.AnimatorListener
{
  sgh(sge paramsge) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    sge.a(this.b, null);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (sge.a(this.b) != null) {
      sge.a(this.b).setState(3);
    }
    if (sge.a(this.b) != null)
    {
      sge.a(this.b).setAlpha(0.0F);
      sge.a(this.b, null);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sgh
 * JD-Core Version:    0.7.0.1
 */