import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class xeg
  extends AnimatorListenerAdapter
{
  xeg(xed paramxed) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    wxe.b("TextLayer", "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    wxe.b("TextLayer", "scaleAnimator end!");
    this.a.p = 1.0F;
    this.a.c = false;
    this.a.a.g();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    wxe.b("TextLayer", "scaleAnimator start!");
    this.a.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xeg
 * JD-Core Version:    0.7.0.1
 */