import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

class ums
  implements Animator.AnimatorListener
{
  ums(ump paramump) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ump.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ump.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    ump.a(this.a, true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ump.a(this.a, true);
    ump.a(this.a).setAlpha(0.0F);
    ump.b(this.a).setAlpha(0.0F);
    ump.c(this.a).setAlpha(0.0F);
    ump.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ums
 * JD-Core Version:    0.7.0.1
 */