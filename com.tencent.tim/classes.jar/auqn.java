import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.tencent.lottieNew.LottieAnimationView;
import com.tencent.tim.widget.PullRefreshHeader;

public class auqn
  extends AnimatorListenerAdapter
{
  public auqn(PullRefreshHeader paramPullRefreshHeader) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (PullRefreshHeader.d(this.this$0)) {
      PullRefreshHeader.a(this.this$0).playAnimation();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    if (PullRefreshHeader.d(this.this$0)) {
      PullRefreshHeader.a(this.this$0).cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auqn
 * JD-Core Version:    0.7.0.1
 */