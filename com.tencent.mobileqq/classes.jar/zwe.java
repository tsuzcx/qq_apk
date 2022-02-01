import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class zwe
  implements Animator.AnimatorListener
{
  zwe(zwd paramzwd) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    if (zwd.a(this.a) != null) {
      zwd.a(this.a).a();
    }
  }
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwe
 * JD-Core Version:    0.7.0.1
 */