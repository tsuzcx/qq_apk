import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SlideBottomPanel;

public class ayrp
  implements Animator.AnimatorListener
{
  public ayrp(SlideBottomPanel paramSlideBottomPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.isAnimating = false;
    this.a.dAy = false;
    this.a.isAtBottom = false;
    if (this.a.a != null) {
      this.a.a.hidePanelFinish();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.isAnimating = false;
    this.a.dAy = false;
    this.a.isAtBottom = false;
    if (this.a.a != null) {
      this.a.a.hidePanelFinish();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.isAnimating = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayrp
 * JD-Core Version:    0.7.0.1
 */