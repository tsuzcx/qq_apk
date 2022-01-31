import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.FrameLayout;

class ykw
  implements Animator.AnimatorListener
{
  ykw(ykt paramykt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ykt.a(this.a, null);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (ykt.a(this.a) != null) {
      ykt.a(this.a).a(3);
    }
    if (ykt.a(this.a) != null)
    {
      ykt.a(this.a).setAlpha(0.0F);
      ykt.a(this.a, null);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ykw
 * JD-Core Version:    0.7.0.1
 */