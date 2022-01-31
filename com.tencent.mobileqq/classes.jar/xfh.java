import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class xfh
  implements Animator.AnimatorListener
{
  xfh(xff paramxff) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (xff.a(this.a) != null) {
      xff.a(this.a).a();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (xff.a(this.a) != null) {
      xff.a(this.a).a();
    }
    if (xff.a(this.a) != null)
    {
      xff.a(xff.a(this.a), null);
      xff.a(this.a).a();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (xff.a(this.a) != null) {
      xff.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xfh
 * JD-Core Version:    0.7.0.1
 */