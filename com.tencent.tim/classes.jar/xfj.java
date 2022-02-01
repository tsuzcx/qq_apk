import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPoke;

final class xfj
  implements xeh.b
{
  public int b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface = (MessageForPoke)paramChatMessage;
    if ((paramQQAppInterface.interactType == 126) && (!xks.isSupported(paramQQAppInterface.minVersion))) {
      return 0;
    }
    return 62;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xfj
 * JD-Core Version:    0.7.0.1
 */