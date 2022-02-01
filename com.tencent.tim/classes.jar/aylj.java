import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;

final class aylj
  implements Animator.AnimatorListener
{
  aylj(aylh.a parama, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.a != null) {
      this.a.c(this.K);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a != null) {
      this.a.b(this.K);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.a != null) {
      this.a.a(this.K);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aylj
 * JD-Core Version:    0.7.0.1
 */