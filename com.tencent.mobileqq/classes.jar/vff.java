import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.item.HeartCombolEffectView;

public class vff
  implements ValueAnimator.AnimatorUpdateListener
{
  public vff(HeartCombolEffectView paramHeartCombolEffectView, vfh paramvfh) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Vfh.jdField_b_of_type_Float = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if ((!this.jdField_a_of_type_Vfh.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Vfh.jdField_b_of_type_Float > 0.0F)) {
      this.jdField_a_of_type_Vfh.jdField_b_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vff
 * JD-Core Version:    0.7.0.1
 */