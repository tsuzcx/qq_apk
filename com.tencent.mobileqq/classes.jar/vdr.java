import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;

public class vdr
  implements ValueAnimator.AnimatorUpdateListener
{
  public vdr(SixCombolEffectView paramSixCombolEffectView, vee paramvee) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Vee.a = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if ((!this.jdField_a_of_type_Vee.b) && (this.jdField_a_of_type_Vee.a < 0.52F)) {
      this.jdField_a_of_type_Vee.b = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vdr
 * JD-Core Version:    0.7.0.1
 */