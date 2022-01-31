import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;

class wzx
  implements ValueAnimator.AnimatorUpdateListener
{
  wzx(wzv paramwzv, int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = (int)((this.jdField_a_of_type_Int - this.b) * f);
    int j = this.b;
    int k = (int)(f * (this.c - this.d));
    int m = this.d;
    paramValueAnimator = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramValueAnimator.leftMargin = (i + j);
    paramValueAnimator.bottomMargin = (m + k);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wzx
 * JD-Core Version:    0.7.0.1
 */