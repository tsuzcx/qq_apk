import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;

public class acm
  implements View.OnClickListener
{
  public acm(ChatBackgroundSettingActivity paramChatBackgroundSettingActivity, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.h == 0) {
      ChatBackgroundSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity, "OPENVIP_BUTTON", this.jdField_a_of_type_Int);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.h == 1)
      {
        ChatBackgroundSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity, "XUFEI_VIP", this.jdField_a_of_type_Int);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.h != 2);
    ChatBackgroundSettingActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity, "XUFEI_SVIP", this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     acm
 * JD-Core Version:    0.7.0.1
 */