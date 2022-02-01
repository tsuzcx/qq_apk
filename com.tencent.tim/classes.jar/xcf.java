import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.immersion.stickersampleapp.HapticManager;
import com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.ViewAnimation;
import com.tencent.qphone.base.util.QLog;

class xcf
  extends AnimatorListenerAdapter
{
  xcf(xbu paramxbu, xbu.a parama, MessageForPoke paramMessageForPoke) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    int i = 1;
    super.onAnimationEnd(paramAnimator);
    xbu.bgT = false;
    this.jdField_a_of_type_Xbu$a.h.setVisibility(8);
    this.jdField_a_of_type_Xbu$a.hD.setVisibility(0);
    this.jdField_a_of_type_Xbu$a.a.clearAnimation();
    this.jdField_a_of_type_Xbu$a.a.setVisibility(8);
    if ((!this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.isSend()) && (this.jdField_a_of_type_Xbu$a.pos == xbu.access$400()) && (!(this.this$0.mContext instanceof ChatHistoryActivity)) && (!xbu.I(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke))) {
      this.jdField_a_of_type_Xbu$a.tb.setVisibility(0);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.isPlayed) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.setPlayed(this.this$0.mApp);
    }
    if (!xks.G("fullscreen", this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.subId))
    {
      if (abrj.a(this.this$0.mApp).cqT == 1) {
        i = 0;
      }
      if (i != 0)
      {
        abrb.b(this.this$0.mApp, "vas_poke", false);
        if (QLog.isColorLevel()) {
          QLog.i("GivingHeart.sprite", 2, "show sprite (normal) in bubble.");
        }
      }
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    xbu.bgT = true;
    if (xks.Sz()) {
      HapticManager.a().h(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.subId), 2);
    }
    xkr.a().q(7, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.subId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.isSend());
    if (this.this$0.g.isAnimating()) {
      this.this$0.g.endAnimation();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.isSend()) {
      this.this$0.a.setEnableXCoordinateMirrored(false);
    }
    for (;;)
    {
      xks.a(this.this$0.mApp, this.this$0.mContext, this.this$0.g, null, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.subId, "view_aio");
      return;
      this.this$0.a.setEnableXCoordinateMirrored(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xcf
 * JD-Core Version:    0.7.0.1
 */