import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSearchBarView;

public class afyq
  implements ValueAnimator.AnimatorUpdateListener
{
  public afyq(ExtendFriendSearchBarView paramExtendFriendSearchBarView, FrameLayout.LayoutParams paramLayoutParams, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (paramValueAnimator.getAnimatedValue() == null) {
      return;
    }
    float f = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() * 1.0F / 1000.0F;
    int i = (int)(-ExtendFriendSearchBarView.a(this.b) * f);
    this.e.topMargin = i;
    this.Co.setLayoutParams(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afyq
 * JD-Core Version:    0.7.0.1
 */