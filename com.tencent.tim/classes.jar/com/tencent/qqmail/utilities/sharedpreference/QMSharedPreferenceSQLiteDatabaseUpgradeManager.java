package com.tencent.qqmail.utilities.sharedpreference;

import android.util.SparseArray;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqmail.model.mail.upgrade.ISQLIteDatabaseUpgrade;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Arrays;
import java.util.concurrent.Future;

public class QMSharedPreferenceSQLiteDatabaseUpgradeManager
{
  private static final String TAG = "QMSharedPreferenceSQLiteUpgradeManager";
  protected final int MIN_VERSION = 0;
  protected final int VERSION = 1;
  private Future<SparseArray<ISQLIteDatabaseUpgrade>> addVersionInFuture = Threads.submitTask(new QMSharedPreferenceSQLiteDatabaseUpgradeManager.1(this));
  
  private void addVersion(SparseArray<ISQLIteDatabaseUpgrade> paramSparseArray, ISQLIteDatabaseUpgrade paramISQLIteDatabaseUpgrade)
  {
    paramSparseArray.put(paramISQLIteDatabaseUpgrade.getVersion(), paramISQLIteDatabaseUpgrade);
  }
  
  private SparseArray<ISQLIteDatabaseUpgrade> getVersions()
  {
    try
    {
      SparseArray localSparseArray = (SparseArray)this.addVersionInFuture.get();
      return localSparseArray;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "QMSharedPreferenceSQLiteUpgradeManager", "getVersions failed: " + localException.toString());
    }
    return null;
  }
  
  private SparseArray<ISQLIteDatabaseUpgrade> setVersions()
  {
    SparseArray localSparseArray = new SparseArray();
    addVersion(localSparseArray, new QMSharedPreferenceSQLiteDatabaseUpgradeManager.2(this, this));
    return localSparseArray;
  }
  
  private int[] sortVersions(SparseArray<ISQLIteDatabaseUpgrade> paramSparseArray)
  {
    int[] arrayOfInt = new int[paramSparseArray.size()];
    int i = 0;
    while (i < paramSparseArray.size())
    {
      arrayOfInt[i] = paramSparseArray.keyAt(i);
      i += 1;
    }
    Arrays.sort(arrayOfInt);
    return arrayOfInt;
  }
  
  public int getMinSupportVersion()
  {
    return 0;
  }
  
  public int getVersion()
  {
    return 1;
  }
  
  public boolean upgrade(SQLiteOpenHelper paramSQLiteOpenHelper, SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    SparseArray localSparseArray = getVersions();
    if (localSparseArray == null) {
      return false;
    }
    int[] arrayOfInt = sortVersions(localSparseArray);
    int i = 0;
    boolean bool1 = false;
    if (i < arrayOfInt.length)
    {
      ISQLIteDatabaseUpgrade localISQLIteDatabaseUpgrade = (ISQLIteDatabaseUpgrade)localSparseArray.get(arrayOfInt[i]);
      boolean bool2 = bool1;
      if (arrayOfInt[i] > paramInt)
      {
        bool2 = bool1;
        if (arrayOfInt[i] <= getVersion()) {
          if (i <= 0) {
            break label120;
          }
        }
      }
      for (int j = arrayOfInt[(i - 1)];; j = paramInt) {
        try
        {
          localISQLIteDatabaseUpgrade.onUpgrade(paramSQLiteOpenHelper, paramSQLiteDatabase, j);
          bool2 = true;
          i += 1;
          bool1 = bool2;
        }
        catch (Exception localException)
        {
          label120:
          localStringBuilder = new StringBuilder().append("failed execute upgrade from ");
          if (i <= 0) {
            break label201;
          }
        }
      }
      StringBuilder localStringBuilder;
      label201:
      for (j = arrayOfInt[(i - 1)];; j = paramInt)
      {
        QMLog.log(5, "QMSharedPreferenceSQLiteUpgradeManager", j + " to " + arrayOfInt[i] + ": " + localException.getMessage());
        break;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceSQLiteDatabaseUpgradeManager
 * JD-Core Version:    0.7.0.1
 */