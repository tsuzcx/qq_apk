import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.PointF;
import android.view.View;

class vqr
  implements ValueAnimator.AnimatorUpdateListener
{
  vqr(vqo paramvqo, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (PointF)paramValueAnimator.getAnimatedValue();
    this.jdField_a_of_type_AndroidViewView.setX(paramValueAnimator.x);
    this.jdField_a_of_type_AndroidViewView.setY(paramValueAnimator.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqr
 * JD-Core Version:    0.7.0.1
 */