import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class alvj
  implements Manager
{
  private QQAppInterface app;
  private ConcurrentHashMap<Long, ChatMessage> fO = new ConcurrentHashMap();
  
  public alvj(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public void Y(ChatMessage paramChatMessage)
  {
    this.fO.put(Long.valueOf(paramChatMessage.uniseq), paramChatMessage);
  }
  
  public ChatMessage c(long paramLong)
  {
    return (ChatMessage)this.fO.get(Long.valueOf(paramLong));
  }
  
  public ChatMessage d(long paramLong)
  {
    return (ChatMessage)this.fO.remove(Long.valueOf(paramLong));
  }
  
  public void onDestroy()
  {
    this.fO.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alvj
 * JD-Core Version:    0.7.0.1
 */