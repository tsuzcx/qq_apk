package com.tencent.qqmail.inquirymail.cursor;

import android.database.Cursor;
import com.tencent.qqmail.inquirymail.InquiryMailManager;
import com.tencent.qqmail.inquirymail.InquiryMailSQLite;
import com.tencent.qqmail.inquirymail.model.InquiryMail;
import com.tencent.qqmail.model.mail.QMCursorCollector;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Arrays;
import java.util.concurrent.Future;

public class InquiryMailListCursor
  implements IInquiryMailListCursor
{
  public static final int STATE_INIT = 1;
  public static final int STATE_LOAD_MORE = 2;
  public static final int STATE_NORMAL = 0;
  public static final String TAG = "InquiryMailListCursor";
  private int accountId;
  private Future<Boolean> canLoadMore;
  private Future<Cursor> cursor;
  private InquiryMailManager inquiryMailManager;
  private Cursor latestCursor;
  private int[] mCacheColumnIndex = new int[100];
  private Future<Boolean> nextCanLoadMore;
  private Future<Cursor> nextCursor;
  private Runnable onRefresh = null;
  private QMMailSQLiteHelper sqliteHelper;
  private IRunOnMainThreadWithContext threadWrapper = new DefaultRunOnMainThreadContext();
  
  public InquiryMailListCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, InquiryMailManager paramInquiryMailManager, int paramInt)
  {
    this.sqliteHelper = paramQMMailSQLiteHelper;
    this.inquiryMailManager = paramInquiryMailManager;
    this.accountId = paramInt;
    Arrays.fill(this.mCacheColumnIndex, -2147483648);
  }
  
  private InquiryMail getItem(Cursor paramCursor)
  {
    InquiryMail localInquiryMail = new InquiryMail();
    InquiryMailSQLite.fillInquiryMail(localInquiryMail, paramCursor, this.mCacheColumnIndex);
    return localInquiryMail;
  }
  
  private boolean queryCanLoadMore()
  {
    return QMSettingManager.sharedInstance().isInquiryMailAccountHasMore(this.accountId) == 1;
  }
  
  private Cursor queryRawCursor()
  {
    return this.sqliteHelper.inquiryMail.getInquiryMailCursor(this.sqliteHelper.getReadableDatabase(), this.accountId);
  }
  
  private void refresh()
  {
    Cursor localCursor = getCursor();
    QMCursorCollector.retain(localCursor);
    boolean bool1;
    if (this.cursor != null)
    {
      bool1 = true;
      if ((this.cursor == null) || (getCount() != 0)) {
        break label134;
      }
    }
    label134:
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((bool1) && (!bool2)) {
        break label139;
      }
      QMLog.log(4, "InquiryMailListCursor", "cursorInitialized = " + bool1 + " noData = " + bool2);
      this.cursor = Threads.submitTask(new InquiryMailListCursor.1(this));
      this.canLoadMore = Threads.submitTask(new InquiryMailListCursor.2(this));
      if (bool2) {
        this.threadWrapper.runOnMainThreadWithContext(new InquiryMailListCursor.3(this, localCursor));
      }
      return;
      bool1 = false;
      break;
    }
    label139:
    short[] arrayOfShort = new short[1];
    arrayOfShort[0] = 0;
    if ((this.nextCursor != null) && (!this.nextCursor.isDone()))
    {
      this.nextCursor.cancel(true);
      QMCursorCollector.release(localCursor);
      QMLog.log(4, "InquiryMailListCursor", "nextCursor cancel and release originalCursor");
    }
    if ((this.nextCanLoadMore != null) && (!this.nextCanLoadMore.isDone()))
    {
      this.nextCanLoadMore.cancel(true);
      QMLog.log(4, "InquiryMailListCursor", "nextCanLoadMore cancel");
    }
    this.nextCursor = Threads.submitTask(new InquiryMailListCursor.4(this, arrayOfShort, localCursor));
    this.nextCanLoadMore = Threads.submitTask(new InquiryMailListCursor.5(this, arrayOfShort));
  }
  
  public boolean canLoadMore()
  {
    try
    {
      boolean bool = ((Boolean)this.canLoadMore.get()).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "InquiryMailListCursor", "canLoadMore: " + localException.toString());
    }
    return false;
  }
  
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
      QMLog.log(6, "InquiryMailListCursor", "getCount: " + localException.toString());
    }
    return 0;
  }
  
  protected Cursor getCursor()
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
        QMLog.log(6, "InquiryMailListCursor", "getCursor: " + localException.toString());
      }
    }
  }
  
  public InquiryMail getItem(int paramInt)
  {
    Cursor localCursor = getCursor();
    localCursor.moveToPosition(paramInt);
    return getItem(localCursor);
  }
  
  public long getItemId(int paramInt)
  {
    Cursor localCursor = getCursor();
    localCursor.moveToPosition(paramInt);
    return localCursor.getLong(0);
  }
  
  public int getState()
  {
    if (RequestFilter.isRequestOnRunning("help_static_receive_load_more" + this.accountId)) {
      return 2;
    }
    if (RequestFilter.isRequestOnRunning("help_static_receive_init" + this.accountId)) {
      return 1;
    }
    return 0;
  }
  
  public void loadMore()
  {
    if (!canLoadMore()) {
      return;
    }
    this.inquiryMailManager.loadInquiryMailList(this.accountId);
  }
  
  public void nextCursor()
  {
    try
    {
      this.nextCursor.get();
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "InquiryMailListCursor", "nextCursor: " + localException.toString());
    }
  }
  
  public void refresh(QMRefreshCallback paramQMRefreshCallback)
  {
    refresh(false, paramQMRefreshCallback);
  }
  
  public void refresh(boolean paramBoolean, QMRefreshCallback paramQMRefreshCallback)
  {
    if (paramQMRefreshCallback != null) {
      this.threadWrapper.runOnMainThreadWithContext(new InquiryMailListCursor.6(this, paramQMRefreshCallback));
    }
    refresh();
    if (paramBoolean) {
      reload();
    }
    nextCursor();
    getCursor();
    if (paramQMRefreshCallback != null) {
      this.threadWrapper.runOnMainThreadWithContext(new InquiryMailListCursor.7(this, paramQMRefreshCallback));
    }
  }
  
  public void reload()
  {
    this.inquiryMailManager.initLoadInquiryMailList(this.accountId);
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
    implements InquiryMailListCursor.IRunOnMainThreadWithContext
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
 * Qualified Name:     com.tencent.qqmail.inquirymail.cursor.InquiryMailListCursor
 * JD-Core Version:    0.7.0.1
 */