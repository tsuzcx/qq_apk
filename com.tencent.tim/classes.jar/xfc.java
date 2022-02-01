import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForShortVideo;

final class xfc
  implements xeh.b
{
  public int b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForLightVideo)) {
      return 103;
    }
    switch (((MessageForShortVideo)paramChatMessage).busiType)
    {
    default: 
      return 29;
    case 1: 
      return 38;
    case 2: 
      return 46;
    case 1007: 
      return 40;
    }
    return 41;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xfc
 * JD-Core Version:    0.7.0.1
 */