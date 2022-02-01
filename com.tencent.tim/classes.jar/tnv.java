import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.imcore.message.BaseMessageProcessor.1;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lmsf.msgcomm.msg_comm.Msg;>;
import java.util.Set;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;

public abstract class tnv
{
  protected MessageHandler a;
  public QQAppInterface app;
  protected QQMessageFacade c;
  private List<acrh> pV = new ArrayList();
  
  public tnv(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    this.app = paramQQAppInterface;
    this.a = paramMessageHandler;
    this.c = paramQQAppInterface.b();
  }
  
  protected Pair<Boolean, StringBuilder> a(List<msg_comm.Msg> paramList1, List<msg_comm.Msg> paramList2)
  {
    if ((paramList1 == null) || (paramList1.size() == 0)) {
      return new Pair(Boolean.valueOf(false), null);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramList1.iterator();
    paramList1 = Boolean.valueOf(false);
    while (localIterator.hasNext())
    {
      Object localObject = (msg_comm.Msg)localIterator.next();
      if (((msg_comm.Msg)localObject).msg_head.has())
      {
        String str = a((msg_comm.Msg)localObject);
        if (localHashSet.contains(str))
        {
          localObject = Boolean.valueOf(true);
          paramList1 = (List<msg_comm.Msg>)localObject;
          if (QLog.isColorLevel())
          {
            localStringBuilder.append("< duplicatedMsg:").append(str).append(" >");
            paramList1 = (List<msg_comm.Msg>)localObject;
          }
        }
        for (;;)
        {
          break;
          localHashSet.add(str);
          paramList2.add(localObject);
        }
      }
    }
    return new Pair(paramList1, localStringBuilder);
  }
  
  protected String a(msg_comm.Msg paramMsg)
  {
    return String.valueOf(paramMsg.hashCode());
  }
  
  public tov a(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    return null;
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public void a(acrh paramacrh)
  {
    synchronized (this.pV)
    {
      this.pV.add(paramacrh);
      return;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramToServiceMsg.extraData.putLong("msgSeq", paramLong);
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        paramToServiceMsg.setNeedRemindSlowNetwork(true);
      }
      this.a.sendPbReq(paramToServiceMsg);
      return;
    }
    this.a.send(paramToServiceMsg);
  }
  
  public void a(String paramString, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    synchronized (this.pV)
    {
      Iterator localIterator = this.pV.iterator();
      if (localIterator.hasNext()) {
        ((acrh)localIterator.next()).a(getClass().getSimpleName(), paramString, paramBoolean1, paramInt, paramBoolean2, paramBoolean3);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, List<MessageRecord> arg3, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = top.a(???, this.app);
    synchronized (this.pV)
    {
      Iterator localIterator = this.pV.iterator();
      if (localIterator.hasNext()) {
        ((acrh)localIterator.next()).a(getClass().getSimpleName(), paramString, paramBoolean1, i, paramBoolean2, paramBoolean3);
      }
    }
  }
  
  protected void a(List<MessageRecord> paramList, ArrayList<MessageRecord> paramArrayList, boolean paramBoolean)
  {
    if (paramList.size() > 0)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if (!achp.a(this.app, localMessageRecord, paramBoolean)) {
          paramArrayList.add(localMessageRecord);
        }
      }
    }
  }
  
  public void a(msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "sendMsgReadConfirm");
    }
    a(true, true, false, 0L, new tnw(this, paramPbMsgReadedReportReq));
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong, tnv.a parama)
  {
    int i;
    if (paramLong == 0L)
    {
      i = amzo.seq;
      amzo.seq = i + 1;
      paramLong = i;
    }
    for (;;)
    {
      long l = System.currentTimeMillis();
      if (!paramBoolean1)
      {
        parama = parama.a();
        if (parama == null) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "processRequest cmd=" + parama.getServiceCmd() + ",reqSeq=" + paramLong);
        }
        a(parama, paramLong, paramBoolean2, paramBoolean3);
        return;
      }
      SendMessageHandler localSendMessageHandler = new SendMessageHandler();
      this.a.a(paramLong, localSendMessageHandler);
      i = 0;
      while (i < 9)
      {
        localSendMessageHandler.a(new BaseMessageProcessor.1(this, parama, paramLong, l, paramBoolean2, paramBoolean3));
        i += 1;
      }
      i = 0;
      label168:
      if (i < 3) {
        if (i != 0) {
          break label221;
        }
      }
      label221:
      for (paramLong = 480000L;; paramLong = (3 - i) * 480000 / 3 - i * 2000)
      {
        l = 480000 * i / 3;
        localSendMessageHandler.getClass();
        localSendMessageHandler.b(l, paramLong, "period");
        i += 1;
        break label168;
        break;
      }
    }
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    synchronized (this.pV)
    {
      Iterator localIterator = this.pV.iterator();
      if (localIterator.hasNext()) {
        ((acrh)localIterator.next()).g(paramInt, paramBoolean, paramObject);
      }
    }
  }
  
  protected boolean b(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    return achp.a(this.app, paramMessageRecord, paramBoolean);
  }
  
  protected void bN(String paramString, int paramInt) {}
  
  public void c(int paramInt, boolean paramBoolean, Object paramObject)
  {
    synchronized (this.pV)
    {
      Iterator localIterator = this.pV.iterator();
      if (localIterator.hasNext()) {
        ((acrh)localIterator.next()).h(paramInt, paramBoolean, paramObject);
      }
    }
  }
  
  public void f(int paramInt, Object... paramVarArgs) {}
  
  public void m(String paramString, int paramInt, long paramLong) {}
  
  public static abstract interface a
  {
    public abstract ToServiceMsg a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tnv
 * JD-Core Version:    0.7.0.1
 */