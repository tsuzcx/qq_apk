import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class vol
  extends achq
{
  public vol(QQLSActivity paramQQLSActivity) {}
  
  public void b(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgRevoke", 4, "onMsgRevokeNotice isSuccess=" + paramBoolean1);
    }
    this.this$0.uiHandler.removeMessages(267387140);
    Object localObject1 = new ArrayList();
    Object localObject2;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add((ChatMessage)((Iterator)localObject2).next());
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgRevoke", 4, "onMsgRevokeNotice chatlist=" + ((List)localObject1).size());
    }
    if ((paramBoolean1) && (localObject1 != null) && (!((List)localObject1).isEmpty()) && (((ChatMessage)((List)localObject1).get(0) instanceof MessageForPtt)))
    {
      localObject1 = (MessageForPtt)((List)localObject1).get(0);
      localObject2 = MediaPlayerManager.a(QQLSActivity.a(this.this$0)).a();
      if ((localObject2 == localObject1) || (((localObject2 instanceof MessageForPtt)) && (((ChatMessage)localObject2).frienduin != null) && (((ChatMessage)localObject2).frienduin.equals(((MessageForPtt)localObject1).frienduin)) && (((ChatMessage)localObject2).uniseq == ((MessageForPtt)localObject1).uniseq))) {
        MediaPlayerManager.a(QQLSActivity.a(this.this$0)).stop(true);
      }
    }
    super.b(paramBoolean1, paramList, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vol
 * JD-Core Version:    0.7.0.1
 */