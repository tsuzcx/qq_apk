import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.widget.RelativeLayout.LayoutParams;

class tsa
  implements ValueAnimator.AnimatorUpdateListener
{
  tsa(try paramtry, RelativeLayout.LayoutParams paramLayoutParams1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat, RelativeLayout.LayoutParams paramLayoutParams2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    try.a(this.jdField_a_of_type_Try, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams, f, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, this.d, this.e, this.jdField_a_of_type_Float);
    try.a(this.jdField_a_of_type_Try, this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams, f, try.a(this.jdField_a_of_type_Try));
    try.a(this.jdField_a_of_type_Try, try.a(this.jdField_a_of_type_Try), f, 0.2F, 1.7F, agej.a(34.0F, try.a(this.jdField_a_of_type_Try).getResources()));
    try.a(this.jdField_a_of_type_Try, try.b(this.jdField_a_of_type_Try), f, 0.2F, 2.0F, agej.a(34.0F, try.a(this.jdField_a_of_type_Try).getResources()));
    try.a(this.jdField_a_of_type_Try, try.c(this.jdField_a_of_type_Try), f, 0.2F, 2.0F, agej.a(34.0F, try.a(this.jdField_a_of_type_Try).getResources()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tsa
 * JD-Core Version:    0.7.0.1
 */