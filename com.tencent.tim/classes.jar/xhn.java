import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopSign;

final class xhn
  implements xeh.b
{
  public int b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (TextUtils.isEmpty(((MessageForTroopSign)paramChatMessage).dynamicSource)) {
      return 71;
    }
    return 84;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xhn
 * JD-Core Version:    0.7.0.1
 */