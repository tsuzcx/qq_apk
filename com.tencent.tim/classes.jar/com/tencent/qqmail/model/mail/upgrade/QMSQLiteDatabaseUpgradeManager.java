package com.tencent.qqmail.model.mail.upgrade;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Arrays;
import java.util.concurrent.Future;

public class QMSQLiteDatabaseUpgradeManager
{
  private static final String TAG = "QMSQLiteDatabaseUpgradeManager";
  protected static final int VERSION = 5302;
  protected final int MIN_VERSION = 10;
  private Future<SparseArray<ISQLIteDatabaseUpgrade>> addVersionInFuture = Threads.submitTask(new QMSQLiteDatabaseUpgradeManager.1(this));
  private final String lastVersion = readLastVersion();
  
  private String readLastVersion()
  {
    String str2 = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0).getString("lastVersion", "");
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (!str2.equals("")) {}
    }
    else
    {
      str1 = "3.0";
    }
    return str1;
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
  
  protected void addVersion(SparseArray<ISQLIteDatabaseUpgrade> paramSparseArray, ISQLIteDatabaseUpgrade paramISQLIteDatabaseUpgrade)
  {
    paramSparseArray.put(paramISQLIteDatabaseUpgrade.getVersion(), paramISQLIteDatabaseUpgrade);
  }
  
  protected SparseArray<ISQLIteDatabaseUpgrade> addVersions()
  {
    SparseArray localSparseArray = new SparseArray();
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.2(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.3(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.4(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.5(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.6(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.7(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.8(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.9(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.10(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.11(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.12(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.13(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.14(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.15(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.16(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.17(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.18(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.19(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.20(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.21(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.22(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.23(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.24(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.25(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.26(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.27(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.28(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.29(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.30(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.31(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.32(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.33(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.34(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.35(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.36(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.37(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.38(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.39(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.40(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.41(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.42(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.43(this, this));
    addVersion(localSparseArray, new QMSQLiteDatabaseUpgradeManager.44(this, this));
    return localSparseArray;
  }
  
  public String getLastVersion()
  {
    return this.lastVersion;
  }
  
  public int getMinSupportVersion()
  {
    return getMinVersion();
  }
  
  public int getMinVersion()
  {
    return 10;
  }
  
  public int getPrevVersion(SparseArray<ISQLIteDatabaseUpgrade> paramSparseArray, ISQLIteDatabaseUpgrade paramISQLIteDatabaseUpgrade)
  {
    int k = 0;
    paramSparseArray = sortVersions(paramSparseArray);
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < paramSparseArray.length)
      {
        if ((paramSparseArray[i] == paramISQLIteDatabaseUpgrade.getVersion()) && (i > 0)) {
          j = paramSparseArray[(i - 1)];
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  public int getVersion()
  {
    return 5302;
  }
  
  public SparseArray<ISQLIteDatabaseUpgrade> getVersions()
  {
    try
    {
      SparseArray localSparseArray = (SparseArray)this.addVersionInFuture.get();
      return localSparseArray;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "QMSQLiteDatabaseUpgradeManager", "getVersions failed: " + localException.toString());
    }
    return null;
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
            break label206;
          }
        }
      }
      StringBuilder localStringBuilder;
      label206:
      for (j = arrayOfInt[(i - 1)];; j = paramInt)
      {
        QMLog.log(6, "SQLiteDatabase", j + " to " + arrayOfInt[i] + ": " + localException.getMessage());
        break;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.upgrade.QMSQLiteDatabaseUpgradeManager
 * JD-Core Version:    0.7.0.1
 */