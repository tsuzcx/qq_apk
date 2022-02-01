import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class alvk
  extends alvm
{
  public alvk(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private HashMap<String, ArrayList<MessageRecord>> a(List<MessageRecord> paramList, ArrayList<ChatMessage> paramArrayList)
  {
    HashMap localHashMap = new HashMap(1);
    ArrayList localArrayList = new ArrayList(1);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord1 = (MessageRecord)paramList.next();
      if ((localMessageRecord1 instanceof MessageForMixedMsg))
      {
        Iterator localIterator = ((MessageForMixedMsg)localMessageRecord1).msgElemList.iterator();
        while (localIterator.hasNext())
        {
          MessageRecord localMessageRecord2 = (MessageRecord)localIterator.next();
          if (((localMessageRecord2 instanceof MessageForReplyText)) && (((MessageForReplyText)localMessageRecord2).getSourceMessage() != null))
          {
            localArrayList.add(localMessageRecord2);
            localHashMap.put(String.valueOf(localMessageRecord1.uniseq), localArrayList);
          }
        }
        paramArrayList.add((ChatMessage)localMessageRecord1);
      }
    }
    return localHashMap;
  }
  
  private void h(ajlf paramajlf)
  {
    if (this.mApp == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramajlf.Dr.iterator();
      while (localIterator.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)localIterator.next();
        if ((localChatMessage instanceof MessageForMixedMsg)) {
          ((ajcy)this.mApp.getManager(174)).a(paramajlf.sessionInfo, (MessageForMixedMsg)localChatMessage, false, ((MessageForMixedMsg)localChatMessage).forwardID);
        }
      }
    }
  }
  
  protected void c(ajlf paramajlf)
  {
    h(paramajlf);
  }
  
  protected void d(ajlf paramajlf)
  {
    int i = 0;
    Object localObject1 = paramajlf.Dr;
    ArrayList localArrayList = new ArrayList(1);
    Object localObject2 = (HashMap)paramajlf.mb;
    localObject2 = this.mApp;
    if (paramajlf.action != 2) {}
    for (boolean bool = true;; bool = false)
    {
      paramajlf.lG = a(a((QQAppInterface)localObject2, (List)localObject1, bool), localArrayList);
      paramajlf.Dr = localArrayList;
      if (paramajlf.lG.size() != 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReplyMsgController", 2, "preHandleData dstMsgMap is empty");
      }
      h(paramajlf);
      return;
    }
    if (paramajlf.action == 0) {}
    for (;;)
    {
      localObject1 = this.J.obtainMessage(i);
      ((Message)localObject1).obj = paramajlf;
      ((Message)localObject1).sendToTarget();
      return;
      if (paramajlf.action == 2) {
        i = 1;
      }
    }
  }
  
  protected void g(ajlf paramajlf)
  {
    h(paramajlf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alvk
 * JD-Core Version:    0.7.0.1
 */