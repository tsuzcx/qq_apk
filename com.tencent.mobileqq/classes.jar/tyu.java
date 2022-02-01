import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

class tyu
  implements Animator.AnimatorListener
{
  tyu(tyr paramtyr) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    tyr.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    tyr.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    tyr.a(this.a, true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    tyr.a(this.a, true);
    tyr.a(this.a).setAlpha(0.0F);
    tyr.b(this.a).setAlpha(0.0F);
    tyr.c(this.a).setAlpha(0.0F);
    tyr.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tyu
 * JD-Core Version:    0.7.0.1
 */