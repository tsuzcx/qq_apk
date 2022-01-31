import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.Map;

public class cyo
  implements Runnable
{
  public cyo(DatalineMessageManager paramDatalineMessageManager, DataLineMsgSet paramDataLineMsgSet) {}
  
  public void run()
  {
    boolean bool = false;
    Object localObject1;
    int i;
    if (DatalineMessageManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager).a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet) > 0)
    {
      localObject1 = MsgProxyUtils.a(String.valueOf(AppConstants.T), 6000);
      if (!this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.containsKey(localObject1)) {
        break label287;
      }
      bool = ((QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.get(localObject1)).hasReply;
      i = ((QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.get(localObject1)).counter;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.remove(localObject1);
    }
    for (;;)
    {
      if (DatalineMessageManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager).a().size() > 0L)
      {
        localObject1 = DatalineMessageManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager).a();
        localObject2 = new QQMessageFacade.Message();
        MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject2, (MessageRecord)localObject1);
        ((QQMessageFacade.Message)localObject2).emoRecentMsg = null;
        ((QQMessageFacade.Message)localObject2).counter = i;
        ((QQMessageFacade.Message)localObject2).hasReply = bool;
        this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a((QQMessageFacade.Message)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.put(MsgProxyUtils.a(((QQMessageFacade.Message)localObject2).frienduin, ((QQMessageFacade.Message)localObject2).istroop), localObject2);
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      localObject2 = ((RecentUserProxy)localObject2).a(String.valueOf(AppConstants.T), 6000);
      ((EntityManager)localObject1).a();
      if (localObject2 != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localObject2);
      }
      return;
      label287:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cyo
 * JD-Core Version:    0.7.0.1
 */