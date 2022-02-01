import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.weiyun.transmission.db.JobDbManager;
import com.tencent.weiyun.transmission.db.JobDbWrapper;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;
import java.util.List;

public class awqo
  implements Handler.Callback
{
  private static final String[] PROJ_ADD = { "_id", "cloud_sha", "local_path" };
  private static final String[] PROJ_RESTORE = { "_id", "uid", "cmd_type", "file_name", "p_dir_uid", "p_dir_key", "file_id", "cloud_sha", "file_size", "file_type", "file_version", "group_root_dir_key", "state", "error_code", "error_msg", "total_size", "cur_size", "local_path", "local_dir" };
  private final awqo.a a;
  private final ReleaseLooperHandler mHandler;
  
  public awqo(awqo.a parama, ReleaseLooperHandler paramReleaseLooperHandler)
  {
    this.a = parama;
    this.mHandler = paramReleaseLooperHandler;
    this.mHandler.addCallback(this);
  }
  
  private awqb a(Cursor paramCursor)
  {
    Object localObject = awpy.a(paramCursor.getInt(2), paramCursor.getString(6), paramCursor.getString(3), paramCursor.getString(7), paramCursor.getLong(8), paramCursor.getInt(9), paramCursor.getString(4), paramCursor.getString(5), null);
    ((awpy)localObject).groupRootDirKey = paramCursor.getString(11);
    awqb.a locala = new awqb.a();
    locala.state = paramCursor.getInt(12);
    locala.errorCode = paramCursor.getInt(13);
    locala.errorMsg = paramCursor.getString(14);
    locala.totalSize = paramCursor.getLong(15);
    locala.currSize = paramCursor.getLong(16);
    locala.filePath = paramCursor.getString(17);
    locala.fileId = ((awpy)localObject).fileId;
    locala.fileVersion = paramCursor.getString(10);
    localObject = awqb.a(paramCursor.getString(1), (awpy)localObject, paramCursor.getString(18), locala);
    ((awqb)localObject).setDbId(paramCursor.getLong(0));
    return localObject;
  }
  
  private void a(ContentValues paramContentValues, awqb.a parama, boolean paramBoolean)
  {
    boolean bool = false;
    if ((paramContentValues == null) || (paramContentValues.size() <= 0)) {
      return;
    }
    long l = paramContentValues.getAsLong("_id").longValue();
    JobDbWrapper localJobDbWrapper = JobDbManager.getInstance().openJobDb(true);
    if (localJobDbWrapper == null)
    {
      i = 0;
      paramContentValues = this.a;
      if (i > 0) {
        bool = true;
      }
      paramContentValues.a(l, bool, parama, paramBoolean);
      return;
    }
    if (l >= 0L) {}
    for (int i = localJobDbWrapper.update("download", paramContentValues, "_id=?", new String[] { Long.toString(l) });; i = 0)
    {
      JobDbManager.getInstance().closeJobDb(localJobDbWrapper);
      break;
    }
  }
  
  /* Error */
  private void c(int paramInt, awqb paramawqb)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_2
    //   6: invokevirtual 194	awqb:b	()Lawpy;
    //   9: astore 12
    //   11: aload_2
    //   12: invokevirtual 197	awqb:a	()Lawqb$a;
    //   15: astore 13
    //   17: invokestatic 161	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   20: iconst_1
    //   21: invokevirtual 165	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   24: astore 11
    //   26: aload 11
    //   28: ifnull -24 -> 4
    //   31: aload_2
    //   32: invokevirtual 200	awqb:uid	()Ljava/lang/String;
    //   35: astore 8
    //   37: aload 12
    //   39: getfield 125	awpy:fileId	Ljava/lang/String;
    //   42: astore 10
    //   44: aload_2
    //   45: invokevirtual 203	awqb:Hm	()Ljava/lang/String;
    //   48: astore 14
    //   50: new 205	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   57: ldc 29
    //   59: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc 212
    //   64: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 39
    //   69: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 212
    //   74: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc 59
    //   79: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 214
    //   84: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: astore 15
    //   89: aconst_null
    //   90: astore 9
    //   92: aload 11
    //   94: ldc 170
    //   96: getstatic 27	awqo:PROJ_ADD	[Ljava/lang/String;
    //   99: aload 15
    //   101: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: iconst_3
    //   105: anewarray 19	java/lang/String
    //   108: dup
    //   109: iconst_0
    //   110: aload 8
    //   112: aastore
    //   113: dup
    //   114: iconst_1
    //   115: aload 10
    //   117: aastore
    //   118: dup
    //   119: iconst_2
    //   120: aload 14
    //   122: aastore
    //   123: aconst_null
    //   124: aconst_null
    //   125: ldc 218
    //   127: invokevirtual 222	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   130: astore 8
    //   132: aload 8
    //   134: ifnull +550 -> 684
    //   137: aload 8
    //   139: invokeinterface 226 1 0
    //   144: ifeq +540 -> 684
    //   147: aload 8
    //   149: iconst_0
    //   150: invokeinterface 83 2 0
    //   155: istore_3
    //   156: iload_3
    //   157: i2l
    //   158: lstore 4
    //   160: aload 8
    //   162: iconst_1
    //   163: invokeinterface 87 2 0
    //   168: astore 9
    //   170: aload 8
    //   172: iconst_2
    //   173: invokeinterface 87 2 0
    //   178: astore 10
    //   180: aload 8
    //   182: invokestatic 232	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   185: aload 10
    //   187: astore 8
    //   189: aload 12
    //   191: getfield 235	awpy:sha	Ljava/lang/String;
    //   194: astore 10
    //   196: new 141	android/content/ContentValues
    //   199: dup
    //   200: invokespecial 236	android/content/ContentValues:<init>	()V
    //   203: astore 14
    //   205: aload 14
    //   207: ldc 29
    //   209: aload_2
    //   210: invokevirtual 200	awqb:uid	()Ljava/lang/String;
    //   213: invokevirtual 240	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: aload 14
    //   218: ldc 31
    //   220: aload 12
    //   222: getfield 243	awpy:cmdType	I
    //   225: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   228: invokevirtual 252	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   231: aload 14
    //   233: ldc 33
    //   235: aload 12
    //   237: getfield 255	awpy:fileName	Ljava/lang/String;
    //   240: invokevirtual 240	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload 14
    //   245: ldc 35
    //   247: aload 12
    //   249: getfield 258	awpy:cSa	Ljava/lang/String;
    //   252: invokevirtual 240	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: aload 14
    //   257: ldc 37
    //   259: aload 12
    //   261: getfield 261	awpy:pDirKey	Ljava/lang/String;
    //   264: invokevirtual 240	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: aload 14
    //   269: ldc 39
    //   271: aload 12
    //   273: getfield 125	awpy:fileId	Ljava/lang/String;
    //   276: invokevirtual 240	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: aload 14
    //   281: ldc 23
    //   283: aload 10
    //   285: invokevirtual 240	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: aload 14
    //   290: ldc 41
    //   292: aload 12
    //   294: getfield 264	awpy:fileSize	J
    //   297: invokestatic 267	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   300: invokevirtual 270	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   303: aload 14
    //   305: ldc 43
    //   307: aload 12
    //   309: getfield 273	awpy:type	I
    //   312: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   315: invokevirtual 252	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   318: aload 14
    //   320: ldc 59
    //   322: aload_2
    //   323: invokevirtual 203	awqb:Hm	()Ljava/lang/String;
    //   326: invokevirtual 240	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   329: aload 14
    //   331: ldc_w 275
    //   334: invokestatic 280	java/lang/System:currentTimeMillis	()J
    //   337: invokestatic 267	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   340: invokevirtual 270	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   343: aload 14
    //   345: ldc_w 282
    //   348: aload 12
    //   350: getfield 285	awpy:thumbUrl	Ljava/lang/String;
    //   353: invokevirtual 240	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: aload 14
    //   358: ldc 47
    //   360: aload 12
    //   362: getfield 100	awpy:groupRootDirKey	Ljava/lang/String;
    //   365: invokevirtual 240	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   368: aload 14
    //   370: ldc_w 287
    //   373: iconst_1
    //   374: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   377: invokevirtual 252	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   380: aload 13
    //   382: getfield 122	awqb$a:filePath	Ljava/lang/String;
    //   385: invokestatic 293	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   388: ifne +15 -> 403
    //   391: aload 14
    //   393: ldc 25
    //   395: aload 13
    //   397: getfield 122	awqb$a:filePath	Ljava/lang/String;
    //   400: invokevirtual 240	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   403: lload 4
    //   405: lconst_0
    //   406: lcmp
    //   407: iflt +140 -> 547
    //   410: aload 11
    //   412: ldc 170
    //   414: aload 14
    //   416: ldc 172
    //   418: iconst_1
    //   419: anewarray 19	java/lang/String
    //   422: dup
    //   423: iconst_0
    //   424: lload 4
    //   426: invokestatic 176	java/lang/Long:toString	(J)Ljava/lang/String;
    //   429: aastore
    //   430: invokevirtual 182	com/tencent/weiyun/transmission/db/JobDbWrapper:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   433: pop
    //   434: ldc_w 295
    //   437: aload 10
    //   439: invokevirtual 299	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   442: ifne +17 -> 459
    //   445: lload 4
    //   447: lstore 6
    //   449: aload 9
    //   451: aload 10
    //   453: invokestatic 302	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   456: ifne +12 -> 468
    //   459: ldc_w 304
    //   462: astore 8
    //   464: lload 4
    //   466: lstore 6
    //   468: invokestatic 161	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   471: aload 11
    //   473: invokevirtual 186	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   476: lload 6
    //   478: lconst_0
    //   479: lcmp
    //   480: iflt -476 -> 4
    //   483: aload_2
    //   484: lload 6
    //   486: invokevirtual 138	awqb:setDbId	(J)V
    //   489: aload_0
    //   490: getfield 68	awqo:a	Lawqo$a;
    //   493: iload_1
    //   494: aload_2
    //   495: aload 8
    //   497: invokeinterface 307 4 0
    //   502: return
    //   503: astore 8
    //   505: aconst_null
    //   506: astore 9
    //   508: aconst_null
    //   509: astore 8
    //   511: ldc2_w 308
    //   514: lstore 4
    //   516: aload 9
    //   518: invokestatic 232	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   521: aconst_null
    //   522: astore 10
    //   524: aload 8
    //   526: astore 9
    //   528: aload 10
    //   530: astore 8
    //   532: goto -343 -> 189
    //   535: astore_2
    //   536: aload 9
    //   538: astore 8
    //   540: aload 8
    //   542: invokestatic 232	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   545: aload_2
    //   546: athrow
    //   547: aload 14
    //   549: ldc 49
    //   551: aload 13
    //   553: getfield 106	awqb$a:state	I
    //   556: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   559: invokevirtual 252	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   562: aload 14
    //   564: ldc 51
    //   566: aload 13
    //   568: getfield 109	awqb$a:errorCode	I
    //   571: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   574: invokevirtual 252	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   577: aload 14
    //   579: ldc 53
    //   581: aload 13
    //   583: getfield 112	awqb$a:errorMsg	Ljava/lang/String;
    //   586: invokevirtual 240	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   589: aload 14
    //   591: ldc 55
    //   593: aload 13
    //   595: getfield 116	awqb$a:totalSize	J
    //   598: invokestatic 267	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   601: invokevirtual 270	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   604: aload 14
    //   606: ldc 57
    //   608: aload 13
    //   610: getfield 119	awqb$a:currSize	J
    //   613: invokestatic 267	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   616: invokevirtual 270	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   619: aload 11
    //   621: ldc 170
    //   623: aconst_null
    //   624: aload 14
    //   626: invokevirtual 313	com/tencent/weiyun/transmission/db/JobDbWrapper:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   629: lstore 6
    //   631: goto -163 -> 468
    //   634: astore_2
    //   635: goto -95 -> 540
    //   638: astore 9
    //   640: aload 8
    //   642: astore 9
    //   644: aconst_null
    //   645: astore 8
    //   647: ldc2_w 308
    //   650: lstore 4
    //   652: goto -136 -> 516
    //   655: astore 9
    //   657: aload 8
    //   659: astore 9
    //   661: aconst_null
    //   662: astore 8
    //   664: goto -148 -> 516
    //   667: astore 10
    //   669: aload 8
    //   671: astore 10
    //   673: aload 9
    //   675: astore 8
    //   677: aload 10
    //   679: astore 9
    //   681: goto -165 -> 516
    //   684: aconst_null
    //   685: astore 9
    //   687: aconst_null
    //   688: astore 10
    //   690: ldc2_w 308
    //   693: lstore 4
    //   695: goto -515 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	698	0	this	awqo
    //   0	698	1	paramInt	int
    //   0	698	2	paramawqb	awqb
    //   155	2	3	i	int
    //   158	536	4	l1	long
    //   447	183	6	l2	long
    //   35	461	8	localObject1	Object
    //   503	1	8	localThrowable1	java.lang.Throwable
    //   509	167	8	localObject2	Object
    //   90	447	9	localObject3	Object
    //   638	1	9	localThrowable2	java.lang.Throwable
    //   642	1	9	localObject4	Object
    //   655	1	9	localThrowable3	java.lang.Throwable
    //   659	27	9	localObject5	Object
    //   42	487	10	str	String
    //   667	1	10	localThrowable4	java.lang.Throwable
    //   671	18	10	localObject6	Object
    //   24	596	11	localJobDbWrapper	JobDbWrapper
    //   9	352	12	localawpy	awpy
    //   15	594	13	locala	awqb.a
    //   48	577	14	localObject7	Object
    //   87	13	15	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   92	132	503	java/lang/Throwable
    //   92	132	535	finally
    //   137	156	634	finally
    //   160	170	634	finally
    //   170	180	634	finally
    //   137	156	638	java/lang/Throwable
    //   160	170	655	java/lang/Throwable
    //   170	180	667	java/lang/Throwable
  }
  
  /* Error */
  private void deleteData(long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 7
    //   12: iconst_0
    //   13: istore 5
    //   15: invokestatic 161	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   18: iconst_1
    //   19: invokevirtual 165	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   22: astore 10
    //   24: aload 10
    //   26: ifnonnull +38 -> 64
    //   29: iconst_0
    //   30: istore 4
    //   32: aload 7
    //   34: astore 6
    //   36: aload_0
    //   37: getfield 68	awqo:a	Lawqo$a;
    //   40: astore 7
    //   42: iload 5
    //   44: istore_3
    //   45: iload 4
    //   47: ifle +5 -> 52
    //   50: iconst_1
    //   51: istore_3
    //   52: aload 7
    //   54: lload_1
    //   55: iload_3
    //   56: aload 6
    //   58: invokeinterface 318 5 0
    //   63: return
    //   64: lload_1
    //   65: lconst_0
    //   66: lcmp
    //   67: iflt +199 -> 266
    //   70: aload 10
    //   72: ldc 170
    //   74: getstatic 61	awqo:PROJ_RESTORE	[Ljava/lang/String;
    //   77: ldc 172
    //   79: iconst_1
    //   80: anewarray 19	java/lang/String
    //   83: dup
    //   84: iconst_0
    //   85: lload_1
    //   86: invokestatic 176	java/lang/Long:toString	(J)Ljava/lang/String;
    //   89: aastore
    //   90: aconst_null
    //   91: aconst_null
    //   92: aconst_null
    //   93: invokevirtual 222	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   96: astore 7
    //   98: aload 7
    //   100: ifnull +160 -> 260
    //   103: aload 7
    //   105: invokeinterface 226 1 0
    //   110: ifeq +150 -> 260
    //   113: aload_0
    //   114: aload 7
    //   116: invokespecial 320	awqo:a	(Landroid/database/Cursor;)Lawqb;
    //   119: astore 6
    //   121: aload 7
    //   123: invokestatic 232	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   126: iload_3
    //   127: ifeq +94 -> 221
    //   130: new 141	android/content/ContentValues
    //   133: dup
    //   134: invokespecial 236	android/content/ContentValues:<init>	()V
    //   137: astore 7
    //   139: aload 7
    //   141: ldc_w 287
    //   144: iconst_0
    //   145: invokestatic 249	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   148: invokevirtual 252	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   151: aload 10
    //   153: ldc 170
    //   155: aload 7
    //   157: ldc 172
    //   159: iconst_1
    //   160: anewarray 19	java/lang/String
    //   163: dup
    //   164: iconst_0
    //   165: lload_1
    //   166: invokestatic 176	java/lang/Long:toString	(J)Ljava/lang/String;
    //   169: aastore
    //   170: invokevirtual 182	com/tencent/weiyun/transmission/db/JobDbWrapper:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   173: istore 4
    //   175: invokestatic 161	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   178: aload 10
    //   180: invokevirtual 186	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   183: goto -147 -> 36
    //   186: astore 6
    //   188: aconst_null
    //   189: astore 6
    //   191: aload 6
    //   193: invokestatic 232	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   196: aload 8
    //   198: astore 6
    //   200: goto -74 -> 126
    //   203: astore 8
    //   205: aload 6
    //   207: astore 7
    //   209: aload 8
    //   211: astore 6
    //   213: aload 7
    //   215: invokestatic 232	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   218: aload 6
    //   220: athrow
    //   221: aload 10
    //   223: ldc 170
    //   225: ldc 172
    //   227: iconst_1
    //   228: anewarray 19	java/lang/String
    //   231: dup
    //   232: iconst_0
    //   233: lload_1
    //   234: invokestatic 176	java/lang/Long:toString	(J)Ljava/lang/String;
    //   237: aastore
    //   238: invokevirtual 324	com/tencent/weiyun/transmission/db/JobDbWrapper:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   241: istore 4
    //   243: goto -68 -> 175
    //   246: astore 6
    //   248: goto -35 -> 213
    //   251: astore 6
    //   253: aload 7
    //   255: astore 6
    //   257: goto -66 -> 191
    //   260: aconst_null
    //   261: astore 6
    //   263: goto -142 -> 121
    //   266: iconst_0
    //   267: istore 4
    //   269: aload 9
    //   271: astore 6
    //   273: goto -98 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	this	awqo
    //   0	276	1	paramLong	long
    //   0	276	3	paramBoolean	boolean
    //   30	238	4	i	int
    //   13	30	5	bool	boolean
    //   7	113	6	localObject1	Object
    //   186	1	6	localThrowable1	java.lang.Throwable
    //   189	30	6	localObject2	Object
    //   246	1	6	localObject3	Object
    //   251	1	6	localThrowable2	java.lang.Throwable
    //   255	17	6	localObject4	Object
    //   10	244	7	localObject5	Object
    //   1	196	8	localObject6	Object
    //   203	7	8	localObject7	Object
    //   4	266	9	localObject8	Object
    //   22	200	10	localJobDbWrapper	JobDbWrapper
    // Exception table:
    //   from	to	target	type
    //   70	98	186	java/lang/Throwable
    //   70	98	203	finally
    //   103	121	246	finally
    //   103	121	251	java/lang/Throwable
  }
  
  /* Error */
  private void restoreData(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: invokestatic 161	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   7: iconst_0
    //   8: invokevirtual 165	com/tencent/weiyun/transmission/db/JobDbManager:openJobDb	(Z)Lcom/tencent/weiyun/transmission/db/JobDbWrapper;
    //   11: astore 5
    //   13: aload 5
    //   15: ifnonnull +15 -> 30
    //   18: aload_0
    //   19: getfield 68	awqo:a	Lawqo$a;
    //   22: aload_1
    //   23: aload_2
    //   24: invokeinterface 330 3 0
    //   29: return
    //   30: iconst_4
    //   31: invokestatic 332	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   34: astore_2
    //   35: new 205	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   42: ldc 29
    //   44: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 212
    //   49: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc_w 287
    //   55: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc_w 334
    //   61: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc 49
    //   66: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc_w 336
    //   72: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: astore 4
    //   77: aload 5
    //   79: ldc 170
    //   81: getstatic 61	awqo:PROJ_RESTORE	[Ljava/lang/String;
    //   84: aload 4
    //   86: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: iconst_2
    //   90: anewarray 19	java/lang/String
    //   93: dup
    //   94: iconst_0
    //   95: aload_1
    //   96: aastore
    //   97: dup
    //   98: iconst_1
    //   99: aload_2
    //   100: aastore
    //   101: aconst_null
    //   102: aconst_null
    //   103: ldc_w 338
    //   106: invokevirtual 222	com/tencent/weiyun/transmission/db/JobDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   109: astore_2
    //   110: aload_2
    //   111: ifnull +67 -> 178
    //   114: new 340	java/util/ArrayList
    //   117: dup
    //   118: aload_2
    //   119: invokeinterface 343 1 0
    //   124: invokespecial 346	java/util/ArrayList:<init>	(I)V
    //   127: astore 4
    //   129: aload 4
    //   131: astore_3
    //   132: aload_2
    //   133: invokeinterface 226 1 0
    //   138: ifeq +42 -> 180
    //   141: aload 4
    //   143: aload_0
    //   144: aload_2
    //   145: invokespecial 320	awqo:a	(Landroid/database/Cursor;)Lawqb;
    //   148: invokeinterface 351 2 0
    //   153: pop
    //   154: goto -25 -> 129
    //   157: astore_3
    //   158: aload_2
    //   159: astore_3
    //   160: aload 4
    //   162: astore_2
    //   163: aload_3
    //   164: invokestatic 232	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   167: invokestatic 161	com/tencent/weiyun/transmission/db/JobDbManager:getInstance	()Lcom/tencent/weiyun/transmission/db/JobDbManager;
    //   170: aload 5
    //   172: invokevirtual 186	com/tencent/weiyun/transmission/db/JobDbManager:closeJobDb	(Lcom/tencent/weiyun/transmission/db/JobDbWrapper;)V
    //   175: goto -157 -> 18
    //   178: aconst_null
    //   179: astore_3
    //   180: aload_2
    //   181: invokestatic 232	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   184: aload_3
    //   185: astore_2
    //   186: goto -19 -> 167
    //   189: astore_1
    //   190: aconst_null
    //   191: astore_2
    //   192: aload_2
    //   193: invokestatic 232	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   196: aload_1
    //   197: athrow
    //   198: astore_1
    //   199: goto -7 -> 192
    //   202: astore_2
    //   203: aconst_null
    //   204: astore_2
    //   205: goto -42 -> 163
    //   208: astore_3
    //   209: aconst_null
    //   210: astore 4
    //   212: aload_2
    //   213: astore_3
    //   214: aload 4
    //   216: astore_2
    //   217: goto -54 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	awqo
    //   0	220	1	paramString	String
    //   3	190	2	localObject1	Object
    //   202	1	2	localThrowable1	java.lang.Throwable
    //   204	13	2	localObject2	Object
    //   1	131	3	localObject3	Object
    //   157	1	3	localThrowable2	java.lang.Throwable
    //   159	26	3	localObject4	Object
    //   208	1	3	localThrowable3	java.lang.Throwable
    //   213	1	3	localObject5	Object
    //   75	140	4	localObject6	Object
    //   11	160	5	localJobDbWrapper	JobDbWrapper
    // Exception table:
    //   from	to	target	type
    //   132	154	157	java/lang/Throwable
    //   77	110	189	finally
    //   114	129	198	finally
    //   132	154	198	finally
    //   77	110	202	java/lang/Throwable
    //   114	129	208	java/lang/Throwable
  }
  
  public void b(int paramInt, awqb paramawqb)
  {
    if (paramawqb == null) {
      return;
    }
    this.mHandler.sendMessage(Message.obtain(null, 1, paramInt, 0, paramawqb));
  }
  
  public void b(awqb paramawqb, boolean paramBoolean)
  {
    if (paramawqb == null) {
      return;
    }
    awqb.a locala = paramawqb.b();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("_id", Long.valueOf(paramawqb.dbId()));
    localContentValues.put("state", Integer.valueOf(locala.state));
    localContentValues.put("error_code", Integer.valueOf(locala.errorCode));
    localContentValues.put("error_msg", locala.errorMsg);
    localContentValues.put("total_size", Long.valueOf(locala.totalSize));
    localContentValues.put("cur_size", Long.valueOf(locala.currSize));
    if (!TextUtils.isEmpty(locala.filePath)) {
      localContentValues.put("local_path", locala.filePath);
    }
    if (!TextUtils.isEmpty(paramawqb.fileVersion())) {
      localContentValues.put("file_version", paramawqb.fileVersion());
    }
    paramawqb = this.mHandler;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramawqb.sendMessage(Message.obtain(null, 2, i, 0, new Object[] { localContentValues, locala }));
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      c(paramMessage.arg1, (awqb)paramMessage.obj);
      return true;
    case 2: 
      ContentValues localContentValues = (ContentValues)((Object[])(Object[])paramMessage.obj)[0];
      awqb.a locala = (awqb.a)((Object[])(Object[])paramMessage.obj)[1];
      if (paramMessage.arg1 == 1) {
        bool1 = true;
      }
      a(localContentValues, locala, bool1);
      return true;
    case 3: 
      long l = ((Long)paramMessage.obj).longValue();
      bool1 = bool2;
      if (paramMessage.arg1 == 1) {
        bool1 = true;
      }
      deleteData(l, bool1);
      return true;
    }
    restoreData((String)paramMessage.obj);
    return true;
  }
  
  public void removeInfo(long paramLong, boolean paramBoolean)
  {
    if (paramLong < 0L) {
      return;
    }
    ReleaseLooperHandler localReleaseLooperHandler = this.mHandler;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localReleaseLooperHandler.sendMessage(Message.obtain(null, 3, i, 0, Long.valueOf(paramLong)));
      return;
    }
  }
  
  public void restoreInfo(String paramString)
  {
    this.mHandler.sendMessage(Message.obtain(null, 4, paramString));
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, awqb paramawqb, String paramString);
    
    public abstract void a(long paramLong, boolean paramBoolean1, awqb.a parama, boolean paramBoolean2);
    
    public abstract void a(long paramLong, boolean paramBoolean, awqb paramawqb);
    
    public abstract void onInfoRestored(String paramString, List<awqb> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awqo
 * JD-Core Version:    0.7.0.1
 */