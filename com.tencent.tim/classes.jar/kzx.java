import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.daily.DailyTipsFoldUtils.1;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;

public class kzx
  implements ValueAnimator.AnimatorUpdateListener
{
  public kzx(DailyTipsFoldUtils.1 param1, View paramView, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.val$itemView.setAlpha(1.0F - f);
    int i = (int)(this.aMN * f);
    this.a.b.smoothScrollToPositionFromTop(this.a.b.getHeaderViewsCount(), -i, 0);
    if (QLog.isColorLevel()) {
      QLog.d("DailyTipsFoldUtils", 2, "percent = " + f + ", scrollHeight = " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kzx
 * JD-Core Version:    0.7.0.1
 */