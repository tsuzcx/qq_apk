import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;

public class vgw
  implements ValueAnimator.AnimatorUpdateListener
{
  public vgw(SixCombolEffectView paramSixCombolEffectView, vhg paramvhg) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_Vhg.b = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSixCombolEffectView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vgw
 * JD-Core Version:    0.7.0.1
 */