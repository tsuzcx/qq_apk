import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.aio.anim.goldmsg.GoldMsgQueueView;
import com.tencent.mobileqq.activity.aio.anim.goldmsg.GoldMsgQueueView.DrawItem;
import java.util.List;

public class umg
  extends AnimatorListenerAdapter
{
  public umg(GoldMsgQueueView paramGoldMsgQueueView, boolean paramBoolean1, GoldMsgQueueView.DrawItem paramDrawItem, boolean paramBoolean2) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (this.b)
    {
      GoldMsgQueueView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgQueueView).remove(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgQueueView$DrawItem);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgQueueView$DrawItem.drawable != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgQueueView$DrawItem.drawable.setCallback(null);
      }
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgQueueView$DrawItem.isUseToShowNum = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     umg
 * JD-Core Version:    0.7.0.1
 */