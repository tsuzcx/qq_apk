import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

public class wbe
  implements Animator.AnimatorListener
{
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (paramAnimator != null) {}
    try
    {
      paramAnimator.start();
      return;
    }
    catch (Exception paramAnimator)
    {
      paramAnimator.printStackTrace();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wbe
 * JD-Core Version:    0.7.0.1
 */