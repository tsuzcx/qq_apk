import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class twu
  extends AnimatorListenerAdapter
{
  twu(twt paramtwt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.b.G(twt.a(this.b), twt.b(this.b));
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.b.G(twt.a(this.b), twt.b(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     twu
 * JD-Core Version:    0.7.0.1
 */