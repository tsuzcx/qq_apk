import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;

public class vgt
  implements ValueAnimator.AnimatorUpdateListener
{
  public vgt(SixCombolEffectView paramSixCombolEffectView, vhg paramvhg) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Vhg.a = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if ((!this.jdField_a_of_type_Vhg.b) && (this.jdField_a_of_type_Vhg.a < 0.52F)) {
      this.jdField_a_of_type_Vhg.b = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vgt
 * JD-Core Version:    0.7.0.1
 */