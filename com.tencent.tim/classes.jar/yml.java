import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryForTroopFragment;
import com.tencent.mobileqq.activity.chathistory.TroopAIOImageGeter.a;
import com.tencent.qphone.base.util.QLog;

public class yml
  implements TroopAIOImageGeter.a
{
  public yml(ChatHistoryForTroopFragment paramChatHistoryForTroopFragment) {}
  
  public void b(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt)
  {
    if ((paramArrayOfAIORichMediaData != null) && (paramArrayOfAIORichMediaData.length > 0))
    {
      this.a.f = paramArrayOfAIORichMediaData[(paramArrayOfAIORichMediaData.length - 1)];
      if (QLog.isColorLevel()) {
        QLog.i("chatHistory.troop.portal", 2, "get the first media data");
      }
    }
    do
    {
      return;
      this.a.f = null;
    } while (!QLog.isColorLevel());
    QLog.i("chatHistory.troop.portal", 2, "no media data found");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yml
 * JD-Core Version:    0.7.0.1
 */