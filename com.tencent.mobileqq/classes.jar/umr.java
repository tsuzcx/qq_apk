import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class umr
  implements ValueAnimator.AnimatorUpdateListener
{
  umr(ump paramump, RelativeLayout.LayoutParams paramLayoutParams1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat, RelativeLayout.LayoutParams paramLayoutParams2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    ump.a(this.jdField_a_of_type_Ump, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams, f, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, this.d, this.e, this.jdField_a_of_type_Float);
    ump.a(this.jdField_a_of_type_Ump, this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams, f, ump.a(this.jdField_a_of_type_Ump));
    ump.a(this.jdField_a_of_type_Ump, ump.a(this.jdField_a_of_type_Ump), f, 0.2F, 1.7F, AIOUtils.dp2px(34.0F, ump.a(this.jdField_a_of_type_Ump).getResources()));
    ump.a(this.jdField_a_of_type_Ump, ump.b(this.jdField_a_of_type_Ump), f, 0.2F, 2.0F, AIOUtils.dp2px(34.0F, ump.a(this.jdField_a_of_type_Ump).getResources()));
    ump.a(this.jdField_a_of_type_Ump, ump.c(this.jdField_a_of_type_Ump), f, 0.2F, 2.0F, AIOUtils.dp2px(34.0F, ump.a(this.jdField_a_of_type_Ump).getResources()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     umr
 * JD-Core Version:    0.7.0.1
 */