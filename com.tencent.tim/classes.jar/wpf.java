import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import java.util.Queue;

class wpf
  implements Animator.AnimatorListener
{
  wpf(wpe paramwpe) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    wpe.a(this.a).remove();
    if (wpe.a(this.a).isEmpty()) {
      this.a.stopAnim();
    }
    while (wpe.a(this.a)) {
      return;
    }
    wpe.a(this.a).clear();
    this.a.stopAnim();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wpf
 * JD-Core Version:    0.7.0.1
 */