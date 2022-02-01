import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

class kog
  implements Animator.AnimatorListener
{
  kog(kod paramkod) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    kod.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    kod.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    kod.a(this.a, true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    kod.a(this.a, true);
    kod.a(this.a).setAlpha(0.0F);
    kod.b(this.a).setAlpha(0.0F);
    kod.c(this.a).setAlpha(0.0F);
    kod.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kog
 * JD-Core Version:    0.7.0.1
 */