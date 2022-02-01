import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

class tsb
  implements Animator.AnimatorListener
{
  tsb(try paramtry) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    try.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    try.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    try.a(this.a, true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    try.a(this.a, true);
    try.a(this.a).setAlpha(0.0F);
    try.b(this.a).setAlpha(0.0F);
    try.c(this.a).setAlpha(0.0F);
    try.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tsb
 * JD-Core Version:    0.7.0.1
 */