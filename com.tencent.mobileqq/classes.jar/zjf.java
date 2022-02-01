import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.FrameLayout;

class zjf
  implements Animator.AnimatorListener
{
  zjf(zjc paramzjc) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    zjc.a(this.a, null);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (zjc.a(this.a) != null) {
      zjc.a(this.a).a(3);
    }
    if (zjc.a(this.a) != null)
    {
      zjc.a(this.a).setAlpha(0.0F);
      zjc.a(this.a, null);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zjf
 * JD-Core Version:    0.7.0.1
 */