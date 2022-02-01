package com.tencent.qqmail.download.cursor;

import android.database.Cursor;
import android.util.Log;
import com.tencent.qqmail.download.DownloadInfoSQLiteHelper;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.model.mail.QMCursorCollector;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Arrays;
import java.util.concurrent.Future;

public class DownloadInfoCursor
  implements IDownloadCursor
{
  private static final String TAG = "DownloadInfoCursor";
  protected int[] cacheColumnIndex = new int[100];
  private Future<Cursor> cursor;
  private Cursor latestCursor;
  private Future<Cursor> nextCursor;
  private Runnable onRefresh = null;
  protected DownloadInfoSQLiteHelper sqliteHelper;
  private IRunOnMainThreadWithContext threadWrapper = new DefaultRunOnMainThreadContext();
  
  public DownloadInfoCursor(DownloadInfoSQLiteHelper paramDownloadInfoSQLiteHelper)
  {
    this.sqliteHelper = paramDownloadInfoSQLiteHelper;
    Arrays.fill(this.cacheColumnIndex, -2147483648);
  }
  
  private void nextCursor()
  {
    try
    {
      this.nextCursor.get();
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "DownloadInfoCursor", "nextCursor: " + localException.toString());
    }
  }
  
  private Cursor queryRawCursor()
  {
    return this.sqliteHelper.queryDownloadInfo(this.sqliteHelper.getReadableDatabase());
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
      this.cursor = Threads.submitTask(new DownloadInfoCursor.3(this));
      this.threadWrapper.runOnMainThreadWithContext(new DownloadInfoCursor.4(this, bool1, localCursor));
      return;
    }
    if ((this.nextCursor != null) && (!this.nextCursor.isDone())) {
      this.nextCursor.cancel(true);
    }
    this.nextCursor = Threads.submitTask(new DownloadInfoCursor.5(this, localCursor));
  }
  
  private void reload() {}
  
  public void close()
  {
    QMCursorCollector.release(this.latestCursor);
    QMCursorCollector.cleanup();
    Threads.cancelTask(this.cursor);
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
      QMLog.log(6, "DownloadInfoCursor", "getCount: " + localException.toString());
    }
    return 0;
  }
  
  public Cursor getCursor()
  {
    try
    {
      if (this.cursor != null) {
        this.latestCursor = ((Cursor)this.cursor.get());
      }
      return this.latestCursor;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.latestCursor = null;
        QMLog.log(6, "DownloadInfoCursor", "getCursor: " + Log.getStackTraceString(localException));
      }
    }
  }
  
  public DownloadInfo getItem(int paramInt)
  {
    Cursor localCursor = getCursor();
    localCursor.moveToPosition(paramInt);
    return getItem(localCursor);
  }
  
  protected DownloadInfo getItem(Cursor paramCursor)
  {
    return DownloadInfoSQLiteHelper.fillDownloadInfo(paramCursor, this.cacheColumnIndex);
  }
  
  public long getItemId(int paramInt)
  {
    Cursor localCursor = getCursor();
    localCursor.moveToPosition(paramInt);
    return localCursor.getLong(0);
  }
  
  public void refresh(boolean paramBoolean, QMRefreshCallback paramQMRefreshCallback)
  {
    if (paramQMRefreshCallback != null) {
      this.threadWrapper.runOnMainThreadWithContext(new DownloadInfoCursor.1(this, paramQMRefreshCallback));
    }
    refresh();
    if (paramBoolean) {
      reload();
    }
    nextCursor();
    getCursor();
    if (paramQMRefreshCallback != null) {
      this.threadWrapper.runOnMainThreadWithContext(new DownloadInfoCursor.2(this, paramQMRefreshCallback));
    }
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
    implements DownloadInfoCursor.IRunOnMainThreadWithContext
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
 * Qualified Name:     com.tencent.qqmail.download.cursor.DownloadInfoCursor
 * JD-Core Version:    0.7.0.1
 */