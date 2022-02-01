import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class vch
  extends AnimatorListenerAdapter
{
  vch(vcb paramvcb) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    vcb.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vch
 * JD-Core Version:    0.7.0.1
 */