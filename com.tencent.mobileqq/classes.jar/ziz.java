import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.widget.RotateCircleImageView;

public class ziz
  implements ValueAnimator.AnimatorUpdateListener
{
  public ziz(RotateCircleImageView paramRotateCircleImageView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    RotateCircleImageView.a(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ziz
 * JD-Core Version:    0.7.0.1
 */