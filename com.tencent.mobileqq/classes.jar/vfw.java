import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.LinearLayout;

class vfw
  implements Animator.AnimatorListener
{
  vfw(vfu paramvfu) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (vfu.a(this.a) != null) {
      vfu.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfw
 * JD-Core Version:    0.7.0.1
 */