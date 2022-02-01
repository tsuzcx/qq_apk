import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.widget.RotateCircleImageView;

public class rtl
  implements ValueAnimator.AnimatorUpdateListener
{
  public rtl(RotateCircleImageView paramRotateCircleImageView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    RotateCircleImageView.c(this.b, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rtl
 * JD-Core Version:    0.7.0.1
 */