import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.widget.RotateCircleImageView;

public class weo
  implements ValueAnimator.AnimatorUpdateListener
{
  public weo(RotateCircleImageView paramRotateCircleImageView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    RotateCircleImageView.a(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     weo
 * JD-Core Version:    0.7.0.1
 */