import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

abstract class wtd
{
  long IB;
  String aUe;
  Set<Long> bj;
  Set<Long> bk;
  SessionInfo e;
  int id;
  HashMap<Long, Long> map = new HashMap();
  
  abstract void R(long paramLong1, long paramLong2);
  
  void S(long paramLong1, long paramLong2)
  {
    if ((this.bj != null) && (this.bj.size() > 0) && (this.bj.contains(Long.valueOf(paramLong1))))
    {
      this.bj.remove(Long.valueOf(paramLong1));
      this.bj.add(Long.valueOf(paramLong2));
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOrderManager", 2, "Forward order replaceOriginChatMsg mChatMsgListAfter.size() -> " + this.bj.size() + ", mChatMsgListAfter remove uniSeq -> " + paramLong1 + ", mChatMsgListAfter add uniSeq -> " + paramLong2 + ", ForwardID -> " + this.id);
      }
    }
    if ((this.bk != null) && (this.bk.size() > 0) && (this.bk.contains(Long.valueOf(paramLong1))))
    {
      this.bk.remove(Long.valueOf(paramLong1));
      this.bk.add(Long.valueOf(paramLong2));
    }
  }
  
  long a(Set<Long> paramSet)
  {
    if ((paramSet != null) && (paramSet.size() > 0))
    {
      paramSet = paramSet.toArray();
      if ((paramSet != null) && (paramSet.length > 0))
      {
        paramSet = paramSet[0];
        if ((paramSet instanceof Long)) {
          return ((Long)paramSet).longValue();
        }
      }
    }
    return 0L;
  }
  
  wtd a(SessionInfo paramSessionInfo, String paramString, List<Long> paramList, int paramInt)
  {
    this.id = paramInt;
    this.e = paramSessionInfo;
    this.aUe = paramString;
    if (paramList != null)
    {
      this.bj = new HashSet(paramList);
      this.bk = new HashSet(paramList);
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOrderManager", 2, "Forward order onPreForward mChatMsgListAfter.size() -> " + this.bj.size() + ", mChatMsgListBefore.size() -> " + this.bk.size() + ", ForwardID -> " + paramInt);
      }
    }
    return this;
  }
  
  boolean a(long paramLong, Set<Long> paramSet)
  {
    if (paramSet != null) {}
    try
    {
      if (!paramSet.isEmpty())
      {
        paramSet = paramSet.iterator();
        while (paramSet.hasNext()) {
          if (((Long)paramSet.next()).longValue() == paramLong) {
            return true;
          }
        }
      }
      return false;
    }
    finally {}
  }
  
  abstract void d(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord);
  
  abstract boolean d(QQAppInterface paramQQAppInterface, long paramLong);
  
  void fY(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOrderManager", 2, "ForwardOrder msgIDToSend id -> " + paramLong);
    }
    if (this.bj != null)
    {
      this.bj.add(Long.valueOf(paramLong));
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOrderManager", 2, "ForwardOrder mChatMsgListAfter add id -> " + paramLong);
      }
    }
    if (this.bk != null)
    {
      this.bk.add(Long.valueOf(paramLong));
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOrderManager", 2, "ForwardOrder mChatMsgListBefore add id -> " + paramLong);
      }
    }
  }
  
  void g(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      if ((this.bk != null) && (this.bk.size() > 0))
      {
        Iterator localIterator = this.bk.iterator();
        while (localIterator.hasNext()) {
          if (((Long)localIterator.next()).longValue() == paramLong) {
            localIterator.remove();
          }
        }
        if ((this.bk.size() <= 0) && (!TextUtils.isEmpty(this.aUe)) && (this.e != null))
        {
          paramQQAppInterface = ujt.a(paramQQAppInterface, this.e, this.aUe);
          this.aUe = "";
          if ((paramQQAppInterface != null) && (paramQQAppInterface.length > 0)) {
            this.IB = paramQQAppInterface[0];
          }
        }
      }
      return;
    }
    finally {}
  }
  
  abstract boolean l(long paramLong, boolean paramBoolean);
  
  void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOrderManager", 2, "ForwardOrder onDestroy forward id -> " + this.id);
    }
    this.e = null;
    this.aUe = "";
    this.IB = 0L;
    if (this.bj != null)
    {
      this.bj.clear();
      this.bj = null;
    }
    if (this.bk != null)
    {
      this.bk.clear();
      this.bk = null;
    }
    if (this.map != null)
    {
      this.map.clear();
      this.map = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wtd
 * JD-Core Version:    0.7.0.1
 */