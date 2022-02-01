import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ticker.TickerView;

public class ntd
  extends AnimatorListenerAdapter
{
  public ntd(TickerView paramTickerView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    TickerView.a(this.b).onAnimationEnd();
    TickerView.a(this.b);
    this.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ntd
 * JD-Core Version:    0.7.0.1
 */