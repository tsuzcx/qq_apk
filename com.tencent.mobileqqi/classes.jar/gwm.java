import android.os.Handler;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import java.util.Iterator;
import java.util.List;

public class gwm
  implements Runnable
{
  public gwm(TroopMessageManager paramTroopMessageManager, String paramString, int paramInt, long paramLong, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, boolean paramBoolean) {}
  
  public void run()
  {
    int j = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false);
    ChatMessage localChatMessage;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localChatMessage = (ChatMessage)((Iterator)localObject).next();
      } while (MsgProxyUtils.i(localChatMessage.msgtype));
    }
    for (int i = (int)localChatMessage.shmsgseq;; i = 0)
    {
      if (i <= this.jdField_a_of_type_Long + 1L) {}
      for (boolean bool = true; (j == i) || (i <= this.jdField_a_of_type_Long); bool = false)
      {
        if ((bool) && (this.jdField_a_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false));
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.g = bool;
        TroopMessageManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager).a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
        TroopMessageManager.d(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager).a.post(new gwn(this));
        return;
      }
      int k = (int)(i - this.jdField_a_of_type_Long);
      j = k;
      if (k > 15) {
        j = 15;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.d = j;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, j, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
      j = i;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gwm
 * JD-Core Version:    0.7.0.1
 */