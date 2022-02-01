package com.tencent.qqmail.model.contact.cursor;

import android.database.Cursor;
import android.util.Log;
import com.tencent.qqmail.model.contact.QMContactSQLite;
import com.tencent.qqmail.model.mail.QMCursorCollector;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.concurrent.Future;

public abstract class ContactBaseListCursor
  implements IContactListCursor
{
  private static final String TAG = "QMContactListCursor";
  private int[] accountIds;
  protected int[] cacheColumnIndex = new int[100];
  private Future<Cursor> cursor;
  private Cursor latestCursor;
  private Future<Cursor> nextCursor;
  private Runnable onRefresh = null;
  protected QMMailSQLiteHelper sqliteHelper;
  private IRunOnMainThreadWithContext threadWrapper = new DefaultRunOnMainThreadContext();
  
  public ContactBaseListCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, int[] paramArrayOfInt)
  {
    this.sqliteHelper = paramQMMailSQLiteHelper;
    this.accountIds = paramArrayOfInt;
    Arrays.fill(this.cacheColumnIndex, -2147483648);
  }
  
  private void nextCursor()
  {
    try
    {
      if (this.nextCursor != null) {
        this.nextCursor.get();
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "QMContactListCursor", "nextCursor: " + Log.getStackTraceString(localException));
    }
  }
  
  private void refresh()
  {
    boolean bool2 = false;
    Cursor localCursor = getCursor();
    QMCursorCollector.retain(localCursor);
    if (this.cursor != null) {}
    for (int i = 1;; i = 0)
    {
      boolean bool1 = bool2;
      if (this.cursor != null)
      {
        bool1 = bool2;
        if (getCount() == 0) {
          bool1 = true;
        }
      }
      if ((i != 0) && (!bool1)) {
        break;
      }
      this.cursor = Threads.submitTask(new ContactBaseListCursor.3(this));
      this.threadWrapper.runOnMainThreadWithContext(new ContactBaseListCursor.4(this, bool1, localCursor));
      return;
    }
    if ((this.nextCursor != null) && (!this.nextCursor.isDone())) {
      this.nextCursor.cancel(true);
    }
    this.nextCursor = Threads.submitTask(new ContactBaseListCursor.5(this, localCursor));
  }
  
  public void close()
  {
    QMCursorCollector.release(this.latestCursor);
    QMCursorCollector.cleanup();
    Threads.cancelTask(this.cursor);
  }
  
  public int[] getAccountIds()
  {
    return this.accountIds;
  }
  
  public String getCategory(MailContact paramMailContact)
  {
    String str = null;
    if (!StringExtention.isNullOrEmpty(paramMailContact.getPinyin())) {
      str = paramMailContact.getPinyin().substring(0, 1).toUpperCase();
    }
    paramMailContact = str;
    if (str == null) {
      paramMailContact = "#";
    }
    return paramMailContact;
  }
  
  public int getCount()
  {
    try
    {
      Cursor localCursor = getCursor();
      if ((localCursor != null) && (!localCursor.isClosed()))
      {
        int i = localCursor.getCount();
        return i;
      }
    }
    catch (Exception localException)
    {
      QMLog.log(6, "QMContactListCursor", "getCount: " + localException.toString());
    }
    return 0;
  }
  
  public Cursor getCursor()
  {
    try
    {
      this.latestCursor = ((Cursor)this.cursor.get());
      return this.latestCursor;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.latestCursor = null;
        QMLog.log(6, "QMContactListCursor", "getCursor: " + localException.toString());
      }
    }
  }
  
  public MailContact getItem(int paramInt)
  {
    Cursor localCursor = getCursor();
    localCursor.moveToPosition(paramInt);
    return getItem(localCursor);
  }
  
  protected MailContact getItem(Cursor paramCursor)
  {
    return QMContactSQLite.fillContact(paramCursor, this.cacheColumnIndex);
  }
  
  public long getItemId(int paramInt)
  {
    Cursor localCursor = getCursor();
    localCursor.moveToPosition(paramInt);
    return localCursor.getLong(0);
  }
  
  public LinkedHashMap<String, Integer> getSectionMap()
  {
    return querySectionMap();
  }
  
  protected abstract Cursor queryRawCursor();
  
  protected abstract LinkedHashMap<String, Integer> querySectionMap();
  
  public void refresh(boolean paramBoolean, QMRefreshCallback paramQMRefreshCallback)
  {
    if (paramQMRefreshCallback != null) {
      this.threadWrapper.runOnMainThreadWithContext(new ContactBaseListCursor.1(this, paramQMRefreshCallback));
    }
    refresh();
    if (paramBoolean) {
      reload();
    }
    nextCursor();
    getCursor();
    if (paramQMRefreshCallback != null) {
      this.threadWrapper.runOnMainThreadWithContext(new ContactBaseListCursor.2(this, paramQMRefreshCallback));
    }
  }
  
  protected abstract void reload();
  
  public void setAccountIds(int[] paramArrayOfInt)
  {
    this.accountIds = paramArrayOfInt;
  }
  
  public void setOnRefresh(Runnable paramRunnable)
  {
    this.onRefresh = paramRunnable;
  }
  
  public void setThreadWrapper(IRunOnMainThreadWithContext paramIRunOnMainThreadWithContext)
  {
    this.threadWrapper = paramIRunOnMainThreadWithContext;
  }
  
  public static final class DefaultRunOnMainThreadContext
    implements ContactBaseListCursor.IRunOnMainThreadWithContext
  {
    public void runOnMainThreadWithContext(Runnable paramRunnable)
    {
      Threads.runOnMainThread(paramRunnable);
    }
  }
  
  public static abstract interface IRunOnMainThreadWithContext
  {
    public abstract void runOnMainThreadWithContext(Runnable paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.cursor.ContactBaseListCursor
 * JD-Core Version:    0.7.0.1
 */