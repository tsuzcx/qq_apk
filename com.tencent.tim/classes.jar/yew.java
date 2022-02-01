import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

public class yew
  implements Animation.AnimationListener
{
  public yew(TroopChatPie paramTroopChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.xE.setVisibility(8);
    this.this$0.xF.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.this$0.cL.setBackgroundDrawable(this.this$0.sessionInfo.a.img);
    if (!this.this$0.aey)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130851105);
      this.this$0.pz.setVisibility(8);
      paramAnimation = this.this$0.mContext.getResources().getColorStateList(2131167301);
      this.this$0.mTitleText.setTextColor(paramAnimation);
    }
    for (;;)
    {
      wja.S(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, 2130850842);
      return;
      this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130851106);
      this.this$0.pz.setVisibility(8);
      paramAnimation = this.this$0.mContext.getResources().getColorStateList(2131167302);
      this.this$0.mTitleText.setTextColor(paramAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yew
 * JD-Core Version:    0.7.0.1
 */