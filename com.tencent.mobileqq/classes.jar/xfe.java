import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgDBHelper;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgDBHelper.NotifyMsgRecord;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.WaitRecord;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public final class xfe
  implements Runnable
{
  public void run()
  {
    long l1;
    long l2;
    do
    {
      synchronized (NotifyMsgManager.jdField_a_of_type_JavaLangObject)
      {
        if (NotifyMsgManager.jdField_a_of_type_ComTencentMobileqqActivityQwalletNotifymsgNotifyMsgDBHelper == null) {
          NotifyMsgManager.jdField_a_of_type_ComTencentMobileqqActivityQwalletNotifymsgNotifyMsgDBHelper = new NotifyMsgDBHelper(BaseApplicationImpl.getContext());
        }
        ??? = QWalletTools.a();
        if (??? == null) {
          return;
        }
      }
      if (NotifyMsgManager.jdField_a_of_type_ComTencentMobileqqActivityQwalletNotifymsgNotifyMsgDBHelper != null) {
        NotifyMsgManager.jdField_a_of_type_ComTencentMobileqqActivityQwalletNotifymsgNotifyMsgDBHelper.a(((QQAppInterface)???).c(), NotifyMsgManager.c);
      }
      if (QLog.isColorLevel()) {
        QLog.i("NotifyMsgManager", 2, "loadFromDb completed");
      }
      Object localObject3 = new ArrayList();
      Object localObject4 = new ArrayList();
      int i = 0;
      if (i < NotifyMsgManager.b.size())
      {
        NotifyMsgDBHelper.NotifyMsgRecord localNotifyMsgRecord1 = (NotifyMsgDBHelper.NotifyMsgRecord)NotifyMsgManager.b.get(i);
        if (localNotifyMsgRecord1 == null) {}
        for (;;)
        {
          i += 1;
          break;
          NotifyMsgDBHelper.NotifyMsgRecord localNotifyMsgRecord2 = NotifyMsgManager.a(NotifyMsgManager.c, localNotifyMsgRecord1.b, localNotifyMsgRecord1.a);
          if (localNotifyMsgRecord2 != null)
          {
            ((ArrayList)localObject4).add(NotifyMsgManager.a(localNotifyMsgRecord1, localNotifyMsgRecord2));
          }
          else
          {
            NotifyMsgManager.c.add(localNotifyMsgRecord1);
            ((ArrayList)localObject3).add(localNotifyMsgRecord1);
          }
        }
      }
      NotifyMsgManager.b.clear();
      if (((ArrayList)localObject3).size() > 0) {
        NotifyMsgManager.a((ArrayList)localObject3, true);
      }
      if (((ArrayList)localObject4).size() > 0) {
        NotifyMsgManager.a((ArrayList)localObject4, false);
      }
      NotifyMsgManager.jdField_a_of_type_Int = 2;
      NotifyMsgManager.a(NotifyMsgManager.jdField_a_of_type_JavaUtilArrayList);
      localObject3 = NotifyMsgManager.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (NotifyMsgManager.WaitRecord)((Iterator)localObject3).next();
        if (localObject4 != null) {
          NotifyMsgManager.a((NotifyMsgManager.WaitRecord)localObject4);
        }
      }
      NotifyMsgManager.jdField_a_of_type_JavaUtilArrayList.clear();
      l1 = QWalletSetting.a(((QQAppInterface)???).c(), "qwallet_last_clear_notify_time_", 0L);
      l2 = NetConnInfoCenter.getServerTime();
    } while ((NotifyMsgManager.jdField_a_of_type_ComTencentMobileqqActivityQwalletNotifymsgNotifyMsgDBHelper == null) || ((l1 <= l2) && (l2 - l1 <= 172800L)));
    NotifyMsgManager.jdField_a_of_type_ComTencentMobileqqActivityQwalletNotifymsgNotifyMsgDBHelper.a(2592000L, null);
    NotifyMsgManager.jdField_a_of_type_ComTencentMobileqqActivityQwalletNotifymsgNotifyMsgDBHelper.a(172800L, new int[] { 2 });
    QWalletSetting.a(((QQAppInterface)???).c(), "qwallet_last_clear_notify_time_", l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xfe
 * JD-Core Version:    0.7.0.1
 */