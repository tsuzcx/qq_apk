package com.tencent.qqmail.card.cursor;

import android.database.Cursor;
import android.util.Log;
import com.tencent.qqmail.card.QMCardSQLiteHelper;
import com.tencent.qqmail.model.mail.QMCursorCollector;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Arrays;
import java.util.concurrent.Future;

public abstract class QMCardBaseCursor
  implements ICardDataListCursor
{
  private static final String TAG = "QMCardDataListBaseCursor";
  protected int[] cacheColumnIndex = new int[100];
  private Future<Cursor> currentCursor;
  private Cursor latestCursor;
  private Future<Cursor> nextCursor;
  protected QMCardSQLiteHelper sqLiteHelper;
  private IRunOnMainThreadWithContext threadWrapper = new DefaultRunOnMainThreadContext();
  
  public QMCardBaseCursor(QMCardSQLiteHelper paramQMCardSQLiteHelper)
  {
    this.sqLiteHelper = paramQMCardSQLiteHelper;
    Arrays.fill(this.cacheColumnIndex, -2147483648);
  }
  
  private void nextCardListData()
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
      QMLog.log(6, "QMCardDataListBaseCursor", "nextContactListData: " + Log.getStackTraceString(localException));
    }
  }
  
  private void refresh(QMRefreshCallback paramQMRefreshCallback)
  {
    Cursor localCursor = getCursor();
    QMCursorCollector.retain(localCursor);
    if (this.currentCursor != null) {}
    for (boolean bool = true; ((this.currentCursor == null) || (getCount() != 0)) || (!bool); bool = false)
    {
      this.currentCursor = Threads.submitTask(new QMCardBaseCursor.2(this, bool, paramQMRefreshCallback));
      return;
    }
    if ((this.nextCursor != null) && (!this.nextCursor.isDone())) {
      this.nextCursor.cancel(true);
    }
    this.nextCursor = Threads.submitTask(new QMCardBaseCursor.3(this, paramQMRefreshCallback, localCursor));
  }
  
  public void close()
  {
    QMCursorCollector.release(this.latestCursor);
    QMCursorCollector.cleanup();
    Threads.cancelTask(this.currentCursor);
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
      QMLog.log(6, "QMCardDataListBaseCursor", "getCount: " + localException.toString());
    }
    return 0;
  }
  
  public Cursor getCursor()
  {
    try
    {
      if (this.currentCursor != null)
      {
        Cursor localCursor = (Cursor)this.currentCursor.get();
        if (localCursor != null) {
          this.latestCursor = localCursor;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.latestCursor = null;
        QMLog.log(6, "QMCardDataListBaseCursor", "getCursor: " + Log.getStackTraceString(localException));
      }
    }
    return this.latestCursor;
  }
  
  public abstract Object getItem(int paramInt);
  
  public long getItemId(int paramInt)
  {
    Cursor localCursor = getCursor();
    localCursor.moveToPosition(paramInt);
    return localCursor.getLong(0);
  }
  
  protected abstract Cursor queryRawCursor();
  
  public void refresh(boolean paramBoolean, QMRefreshCallback paramQMRefreshCallback)
  {
    if (paramQMRefreshCallback != null) {
      this.threadWrapper.runOnMainThreadWithContext(new QMCardBaseCursor.1(this, paramQMRefreshCallback));
    }
    if (paramBoolean) {
      reload();
    }
    refresh(paramQMRefreshCallback);
    nextCardListData();
    getCursor();
  }
  
  protected abstract void reload();
  
  public void setThreadWrapper(IRunOnMainThreadWithContext paramIRunOnMainThreadWithContext)
  {
    this.threadWrapper = paramIRunOnMainThreadWithContext;
  }
  
  public static final class DefaultRunOnMainThreadContext
    implements QMCardBaseCursor.IRunOnMainThreadWithContext
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.cursor.QMCardBaseCursor
 * JD-Core Version:    0.7.0.1
 */