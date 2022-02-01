import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.bubble.ChatXListView;

class yci
  implements Animator.AnimatorListener
{
  yci(ycd paramycd) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.this$0.b.removeHeaderView(ycd.a(this.this$0));
    ycd.a(this.this$0, true);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yci
 * JD-Core Version:    0.7.0.1
 */