import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class rfv
  implements Animator.AnimatorListener
{
  rfv(rft.a parama) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.aHB = false;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.aHB = false;
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    this.a.aHB = true;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.aHB = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rfv
 * JD-Core Version:    0.7.0.1
 */