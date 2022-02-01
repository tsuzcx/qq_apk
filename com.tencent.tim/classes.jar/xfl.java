import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;

final class xfl
  implements xeh.b
{
  public int b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface = ((MessageForUniteGrayTip)paramChatMessage).tipParam;
    if ((paramQQAppInterface != null) && (paramQQAppInterface.dbK == 655384)) {
      return 110;
    }
    return 64;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xfl
 * JD-Core Version:    0.7.0.1
 */