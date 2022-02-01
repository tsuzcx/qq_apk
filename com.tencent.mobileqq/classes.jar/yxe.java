import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class yxe
  extends AnimatorListenerAdapter
{
  yxe(yxc paramyxc) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    yqp.b("FaceLayer", "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    yqp.b("FaceLayer", "scaleAnimator end!");
    this.a.p = 1.0F;
    this.a.c = false;
    this.a.b.g();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    yqp.b("FaceLayer", "scaleAnimator start!");
    this.a.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yxe
 * JD-Core Version:    0.7.0.1
 */