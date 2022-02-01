import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class wtf
  extends wtd
{
  void R(long paramLong1, long paramLong2)
  {
    if (this.bk == null)
    {
      this.bk = new HashSet();
      this.bk.add(Long.valueOf(paramLong1));
      if (this.bj != null) {
        break label77;
      }
      this.bj = new HashSet();
    }
    for (;;)
    {
      this.bj.add(Long.valueOf(paramLong1));
      return;
      this.bk.clear();
      break;
      label77:
      this.bj.clear();
    }
  }
  
  void d(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((this.bk != null) && (this.bk.size() > 0) && (a(this.bj) == paramMessageRecord.uniseq) && (!TextUtils.isEmpty(this.aUe)) && (this.e != null))
    {
      paramQQAppInterface = ujt.a(paramQQAppInterface, this.e, this.aUe);
      this.aUe = "";
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length > 0)) {
        this.IB = paramQQAppInterface[0];
      }
    }
  }
  
  boolean d(QQAppInterface paramQQAppInterface, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.bj != null)
    {
      bool1 = bool2;
      if (this.bj.size() > 0)
      {
        bool1 = bool2;
        if (a(this.bj) == paramLong)
        {
          bool1 = bool2;
          if (a(this.bj) == paramLong)
          {
            bool1 = bool2;
            if (this.e != null)
            {
              bool1 = bool2;
              if (this.IB > 0L)
              {
                MessageRecord localMessageRecord = paramQQAppInterface.b().b(this.e.aTl, this.e.cZ, this.IB);
                if (localMessageRecord != null) {
                  paramQQAppInterface.b().b(localMessageRecord, null, false);
                }
                this.IB = 0L;
                onDestroy();
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  boolean l(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = this.bk; (localObject != null) && (((Set)localObject).size() > 0); localObject = this.bj)
    {
      localObject = ((Set)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (((Long)((Iterator)localObject).next()).longValue() != paramLong);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wtf
 * JD-Core Version:    0.7.0.1
 */