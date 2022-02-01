package com.tencent.qqmail;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.tencent.moai.database.DatabaseErrorHandler;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteDatabase.CursorFactory;
import com.tencent.moai.database.sqlite.SQLiteDiskIOException;
import com.tencent.moai.database.sqlite.SQLiteException;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.cacheclear.ClearCacheService;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.File;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;
import moai.oss.OssHelper;

public abstract class QMBaseSQLiteOpenHelper
  extends SQLiteOpenHelper
{
  private static final int RETRY = 3;
  private static final String TAG = "QMBaseSQLiteOpenHelper";
  private AtomicBoolean mCleared = new AtomicBoolean();
  private Context mContext;
  
  public QMBaseSQLiteOpenHelper(@NonNull Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, QMApplicationContext.sharedInstance().currentUin() + paramString, paramCursorFactory, paramInt, new QMDatabaseErrorHandler(null));
    this.mContext = paramContext.getApplicationContext();
    setWriteAheadLoggingEnabled(true);
    try
    {
      paramContext = SQLiteOpenHelper.class.getDeclaredField("mErrorHandler");
      paramContext.setAccessible(true);
      ((QMDatabaseErrorHandler)paramContext.get(this)).sqLiteOpenHelper = this;
      return;
    }
    catch (Exception paramContext) {}
  }
  
  private void clear()
  {
    clear(false);
  }
  
  private void clear(boolean paramBoolean)
  {
    if (this.mCleared.getAndSet(true)) {}
    File localFile1;
    do
    {
      return;
      close();
      localFile1 = this.mContext.getDatabasePath(getDatabaseName());
      localFile2 = new File(localFile1 + "-shm");
      bool = localFile2.delete();
      QMLog.log(6, "QMBaseSQLiteOpenHelper", "delete shm file: " + localFile2 + "/" + bool);
    } while (paramBoolean);
    File localFile2 = new File(localFile1 + "-wal");
    paramBoolean = localFile2.delete();
    boolean bool = localFile1.delete();
    QMLog.log(6, "QMBaseSQLiteOpenHelper", "delete sqlite files, sqlite: " + localFile1 + "/" + bool + ", wal: " + localFile2 + "/" + paramBoolean);
  }
  
  public SQLiteDatabase getReadableDatabase()
  {
    return getWritableDatabase();
  }
  
  public SQLiteDatabase getWritableDatabase()
  {
    SQLiteDatabase localSQLiteDatabase = null;
    int i = 0;
    for (;;)
    {
      int j = i + 1;
      if (i < 3)
      {
        try
        {
          localSQLiteDatabase = super.getWritableDatabase();
          return localSQLiteDatabase;
        }
        catch (Exception localException)
        {
          OssHelper.dbOpenFailed(new Object[] { localException.toString().replace(",", "|") });
          QMLog.log(5, "QMBaseSQLiteOpenHelper", "getWritableDatabase failed", localException);
          if (j != 2) {
            break label82;
          }
        }
        clear();
        for (;;)
        {
          if (j >= 3) {
            break label201;
          }
          SystemClock.sleep(100L);
          i = j;
          break;
          label82:
          if ((j >= 1) && ((localException instanceof SQLiteDiskIOException)) && (localException.getMessage() != null) && (localException.getMessage().contains("code 4874"))) {
            clear(true);
          }
        }
      }
      boolean bool = AppStatusUtil.isApplicationActive();
      String str = getDatabaseName() + " getWritableDatabase failed, foreground: " + bool;
      QMLog.log(6, "QMBaseSQLiteOpenHelper", str);
      if (bool) {
        this.mContext.startService(ClearCacheService.createAlertSpaceIntent());
      }
      for (;;)
      {
        throw new SQLiteException(str, localException);
        Process.killProcess(Process.myPid());
      }
      label201:
      i = j;
    }
  }
  
  static class QMDatabaseErrorHandler
    implements DatabaseErrorHandler
  {
    AtomicBoolean repaired = new AtomicBoolean();
    QMBaseSQLiteOpenHelper sqLiteOpenHelper;
    
    public void onCorruption(SQLiteDatabase paramSQLiteDatabase)
    {
      QMLog.log(5, "QMBaseSQLiteOpenHelper", "SQLiteDatabase, onCorruption: " + paramSQLiteDatabase.getPath() + ", repaired: " + this.repaired.get() + ", try repairing..");
      if (this.repaired.getAndSet(true)) {}
      long l;
      do
      {
        return;
        Threads.runInBackground(new QMBaseSQLiteOpenHelper.QMDatabaseErrorHandler.1(this), 10000L);
        ??? = new File(paramSQLiteDatabase.getPath()).getName();
        l = SystemClock.elapsedRealtime();
        int i = SQLiteDatabase.restore(paramSQLiteDatabase.getPath());
        OssHelper.dbOnCorruption(new Object[] { ???, Integer.valueOf(i) });
        if (i == 0)
        {
          QMLog.log(4, "QMBaseSQLiteOpenHelper", "SQLiteDatabase onCorruption repair success, db: " + paramSQLiteDatabase.getPath() + ", elapsed: " + (SystemClock.elapsedRealtime() - l) + "ms");
          return;
        }
      } while (this.sqLiteOpenHelper == null);
      synchronized (this.sqLiteOpenHelper)
      {
        if (paramSQLiteDatabase.isOpen())
        {
          this.sqLiteOpenHelper.close();
          paramSQLiteDatabase = new File(paramSQLiteDatabase.getPath());
          File localFile1 = new File(paramSQLiteDatabase + "-shm");
          File localFile2 = new File(paramSQLiteDatabase + "-wal");
          boolean bool1 = paramSQLiteDatabase.delete();
          boolean bool2 = localFile1.delete();
          boolean bool3 = localFile2.delete();
          QMLog.log(7, "QMBaseSQLiteOpenHelper", "SQLiteDatabase onCorruption, repare failed!! Delete sqlite files, sqlite: " + paramSQLiteDatabase + "/" + bool1 + ", shm: " + localFile1 + "/" + bool2 + ", wal: " + localFile2 + "/" + bool3 + ", elpased: " + (SystemClock.elapsedRealtime() - l) + "ms");
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.QMBaseSQLiteOpenHelper
 * JD-Core Version:    0.7.0.1
 */