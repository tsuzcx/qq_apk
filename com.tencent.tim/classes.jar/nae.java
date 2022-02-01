import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.discovery.HorizontalRefreshLayout;

public class nae
  extends AnimatorListenerAdapter
{
  public nae(HorizontalRefreshLayout paramHorizontalRefreshLayout) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    HorizontalRefreshLayout.a(this.a, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nae
 * JD-Core Version:    0.7.0.1
 */