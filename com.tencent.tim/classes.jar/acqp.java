import android.os.Handler;
import android.os.Looper;
import com.dataline.activities.LiteActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager.1;
import com.tencent.mobileqq.app.message.DatalineMessageManager.2;
import com.tencent.mobileqq.app.message.DatalineMessageManager.3;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class acqp
  implements acqy
{
  public QQAppInterface app;
  public QQMessageFacade b;
  public String bqy = acbn.bkw;
  public int czi = 6000;
  
  public acqp(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    this.app = paramQQAppInterface;
    this.b = paramQQMessageFacade;
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, EntityManager paramEntityManager)
  {
    a().c(paramDataLineMsgRecord);
    paramEntityManager = a().a(paramDataLineMsgRecord.groupId);
    QQMessageFacade.Message localMessage = this.b.a(String.valueOf(this.bqy), this.czi);
    localMessage.selfuin = String.valueOf(this.bqy);
    localMessage.senderuin = String.valueOf(this.bqy);
    localMessage.msgtype = paramDataLineMsgRecord.msgtype;
    if (localMessage.msgtype == -2009) {
      localMessage.msgtype = -2005;
    }
    localMessage.msg = paramDataLineMsgRecord.msg;
    localMessage.emoRecentMsg = null;
    if (paramDataLineMsgRecord.time > localMessage.time)
    {
      QLog.d("DatalineMessageManager", 2, "updateLastMsg mr msg time[" + localMessage.time + "] to time[" + paramDataLineMsgRecord.time + "]");
      localMessage.time = paramDataLineMsgRecord.time;
    }
    localMessage.msgseq = paramDataLineMsgRecord.msgseq;
    localMessage.isread = paramDataLineMsgRecord.isread;
    localMessage.issend = paramDataLineMsgRecord.issend;
    localMessage.frienduin = String.valueOf(this.bqy);
    localMessage.istroop = this.czi;
    localMessage.fileType = -1;
    localMessage.msgId = paramDataLineMsgRecord.msgId;
    this.b.b(localMessage);
    if (!paramDataLineMsgRecord.isSend()) {
      localMessage.hasReply = true;
    }
    if ((!paramDataLineMsgRecord.isSendFromLocal()) && (!paramDataLineMsgRecord.isread))
    {
      this.b.e(localMessage);
      if (!DataLineMsgSet.isSingle(paramDataLineMsgRecord)) {
        break label290;
      }
      this.app.a().G(localMessage.frienduin, localMessage.istroop, 1);
    }
    label290:
    while ((paramEntityManager != null) && (paramEntityManager.getComeCount() != 1)) {
      return;
    }
    this.app.a().G(localMessage.frienduin, localMessage.istroop, 1);
  }
  
  public int Bh()
  {
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread()) {
      throw new RuntimeException("clearHistory in no-main thread");
    }
    localObject = this.b.a(String.valueOf(this.bqy), this.czi);
    if (this.app.getWritableDatabase() == null) {
      return 0;
    }
    int i = a().Bk();
    if (i > 0)
    {
      ((QQMessageFacade.Message)localObject).msg = null;
      ((QQMessageFacade.Message)localObject).emoRecentMsg = null;
      ((QQMessageFacade.Message)localObject).fileType = -1;
    }
    this.b.as(localObject);
    return i;
  }
  
  public int S(long paramLong)
  {
    DataLineMsgSet localDataLineMsgSet = a().b(paramLong);
    if (localDataLineMsgSet == null) {
      return -1;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread()) {
      return a(localDataLineMsgSet);
    }
    new Handler(localLooper).post(new DatalineMessageManager.2(this, localDataLineMsgSet));
    return 0;
  }
  
  public int a(DataLineMsgSet paramDataLineMsgSet)
  {
    boolean bool = false;
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() == ((Looper)localObject).getThread())
    {
      int i = a().b(paramDataLineMsgSet);
      if (i > 0)
      {
        paramDataLineMsgSet = top.u(String.valueOf(this.bqy), this.czi);
        if (this.b.gP.containsKey(paramDataLineMsgSet))
        {
          bool = ((QQMessageFacade.Message)this.b.gP.get(paramDataLineMsgSet)).hasReply;
          this.b.gP.remove(paramDataLineMsgSet);
        }
        long l = a().a().size();
        if (l > 0L)
        {
          localObject = a().a();
          paramDataLineMsgSet = (DataLineMsgSet)localObject;
          if (localObject != null) {
            if ((((DataLineMsgRecord)localObject).msgtype != -5000) && (((DataLineMsgRecord)localObject).msgtype != -5041))
            {
              paramDataLineMsgSet = (DataLineMsgSet)localObject;
              if (((DataLineMsgRecord)localObject).msgtype != -2073) {}
            }
            else
            {
              paramDataLineMsgSet = (DataLineMsgSet)localObject;
              if (l > 1L) {
                paramDataLineMsgSet = a().a().get((int)(l - 2L)).getLastItem();
              }
            }
          }
          localObject = new QQMessageFacade.Message();
          if (paramDataLineMsgSet != null)
          {
            MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject, paramDataLineMsgSet);
            ((QQMessageFacade.Message)localObject).emoRecentMsg = null;
            ((QQMessageFacade.Message)localObject).hasReply = bool;
            this.b.b((QQMessageFacade.Message)localObject);
            this.b.gP.put(top.u(String.valueOf(this.bqy), this.czi), localObject);
          }
        }
        paramDataLineMsgSet = this.app.a().createEntityManager();
        localObject = this.app.a().a().a(String.valueOf(this.bqy), this.czi);
        paramDataLineMsgSet.close();
        if (localObject != null) {
          this.b.as(localObject);
        }
      }
      return i;
    }
    new Handler((Looper)localObject).post(new DatalineMessageManager.3(this, paramDataLineMsgSet));
    return 0;
  }
  
  public long a(DataLineMsgRecord paramDataLineMsgRecord, boolean paramBoolean)
  {
    long l2 = -1L;
    long l1;
    if (paramDataLineMsgRecord == null)
    {
      l1 = l2;
      if (QLog.isColorLevel())
      {
        QLog.w("Q.msg.DatalineMessageManager", 2, "mr is null");
        l1 = l2;
      }
    }
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      return l1;
      cNT();
      localObject1 = new dv(false, false);
      localObject2 = Looper.getMainLooper();
      if (Thread.currentThread() == ((Looper)localObject2).getThread())
      {
        localObject1 = this.app.a().createEntityManager();
        try
        {
          if (paramDataLineMsgRecord.time == 0L) {
            paramDataLineMsgRecord.time = anaz.gQ();
          }
          if (paramDataLineMsgRecord.msgseq == 0L) {
            paramDataLineMsgRecord.msgseq = ((int)paramDataLineMsgRecord.time);
          }
          localObject2 = this.app.a().a();
          RecentUser localRecentUser = ((acxw)localObject2).a(String.valueOf(this.bqy), this.czi);
          localRecentUser.setType(this.czi);
          localRecentUser.lastmsgtime = paramDataLineMsgRecord.time;
          ((acxw)localObject2).e(localRecentUser);
          a(paramDataLineMsgRecord, (EntityManager)localObject1);
          l2 = paramDataLineMsgRecord.msgId;
          if (paramBoolean) {
            paramDataLineMsgRecord.issuc = true;
          }
          this.b.as(paramDataLineMsgRecord);
          ((EntityManager)localObject1).close();
          l1 = l2;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.DatalineMessageManager", 2, "mr.msgId: " + l2);
            return l2;
          }
        }
        finally
        {
          ((EntityManager)localObject1).close();
        }
      }
    }
    new Handler((Looper)localObject2).post(new DatalineMessageManager.1(this, paramDataLineMsgRecord, (dv)localObject1));
    ((dv)localObject1).f(-1L);
    return 0L;
  }
  
  public acxt a()
  {
    return this.app.a(0);
  }
  
  public DataLineMsgRecord a(long paramLong)
  {
    return a().a(paramLong);
  }
  
  public DataLineMsgSet a(long paramLong)
  {
    return a().c(paramLong);
  }
  
  public void a(int paramInt, acxt.a parama)
  {
    a().a(paramInt, parama);
  }
  
  public void a(long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    a().b(paramLong, paramString, paramArrayOfByte);
  }
  
  public void af(long paramLong, String paramString)
  {
    a().ai(paramLong, paramString);
  }
  
  public void ag(long paramLong, String paramString)
  {
    a().ah(paramLong, paramString);
  }
  
  protected void cNT()
  {
    ((acde)this.app.getBusinessHandler(8)).EI(false);
  }
  
  public void cNU()
  {
    Object localObject1 = this.app.a().createEntityManager();
    try
    {
      acxw localacxw = this.app.a().a();
      RecentUser localRecentUser = localacxw.a(String.valueOf(this.bqy), this.czi);
      localRecentUser.setType(this.czi);
      localRecentUser.lastmsgtime = anaz.gQ();
      localacxw.e(localRecentUser);
      ((EntityManager)localObject1).close();
      localObject1 = this.b.a(String.valueOf(this.bqy), this.czi);
      this.b.as(localObject1);
      return;
    }
    finally
    {
      ((EntityManager)localObject1).close();
    }
  }
  
  public void cNV()
  {
    a().cOK();
  }
  
  public void cNW()
  {
    a().cNW();
  }
  
  public void cNX()
  {
    if (!LiteActivity.class.getName().equals(accy.ay(BaseApplication.getContext()))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DatalineMessageManager", 2, "setDataLineMsgReaded,unread=" + this.b.a().A(this.bqy, this.czi));
      }
    } while (this.b.a().A(this.bqy, this.czi) <= 0);
    a().aIH();
    this.b.a().h(this.bqy, this.czi, true);
    this.b.as(this.b.a(this.bqy, this.czi));
  }
  
  public void ie(long paramLong)
  {
    a().il(paramLong);
  }
  
  public void jdMethod_if(long paramLong)
  {
    a().im(paramLong);
  }
  
  public void ig(long paramLong)
  {
    a().ii(paramLong);
  }
  
  public void ih(long paramLong)
  {
    QQMessageFacade.Message localMessage = this.b.a(String.valueOf(this.bqy), this.czi);
    if (paramLong > localMessage.time)
    {
      QLog.d("DatalineMessageManager", 2, "updateLastMsg msg time[" + localMessage.time + "] to time[" + paramLong + "]");
      localMessage.time = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acqp
 * JD-Core Version:    0.7.0.1
 */