import android.os.SystemClock;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class wgr
  implements Runnable
{
  public wgr(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    int j = 0;
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int).e(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    int k;
    int i;
    label92:
    int m;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      if (((List)localObject).size() > 3) {
        break label160;
      }
      k = ((List)localObject).size();
      Iterator localIterator = ((List)localObject).iterator();
      i = 0;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          if (localMessageRecord != null) {
            if (localMessageRecord.msgtype == -2058)
            {
              m = j + 1;
              j = i;
              i = m;
              label140:
              if (j < k) {
                break label178;
              }
              if (QLog.isColorLevel()) {
                QLog.i("Q.aio.TroopChatPie", 2, "AIO has more than 3 normal message, so return!");
              }
            }
          }
        }
      }
    }
    label160:
    label178:
    do
    {
      do
      {
        return;
        k = 3;
        break;
        m = i + 1;
        i = j;
        j = m;
        break label140;
        m = j;
        j = i;
        i = m;
        break label92;
      } while (j <= ((List)localObject).size() / 2);
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.TroopChatPie", 2, "now pull more message for troop!");
      }
      TroopChatPie.a(this.a, SystemClock.uptimeMillis());
      ((ChatContext)TroopChatPie.a(this.a).a).a(TroopChatPie.a(this.a));
      TroopChatPie.b(this.a).e = MsgProxyUtils.c((List)localObject);
      TroopChatPie.c(this.a).f = true;
    } while (TroopChatPie.d(this.a).c != 0);
    localObject = TroopChatPie.e(this.a);
    ((QQMessageFacade.RefreshMessageContext)localObject).c += 1;
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 15, TroopChatPie.f(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wgr
 * JD-Core Version:    0.7.0.1
 */