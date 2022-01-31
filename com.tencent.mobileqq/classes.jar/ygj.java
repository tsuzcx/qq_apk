import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.FrameLayout;

class ygj
  implements Animator.AnimatorListener
{
  ygj(ygg paramygg) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ygg.a(this.a, null);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (ygg.a(this.a) != null) {
      ygg.a(this.a).a(3);
    }
    if (ygg.a(this.a) != null)
    {
      ygg.a(this.a).setAlpha(0.0F);
      ygg.a(this.a, null);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ygj
 * JD-Core Version:    0.7.0.1
 */