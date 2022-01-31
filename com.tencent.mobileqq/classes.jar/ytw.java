import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class ytw
  implements Animator.AnimatorListener
{
  ytw(ytv paramytv) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    if (ytv.a(this.a) != null) {
      ytv.a(this.a).a();
    }
  }
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ytw
 * JD-Core Version:    0.7.0.1
 */