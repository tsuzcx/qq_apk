import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class uym
  extends AnimatorListenerAdapter
{
  uym(uyj paramuyj) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    urk.b("TextLayer", "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    urk.b("TextLayer", "scaleAnimator end!");
    this.a.p = 1.0F;
    this.a.c = false;
    this.a.a.g();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    urk.b("TextLayer", "scaleAnimator start!");
    this.a.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uym
 * JD-Core Version:    0.7.0.1
 */