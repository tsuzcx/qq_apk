import android.os.HandlerThread;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.proxy.FTSDBManager.1;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.fts.FTSTroopSync;
import com.tencent.mobileqq.data.fts.FTSTroopTime;
import com.tencent.mobileqq.fts.FTSDatabase;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.Observable;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class acxu
  extends Observable
  implements Manager
{
  public static volatile boolean ENABLE = true;
  private HandlerThread E;
  public acyc a;
  private FTSDatabase jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase;
  private FTSDatatbase jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase;
  private int cAq = -1;
  private ConcurrentHashMap<Integer, acxy> eB = new ConcurrentHashMap();
  public volatile boolean isDestroyed;
  private volatile boolean isInit;
  private QQAppInterface mApp;
  private volatile int retryCount;
  
  public acxu(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.E = new HandlerThread("QQ_FTS_Sync", 3);
    this.E.start();
    this.jdField_a_of_type_Acyc = new acyc(this.E.getLooper(), this.mApp, this);
    this.eB.put(Integer.valueOf(1), new acxz(this.mApp, this.jdField_a_of_type_Acyc));
    this.eB.put(Integer.valueOf(2), new acyd(this.mApp, this.jdField_a_of_type_Acyc));
    this.eB.put(Integer.valueOf(4), new acyb(this.mApp, this.jdField_a_of_type_Acyc));
    cOM();
    if (QLog.isColorLevel()) {
      QLog.i("Q.fts.manager", 2, "FTSDBManager structure...");
    }
  }
  
  public static void f(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    aqoe.bk(paramQQAppInterface, paramString);
    SQLiteDatabase localSQLiteDatabase = new QQEntityManagerFactory(paramString).build(paramString).getWritableDatabase();
    localSQLiteDatabase.execSQL("DROP TABLE IF EXISTS msg_upgrade_log;");
    localSQLiteDatabase.execSQL("DROP TABLE IF EXISTS msg_sync_log;");
    localSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + FTSTroopSync.class.getSimpleName() + ";");
    localSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + FTSTroopTime.class.getSimpleName() + ";");
    if (!paramBoolean) {
      paramQQAppInterface.a().cON();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.fts.manager", 2, "FTS clear...");
      }
      return;
      paramQQAppInterface = new File(paramQQAppInterface.getApplication().getFilesDir().getAbsolutePath().replace("files", "databases") + File.separator + paramString + "-IndexQQMsg.db");
      if ((paramQQAppInterface.exists()) && (paramQQAppInterface.isFile())) {
        paramQQAppInterface.delete();
      }
    }
  }
  
  /* Error */
  private void init()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 42	acxu:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: iconst_0
    //   14: invokestatic 234	aqoe:an	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   17: aload_0
    //   18: getfield 114	acxu:isInit	Z
    //   21: ifne +239 -> 260
    //   24: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +139 -> 166
    //   30: ldc 236
    //   32: aconst_null
    //   33: invokestatic 242	android/database/sqlite/SQLiteDatabase:openOrCreateDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   36: astore_3
    //   37: aload 6
    //   39: astore 4
    //   41: aload_3
    //   42: ldc 244
    //   44: aconst_null
    //   45: invokevirtual 248	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   48: astore 5
    //   50: ldc 250
    //   52: astore 6
    //   54: aload 5
    //   56: astore 4
    //   58: aload 5
    //   60: invokeinterface 255 1 0
    //   65: ifeq +38 -> 103
    //   68: aload 5
    //   70: astore 4
    //   72: new 153	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   79: aload 6
    //   81: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload 5
    //   86: iconst_0
    //   87: invokeinterface 259 2 0
    //   92: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: astore 6
    //   100: goto -46 -> 54
    //   103: aload 5
    //   105: astore 4
    //   107: ldc 97
    //   109: iconst_2
    //   110: new 153	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   117: ldc_w 261
    //   120: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokestatic 266	aqgz:getDeviceOSVersion	()Ljava/lang/String;
    //   126: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc_w 268
    //   132: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload 6
    //   137: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 103	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   146: aload 5
    //   148: ifnull +10 -> 158
    //   151: aload 5
    //   153: invokeinterface 271 1 0
    //   158: aload_3
    //   159: ifnull +7 -> 166
    //   162: aload_3
    //   163: invokevirtual 272	android/database/sqlite/SQLiteDatabase:close	()V
    //   166: getstatic 277	android/os/Build$VERSION:SDK_INT	I
    //   169: bipush 18
    //   171: if_icmpge +573 -> 744
    //   174: aload_0
    //   175: getfield 42	acxu:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   178: invokestatic 281	aqoe:ao	(Lcom/tencent/mobileqq/app/QQAppInterface;)I
    //   181: istore_2
    //   182: aload_0
    //   183: getfield 42	acxu:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   186: iload_2
    //   187: iconst_1
    //   188: iadd
    //   189: invokestatic 285	aqoe:T	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   192: ldc 97
    //   194: iconst_1
    //   195: new 153	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   202: ldc_w 287
    //   205: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: iload_2
    //   209: invokevirtual 290	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   212: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 103	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: iload_2
    //   219: iconst_5
    //   220: if_icmplt +95 -> 315
    //   223: iload_2
    //   224: sipush 200
    //   227: if_icmpge +88 -> 315
    //   230: ldc 97
    //   232: iconst_1
    //   233: new 153	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   240: ldc_w 292
    //   243: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: iload_2
    //   247: invokevirtual 290	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   250: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 295	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   256: iconst_0
    //   257: putstatic 28	acxu:ENABLE	Z
    //   260: return
    //   261: astore_3
    //   262: aconst_null
    //   263: astore_3
    //   264: aload 4
    //   266: ifnull +10 -> 276
    //   269: aload 4
    //   271: invokeinterface 271 1 0
    //   276: aload_3
    //   277: ifnull -111 -> 166
    //   280: aload_3
    //   281: invokevirtual 272	android/database/sqlite/SQLiteDatabase:close	()V
    //   284: goto -118 -> 166
    //   287: astore_3
    //   288: aconst_null
    //   289: astore 4
    //   291: aload 4
    //   293: ifnull +10 -> 303
    //   296: aload 4
    //   298: invokeinterface 271 1 0
    //   303: aload 5
    //   305: ifnull +8 -> 313
    //   308: aload 5
    //   310: invokevirtual 272	android/database/sqlite/SQLiteDatabase:close	()V
    //   313: aload_3
    //   314: athrow
    //   315: iload_2
    //   316: istore_1
    //   317: iload_2
    //   318: sipush 200
    //   321: if_icmplt +13 -> 334
    //   324: aload_0
    //   325: getfield 42	acxu:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   328: iconst_0
    //   329: invokestatic 285	aqoe:T	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   332: iload_2
    //   333: istore_1
    //   334: aload_0
    //   335: getfield 297	acxu:jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   338: ifnull +10 -> 348
    //   341: aload_0
    //   342: getfield 297	acxu:jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   345: invokevirtual 300	com/tencent/mobileqq/fts/FTSDatabase:close	()V
    //   348: aload_0
    //   349: getfield 302	acxu:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   352: ifnull +10 -> 362
    //   355: aload_0
    //   356: getfield 302	acxu:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   359: invokevirtual 305	com/tencent/mobileqq/persistence/fts/FTSDatatbase:close	()V
    //   362: ldc 97
    //   364: iconst_1
    //   365: ldc_w 307
    //   368: invokestatic 103	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   371: aload_0
    //   372: new 304	com/tencent/mobileqq/persistence/fts/FTSDatatbase
    //   375: dup
    //   376: aload_0
    //   377: getfield 42	acxu:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   380: invokespecial 309	com/tencent/mobileqq/persistence/fts/FTSDatatbase:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   383: putfield 302	acxu:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   386: new 311	ahqf
    //   389: dup
    //   390: invokespecial 312	ahqf:<init>	()V
    //   393: invokestatic 315	com/tencent/mobileqq/fts/FTSDatabase:a	(Lahqd;)V
    //   396: aload_0
    //   397: new 317	ahpz
    //   400: dup
    //   401: invokespecial 318	ahpz:<init>	()V
    //   404: putfield 297	acxu:jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   407: aload_0
    //   408: getfield 302	acxu:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   411: invokevirtual 319	com/tencent/mobileqq/persistence/fts/FTSDatatbase:init	()V
    //   414: new 153	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   421: aload_0
    //   422: getfield 42	acxu:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   425: invokevirtual 191	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   428: invokevirtual 197	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   431: invokevirtual 200	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   434: ldc 202
    //   436: ldc 204
    //   438: invokevirtual 210	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   441: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: getstatic 214	java/io/File:separator	Ljava/lang/String;
    //   447: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload_0
    //   451: getfield 42	acxu:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   454: invokevirtual 322	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   457: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: ldc 216
    //   462: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: astore_3
    //   469: aload_0
    //   470: getfield 297	acxu:jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   473: aload_3
    //   474: invokevirtual 324	com/tencent/mobileqq/fts/FTSDatabase:init	(Ljava/lang/String;)V
    //   477: aload_0
    //   478: getfield 42	acxu:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   481: iconst_1
    //   482: invokestatic 327	aqoe:am	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   485: getstatic 277	android/os/Build$VERSION:SDK_INT	I
    //   488: bipush 18
    //   490: if_icmpge +37 -> 527
    //   493: ldc 97
    //   495: iconst_1
    //   496: new 153	java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   503: ldc_w 329
    //   506: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: iload_1
    //   510: invokevirtual 290	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   513: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokestatic 295	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   519: aload_0
    //   520: getfield 42	acxu:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   523: iconst_0
    //   524: invokestatic 285	aqoe:T	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   527: aload_0
    //   528: getfield 38	acxu:eB	Ljava/util/concurrent/ConcurrentHashMap;
    //   531: invokevirtual 333	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   534: invokeinterface 339 1 0
    //   539: astore_3
    //   540: aload_3
    //   541: invokeinterface 344 1 0
    //   546: ifeq +158 -> 704
    //   549: aload_3
    //   550: invokeinterface 348 1 0
    //   555: checkcast 67	java/lang/Integer
    //   558: invokevirtual 352	java/lang/Integer:intValue	()I
    //   561: istore_1
    //   562: aload_0
    //   563: getfield 38	acxu:eB	Ljava/util/concurrent/ConcurrentHashMap;
    //   566: iload_1
    //   567: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   570: invokevirtual 356	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   573: checkcast 358	acxy
    //   576: astore 4
    //   578: aload 4
    //   580: ifnonnull +74 -> 654
    //   583: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   586: ifeq -326 -> 260
    //   589: ldc 97
    //   591: iconst_2
    //   592: iconst_4
    //   593: anewarray 360	java/lang/Object
    //   596: dup
    //   597: iconst_0
    //   598: ldc_w 362
    //   601: aastore
    //   602: dup
    //   603: iconst_1
    //   604: iload_1
    //   605: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   608: aastore
    //   609: dup
    //   610: iconst_2
    //   611: ldc_w 364
    //   614: aastore
    //   615: dup
    //   616: iconst_3
    //   617: aload_0
    //   618: getfield 38	acxu:eB	Ljava/util/concurrent/ConcurrentHashMap;
    //   621: invokevirtual 367	java/util/concurrent/ConcurrentHashMap:size	()I
    //   624: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   627: aastore
    //   628: invokestatic 371	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   631: return
    //   632: astore_3
    //   633: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   636: ifeq +13 -> 649
    //   639: ldc 97
    //   641: iconst_2
    //   642: ldc_w 373
    //   645: aload_3
    //   646: invokestatic 377	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   649: iconst_0
    //   650: putstatic 28	acxu:ENABLE	Z
    //   653: return
    //   654: aload 4
    //   656: aload_0
    //   657: getfield 302	acxu:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   660: aload_0
    //   661: getfield 297	acxu:jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   664: invokevirtual 380	acxy:a	(Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;Lcom/tencent/mobileqq/fts/FTSDatabase;)Z
    //   667: ifne -127 -> 540
    //   670: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   673: ifeq -413 -> 260
    //   676: ldc 97
    //   678: iconst_2
    //   679: iconst_2
    //   680: anewarray 360	java/lang/Object
    //   683: dup
    //   684: iconst_0
    //   685: ldc_w 382
    //   688: aastore
    //   689: dup
    //   690: iconst_1
    //   691: aload 4
    //   693: invokevirtual 386	java/lang/Object:getClass	()Ljava/lang/Class;
    //   696: invokevirtual 168	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   699: aastore
    //   700: invokestatic 371	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   703: return
    //   704: aload_0
    //   705: iconst_1
    //   706: putfield 114	acxu:isInit	Z
    //   709: return
    //   710: astore 6
    //   712: aconst_null
    //   713: astore 4
    //   715: aload_3
    //   716: astore 5
    //   718: aload 6
    //   720: astore_3
    //   721: goto -430 -> 291
    //   724: astore 6
    //   726: aload 5
    //   728: astore 4
    //   730: aload_3
    //   731: astore 5
    //   733: aload 6
    //   735: astore_3
    //   736: goto -445 -> 291
    //   739: astore 5
    //   741: goto -477 -> 264
    //   744: iconst_0
    //   745: istore_1
    //   746: goto -412 -> 334
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	749	0	this	acxu
    //   316	430	1	i	int
    //   181	152	2	j	int
    //   36	127	3	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   261	1	3	localException1	java.lang.Exception
    //   263	18	3	localObject1	Object
    //   287	27	3	localObject2	Object
    //   468	82	3	localObject3	Object
    //   632	84	3	localThrowable	java.lang.Throwable
    //   720	16	3	localObject4	Object
    //   7	722	4	localObject5	Object
    //   1	731	5	localObject6	Object
    //   739	1	5	localException2	java.lang.Exception
    //   4	132	6	str	String
    //   710	9	6	localObject7	Object
    //   724	10	6	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   30	37	261	java/lang/Exception
    //   30	37	287	finally
    //   407	527	632	java/lang/Throwable
    //   41	50	710	finally
    //   58	68	724	finally
    //   72	100	724	finally
    //   107	146	724	finally
    //   41	50	739	java/lang/Exception
    //   58	68	739	java/lang/Exception
    //   72	100	739	java/lang/Exception
    //   107	146	739	java/lang/Exception
  }
  
  public void Km(int paramInt)
  {
    this.cAq = paramInt;
  }
  
  public void Kn(int paramInt)
  {
    if (!this.isDestroyed) {
      ((acxy)this.eB.get(Integer.valueOf(paramInt))).cOR();
    }
  }
  
  public acxy a(int paramInt)
  {
    return (acxy)this.eB.get(Integer.valueOf(paramInt));
  }
  
  public acxz a()
  {
    return (acxz)a(1);
  }
  
  public void cOM()
  {
    if (hasInit()) {
      return;
    }
    this.jdField_a_of_type_Acyc.post(new FTSDBManager.1(this));
  }
  
  public void cON()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.dDB();
    this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.close();
  }
  
  public long fc()
  {
    long l = 0L;
    File localFile = new File(this.mApp.getApplication().getFilesDir().getAbsolutePath().replace("files", "databases") + File.separator + this.mApp.getCurrentAccountUin() + "-IndexQQMsg.db");
    if (localFile.exists()) {
      l = localFile.length();
    }
    return l;
  }
  
  public boolean hasInit()
  {
    try
    {
      boolean bool = this.isInit;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onDestroy()
  {
    try
    {
      this.isDestroyed = true;
      this.isInit = false;
      this.jdField_a_of_type_Acyc.stopSync();
      this.E.quit();
      Iterator localIterator = this.eB.keySet().iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        ((acxy)this.eB.get(Integer.valueOf(i))).destroy();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase == null) {
        break label101;
      }
    }
    finally {}
    this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.close();
    label101:
    if (this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.close();
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.fts.manager", 2, "FTSDBManager destroy...");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acxu
 * JD-Core Version:    0.7.0.1
 */