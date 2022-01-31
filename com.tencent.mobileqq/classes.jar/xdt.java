import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class xdt
  extends AnimatorListenerAdapter
{
  xdt(xdr paramxdr) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    wxe.b("FaceLayer", "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    wxe.b("FaceLayer", "scaleAnimator end!");
    this.a.p = 1.0F;
    this.a.c = false;
    this.a.b.g();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    wxe.b("FaceLayer", "scaleAnimator start!");
    this.a.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xdt
 * JD-Core Version:    0.7.0.1
 */