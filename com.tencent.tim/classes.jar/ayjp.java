import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class ayjp
  implements Animator.AnimatorListener
{
  ayjp(ayjn.a parama) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayjp
 * JD-Core Version:    0.7.0.1
 */