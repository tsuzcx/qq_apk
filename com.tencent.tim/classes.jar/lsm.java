import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class lsm
  implements Animator.AnimatorListener
{
  lsm(lsf paramlsf, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.val$isShow)
    {
      lsf.a(this.this$0).isShowRecommendList = false;
      lsf.a(this.this$0);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lsm
 * JD-Core Version:    0.7.0.1
 */