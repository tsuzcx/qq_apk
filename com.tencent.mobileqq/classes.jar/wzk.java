import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class wzk
  extends AnimatorListenerAdapter
{
  wzk(wzi paramwzi) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    wsv.b("FaceLayer", "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    wsv.b("FaceLayer", "scaleAnimator end!");
    this.a.p = 1.0F;
    this.a.c = false;
    this.a.b.g();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    wsv.b("FaceLayer", "scaleAnimator start!");
    this.a.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wzk
 * JD-Core Version:    0.7.0.1
 */