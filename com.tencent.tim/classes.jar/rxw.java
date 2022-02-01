import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.richframework.part.block.base.RefreshHeaderView;

public class rxw
  implements ValueAnimator.AnimatorUpdateListener
{
  public rxw(RefreshHeaderView paramRefreshHeaderView, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.this$0.setVisibleHeight(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    if ((this.bvS == 0) && (((Integer)paramValueAnimator.getAnimatedValue()).intValue() == 0)) {
      this.this$0.setState(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rxw
 * JD-Core Version:    0.7.0.1
 */