import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.CaptureOperateTouchLayout;
import com.tencent.biz.pubaccount.readinjoy.view.CaptureOperateTouchLayout.b;

public class ncp
  implements ValueAnimator.AnimatorUpdateListener
{
  public ncp(CaptureOperateTouchLayout.b paramb, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.val$v.setX(f);
    CaptureOperateTouchLayout.a(this.a.b).setX(f + this.val$v.getWidth() * 0.32F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ncp
 * JD-Core Version:    0.7.0.1
 */