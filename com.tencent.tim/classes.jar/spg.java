import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class spg
  implements Animator.AnimatorListener
{
  spg(spf paramspf) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    if (spf.a(this.d) != null) {
      spf.a(this.d).bzK();
    }
  }
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     spg
 * JD-Core Version:    0.7.0.1
 */