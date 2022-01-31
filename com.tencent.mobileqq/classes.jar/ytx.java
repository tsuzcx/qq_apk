import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class ytx
  implements Animator.AnimatorListener
{
  ytx(ytv paramytv) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (ytv.a(this.a) != null) {
      ytv.a(this.a).a();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (ytv.a(this.a) != null) {
      ytv.a(this.a).a();
    }
    if (ytv.a(this.a) != null)
    {
      ytv.a(ytv.a(this.a), null);
      ytv.a(this.a).a();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (ytv.a(this.a) != null) {
      ytv.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ytx
 * JD-Core Version:    0.7.0.1
 */