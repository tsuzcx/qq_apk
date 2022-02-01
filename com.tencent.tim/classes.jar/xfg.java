import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import java.util.ArrayList;

final class xfg
  implements xeh.b
{
  public int b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface = (MessageForArkBabyqReply)paramChatMessage;
    if ((paramQQAppInterface.mArkBabyqReplyCardList == null) || (paramQQAppInterface.mArkBabyqReplyCardList.size() <= 0)) {
      return 83;
    }
    return 82;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xfg
 * JD-Core Version:    0.7.0.1
 */