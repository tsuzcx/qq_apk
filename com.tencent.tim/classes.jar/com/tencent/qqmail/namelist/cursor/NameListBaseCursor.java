package com.tencent.qqmail.namelist.cursor;

import android.database.Cursor;
import android.util.Log;
import com.tencent.qqmail.model.mail.QMCursorCollector;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.namelist.NameListManager;
import com.tencent.qqmail.namelist.NameListSQLite;
import com.tencent.qqmail.namelist.model.NameListContact;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.concurrent.Future;

public abstract class NameListBaseCursor
  implements INameListCursor
{
  public static final String TAG = "NameListBaseCursor";
  protected Future<Cursor> currentCursor;
  protected Cursor latestCursor;
  protected int mAccountId;
  protected int[] mCacheColumnIndex = new int[100];
  protected int mType;
  protected NameListManager nameListManager;
  protected Future<Cursor> nextCursor;
  private Runnable onRefresh = null;
  protected QMMailSQLiteHelper sqliteHelper;
  private IRunOnMainThreadWithContext threadWrapper = new DefaultRunOnMainThreadContext();
  
  public NameListBaseCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, NameListManager paramNameListManager, int paramInt1, int paramInt2)
  {
    this.sqliteHelper = paramQMMailSQLiteHelper;
    this.nameListManager = paramNameListManager;
    this.mAccountId = paramInt1;
    this.mType = paramInt2;
    Arrays.fill(this.mCacheColumnIndex, -2147483648);
  }
  
  public void close()
  {
    QMCursorCollector.release(this.latestCursor);
    QMCursorCollector.cleanup();
    Threads.cancelTask(this.currentCursor);
  }
  
  public String getCategory(int paramInt)
  {
    String str2 = null;
    String str1 = str2;
    if (paramInt >= 0)
    {
      if (paramInt <= getCount()) {
        break label20;
      }
      str1 = str2;
    }
    label20:
    do
    {
      do
      {
        NameListContact localNameListContact;
        do
        {
          return str1;
          localNameListContact = getItem(paramInt);
          str1 = str2;
        } while (StringExtention.isNullOrEmpty(localNameListContact.getEmail()));
        str2 = localNameListContact.getEmail().substring(0, 1).toUpperCase();
        if (str2.compareTo("A") < 0) {
          break;
        }
        str1 = str2;
      } while (str2.compareTo("Z") <= 0);
      if (str2.compareTo("a") < 0) {
        break;
      }
      str1 = str2;
    } while (str2.compareTo("z") <= 0);
    return "#";
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
      QMLog.log(6, "NameListBaseCursor", "getCount: " + localException.toString());
    }
    return 0;
  }
  
  public Cursor getCursor()
  {
    try
    {
      if (this.currentCursor != null) {
        this.latestCursor = ((Cursor)this.currentCursor.get());
      }
      return this.latestCursor;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.latestCursor = null;
        QMLog.log(6, "NameListBaseCursor", "getCursor: " + Log.getStackTraceString(localException));
      }
    }
  }
  
  public NameListContact getItem(int paramInt)
  {
    Cursor localCursor = getCursor();
    localCursor.moveToPosition(paramInt);
    return getItem(localCursor);
  }
  
  public NameListContact getItem(Cursor paramCursor)
  {
    NameListContact localNameListContact = new NameListContact();
    NameListSQLite.fillNameListContact(localNameListContact, paramCursor, null);
    return localNameListContact;
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
  
  public void nextCursor()
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
      QMLog.log(6, "NameListBaseCursor", "nextCursor: " + Log.getStackTraceString(localException));
    }
  }
  
  protected abstract Cursor queryRawCursor();
  
  protected abstract LinkedHashMap<String, Integer> querySectionMap();
  
  protected void refresh(QMRefreshCallback paramQMRefreshCallback)
  {
    int k = 0;
    Cursor localCursor = getCursor();
    QMCursorCollector.retain(localCursor);
    if (this.currentCursor != null) {}
    for (int i = 1;; i = 0)
    {
      int j = k;
      if (this.currentCursor != null)
      {
        j = k;
        if (getCount() == 0) {
          j = 1;
        }
      }
      if ((i != 0) && (j == 0)) {
        break;
      }
      this.currentCursor = Threads.submitTask(new NameListBaseCursor.2(this, paramQMRefreshCallback));
      return;
    }
    if ((this.nextCursor != null) && (!this.nextCursor.isDone()))
    {
      this.nextCursor.cancel(true);
      QMCursorCollector.release(localCursor);
    }
    this.nextCursor = Threads.submitTask(new NameListBaseCursor.3(this, paramQMRefreshCallback, localCursor));
  }
  
  public void refresh(boolean paramBoolean, QMRefreshCallback paramQMRefreshCallback)
  {
    if (paramQMRefreshCallback != null) {
      this.threadWrapper.runOnMainThreadWithContext(new NameListBaseCursor.1(this, paramQMRefreshCallback));
    }
    if (paramBoolean) {
      reload();
    }
    refresh(paramQMRefreshCallback);
    nextCursor();
    getCursor();
  }
  
  protected abstract void reload();
  
  public void setOnRefresh(Runnable paramRunnable)
  {
    this.onRefresh = paramRunnable;
  }
  
  public void setThreadWrapper(IRunOnMainThreadWithContext paramIRunOnMainThreadWithContext)
  {
    this.threadWrapper = paramIRunOnMainThreadWithContext;
  }
  
  public static final class DefaultRunOnMainThreadContext
    implements NameListBaseCursor.IRunOnMainThreadWithContext
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
 * Qualified Name:     com.tencent.qqmail.namelist.cursor.NameListBaseCursor
 * JD-Core Version:    0.7.0.1
 */