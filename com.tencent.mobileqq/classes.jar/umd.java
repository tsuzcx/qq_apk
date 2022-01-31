import android.animation.Animator;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.anim.goldmsg.FlyIconAnimListener;
import com.tencent.mobileqq.activity.aio.anim.goldmsg.GoldMsgNumAnim;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.List;

public class umd
  extends FlyIconAnimListener
{
  public umd(GoldMsgNumAnim paramGoldMsgNumAnim, Pair paramPair)
  {
    super(paramPair);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (this.jdField_a_of_type_ComTencentUtilPair != null)
    {
      if (this.jdField_a_of_type_ComTencentUtilPair.first != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgNumAnim.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView((View)this.jdField_a_of_type_ComTencentUtilPair.first);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgNumAnim.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_ComTencentUtilPair);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("GoldMsgNumAnim", 4, "flyIconAnimListener.onAnimationEnd flyIconList size=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgNumAnim.jdField_a_of_type_JavaUtilList.size());
    }
    GoldMsgNumAnim.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgNumAnim);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     umd
 * JD-Core Version:    0.7.0.1
 */