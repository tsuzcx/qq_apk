import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.WindowManager;

class argy
  implements Animator.AnimatorListener
{
  argy(argu paramargu) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (argu.a(this.b) != null)
    {
      argu.a(this.b).removeViewImmediate(argu.a(this.b));
      argu.a(this.b, null);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     argy
 * JD-Core Version:    0.7.0.1
 */