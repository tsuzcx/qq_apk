import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class yrn
  extends AnimatorListenerAdapter
{
  yrn(yrk paramyrk) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ykq.b("TextLayer", "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ykq.b("TextLayer", "scaleAnimator end!");
    this.a.p = 1.0F;
    this.a.c = false;
    this.a.a.g();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ykq.b("TextLayer", "scaleAnimator start!");
    this.a.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yrn
 * JD-Core Version:    0.7.0.1
 */