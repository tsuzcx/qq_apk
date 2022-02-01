import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.tim.widget.PullRefreshHeader;
import com.tencent.widget.ListView;

public class auqj
  extends AnimatorListenerAdapter
{
  public auqj(PullRefreshHeader paramPullRefreshHeader) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (PullRefreshHeader.a(this.this$0) != null) {
      PullRefreshHeader.a(this.this$0).setLayerType(2, null);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (PullRefreshHeader.a(this.this$0) != null) {
      PullRefreshHeader.a(this.this$0).setLayerType(2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auqj
 * JD-Core Version:    0.7.0.1
 */