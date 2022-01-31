import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class uxz
  extends AnimatorListenerAdapter
{
  uxz(uxx paramuxx) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    urk.b("FaceLayer", "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    urk.b("FaceLayer", "scaleAnimator end!");
    this.a.p = 1.0F;
    this.a.c = false;
    this.a.b.g();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    urk.b("FaceLayer", "scaleAnimator start!");
    this.a.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uxz
 * JD-Core Version:    0.7.0.1
 */