import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class sph
  implements Animator.AnimatorListener
{
  sph(spf paramspf) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (spf.a(this.d) != null) {
      spf.a(this.d).onCancel();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (spf.a(this.d) != null) {
      spf.a(this.d).onStop();
    }
    if (spf.a(this.d) != null)
    {
      spf.a(spf.a(this.d), null);
      spf.a(this.d).b();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (spf.a(this.d) != null) {
      spf.a(this.d).onStart();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sph
 * JD-Core Version:    0.7.0.1
 */