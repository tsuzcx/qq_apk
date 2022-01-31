import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class vlf
  extends AnimatorListenerAdapter
{
  vlf(vlc paramvlc) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ved.b("TextLayer", "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ved.b("TextLayer", "scaleAnimator end!");
    this.a.p = 1.0F;
    this.a.c = false;
    this.a.a.g();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ved.b("TextLayer", "scaleAnimator start!");
    this.a.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vlf
 * JD-Core Version:    0.7.0.1
 */