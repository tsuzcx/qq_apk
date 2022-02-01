import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.emoticonview.HorizontalListViewEx;

public class afpl
  implements ValueAnimator.AnimatorUpdateListener
{
  public afpl(HorizontalListViewEx paramHorizontalListViewEx, View paramView, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.this$0.aYV = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.this$0.aYV += this.BU.getLeft() - this.cSZ;
    if (this.this$0.aYV == this.BU.getLeft()) {
      HorizontalListViewEx.a(this.this$0, false);
    }
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afpl
 * JD-Core Version:    0.7.0.1
 */