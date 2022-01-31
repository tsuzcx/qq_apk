import com.dataline.util.WaitEvent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

public class fjq
  implements Runnable
{
  public fjq(QQMessageFacade paramQQMessageFacade, DataLineMsgRecord paramDataLineMsgRecord, WaitEvent paramWaitEvent) {}
  
  public void run()
  {
    EntityManager localEntityManager = QQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade).a().createEntityManager();
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time == 0L) {
        this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time = MessageCache.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgseq == 0L) {
        this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgseq = ((int)this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time);
      }
      RecentUserProxy localRecentUserProxy = QQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade).a().a();
      RecentUser localRecentUser = localRecentUserProxy.a(String.valueOf(AppConstants.P), 6000);
      localRecentUser.type = 6000;
      localRecentUser.lastmsgtime = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time;
      localRecentUserProxy.a(localRecentUser);
      QQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade, this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord, localEntityManager);
      long l = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgId;
      QQMessageFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.notifyObservers(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord);
      this.jdField_a_of_type_ComDatalineUtilWaitEvent.a();
      localEntityManager.a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "mr.msgId: " + l);
      }
      return;
    }
    finally
    {
      localEntityManager.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fjq
 * JD-Core Version:    0.7.0.1
 */