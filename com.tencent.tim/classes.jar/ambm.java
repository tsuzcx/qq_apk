import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ambm
  implements ambq.a
{
  public static String TAG = "OrderMediaMsgSessionQueue";
  private ConcurrentLinkedQueue<ambi> H;
  private ambh jdField_a_of_type_Ambh;
  private ambm.a jdField_a_of_type_Ambm$a;
  protected ambp.b a;
  private ambp jdField_a_of_type_Ambp;
  private ambq jdField_a_of_type_Ambq;
  private String aUf;
  private int dBE = 0;
  private Iterator<ambi> mIterator;
  private long mStartTime = 0L;
  achq n = new ambo(this);
  
  public ambm(String paramString, ambh paramambh)
  {
    this.jdField_a_of_type_Ambp$b = new ambn(this);
    this.aUf = paramString;
    this.jdField_a_of_type_Ambh = paramambh;
    this.H = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_Ambp = new ambp(this.aUf);
    this.jdField_a_of_type_Ambp.a(this.jdField_a_of_type_Ambp$b);
    this.jdField_a_of_type_Ambq = new ambq(this);
  }
  
  private void a(ambi paramambi)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doNextAddSend ").append(paramambi.mIndex).append(", uniseq:").append(paramambi.mUniseq).append(", addStatus:").append(paramambi.dBC).append(", sendStatus:").append(paramambi.dBD);
      QLog.d(TAG, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Ambp.kZ(paramambi.mUniseq);
    if (paramambi.avf()) {
      this.jdField_a_of_type_Ambh.at(paramambi.H);
    }
    if (paramambi.avh()) {
      this.jdField_a_of_type_Ambh.a(paramambi.H, paramambi.mMsgObserver, paramambi.a);
    }
    dMf();
    dMg();
  }
  
  private MessageRecord c(long paramLong)
  {
    Object localObject = null;
    MessageRecord localMessageRecord = null;
    if (paramLong != 0L)
    {
      Iterator localIterator = this.H.iterator();
      localObject = localMessageRecord;
      if (localIterator.hasNext())
      {
        localObject = (ambi)localIterator.next();
        if (paramLong != ((ambi)localObject).mUniseq) {
          break label67;
        }
        localMessageRecord = ((ambi)localObject).H;
      }
    }
    label67:
    for (;;)
    {
      break;
      return localObject;
    }
  }
  
  private void dMf()
  {
    Object localObject2;
    try
    {
      localObject2 = this.H.iterator();
      do
      {
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label325;
          }
          ambi localambi = (ambi)((Iterator)localObject2).next();
          if (!localambi.avf()) {
            break;
          }
          localambi.dBC = 2;
          this.jdField_a_of_type_Ambp.kY(localambi.mUniseq);
          this.jdField_a_of_type_Ambh.at(localambi.H);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("success in add ").append(localambi.mIndex).append(", uniseq:").append(localambi.mUniseq).append(", path:").append(localambi.mFilePath).append(", status:").append(localambi.dBC);
            QLog.d(TAG, 2, localStringBuilder.toString());
          }
          if (localambi.hs != null)
          {
            this.jdField_a_of_type_Ambq.ah(localambi.hs);
            localambi.hs = null;
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "remove mAddTimeoutRunable1 uniseq:" + localambi.mUniseq);
            }
          }
          if (localambi.cBU)
          {
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "invalid msg:" + localambi.mUniseq);
            }
            a(localambi.mUniseq);
          }
        }
      } while (localObject1.avg());
    }
    finally {}
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("not ready to add ").append(localObject1.mIndex).append(", path:").append(localObject1.mFilePath).append(", mStatus:").append(localObject1.dBC);
      QLog.d(TAG, 2, ((StringBuilder)localObject2).toString());
    }
    label325:
  }
  
  private void dMg()
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      try
      {
        if (this.H.isEmpty())
        {
          ambl.an(this.dBE, System.currentTimeMillis() - this.mStartTime);
          if (this.jdField_a_of_type_Ambm$a != null) {
            this.jdField_a_of_type_Ambm$a.Pw(this.aUf);
          }
          this.jdField_a_of_type_Ambq.destroy();
          this.mStartTime = 0L;
          this.dBE = 0;
          return;
        }
        ambi localambi = (ambi)this.H.peek();
        if (localambi == null) {
          continue;
        }
        if (localambi.avh())
        {
          localambi.dBD = 4;
          this.jdField_a_of_type_Ambq.dMh();
          this.jdField_a_of_type_Ambh.a(localambi.H, this.n, localambi.a);
          if (!QLog.isColorLevel()) {
            continue;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("success in send ").append(localambi.mIndex).append(", uniseq:").append(localambi.mUniseq).append(", dest:").append(localambi.mFilePath).append(", status:").append(localambi.dBD);
          QLog.d(TAG, 2, localStringBuilder.toString());
          continue;
        }
        if (localObject.avi()) {
          continue;
        }
      }
      finally {}
      if (this.jdField_a_of_type_Ambh.aP(localObject.H)) {
        localObject.mNeedCompress = true;
      }
      boolean bool = this.jdField_a_of_type_Ambq.cA(localObject.mUniseq);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("not ready to send ").append(localObject.mIndex).append(", uniseq:").append(localObject.mUniseq).append(", dest:").append(localObject.mFilePath).append(", status:").append(localObject.dBD).append(", needCompress:").append(localObject.mNeedCompress).append(", addSuccess:").append(bool);
        QLog.d(TAG, 2, localStringBuilder.toString());
      }
    }
  }
  
  public void N(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Ambq.la(paramLong);
    if (paramInt2 == 0)
    {
      a(paramLong);
      QLog.d(TAG, 1, new Object[] { "blocking!!! count zero ", Long.valueOf(paramLong) });
      return;
    }
    if (paramInt1 == -1)
    {
      paramInt1 = this.jdField_a_of_type_Ambh.m(c(paramLong));
      this.jdField_a_of_type_Ambq.O(paramLong, paramInt1, paramInt2 - 1);
      return;
    }
    int i = this.jdField_a_of_type_Ambh.m(c(paramLong));
    if (i > paramInt1)
    {
      this.jdField_a_of_type_Ambq.O(paramLong, i, paramInt2);
      return;
    }
    a(paramLong);
    QLog.d(TAG, 1, new Object[] { "blocking!!! progress stuck ", Long.valueOf(paramLong) });
  }
  
  public ambi a(long paramLong)
  {
    this.mIterator = this.H.iterator();
    while (this.mIterator.hasNext())
    {
      ambi localambi = (ambi)this.mIterator.next();
      if (paramLong == localambi.mUniseq)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeMediaMsgByUniseq ").append(localambi.mIndex).append(", uniseq:").append(localambi.mUniseq);
          QLog.d(TAG, 2, localStringBuilder.toString());
        }
        this.mIterator.remove();
        a(localambi);
        return localambi;
      }
    }
    return null;
  }
  
  public ambi a(String paramString)
  {
    this.mIterator = this.H.iterator();
    while (this.mIterator.hasNext())
    {
      ambi localambi = (ambi)this.mIterator.next();
      if (paramString.equals(localambi.mFilePath))
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("removeMediaMsgByPath ").append(localambi.mIndex).append(", uniseq:").append(localambi.mUniseq);
          QLog.d(TAG, 2, paramString.toString());
        }
        this.mIterator.remove();
        a(localambi);
        return localambi;
      }
    }
    return null;
  }
  
  public ambp a()
  {
    return this.jdField_a_of_type_Ambp;
  }
  
  public void a(ambm.a parama)
  {
    this.jdField_a_of_type_Ambm$a = parama;
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addOrderMsgRecord").append(" uniseq:").append(paramLong).append(", path:").append(paramString).append(", realadd:").append(paramBoolean);
      QLog.d(TAG, 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.H.iterator();
    ambi localambi;
    if (((Iterator)localObject).hasNext())
    {
      localambi = (ambi)((Iterator)localObject).next();
      if ((localambi.mUniseq == 0L) || (paramLong != localambi.mUniseq)) {
        break label217;
      }
      localambi.H = paramMessageRecord;
      if (!paramBoolean) {
        break label145;
      }
      localambi.dBC = 1;
    }
    for (;;)
    {
      if (paramBoolean) {
        dMf();
      }
      return;
      label145:
      localambi.dBC = 2;
      if (localambi.hs != null)
      {
        this.jdField_a_of_type_Ambq.ah(localambi.hs);
        localambi.hs = null;
        if (QLog.isColorLevel())
        {
          QLog.d(TAG, 2, "remove mAddTimeoutRunable2 uniseq:" + localambi.mUniseq);
          continue;
          label217:
          if ((localambi.mUniseq != 0L) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(localambi.mFilePath))) {
            break;
          }
          localambi.H = paramMessageRecord;
          localambi.mUniseq = paramLong;
          if (paramBoolean)
          {
            localambi.dBC = 1;
          }
          else
          {
            localambi.dBC = 2;
            if (localambi.hs != null)
            {
              this.jdField_a_of_type_Ambq.ah(localambi.hs);
              localambi.hs = null;
              if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "remove mAddTimeoutRunable3 uniseq:" + localambi.mUniseq);
              }
            }
          }
        }
      }
    }
  }
  
  public void aF(long paramLong, String paramString)
  {
    h(paramLong, paramString, false);
  }
  
  public void aI(long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramLong2 == 0L)) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "oldSeq and newSeq should not be zero");
      }
    }
    for (;;)
    {
      return;
      int i;
      if (!this.H.isEmpty())
      {
        Iterator localIterator = this.H.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            ambi localambi = (ambi)localIterator.next();
            if (paramLong1 == localambi.mUniseq)
            {
              localambi.mUniseq = paramLong2;
              if (localambi.hs != null)
              {
                this.jdField_a_of_type_Ambq.ah(localambi.hs);
                localambi.hs = this.jdField_a_of_type_Ambq.a(paramLong2);
              }
              if (QLog.isColorLevel())
              {
                QLog.d(TAG, 2, new Object[] { "updateMediaMsgByUniseq old:", Long.valueOf(paramLong1), ", new:", Long.valueOf(paramLong2) });
                i = 1;
              }
            }
          }
        }
      }
      while (i == 0)
      {
        aF(paramLong2, "");
        return;
        i = 1;
        continue;
        i = 0;
      }
    }
  }
  
  public boolean avj()
  {
    return this.H.isEmpty();
  }
  
  public void bu(Object paramObject)
  {
    ambi localambi = null;
    int i;
    if ((paramObject instanceof Long))
    {
      localambi = a(((Long)paramObject).longValue());
      i = 1;
    }
    for (;;)
    {
      if ((localambi != null) && (localambi.H != null)) {}
      for (int j = localambi.H.msgtype;; j = -1)
      {
        ambl.jt(j, i);
        QLog.d(TAG, 1, new Object[] { "timeout!!! add msg:", paramObject, " ,msgtype:", Integer.valueOf(j) });
        return;
        if (!(paramObject instanceof String)) {
          break label114;
        }
        localambi = a((String)paramObject);
        i = 2;
        break;
      }
      label114:
      i = 0;
    }
  }
  
  public void c(MessageRecord paramMessageRecord, achq paramachq, ambj.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "sendOrderMsgRecord:" + paramMessageRecord.uniseq);
    }
    Iterator localIterator = this.H.iterator();
    while (localIterator.hasNext())
    {
      ambi localambi = (ambi)localIterator.next();
      if (paramMessageRecord.uniseq == localambi.mUniseq)
      {
        localambi.H = paramMessageRecord;
        localambi.mMsgObserver = paramachq;
        localambi.a = parama;
        localambi.dBD = 3;
        if (QLog.isColorLevel())
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("ready to send ").append(localambi.mIndex).append(", uniseq:").append(localambi.mUniseq).append(", addStatus:").append(localambi.dBC).append(", sendStatus:").append(localambi.dBD);
          QLog.d(TAG, 2, paramMessageRecord.toString());
        }
      }
    }
    dMg();
  }
  
  public void destroy()
  {
    if (this.jdField_a_of_type_Ambp != null)
    {
      this.jdField_a_of_type_Ambp.destroy();
      this.jdField_a_of_type_Ambp = null;
    }
    if (this.H != null)
    {
      this.H.clear();
      this.H = null;
    }
    if (this.jdField_a_of_type_Ambq != null)
    {
      this.jdField_a_of_type_Ambq.destroy();
      this.jdField_a_of_type_Ambq = null;
    }
    this.jdField_a_of_type_Ambm$a = null;
  }
  
  public void h(long paramLong, String paramString, boolean paramBoolean)
  {
    Object localObject = new ambi();
    ((ambi)localObject).mUniseq = paramLong;
    ((ambi)localObject).mFilePath = paramString;
    ((ambi)localObject).cBU = paramBoolean;
    int i = this.dBE + 1;
    this.dBE = i;
    ((ambi)localObject).mIndex = i;
    ((ambi)localObject).dBC = 0;
    ((ambi)localObject).dBD = 0;
    this.H.offer(localObject);
    if (paramLong != 0L) {}
    for (((ambi)localObject).hs = this.jdField_a_of_type_Ambq.a(paramLong);; ((ambi)localObject).hs = this.jdField_a_of_type_Ambq.a(paramString))
    {
      if (this.mStartTime == 0L) {
        this.mStartTime = System.currentTimeMillis();
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("enqueueMediaMsg msgSize:").append(this.dBE).append(", uniseq:").append(paramLong).append(", path:").append(paramString).append(", queue:").append(this.H.size());
        QLog.d(TAG, 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
  }
  
  public boolean h(long paramLong, String paramString)
  {
    Iterator localIterator = this.H.iterator();
    while (localIterator.hasNext())
    {
      ambi localambi = (ambi)localIterator.next();
      if ((localambi.mUniseq != 0L) && (paramLong == localambi.mUniseq)) {
        return true;
      }
      if ((localambi.mUniseq == 0L) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(localambi.mFilePath))) {
        return true;
      }
    }
    return false;
  }
  
  public void kV(long paramLong)
  {
    this.jdField_a_of_type_Ambq.dMh();
    ambi localambi = null;
    if (paramLong != 0L) {
      if (this.jdField_a_of_type_Ambh.aN(c(paramLong))) {
        localambi = a(paramLong);
      }
    }
    int i;
    label53:
    boolean bool;
    for (;;)
    {
      if (localambi != null) {
        if (localambi.H == null)
        {
          i = 0;
          bool = true;
          label56:
          ambl.bR(i, bool);
          if (!bool)
          {
            int j = this.jdField_a_of_type_Ambh.m(c(paramLong));
            this.jdField_a_of_type_Ambq.O(paramLong, j, 3);
          }
          QLog.d(TAG, 1, new Object[] { "timeout!!! send msg:", Long.valueOf(paramLong), " ,invalid:", Boolean.valueOf(bool), " ,msgtype:", Integer.valueOf(i) });
          return;
          if (this.H.isEmpty()) {
            continue;
          }
          localambi = (ambi)this.H.peek();
          if ((localambi == null) || (!this.jdField_a_of_type_Ambh.aN(localambi.H))) {
            break label245;
          }
        }
      }
    }
    label245:
    for (localambi = a(localambi.mUniseq);; localambi = null)
    {
      QLog.d(TAG, 1, new Object[] { "uniseq is invalid:", Long.valueOf(paramLong) });
      break;
      i = localambi.H.msgtype;
      break label53;
      i = -1;
      bool = false;
      break label56;
    }
  }
  
  public static abstract interface a
  {
    public abstract void Pw(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ambm
 * JD-Core Version:    0.7.0.1
 */