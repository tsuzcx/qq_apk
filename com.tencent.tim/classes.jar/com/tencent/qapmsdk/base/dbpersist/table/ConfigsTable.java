package com.tencent.qapmsdk.base.dbpersist.table;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.config.PluginCombination.Companion;
import com.tencent.qapmsdk.base.dbpersist.BaseTable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/dbpersist/table/ConfigsTable;", "Lcom/tencent/qapmsdk/base/dbpersist/BaseTable;", "pId", "", "version", "", "(ILjava/lang/String;)V", "()V", "insert", "dataBase", "Landroid/database/sqlite/SQLiteDatabase;", "block", "Lkotlin/Function0;", "search", "", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class ConfigsTable
  extends BaseTable
{
  private static final String COLUMN_EVENT_SAMPLE_RATIO = "event_sample_ratio";
  private static final String COLUMN_ID = "_id";
  private static final String COLUMN_MAX_REPORT_NUM = "max_report_num";
  private static final String COLUMN_PLUGIN = "plugin";
  private static final String COLUMN_PRODUCT_ID = "p_id";
  private static final String COLUMN_STACK_DEPTH = "stack_depth";
  private static final String COLUMN_THRESHOLD = "threshold";
  private static final String COLUMN_VERSION = "version";
  private static final String CREATE_CONFIGS = "CREATE TABLE configs (_id INTEGER PRIMARY KEY AUTOINCREMENT,p_id INT,version TEXT,plugin SMALLINT,threshold FLOAT,max_report_num INT,event_sample_ratio FLOAT,stack_depth INT);";
  public static final Companion Companion = new Companion(null);
  private static final String TABLE_CONFIGS = "configs";
  private static final String TAG = "QAPM_table_ConfigsTable";
  private int pId;
  private String version = "";
  
  static
  {
    new ConfigsTable();
  }
  
  public ConfigsTable()
  {
    super("configs", "CREATE TABLE configs (_id INTEGER PRIMARY KEY AUTOINCREMENT,p_id INT,version TEXT,plugin SMALLINT,threshold FLOAT,max_report_num INT,event_sample_ratio FLOAT,stack_depth INT);");
  }
  
  public ConfigsTable(int paramInt, @NotNull String paramString)
  {
    this();
    this.pId = paramInt;
    this.version = paramString;
  }
  
  public int insert(@NotNull SQLiteDatabase paramSQLiteDatabase, @NotNull Function0<Integer> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramSQLiteDatabase, "dataBase");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    paramSQLiteDatabase.delete("configs", null, null);
    paramSQLiteDatabase.beginTransaction();
    paramFunction0 = new ContentValues();
    PluginCombination.Companion.each((Function1)new ConfigsTable.insert.1(this, paramFunction0, paramSQLiteDatabase));
    paramSQLiteDatabase.setTransactionSuccessful();
    paramSQLiteDatabase.endTransaction();
    return 0;
  }
  
  /* Error */
  @org.jetbrains.annotations.Nullable
  public Object search(@NotNull SQLiteDatabase paramSQLiteDatabase, @NotNull Function0<? extends Object> paramFunction0)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 103
    //   3: invokestatic 90	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc 104
    //   9: invokestatic 90	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_1
    //   13: ldc 63
    //   15: aconst_null
    //   16: ldc 150
    //   18: iconst_2
    //   19: anewarray 152	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: aload_0
    //   25: getfield 92	com/tencent/qapmsdk/base/dbpersist/table/ConfigsTable:pId	I
    //   28: invokestatic 156	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   31: aastore
    //   32: dup
    //   33: iconst_1
    //   34: aload_0
    //   35: getfield 83	com/tencent/qapmsdk/base/dbpersist/table/ConfigsTable:version	Ljava/lang/String;
    //   38: aastore
    //   39: aconst_null
    //   40: aconst_null
    //   41: aconst_null
    //   42: invokevirtual 160	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull +174 -> 221
    //   50: aload_1
    //   51: checkcast 162	java/io/Closeable
    //   54: astore 8
    //   56: aconst_null
    //   57: checkcast 148	java/lang/Throwable
    //   60: astore_1
    //   61: aload 8
    //   63: checkcast 164	android/database/Cursor
    //   66: astore_2
    //   67: aload_2
    //   68: invokeinterface 168 1 0
    //   73: ifle +150 -> 223
    //   76: aload_2
    //   77: invokeinterface 172 1 0
    //   82: pop
    //   83: aload_2
    //   84: invokeinterface 175 1 0
    //   89: ifne +134 -> 223
    //   92: aload_2
    //   93: aload_2
    //   94: ldc 45
    //   96: invokeinterface 179 2 0
    //   101: invokeinterface 183 2 0
    //   106: istore 4
    //   108: aload_2
    //   109: aload_2
    //   110: ldc 54
    //   112: invokeinterface 179 2 0
    //   117: invokeinterface 183 2 0
    //   122: istore 5
    //   124: aload_2
    //   125: aload_2
    //   126: ldc 42
    //   128: invokeinterface 179 2 0
    //   133: invokeinterface 183 2 0
    //   138: istore 6
    //   140: aload_2
    //   141: aload_2
    //   142: ldc 36
    //   144: invokeinterface 179 2 0
    //   149: invokeinterface 187 2 0
    //   154: fstore_3
    //   155: aload_2
    //   156: aload_2
    //   157: ldc 51
    //   159: invokeinterface 179 2 0
    //   164: invokeinterface 183 2 0
    //   169: istore 7
    //   171: getstatic 193	com/tencent/qapmsdk/base/monitorplugin/PluginController:INSTANCE	Lcom/tencent/qapmsdk/base/monitorplugin/PluginController;
    //   174: iload 4
    //   176: iload 5
    //   178: iload 6
    //   180: fload_3
    //   181: iload 7
    //   183: invokevirtual 197	com/tencent/qapmsdk/base/monitorplugin/PluginController:resetPlugin	(IIIFI)V
    //   186: aload_2
    //   187: invokeinterface 200 1 0
    //   192: pop
    //   193: goto -110 -> 83
    //   196: astore_1
    //   197: aload_1
    //   198: athrow
    //   199: astore_2
    //   200: aload 8
    //   202: aload_1
    //   203: invokestatic 206	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   206: aload_2
    //   207: athrow
    //   208: astore_1
    //   209: getstatic 211	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   212: ldc 66
    //   214: aload_1
    //   215: checkcast 148	java/lang/Throwable
    //   218: invokevirtual 215	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   221: aconst_null
    //   222: areturn
    //   223: getstatic 220	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   226: astore_2
    //   227: aload 8
    //   229: aload_1
    //   230: invokestatic 206	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   233: aconst_null
    //   234: areturn
    //   235: astore_2
    //   236: goto -36 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	this	ConfigsTable
    //   0	239	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	239	2	paramFunction0	Function0<? extends Object>
    //   154	27	3	f	float
    //   106	69	4	i	int
    //   122	55	5	j	int
    //   138	41	6	k	int
    //   169	13	7	m	int
    //   54	174	8	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   61	83	196	java/lang/Throwable
    //   83	193	196	java/lang/Throwable
    //   223	227	196	java/lang/Throwable
    //   197	199	199	finally
    //   12	46	208	java/lang/Exception
    //   50	61	208	java/lang/Exception
    //   200	208	208	java/lang/Exception
    //   227	233	208	java/lang/Exception
    //   61	83	235	finally
    //   83	193	235	finally
    //   223	227	235	finally
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/dbpersist/table/ConfigsTable$Companion;", "", "()V", "COLUMN_EVENT_SAMPLE_RATIO", "", "COLUMN_ID", "COLUMN_MAX_REPORT_NUM", "COLUMN_PLUGIN", "COLUMN_PRODUCT_ID", "COLUMN_STACK_DEPTH", "COLUMN_THRESHOLD", "COLUMN_VERSION", "CREATE_CONFIGS", "TABLE_CONFIGS", "TAG", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.dbpersist.table.ConfigsTable
 * JD-Core Version:    0.7.0.1
 */