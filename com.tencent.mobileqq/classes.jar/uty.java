import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.anim.goldmsg.GoldMsgAnimatorCtr;
import com.tencent.mobileqq.activity.aio.anim.goldmsg.GoldMsgLayAnim;
import com.tencent.qphone.base.util.QLog;

public class uty
  implements ValueAnimator.AnimatorUpdateListener
{
  public uty(GoldMsgLayAnim paramGoldMsgLayAnim) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    float f = i / 100.0F;
    int j = (int)(this.a.jdField_b_of_type_Int * f);
    if (QLog.isDevelopLevel()) {
      QLog.i("GoldMsgLayAnim", 4, "updateTextView currentValue=" + i + ",fraction=" + f + ",textOldWidth=" + this.a.jdField_b_of_type_Int + ",textNewWidth=" + j);
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams().width = j;
    this.a.jdField_a_of_type_AndroidWidgetTextView.setAlpha(f);
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
    if ((paramValueAnimator == this.a.jdField_a_of_type_AndroidAnimationValueAnimator) && (i == 100)) {
      this.a.a();
    }
    while ((paramValueAnimator != this.a.jdField_b_of_type_AndroidAnimationValueAnimator) || (i != 0)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uty
 * JD-Core Version:    0.7.0.1
 */