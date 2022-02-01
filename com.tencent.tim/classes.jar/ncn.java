import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.view.BezierSideBarView;

public class ncn
  implements ValueAnimator.AnimatorUpdateListener
{
  public ncn(BezierSideBarView paramBezierSideBarView, ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    BezierSideBarView.a(this.b, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.b.invalidate();
    if (this.d != null) {
      this.d.onAnimationUpdate(paramValueAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ncn
 * JD-Core Version:    0.7.0.1
 */