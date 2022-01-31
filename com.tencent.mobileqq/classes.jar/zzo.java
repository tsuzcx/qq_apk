import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.Map;

public class zzo
  implements Runnable
{
  public zzo(DatalineMessageManager paramDatalineMessageManager, DataLineMsgSet paramDataLineMsgSet) {}
  
  public void run()
  {
    boolean bool = false;
    Object localObject1;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.a().a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet) > 0)
    {
      localObject1 = MsgProxyUtils.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_Int);
      if (!this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.containsKey(localObject1)) {
        break label384;
      }
      bool = ((QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.get(localObject1)).hasReply;
      i = ((QQMessageFacade.Message)this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.get(localObject1)).counter;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.remove(localObject1);
    }
    for (;;)
    {
      long l = this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.a().a().size();
      if (l > 0L)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.a().a();
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((DataLineMsgRecord)localObject2).msgtype == -5000)
          {
            localObject1 = localObject2;
            if (l > 1L) {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.a().a().get((int)(l - 2L)).getLastItem();
            }
          }
        }
        localObject2 = new QQMessageFacade.Message();
        if (localObject1 != null)
        {
          MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject2, (MessageRecord)localObject1);
          ((QQMessageFacade.Message)localObject2).emoRecentMsg = null;
          ((QQMessageFacade.Message)localObject2).counter = i;
          ((QQMessageFacade.Message)localObject2).hasReply = bool;
          this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a((QQMessageFacade.Message)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a.put(MsgProxyUtils.a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_Int), localObject2);
        }
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      localObject2 = ((RecentUserProxy)localObject2).a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_Int);
      ((EntityManager)localObject1).a();
      if (localObject2 != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageDatalineMessageManager.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localObject2);
      }
      return;
      label384:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zzo
 * JD-Core Version:    0.7.0.1
 */