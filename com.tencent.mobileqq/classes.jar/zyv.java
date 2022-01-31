import android.os.Handler;
import com.tencent.mobileqq.app.message.BaseMessageManagerForTroopAndDisc;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.Iterator;
import java.util.List;

public class zyv
  implements Runnable
{
  public zyv(BaseMessageManagerForTroopAndDisc paramBaseMessageManagerForTroopAndDisc, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext, String paramString, int paramInt, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManagerForTroopAndDisc.b(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
    int j = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManagerForTroopAndDisc.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
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
      } while (MsgProxyUtils.a(localChatMessage));
    }
    for (int i = (int)localChatMessage.shmsgseq;; i = 0)
    {
      if (i <= this.jdField_a_of_type_Long + 1L) {}
      for (boolean bool = true; (j == i) || (i <= this.jdField_a_of_type_Long); bool = false)
      {
        if ((bool) && (this.jdField_a_of_type_Boolean)) {
          BaseMessageManagerForTroopAndDisc.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManagerForTroopAndDisc, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManagerForTroopAndDisc.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int));
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.g = bool;
        this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManagerForTroopAndDisc.a.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManagerForTroopAndDisc.a.a.post(new zyw(this));
        return;
      }
      int k = (int)(i - this.jdField_a_of_type_Long);
      j = k;
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManagerForTroopAndDisc.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, k).size() != k)
      {
        j = k;
        if (k > 15) {
          j = 15;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.e = j;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageBaseMessageManagerForTroopAndDisc.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, j, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
      j = i;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zyv
 * JD-Core Version:    0.7.0.1
 */