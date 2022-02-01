import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class yxr
  extends AnimatorListenerAdapter
{
  yxr(yxo paramyxo) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    yqp.b("TextLayer", "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    yqp.b("TextLayer", "scaleAnimator end!");
    this.a.p = 1.0F;
    this.a.c = false;
    this.a.a.g();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    yqp.b("TextLayer", "scaleAnimator start!");
    this.a.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yxr
 * JD-Core Version:    0.7.0.1
 */