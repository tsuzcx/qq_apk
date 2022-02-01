import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ticker.TickerView;

public class ntc
  implements ValueAnimator.AnimatorUpdateListener
{
  public ntc(TickerView paramTickerView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    TickerView.a(this.b).setAnimationProgress(paramValueAnimator.getAnimatedFraction());
    TickerView.a(this.b);
    this.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ntc
 * JD-Core Version:    0.7.0.1
 */