import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class vkv
  extends AnimatorListenerAdapter
{
  vkv(vkt paramvkt) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    veg.b("FaceLayer", "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    veg.b("FaceLayer", "scaleAnimator end!");
    this.a.p = 1.0F;
    this.a.c = false;
    this.a.b.g();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    veg.b("FaceLayer", "scaleAnimator start!");
    this.a.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vkv
 * JD-Core Version:    0.7.0.1
 */