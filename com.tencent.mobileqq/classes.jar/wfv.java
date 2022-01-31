import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import mqq.os.MqqHandler;

public class wfv
  implements Runnable
{
  public wfv(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    if (TroopChatPie.e(this.a)) {
      return;
    }
    Object localObject = (TroopInfoManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
    if (localObject != null) {
      ((TroopInfoManager)localObject).a(Long.valueOf(Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)), true).a();
    }
    TroopNotificationHelper.c(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    localObject = TroopChatPie.k(this.a).obtainMessage(29);
    ((Message)localObject).arg1 = 1;
    TroopChatPie.l(this.a).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wfv
 * JD-Core Version:    0.7.0.1
 */