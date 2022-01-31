package com.tencent.mobileqq.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fni;

public class QQEntityManagerFactory$SQLiteOpenHelperImpl
  extends SQLiteOpenHelper
{
  private String databaseName;
  private SQLiteDatabase dbR;
  private SQLiteDatabase dbW;
  private SQLiteDatabase mInnerDb;
  
  public QQEntityManagerFactory$SQLiteOpenHelperImpl(QQEntityManagerFactory paramQQEntityManagerFactory, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(BaseApplication.getContext(), paramString, new fni(paramQQEntityManagerFactory, null), paramInt);
    this.databaseName = paramString;
  }
  
  private void dropAllTable(SQLiteDatabase paramSQLiteDatabase)
  {
    String[] arrayOfString = getAllTableName(paramSQLiteDatabase);
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      if (i < j)
      {
        String str = arrayOfString[i];
        if ("android_metadata".equals(str)) {}
        for (;;)
        {
          i += 1;
          break;
          if (!"sqlite_sequence".equals(str)) {
            paramSQLiteDatabase.execSQL(TableBuilder.a(str));
          }
        }
      }
    }
    onCreate(paramSQLiteDatabase);
  }
  
  private String[] getAllTableName(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject = null;
    Cursor localCursor = paramSQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
    paramSQLiteDatabase = localObject;
    int i;
    if (localCursor != null)
    {
      paramSQLiteDatabase = localObject;
      if (localCursor.moveToFirst())
      {
        paramSQLiteDatabase = new String[localCursor.getCount()];
        i = 0;
      }
    }
    for (;;)
    {
      paramSQLiteDatabase[i] = SecurityUtile.a(localCursor.getString(0));
      if (!localCursor.moveToNext())
      {
        if (localCursor != null) {
          localCursor.close();
        }
        return paramSQLiteDatabase;
      }
      i += 1;
    }
  }
  
  public void close()
  {
    try
    {
      if ((this.dbR != null) && (this.dbR.isOpen()))
      {
        this.dbR.close();
        this.dbR = null;
      }
      if ((this.dbW != null) && (this.dbW.isOpen()))
      {
        this.dbW.close();
        this.dbW = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void dropAllTable()
  {
    dropAllTable(this.mInnerDb);
  }
  
  /* Error */
  public SQLiteDatabase getReadableDatabase()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: invokespecial 112	android/database/sqlite/SQLiteOpenHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: putfield 98	com/tencent/mobileqq/data/QQEntityManagerFactory$SQLiteOpenHelperImpl:dbR	Landroid/database/sqlite/SQLiteDatabase;
    //   10: aload_0
    //   11: getfield 98	com/tencent/mobileqq/data/QQEntityManagerFactory$SQLiteOpenHelperImpl:dbR	Landroid/database/sqlite/SQLiteDatabase;
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: areturn
    //   19: astore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_1
    //   23: athrow
    //   24: astore_1
    //   25: goto -15 -> 10
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	SQLiteOpenHelperImpl
    //   14	4	1	localSQLiteDatabase	SQLiteDatabase
    //   19	4	1	localObject	Object
    //   24	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	10	19	finally
    //   10	15	19	finally
    //   2	10	24	java/lang/Exception
  }
  
  public SQLiteDatabase getWritableDatabase()
  {
    try
    {
      this.dbW = super.getWritableDatabase();
      this.dbW.setLockingEnabled(false);
      SQLiteDatabase localSQLiteDatabase = this.dbW;
      return localSQLiteDatabase;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    finally {}
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.this$0.TAG, 2, "[DB]" + this.databaseName + " onCreate");
    }
    this.this$0.createDatabase(paramSQLiteDatabase);
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onOpen(paramSQLiteDatabase);
    if (QLog.isColorLevel()) {
      QLog.i(this.this$0.TAG, 2, "[DB]" + this.databaseName + " onOpen");
    }
    this.mInnerDb = paramSQLiteDatabase;
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.this$0.TAG, 2, "[DB]" + this.databaseName + " onUpgrade" + " oldVersion: " + paramInt1 + " newVersion: " + paramInt2);
    }
    this.this$0.upgradeDatabase(paramSQLiteDatabase, paramInt1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.i(this.this$0.TAG, 2, "[DB] onUpgrade end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQEntityManagerFactory.SQLiteOpenHelperImpl
 * JD-Core Version:    0.7.0.1
 */