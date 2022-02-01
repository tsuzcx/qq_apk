import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.PointF;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.profile.view.VipTagView;
import com.tencent.mobileqq.widget.RatioLayout;

public class alhd
  implements ValueAnimator.AnimatorUpdateListener
{
  public alhd(ProfileTagView paramProfileTagView, VipTagView paramVipTagView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (PointF)paramValueAnimator.getAnimatedValue();
    this.this$0.a.g(this.a, paramValueAnimator.x, paramValueAnimator.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alhd
 * JD-Core Version:    0.7.0.1
 */