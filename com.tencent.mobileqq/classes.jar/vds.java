import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;

public class vds
  implements ValueAnimator.AnimatorUpdateListener
{
  public vds(SixCombolEffectView paramSixCombolEffectView, vee paramvee) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Vee.a = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vds
 * JD-Core Version:    0.7.0.1
 */