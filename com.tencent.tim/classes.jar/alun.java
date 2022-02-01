import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakShow;

public class alun
  implements Animator.AnimatorListener
{
  public alun(AIOIceBreakShow paramAIOIceBreakShow) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AIOIceBreakShow.a(this.this$0, false);
    AIOIceBreakShow.a(this.this$0);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AIOIceBreakShow.a(this.this$0, false);
    AIOIceBreakShow.a(this.this$0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AIOIceBreakShow.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alun
 * JD-Core Version:    0.7.0.1
 */