import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;

public class vlv
  implements ValueAnimator.AnimatorUpdateListener
{
  public vlv(SixCombolEffectView paramSixCombolEffectView, vmi paramvmi) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Vmi.a = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if ((!this.jdField_a_of_type_Vmi.b) && (this.jdField_a_of_type_Vmi.a < 0.52F)) {
      this.jdField_a_of_type_Vmi.b = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vlv
 * JD-Core Version:    0.7.0.1
 */