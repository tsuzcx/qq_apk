import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;

final class xgg
  implements xeh.b
{
  public int b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (((MessageForPic)paramChatMessage).isMixed) {
      return 24;
    }
    if (acfx.W(paramChatMessage)) {
      return 42;
    }
    if (acei.W(paramChatMessage)) {
      return 66;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xgg
 * JD-Core Version:    0.7.0.1
 */