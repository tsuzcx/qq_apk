import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class adlx
  implements Animator.AnimatorListener
{
  adlx(adlw paramadlw) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (adlw.a(this.a) != null) {
      adlw.a(this.a).onAnimationEnd();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adlx
 * JD-Core Version:    0.7.0.1
 */