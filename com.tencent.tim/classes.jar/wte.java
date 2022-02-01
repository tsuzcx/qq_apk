import android.util.SparseArray;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class wte
{
  private static wte a;
  private AtomicInteger aD = new AtomicInteger(0);
  private SparseArray<wtd> bv = new SparseArray();
  
  private wtd a(long paramLong, boolean paramBoolean)
  {
    int i = this.bv.size() - 1;
    while (i >= 0)
    {
      wtd localwtd = (wtd)this.bv.valueAt(i);
      if ((localwtd != null) && (localwtd.l(paramLong, paramBoolean))) {
        return localwtd;
      }
      i -= 1;
    }
    return null;
  }
  
  public static wte a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new wte();
      }
      return a;
    }
    finally {}
  }
  
  public void a(SessionInfo paramSessionInfo, String paramString, int paramInt)
  {
    a(paramSessionInfo, paramString, new ArrayList(), 1, paramInt);
  }
  
  public void a(SessionInfo paramSessionInfo, String paramString, List<MessageRecord> paramList, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        localArrayList.add(Long.valueOf(localMessageRecord.uniseq));
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOrderManager", 2, "onPreForward :: mr.uniseq -> " + localMessageRecord.uniseq + ", forwardID -> " + paramInt2);
        }
      }
    }
    if (paramInt1 == 1) {}
    for (paramList = new wti();; paramList = new wtf())
    {
      this.bv.put(paramInt2, paramList.a(paramSessionInfo, paramString, localArrayList, paramInt2));
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    wtd localwtd = (wtd)this.bv.get(paramInt);
    if (localwtd != null) {
      localwtd.g(paramQQAppInterface, paramLong);
    }
  }
  
  public void a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, int paramInt)
  {
    try
    {
      ((wtd)this.bv.get(paramInt)).S(paramMessageRecord1.uniseq, paramMessageRecord2.uniseq);
      return;
    }
    finally {}
  }
  
  public void b(QQAppInterface paramQQAppInterface, List<MessageRecord> paramList)
  {
    if (paramList != null) {
      try
      {
        if (paramList.size() > 0)
        {
          paramList = paramList.iterator();
          while (paramList.hasNext()) {
            d(paramQQAppInterface, (MessageRecord)paramList.next());
          }
        }
      }
      finally {}
    }
  }
  
  public void d(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    try
    {
      wtd localwtd = a(paramMessageRecord.uniseq, true);
      if (localwtd != null) {
        localwtd.d(paramQQAppInterface, paramMessageRecord);
      }
      return;
    }
    finally {}
  }
  
  public void h(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOrderManager", 2, "onSendResult newSeq -> " + paramLong + ", mForwardEntities.size() => " + this.bv.size());
    }
    wtd localwtd = a(paramLong, false);
    if ((localwtd != null) && (localwtd.d(paramQQAppInterface, paramLong))) {
      this.bv.remove(localwtd.id);
    }
  }
  
  public void i(long paramLong1, long paramLong2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOrderManager", 2, "mapUniSeqId:: newSeq -> " + paramLong1 + ", originSeq -> " + paramLong2 + ", id -> " + paramInt);
    }
    wtd localwtd = (wtd)this.bv.get(paramInt);
    if (localwtd != null) {
      localwtd.R(paramLong1, paramLong2);
    }
  }
  
  public int we()
  {
    return this.aD.incrementAndGet();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wte
 * JD-Core Version:    0.7.0.1
 */