import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class vli
  extends AnimatorListenerAdapter
{
  vli(vlf paramvlf) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    veg.b("TextLayer", "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    veg.b("TextLayer", "scaleAnimator end!");
    this.a.p = 1.0F;
    this.a.c = false;
    this.a.a.g();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    veg.b("TextLayer", "scaleAnimator start!");
    this.a.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vli
 * JD-Core Version:    0.7.0.1
 */