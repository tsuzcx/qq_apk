import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.widget.RotateCircleImageView;

public class zjd
  implements ValueAnimator.AnimatorUpdateListener
{
  public zjd(RotateCircleImageView paramRotateCircleImageView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    RotateCircleImageView.c(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zjd
 * JD-Core Version:    0.7.0.1
 */