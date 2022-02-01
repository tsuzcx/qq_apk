import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class ayod
  implements Animator.AnimatorListener
{
  ayod(ayob paramayob) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (ayob.a(this.b) != null) {
      ayob.a(this.b).onEnd();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayod
 * JD-Core Version:    0.7.0.1
 */