import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.view.View;
import com.tencent.mobileqq.widget.ScrollerRunnable.4;
import com.tencent.mobileqq.widget.ScrollerRunnable.4.1.1;

public class arit
  implements Animator.AnimatorListener
{
  public arit(ScrollerRunnable.4 param4, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.val$view.postDelayed(new ScrollerRunnable.4.1.1(this), 500L);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arit
 * JD-Core Version:    0.7.0.1
 */