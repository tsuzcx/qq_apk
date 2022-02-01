import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;

public class bn
  implements ValueAnimator.AnimatorUpdateListener
{
  public bn(LiteActivity paramLiteActivity) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    LiteActivity.a(this.this$0).getLayoutParams().height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    LiteActivity.a(this.this$0).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     bn
 * JD-Core Version:    0.7.0.1
 */