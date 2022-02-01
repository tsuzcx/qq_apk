import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.widget.SlideDownFrameLayout;
import com.tencent.mobileqq.widget.SlideDownFrameLayout.a;

public class arjf
  implements Animator.AnimatorListener
{
  public arjf(SlideDownFrameLayout paramSlideDownFrameLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SlideDownFrameLayout.a(this.b).aKG();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arjf
 * JD-Core Version:    0.7.0.1
 */