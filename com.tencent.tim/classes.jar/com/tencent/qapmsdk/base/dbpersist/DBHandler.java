package com.tencent.qapmsdk.base.dbpersist;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.tencent.qapmsdk.base.dbpersist.table.ConfigsTable;
import com.tencent.qapmsdk.base.dbpersist.table.DropFrameTable;
import com.tencent.qapmsdk.base.dbpersist.table.ResultObjectsTable;
import com.tencent.qapmsdk.base.dbpersist.table.StatisticsTable;
import com.tencent.qapmsdk.base.dbpersist.table.UploadErrorsTable;
import com.tencent.qapmsdk.common.logger.Logger;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/dbpersist/DBHandler;", "", "()V", "database", "Landroid/database/sqlite/SQLiteDatabase;", "dbHelper", "Lcom/tencent/qapmsdk/base/dbpersist/DBHelper;", "getDbHelper", "()Lcom/tencent/qapmsdk/base/dbpersist/DBHelper;", "setDbHelper", "(Lcom/tencent/qapmsdk/base/dbpersist/DBHelper;)V", "close", "", "delete", "", "table", "", "whereClause", "whereArgs", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I", "deleteAllSentOrOverTime", "overTime", "", "insert", "Lcom/tencent/qapmsdk/base/dbpersist/BaseTable;", "block", "Lkotlin/Function0;", "open", "search", "sql", "sqlSearch", "updateStatus", "id", "", "status", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class DBHandler
{
  public static final Companion Companion = new Companion(null);
  private static final int DB_ERROR = -1;
  private static final int DB_NO_OPEN = -2;
  private static final ArrayList<Object> TABLES = CollectionsKt.arrayListOf(new Object[] { ConfigsTable.Companion, DropFrameTable.Companion, ResultObjectsTable.Companion, UploadErrorsTable.Companion, StatisticsTable.Companion });
  private static final String TAG = "QAPM_db_persist_DBHandler";
  private static volatile DBHandler handler;
  private SQLiteDatabase database;
  @Nullable
  private DBHelper dbHelper;
  
  private final int sql(Function0<Integer> paramFunction0)
  {
    if (access$getDatabase$p(this) != null)
    {
      SQLiteDatabase localSQLiteDatabase = access$getDatabase$p(this);
      if ((localSQLiteDatabase == null) || (localSQLiteDatabase.isOpen())) {}
    }
    else
    {
      return -2;
    }
    try
    {
      int i = ((Number)paramFunction0.invoke()).intValue();
      return i;
    }
    catch (Exception paramFunction0)
    {
      Logger.INSTANCE.exception("QAPM_db_persist_DBHandler", (Throwable)paramFunction0);
    }
    return -1;
  }
  
  private final Object sqlSearch(Function0<? extends Object> paramFunction0)
  {
    if (access$getDatabase$p(this) != null)
    {
      SQLiteDatabase localSQLiteDatabase = access$getDatabase$p(this);
      if ((localSQLiteDatabase == null) || (localSQLiteDatabase.isOpen())) {}
    }
    else
    {
      return null;
    }
    try
    {
      paramFunction0 = paramFunction0.invoke();
      return paramFunction0;
    }
    catch (Exception paramFunction0)
    {
      Logger.INSTANCE.exception("QAPM_db_persist_DBHandler", (Throwable)paramFunction0);
    }
    return null;
  }
  
  public final void close()
  {
    SQLiteDatabase localSQLiteDatabase = this.database;
    if ((localSQLiteDatabase != null) && (localSQLiteDatabase.isOpen()))
    {
      localSQLiteDatabase.close();
      handler = (DBHandler)null;
    }
  }
  
  public final int delete(@NotNull String paramString1, @Nullable String paramString2, @Nullable String[] paramArrayOfString)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "table");
    SQLiteDatabase localSQLiteDatabase;
    if (access$getDatabase$p(this) != null)
    {
      localSQLiteDatabase = access$getDatabase$p(this);
      if ((localSQLiteDatabase == null) || (localSQLiteDatabase.isOpen())) {}
    }
    else
    {
      return -2;
    }
    try
    {
      localSQLiteDatabase = this.database;
      if (localSQLiteDatabase != null)
      {
        int i = localSQLiteDatabase.delete(paramString1, paramString2, paramArrayOfString);
        return i;
      }
      return 0;
    }
    catch (Exception paramString1)
    {
      Logger.INSTANCE.exception("QAPM_db_persist_DBHandler", (Throwable)paramString1);
    }
    return -1;
  }
  
  public final int deleteAllSentOrOverTime(@NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "table");
    if (paramBoolean) {
      return delete(paramString, "status=? OR occur_time<?", new String[] { String.valueOf(DBDataStatus.SENT.getValue()), String.valueOf(System.currentTimeMillis() - 259200000) });
    }
    return delete(paramString, "status=?", new String[] { String.valueOf(DBDataStatus.SENT.getValue()) });
  }
  
  @Nullable
  public final DBHelper getDbHelper()
  {
    return this.dbHelper;
  }
  
  public final int insert(@NotNull BaseTable paramBaseTable, @NotNull Function0<Integer> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseTable, "table");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    SQLiteDatabase localSQLiteDatabase;
    if (access$getDatabase$p(this) != null)
    {
      localSQLiteDatabase = access$getDatabase$p(this);
      if ((localSQLiteDatabase == null) || (localSQLiteDatabase.isOpen())) {
        break label41;
      }
    }
    for (;;)
    {
      return -2;
      try
      {
        label41:
        localSQLiteDatabase = this.database;
        if (localSQLiteDatabase != null)
        {
          int i = paramBaseTable.insert(localSQLiteDatabase, paramFunction0);
          return i;
        }
      }
      catch (Exception paramBaseTable)
      {
        Logger.INSTANCE.exception("QAPM_db_persist_DBHandler", (Throwable)paramBaseTable);
      }
    }
    return -1;
  }
  
  public final void open()
  {
    Object localObject;
    if (this.database != null)
    {
      localObject = this.database;
      if ((localObject == null) || (((SQLiteDatabase)localObject).isOpen())) {
        break label42;
      }
    }
    try
    {
      localObject = this.dbHelper;
      if (localObject != null) {}
      for (localObject = ((DBHelper)localObject).getWritableDatabase();; localObject = null)
      {
        this.database = ((SQLiteDatabase)localObject);
        label42:
        return;
      }
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      Logger.INSTANCE.exception("QAPM_db_persist_DBHandler", (Throwable)localSQLiteException);
    }
  }
  
  @Nullable
  public final Object search(@NotNull BaseTable paramBaseTable, @NotNull Function0<? extends Object> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseTable, "table");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    SQLiteDatabase localSQLiteDatabase;
    if (access$getDatabase$p(this) != null)
    {
      localSQLiteDatabase = access$getDatabase$p(this);
      if ((localSQLiteDatabase == null) || (localSQLiteDatabase.isOpen())) {}
    }
    else
    {
      return null;
    }
    try
    {
      localSQLiteDatabase = this.database;
      if (localSQLiteDatabase != null)
      {
        paramBaseTable = paramBaseTable.search(localSQLiteDatabase, paramFunction0);
        return paramBaseTable;
      }
      return null;
    }
    catch (Exception paramBaseTable)
    {
      Logger.INSTANCE.exception("QAPM_db_persist_DBHandler", (Throwable)paramBaseTable);
    }
    return null;
  }
  
  public final void setDbHelper(@Nullable DBHelper paramDBHelper)
  {
    this.dbHelper = paramDBHelper;
  }
  
  public final int updateStatus(@NotNull String paramString, long paramLong, int paramInt)
  {
    int i = -1;
    Intrinsics.checkParameterIsNotNull(paramString, "table");
    Object localObject;
    if (access$getDatabase$p(this) != null)
    {
      localObject = access$getDatabase$p(this);
      if ((localObject == null) || (((SQLiteDatabase)localObject).isOpen())) {}
    }
    else
    {
      paramInt = -2;
    }
    for (;;)
    {
      i = paramInt;
      label43:
      return i;
      try
      {
        if ((paramInt != DBDataStatus.TO_SEND.getValue()) && (paramInt != DBDataStatus.SENT.getValue())) {
          break label43;
        }
        localObject = new ContentValues();
        ((ContentValues)localObject).put("status", Integer.valueOf(paramInt));
        SQLiteDatabase localSQLiteDatabase = this.database;
        if (localSQLiteDatabase != null) {}
        for (paramInt = localSQLiteDatabase.update(paramString, (ContentValues)localObject, "_id=" + paramLong, null);; paramInt = 0) {
          break;
        }
      }
      catch (Exception paramString)
      {
        Logger.INSTANCE.exception("QAPM_db_persist_DBHandler", (Throwable)paramString);
        paramInt = -1;
      }
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/dbpersist/DBHandler$Companion;", "", "()V", "DB_ERROR", "", "DB_NO_OPEN", "TABLES", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "TAG", "", "handler", "Lcom/tencent/qapmsdk/base/dbpersist/DBHandler;", "getInstance", "dbHelper", "Lcom/tencent/qapmsdk/base/dbpersist/DBHelper;", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class Companion
  {
    /* Error */
    @NotNull
    public final DBHandler getInstance(@NotNull DBHelper paramDBHelper)
    {
      // Byte code:
      //   0: aload_1
      //   1: ldc 42
      //   3: invokestatic 48	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
      //   6: invokestatic 52	com/tencent/qapmsdk/base/dbpersist/DBHandler:access$getHandler$cp	()Lcom/tencent/qapmsdk/base/dbpersist/DBHandler;
      //   9: astore_2
      //   10: aload_2
      //   11: ifnull +5 -> 16
      //   14: aload_2
      //   15: areturn
      //   16: aload_0
      //   17: monitorenter
      //   18: invokestatic 52	com/tencent/qapmsdk/base/dbpersist/DBHandler:access$getHandler$cp	()Lcom/tencent/qapmsdk/base/dbpersist/DBHandler;
      //   21: astore_2
      //   22: aload_2
      //   23: ifnull +7 -> 30
      //   26: aload_0
      //   27: monitorexit
      //   28: aload_2
      //   29: areturn
      //   30: new 6	com/tencent/qapmsdk/base/dbpersist/DBHandler
      //   33: dup
      //   34: aconst_null
      //   35: invokespecial 54	com/tencent/qapmsdk/base/dbpersist/DBHandler:<init>	(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
      //   38: astore_2
      //   39: aload_2
      //   40: invokestatic 58	com/tencent/qapmsdk/base/dbpersist/DBHandler:access$setHandler$cp	(Lcom/tencent/qapmsdk/base/dbpersist/DBHandler;)V
      //   43: aload_2
      //   44: aload_1
      //   45: invokevirtual 62	com/tencent/qapmsdk/base/dbpersist/DBHandler:setDbHelper	(Lcom/tencent/qapmsdk/base/dbpersist/DBHelper;)V
      //   48: aload_2
      //   49: invokevirtual 65	com/tencent/qapmsdk/base/dbpersist/DBHandler:open	()V
      //   52: goto -26 -> 26
      //   55: astore_1
      //   56: aload_0
      //   57: monitorexit
      //   58: aload_1
      //   59: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	60	0	this	Companion
      //   0	60	1	paramDBHelper	DBHelper
      //   9	40	2	localDBHandler	DBHandler
      // Exception table:
      //   from	to	target	type
      //   18	22	55	finally
      //   30	52	55	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.dbpersist.DBHandler
 * JD-Core Version:    0.7.0.1
 */