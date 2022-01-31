import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class vnm
  extends AnimatorListenerAdapter
{
  vnm(vnl paramvnl) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.a.a.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vnm
 * JD-Core Version:    0.7.0.1
 */