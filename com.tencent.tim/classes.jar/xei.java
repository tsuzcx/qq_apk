import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;

final class xei
  implements xeh.b
{
  public int b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForLongTextMsg)) {
      return 63;
    }
    if ((paramChatMessage instanceof MessageForWantGiftMsg)) {
      return 72;
    }
    if (((MessageForText)paramChatMessage).locationUrl != null) {
      return 10;
    }
    if ((paramChatMessage.vipBubbleID == 100000L) && (!paramChatMessage.isSend())) {
      return 9;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xei
 * JD-Core Version:    0.7.0.1
 */