import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqstory.widget.circularreveal.CircularRevealCompatLayout;

class wex
  implements ValueAnimator.AnimatorUpdateListener
{
  wex(wew paramwew, CircularRevealCompatLayout paramCircularRevealCompatLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (wez)paramValueAnimator.getAnimatedValue();
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout.setRevealClip(paramValueAnimator.a, paramValueAnimator.b, paramValueAnimator.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wex
 * JD-Core Version:    0.7.0.1
 */