package com.tencent.qapmsdk.base.dbpersist.table;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.qapmsdk.base.dbpersist.BaseTable;
import com.tencent.qapmsdk.base.dbpersist.DBDataStatus;
import com.tencent.qapmsdk.base.meta.DropFrameResultMeta;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/dbpersist/table/DropFrameTable;", "Lcom/tencent/qapmsdk/base/dbpersist/BaseTable;", "pId", "", "processName", "", "version", "uin", "scene", "dropFrameResult", "Lcom/tencent/qapmsdk/base/meta/DropFrameResultMeta;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/qapmsdk/base/meta/DropFrameResultMeta;)V", "lastTime", "", "curTime", "(ILjava/lang/String;Ljava/lang/String;JJ)V", "()V", "buildDropFrameJson", "Lorg/json/JSONObject;", "map", "Ljava/util/HashMap;", "buildSingleScene", "insert", "dataBase", "Landroid/database/sqlite/SQLiteDatabase;", "block", "Lkotlin/Function0;", "search", "", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class DropFrameTable
  extends BaseTable
{
  private static final String COLUMN_DROP_COUNT = "drop_count";
  private static final String COLUMN_DROP_DURATION = "drop_duration";
  private static final String COLUMN_ID = "_id";
  private static final String COLUMN_OCCUR_TIME = "occur_time";
  private static final String COLUMN_PROCESS_NAME = "process_name";
  private static final String COLUMN_PRODUCT_ID = "p_id";
  private static final String COLUMN_RANGE_0 = "range_0";
  private static final String COLUMN_RANGE_1 = "range_1";
  private static final String COLUMN_RANGE_2_4 = "range_2_4";
  private static final String COLUMN_RANGE_4_8 = "range_4_8";
  private static final String COLUMN_RANGE_8_15 = "range_8_15";
  private static final String COLUMN_RANGE_OVER_15 = "range_over_15";
  private static final String COLUMN_SCENE = "scene";
  private static final String COLUMN_STATE = "state";
  private static final String COLUMN_STATUS = "status";
  private static final String COLUMN_UIN = "uin";
  private static final String COLUMN_VERSION = "version";
  private static final String CREATE_DROP_FRAME = "CREATE TABLE drop_frame (_id INTEGER PRIMARY KEY AUTOINCREMENT,process_name TEXT,p_id INT,version TEXT,uin TEXT,scene TEXT,state TINYINT,drop_duration FLOAT,drop_count INT,range_0 INT,range_1 INT,range_2_4 INT,range_4_8 INT,range_8_15 INT,range_over_15 INT,status TINYINT,occur_time BIGINT);";
  public static final Companion Companion = new Companion(null);
  private static final String TABLE_DROP_FRAME = "drop_frame";
  private static final String TAG = "QAPM_table_DropFrameTable";
  private long curTime;
  private DropFrameResultMeta dropFrameResult = new DropFrameResultMeta(0, 0.0F, null, null, 15, null);
  private long lastTime;
  private int pId;
  private String processName = "";
  private String scene = "";
  private String uin = "";
  private String version = "";
  
  static
  {
    new DropFrameTable();
  }
  
  public DropFrameTable()
  {
    super("drop_frame", "CREATE TABLE drop_frame (_id INTEGER PRIMARY KEY AUTOINCREMENT,process_name TEXT,p_id INT,version TEXT,uin TEXT,scene TEXT,state TINYINT,drop_duration FLOAT,drop_count INT,range_0 INT,range_1 INT,range_2_4 INT,range_4_8 INT,range_8_15 INT,range_over_15 INT,status TINYINT,occur_time BIGINT);");
  }
  
  public DropFrameTable(int paramInt, @NotNull String paramString1, @NotNull String paramString2, long paramLong1, long paramLong2)
  {
    this();
    this.pId = paramInt;
    this.processName = paramString1;
    this.version = paramString2;
    this.lastTime = paramLong1;
    this.curTime = paramLong2;
  }
  
  public DropFrameTable(int paramInt, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull DropFrameResultMeta paramDropFrameResultMeta)
  {
    this();
    this.pId = paramInt;
    this.processName = paramString1;
    this.version = paramString2;
    this.uin = paramString3;
    this.scene = paramString4;
    this.dropFrameResult = paramDropFrameResultMeta;
  }
  
  private final JSONObject buildSingleScene(DropFrameResultMeta paramDropFrameResultMeta)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    if (paramDropFrameResultMeta != null)
    {
      localJSONObject2.put("dropDuration", paramDropFrameResultMeta.duration / 1.0E+009F);
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      while (i <= 5)
      {
        localJSONArray.put(i, paramDropFrameResultMeta.dropIntervals[i]);
        i += 1;
      }
      localJSONObject2.put("dropTimes", localJSONArray);
      localJSONObject1.put(String.valueOf(paramDropFrameResultMeta.state), localJSONObject2);
    }
    return localJSONObject1;
  }
  
  @NotNull
  public final JSONObject buildDropFrameJson(@NotNull HashMap<String, DropFrameResultMeta> paramHashMap)
    throws JSONException
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "map");
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localJSONObject.put(str, buildSingleScene((DropFrameResultMeta)paramHashMap.get(str)));
    }
    return localJSONObject;
  }
  
  public int insert(@NotNull SQLiteDatabase paramSQLiteDatabase, @NotNull Function0<Integer> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramSQLiteDatabase, "dataBase");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    paramFunction0 = new ContentValues();
    paramFunction0.put("process_name", this.processName);
    paramFunction0.put("p_id", Integer.valueOf(this.pId));
    paramFunction0.put("version", this.version);
    paramFunction0.put("uin", this.uin);
    paramFunction0.put("scene", this.scene);
    paramFunction0.put("state", Integer.valueOf(this.dropFrameResult.state));
    paramFunction0.put("drop_duration", Float.valueOf(this.dropFrameResult.duration));
    paramFunction0.put("drop_count", Integer.valueOf(this.dropFrameResult.dropCount));
    paramFunction0.put("range_0", Long.valueOf(this.dropFrameResult.dropIntervals[0]));
    paramFunction0.put("range_1", Long.valueOf(this.dropFrameResult.dropIntervals[1]));
    paramFunction0.put("range_2_4", Long.valueOf(this.dropFrameResult.dropIntervals[2]));
    paramFunction0.put("range_4_8", Long.valueOf(this.dropFrameResult.dropIntervals[3]));
    paramFunction0.put("range_8_15", Long.valueOf(this.dropFrameResult.dropIntervals[4]));
    paramFunction0.put("range_over_15", Long.valueOf(this.dropFrameResult.dropIntervals[5]));
    paramFunction0.put("status", Integer.valueOf(DBDataStatus.TO_SEND.getValue()));
    paramFunction0.put("occur_time", Long.valueOf(System.currentTimeMillis()));
    return (int)paramSQLiteDatabase.insert("drop_frame", "name", paramFunction0);
  }
  
  /* Error */
  @org.jetbrains.annotations.Nullable
  public Object search(@NotNull SQLiteDatabase paramSQLiteDatabase, @NotNull Function0<? extends Object> paramFunction0)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 230
    //   3: invokestatic 143	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc 231
    //   9: invokestatic 143	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: new 199	java/util/HashMap
    //   15: dup
    //   16: invokespecial 294	java/util/HashMap:<init>	()V
    //   19: astore 16
    //   21: aload_2
    //   22: invokeinterface 299 1 0
    //   27: astore 14
    //   29: aload 14
    //   31: iconst_3
    //   32: invokestatic 241	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   35: invokestatic 303	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   38: ifeq +541 -> 579
    //   41: ldc_w 305
    //   44: astore 14
    //   46: aload_2
    //   47: invokeinterface 299 1 0
    //   52: astore 15
    //   54: aload 15
    //   56: iconst_3
    //   57: invokestatic 241	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: invokestatic 303	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   63: ifeq +556 -> 619
    //   66: iconst_3
    //   67: anewarray 190	java/lang/String
    //   70: astore 15
    //   72: aload 15
    //   74: iconst_0
    //   75: aload_0
    //   76: getfield 122	com/tencent/qapmsdk/base/dbpersist/table/DropFrameTable:processName	Ljava/lang/String;
    //   79: aastore
    //   80: aload 15
    //   82: iconst_1
    //   83: aload_0
    //   84: getfield 145	com/tencent/qapmsdk/base/dbpersist/table/DropFrameTable:pId	I
    //   87: invokestatic 194	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   90: aastore
    //   91: aload 15
    //   93: iconst_2
    //   94: aload_0
    //   95: getfield 124	com/tencent/qapmsdk/base/dbpersist/table/DropFrameTable:version	Ljava/lang/String;
    //   98: aastore
    //   99: aload_1
    //   100: ldc 101
    //   102: aconst_null
    //   103: aload 14
    //   105: aload 15
    //   107: aconst_null
    //   108: aconst_null
    //   109: aconst_null
    //   110: invokevirtual 309	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   113: astore 14
    //   115: aload 14
    //   117: ifnull +459 -> 576
    //   120: aload 14
    //   122: checkcast 311	java/io/Closeable
    //   125: astore 15
    //   127: aconst_null
    //   128: checkcast 293	java/lang/Throwable
    //   131: astore 14
    //   133: aload 15
    //   135: checkcast 313	android/database/Cursor
    //   138: astore 17
    //   140: aload 17
    //   142: invokeinterface 316 1 0
    //   147: pop
    //   148: aload 17
    //   150: invokeinterface 319 1 0
    //   155: ifne +693 -> 848
    //   158: aload 17
    //   160: aload 17
    //   162: ldc 84
    //   164: invokeinterface 323 2 0
    //   169: invokeinterface 326 2 0
    //   174: astore 18
    //   176: aload 17
    //   178: aload 17
    //   180: ldc 87
    //   182: invokeinterface 323 2 0
    //   187: invokeinterface 330 2 0
    //   192: istore 4
    //   194: aload 17
    //   196: aload 17
    //   198: ldc 52
    //   200: invokeinterface 323 2 0
    //   205: invokeinterface 334 2 0
    //   210: fstore_3
    //   211: aload 17
    //   213: aload 17
    //   215: ldc 49
    //   217: invokeinterface 323 2 0
    //   222: invokeinterface 338 2 0
    //   227: istore 5
    //   229: aload 17
    //   231: aload 17
    //   233: ldc 67
    //   235: invokeinterface 323 2 0
    //   240: invokeinterface 338 2 0
    //   245: istore 6
    //   247: aload 17
    //   249: aload 17
    //   251: ldc 70
    //   253: invokeinterface 323 2 0
    //   258: invokeinterface 338 2 0
    //   263: istore 7
    //   265: aload 17
    //   267: aload 17
    //   269: ldc 73
    //   271: invokeinterface 323 2 0
    //   276: invokeinterface 338 2 0
    //   281: istore 8
    //   283: aload 17
    //   285: aload 17
    //   287: ldc 76
    //   289: invokeinterface 323 2 0
    //   294: invokeinterface 338 2 0
    //   299: istore 9
    //   301: aload 17
    //   303: aload 17
    //   305: ldc 79
    //   307: invokeinterface 323 2 0
    //   312: invokeinterface 338 2 0
    //   317: istore 10
    //   319: aload 17
    //   321: aload 17
    //   323: ldc 82
    //   325: invokeinterface 323 2 0
    //   330: invokeinterface 338 2 0
    //   335: istore 11
    //   337: aload 16
    //   339: aload 18
    //   341: invokevirtual 342	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   344: ifeq +412 -> 756
    //   347: aload 16
    //   349: aload 18
    //   351: invokevirtual 223	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   354: checkcast 130	com/tencent/qapmsdk/base/meta/DropFrameResultMeta
    //   357: astore 19
    //   359: aload 19
    //   361: ifnull +179 -> 540
    //   364: aload 19
    //   366: iload 5
    //   368: aload 19
    //   370: getfield 255	com/tencent/qapmsdk/base/meta/DropFrameResultMeta:dropCount	I
    //   373: iadd
    //   374: putfield 255	com/tencent/qapmsdk/base/meta/DropFrameResultMeta:dropCount	I
    //   377: aload 19
    //   379: aload 19
    //   381: getfield 166	com/tencent/qapmsdk/base/meta/DropFrameResultMeta:duration	F
    //   384: fload_3
    //   385: fadd
    //   386: putfield 166	com/tencent/qapmsdk/base/meta/DropFrameResultMeta:duration	F
    //   389: aload 19
    //   391: getfield 178	com/tencent/qapmsdk/base/meta/DropFrameResultMeta:dropIntervals	[J
    //   394: astore 20
    //   396: aload 20
    //   398: iconst_0
    //   399: aload 20
    //   401: iconst_0
    //   402: laload
    //   403: iload 6
    //   405: i2l
    //   406: ladd
    //   407: lastore
    //   408: aload 19
    //   410: getfield 178	com/tencent/qapmsdk/base/meta/DropFrameResultMeta:dropIntervals	[J
    //   413: astore 20
    //   415: aload 20
    //   417: iconst_1
    //   418: laload
    //   419: lstore 12
    //   421: aload 20
    //   423: iconst_1
    //   424: iload 7
    //   426: i2l
    //   427: lload 12
    //   429: ladd
    //   430: lastore
    //   431: aload 19
    //   433: getfield 178	com/tencent/qapmsdk/base/meta/DropFrameResultMeta:dropIntervals	[J
    //   436: astore 20
    //   438: aload 20
    //   440: iconst_2
    //   441: aload 20
    //   443: iconst_2
    //   444: laload
    //   445: iload 8
    //   447: i2l
    //   448: ladd
    //   449: lastore
    //   450: aload 19
    //   452: getfield 178	com/tencent/qapmsdk/base/meta/DropFrameResultMeta:dropIntervals	[J
    //   455: astore 20
    //   457: aload 20
    //   459: iconst_3
    //   460: aload 20
    //   462: iconst_3
    //   463: laload
    //   464: iload 9
    //   466: i2l
    //   467: ladd
    //   468: lastore
    //   469: aload 19
    //   471: getfield 178	com/tencent/qapmsdk/base/meta/DropFrameResultMeta:dropIntervals	[J
    //   474: astore 20
    //   476: aload 20
    //   478: iconst_4
    //   479: aload 20
    //   481: iconst_4
    //   482: laload
    //   483: iload 10
    //   485: i2l
    //   486: ladd
    //   487: lastore
    //   488: aload 19
    //   490: getfield 178	com/tencent/qapmsdk/base/meta/DropFrameResultMeta:dropIntervals	[J
    //   493: astore 20
    //   495: aload 20
    //   497: iconst_5
    //   498: aload 20
    //   500: iconst_5
    //   501: laload
    //   502: iload 11
    //   504: i2l
    //   505: ladd
    //   506: lastore
    //   507: aload 16
    //   509: checkcast 344	java/util/Map
    //   512: astore 20
    //   514: aload 18
    //   516: ldc 84
    //   518: invokestatic 347	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   521: aload 19
    //   523: ldc 154
    //   525: invokestatic 347	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   528: aload 20
    //   530: aload 18
    //   532: aload 19
    //   534: invokeinterface 350 3 0
    //   539: pop
    //   540: aload 17
    //   542: invokeinterface 353 1 0
    //   547: pop
    //   548: goto -400 -> 148
    //   551: astore_1
    //   552: aload_1
    //   553: athrow
    //   554: astore_2
    //   555: aload 15
    //   557: aload_1
    //   558: invokestatic 359	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   561: aload_2
    //   562: athrow
    //   563: astore_1
    //   564: getstatic 365	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   567: ldc 104
    //   569: aload_1
    //   570: checkcast 293	java/lang/Throwable
    //   573: invokevirtual 369	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   576: aload 16
    //   578: areturn
    //   579: aload 14
    //   581: iconst_4
    //   582: invokestatic 241	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   585: invokestatic 303	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   588: ifeq +11 -> 599
    //   591: ldc_w 371
    //   594: astore 14
    //   596: goto -550 -> 46
    //   599: aload 14
    //   601: iconst_5
    //   602: invokestatic 241	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   605: invokestatic 303	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   608: ifeq +281 -> 889
    //   611: ldc_w 373
    //   614: astore 14
    //   616: goto -570 -> 46
    //   619: aload 15
    //   621: iconst_4
    //   622: invokestatic 241	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   625: invokestatic 303	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   628: ifeq +52 -> 680
    //   631: iconst_4
    //   632: anewarray 190	java/lang/String
    //   635: astore 15
    //   637: aload 15
    //   639: iconst_0
    //   640: getstatic 269	com/tencent/qapmsdk/base/dbpersist/DBDataStatus:TO_SEND	Lcom/tencent/qapmsdk/base/dbpersist/DBDataStatus;
    //   643: invokevirtual 273	com/tencent/qapmsdk/base/dbpersist/DBDataStatus:getValue	()I
    //   646: invokestatic 194	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   649: aastore
    //   650: aload 15
    //   652: iconst_1
    //   653: aload_0
    //   654: getfield 122	com/tencent/qapmsdk/base/dbpersist/table/DropFrameTable:processName	Ljava/lang/String;
    //   657: aastore
    //   658: aload 15
    //   660: iconst_2
    //   661: aload_0
    //   662: getfield 145	com/tencent/qapmsdk/base/dbpersist/table/DropFrameTable:pId	I
    //   665: invokestatic 194	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   668: aastore
    //   669: aload 15
    //   671: iconst_3
    //   672: aload_0
    //   673: getfield 124	com/tencent/qapmsdk/base/dbpersist/table/DropFrameTable:version	Ljava/lang/String;
    //   676: aastore
    //   677: goto -578 -> 99
    //   680: aload 15
    //   682: iconst_5
    //   683: invokestatic 241	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   686: invokestatic 303	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   689: ifeq +61 -> 750
    //   692: iconst_5
    //   693: anewarray 190	java/lang/String
    //   696: astore 15
    //   698: aload 15
    //   700: iconst_0
    //   701: aload_0
    //   702: getfield 122	com/tencent/qapmsdk/base/dbpersist/table/DropFrameTable:processName	Ljava/lang/String;
    //   705: aastore
    //   706: aload 15
    //   708: iconst_1
    //   709: aload_0
    //   710: getfield 145	com/tencent/qapmsdk/base/dbpersist/table/DropFrameTable:pId	I
    //   713: invokestatic 194	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   716: aastore
    //   717: aload 15
    //   719: iconst_2
    //   720: aload_0
    //   721: getfield 124	com/tencent/qapmsdk/base/dbpersist/table/DropFrameTable:version	Ljava/lang/String;
    //   724: aastore
    //   725: aload 15
    //   727: iconst_3
    //   728: aload_0
    //   729: getfield 147	com/tencent/qapmsdk/base/dbpersist/table/DropFrameTable:lastTime	J
    //   732: invokestatic 376	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   735: aastore
    //   736: aload 15
    //   738: iconst_4
    //   739: aload_0
    //   740: getfield 149	com/tencent/qapmsdk/base/dbpersist/table/DropFrameTable:curTime	J
    //   743: invokestatic 376	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   746: aastore
    //   747: goto -648 -> 99
    //   750: aconst_null
    //   751: astore 15
    //   753: goto -654 -> 99
    //   756: new 130	com/tencent/qapmsdk/base/meta/DropFrameResultMeta
    //   759: dup
    //   760: iload 5
    //   762: fload_3
    //   763: bipush 6
    //   765: newarray long
    //   767: dup
    //   768: iconst_0
    //   769: iload 6
    //   771: i2l
    //   772: lastore
    //   773: dup
    //   774: iconst_1
    //   775: iload 7
    //   777: i2l
    //   778: lastore
    //   779: dup
    //   780: iconst_2
    //   781: iload 8
    //   783: i2l
    //   784: lastore
    //   785: dup
    //   786: iconst_3
    //   787: iload 9
    //   789: i2l
    //   790: lastore
    //   791: dup
    //   792: iconst_4
    //   793: iload 10
    //   795: i2l
    //   796: lastore
    //   797: dup
    //   798: iconst_5
    //   799: iload 11
    //   801: i2l
    //   802: lastore
    //   803: aconst_null
    //   804: bipush 8
    //   806: aconst_null
    //   807: invokespecial 133	com/tencent/qapmsdk/base/meta/DropFrameResultMeta:<init>	(IF[JLjava/lang/String;ILkotlin/jvm/internal/DefaultConstructorMarker;)V
    //   810: astore 19
    //   812: aload 19
    //   814: iload 4
    //   816: putfield 188	com/tencent/qapmsdk/base/meta/DropFrameResultMeta:state	I
    //   819: aload 16
    //   821: checkcast 344	java/util/Map
    //   824: astore 20
    //   826: aload 18
    //   828: ldc 84
    //   830: invokestatic 347	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   833: aload 20
    //   835: aload 18
    //   837: aload 19
    //   839: invokeinterface 350 3 0
    //   844: pop
    //   845: goto -305 -> 540
    //   848: aload_2
    //   849: invokeinterface 299 1 0
    //   854: iconst_5
    //   855: invokestatic 241	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   858: invokestatic 303	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   861: iconst_1
    //   862: ixor
    //   863: ifeq +12 -> 875
    //   866: aload_1
    //   867: ldc 101
    //   869: aconst_null
    //   870: aconst_null
    //   871: invokevirtual 380	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   874: pop
    //   875: getstatic 385	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   878: astore_1
    //   879: aload 15
    //   881: aload 14
    //   883: invokestatic 359	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   886: aload 16
    //   888: areturn
    //   889: ldc 120
    //   891: astore 14
    //   893: goto -847 -> 46
    //   896: astore_2
    //   897: aload 14
    //   899: astore_1
    //   900: goto -345 -> 555
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	903	0	this	DropFrameTable
    //   0	903	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	903	2	paramFunction0	Function0<? extends Object>
    //   210	553	3	f	float
    //   192	623	4	i	int
    //   227	534	5	j	int
    //   245	525	6	k	int
    //   263	513	7	m	int
    //   281	501	8	n	int
    //   299	489	9	i1	int
    //   317	477	10	i2	int
    //   335	465	11	i3	int
    //   419	9	12	l	long
    //   27	871	14	localObject1	Object
    //   52	828	15	localObject2	Object
    //   19	868	16	localHashMap	HashMap
    //   138	403	17	localCursor	android.database.Cursor
    //   174	662	18	str	String
    //   357	481	19	localDropFrameResultMeta	DropFrameResultMeta
    //   394	440	20	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   133	148	551	java/lang/Throwable
    //   148	359	551	java/lang/Throwable
    //   364	396	551	java/lang/Throwable
    //   408	415	551	java/lang/Throwable
    //   431	438	551	java/lang/Throwable
    //   450	457	551	java/lang/Throwable
    //   469	476	551	java/lang/Throwable
    //   488	495	551	java/lang/Throwable
    //   507	540	551	java/lang/Throwable
    //   540	548	551	java/lang/Throwable
    //   756	845	551	java/lang/Throwable
    //   848	875	551	java/lang/Throwable
    //   875	879	551	java/lang/Throwable
    //   552	554	554	finally
    //   21	41	563	java/lang/Exception
    //   46	99	563	java/lang/Exception
    //   99	115	563	java/lang/Exception
    //   120	133	563	java/lang/Exception
    //   555	563	563	java/lang/Exception
    //   579	591	563	java/lang/Exception
    //   599	611	563	java/lang/Exception
    //   619	677	563	java/lang/Exception
    //   680	747	563	java/lang/Exception
    //   879	886	563	java/lang/Exception
    //   133	148	896	finally
    //   148	359	896	finally
    //   364	396	896	finally
    //   408	415	896	finally
    //   431	438	896	finally
    //   450	457	896	finally
    //   469	476	896	finally
    //   488	495	896	finally
    //   507	540	896	finally
    //   540	548	896	finally
    //   756	845	896	finally
    //   848	875	896	finally
    //   875	879	896	finally
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/dbpersist/table/DropFrameTable$Companion;", "", "()V", "COLUMN_DROP_COUNT", "", "COLUMN_DROP_DURATION", "COLUMN_ID", "COLUMN_OCCUR_TIME", "COLUMN_PROCESS_NAME", "COLUMN_PRODUCT_ID", "COLUMN_RANGE_0", "COLUMN_RANGE_1", "COLUMN_RANGE_2_4", "COLUMN_RANGE_4_8", "COLUMN_RANGE_8_15", "COLUMN_RANGE_OVER_15", "COLUMN_SCENE", "COLUMN_STATE", "COLUMN_STATUS", "COLUMN_UIN", "COLUMN_VERSION", "CREATE_DROP_FRAME", "TABLE_DROP_FRAME", "TAG", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.dbpersist.table.DropFrameTable
 * JD-Core Version:    0.7.0.1
 */