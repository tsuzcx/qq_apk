import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ticker.TickerView;

public class tsz
  extends AnimatorListenerAdapter
{
  public tsz(TickerView paramTickerView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    TickerView.a(this.a).a();
    TickerView.a(this.a);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tsz
 * JD-Core Version:    0.7.0.1
 */