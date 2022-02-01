import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.tim.widget.PullRefreshHeader;

public class auqk
  implements ValueAnimator.AnimatorUpdateListener
{
  public auqk(PullRefreshHeader paramPullRefreshHeader, ViewGroup.MarginLayoutParams paramMarginLayoutParams) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if ((i > 0) && (i < PullRefreshHeader.a(this.this$0))) {
      this.d.topMargin = (i + PullRefreshHeader.b(this.this$0));
    }
    for (;;)
    {
      PullRefreshHeader.a(this.this$0).setLayoutParams(this.d);
      if (!PullRefreshHeader.a(this.this$0)) {
        PullRefreshHeader.a(this.this$0, this.d.topMargin);
      }
      return;
      if ((i >= PullRefreshHeader.a(this.this$0)) && (i < PullRefreshHeader.c(this.this$0)))
      {
        this.d.topMargin = (PullRefreshHeader.b(this.this$0) + PullRefreshHeader.a(this.this$0) - PullRefreshHeader.a(this.this$0, i));
      }
      else
      {
        PullRefreshHeader.a(this.this$0).setVisibility(4);
        this.d.topMargin = ((i - PullRefreshHeader.c(this.this$0)) / 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auqk
 * JD-Core Version:    0.7.0.1
 */