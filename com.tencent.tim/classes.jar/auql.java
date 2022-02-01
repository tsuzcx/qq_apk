import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.tim.widget.PullRefreshHeader;

public class auql
  extends AnimatorListenerAdapter
{
  public auql(PullRefreshHeader paramPullRefreshHeader) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    PullRefreshHeader.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auql
 * JD-Core Version:    0.7.0.1
 */