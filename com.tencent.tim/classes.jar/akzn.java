import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;

class akzn
  implements Animator.AnimatorListener
{
  akzn(akze paramakze, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.this$0.resetTitle();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.this$0.resetTitle();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (this.this$0.bQO) {
      this.Bh.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akzn
 * JD-Core Version:    0.7.0.1
 */