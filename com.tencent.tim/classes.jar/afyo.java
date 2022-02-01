import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSearchBarView;

public class afyo
  implements ValueAnimator.AnimatorUpdateListener
{
  public afyo(ExtendFriendSearchBarView paramExtendFriendSearchBarView, FrameLayout.LayoutParams paramLayoutParams, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (paramValueAnimator.getAnimatedValue() == null) {
      return;
    }
    int i = (int)((1.0F - ((Integer)paramValueAnimator.getAnimatedValue()).intValue() * 1.0F / 1000.0F) * -ExtendFriendSearchBarView.a(this.b));
    this.e.topMargin = i;
    this.Co.setLayoutParams(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afyo
 * JD-Core Version:    0.7.0.1
 */