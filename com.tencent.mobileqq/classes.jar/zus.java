import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import mqq.os.MqqHandler;

public class zus
  implements Runnable
{
  public zus(TroopHandler paramTroopHandler, MessageForReplyText paramMessageForReplyText, int paramInt) {}
  
  public void run()
  {
    ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.b.a().c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.mSourceMsgInfo.mSourceMsgSeq);
    if (localChatMessage != null) {
      ThreadManager.getUIHandler().post(new zut(this, localChatMessage));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zus
 * JD-Core Version:    0.7.0.1
 */