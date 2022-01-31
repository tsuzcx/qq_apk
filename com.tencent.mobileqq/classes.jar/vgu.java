import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;

public class vgu
  implements ValueAnimator.AnimatorUpdateListener
{
  public vgu(SixCombolEffectView paramSixCombolEffectView, vhg paramvhg) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Vhg.a = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vgu
 * JD-Core Version:    0.7.0.1
 */