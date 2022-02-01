import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class yci
  extends AnimatorListenerAdapter
{
  yci(ycg paramycg) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    xvv.b("FaceLayer", "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    xvv.b("FaceLayer", "scaleAnimator end!");
    this.a.p = 1.0F;
    this.a.c = false;
    this.a.b.g();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    xvv.b("FaceLayer", "scaleAnimator start!");
    this.a.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yci
 * JD-Core Version:    0.7.0.1
 */