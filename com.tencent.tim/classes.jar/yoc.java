import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class yoc
  extends acfd
{
  yoc(yob paramyob) {}
  
  private void db(ArrayList<yow> paramArrayList)
  {
    if ((paramArrayList != null) && (yob.a(this.b) != 80000005) && (paramArrayList.size() == 1)) {
      yob.a(this.b, ((yow)paramArrayList.get(0)).cak);
    }
    if ((paramArrayList != null) && (paramArrayList.size() >= 1))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        yow localyow = (yow)paramArrayList.next();
        if (localyow.resultType == 80000003)
        {
          i = 0;
          while (i < localyow.sS.size())
          {
            ((AccountSearchPb.record)localyow.sS.get(i)).number.set(i + 1);
            i += 1;
          }
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (yob.a(this.b) != 80000005) {
          kbp.a(yob.a(this.b), "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D96", "0X8005D96", 0, 0, yob.b(this.b) + "", "", this.b.keyword, "", false);
        }
      }
      else {
        return;
      }
      kbp.a(yob.a(this.b), "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D94", "0X8005D94", 0, 0, "", "", this.b.keyword, "", false);
      return;
    }
  }
  
  protected void onSearchFriendResult(boolean paramBoolean1, int paramInt1, Object paramObject, int paramInt2, String paramString, boolean paramBoolean2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(yob.TAG, 2, "onSearchFriendResult  searchType = " + paramInt1 + " isSuccess = " + paramBoolean1);
    }
    int j = 0;
    int i;
    yob.a locala;
    if (paramInt1 == 87)
    {
      this.b.ckg();
      i = 1;
      if (yob.a(this.b) != null)
      {
        locala = yob.a(this.b);
        if (i == 0) {
          break label308;
        }
      }
    }
    for (;;)
    {
      locala.c(paramInt1, paramBoolean1, paramObject, paramInt2, paramString);
      do
      {
        for (;;)
        {
          return;
          if (paramInt1 != 88) {
            break label294;
          }
          if (paramLong == yob.a(this.b))
          {
            this.b.ckg();
            if (!paramBoolean2)
            {
              if (yob.a(this.b) != null) {
                yob.a(this.b).c(yob.a(this.b), paramBoolean1, new ArrayList(), paramInt2, paramString);
              }
            }
            else
            {
              if (!paramBoolean1) {
                break label250;
              }
              try
              {
                db((ArrayList)paramObject);
                i = j;
              }
              catch (Exception paramObject)
              {
                if (QLog.isColorLevel()) {
                  QLog.e(yob.TAG, 2, "", paramObject);
                }
              }
            }
          }
        }
      } while (yob.a(this.b) == null);
      yob.a(this.b).c(yob.a(this.b), paramBoolean1, new ArrayList(), paramInt2, paramString);
      return;
      label250:
      i = j;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(yob.TAG, 2, "search failed error msg = " + paramString);
      i = j;
      break;
      label294:
      this.b.ckg();
      i = j;
      break;
      label308:
      paramInt1 = yob.a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yoc
 * JD-Core Version:    0.7.0.1
 */