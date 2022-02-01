import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class rge
  extends AnimatorListenerAdapter
{
  rge(rgb.b paramb) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ram.d("TextLayer", "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ram.d("TextLayer", "scaleAnimator end!");
    this.c.nJ = 1.0F;
    this.c.aIo = false;
    this.c.a.notifyChange();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ram.d("TextLayer", "scaleAnimator start!");
    this.c.aIo = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rge
 * JD-Core Version:    0.7.0.1
 */