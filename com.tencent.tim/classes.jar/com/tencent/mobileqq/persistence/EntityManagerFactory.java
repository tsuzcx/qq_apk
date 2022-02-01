package com.tencent.mobileqq.persistence;

import android.annotation.TargetApi;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteQuery;
import android.text.TextUtils;
import com.tencent.mobileqq.data.Ability;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class EntityManagerFactory
{
  protected static final String CLOSE_EXCEPTION_MSG = "The EntityManagerFactory has been already closed";
  protected static final int FLAG_CHECK_AUTHENTICATION = -1;
  public static long corruptedTime = -1L;
  public String TAG = "EntityManagerFactory";
  protected boolean closed;
  protected com.tencent.mobileqq.app.SQLiteOpenHelper dbHelper = build(paramString);
  protected SQLiteOpenHelperImpl mInnerDbHelper;
  protected String mName;
  public String name;
  
  public EntityManagerFactory(String paramString)
  {
    this.mName = paramString;
    this.name = paramString;
  }
  
  /* Error */
  public static String getSqliteLibraryVersion()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore_0
    //   6: ldc 59
    //   8: astore_3
    //   9: ldc 61
    //   11: aconst_null
    //   12: invokestatic 67	android/database/sqlite/SQLiteDatabase:openOrCreateDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore 4
    //   17: aload 4
    //   19: astore_0
    //   20: aload_2
    //   21: astore_1
    //   22: aload_0
    //   23: ldc 69
    //   25: aconst_null
    //   26: invokevirtual 73	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore_2
    //   30: aload_2
    //   31: astore_1
    //   32: aload_2
    //   33: invokeinterface 79 1 0
    //   38: ifeq +33 -> 71
    //   41: aload_2
    //   42: astore_1
    //   43: new 81	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   50: aload_3
    //   51: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_2
    //   55: iconst_0
    //   56: invokeinterface 90 2 0
    //   61: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore_3
    //   68: goto -38 -> 30
    //   71: aload_2
    //   72: ifnull +9 -> 81
    //   75: aload_2
    //   76: invokeinterface 96 1 0
    //   81: aload_3
    //   82: astore_1
    //   83: aload_0
    //   84: ifnull +9 -> 93
    //   87: aload_0
    //   88: invokevirtual 97	android/database/sqlite/SQLiteDatabase:close	()V
    //   91: aload_3
    //   92: astore_1
    //   93: aload_1
    //   94: areturn
    //   95: astore_2
    //   96: aconst_null
    //   97: astore_1
    //   98: ldc 99
    //   100: astore_3
    //   101: ldc 101
    //   103: iconst_1
    //   104: ldc 103
    //   106: aload_2
    //   107: invokestatic 109	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   110: aload_1
    //   111: ifnull +9 -> 120
    //   114: aload_1
    //   115: invokeinterface 96 1 0
    //   120: aload_3
    //   121: astore_1
    //   122: aload_0
    //   123: ifnull -30 -> 93
    //   126: aload_0
    //   127: invokevirtual 97	android/database/sqlite/SQLiteDatabase:close	()V
    //   130: ldc 99
    //   132: areturn
    //   133: astore_2
    //   134: aconst_null
    //   135: astore_0
    //   136: aload_1
    //   137: ifnull +9 -> 146
    //   140: aload_1
    //   141: invokeinterface 96 1 0
    //   146: aload_0
    //   147: ifnull +7 -> 154
    //   150: aload_0
    //   151: invokevirtual 97	android/database/sqlite/SQLiteDatabase:close	()V
    //   154: aload_2
    //   155: athrow
    //   156: astore_2
    //   157: goto -21 -> 136
    //   160: astore_2
    //   161: goto -25 -> 136
    //   164: astore_2
    //   165: aconst_null
    //   166: astore_1
    //   167: goto -69 -> 98
    //   170: astore_3
    //   171: aload_2
    //   172: astore_1
    //   173: aload_3
    //   174: astore_2
    //   175: goto -77 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   5	146	0	localObject1	Object
    //   1	172	1	localObject2	Object
    //   3	73	2	localCursor	Cursor
    //   95	12	2	localThrowable1	java.lang.Throwable
    //   133	22	2	localObject3	Object
    //   156	1	2	localObject4	Object
    //   160	1	2	localObject5	Object
    //   164	8	2	localThrowable2	java.lang.Throwable
    //   174	1	2	localObject6	Object
    //   8	113	3	str	String
    //   170	4	3	localThrowable3	java.lang.Throwable
    //   15	3	4	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   9	17	95	java/lang/Throwable
    //   9	17	133	finally
    //   22	30	156	finally
    //   32	41	156	finally
    //   43	68	156	finally
    //   101	110	160	finally
    //   22	30	164	java/lang/Throwable
    //   32	41	170	java/lang/Throwable
    //   43	68	170	java/lang/Throwable
  }
  
  public abstract com.tencent.mobileqq.app.SQLiteOpenHelper build(String paramString);
  
  protected void checkTableColumnChange(String paramString, SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  protected void cleanOverDueCorruptDatabase() {}
  
  public void close()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    this.closed = true;
    this.dbHelper.close();
  }
  
  protected abstract void createDatabase(SQLiteDatabase paramSQLiteDatabase);
  
  public EntityManager createEntityManager()
  {
    if (this.closed) {
      throw new IllegalStateException("The EntityManagerFactory has been already closed");
    }
    OGEntityManager localOGEntityManager = new OGEntityManager(this.dbHelper, this.mName);
    this.closed = false;
    return localOGEntityManager;
  }
  
  protected void doAfterUpgradeDatabase(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  protected abstract String getPackageName();
  
  protected boolean isNeedEncrypt()
  {
    return true;
  }
  
  public boolean isOpen()
  {
    return !this.closed;
  }
  
  protected abstract void upgradeDatabase(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2);
  
  public boolean verifyAuthentication()
  {
    if (this.name.matches("^[0-9]*$"))
    {
      EntityManager localEntityManager = createEntityManager();
      Ability localAbility = (Ability)localEntityManager.find(Ability.class, "flags=?", new String[] { String.valueOf(-1) });
      if (localAbility == null)
      {
        localAbility = new Ability();
        localAbility.flags = -1;
        localAbility.uin = this.name;
        localEntityManager.persistOrReplace(localAbility);
        return true;
      }
      if ((localAbility.uin == null) || (!localAbility.uin.equals(this.name)))
      {
        this.mInnerDbHelper.dropAllTable();
        localAbility = new Ability();
        localAbility.flags = -1;
        localAbility.uin = this.name;
        localEntityManager.persistOrReplace(localAbility);
        return false;
      }
    }
    return true;
  }
  
  class Factory
    implements SQLiteDatabase.CursorFactory
  {
    private Factory() {}
    
    public Cursor newCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
    {
      return new EntityManagerFactory.Factory.1(this, paramSQLiteDatabase, paramSQLiteCursorDriver, paramString, paramSQLiteQuery);
    }
  }
  
  public class SQLiteOpenHelperImpl
    extends android.database.sqlite.SQLiteOpenHelper
  {
    private String databaseName;
    private SQLiteDatabase dbR;
    private SQLiteDatabase dbW;
    private SQLiteDatabase mInnerDb;
    
    public SQLiteOpenHelperImpl(String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
    {
      super(paramString, new EntityManagerFactory.Factory(EntityManagerFactory.this, null), paramInt);
      this.databaseName = paramString;
    }
    
    @TargetApi(11)
    public SQLiteOpenHelperImpl(String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
    {
      super(paramString, new EntityManagerFactory.Factory(EntityManagerFactory.this, null), paramInt, paramDatabaseErrorHandler);
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
              try
              {
                paramSQLiteDatabase.execSQL(TableBuilder.dropSQLStatement(str));
              }
              catch (SQLiteException localSQLiteException)
              {
                QLog.e(EntityManagerFactory.this.TAG, 1, "[DB] dropAllTable " + str, localSQLiteException);
                com.tencent.mobileqq.app.SQLiteOpenHelper.throwDebugException(localSQLiteException);
              }
            }
          }
        }
      }
      onCreate(paramSQLiteDatabase);
    }
    
    /* Error */
    private String[] getAllTableName(SQLiteDatabase paramSQLiteDatabase)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: aload_1
      //   3: ldc 111
      //   5: aconst_null
      //   6: invokevirtual 115	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      //   9: astore 4
      //   11: aload 4
      //   13: ifnull +180 -> 193
      //   16: aload 4
      //   18: astore 5
      //   20: aload 4
      //   22: invokeinterface 121 1 0
      //   27: ifeq +166 -> 193
      //   30: aload 4
      //   32: astore 5
      //   34: aload 4
      //   36: invokeinterface 125 1 0
      //   41: anewarray 56	java/lang/String
      //   44: astore_1
      //   45: aload 4
      //   47: astore 5
      //   49: aload_1
      //   50: iload_2
      //   51: aload 4
      //   53: iconst_0
      //   54: invokeinterface 129 2 0
      //   59: invokestatic 134	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
      //   62: aastore
      //   63: aload 4
      //   65: astore 5
      //   67: aload 4
      //   69: invokeinterface 137 1 0
      //   74: istore_3
      //   75: iload_3
      //   76: ifne +110 -> 186
      //   79: aload_1
      //   80: astore 5
      //   82: aload 4
      //   84: ifnull +13 -> 97
      //   87: aload 4
      //   89: invokeinterface 140 1 0
      //   94: aload_1
      //   95: astore 5
      //   97: aload 5
      //   99: areturn
      //   100: astore 6
      //   102: aconst_null
      //   103: astore 4
      //   105: aconst_null
      //   106: astore_1
      //   107: aload 4
      //   109: astore 5
      //   111: aload_0
      //   112: getfield 19	com/tencent/mobileqq/persistence/EntityManagerFactory$SQLiteOpenHelperImpl:this$0	Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
      //   115: getfield 77	com/tencent/mobileqq/persistence/EntityManagerFactory:TAG	Ljava/lang/String;
      //   118: iconst_1
      //   119: ldc 141
      //   121: aload 6
      //   123: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   126: aload 4
      //   128: astore 5
      //   130: aload 6
      //   132: invokestatic 104	com/tencent/mobileqq/app/SQLiteOpenHelper:throwDebugException	(Ljava/lang/Exception;)V
      //   135: aload_1
      //   136: astore 5
      //   138: aload 4
      //   140: ifnull -43 -> 97
      //   143: aload 4
      //   145: invokeinterface 140 1 0
      //   150: aload_1
      //   151: areturn
      //   152: astore_1
      //   153: aconst_null
      //   154: astore 5
      //   156: aload 5
      //   158: ifnull +10 -> 168
      //   161: aload 5
      //   163: invokeinterface 140 1 0
      //   168: aload_1
      //   169: athrow
      //   170: astore_1
      //   171: goto -15 -> 156
      //   174: astore 6
      //   176: aconst_null
      //   177: astore_1
      //   178: goto -71 -> 107
      //   181: astore 6
      //   183: goto -76 -> 107
      //   186: iload_2
      //   187: iconst_1
      //   188: iadd
      //   189: istore_2
      //   190: goto -145 -> 45
      //   193: aconst_null
      //   194: astore_1
      //   195: goto -116 -> 79
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	198	0	this	SQLiteOpenHelperImpl
      //   0	198	1	paramSQLiteDatabase	SQLiteDatabase
      //   1	189	2	i	int
      //   74	2	3	bool	boolean
      //   9	135	4	localCursor	Cursor
      //   18	144	5	localObject	Object
      //   100	31	6	localException1	Exception
      //   174	1	6	localException2	Exception
      //   181	1	6	localException3	Exception
      // Exception table:
      //   from	to	target	type
      //   2	11	100	java/lang/Exception
      //   2	11	152	finally
      //   20	30	170	finally
      //   34	45	170	finally
      //   49	63	170	finally
      //   67	75	170	finally
      //   111	126	170	finally
      //   130	135	170	finally
      //   20	30	174	java/lang/Exception
      //   34	45	174	java/lang/Exception
      //   49	63	181	java/lang/Exception
      //   67	75	181	java/lang/Exception
    }
    
    public void close()
    {
      QLog.e(EntityManagerFactory.this.TAG, 1, "SQLiteOpenHelperImpl close");
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
      catch (Exception localException)
      {
        QLog.e(EntityManagerFactory.this.TAG, 1, "close", localException);
      }
    }
    
    public void dropAllTable()
    {
      dropAllTable(this.mInnerDb);
    }
    
    public SQLiteDatabase getReadableDatabase()
    {
      try
      {
        this.dbR = super.getReadableDatabase();
        SQLiteDatabase localSQLiteDatabase = this.dbR;
        return localSQLiteDatabase;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e(EntityManagerFactory.this.TAG, 1, "getReadableDatabase", localException);
          com.tencent.mobileqq.app.SQLiteOpenHelper.throwDebugException(localException);
        }
      }
      finally {}
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
          QLog.e(EntityManagerFactory.this.TAG, 1, "getWritableDatabase", localException);
          com.tencent.mobileqq.app.SQLiteOpenHelper.throwDebugException(localException);
        }
      }
      finally {}
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      if (QLog.isColorLevel()) {
        QLog.i(EntityManagerFactory.this.TAG, 2, "[DB]" + this.databaseName + " onCreate");
      }
      EntityManagerFactory.this.createDatabase(paramSQLiteDatabase);
    }
    
    public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
    
    public void onOpen(SQLiteDatabase paramSQLiteDatabase)
    {
      super.onOpen(paramSQLiteDatabase);
      if (QLog.isColorLevel()) {
        QLog.i(EntityManagerFactory.this.TAG, 2, "[DB]" + this.databaseName + " onOpen");
      }
      this.mInnerDb = paramSQLiteDatabase;
      try
      {
        localObject1 = SQLiteDatabase.class.getDeclaredField("mConfigurationLocked");
        ((Field)localObject1).setAccessible(true);
        localObject1 = ((Field)localObject1).get(paramSQLiteDatabase);
        localObject2 = localObject1.getClass().getDeclaredField("maxSqlCacheSize");
        ((Field)localObject2).setAccessible(true);
        ((Field)localObject2).set(localObject1, Integer.valueOf(150));
        localObject2 = SQLiteDatabase.class.getDeclaredField("mConnectionPoolLocked");
        ((Field)localObject2).setAccessible(true);
        localObject2 = ((Field)localObject2).get(paramSQLiteDatabase);
        Method[] arrayOfMethod = localObject2.getClass().getDeclaredMethods();
        int j = arrayOfMethod.length;
        i = 0;
        if (i >= j) {
          break label524;
        }
        paramSQLiteDatabase = arrayOfMethod[i];
        if (!TextUtils.equals(paramSQLiteDatabase.getName(), "reconfigure")) {
          break label253;
        }
      }
      catch (NoSuchFieldException paramSQLiteDatabase)
      {
        for (;;)
        {
          Object localObject1;
          Object localObject2;
          int i;
          paramSQLiteDatabase.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.w(EntityManagerFactory.this.TAG, 2, "[DB]" + this.databaseName + "  onOpen", paramSQLiteDatabase);
          }
        }
      }
      catch (IllegalArgumentException paramSQLiteDatabase)
      {
        for (;;)
        {
          paramSQLiteDatabase.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.w(EntityManagerFactory.this.TAG, 2, "[DB]" + this.databaseName + "  onOpen", paramSQLiteDatabase);
          }
        }
      }
      catch (IllegalAccessException paramSQLiteDatabase)
      {
        for (;;)
        {
          paramSQLiteDatabase.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.w(EntityManagerFactory.this.TAG, 2, "[DB]" + this.databaseName + "  onOpen", paramSQLiteDatabase);
          }
        }
      }
      catch (InvocationTargetException paramSQLiteDatabase)
      {
        for (;;)
        {
          paramSQLiteDatabase.printStackTrace();
          if (QLog.isColorLevel())
          {
            QLog.w(EntityManagerFactory.this.TAG, 2, "[DB]" + this.databaseName + "  onOpen", paramSQLiteDatabase);
            continue;
            paramSQLiteDatabase = null;
          }
        }
      }
      if (paramSQLiteDatabase != null)
      {
        paramSQLiteDatabase.setAccessible(true);
        paramSQLiteDatabase.invoke(localObject2, new Object[] { localObject1 });
        if (QLog.isColorLevel()) {
          QLog.i(EntityManagerFactory.this.TAG, 2, "[DB]" + this.databaseName + " LRU MAX SIZE = " + 150);
        }
      }
      for (;;)
      {
        EntityManagerFactory.this.cleanOverDueCorruptDatabase();
        return;
        label253:
        i += 1;
        break;
        if (QLog.isColorLevel()) {
          QLog.w(EntityManagerFactory.this.TAG, 2, "[DB]" + this.databaseName + " not find reconfigure()");
        }
      }
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.i(EntityManagerFactory.this.TAG, 2, "[DB]" + this.databaseName + " onUpgrade oldVersion: " + paramInt1 + " newVersion: " + paramInt2);
      }
      EntityManagerFactory.this.upgradeDatabase(paramSQLiteDatabase, paramInt1, paramInt2);
      EntityManagerFactory.this.checkTableColumnChange(EntityManagerFactory.this.getPackageName(), paramSQLiteDatabase, paramInt1, paramInt2);
      EntityManagerFactory.this.doAfterUpgradeDatabase(paramSQLiteDatabase, paramInt1, paramInt2);
      if (QLog.isColorLevel()) {
        QLog.i(EntityManagerFactory.this.TAG, 2, "[DB] onUpgrade end");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.EntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */