import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class ayjr
  extends AnimatorListenerAdapter
{
  ayjr(ayjn.b paramb) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ram.d(ayjn.TAG, "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ram.d(ayjn.TAG, "scaleAnimator end!");
    this.b.nJ = 1.0F;
    this.b.aIo = false;
    this.b.this$0.notifyChange();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ram.d(ayjn.TAG, "scaleAnimator start!");
    this.b.aIo = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayjr
 * JD-Core Version:    0.7.0.1
 */