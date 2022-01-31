import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.BaseTroopView.ITroopContext;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class wpy
  implements View.OnClickListener
{
  public wpy(NotificationView paramNotificationView, structmsg.SystemMsg paramSystemMsg) {}
  
  public void onClick(View paramView)
  {
    TroopMemberCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationView.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a(), String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsg.group_code.get()), String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$SystemMsg.action_uin.get()), -1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wpy
 * JD-Core Version:    0.7.0.1
 */