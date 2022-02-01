package com.tencent.qapmsdk.common.sqlitedb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/sqlitedb/SqliteHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "dbName", "", "factory", "Landroid/database/sqlite/SQLiteDatabase$CursorFactory;", "version", "", "(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V", "onCreate", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "oldVersion", "newVersion", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public class SqliteHelper
  extends SQLiteOpenHelper
{
  public static final Companion Companion = new Companion(null);
  @NotNull
  private static final HashMap<String, String> tables = new HashMap();
  
  public SqliteHelper(@NotNull Context paramContext, @NotNull String paramString, @Nullable SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
  }
  
  public void onCreate(@NotNull SQLiteDatabase paramSQLiteDatabase)
  {
    Intrinsics.checkParameterIsNotNull(paramSQLiteDatabase, "db");
    Iterator localIterator = ((Map)tables).entrySet().iterator();
    while (localIterator.hasNext()) {
      paramSQLiteDatabase.execSQL((String)((Map.Entry)localIterator.next()).getValue());
    }
  }
  
  public void onUpgrade(@NotNull SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramSQLiteDatabase, "db");
    Iterator localIterator = ((Map)tables).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramSQLiteDatabase.execSQL("Drop table if exists " + (String)localEntry.getKey());
    }
    onCreate(paramSQLiteDatabase);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/sqlitedb/SqliteHelper$Companion;", "", "()V", "tables", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getTables", "()Ljava/util/HashMap;", "registerTable", "", "tableName", "createSql", "common_release"}, k=1, mv={1, 1, 15})
  public static final class Companion
  {
    @NotNull
    public final HashMap<String, String> getTables()
    {
      return SqliteHelper.access$getTables$cp();
    }
    
    public final void registerTable(@NotNull String paramString1, @NotNull String paramString2)
    {
      Intrinsics.checkParameterIsNotNull(paramString1, "tableName");
      Intrinsics.checkParameterIsNotNull(paramString2, "createSql");
      if (((CharSequence)paramString1).length() > 0)
      {
        i = 1;
        if (i != 0) {
          if (((CharSequence)paramString2).length() <= 0) {
            break label72;
          }
        }
      }
      label72:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          ((Map)((Companion)this).getTables()).put(paramString1, paramString2);
        }
        return;
        i = 0;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.sqlitedb.SqliteHelper
 * JD-Core Version:    0.7.0.1
 */