import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class yyl
  implements Animator.AnimatorListener
{
  yyl(yyk paramyyk) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    if (yyk.a(this.a) != null) {
      yyk.a(this.a).a();
    }
  }
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yyl
 * JD-Core Version:    0.7.0.1
 */