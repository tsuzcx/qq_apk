import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class wqc
  implements Animator.AnimatorListener
{
  wqc(wqa paramwqa) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (wqa.a(this.a) != null) {
      wqa.a(this.a).a();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (wqa.a(this.a) != null) {
      wqa.a(this.a).a();
    }
    if (wqa.a(this.a) != null)
    {
      wqa.a(wqa.a(this.a), null);
      wqa.a(this.a).a();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (wqa.a(this.a) != null) {
      wqa.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wqc
 * JD-Core Version:    0.7.0.1
 */