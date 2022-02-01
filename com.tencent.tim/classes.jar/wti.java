import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class wti
  extends wtd
{
  private void T(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOrderManager", 2, "ForwardOrder realMapUniSeq newSeq -> " + paramLong1 + ", originSeq -> " + paramLong2 + ", forwardID -> " + this.id);
    }
    if ((this.bk != null) && (!this.bk.isEmpty()) && (a(paramLong2, this.bk)) && (this.map != null))
    {
      this.map.put(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOrderManager", 2, "ForwardOrder realMapUniSeq map do put, forwardID -> " + this.id);
      }
    }
  }
  
  void R(long paramLong1, long paramLong2)
  {
    if (a(paramLong2, this.bk))
    {
      T(paramLong1, paramLong2);
      return;
    }
    fY(paramLong1);
    T(paramLong1, paramLong1);
  }
  
  void d(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((this.map != null) && (this.map.get(Long.valueOf(paramMessageRecord.uniseq)) != null))
    {
      paramMessageRecord = (Long)this.map.get(Long.valueOf(paramMessageRecord.uniseq));
      if ((paramMessageRecord != null) && (a(paramMessageRecord.longValue(), this.bk)))
      {
        this.bk.remove(paramMessageRecord);
        if ((this.bk.size() <= 0) && (!TextUtils.isEmpty(this.aUe)) && (this.e != null))
        {
          paramQQAppInterface = ujt.a(paramQQAppInterface, this.e, this.aUe);
          this.aUe = "";
          if ((paramQQAppInterface != null) && (paramQQAppInterface.length > 0)) {
            this.IB = paramQQAppInterface[0];
          }
        }
      }
    }
  }
  
  boolean d(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      if ((this.map != null) && (this.map.get(Long.valueOf(paramLong)) != null))
      {
        Object localObject = (Long)this.map.get(Long.valueOf(paramLong));
        if ((localObject != null) && (a(((Long)localObject).longValue(), this.bj)))
        {
          this.bj.remove(localObject);
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOrderManager", 2, "SeparateForwardOrder onSendResult mChatMsgListAfter remove originUniSeq " + localObject + "， mChatMsgListAfter.size() -> " + this.bj.size() + ", forwardID -> " + this.id);
          }
          if ((this.bj.size() <= 0) && (this.e != null) && (this.IB > 0L))
          {
            localObject = paramQQAppInterface.b().b(this.e.aTl, this.e.cZ, this.IB);
            if (localObject != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ForwardOrderManager", 2, "SeparateForwardOrder onSendResult query msg and send, newSeq -> " + paramLong + ", forwardID -> " + this.id);
              }
              paramQQAppInterface.b().b((MessageRecord)localObject, null, false);
              this.IB = 0L;
              onDestroy();
              return true;
            }
          }
        }
      }
      return false;
    }
    finally {}
  }
  
  boolean l(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = this.bk; (localObject != null) && (((Set)localObject).size() > 0); localObject = this.bj)
    {
      localObject = ((Set)localObject).iterator();
      long l;
      Long localLong;
      do
      {
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          l = ((Long)((Iterator)localObject).next()).longValue();
        } while ((this.map == null) || (this.map.get(Long.valueOf(paramLong)) == null));
        localLong = (Long)this.map.get(Long.valueOf(paramLong));
      } while ((localLong == null) || (localLong.longValue() <= 0L) || (localLong.longValue() != l));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wti
 * JD-Core Version:    0.7.0.1
 */