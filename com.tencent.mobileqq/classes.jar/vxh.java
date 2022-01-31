import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import mqq.os.MqqHandler;

class vxh
  implements Runnable
{
  vxh(vxg paramvxg) {}
  
  public void run()
  {
    if (TroopChatPie.d(this.a.a)) {
      return;
    }
    TroopNotificationHelper.c(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    TroopNotificationHelper.c(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    Message localMessage = TroopChatPie.h(this.a.a).obtainMessage(29);
    localMessage.arg1 = 2;
    TroopChatPie.i(this.a.a).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vxh
 * JD-Core Version:    0.7.0.1
 */