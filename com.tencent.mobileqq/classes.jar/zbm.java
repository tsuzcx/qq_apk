import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class zbm
  extends AnimatorListenerAdapter
{
  zbm(zbj paramzbj) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    yuk.b("TextLayer", "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    yuk.b("TextLayer", "scaleAnimator end!");
    this.a.p = 1.0F;
    this.a.c = false;
    this.a.a.g();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    yuk.b("TextLayer", "scaleAnimator start!");
    this.a.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zbm
 * JD-Core Version:    0.7.0.1
 */