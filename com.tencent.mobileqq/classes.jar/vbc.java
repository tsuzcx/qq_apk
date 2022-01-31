import android.view.View;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import mqq.os.MqqHandler;

class vbc
  implements Runnable
{
  vbc(vbb paramvbb, MessageForReplyText paramMessageForReplyText, View paramView) {}
  
  public void run()
  {
    ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_Vbb.a.a.a().c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.mSourceMsgInfo.mSourceMsgSeq);
    if ((localChatMessage != null) && (localChatMessage.msgtype != -2006) && (localChatMessage.isValid) && (localChatMessage.msgtype != -2032))
    {
      ThreadManager.getUIHandler().post(new vbd(this, localChatMessage));
      return;
    }
    ThreadManager.getUIHandler().post(new vbe(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vbc
 * JD-Core Version:    0.7.0.1
 */