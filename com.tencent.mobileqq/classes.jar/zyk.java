import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.FrameLayout;

class zyk
  implements Animator.AnimatorListener
{
  zyk(zyh paramzyh) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    zyh.a(this.a, null);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (zyh.a(this.a) != null) {
      zyh.a(this.a).a(3);
    }
    if (zyh.a(this.a) != null)
    {
      zyh.a(this.a).setAlpha(0.0F);
      zyh.a(this.a, null);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zyk
 * JD-Core Version:    0.7.0.1
 */