import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class vea
  extends AnimatorListenerAdapter
{
  vea(vdr paramvdr) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    vdr.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vea
 * JD-Core Version:    0.7.0.1
 */