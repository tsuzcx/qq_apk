package com.tencent.qqmail.model.mail;

import android.database.Cursor;
import androidx.annotation.NonNull;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.model.mail.cursor.IMailListCursor;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

public abstract class QMMailListCursor
  implements IMailListCursor
{
  public static final int STATE_LOADING = 1;
  public static final int STATE_NORMAL = 0;
  public static final int STATE_UPDATING = -1;
  protected static final String TAG = "QMMailListCursor";
  private Future<Boolean> canLoadMore;
  private boolean canPopIn;
  private Future<Boolean> canUpdate;
  private Future<Cursor> cursor;
  private boolean doNotLogNPEAtFirst = false;
  protected Cursor latestCursor;
  protected int[] mCacheColumnIndex = new int[100];
  private Future<Boolean> nextCanLoadMore;
  private Future<Cursor> nextCursor;
  private Runnable onRefresh = null;
  public QMMailSQLiteHelper sqliteHelper;
  private IRunOnMainThreadWithContext threadWrapper = new DefaultRunOnMainThreadContext();
  
  public QMMailListCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper)
  {
    this.sqliteHelper = paramQMMailSQLiteHelper;
    Arrays.fill(this.mCacheColumnIndex, -2147483648);
  }
  
  protected void afterRefresh() {}
  
  protected void beforeRefresh() {}
  
  public final boolean canLoadMore()
  {
    try
    {
      boolean bool = ((Boolean)this.canLoadMore.get()).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      if (this.doNotLogNPEAtFirst) {
        QMLog.log(6, "QMMailListCursor", "canLoadMore: " + localException.toString());
      }
    }
    return false;
  }
  
  public final boolean canPopIn()
  {
    return this.canPopIn;
  }
  
  protected boolean canRefresh()
  {
    return true;
  }
  
  public final boolean canUpdate()
  {
    try
    {
      boolean bool = ((Boolean)this.canUpdate.get()).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      if (this.doNotLogNPEAtFirst) {
        QMLog.log(6, "QMMailListCursor", "canUpdate: " + localException.toString());
      }
    }
    return false;
  }
  
  public Cursor cloneCursor()
  {
    return queryRawCursor();
  }
  
  public void close()
  {
    QMCursorCollector.release(this.latestCursor);
    Threads.cancelTask(this.cursor);
    Threads.cancelTask(this.canLoadMore);
    Threads.cancelTask(this.canUpdate);
  }
  
  public int getCount()
  {
    boolean bool = true;
    Cursor localCursor = getCursor();
    if ((localCursor != null) && (!localCursor.isClosed()))
    {
      i = 1;
      if (i == 0) {
        break label100;
      }
    }
    label95:
    label100:
    for (int i = localCursor.getCount();; i = 0)
    {
      StringBuilder localStringBuilder;
      if (i == 0)
      {
        localStringBuilder = new StringBuilder().append("count is 0, cursor: ").append(localCursor).append(", closed: ");
        if ((localCursor == null) || (!localCursor.isClosed())) {
          break label95;
        }
      }
      for (;;)
      {
        QMLog.log(5, "QMMailListCursor", bool);
        return i;
        i = 0;
        break;
        bool = false;
      }
    }
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
        if (this.doNotLogNPEAtFirst) {
          QMLog.log(6, "QMMailListCursor", "getCursor: " + localException.toString());
        }
      }
    }
  }
  
  @NonNull
  public Mail getItem(int paramInt)
  {
    return getMailItem(paramInt);
  }
  
  public Mail getItem(Cursor paramCursor, int[] paramArrayOfInt, boolean paramBoolean)
  {
    Mail localMail = new Mail();
    localMail.setStatus(new MailStatus());
    localMail.setInformation(new MailInformation());
    if (paramBoolean) {
      QMMailSQLite.fillMail(paramCursor, localMail, paramArrayOfInt);
    }
    return localMail;
  }
  
  public long getItemId(int paramInt)
  {
    Cursor localCursor = getCursor();
    localCursor.moveToPosition(paramInt);
    try
    {
      long l = localCursor.getLong(localCursor.getColumnIndex("id"));
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public long[] getItemIds()
  {
    int i = 0;
    Object localObject = getCursor();
    int j;
    if ((localObject != null) && (!((Cursor)localObject).isClosed()))
    {
      j = ((Cursor)localObject).getCount();
      if (j > 0) {}
    }
    else
    {
      localObject = new long[0];
      return localObject;
    }
    long[] arrayOfLong = new long[j];
    for (;;)
    {
      localObject = arrayOfLong;
      if (i >= j) {
        break;
      }
      arrayOfLong[i] = getItemId(i);
      i += 1;
    }
  }
  
  public Future<long[]> getItemIdsInFuture()
  {
    return Threads.submitTask(new QMMailListCursor.1(this));
  }
  
  @NonNull
  public final Mail getMailItem(int paramInt)
  {
    Cursor localCursor = getCursor();
    boolean bool = localCursor.moveToPosition(paramInt);
    if (!bool) {
      QMLog.log(5, "QMMailListCursor", "getItem, move to " + paramInt + " failed, May be caused by cursor changed!");
    }
    return getItem(localCursor, this.mCacheColumnIndex, bool);
  }
  
  public int getState()
  {
    return 0;
  }
  
  public int[] getUnreadItemPosition()
  {
    int m = 0;
    ArrayList localArrayList = new ArrayList();
    Object localObject = getCursor();
    if ((localObject != null) && (!((Cursor)localObject).isClosed()))
    {
      int n = ((Cursor)localObject).getCount();
      int j = -1;
      int i = 0;
      while (i < n)
      {
        ((Cursor)localObject).moveToPosition(i);
        int k = j;
        if (((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndex("isUnread")) == 1)
        {
          k = j + 1;
          localArrayList.add(k, Integer.valueOf(i));
        }
        i += 1;
        j = k;
      }
      if (localArrayList.size() > 0)
      {
        localObject = new int[localArrayList.size()];
        i = m;
        while (i < localObject.length)
        {
          localObject[i] = ((Integer)localArrayList.get(i)).intValue();
          i += 1;
        }
        return localObject;
      }
    }
    return new int[0];
  }
  
  public boolean isOverdue()
  {
    return true;
  }
  
  public abstract void loadMore();
  
  public void nextCursor()
  {
    try
    {
      this.nextCursor.get();
      return;
    }
    catch (Exception localException)
    {
      while (!this.doNotLogNPEAtFirst) {}
      QMLog.log(6, "QMMailListCursor", "nextCursor: " + localException.toString());
    }
  }
  
  public void popIn()
  {
    Threads.runInBackground(new QMMailListCursor.11(this));
  }
  
  protected abstract boolean queryCanLoadMore();
  
  protected abstract boolean queryCanPopIn();
  
  protected abstract boolean queryCanUpdate();
  
  protected abstract Cursor queryRawCursor();
  
  public final void refresh()
  {
    boolean bool3 = false;
    beforeRefresh();
    Cursor localCursor;
    boolean bool1;
    if (canRefresh())
    {
      localCursor = getCursor();
      QMCursorCollector.retain(localCursor);
      this.doNotLogNPEAtFirst = true;
      if (this.cursor == null) {
        break label185;
      }
      bool1 = true;
      boolean bool2 = bool3;
      if (this.cursor != null)
      {
        bool2 = bool3;
        if (getCount() == 0) {
          bool2 = true;
        }
      }
      QMLog.log(4, "QMMailListCursor", "refresh, cursorInitialized: " + bool1 + ", noData: " + bool2 + "," + this);
      if ((bool1) && (!bool2)) {
        break label190;
      }
      this.cursor = Threads.submitTask(new QMMailListCursor.2(this));
      this.canLoadMore = Threads.submitTask(new QMMailListCursor.3(this));
      if (bool2) {
        this.threadWrapper.runOnMainThreadWithContext(new QMMailListCursor.4(this, localCursor));
      }
    }
    for (;;)
    {
      this.canUpdate = Threads.submitTask(new QMMailListCursor.8(this));
      afterRefresh();
      return;
      label185:
      bool1 = false;
      break;
      label190:
      if ((this.nextCursor != null) && (!this.nextCursor.isDone()))
      {
        this.nextCursor.cancel(true);
        QMLog.log(4, "QMMailListCursor", "nextCursor cancel and release originalCursor");
      }
      if ((this.nextCanLoadMore != null) && (!this.nextCanLoadMore.isDone()))
      {
        this.nextCanLoadMore.cancel(true);
        QMLog.log(4, "QMMailListCursor", "nextCanLoadMore cancel");
      }
      CountDownLatch localCountDownLatch = new CountDownLatch(2);
      Future localFuture1 = Threads.submitTask(new QMMailListCursor.5(this, localCountDownLatch));
      this.nextCursor = localFuture1;
      Future localFuture2 = Threads.submitTask(new QMMailListCursor.6(this, localCountDownLatch));
      this.nextCanLoadMore = localFuture2;
      Threads.runInBackground(new QMMailListCursor.7(this, localCountDownLatch, localFuture1, localFuture2, localCursor));
    }
  }
  
  public final void refresh(QMRefreshCallback paramQMRefreshCallback)
  {
    refresh(false, paramQMRefreshCallback);
  }
  
  public final void refresh(boolean paramBoolean, QMRefreshCallback paramQMRefreshCallback)
  {
    if (paramQMRefreshCallback != null) {
      this.threadWrapper.runOnMainThreadWithContext(new QMMailListCursor.9(this, paramQMRefreshCallback));
    }
    refresh();
    if (paramBoolean) {
      reload();
    }
    nextCursor();
    getCursor();
    if (paramQMRefreshCallback != null) {
      this.threadWrapper.runOnMainThreadWithContext(new QMMailListCursor.10(this, paramQMRefreshCallback));
    }
  }
  
  protected void reload() {}
  
  public void reloadAfterDeleteMailSyncRemote()
  {
    reload();
  }
  
  public void setOnRefresh(Runnable paramRunnable)
  {
    this.onRefresh = paramRunnable;
  }
  
  public void setThreadWrapper(IRunOnMainThreadWithContext paramIRunOnMainThreadWithContext)
  {
    this.threadWrapper = paramIRunOnMainThreadWithContext;
  }
  
  public abstract void update();
  
  public static final class DefaultRunOnMainThreadContext
    implements QMMailListCursor.IRunOnMainThreadWithContext
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
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailListCursor
 * JD-Core Version:    0.7.0.1
 */