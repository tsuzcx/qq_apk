import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakShow;
import com.tencent.widget.AbsListView.LayoutParams;

public class alum
  implements ValueAnimator.AnimatorUpdateListener
{
  public alum(AIOIceBreakShow paramAIOIceBreakShow) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (AIOIceBreakShow.a(this.this$0) == null) {
      return;
    }
    int i = ((Integer)paramValueAnimator.getAnimatedValue("alpha")).intValue();
    int j = ((Integer)paramValueAnimator.getAnimatedValue("height")).intValue();
    AIOIceBreakShow.a(this.this$0).setAlpha(i / 100.0F);
    paramValueAnimator = AIOIceBreakShow.a(this.this$0).d();
    ((AbsListView.LayoutParams)paramValueAnimator.getLayoutParams()).height = j;
    paramValueAnimator.requestLayout();
    AIOIceBreakShow.a(this.this$0).scrollTo(0, j - AIOIceBreakShow.access$300());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alum
 * JD-Core Version:    0.7.0.1
 */