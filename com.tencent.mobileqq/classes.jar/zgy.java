import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class zgy
  implements Runnable
{
  public zgy(MessageHandler paramMessageHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler.trooptroop_pull_msg", 2, "onReceive,cost:" + (System.currentTimeMillis() - TroopMessageManager.b));
    }
    try
    {
      MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg, this.jdField_a_of_type_JavaLangObject, false);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MessageHandler", 2, "handleGetPullTroopMsgResp_PB exception ! ", localException);
      }
      MessageHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zgy
 * JD-Core Version:    0.7.0.1
 */