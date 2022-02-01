import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class acsu
{
  private QQMessageFacade.Message b;
  private QQAppInterface mApp;
  private final List<QQMessageFacade.Message> messages = new ArrayList();
  
  public acsu(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  private QQMessageFacade.Message a(List<QQMessageFacade.Message> paramList, MessageRecord paramMessageRecord)
  {
    Object localObject;
    if ((paramList == null) || (paramMessageRecord == null))
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramList.size()) {
        break label59;
      }
      QQMessageFacade.Message localMessage = (QQMessageFacade.Message)paramList.get(i);
      localObject = localMessage;
      if (d(localMessage, paramMessageRecord)) {
        break;
      }
      i += 1;
    }
    label59:
    return null;
  }
  
  private boolean d(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return top.u(paramMessageRecord1.frienduin, paramMessageRecord1.istroop).equals(top.u(paramMessageRecord2.frienduin, paramMessageRecord2.istroop));
  }
  
  public int Bi()
  {
    return w(false);
  }
  
  public int Bj()
  {
    return x(false);
  }
  
  public void Kk(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "showNotificationMsg type:" + paramInt);
    }
    if ((!this.mApp.isBackground_Pause) || (this.messages.size() == 0)) {
      return;
    }
    synchronized (this.messages)
    {
      Iterator localIterator = this.messages.iterator();
      while (localIterator.hasNext()) {
        if (((QQMessageFacade.Message)localIterator.next()).istroop == paramInt) {
          localIterator.remove();
        }
      }
    }
    if (!this.messages.isEmpty()) {}
    for (QQMessageFacade.Message localMessage = (QQMessageFacade.Message)this.messages.get(this.messages.size() - 1);; localMessage = null)
    {
      this.mApp.a(localMessage, null);
      return;
    }
  }
  
  public void Z(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "revokeNotificationMsg, " + paramMessageRecord);
    }
    if ((!this.mApp.isBackground_Pause) || (this.messages.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, new Object[] { "revokeNotificationMsg, isBackground: ", Boolean.valueOf(this.mApp.isBackground_Pause) });
      }
      return;
    }
    QQMessageFacade.Message localMessage;
    synchronized (this.messages)
    {
      localMessage = a(this.messages, paramMessageRecord);
      if ((localMessage == null) || (localMessage.msgInfoList == null) || (localMessage.msgInfoList.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("notification", 2, "revokeNotificationMsg, conversation not in cache");
        }
        return;
      }
    }
    int k = localMessage.msgInfoList.size();
    int i = k - 1;
    for (;;)
    {
      acsu.a locala;
      int j;
      if (i >= 0)
      {
        locala = (acsu.a)localMessage.msgInfoList.get(i);
        if ((locala.uinType == 3000) || (locala.uinType == 1))
        {
          if (locala.shmsgseq != paramMessageRecord.shmsgseq) {
            break label486;
          }
          j = i;
        }
      }
      for (;;)
      {
        if (j == -1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("notification", 2, "revokeNotificationMsg, not in cache");
          }
          return;
          if (locala.msguid != paramMessageRecord.msgUid) {
            break;
          }
          j = i;
          if (locala.shmsgseq != paramMessageRecord.shmsgseq) {
            break;
          }
        }
        else
        {
          if ((j == k - 1) && (k > 1))
          {
            paramMessageRecord = (acsu.a)localMessage.msgInfoList.get(k - 2);
            MessageRecord.copyMessageRecordBaseField(localMessage, this.mApp.b().a(paramMessageRecord.friendUin, paramMessageRecord.uinType, paramMessageRecord.uniseq));
            localMessage.emoRecentMsg = null;
            localMessage.fileType = -1;
            this.mApp.b().b(localMessage);
            if (QLog.isColorLevel()) {
              QLog.d("notification", 2, "revokeNotificationMsg, match the last msg");
            }
          }
          localMessage.msgInfoList.remove(j);
          localMessage.counter -= 1;
          if ((localMessage.counter <= 0) || (localMessage.msgInfoList.isEmpty())) {
            this.messages.remove(localMessage);
          }
          if (!this.messages.isEmpty()) {}
          for (paramMessageRecord = (QQMessageFacade.Message)this.messages.get(this.messages.size() - 1);; paramMessageRecord = null)
          {
            this.mApp.a(paramMessageRecord, localMessage);
            return;
          }
          j = -1;
        }
      }
      label486:
      i -= 1;
    }
  }
  
  public QQMessageFacade.Message a()
  {
    return this.b;
  }
  
  public void cOC()
  {
    synchronized (this.messages)
    {
      this.messages.clear();
      return;
    }
  }
  
  public void cOD()
  {
    synchronized (this.messages)
    {
      Iterator localIterator = this.messages.iterator();
      if (localIterator.hasNext())
      {
        QQMessageFacade.Message localMessage = (QQMessageFacade.Message)localIterator.next();
        localMessage.counter = 0;
        localMessage.msgInfoList = null;
      }
    }
    this.messages.clear();
  }
  
  public void e(QQMessageFacade.Message paramMessage)
  {
    this.b = paramMessage;
  }
  
  public void ea(String paramString, int paramInt)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("notification", 2, "removeNotification uin" + paramString + ",type:" + paramInt);
    }
    if ((!this.mApp.isBackground_Pause) || (this.messages.size() == 0)) {
      return;
    }
    for (;;)
    {
      Object localObject2;
      synchronized (this.messages)
      {
        Iterator localIterator = this.messages.iterator();
        if (!localIterator.hasNext()) {
          break label325;
        }
        localObject2 = (QQMessageFacade.Message)localIterator.next();
        if (((paramInt == ((QQMessageFacade.Message)localObject2).istroop) || ((top.fv(paramInt)) && (top.fv(((QQMessageFacade.Message)localObject2).istroop)))) && (((QQMessageFacade.Message)localObject2).frienduin.equals(paramString)))
        {
          ((QQMessageFacade.Message)localObject2).counter = 0;
          localIterator.remove();
          bool1 = true;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder().append("removeNotification remove:").append(bool1).append(",preMsg is null");
            if (localObject1 != null) {
              break label303;
            }
            bool2 = true;
            QLog.d("notification", 2, bool2 + ",iterator.hasNext():" + localIterator.hasNext());
          }
          if (bool1)
          {
            if ((localObject1 != null) || (!localIterator.hasNext())) {
              break label322;
            }
            localObject1 = (QQMessageFacade.Message)localIterator.next();
            if ((!ausb.ne(paramInt)) || (!ausb.tb(paramString))) {
              break label309;
            }
            ausb.a(this.mApp).ZA(paramString);
          }
          return;
        }
      }
      localObject1 = localObject2;
      continue;
      label303:
      boolean bool2 = false;
      continue;
      label309:
      this.mApp.a((QQMessageFacade.Message)localObject1, null);
      continue;
      label322:
      continue;
      label325:
      boolean bool1 = false;
    }
  }
  
  public List<QQMessageFacade.Message> ek()
  {
    synchronized (this.messages)
    {
      List localList2 = (List)((ArrayList)this.messages).clone();
      return localList2;
    }
  }
  
  public void g(QQMessageFacade.Message paramMessage)
  {
    synchronized (this.messages)
    {
      Object localObject = a(this.messages, paramMessage);
      if (localObject != null)
      {
        paramMessage.msgInfoList = ((QQMessageFacade.Message)localObject).msgInfoList;
        this.messages.set(this.messages.indexOf(localObject), paramMessage);
        if (paramMessage.msgInfoList == null) {
          paramMessage.msgInfoList = new ArrayList();
        }
        localObject = new acsu.a(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq, paramMessage.msgUid, paramMessage.shmsgseq);
        paramMessage.msgInfoList.add(localObject);
        return;
      }
      this.messages.add(paramMessage);
    }
  }
  
  public int gJ(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      synchronized (this.messages)
      {
        Iterator localIterator = this.messages.iterator();
        if (localIterator.hasNext())
        {
          QQMessageFacade.Message localMessage = (QQMessageFacade.Message)localIterator.next();
          if (localMessage.istroop == paramInt) {
            i = localMessage.counter + i;
          }
        }
        else
        {
          return i;
        }
      }
    }
  }
  
  public int w(boolean paramBoolean)
  {
    synchronized (this.messages)
    {
      Iterator localIterator = this.messages.iterator();
      label20:
      QQMessageFacade.Message localMessage;
      for (int i = 0; localIterator.hasNext(); i = localMessage.counter + i)
      {
        localMessage = (QQMessageFacade.Message)localIterator.next();
        if ((localMessage.istroop == 1037) || (localMessage.istroop == 1044) || (localMessage.istroop == 1045) || ((paramBoolean) && (ausb.g(localMessage)))) {
          break label20;
        }
      }
      return i;
    }
  }
  
  public int x(boolean paramBoolean)
  {
    synchronized (this.messages)
    {
      Iterator localIterator = this.messages.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        QQMessageFacade.Message localMessage = (QQMessageFacade.Message)localIterator.next();
        if ((localMessage.istroop != 1008) && (localMessage.istroop != 1037) && (localMessage.istroop != 1044) && (localMessage.istroop != 1045) && ((!paramBoolean) || (!ausb.g(localMessage))))
        {
          if (7000 != localMessage.istroop) {
            break label166;
          }
          anxr localanxr = (anxr)this.mApp.getManager(61);
          if (localanxr == null) {
            break label157;
          }
          j = localanxr.ez(localMessage.frienduin);
          break label159;
        }
      }
      return i;
    }
    label157:
    int j = 0;
    label159:
    int i = j + i;
    for (;;)
    {
      break;
      label166:
      i += 1;
    }
  }
  
  public static class a
  {
    public String friendUin;
    public long msguid;
    public long shmsgseq;
    public int uinType;
    public long uniseq;
    
    public a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
    {
      this.friendUin = paramString;
      this.uinType = paramInt;
      this.uniseq = paramLong1;
      this.msguid = paramLong2;
      this.shmsgseq = paramLong3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acsu
 * JD-Core Version:    0.7.0.1
 */