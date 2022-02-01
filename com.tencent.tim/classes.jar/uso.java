import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class uso
  extends acmc
{
  public uso(Conversation paramConversation) {}
  
  public void fN(List<String> paramList)
  {
    acxw localacxw;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localacxw = this.this$0.app.a();
      if (localacxw != null) {
        break label37;
      }
      QLog.d("Q.recent", 1, "onBatchDelete, proxy == null");
    }
    for (;;)
    {
      return;
      label37:
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RecentUser localRecentUser = localacxw.a((String)paramList.next(), 0);
        if (localRecentUser != null) {
          localacxw.f(localRecentUser);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uso
 * JD-Core Version:    0.7.0.1
 */