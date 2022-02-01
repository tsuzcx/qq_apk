import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.intimate.IntimateScoreCardView;

public class wxs
  implements ValueAnimator.AnimatorUpdateListener
{
  public wxs(IntimateScoreCardView paramIntimateScoreCardView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f < 0.5F)
    {
      IntimateScoreCardView.a(this.this$0).setAlpha(1.0F - f * 2.0F);
      return;
    }
    IntimateScoreCardView.a(this.this$0).setAlpha(f * 2.0F - 1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wxs
 * JD-Core Version:    0.7.0.1
 */