import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class ayka
  extends AnimatorListenerAdapter
{
  ayka(ayjw.c paramc) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ram.d(ayjw.TAG, "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ram.d(ayjw.TAG, "scaleAnimator end!");
    this.c.nJ = 1.0F;
    this.c.aIo = false;
    this.c.a.notifyChange();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ram.d(ayjw.TAG, "scaleAnimator start!");
    this.c.aIo = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayka
 * JD-Core Version:    0.7.0.1
 */