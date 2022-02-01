import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class tyt
  implements ValueAnimator.AnimatorUpdateListener
{
  tyt(tyr paramtyr, RelativeLayout.LayoutParams paramLayoutParams1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat, RelativeLayout.LayoutParams paramLayoutParams2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    tyr.a(this.jdField_a_of_type_Tyr, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams, f, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, this.d, this.e, this.jdField_a_of_type_Float);
    tyr.a(this.jdField_a_of_type_Tyr, this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams, f, tyr.a(this.jdField_a_of_type_Tyr));
    tyr.a(this.jdField_a_of_type_Tyr, tyr.a(this.jdField_a_of_type_Tyr), f, 0.2F, 1.7F, AIOUtils.dp2px(34.0F, tyr.a(this.jdField_a_of_type_Tyr).getResources()));
    tyr.a(this.jdField_a_of_type_Tyr, tyr.b(this.jdField_a_of_type_Tyr), f, 0.2F, 2.0F, AIOUtils.dp2px(34.0F, tyr.a(this.jdField_a_of_type_Tyr).getResources()));
    tyr.a(this.jdField_a_of_type_Tyr, tyr.c(this.jdField_a_of_type_Tyr), f, 0.2F, 2.0F, AIOUtils.dp2px(34.0F, tyr.a(this.jdField_a_of_type_Tyr).getResources()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tyt
 * JD-Core Version:    0.7.0.1
 */