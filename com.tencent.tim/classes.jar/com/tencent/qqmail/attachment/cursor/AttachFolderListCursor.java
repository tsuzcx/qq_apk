package com.tencent.qqmail.attachment.cursor;

import android.database.Cursor;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.QMAttachSQLite;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.model.mail.QMCursorCollector;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.concurrent.Future;

public class AttachFolderListCursor
  implements IAttachFolderListCursor
{
  private static String FIELD_ATTACH_HASH_ID = "id";
  public static final int STATE_LOADING = 1;
  public static final int STATE_NORMAL = 0;
  public static final int STATE_UPDATING = 2;
  public static final String TAG = "AttachFolderListCursor";
  private QMAttachManager attachFolderMgr;
  private Future<Cursor> cursor;
  private Cursor latestCursor;
  private Future<Cursor> nextCursor;
  private Runnable onRefresh = null;
  private QMMailSQLiteHelper sqliteHelper;
  
  public AttachFolderListCursor(QMMailSQLiteHelper paramQMMailSQLiteHelper, QMAttachManager paramQMAttachManager)
  {
    this.sqliteHelper = paramQMMailSQLiteHelper;
    this.attachFolderMgr = paramQMAttachManager;
  }
  
  private boolean canRefresh()
  {
    return true;
  }
  
  private Cursor getCursor()
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
        QMLog.log(6, "AttachFolderListCursor", "getCursor: " + localException.toString());
      }
    }
  }
  
  private Attach getItem(Cursor paramCursor)
  {
    if ((this.sqliteHelper != null) && (paramCursor != null)) {
      return QMAttachSQLite.fillAttach(this.sqliteHelper.getReadableDatabase(), paramCursor);
    }
    return null;
  }
  
  private long getItemId(Cursor paramCursor)
  {
    return paramCursor.getLong(paramCursor.getColumnIndex(FIELD_ATTACH_HASH_ID));
  }
  
  private Cursor queryRawCursor()
  {
    SQLiteDatabase localSQLiteDatabase = this.sqliteHelper.getReadableDatabase();
    return this.sqliteHelper.attach.getAttachFolderListCursor(localSQLiteDatabase);
  }
  
  private void reload()
  {
    checkUpdate();
  }
  
  public void checkUpdate()
  {
    this.attachFolderMgr.checkAttachFolderListByAccounts(true, false);
  }
  
  public void close()
  {
    QMCursorCollector.release(this.latestCursor);
    QMCursorCollector.cleanup();
    Threads.cancelTask(this.cursor);
  }
  
  public int getCount()
  {
    int j = 0;
    try
    {
      Cursor localCursor = getCursor();
      int i = j;
      if (localCursor != null)
      {
        i = j;
        if (!localCursor.isClosed()) {
          i = localCursor.getCount();
        }
      }
      return i;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "AttachFolderListCursor", "getCount: " + localException.toString());
    }
    return 0;
  }
  
  public Attach getItem(int paramInt)
  {
    Cursor localCursor = getCursor();
    localCursor.moveToPosition(paramInt);
    return getItem(localCursor);
  }
  
  public long getItemId(int paramInt)
  {
    Cursor localCursor = getCursor();
    localCursor.moveToPosition(paramInt);
    return getItemId(localCursor);
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
  
  public int getState()
  {
    if (!this.attachFolderMgr.checkListFinished()) {
      return 2;
    }
    if (!this.attachFolderMgr.loadListFinished()) {
      return 1;
    }
    return 0;
  }
  
  public final void refresh()
  {
    if (canRefresh())
    {
      Cursor localCursor = getCursor();
      QMCursorCollector.retain(localCursor);
      if ((this.nextCursor != null) && (!this.nextCursor.isDone())) {
        this.nextCursor.cancel(true);
      }
      this.nextCursor = Threads.submitTask(new AttachFolderListCursor.1(this, localCursor));
    }
  }
  
  public void refresh(QMRefreshCallback paramQMRefreshCallback)
  {
    refresh(false, paramQMRefreshCallback);
  }
  
  public void refresh(boolean paramBoolean, QMRefreshCallback paramQMRefreshCallback)
  {
    if (paramQMRefreshCallback != null) {
      Threads.runOnMainThread(new AttachFolderListCursor.2(this, paramQMRefreshCallback));
    }
    refresh();
    if (paramBoolean) {
      reload();
    }
    if (paramQMRefreshCallback != null) {
      Threads.runOnMainThread(new AttachFolderListCursor.3(this, paramQMRefreshCallback));
    }
  }
  
  public void setOnRefresh(Runnable paramRunnable)
  {
    this.onRefresh = paramRunnable;
  }
  
  public void update(int paramInt)
  {
    this.attachFolderMgr.loadAttachFolderList(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.cursor.AttachFolderListCursor
 * JD-Core Version:    0.7.0.1
 */