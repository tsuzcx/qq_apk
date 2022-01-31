import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;

public class wab
  implements Runnable
{
  public wab(TroopChatPie paramTroopChatPie, boolean paramBoolean) {}
  
  public void run()
  {
    TroopGagMgr.SelfGagInfo localSelfGagInfo = ((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.jdField_a_of_type_Boolean);
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.b.obtainMessage(2);
    localMessage.obj = localSelfGagInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.b.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wab
 * JD-Core Version:    0.7.0.1
 */