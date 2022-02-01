import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class ycu
  extends AnimatorListenerAdapter
{
  ycu(ycr paramycr) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    xvv.b("TextLayer", "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    xvv.b("TextLayer", "scaleAnimator end!");
    this.a.p = 1.0F;
    this.a.c = false;
    this.a.a.g();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    xvv.b("TextLayer", "scaleAnimator start!");
    this.a.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ycu
 * JD-Core Version:    0.7.0.1
 */