import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class zaz
  extends AnimatorListenerAdapter
{
  zaz(zax paramzax) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    yuk.b("FaceLayer", "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    yuk.b("FaceLayer", "scaleAnimator end!");
    this.a.p = 1.0F;
    this.a.c = false;
    this.a.b.g();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    yuk.b("FaceLayer", "scaleAnimator start!");
    this.a.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zaz
 * JD-Core Version:    0.7.0.1
 */