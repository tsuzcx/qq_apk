import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class yrb
  extends AnimatorListenerAdapter
{
  yrb(yqz paramyqz) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ykq.b("FaceLayer", "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ykq.b("FaceLayer", "scaleAnimator end!");
    this.a.p = 1.0F;
    this.a.c = false;
    this.a.b.g();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ykq.b("FaceLayer", "scaleAnimator start!");
    this.a.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yrb
 * JD-Core Version:    0.7.0.1
 */