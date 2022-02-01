package com.tencent.mobileqq.startup.step;

import acbn;
import anbk;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import annk;
import awit;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import oak;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MigrateSubscribeDB
  extends Step
{
  public static boolean isUpdated;
  private List<File> GA;
  private List<File> GB;
  private List<File> GC;
  long amy = 0L;
  BaseApplicationImpl app;
  Object mLock = new Object();
  volatile boolean mRunning = true;
  int mTimeOut = -1;
  
  /* Error */
  private boolean D(File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +23 -> 24
    //   4: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +11 -> 18
    //   10: ldc 54
    //   12: iconst_2
    //   13: ldc 56
    //   15: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: iconst_0
    //   19: istore 4
    //   21: iload 4
    //   23: ireturn
    //   24: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +31 -> 58
    //   30: ldc 54
    //   32: iconst_2
    //   33: new 62	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   40: ldc 65
    //   42: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_1
    //   46: invokevirtual 75	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   49: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: invokestatic 84	java/lang/System:nanoTime	()J
    //   61: lstore 5
    //   63: aload_1
    //   64: invokevirtual 87	java/io/File:getName	()Ljava/lang/String;
    //   67: astore 11
    //   69: aconst_null
    //   70: astore 7
    //   72: aconst_null
    //   73: astore 16
    //   75: aconst_null
    //   76: astore 10
    //   78: aconst_null
    //   79: astore 9
    //   81: aconst_null
    //   82: astore 15
    //   84: aconst_null
    //   85: astore 12
    //   87: aconst_null
    //   88: astore 8
    //   90: aconst_null
    //   91: astore 14
    //   93: aload_0
    //   94: getfield 89	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:GB	Ljava/util/List;
    //   97: invokeinterface 94 1 0
    //   102: ifne +15 -> 117
    //   105: aload_0
    //   106: getfield 96	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:GC	Ljava/util/List;
    //   109: invokeinterface 94 1 0
    //   114: ifeq +56 -> 170
    //   117: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +11 -> 131
    //   123: ldc 54
    //   125: iconst_2
    //   126: ldc 98
    //   128: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: iconst_0
    //   132: istore 4
    //   134: iconst_0
    //   135: ifeq +11 -> 146
    //   138: new 100	java/lang/NullPointerException
    //   141: dup
    //   142: invokespecial 101	java/lang/NullPointerException:<init>	()V
    //   145: athrow
    //   146: iconst_0
    //   147: ifeq +11 -> 158
    //   150: new 100	java/lang/NullPointerException
    //   153: dup
    //   154: invokespecial 101	java/lang/NullPointerException:<init>	()V
    //   157: athrow
    //   158: iconst_0
    //   159: ifeq -138 -> 21
    //   162: new 100	java/lang/NullPointerException
    //   165: dup
    //   166: invokespecial 101	java/lang/NullPointerException:<init>	()V
    //   169: athrow
    //   170: aload 11
    //   172: ldc 103
    //   174: ldc 105
    //   176: invokevirtual 111	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   179: invokestatic 117	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   182: invokestatic 121	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   185: astore 17
    //   187: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   190: ifeq +29 -> 219
    //   193: ldc 54
    //   195: iconst_2
    //   196: new 62	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   203: ldc 123
    //   205: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload 17
    //   210: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aload_0
    //   220: getfield 89	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:GB	Ljava/util/List;
    //   223: invokeinterface 94 1 0
    //   228: ifne +461 -> 689
    //   231: aload_0
    //   232: getfield 89	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:GB	Ljava/util/List;
    //   235: invokeinterface 127 1 0
    //   240: astore 7
    //   242: aload 7
    //   244: invokeinterface 132 1 0
    //   249: ifeq +1201 -> 1450
    //   252: aload 7
    //   254: invokeinterface 136 1 0
    //   259: checkcast 71	java/io/File
    //   262: invokevirtual 87	java/io/File:getName	()Ljava/lang/String;
    //   265: astore 11
    //   267: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq +29 -> 299
    //   273: ldc 54
    //   275: iconst_2
    //   276: new 62	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   283: ldc 138
    //   285: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload 11
    //   290: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: aload 11
    //   301: aload 17
    //   303: invokevirtual 142	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   306: ifeq +237 -> 543
    //   309: aload 11
    //   311: astore 7
    //   313: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   316: ifeq +1137 -> 1453
    //   319: ldc 54
    //   321: iconst_2
    //   322: new 62	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   329: ldc 144
    //   331: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: aload 11
    //   336: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: aload 11
    //   347: astore 7
    //   349: goto +1104 -> 1453
    //   352: aload_0
    //   353: getfield 96	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:GC	Ljava/util/List;
    //   356: invokeinterface 94 1 0
    //   361: ifne +443 -> 804
    //   364: aload_0
    //   365: getfield 96	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:GC	Ljava/util/List;
    //   368: invokeinterface 127 1 0
    //   373: astore 7
    //   375: aload 7
    //   377: invokeinterface 132 1 0
    //   382: ifeq +1062 -> 1444
    //   385: aload 7
    //   387: invokeinterface 136 1 0
    //   392: checkcast 71	java/io/File
    //   395: invokevirtual 87	java/io/File:getName	()Ljava/lang/String;
    //   398: astore 13
    //   400: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   403: ifeq +29 -> 432
    //   406: ldc 54
    //   408: iconst_2
    //   409: new 62	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   416: ldc 146
    //   418: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: aload 13
    //   423: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: aload 13
    //   434: aload 17
    //   436: invokevirtual 142	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   439: ifeq +320 -> 759
    //   442: aload 13
    //   444: astore 7
    //   446: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   449: ifeq +1011 -> 1460
    //   452: ldc 54
    //   454: iconst_2
    //   455: new 62	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   462: ldc 148
    //   464: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: aload 13
    //   469: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   478: aload 13
    //   480: astore 7
    //   482: goto +978 -> 1460
    //   485: aload 13
    //   487: ifnonnull +342 -> 829
    //   490: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   493: ifeq +11 -> 504
    //   496: ldc 54
    //   498: iconst_2
    //   499: ldc 150
    //   501: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   504: iconst_1
    //   505: istore 4
    //   507: iconst_0
    //   508: ifeq +11 -> 519
    //   511: new 100	java/lang/NullPointerException
    //   514: dup
    //   515: invokespecial 101	java/lang/NullPointerException:<init>	()V
    //   518: athrow
    //   519: iconst_0
    //   520: ifeq +11 -> 531
    //   523: new 100	java/lang/NullPointerException
    //   526: dup
    //   527: invokespecial 101	java/lang/NullPointerException:<init>	()V
    //   530: athrow
    //   531: iconst_0
    //   532: ifeq -511 -> 21
    //   535: new 100	java/lang/NullPointerException
    //   538: dup
    //   539: invokespecial 101	java/lang/NullPointerException:<init>	()V
    //   542: athrow
    //   543: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   546: ifeq -304 -> 242
    //   549: ldc 54
    //   551: iconst_2
    //   552: new 62	java/lang/StringBuilder
    //   555: dup
    //   556: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   559: ldc 152
    //   561: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: aload 11
    //   566: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: ldc 154
    //   571: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: aload 17
    //   576: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   582: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   585: goto -343 -> 242
    //   588: astore 10
    //   590: aconst_null
    //   591: astore 7
    //   593: aconst_null
    //   594: astore_1
    //   595: aload 10
    //   597: invokevirtual 157	java/lang/Exception:printStackTrace	()V
    //   600: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   603: ifeq +11 -> 614
    //   606: ldc 54
    //   608: iconst_2
    //   609: ldc 159
    //   611: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   614: aload 7
    //   616: ifnull +8 -> 624
    //   619: aload 7
    //   621: invokevirtual 164	com/tencent/mobileqq/app/SQLiteDatabase:close	()V
    //   624: aload 8
    //   626: ifnull +8 -> 634
    //   629: aload 8
    //   631: invokevirtual 167	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   634: aload_1
    //   635: ifnull +7 -> 642
    //   638: aload_1
    //   639: invokevirtual 170	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   642: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   645: ifeq +42 -> 687
    //   648: ldc 54
    //   650: iconst_2
    //   651: new 62	java/lang/StringBuilder
    //   654: dup
    //   655: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   658: ldc 172
    //   660: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: invokestatic 84	java/lang/System:nanoTime	()J
    //   666: lload 5
    //   668: lsub
    //   669: ldc2_w 173
    //   672: ldiv
    //   673: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   676: ldc 179
    //   678: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   684: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   687: iconst_1
    //   688: ireturn
    //   689: aload 7
    //   691: astore 11
    //   693: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   696: ifeq -344 -> 352
    //   699: ldc 54
    //   701: iconst_2
    //   702: ldc 181
    //   704: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   707: aload 7
    //   709: astore 11
    //   711: goto -359 -> 352
    //   714: astore_1
    //   715: aload 10
    //   717: astore 7
    //   719: aload 9
    //   721: astore 8
    //   723: aload 14
    //   725: astore 9
    //   727: aload 9
    //   729: ifnull +8 -> 737
    //   732: aload 9
    //   734: invokevirtual 164	com/tencent/mobileqq/app/SQLiteDatabase:close	()V
    //   737: aload 8
    //   739: ifnull +8 -> 747
    //   742: aload 8
    //   744: invokevirtual 167	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   747: aload 7
    //   749: ifnull +8 -> 757
    //   752: aload 7
    //   754: invokevirtual 170	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   757: aload_1
    //   758: athrow
    //   759: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   762: ifeq -387 -> 375
    //   765: ldc 54
    //   767: iconst_2
    //   768: new 62	java/lang/StringBuilder
    //   771: dup
    //   772: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   775: ldc 183
    //   777: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: aload 13
    //   782: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: ldc 154
    //   787: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: aload 17
    //   792: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   798: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   801: goto -426 -> 375
    //   804: aload 16
    //   806: astore 13
    //   808: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   811: ifeq -326 -> 485
    //   814: ldc 54
    //   816: iconst_2
    //   817: ldc 185
    //   819: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   822: aload 16
    //   824: astore 13
    //   826: goto -341 -> 485
    //   829: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   832: ifeq +39 -> 871
    //   835: ldc 54
    //   837: iconst_2
    //   838: new 62	java/lang/StringBuilder
    //   841: dup
    //   842: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   845: ldc 187
    //   847: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: aload 11
    //   852: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: ldc 189
    //   857: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: aload 13
    //   862: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   865: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   868: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   871: new 191	com/tencent/mobileqq/data/QQEntityManagerFactory
    //   874: dup
    //   875: aload 17
    //   877: invokespecial 194	com/tencent/mobileqq/data/QQEntityManagerFactory:<init>	(Ljava/lang/String;)V
    //   880: astore 7
    //   882: aload 15
    //   884: astore 10
    //   886: aload 12
    //   888: astore 9
    //   890: aload 7
    //   892: invokevirtual 198	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   895: astore 8
    //   897: aload 8
    //   899: astore 10
    //   901: aload 8
    //   903: astore 9
    //   905: aload 8
    //   907: invokevirtual 202	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   910: astore 15
    //   912: aload 8
    //   914: astore 10
    //   916: aload 8
    //   918: astore 9
    //   920: aload 7
    //   922: aload 17
    //   924: invokevirtual 206	com/tencent/mobileqq/persistence/EntityManagerFactory:build	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/SQLiteOpenHelper;
    //   927: invokevirtual 212	com/tencent/mobileqq/app/SQLiteOpenHelper:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   930: astore 12
    //   932: aload_0
    //   933: getfield 34	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:mRunning	Z
    //   936: ifne +70 -> 1006
    //   939: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   942: ifeq +29 -> 971
    //   945: ldc 54
    //   947: iconst_2
    //   948: new 62	java/lang/StringBuilder
    //   951: dup
    //   952: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   955: ldc 214
    //   957: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   960: aload 17
    //   962: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   968: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   971: iconst_0
    //   972: istore 4
    //   974: aload 12
    //   976: ifnull +8 -> 984
    //   979: aload 12
    //   981: invokevirtual 164	com/tencent/mobileqq/app/SQLiteDatabase:close	()V
    //   984: aload 8
    //   986: ifnull +8 -> 994
    //   989: aload 8
    //   991: invokevirtual 167	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   994: aload 7
    //   996: ifnull -975 -> 21
    //   999: aload 7
    //   1001: invokevirtual 170	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   1004: iconst_0
    //   1005: ireturn
    //   1006: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1009: ifeq +58 -> 1067
    //   1012: ldc 54
    //   1014: iconst_2
    //   1015: new 62	java/lang/StringBuilder
    //   1018: dup
    //   1019: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   1022: ldc 216
    //   1024: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1027: aload 17
    //   1029: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: ldc 218
    //   1034: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: aload_1
    //   1038: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1041: ldc 223
    //   1043: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: aload 11
    //   1048: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1051: ldc 225
    //   1053: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: aload 13
    //   1058: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1064: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1067: aload 15
    //   1069: invokevirtual 230	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   1072: aload_0
    //   1073: aload 13
    //   1075: invokespecial 234	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:aO	(Ljava/lang/String;)Ljava/util/List;
    //   1078: astore_1
    //   1079: aload_0
    //   1080: aload_1
    //   1081: aload 8
    //   1083: invokespecial 237	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:b	(Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   1086: aload_0
    //   1087: aload 17
    //   1089: invokespecial 240	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:QL	(Ljava/lang/String;)V
    //   1092: aload 11
    //   1094: ifnull +70 -> 1164
    //   1097: aload_0
    //   1098: aload 11
    //   1100: aload 17
    //   1102: aload_0
    //   1103: aload 11
    //   1105: invokespecial 244	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:s	(Ljava/lang/String;)[Ljava/lang/String;
    //   1108: aload_1
    //   1109: aload 8
    //   1111: invokespecial 247	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   1114: aload_0
    //   1115: aload_1
    //   1116: aload 8
    //   1118: invokespecial 249	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   1121: aload 15
    //   1123: invokevirtual 252	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   1126: aload 15
    //   1128: invokevirtual 255	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   1131: aload 12
    //   1133: ifnull +8 -> 1141
    //   1136: aload 12
    //   1138: invokevirtual 164	com/tencent/mobileqq/app/SQLiteDatabase:close	()V
    //   1141: aload 8
    //   1143: ifnull +8 -> 1151
    //   1146: aload 8
    //   1148: invokevirtual 167	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   1151: aload 7
    //   1153: ifnull -511 -> 642
    //   1156: aload 7
    //   1158: invokevirtual 170	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   1161: goto -519 -> 642
    //   1164: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1167: ifeq +12 -> 1179
    //   1170: ldc 54
    //   1172: iconst_2
    //   1173: ldc_w 257
    //   1176: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1179: aload_0
    //   1180: getfield 89	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:GB	Ljava/util/List;
    //   1183: invokeinterface 94 1 0
    //   1188: ifne -74 -> 1114
    //   1191: aload_0
    //   1192: getfield 89	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:GB	Ljava/util/List;
    //   1195: invokeinterface 127 1 0
    //   1200: astore 9
    //   1202: aload 9
    //   1204: invokeinterface 132 1 0
    //   1209: ifeq -95 -> 1114
    //   1212: aload 9
    //   1214: invokeinterface 136 1 0
    //   1219: checkcast 71	java/io/File
    //   1222: invokevirtual 87	java/io/File:getName	()Ljava/lang/String;
    //   1225: astore 10
    //   1227: aload_0
    //   1228: aload 10
    //   1230: invokespecial 244	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:s	(Ljava/lang/String;)[Ljava/lang/String;
    //   1233: astore 11
    //   1235: aload 11
    //   1237: ifnull -35 -> 1202
    //   1240: aload_0
    //   1241: aload_1
    //   1242: aload 11
    //   1244: invokespecial 261	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:c	(Ljava/util/List;[Ljava/lang/String;)Ljava/util/List;
    //   1247: invokeinterface 265 1 0
    //   1252: istore_3
    //   1253: iload_3
    //   1254: ifeq -52 -> 1202
    //   1257: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1260: ifeq +41 -> 1301
    //   1263: ldc 54
    //   1265: iconst_2
    //   1266: new 62	java/lang/StringBuilder
    //   1269: dup
    //   1270: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   1273: ldc_w 267
    //   1276: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1279: aload 17
    //   1281: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1284: ldc_w 269
    //   1287: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: aload 10
    //   1292: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1295: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1298: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1301: iload_3
    //   1302: anewarray 107	java/lang/String
    //   1305: astore 11
    //   1307: iconst_0
    //   1308: istore_2
    //   1309: iload_2
    //   1310: iload_3
    //   1311: if_icmpge +27 -> 1338
    //   1314: aload 11
    //   1316: iload_2
    //   1317: aload_1
    //   1318: iload_2
    //   1319: invokeinterface 273 2 0
    //   1324: checkcast 9	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$b
    //   1327: getfield 277	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$b:mSubscribeID	Ljava/lang/String;
    //   1330: aastore
    //   1331: iload_2
    //   1332: iconst_1
    //   1333: iadd
    //   1334: istore_2
    //   1335: goto -26 -> 1309
    //   1338: aload_0
    //   1339: aload 10
    //   1341: aload 17
    //   1343: aload 11
    //   1345: aload_1
    //   1346: aload 8
    //   1348: invokespecial 247	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/util/List;Lcom/tencent/mobileqq/persistence/EntityManager;)V
    //   1351: goto -149 -> 1202
    //   1354: astore_1
    //   1355: aload_1
    //   1356: invokevirtual 157	java/lang/Exception:printStackTrace	()V
    //   1359: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1362: ifeq +12 -> 1374
    //   1365: ldc 54
    //   1367: iconst_2
    //   1368: ldc_w 279
    //   1371: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1374: aload 15
    //   1376: invokevirtual 255	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   1379: goto -248 -> 1131
    //   1382: astore_1
    //   1383: aload 15
    //   1385: invokevirtual 255	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   1388: aload_1
    //   1389: athrow
    //   1390: astore_1
    //   1391: aload 12
    //   1393: astore 9
    //   1395: goto -668 -> 727
    //   1398: astore_1
    //   1399: aload 14
    //   1401: astore 9
    //   1403: aload 10
    //   1405: astore 8
    //   1407: goto -680 -> 727
    //   1410: astore 10
    //   1412: aload 7
    //   1414: astore 9
    //   1416: aload_1
    //   1417: astore 7
    //   1419: aload 10
    //   1421: astore_1
    //   1422: goto -695 -> 727
    //   1425: astore 10
    //   1427: aconst_null
    //   1428: astore 8
    //   1430: aload 7
    //   1432: astore_1
    //   1433: aload 8
    //   1435: astore 7
    //   1437: aload 9
    //   1439: astore 8
    //   1441: goto -846 -> 595
    //   1444: aconst_null
    //   1445: astore 7
    //   1447: goto +13 -> 1460
    //   1450: aconst_null
    //   1451: astore 7
    //   1453: aload 7
    //   1455: astore 11
    //   1457: goto -1105 -> 352
    //   1460: aload 7
    //   1462: astore 13
    //   1464: goto -979 -> 485
    //   1467: astore 10
    //   1469: aload 7
    //   1471: astore_1
    //   1472: aload 12
    //   1474: astore 7
    //   1476: goto -881 -> 595
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1479	0	this	MigrateSubscribeDB
    //   0	1479	1	paramFile	File
    //   1308	27	2	i	int
    //   1252	60	3	j	int
    //   19	954	4	bool	boolean
    //   61	606	5	l	long
    //   70	1405	7	localObject1	Object
    //   88	1352	8	localObject2	Object
    //   79	1359	9	localObject3	Object
    //   76	1	10	localObject4	Object
    //   588	128	10	localException1	Exception
    //   884	520	10	localObject5	Object
    //   1410	10	10	localObject6	Object
    //   1425	1	10	localException2	Exception
    //   1467	1	10	localException3	Exception
    //   67	1389	11	localObject7	Object
    //   85	1388	12	localSQLiteDatabase	com.tencent.mobileqq.app.SQLiteDatabase
    //   398	1065	13	localObject8	Object
    //   91	1309	14	localObject9	Object
    //   82	1302	15	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   73	750	16	localObject10	Object
    //   185	1157	17	str	String
    // Exception table:
    //   from	to	target	type
    //   93	117	588	java/lang/Exception
    //   117	131	588	java/lang/Exception
    //   170	219	588	java/lang/Exception
    //   219	242	588	java/lang/Exception
    //   242	299	588	java/lang/Exception
    //   299	309	588	java/lang/Exception
    //   313	345	588	java/lang/Exception
    //   352	375	588	java/lang/Exception
    //   375	432	588	java/lang/Exception
    //   432	442	588	java/lang/Exception
    //   446	478	588	java/lang/Exception
    //   490	504	588	java/lang/Exception
    //   543	585	588	java/lang/Exception
    //   693	707	588	java/lang/Exception
    //   759	801	588	java/lang/Exception
    //   808	822	588	java/lang/Exception
    //   829	871	588	java/lang/Exception
    //   871	882	588	java/lang/Exception
    //   93	117	714	finally
    //   117	131	714	finally
    //   170	219	714	finally
    //   219	242	714	finally
    //   242	299	714	finally
    //   299	309	714	finally
    //   313	345	714	finally
    //   352	375	714	finally
    //   375	432	714	finally
    //   432	442	714	finally
    //   446	478	714	finally
    //   490	504	714	finally
    //   543	585	714	finally
    //   693	707	714	finally
    //   759	801	714	finally
    //   808	822	714	finally
    //   829	871	714	finally
    //   871	882	714	finally
    //   1072	1092	1354	java/lang/Exception
    //   1097	1114	1354	java/lang/Exception
    //   1114	1126	1354	java/lang/Exception
    //   1164	1179	1354	java/lang/Exception
    //   1179	1202	1354	java/lang/Exception
    //   1202	1235	1354	java/lang/Exception
    //   1240	1253	1354	java/lang/Exception
    //   1257	1301	1354	java/lang/Exception
    //   1301	1307	1354	java/lang/Exception
    //   1314	1331	1354	java/lang/Exception
    //   1338	1351	1354	java/lang/Exception
    //   1072	1092	1382	finally
    //   1097	1114	1382	finally
    //   1114	1126	1382	finally
    //   1164	1179	1382	finally
    //   1179	1202	1382	finally
    //   1202	1235	1382	finally
    //   1240	1253	1382	finally
    //   1257	1301	1382	finally
    //   1301	1307	1382	finally
    //   1314	1331	1382	finally
    //   1338	1351	1382	finally
    //   1355	1374	1382	finally
    //   932	971	1390	finally
    //   1006	1067	1390	finally
    //   1067	1072	1390	finally
    //   1126	1131	1390	finally
    //   1374	1379	1390	finally
    //   1383	1390	1390	finally
    //   890	897	1398	finally
    //   905	912	1398	finally
    //   920	932	1398	finally
    //   595	614	1410	finally
    //   890	897	1425	java/lang/Exception
    //   905	912	1425	java/lang/Exception
    //   920	932	1425	java/lang/Exception
    //   932	971	1467	java/lang/Exception
    //   1006	1067	1467	java/lang/Exception
    //   1067	1072	1467	java/lang/Exception
    //   1126	1131	1467	java/lang/Exception
    //   1374	1379	1467	java/lang/Exception
    //   1383	1390	1467	java/lang/Exception
  }
  
  private int Kg()
  {
    return (short)Math.abs(new Random().nextInt()) & 0xFFFF;
  }
  
  private void QL(String paramString)
  {
    long l = System.nanoTime();
    int j = BaseApplicationImpl.getApplication().getSharedPreferences("readinjoy_" + paramString + "_" + 1, 0).getInt("updated_msg_count", 0);
    if (j == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "updateFolderUnReadCount readInJoyUnreadCount == 0");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MigrateSubscribeDB", 2, "updateFolderUnReadCount readinjoy new unread count: " + j);
    }
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences(paramString, 0);
    Object localObject2 = paramString.getString("troopbar_assist_new_unread_list", "");
    if (awit.isColorLevel()) {
      QLog.i("MigrateSubscribeDB", 2, "updateFolderUnReadCount, get troopbar new unread list ( newMsgStr ): " + (String)localObject2);
    }
    Object localObject1 = new ConcurrentHashMap();
    for (;;)
    {
      Object localObject3;
      Object localObject4;
      String str;
      try
      {
        localObject2 = new JSONArray((String)localObject2);
        if (!QLog.isColorLevel()) {
          break label633;
        }
        QLog.d("MigrateSubscribeDB", 2, "updateFolderUnReadCount jsonArray length: " + ((JSONArray)localObject2).length());
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        if (!QLog.isColorLevel()) {
          break label375;
        }
        QLog.e("MigrateSubscribeDB", 2, "updateFolderUnReadCount:" + paramString.toString(), paramString);
      }
      if (i < ((JSONArray)localObject2).length())
      {
        localObject3 = ((JSONArray)localObject2).getJSONObject(i);
        localObject4 = ((JSONObject)localObject3).keys();
        if (((Iterator)localObject4).hasNext())
        {
          str = (String)((Iterator)localObject4).next();
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "updateFolderUnReadCount newMsgMap put key: " + str + " | value: " + ((JSONObject)localObject3).getInt(str));
          }
          ((ConcurrentHashMap)localObject1).put(str, Integer.valueOf(((JSONObject)localObject3).getInt(str)));
          continue;
        }
      }
      for (;;)
      {
        label375:
        if (!QLog.isColorLevel()) {
          break label631;
        }
        QLog.d("MigrateSubscribeDB", 2, "updateFolderUnReadCount total cost = " + (System.nanoTime() - l) / 1000000L + " ms ");
        return;
        i += 1;
        break;
        ((ConcurrentHashMap)localObject1).put(acbn.blo, Integer.valueOf(j));
        localObject2 = ((ConcurrentHashMap)localObject1).keySet().iterator();
        localObject3 = new JSONArray();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = new JSONObject();
          str = (String)((Iterator)localObject2).next();
          try
          {
            ((JSONObject)localObject4).put(str, ((ConcurrentHashMap)localObject1).get(str));
            ((JSONArray)localObject3).put(localObject4);
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
        localObject1 = ((JSONArray)localObject3).toString();
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "updateFolderUnReadCount save newMsgStr into sp:" + (String)localObject1);
        }
        paramString = paramString.edit();
        paramString.putString("troopbar_assist_new_unread_list", (String)localObject1);
        paramString.commit();
        if (awit.isColorLevel()) {
          QLog.i("MigrateSubscribeDB", 2, "updateFolderUnReadCount, put troopbar new list ( newMsgStr ): " + (String)localObject1);
        }
      }
      label631:
      break;
      label633:
      int i = 0;
    }
  }
  
  /* Error */
  private List<MessageRecord> a(String paramString1, String paramString2, List<b> paramList, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +60 -> 63
    //   6: ldc 54
    //   8: iconst_2
    //   9: new 62	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 429
    //   19: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 431
    //   29: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_2
    //   33: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc_w 433
    //   39: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_3
    //   43: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   46: ldc_w 435
    //   49: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload 4
    //   54: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   63: invokestatic 84	java/lang/System:nanoTime	()J
    //   66: lstore 13
    //   68: new 437	java/util/ArrayList
    //   71: dup
    //   72: invokespecial 438	java/util/ArrayList:<init>	()V
    //   75: astore 22
    //   77: aload_2
    //   78: ifnull +7 -> 85
    //   81: aload_3
    //   82: ifnonnull +20 -> 102
    //   85: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   88: ifeq +12 -> 100
    //   91: ldc 54
    //   93: iconst_2
    //   94: ldc_w 440
    //   97: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: aconst_null
    //   101: areturn
    //   102: aload_3
    //   103: invokeinterface 265 1 0
    //   108: istore 6
    //   110: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   113: ifeq +30 -> 143
    //   116: ldc 54
    //   118: iconst_2
    //   119: new 62	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   126: ldc_w 442
    //   129: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: iload 6
    //   134: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   137: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: iconst_0
    //   144: istore 5
    //   146: iload 5
    //   148: iload 6
    //   150: if_icmpge +966 -> 1116
    //   153: aload_3
    //   154: iload 5
    //   156: invokeinterface 273 2 0
    //   161: checkcast 9	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$b
    //   164: getfield 277	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$b:mSubscribeID	Ljava/lang/String;
    //   167: aload_2
    //   168: invokevirtual 446	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   171: ifeq +683 -> 854
    //   174: aload_3
    //   175: iload 5
    //   177: invokeinterface 273 2 0
    //   182: checkcast 9	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$b
    //   185: astore_3
    //   186: aload_3
    //   187: ifnull +923 -> 1110
    //   190: aload_3
    //   191: getfield 449	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$b:aOr	I
    //   194: istore 5
    //   196: ldc_w 451
    //   199: astore_3
    //   200: iload 5
    //   202: ifle +7 -> 209
    //   205: ldc_w 453
    //   208: astore_3
    //   209: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +29 -> 241
    //   215: ldc 54
    //   217: iconst_2
    //   218: new 62	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   225: ldc_w 455
    //   228: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_3
    //   232: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   241: new 6	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$a
    //   244: dup
    //   245: aload_0
    //   246: invokestatic 461	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   249: aload_1
    //   250: bipush 80
    //   252: invokespecial 464	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$a:<init>	(Lcom/tencent/mobileqq/startup/step/MigrateSubscribeDB;Landroid/content/Context;Ljava/lang/String;I)V
    //   255: astore_1
    //   256: aload_1
    //   257: invokevirtual 468	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$a:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   260: astore 23
    //   262: aload 23
    //   264: iconst_0
    //   265: ldc_w 470
    //   268: aconst_null
    //   269: ldc_w 472
    //   272: iconst_1
    //   273: anewarray 107	java/lang/String
    //   276: dup
    //   277: iconst_0
    //   278: aload_2
    //   279: aastore
    //   280: aconst_null
    //   281: aconst_null
    //   282: ldc_w 474
    //   285: aload_3
    //   286: invokevirtual 480	android/database/sqlite/SQLiteDatabase:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   289: astore_2
    //   290: aload_2
    //   291: ifnull +732 -> 1023
    //   294: aload_2
    //   295: invokeinterface 485 1 0
    //   300: ifeq +696 -> 996
    //   303: aload_2
    //   304: ldc_w 487
    //   307: invokeinterface 490 2 0
    //   312: istore 7
    //   314: aload_2
    //   315: ldc_w 492
    //   318: invokeinterface 490 2 0
    //   323: istore 8
    //   325: aload_2
    //   326: ldc_w 494
    //   329: invokeinterface 490 2 0
    //   334: istore 9
    //   336: aload_2
    //   337: ldc_w 496
    //   340: invokeinterface 490 2 0
    //   345: istore 10
    //   347: aload_2
    //   348: ldc_w 498
    //   351: invokeinterface 490 2 0
    //   356: istore 11
    //   358: aload_2
    //   359: ldc_w 500
    //   362: invokeinterface 490 2 0
    //   367: istore 12
    //   369: aload_2
    //   370: iload 7
    //   372: invokeinterface 504 2 0
    //   377: lstore 15
    //   379: aload_2
    //   380: iload 8
    //   382: invokeinterface 507 2 0
    //   387: astore 25
    //   389: aload_2
    //   390: iload 9
    //   392: invokeinterface 507 2 0
    //   397: astore_3
    //   398: aload_2
    //   399: iload 10
    //   401: invokeinterface 507 2 0
    //   406: astore 24
    //   408: aload_2
    //   409: iload 11
    //   411: invokeinterface 504 2 0
    //   416: lstore 17
    //   418: aload_2
    //   419: iload 12
    //   421: invokeinterface 504 2 0
    //   426: lstore 19
    //   428: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   431: ifeq +90 -> 521
    //   434: ldc 54
    //   436: iconst_2
    //   437: new 62	java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   444: ldc_w 509
    //   447: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: lload 15
    //   452: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   455: ldc_w 511
    //   458: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: aload 25
    //   463: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: ldc_w 511
    //   469: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: aload_3
    //   473: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: ldc_w 511
    //   479: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: aload 24
    //   484: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: ldc_w 511
    //   490: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: lload 17
    //   495: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   498: ldc_w 511
    //   501: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: lload 19
    //   506: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   509: ldc_w 513
    //   512: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: aload 25
    //   523: invokestatic 519	oak:cu	(Ljava/lang/String;)Ljava/lang/String;
    //   526: astore_3
    //   527: aload_3
    //   528: invokestatic 523	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   531: ifne +415 -> 946
    //   534: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   537: ifeq +40 -> 577
    //   540: ldc 54
    //   542: iconst_2
    //   543: new 62	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   550: ldc_w 525
    //   553: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload 25
    //   558: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: ldc_w 527
    //   564: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: aload_3
    //   568: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   577: aload 24
    //   579: invokestatic 532	obj:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/PAMessage;
    //   582: astore 26
    //   584: aload 26
    //   586: ifnull +342 -> 928
    //   589: sipush -3006
    //   592: invokestatic 537	anbi:d	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   595: checkcast 539	com/tencent/mobileqq/data/MessageForPubAccount
    //   598: astore 25
    //   600: aload 25
    //   602: sipush -3006
    //   605: putfield 542	com/tencent/mobileqq/data/MessageForPubAccount:msgtype	I
    //   608: aload 25
    //   610: sipush 1008
    //   613: putfield 545	com/tencent/mobileqq/data/MessageForPubAccount:istroop	I
    //   616: aload 25
    //   618: aload 24
    //   620: putfield 548	com/tencent/mobileqq/data/MessageForPubAccount:msg	Ljava/lang/String;
    //   623: aload 25
    //   625: aload 26
    //   627: putfield 552	com/tencent/mobileqq/data/MessageForPubAccount:mPAMessage	Lcom/tencent/mobileqq/data/PAMessage;
    //   630: aload 25
    //   632: aload 26
    //   634: invokestatic 555	obj:a	(Lcom/tencent/mobileqq/data/PAMessage;)[B
    //   637: putfield 559	com/tencent/mobileqq/data/MessageForPubAccount:msgData	[B
    //   640: aload 25
    //   642: aload_3
    //   643: putfield 562	com/tencent/mobileqq/data/MessageForPubAccount:frienduin	Ljava/lang/String;
    //   646: aload 25
    //   648: aload_3
    //   649: putfield 565	com/tencent/mobileqq/data/MessageForPubAccount:senderuin	Ljava/lang/String;
    //   652: aload 25
    //   654: aload 4
    //   656: putfield 568	com/tencent/mobileqq/data/MessageForPubAccount:selfuin	Ljava/lang/String;
    //   659: aload 25
    //   661: lload 17
    //   663: putfield 571	com/tencent/mobileqq/data/MessageForPubAccount:time	J
    //   666: aload 25
    //   668: lload 17
    //   670: putfield 574	com/tencent/mobileqq/data/MessageForPubAccount:msgseq	J
    //   673: aload 25
    //   675: aload_0
    //   676: invokespecial 576	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:Kg	()I
    //   679: i2l
    //   680: putfield 579	com/tencent/mobileqq/data/MessageForPubAccount:shmsgseq	J
    //   683: aload 25
    //   685: aload_0
    //   686: invokespecial 582	com/tencent/mobileqq/startup/step/MigrateSubscribeDB:hb	()J
    //   689: putfield 585	com/tencent/mobileqq/data/MessageForPubAccount:msgUid	J
    //   692: iload 5
    //   694: ifle +228 -> 922
    //   697: iconst_0
    //   698: istore 21
    //   700: aload 25
    //   702: iload 21
    //   704: putfield 588	com/tencent/mobileqq/data/MessageForPubAccount:isread	Z
    //   707: aload 22
    //   709: aload 25
    //   711: invokeinterface 591 2 0
    //   716: pop
    //   717: iload 5
    //   719: iconst_1
    //   720: isub
    //   721: istore 5
    //   723: goto +398 -> 1121
    //   726: aload_2
    //   727: invokeinterface 594 1 0
    //   732: istore 21
    //   734: iload 6
    //   736: istore 5
    //   738: iload 21
    //   740: ifne -371 -> 369
    //   743: aload_2
    //   744: invokeinterface 595 1 0
    //   749: aload 22
    //   751: ifnull +287 -> 1038
    //   754: aload 22
    //   756: invokeinterface 265 1 0
    //   761: ifle +277 -> 1038
    //   764: iconst_0
    //   765: istore 5
    //   767: iload 5
    //   769: aload 22
    //   771: invokeinterface 265 1 0
    //   776: iconst_1
    //   777: isub
    //   778: if_icmpge +260 -> 1038
    //   781: aload 22
    //   783: invokeinterface 265 1 0
    //   788: iconst_1
    //   789: isub
    //   790: istore 6
    //   792: iload 6
    //   794: iload 5
    //   796: if_icmple +218 -> 1014
    //   799: aload 22
    //   801: iload 6
    //   803: invokeinterface 273 2 0
    //   808: checkcast 597	com/tencent/mobileqq/data/MessageRecord
    //   811: getfield 598	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   814: aload 22
    //   816: iload 5
    //   818: invokeinterface 273 2 0
    //   823: checkcast 597	com/tencent/mobileqq/data/MessageRecord
    //   826: getfield 598	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   829: invokevirtual 446	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   832: ifeq +13 -> 845
    //   835: aload 22
    //   837: iload 6
    //   839: invokeinterface 601 2 0
    //   844: pop
    //   845: iload 6
    //   847: iconst_1
    //   848: isub
    //   849: istore 6
    //   851: goto -59 -> 792
    //   854: iload 5
    //   856: iconst_1
    //   857: iadd
    //   858: istore 5
    //   860: goto -714 -> 146
    //   863: astore 24
    //   865: aload 24
    //   867: invokevirtual 157	java/lang/Exception:printStackTrace	()V
    //   870: goto -240 -> 630
    //   873: astore_3
    //   874: aload_3
    //   875: invokevirtual 157	java/lang/Exception:printStackTrace	()V
    //   878: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   881: ifeq +13 -> 894
    //   884: ldc 54
    //   886: iconst_2
    //   887: ldc_w 603
    //   890: aload_3
    //   891: invokestatic 381	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   894: aload_2
    //   895: invokeinterface 595 1 0
    //   900: goto -151 -> 749
    //   903: astore 24
    //   905: aload 24
    //   907: invokevirtual 157	java/lang/Exception:printStackTrace	()V
    //   910: goto -270 -> 640
    //   913: astore_1
    //   914: aload_2
    //   915: invokeinterface 595 1 0
    //   920: aload_1
    //   921: athrow
    //   922: iconst_1
    //   923: istore 21
    //   925: goto -225 -> 700
    //   928: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   931: ifeq +197 -> 1128
    //   934: ldc 54
    //   936: iconst_2
    //   937: ldc_w 605
    //   940: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   943: goto +185 -> 1128
    //   946: iload 5
    //   948: istore 6
    //   950: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   953: ifeq -227 -> 726
    //   956: ldc 54
    //   958: iconst_2
    //   959: new 62	java/lang/StringBuilder
    //   962: dup
    //   963: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   966: ldc_w 607
    //   969: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   972: aload 25
    //   974: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   977: ldc_w 609
    //   980: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   986: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   989: iload 5
    //   991: istore 6
    //   993: goto -267 -> 726
    //   996: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   999: ifeq -256 -> 743
    //   1002: ldc 54
    //   1004: iconst_2
    //   1005: ldc_w 611
    //   1008: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1011: goto -268 -> 743
    //   1014: iload 5
    //   1016: iconst_1
    //   1017: iadd
    //   1018: istore 5
    //   1020: goto -253 -> 767
    //   1023: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1026: ifeq +12 -> 1038
    //   1029: ldc 54
    //   1031: iconst_2
    //   1032: ldc_w 613
    //   1035: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1038: aload_1
    //   1039: ifnull +7 -> 1046
    //   1042: aload_1
    //   1043: invokevirtual 614	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$a:close	()V
    //   1046: aload 23
    //   1048: ifnull +8 -> 1056
    //   1051: aload 23
    //   1053: invokevirtual 615	android/database/sqlite/SQLiteDatabase:close	()V
    //   1056: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1059: ifeq +44 -> 1103
    //   1062: ldc 54
    //   1064: iconst_2
    //   1065: new 62	java/lang/StringBuilder
    //   1068: dup
    //   1069: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   1072: ldc_w 617
    //   1075: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1078: invokestatic 84	java/lang/System:nanoTime	()J
    //   1081: lload 13
    //   1083: lsub
    //   1084: ldc2_w 173
    //   1087: ldiv
    //   1088: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1091: ldc_w 385
    //   1094: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1097: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1100: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1103: aload 22
    //   1105: areturn
    //   1106: astore_1
    //   1107: goto -51 -> 1056
    //   1110: iconst_0
    //   1111: istore 5
    //   1113: goto -917 -> 196
    //   1116: aconst_null
    //   1117: astore_3
    //   1118: goto -932 -> 186
    //   1121: iload 5
    //   1123: istore 6
    //   1125: goto -399 -> 726
    //   1128: goto -7 -> 1121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1131	0	this	MigrateSubscribeDB
    //   0	1131	1	paramString1	String
    //   0	1131	2	paramString2	String
    //   0	1131	3	paramList	List<b>
    //   0	1131	4	paramString3	String
    //   144	978	5	i	int
    //   108	1016	6	j	int
    //   312	59	7	k	int
    //   323	58	8	m	int
    //   334	57	9	n	int
    //   345	55	10	i1	int
    //   356	54	11	i2	int
    //   367	53	12	i3	int
    //   66	1016	13	l1	long
    //   377	74	15	l2	long
    //   416	253	17	l3	long
    //   426	79	19	l4	long
    //   698	226	21	bool	boolean
    //   75	1029	22	localArrayList	ArrayList
    //   260	792	23	localSQLiteDatabase	SQLiteDatabase
    //   406	213	24	str	String
    //   863	3	24	localException1	Exception
    //   903	3	24	localException2	Exception
    //   387	586	25	localObject	Object
    //   582	51	26	localPAMessage	com.tencent.mobileqq.data.PAMessage
    // Exception table:
    //   from	to	target	type
    //   623	630	863	java/lang/Exception
    //   294	369	873	java/lang/Exception
    //   369	521	873	java/lang/Exception
    //   521	577	873	java/lang/Exception
    //   577	584	873	java/lang/Exception
    //   589	623	873	java/lang/Exception
    //   640	692	873	java/lang/Exception
    //   700	717	873	java/lang/Exception
    //   726	734	873	java/lang/Exception
    //   865	870	873	java/lang/Exception
    //   905	910	873	java/lang/Exception
    //   928	943	873	java/lang/Exception
    //   950	989	873	java/lang/Exception
    //   996	1011	873	java/lang/Exception
    //   630	640	903	java/lang/Exception
    //   294	369	913	finally
    //   369	521	913	finally
    //   521	577	913	finally
    //   577	584	913	finally
    //   589	623	913	finally
    //   623	630	913	finally
    //   630	640	913	finally
    //   640	692	913	finally
    //   700	717	913	finally
    //   726	734	913	finally
    //   865	870	913	finally
    //   874	894	913	finally
    //   905	910	913	finally
    //   928	943	913	finally
    //   950	989	913	finally
    //   996	1011	913	finally
    //   1051	1056	1106	java/lang/Exception
  }
  
  private void a(String paramString1, String paramString2, String[] paramArrayOfString, List<b> paramList, EntityManager paramEntityManager)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MigrateSubscribeDB", 2, "MigrateAllToMessageRecord  fileName is : " + paramString1 + "uinStr : " + paramString2);
    }
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "Migrate subscribe subscribeMsgIDs size: " + j);
      }
      int i = 0;
      while (i < j)
      {
        List localList = a(paramString1, paramArrayOfString[i], paramList, paramString2);
        d(paramArrayOfString[i], paramList, localList);
        c(localList, paramEntityManager);
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MigrateSubscribeDB", 2, "Migrate subscribe subscribeMsgIDs is null");
    }
  }
  
  private void a(List<b> paramList, EntityManager paramEntityManager)
  {
    long l = System.nanoTime();
    if (paramList == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "migrateToTroopBar fail subscribeRecentDataList is null");
      }
    }
    do
    {
      return;
      int j = paramList.size();
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "migrateToTroopBar subscribeRecentDataList list size: " + j);
      }
      int i = 0;
      if (i < j)
      {
        b localb = (b)paramList.get(i);
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "migrateToTroopBar subscribeRecentData: " + localb);
        }
        String str = oak.cu(localb.mSubscribeID);
        if (!TextUtils.isEmpty(str))
        {
          TroopBarData localTroopBarData = new TroopBarData();
          localTroopBarData.mUin = str;
          localTroopBarData.mLastMsgTime = localb.amz;
          localTroopBarData.mLastDraftTime = 0L;
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "migrateToTroopBar subscribeid[" + localb.mSubscribeID + "] create new TroopBarData: " + localTroopBarData);
          }
          paramEntityManager.persistOrReplace(localTroopBarData);
        }
        for (;;)
        {
          i += 1;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "migrateToTroopBar we can't subscribeid[" + localb.mSubscribeID + "]'s uin");
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("MigrateSubscribeDB", 2, "migrateToTroopBar total cost = " + (System.nanoTime() - l) / 1000000L + " ms ");
  }
  
  private List<b> aO(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "getSubscribeRecentDataList fail readInJoySubDBName is null");
      }
      paramString = null;
      return paramString;
    }
    a locala = new a(BaseApplication.getContext(), paramString, 17);
    paramString = locala.getReadableDatabase().rawQuery("select * from RecentSubscribeData order by mLastMsgTime DESC", null);
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        if (!paramString.moveToFirst()) {
          continue;
        }
        int i = paramString.getColumnIndex("mDraft");
        int j = paramString.getColumnIndex("mDraftTime");
        int k = paramString.getColumnIndex("mLastMsg");
        int m = paramString.getColumnIndex("mLastMsgID");
        int n = paramString.getColumnIndex("mLastMsgTime");
        int i1 = paramString.getColumnIndex("mLastReorderTime");
        int i2 = paramString.getColumnIndex("mSubscribeHeadUrl");
        int i3 = paramString.getColumnIndex("mSubscribeID");
        int i4 = paramString.getColumnIndex("mSubscribeName");
        int i5 = paramString.getColumnIndex("mUnreadCount");
        b localb = new b(null);
        localb.ceP = r(paramString.getString(i));
        localb.ceQ = r(paramString.getString(j));
        localb.Ul = r(paramString.getString(k));
        localb.Ix = paramString.getLong(m);
        localb.mLastMsgTime = paramString.getLong(n);
        localb.amz = paramString.getLong(i1);
        localb.ceR = r(paramString.getString(i2));
        localb.mSubscribeID = r(paramString.getString(i3));
        localb.mSubscribeName = r(paramString.getString(i4));
        localb.aOr = paramString.getInt(i5);
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "read Subscribe RecentDataResults:(mDraft,mDraftTime,mLastMsg,mLastMsgID,mLastMsgTime,mLastReorderTime,mSubscribeHeadUrl,mSubscribeID,mSubscribeName,mUnreadCount)=(" + localb.ceP + "," + localb.ceQ + "," + localb.Ul + "," + localb.Ix + "," + localb.mLastMsgTime + "," + localb.amz + localb.ceR + "," + localb.mSubscribeID + "," + localb.mSubscribeName + "," + localb.aOr + ")");
        }
        localArrayList.add(localb);
        boolean bool = paramString.moveToNext();
        if (bool) {
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MigrateSubscribeDB", 2, "read Subscribe Recent Datas Exception", localException);
        paramString.close();
        continue;
      }
      finally
      {
        paramString.close();
      }
      paramString = localArrayList;
      if (locala == null) {
        break;
      }
      locala.close();
      return localArrayList;
      if (QLog.isColorLevel())
      {
        QLog.d("MigrateSubscribeDB", 2, "getSubscribeRecentDataList select from RecentSubscribeData no data");
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "getSubscribeRecentDataList fail curSubReadInJoy is null");
        }
      }
    }
  }
  
  private void b(List<b> paramList, EntityManager paramEntityManager)
  {
    long l = System.nanoTime();
    if (paramList == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "migrateToCoversationInfo fail subscribeRecentDataList is null");
      }
    }
    label265:
    label340:
    label359:
    do
    {
      return;
      int i = paramList.size();
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "migrateToCoversationInfo subscribeRecentDataList list size: " + i);
      }
      i = 0;
      if (i < paramList.size())
      {
        b localb = (b)paramList.get(i);
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "migrateToCoversationInfo subscribeRecentData: " + localb);
        }
        String str = oak.cu(localb.mSubscribeID);
        ConversationInfo localConversationInfo;
        int j;
        if (!TextUtils.isEmpty(str))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "migrateToCoversationInfo find subscribeID[" + localb.mSubscribeID + "]'s uin: " + str);
          }
          localConversationInfo = new ConversationInfo();
          List localList = paramEntityManager.query(ConversationInfo.class, false, "uin=? and type=?", new String[] { str, String.valueOf(1008) }, null, null, null, null);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder().append("migrateToCoversationInfo dataList size: ");
            if (localList != null)
            {
              j = localList.size();
              QLog.d("MigrateSubscribeDB", 2, j);
            }
          }
          else
          {
            if ((localList == null) || (localList.size() <= 0)) {
              break label359;
            }
            localConversationInfo = (ConversationInfo)localList.get(0);
            localConversationInfo.uin = str;
            localConversationInfo.unreadCount += localb.aOr;
            localConversationInfo.type = 1008;
            paramEntityManager.persistOrReplace(localConversationInfo);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          j = 0;
          break label265;
          localConversationInfo.uin = str;
          localConversationInfo.unreadCount = localb.aOr;
          localConversationInfo.type = 1008;
          break label340;
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "migrateToCoversationInfo we can't subscribeid[" + localb.mSubscribeID + "]'s uin");
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("MigrateSubscribeDB", 2, "migrateToCoversationInfo total cost = " + (System.nanoTime() - l) / 1000000L + " ms ");
  }
  
  private List<String> c(List<b> paramList, String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      String str = ((b)paramList.get(i)).mSubscribeID;
      int j = 0;
      for (;;)
      {
        if (j < paramArrayOfString.length)
        {
          if (paramArrayOfString[j].equals(str)) {
            localArrayList.add(str);
          }
        }
        else
        {
          i += 1;
          break;
        }
        j += 1;
      }
    }
    return localArrayList;
  }
  
  private void c(List<MessageRecord> paramList, EntityManager paramEntityManager)
  {
    long l = System.nanoTime();
    if (paramList == null) {}
    do
    {
      return;
      int i = 0;
      while (i < paramList.size())
      {
        paramEntityManager.persistOrReplace((MessageRecord)paramList.get(i));
        i += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MigrateSubscribeDB", 2, "migrateToMsgRecord total cost = " + (System.nanoTime() - l) / 1000000L + " ms ");
  }
  
  private void d(String paramString, List<b> paramList, List<MessageRecord> paramList1)
  {
    if ((paramString == null) || (paramList == null) || (paramList1 == null) || (paramList1.size() <= 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "updateSubscribeRecentDataList subscribleID is null or subscribeRecentDataList is null or subscribeMsgList is null");
      }
    }
    for (;;)
    {
      return;
      long l = ((MessageRecord)paramList1.get(paramList1.size() - 1)).time;
      int j = paramList.size();
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "updateSubscribeRecentDataList subscribeRecentDataList size: " + j);
      }
      int i = 0;
      while (i < j)
      {
        if (((b)paramList.get(i)).mSubscribeID.equals(paramString))
        {
          paramString = (b)paramList.get(i);
          paramString.amz = l;
          paramList.set(i, paramString);
          return;
        }
        i += 1;
      }
    }
  }
  
  private void dRU()
  {
    Object localObject3;
    HashMap localHashMap;
    Object localObject2;
    int j;
    int i;
    if ((this.GA != null) && (!this.GA.isEmpty()))
    {
      Object localObject1 = this.app;
      localObject1 = BaseApplicationImpl.getApplication().getAllAccounts();
      if (localObject1 != null)
      {
        try
        {
          localObject3 = this.app.getRuntime().getAccount();
          localHashMap = new HashMap(this.GA.size());
          localObject2 = this.GA.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            File localFile = (File)((Iterator)localObject2).next();
            if (localFile != null)
            {
              localHashMap.put(localFile.getName().replace(".db", ""), localFile);
              continue;
              return;
            }
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "sorMainDbFiles error", localException);
          }
        }
        localObject2 = new ArrayList(this.GA.size());
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "sorMainDbFiles currentUin: " + (String)localObject3);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject3 = (File)localHashMap.remove(localObject3);
          if (localObject3 != null) {
            ((List)localObject2).add(localObject3);
          }
        }
        j = localException.size();
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        localObject3 = (SimpleAccount)localException.get(i);
        if ((localObject3 != null) && (((SimpleAccount)localObject3).getUin() != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "sorMainDbFiles uin: " + ((SimpleAccount)localObject3).getUin());
          }
          localObject3 = (File)localHashMap.remove(((SimpleAccount)localObject3).getUin());
          if (localObject3 != null) {
            ((List)localObject2).add(localObject3);
          }
        }
      }
      else
      {
        Iterator localIterator = localHashMap.values().iterator();
        while (localIterator.hasNext()) {
          ((List)localObject2).add((File)localIterator.next());
        }
        this.GA = ((List)localObject2);
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MigrateSubscribeDB", 2, "sorMainDbFiles no account login");
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MigrateSubscribeDB", 2, "sorMainDbFiles mUinMainDBFiles is empty");
        return;
      }
      i += 1;
    }
  }
  
  private void dRV()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("MigrateSubscribeDB", 2, "begin getMigrateDBFiles.");
    }
    long l = System.nanoTime();
    this.GA = new ArrayList();
    this.GB = new ArrayList();
    this.GC = new ArrayList();
    Pattern localPattern1 = Pattern.compile("^\\d+\\.db$");
    Pattern localPattern2 = Pattern.compile("^readinjoy_main_\\d+$");
    Pattern localPattern3 = Pattern.compile("^readinjoy_\\d+\\.db$");
    String str1 = this.app.getFilesDir().getPath();
    str1 = str1.substring(0, str1.lastIndexOf("/")) + "/databases";
    Object localObject1 = new File(str1);
    if (QLog.isColorLevel()) {
      QLog.d("MigrateSubscribeDB", 2, "getMigrateDBFiles we will list files in folder: " + str1);
    }
    localObject1 = ((File)localObject1).listFiles();
    if (localObject1 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "getMigrateDBFiles dbFiles length: " + localObject1.length);
      }
      j = localObject1.length;
      while (i < j)
      {
        localObject2 = localObject1[i];
        str2 = localObject2.getName();
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "getMigrateDBFiles find file[" + str2 + "] in folder[" + str1 + "]");
        }
        if (localPattern1.matcher(str2).find())
        {
          this.GA.add(localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "getMigrateDBFiles mUinMainDBFiles " + localObject2);
          }
        }
        if (localPattern2.matcher(str2).find())
        {
          this.GB.add(localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "getMigrateDBFiles mReadInJoyMainDBFiles " + localObject2);
          }
        }
        if (localPattern3.matcher(str2).find())
        {
          this.GC.add(localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("MigrateSubscribeDB", 2, "getMigrateDBFiles mReadInJoySubDBFiles " + localObject2);
          }
        }
        i += 1;
      }
      Collections.sort(this.GA, new annk(this));
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "doStep get Migrate db files cost = " + (System.nanoTime() - l) / 1000000L + "ms");
      }
    }
    while (!QLog.isColorLevel())
    {
      int j;
      Object localObject2;
      String str2;
      return;
    }
    QLog.d("MigrateSubscribeDB", 2, "getMigrateDBFiles dbFiles is null");
  }
  
  private long hb()
  {
    return anbk.ab(Math.abs(new Random().nextInt()) | 0x0);
  }
  
  public static boolean isNeedUpdate()
  {
    boolean bool2 = false;
    boolean bool1;
    if (!isUpdated)
    {
      String str = BaseApplicationImpl.sApplication.getSharedPreferences("contact_bind_info_global", 0).getString("last_phone_version_popped", "");
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "isNeedUpdate oldVersion: " + str + " : curVersion: " + "3.4.4");
      }
      if (!TextUtils.isEmpty(str)) {
        if (str.startsWith("5.7")) {
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "isNeedUpdate isNeed: " + bool1);
      }
      return bool1;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("MigrateSubscribeDB", 2, "isNeedUpdate oldVersion isn't start with 5.7");
        bool1 = bool2;
        continue;
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("MigrateSubscribeDB", 2, "isNeedUpdate oldVersion is empty");
          bool1 = bool2;
          continue;
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("MigrateSubscribeDB", 2, "isNeedUpdate no need run again");
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  private String r(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    String str;
    do
    {
      return paramObject;
      str = paramObject.toString();
      paramObject = str;
    } while (str.length() <= 0);
    return SecurityUtile.decode(str);
  }
  
  /* Error */
  private String[] s(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 5
    //   9: aload_1
    //   10: ifnonnull +29 -> 39
    //   13: aload 5
    //   15: astore 4
    //   17: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +16 -> 36
    //   23: ldc 54
    //   25: iconst_2
    //   26: ldc_w 959
    //   29: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload 5
    //   34: astore 4
    //   36: aload 4
    //   38: areturn
    //   39: invokestatic 461	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   42: astore 4
    //   44: new 6	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$a
    //   47: dup
    //   48: aload_0
    //   49: aload 4
    //   51: aload_1
    //   52: bipush 80
    //   54: invokespecial 464	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$a:<init>	(Lcom/tencent/mobileqq/startup/step/MigrateSubscribeDB;Landroid/content/Context;Ljava/lang/String;I)V
    //   57: astore 6
    //   59: aload 6
    //   61: invokevirtual 468	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$a:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   64: astore 5
    //   66: aload 5
    //   68: ldc_w 961
    //   71: aconst_null
    //   72: invokevirtual 677	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   75: astore 4
    //   77: aload 4
    //   79: ifnull +364 -> 443
    //   82: aload 4
    //   84: astore 8
    //   86: aload 5
    //   88: astore 9
    //   90: aload 6
    //   92: astore 10
    //   94: aload 4
    //   96: invokeinterface 485 1 0
    //   101: ifeq +194 -> 295
    //   104: aload 4
    //   106: astore 8
    //   108: aload 5
    //   110: astore 9
    //   112: aload 6
    //   114: astore 10
    //   116: aload 4
    //   118: invokeinterface 964 1 0
    //   123: anewarray 107	java/lang/String
    //   126: astore_1
    //   127: iconst_0
    //   128: istore_2
    //   129: aload 4
    //   131: astore 8
    //   133: aload 5
    //   135: astore 9
    //   137: aload 6
    //   139: astore 10
    //   141: aload_1
    //   142: iload_2
    //   143: aload 4
    //   145: iconst_0
    //   146: invokeinterface 507 2 0
    //   151: aastore
    //   152: aload 4
    //   154: astore 8
    //   156: aload 5
    //   158: astore 9
    //   160: aload 6
    //   162: astore 10
    //   164: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   167: ifeq +59 -> 226
    //   170: aload 4
    //   172: astore 8
    //   174: aload 5
    //   176: astore 9
    //   178: aload 6
    //   180: astore 10
    //   182: ldc 54
    //   184: iconst_2
    //   185: new 62	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   192: ldc_w 966
    //   195: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: iload_2
    //   199: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: ldc_w 968
    //   205: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_1
    //   209: iload_2
    //   210: aaload
    //   211: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: ldc_w 879
    //   217: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: iload_2
    //   227: iconst_1
    //   228: iadd
    //   229: istore_2
    //   230: aload 4
    //   232: astore 8
    //   234: aload 5
    //   236: astore 9
    //   238: aload 6
    //   240: astore 10
    //   242: aload 4
    //   244: invokeinterface 594 1 0
    //   249: istore_3
    //   250: iload_3
    //   251: ifne -122 -> 129
    //   254: aload 4
    //   256: ifnull +10 -> 266
    //   259: aload 4
    //   261: invokeinterface 595 1 0
    //   266: aload 5
    //   268: ifnull +8 -> 276
    //   271: aload 5
    //   273: invokevirtual 615	android/database/sqlite/SQLiteDatabase:close	()V
    //   276: aload_1
    //   277: astore 4
    //   279: aload 6
    //   281: ifnull -245 -> 36
    //   284: aload 6
    //   286: invokevirtual 614	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$a:close	()V
    //   289: aload_1
    //   290: areturn
    //   291: astore 4
    //   293: aload_1
    //   294: areturn
    //   295: aload 11
    //   297: astore_1
    //   298: aload 4
    //   300: astore 8
    //   302: aload 5
    //   304: astore 9
    //   306: aload 6
    //   308: astore 10
    //   310: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   313: ifeq -59 -> 254
    //   316: aload 4
    //   318: astore 8
    //   320: aload 5
    //   322: astore 9
    //   324: aload 6
    //   326: astore 10
    //   328: ldc 54
    //   330: iconst_2
    //   331: ldc_w 970
    //   334: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   337: aload 11
    //   339: astore_1
    //   340: goto -86 -> 254
    //   343: astore_1
    //   344: aload 4
    //   346: astore 8
    //   348: aload 5
    //   350: astore 9
    //   352: aload 6
    //   354: astore 10
    //   356: aload_1
    //   357: invokevirtual 157	java/lang/Exception:printStackTrace	()V
    //   360: aload 4
    //   362: astore 8
    //   364: aload 5
    //   366: astore 9
    //   368: aload 6
    //   370: astore 10
    //   372: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   375: ifeq +25 -> 400
    //   378: aload 4
    //   380: astore 8
    //   382: aload 5
    //   384: astore 9
    //   386: aload 6
    //   388: astore 10
    //   390: ldc 54
    //   392: iconst_2
    //   393: ldc_w 972
    //   396: aload_1
    //   397: invokestatic 381	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   400: aload 4
    //   402: ifnull +10 -> 412
    //   405: aload 4
    //   407: invokeinterface 595 1 0
    //   412: aload 5
    //   414: ifnull +8 -> 422
    //   417: aload 5
    //   419: invokevirtual 615	android/database/sqlite/SQLiteDatabase:close	()V
    //   422: aload 7
    //   424: astore 4
    //   426: aload 6
    //   428: ifnull -392 -> 36
    //   431: aload 6
    //   433: invokevirtual 614	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$a:close	()V
    //   436: aload 7
    //   438: areturn
    //   439: astore_1
    //   440: aload 7
    //   442: areturn
    //   443: aload 11
    //   445: astore_1
    //   446: aload 4
    //   448: astore 8
    //   450: aload 5
    //   452: astore 9
    //   454: aload 6
    //   456: astore 10
    //   458: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   461: ifeq -207 -> 254
    //   464: aload 4
    //   466: astore 8
    //   468: aload 5
    //   470: astore 9
    //   472: aload 6
    //   474: astore 10
    //   476: ldc 54
    //   478: iconst_2
    //   479: ldc_w 974
    //   482: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   485: aload 11
    //   487: astore_1
    //   488: goto -234 -> 254
    //   491: astore_1
    //   492: aload 10
    //   494: astore 6
    //   496: aload 9
    //   498: astore 5
    //   500: aload 8
    //   502: astore 4
    //   504: aload 4
    //   506: ifnull +10 -> 516
    //   509: aload 4
    //   511: invokeinterface 595 1 0
    //   516: aload 5
    //   518: ifnull +8 -> 526
    //   521: aload 5
    //   523: invokevirtual 615	android/database/sqlite/SQLiteDatabase:close	()V
    //   526: aload 6
    //   528: ifnull +8 -> 536
    //   531: aload 6
    //   533: invokevirtual 614	com/tencent/mobileqq/startup/step/MigrateSubscribeDB$a:close	()V
    //   536: aload_1
    //   537: athrow
    //   538: astore 4
    //   540: goto -274 -> 266
    //   543: astore 4
    //   545: goto -269 -> 276
    //   548: astore_1
    //   549: goto -137 -> 412
    //   552: astore_1
    //   553: goto -131 -> 422
    //   556: astore 4
    //   558: goto -42 -> 516
    //   561: astore 4
    //   563: goto -37 -> 526
    //   566: astore 4
    //   568: goto -32 -> 536
    //   571: astore_1
    //   572: aconst_null
    //   573: astore 4
    //   575: aconst_null
    //   576: astore 5
    //   578: aconst_null
    //   579: astore 6
    //   581: goto -77 -> 504
    //   584: astore_1
    //   585: aconst_null
    //   586: astore 4
    //   588: aconst_null
    //   589: astore 5
    //   591: goto -87 -> 504
    //   594: astore_1
    //   595: aconst_null
    //   596: astore 4
    //   598: goto -94 -> 504
    //   601: astore_1
    //   602: aconst_null
    //   603: astore 4
    //   605: aconst_null
    //   606: astore 5
    //   608: aconst_null
    //   609: astore 6
    //   611: goto -267 -> 344
    //   614: astore_1
    //   615: aconst_null
    //   616: astore 4
    //   618: aconst_null
    //   619: astore 5
    //   621: goto -277 -> 344
    //   624: astore_1
    //   625: aconst_null
    //   626: astore 4
    //   628: goto -284 -> 344
    //   631: astore 8
    //   633: aload_1
    //   634: astore 7
    //   636: aload 8
    //   638: astore_1
    //   639: goto -295 -> 344
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	642	0	this	MigrateSubscribeDB
    //   0	642	1	paramString	String
    //   128	102	2	i	int
    //   249	2	3	bool	boolean
    //   15	263	4	localObject1	Object
    //   291	115	4	localException1	Exception
    //   424	86	4	localObject2	Object
    //   538	1	4	localException2	Exception
    //   543	1	4	localException3	Exception
    //   556	1	4	localException4	Exception
    //   561	1	4	localException5	Exception
    //   566	1	4	localException6	Exception
    //   573	54	4	localObject3	Object
    //   7	613	5	localObject4	Object
    //   57	553	6	localObject5	Object
    //   4	631	7	localObject6	Object
    //   84	417	8	localObject7	Object
    //   631	6	8	localException7	Exception
    //   88	409	9	localObject8	Object
    //   92	401	10	localObject9	Object
    //   1	485	11	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   284	289	291	java/lang/Exception
    //   94	104	343	java/lang/Exception
    //   116	127	343	java/lang/Exception
    //   310	316	343	java/lang/Exception
    //   328	337	343	java/lang/Exception
    //   458	464	343	java/lang/Exception
    //   476	485	343	java/lang/Exception
    //   431	436	439	java/lang/Exception
    //   94	104	491	finally
    //   116	127	491	finally
    //   141	152	491	finally
    //   164	170	491	finally
    //   182	226	491	finally
    //   242	250	491	finally
    //   310	316	491	finally
    //   328	337	491	finally
    //   356	360	491	finally
    //   372	378	491	finally
    //   390	400	491	finally
    //   458	464	491	finally
    //   476	485	491	finally
    //   259	266	538	java/lang/Exception
    //   271	276	543	java/lang/Exception
    //   405	412	548	java/lang/Exception
    //   417	422	552	java/lang/Exception
    //   509	516	556	java/lang/Exception
    //   521	526	561	java/lang/Exception
    //   531	536	566	java/lang/Exception
    //   44	59	571	finally
    //   59	66	584	finally
    //   66	77	594	finally
    //   44	59	601	java/lang/Exception
    //   59	66	614	java/lang/Exception
    //   66	77	624	java/lang/Exception
    //   141	152	631	java/lang/Exception
    //   164	170	631	java/lang/Exception
    //   182	226	631	java/lang/Exception
    //   242	250	631	java/lang/Exception
  }
  
  protected boolean doStep()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MigrateSubscribeDB", 2, "begin do Step for MigrateSubscribeDB." + BaseApplicationImpl.sProcessId);
    }
    if (!isNeedUpdate())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "No need do update action");
      }
      return super.doStep();
    }
    this.app = BaseApplicationImpl.sApplication;
    if (this.app == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MigrateSubscribeDB", 2, "doStep fail app is null");
      }
      return super.doStep();
    }
    isUpdated = true;
    this.mTimeOut = 40000;
    long l = System.nanoTime();
    dRV();
    Iterator localIterator;
    if (!this.GA.isEmpty())
    {
      dRU();
      localIterator = this.GA.iterator();
    }
    for (;;)
    {
      File localFile;
      if (localIterator.hasNext())
      {
        localFile = (File)localIterator.next();
        if (this.mRunning) {
          break label245;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "doStep foreach mUinMainDBFiles，but timeout！");
        }
      }
      label245:
      while (!D(localFile))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MigrateSubscribeDB", 2, "doStep Migrate subscribe db total cost = " + (System.nanoTime() - l) / 1000000L + " ms  and Migrate " + this.amy + " times ");
        }
        return super.doStep();
      }
      this.amy += 1L;
    }
  }
  
  class a
    extends SQLiteOpenHelper
  {
    public a(Context paramContext, String paramString, int paramInt)
    {
      super(paramString, null, paramInt);
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase) {}
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  }
  
  class b
  {
    long Ix;
    String Ul;
    int aOr;
    long amz;
    String ceP;
    String ceQ;
    String ceR;
    long mLastMsgTime;
    String mSubscribeID;
    String mSubscribeName;
    
    private b() {}
    
    public String toString()
    {
      return "mSubscribeID: " + this.mSubscribeID + " | mSubscribeName: " + this.mSubscribeName + " | mLastMsg: " + this.Ul + " | mLastMsgTime: " + this.mLastMsgTime + " | mLastMsgID: " + this.Ix + " | mLastReorderTime: " + this.amz + " | mDraft: " + this.ceP + " | mDraftTime: " + this.ceQ + " | mSubscribeHeadUrl: " + this.ceR + " | mUnreadCount: " + this.aOr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.MigrateSubscribeDB
 * JD-Core Version:    0.7.0.1
 */