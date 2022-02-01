package com.tencent.qqmail.model.mail.cursor;

import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.concurrent.Future;

public class QMSortedSearchCursor
  implements IMailListCursor
{
  private Mail[] mails;
  
  public QMSortedSearchCursor(QMSearchCursor paramQMSearchCursor)
  {
    int j = paramQMSearchCursor.getCount();
    if (j > 0)
    {
      this.mails = new Mail[j];
      int i = 0;
      while (i < j)
      {
        this.mails[i] = paramQMSearchCursor.getItem(i);
        i += 1;
      }
      Arrays.sort(this.mails, new MailUtcTimeComparator(null));
    }
  }
  
  public boolean canLoadMore()
  {
    return false;
  }
  
  public boolean canPopIn()
  {
    return false;
  }
  
  public void close() {}
  
  public int getCount()
  {
    if (this.mails != null) {
      return this.mails.length;
    }
    return 0;
  }
  
  public Mail getItem(int paramInt)
  {
    if ((this.mails != null) && (paramInt >= 0) && (paramInt < this.mails.length)) {
      return this.mails[paramInt];
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public long[] getItemIds()
  {
    return new long[0];
  }
  
  public Future<long[]> getItemIdsInFuture()
  {
    return null;
  }
  
  public int getState()
  {
    return 0;
  }
  
  public int[] getUnreadItemPosition()
  {
    return new int[0];
  }
  
  public void loadMore() {}
  
  public void popIn() {}
  
  public void refresh(QMRefreshCallback paramQMRefreshCallback) {}
  
  public void refresh(boolean paramBoolean, QMRefreshCallback paramQMRefreshCallback) {}
  
  public void reloadAfterDeleteMailSyncRemote() {}
  
  class MailUtcTimeComparator
    implements Comparator
  {
    private MailUtcTimeComparator() {}
    
    private long getUtcTime(Mail paramMail)
    {
      return paramMail.getInformation().getUtc().getTime();
    }
    
    public int compare(Object paramObject1, Object paramObject2)
    {
      if (paramObject2 == null) {}
      long l1;
      long l2;
      do
      {
        return -1;
        if (paramObject1 == null) {
          return 1;
        }
        paramObject1 = (Mail)paramObject1;
        paramObject2 = (Mail)paramObject2;
        l1 = getUtcTime(paramObject1);
        l2 = getUtcTime(paramObject2);
      } while (l1 > l2);
      if (l1 < l2) {
        return 1;
      }
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMSortedSearchCursor
 * JD-Core Version:    0.7.0.1
 */