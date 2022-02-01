import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.widget.circularreveal.CircularRevealCompatLayout;

class zve
  implements ValueAnimator.AnimatorUpdateListener
{
  zve(zvd paramzvd, CircularRevealCompatLayout paramCircularRevealCompatLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (zvg)paramValueAnimator.getAnimatedValue();
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout.setRevealClip(paramValueAnimator.a, paramValueAnimator.b, paramValueAnimator.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zve
 * JD-Core Version:    0.7.0.1
 */