import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;

class yxb
  implements ValueAnimator.AnimatorUpdateListener
{
  yxb(ywy paramywy, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if ((localLayoutParams instanceof LinearLayout.LayoutParams))
    {
      ((LinearLayout.LayoutParams)localLayoutParams).topMargin = paramValueAnimator.intValue();
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yxb
 * JD-Core Version:    0.7.0.1
 */