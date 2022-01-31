import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class vus
  implements Runnable
{
  public vus(HotChatPie paramHotChatPie) {}
  
  public void run()
  {
    TroopHandler localTroopHandler = (TroopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (localTroopHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseTroopChatPieQ.hotchat.aio_post_red_point", 2, "send_oidb_0x8c9_2");
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(1105933138L));
      localTroopHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localArrayList, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vus
 * JD-Core Version:    0.7.0.1
 */