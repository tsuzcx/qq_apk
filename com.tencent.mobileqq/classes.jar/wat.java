import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

public class wat
  implements Animation.AnimationListener
{
  public wat(TroopChatPie paramTroopChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.q.setVisibility(8);
    this.a.r.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.a);
    if (!this.a.E)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130845871);
      this.a.m.setVisibility(8);
      paramAnimation = this.a.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131494212);
      this.a.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramAnimation);
    }
    for (;;)
    {
      this.a.b.setBackgroundResource(2130845635);
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130845872);
      this.a.m.setVisibility(8);
      paramAnimation = this.a.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131494213);
      this.a.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wat
 * JD-Core Version:    0.7.0.1
 */