import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.item.HeartCombolEffectView;

public class uxc
  implements ValueAnimator.AnimatorUpdateListener
{
  public uxc(HeartCombolEffectView paramHeartCombolEffectView, uxe paramuxe) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Uxe.jdField_b_of_type_Float = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if ((!this.jdField_a_of_type_Uxe.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Uxe.jdField_b_of_type_Float > 0.0F)) {
      this.jdField_a_of_type_Uxe.jdField_b_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uxc
 * JD-Core Version:    0.7.0.1
 */