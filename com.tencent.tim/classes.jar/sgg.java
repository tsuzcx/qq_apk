import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;

class sgg
  implements Animator.AnimatorListener
{
  sgg(sge paramsge, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = (FrameLayout.LayoutParams)sge.b(this.b).getLayoutParams();
    paramAnimator.height = this.val$height;
    paramAnimator.width = this.val$width;
    paramAnimator.setMargins(this.mQ, this.dS, 0, 0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sgg
 * JD-Core Version:    0.7.0.1
 */