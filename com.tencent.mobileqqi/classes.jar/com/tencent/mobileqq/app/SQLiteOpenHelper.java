package com.tencent.mobileqq.app;

import com.tencent.mobileqq.persistence.TableNameCache;

public class SQLiteOpenHelper
{
  private android.database.sqlite.SQLiteOpenHelper jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper;
  private SQLiteDatabase jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase;
  private TableNameCache jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache = new TableNameCache();
  private SQLiteDatabase b;
  
  public SQLiteOpenHelper(android.database.sqlite.SQLiteOpenHelper paramSQLiteOpenHelper)
  {
    this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper = paramSQLiteOpenHelper;
  }
  
  /* Error */
  public SQLiteDatabase a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 21	com/tencent/mobileqq/app/SQLiteOpenHelper:jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper	Landroid/database/sqlite/SQLiteOpenHelper;
    //   6: invokevirtual 31	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_1
    //   10: aload_0
    //   11: getfield 33	com/tencent/mobileqq/app/SQLiteOpenHelper:jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   14: ifnull +14 -> 28
    //   17: aload_0
    //   18: getfield 33	com/tencent/mobileqq/app/SQLiteOpenHelper:jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   21: getfield 38	com/tencent/mobileqq/app/SQLiteDatabase:a	Landroid/database/sqlite/SQLiteDatabase;
    //   24: aload_1
    //   25: if_acmpeq +19 -> 44
    //   28: aload_0
    //   29: new 35	com/tencent/mobileqq/app/SQLiteDatabase
    //   32: dup
    //   33: aload_1
    //   34: aload_0
    //   35: getfield 19	com/tencent/mobileqq/app/SQLiteOpenHelper:jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache	Lcom/tencent/mobileqq/persistence/TableNameCache;
    //   38: invokespecial 41	com/tencent/mobileqq/app/SQLiteDatabase:<init>	(Landroid/database/sqlite/SQLiteDatabase;Lcom/tencent/mobileqq/persistence/TableNameCache;)V
    //   41: putfield 33	com/tencent/mobileqq/app/SQLiteOpenHelper:jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   44: aload_0
    //   45: getfield 33	com/tencent/mobileqq/app/SQLiteOpenHelper:jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: areturn
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    //   58: astore_1
    //   59: goto -15 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	SQLiteOpenHelper
    //   9	43	1	localObject1	Object
    //   53	4	1	localObject2	Object
    //   58	1	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	28	53	finally
    //   28	44	53	finally
    //   44	49	53	finally
    //   2	28	58	java/lang/Exception
    //   28	44	58	java/lang/Exception
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public SQLiteDatabase b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 21	com/tencent/mobileqq/app/SQLiteOpenHelper:jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper	Landroid/database/sqlite/SQLiteOpenHelper;
    //   6: invokevirtual 47	android/database/sqlite/SQLiteOpenHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore_1
    //   10: aload_0
    //   11: getfield 49	com/tencent/mobileqq/app/SQLiteOpenHelper:b	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   14: ifnull +14 -> 28
    //   17: aload_0
    //   18: getfield 49	com/tencent/mobileqq/app/SQLiteOpenHelper:b	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   21: getfield 38	com/tencent/mobileqq/app/SQLiteDatabase:a	Landroid/database/sqlite/SQLiteDatabase;
    //   24: aload_1
    //   25: if_acmpeq +19 -> 44
    //   28: aload_0
    //   29: new 35	com/tencent/mobileqq/app/SQLiteDatabase
    //   32: dup
    //   33: aload_1
    //   34: aload_0
    //   35: getfield 19	com/tencent/mobileqq/app/SQLiteOpenHelper:jdField_a_of_type_ComTencentMobileqqPersistenceTableNameCache	Lcom/tencent/mobileqq/persistence/TableNameCache;
    //   38: invokespecial 41	com/tencent/mobileqq/app/SQLiteDatabase:<init>	(Landroid/database/sqlite/SQLiteDatabase;Lcom/tencent/mobileqq/persistence/TableNameCache;)V
    //   41: putfield 49	com/tencent/mobileqq/app/SQLiteOpenHelper:b	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   44: aload_0
    //   45: getfield 49	com/tencent/mobileqq/app/SQLiteOpenHelper:b	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: areturn
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    //   58: astore_1
    //   59: goto -15 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	SQLiteOpenHelper
    //   9	43	1	localObject1	Object
    //   53	4	1	localObject2	Object
    //   58	1	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	28	53	finally
    //   28	44	53	finally
    //   44	49	53	finally
    //   2	28	58	java/lang/Exception
    //   28	44	58	java/lang/Exception
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SQLiteOpenHelper
 * JD-Core Version:    0.7.0.1
 */