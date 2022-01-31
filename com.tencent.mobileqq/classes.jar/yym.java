import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class yym
  implements Animator.AnimatorListener
{
  yym(yyk paramyyk) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (yyk.a(this.a) != null) {
      yyk.a(this.a).a();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (yyk.a(this.a) != null) {
      yyk.a(this.a).a();
    }
    if (yyk.a(this.a) != null)
    {
      yyk.a(yyk.a(this.a), null);
      yyk.a(this.a).a();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (yyk.a(this.a) != null) {
      yyk.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yym
 * JD-Core Version:    0.7.0.1
 */