package com.tencent.qqmail.utilities.exception;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.view.WindowManager.BadTokenException;
import com.tencent.moai.database.sqlite.SQLiteException;
import com.tencent.moai.database.sqlite.SQLiteFullException;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.launcher.desktop.LauncherActivity;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.keepalive.KeepAliveManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.patch.QMPatchManager;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushService;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushService.PushStartUpReason;
import com.tencent.qqmail.utilities.schedule.QMScheduledJobs.FromType;
import com.tencent.qqmail.utilities.services.QMNotifyService;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.concurrent.TimeoutException;
import moai.oss.KvHelper;

public class QMUncaughtExceptionHandler
  implements Thread.UncaughtExceptionHandler
{
  private static final String KEY_PATCH_CRASH_LAST_TIME_PREFIX = "patch_crash_last_time_";
  private static final String KEY_PATCH_CRASH_PREFIX = "patch_crash_";
  private static final String KEY_REBOOT = "reboot";
  private static final int MAX_FILE_COUNT = 10;
  private static final int MAX_LOGCAT_COUNT = 2000;
  private static final String PROCESS_SUFFIX;
  private static final int REBOOT_LIMIT = 2;
  private static final String SP_NAME;
  private static final String TAG = "QMUncaughtExceptionHandler";
  private static Thread.UncaughtExceptionHandler sDefaultHandler;
  private static Thread.UncaughtExceptionHandler sInstance;
  
  static
  {
    String str;
    if (QMApplicationContext.sharedInstance().isMainProcess()) {
      str = "main";
    }
    for (;;)
    {
      PROCESS_SUFFIX = str;
      SP_NAME = "uncaught_info_" + PROCESS_SUFFIX;
      sDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
      sInstance = new QMUncaughtExceptionHandler();
      return;
      if (QMApplicationContext.sharedInstance().isPushProcess()) {
        str = "push";
      } else if (QMApplicationContext.sharedInstance().isToolsProcess()) {
        str = "tools";
      } else {
        str = "other";
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  private static void alarm(PendingIntent paramPendingIntent)
  {
    AlarmManager localAlarmManager = (AlarmManager)QMApplicationContext.sharedInstance().getSystemService("alarm");
    int i = Build.VERSION.SDK_INT;
    if (i < 19)
    {
      localAlarmManager.set(2, 0L, paramPendingIntent);
      return;
    }
    if (i < 23)
    {
      localAlarmManager.setExact(2, 0L, paramPendingIntent);
      return;
    }
    localAlarmManager.setExactAndAllowWhileIdle(2, 0L, paramPendingIntent);
  }
  
  private static boolean canReboot()
  {
    int i = SPManager.getSp(SP_NAME).getInt("reboot", 0);
    SharedPreferences.Editor localEditor = SPManager.getEditor(SP_NAME);
    i += 1;
    localEditor.putInt("reboot", i).apply();
    if (i > 2)
    {
      QMLog.log(6, "QMUncaughtExceptionHandler", "crash over " + i + " times, abort reboot!!");
      return false;
    }
    return true;
  }
  
  /* Error */
  public static void dumpCrashLog(boolean paramBoolean, Thread paramThread, Throwable paramThrowable)
  {
    // Byte code:
    //   0: invokestatic 171	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore 4
    //   5: iload_0
    //   6: ifeq +269 -> 275
    //   9: ldc 173
    //   11: astore 8
    //   13: bipush 7
    //   15: ldc 28
    //   17: new 49	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   24: aload 8
    //   26: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 175
    //   31: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokestatic 181	android/os/Process:myPid	()I
    //   37: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: ldc 183
    //   42: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_1
    //   46: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   49: ldc 188
    //   51: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokestatic 39	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   57: ldc 190
    //   59: invokevirtual 100	com/tencent/qqmail/QMApplicationContext:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   62: checkcast 192	android/view/accessibility/AccessibilityManager
    //   65: invokevirtual 195	android/view/accessibility/AccessibilityManager:isEnabled	()Z
    //   68: invokevirtual 198	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   71: ldc 200
    //   73: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokestatic 205	com/tencent/qqmail/utilities/AppStatusUtil:isAppOnForeground	()Z
    //   79: invokevirtual 198	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   82: ldc 207
    //   84: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokestatic 210	com/tencent/qqmail/utilities/AppStatusUtil:isApplicationActive	()Z
    //   90: invokevirtual 198	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   93: ldc 212
    //   95: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokestatic 217	com/tencent/qqmail/marcos/AppConfig:getSystemVersion	()Ljava/lang/String;
    //   101: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc 219
    //   106: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokestatic 222	com/tencent/qqmail/marcos/AppConfig:getCodeVersion	()Ljava/lang/String;
    //   112: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: aload_2
    //   119: invokestatic 225	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   122: bipush 7
    //   124: ldc 28
    //   126: new 49	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   133: ldc 227
    //   135: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: iconst_1
    //   139: invokestatic 232	com/tencent/qqmail/utilities/thread/Threads:dumpAllThread	(Z)Ljava/lang/StringBuilder;
    //   142: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 157	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   151: bipush 7
    //   153: ldc 28
    //   155: invokestatic 238	com/tencent/qqmail/QMActivityManager:shareInstance	()Lcom/tencent/qqmail/QMActivityManager;
    //   158: aload 8
    //   160: invokevirtual 242	com/tencent/qqmail/QMActivityManager:getActivitiesStack	(Ljava/lang/String;)Ljava/lang/String;
    //   163: invokestatic 157	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   166: invokestatic 245	com/tencent/qqmail/utilities/log/QMLog:flush	()V
    //   169: new 49	java/lang/StringBuilder
    //   172: dup
    //   173: sipush 128
    //   176: invokespecial 248	java/lang/StringBuilder:<init>	(I)V
    //   179: astore 9
    //   181: aload_2
    //   182: ifnull +208 -> 390
    //   185: iload_0
    //   186: ifeq +998 -> 1184
    //   189: aload_2
    //   190: invokevirtual 252	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   193: astore 8
    //   195: aload 8
    //   197: ifnull +95 -> 292
    //   200: aload 8
    //   202: invokevirtual 256	java/lang/Throwable:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   205: astore 10
    //   207: aload 10
    //   209: ifnull +83 -> 292
    //   212: aload 10
    //   214: arraylength
    //   215: ifle +77 -> 292
    //   218: aload 9
    //   220: aload 8
    //   222: invokevirtual 257	java/lang/Throwable:toString	()Ljava/lang/String;
    //   225: ldc_w 259
    //   228: ldc_w 261
    //   231: invokevirtual 267	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   234: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: iconst_0
    //   239: istore_3
    //   240: iload_3
    //   241: aload 10
    //   243: arraylength
    //   244: bipush 10
    //   246: invokestatic 273	java/lang/Math:min	(II)I
    //   249: if_icmpge +34 -> 283
    //   252: aload 9
    //   254: ldc_w 275
    //   257: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload 10
    //   262: iload_3
    //   263: aaload
    //   264: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: iload_3
    //   269: iconst_1
    //   270: iadd
    //   271: istore_3
    //   272: goto -32 -> 240
    //   275: ldc_w 277
    //   278: astore 8
    //   280: goto -267 -> 13
    //   283: aload 9
    //   285: ldc_w 259
    //   288: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload 8
    //   294: ifnull +96 -> 390
    //   297: aload 8
    //   299: invokevirtual 252	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   302: ifnull +13 -> 315
    //   305: aload 8
    //   307: invokevirtual 252	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   310: astore 8
    //   312: goto -15 -> 297
    //   315: aload 8
    //   317: invokevirtual 256	java/lang/Throwable:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   320: astore 10
    //   322: aload 10
    //   324: ifnull +66 -> 390
    //   327: aload 10
    //   329: arraylength
    //   330: ifle +60 -> 390
    //   333: aload 9
    //   335: aload 8
    //   337: invokevirtual 257	java/lang/Throwable:toString	()Ljava/lang/String;
    //   340: ldc_w 259
    //   343: ldc_w 261
    //   346: invokevirtual 267	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   349: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: iconst_0
    //   354: istore_3
    //   355: iload_3
    //   356: aload 10
    //   358: arraylength
    //   359: bipush 10
    //   361: invokestatic 273	java/lang/Math:min	(II)I
    //   364: if_icmpge +26 -> 390
    //   367: aload 9
    //   369: ldc_w 275
    //   372: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload 10
    //   377: iload_3
    //   378: aaload
    //   379: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: iload_3
    //   384: iconst_1
    //   385: iadd
    //   386: istore_3
    //   387: goto -32 -> 355
    //   390: bipush 7
    //   392: anewarray 4	java/lang/Object
    //   395: dup
    //   396: iconst_0
    //   397: iload_0
    //   398: invokestatic 283	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   401: aastore
    //   402: dup
    //   403: iconst_1
    //   404: invokestatic 39	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   407: invokevirtual 43	com/tencent/qqmail/QMApplicationContext:isMainProcess	()Z
    //   410: invokestatic 283	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   413: aastore
    //   414: dup
    //   415: iconst_2
    //   416: aload_1
    //   417: aastore
    //   418: dup
    //   419: iconst_3
    //   420: invokestatic 205	com/tencent/qqmail/utilities/AppStatusUtil:isAppOnForeground	()Z
    //   423: invokestatic 283	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   426: aastore
    //   427: dup
    //   428: iconst_4
    //   429: invokestatic 210	com/tencent/qqmail/utilities/AppStatusUtil:isApplicationActive	()Z
    //   432: invokestatic 283	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   435: aastore
    //   436: dup
    //   437: iconst_5
    //   438: invokestatic 238	com/tencent/qqmail/QMActivityManager:shareInstance	()Lcom/tencent/qqmail/QMActivityManager;
    //   441: invokevirtual 287	com/tencent/qqmail/QMActivityManager:getVisiblePage	()Ljava/lang/Object;
    //   444: aastore
    //   445: dup
    //   446: bipush 6
    //   448: aload 9
    //   450: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: aastore
    //   454: invokestatic 293	moai/oss/OssHelper:crash	([Ljava/lang/Object;)V
    //   457: ldc2_w 294
    //   460: invokestatic 299	android/os/SystemClock:sleep	(J)V
    //   463: new 301	java/text/SimpleDateFormat
    //   466: dup
    //   467: ldc_w 303
    //   470: invokestatic 309	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   473: invokespecial 312	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   476: new 314	java/util/Date
    //   479: dup
    //   480: invokespecial 315	java/util/Date:<init>	()V
    //   483: invokevirtual 319	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   486: astore 9
    //   488: invokestatic 39	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   491: astore_1
    //   492: aload_1
    //   493: invokevirtual 43	com/tencent/qqmail/QMApplicationContext:isMainProcess	()Z
    //   496: ifeq +257 -> 753
    //   499: ldc 45
    //   501: astore_1
    //   502: iload_0
    //   503: ifeq +282 -> 785
    //   506: ldc_w 321
    //   509: astore 8
    //   511: new 323	java/io/File
    //   514: dup
    //   515: ldc_w 325
    //   518: iconst_5
    //   519: anewarray 4	java/lang/Object
    //   522: dup
    //   523: iconst_0
    //   524: invokestatic 331	com/tencent/qqmail/utilities/log/LogPathManager:getInstance	()Lcom/tencent/qqmail/utilities/log/LogPathManager;
    //   527: invokevirtual 334	com/tencent/qqmail/utilities/log/LogPathManager:getTombstoneDirPath	()Ljava/lang/String;
    //   530: aastore
    //   531: dup
    //   532: iconst_1
    //   533: ldc_w 336
    //   536: aastore
    //   537: dup
    //   538: iconst_2
    //   539: aload 9
    //   541: aastore
    //   542: dup
    //   543: iconst_3
    //   544: aload_1
    //   545: aastore
    //   546: dup
    //   547: iconst_4
    //   548: aload 8
    //   550: aastore
    //   551: invokestatic 339	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   554: invokespecial 342	java/io/File:<init>	(Ljava/lang/String;)V
    //   557: astore_1
    //   558: new 344	java/io/BufferedWriter
    //   561: dup
    //   562: new 346	java/io/FileWriter
    //   565: dup
    //   566: aload_1
    //   567: invokespecial 349	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   570: invokespecial 352	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   573: astore 8
    //   575: aload 8
    //   577: astore_1
    //   578: aload 8
    //   580: aload_2
    //   581: invokestatic 358	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   584: invokevirtual 361	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   587: aload 8
    //   589: astore_1
    //   590: aload 8
    //   592: invokevirtual 362	java/io/BufferedWriter:flush	()V
    //   595: aload 8
    //   597: astore_1
    //   598: invokestatic 171	android/os/SystemClock:elapsedRealtime	()J
    //   601: lstore 6
    //   603: aload 8
    //   605: astore_1
    //   606: aload 8
    //   608: ldc_w 364
    //   611: invokevirtual 361	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   614: aload 8
    //   616: astore_1
    //   617: iconst_0
    //   618: bipush 100
    //   620: invokestatic 370	com/tencent/qqmail/utilities/log/FeedbackManager:getQmLog	(ZI)Ljava/util/List;
    //   623: astore_2
    //   624: aload_2
    //   625: ifnull +168 -> 793
    //   628: aload 8
    //   630: astore_1
    //   631: aload_2
    //   632: invokeinterface 376 1 0
    //   637: astore_2
    //   638: aload 8
    //   640: astore_1
    //   641: aload_2
    //   642: invokeinterface 381 1 0
    //   647: ifeq +146 -> 793
    //   650: aload 8
    //   652: astore_1
    //   653: aload 8
    //   655: aload_2
    //   656: invokeinterface 384 1 0
    //   661: checkcast 263	java/lang/String
    //   664: invokevirtual 361	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   667: aload 8
    //   669: astore_1
    //   670: aload 8
    //   672: invokevirtual 387	java/io/BufferedWriter:newLine	()V
    //   675: goto -37 -> 638
    //   678: astore_1
    //   679: aload 8
    //   681: astore_2
    //   682: aload_1
    //   683: astore 8
    //   685: aload_2
    //   686: astore_1
    //   687: bipush 7
    //   689: ldc 28
    //   691: ldc_w 389
    //   694: aload 8
    //   696: invokestatic 225	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   699: aload_2
    //   700: invokevirtual 392	java/io/BufferedWriter:close	()V
    //   703: iconst_4
    //   704: ldc 28
    //   706: new 49	java/lang/StringBuilder
    //   709: dup
    //   710: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   713: ldc_w 394
    //   716: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: invokestatic 171	android/os/SystemClock:elapsedRealtime	()J
    //   722: lload 4
    //   724: lsub
    //   725: invokevirtual 397	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   728: ldc_w 399
    //   731: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   737: invokestatic 157	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   740: invokestatic 245	com/tencent/qqmail/utilities/log/QMLog:flush	()V
    //   743: invokestatic 404	com/tencent/qqmail/utilities/osslog/QMOssClient:getInstance	()Lcom/tencent/qqmail/utilities/osslog/QMOssClient;
    //   746: invokevirtual 405	com/tencent/qqmail/utilities/osslog/QMOssClient:flush	()V
    //   749: invokestatic 408	com/tencent/qqmail/protocol/DataCollector:flush	()V
    //   752: return
    //   753: aload_1
    //   754: invokevirtual 78	com/tencent/qqmail/QMApplicationContext:isPushProcess	()Z
    //   757: ifeq +9 -> 766
    //   760: ldc 80
    //   762: astore_1
    //   763: goto -261 -> 502
    //   766: aload_1
    //   767: invokevirtual 83	com/tencent/qqmail/QMApplicationContext:isToolsProcess	()Z
    //   770: ifeq +9 -> 779
    //   773: ldc 85
    //   775: astore_1
    //   776: goto -274 -> 502
    //   779: ldc 87
    //   781: astore_1
    //   782: goto -280 -> 502
    //   785: ldc_w 410
    //   788: astore 8
    //   790: goto -279 -> 511
    //   793: aload 8
    //   795: astore_1
    //   796: aload 8
    //   798: invokevirtual 362	java/io/BufferedWriter:flush	()V
    //   801: aload 8
    //   803: astore_1
    //   804: aload 8
    //   806: new 49	java/lang/StringBuilder
    //   809: dup
    //   810: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   813: ldc_w 412
    //   816: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: invokestatic 171	android/os/SystemClock:elapsedRealtime	()J
    //   822: lload 6
    //   824: lsub
    //   825: invokevirtual 397	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   828: ldc_w 414
    //   831: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   837: invokevirtual 361	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   840: aload 8
    //   842: astore_1
    //   843: invokestatic 171	android/os/SystemClock:elapsedRealtime	()J
    //   846: lstore 6
    //   848: aload 8
    //   850: astore_1
    //   851: aload 8
    //   853: ldc_w 416
    //   856: invokevirtual 361	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   859: aload 8
    //   861: astore_1
    //   862: new 418	java/io/BufferedReader
    //   865: dup
    //   866: new 420	java/io/InputStreamReader
    //   869: dup
    //   870: invokestatic 426	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   873: ldc_w 428
    //   876: invokevirtual 432	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   879: invokevirtual 438	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   882: invokespecial 441	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   885: invokespecial 444	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   888: astore_2
    //   889: aload 8
    //   891: astore_1
    //   892: aload_2
    //   893: invokevirtual 447	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   896: astore 9
    //   898: aload 9
    //   900: ifnull +25 -> 925
    //   903: aload 8
    //   905: astore_1
    //   906: aload 8
    //   908: aload 9
    //   910: invokevirtual 361	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   913: aload 8
    //   915: astore_1
    //   916: aload 8
    //   918: invokevirtual 387	java/io/BufferedWriter:newLine	()V
    //   921: goto -32 -> 889
    //   924: astore_1
    //   925: aload 8
    //   927: astore_1
    //   928: aload 8
    //   930: invokevirtual 362	java/io/BufferedWriter:flush	()V
    //   933: aload 8
    //   935: astore_1
    //   936: aload 8
    //   938: new 49	java/lang/StringBuilder
    //   941: dup
    //   942: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   945: ldc_w 449
    //   948: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   951: invokestatic 171	android/os/SystemClock:elapsedRealtime	()J
    //   954: lload 6
    //   956: lsub
    //   957: invokevirtual 397	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   960: ldc_w 414
    //   963: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   969: invokevirtual 361	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   972: aload 8
    //   974: astore_1
    //   975: invokestatic 171	android/os/SystemClock:elapsedRealtime	()J
    //   978: lstore 6
    //   980: aload 8
    //   982: astore_1
    //   983: aload 8
    //   985: ldc_w 451
    //   988: invokevirtual 361	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   991: aload 8
    //   993: astore_1
    //   994: new 453	android/util/PrintWriterPrinter
    //   997: dup
    //   998: new 455	java/io/PrintWriter
    //   1001: dup
    //   1002: aload 8
    //   1004: iconst_1
    //   1005: invokespecial 458	java/io/PrintWriter:<init>	(Ljava/io/Writer;Z)V
    //   1008: invokespecial 461	android/util/PrintWriterPrinter:<init>	(Ljava/io/PrintWriter;)V
    //   1011: iconst_1
    //   1012: anewarray 263	java/lang/String
    //   1015: dup
    //   1016: iconst_0
    //   1017: ldc_w 463
    //   1020: aastore
    //   1021: invokestatic 469	com/tencent/moai/database/sqlite/SQLiteDebug:dump	(Landroid/util/Printer;[Ljava/lang/String;)V
    //   1024: aload 8
    //   1026: astore_1
    //   1027: aload 8
    //   1029: new 49	java/lang/StringBuilder
    //   1032: dup
    //   1033: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   1036: ldc_w 471
    //   1039: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: invokestatic 171	android/os/SystemClock:elapsedRealtime	()J
    //   1045: lload 6
    //   1047: lsub
    //   1048: invokevirtual 397	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1051: ldc_w 414
    //   1054: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1060: invokevirtual 361	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   1063: aload 8
    //   1065: astore_1
    //   1066: invokestatic 171	android/os/SystemClock:elapsedRealtime	()J
    //   1069: lstore 6
    //   1071: aload 8
    //   1073: astore_1
    //   1074: aload 8
    //   1076: ldc_w 473
    //   1079: invokevirtual 361	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   1082: aload 8
    //   1084: astore_1
    //   1085: aload 8
    //   1087: iconst_0
    //   1088: invokestatic 232	com/tencent/qqmail/utilities/thread/Threads:dumpAllThread	(Z)Ljava/lang/StringBuilder;
    //   1091: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1094: invokevirtual 361	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   1097: aload 8
    //   1099: astore_1
    //   1100: aload 8
    //   1102: invokevirtual 362	java/io/BufferedWriter:flush	()V
    //   1105: aload 8
    //   1107: astore_1
    //   1108: aload 8
    //   1110: new 49	java/lang/StringBuilder
    //   1113: dup
    //   1114: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   1117: ldc_w 475
    //   1120: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1123: invokestatic 171	android/os/SystemClock:elapsedRealtime	()J
    //   1126: lload 6
    //   1128: lsub
    //   1129: invokevirtual 397	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1132: ldc_w 414
    //   1135: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1138: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1141: invokevirtual 361	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   1144: aload 8
    //   1146: invokevirtual 392	java/io/BufferedWriter:close	()V
    //   1149: goto -446 -> 703
    //   1152: astore_1
    //   1153: goto -450 -> 703
    //   1156: astore_2
    //   1157: aconst_null
    //   1158: astore_1
    //   1159: aload_1
    //   1160: invokevirtual 392	java/io/BufferedWriter:close	()V
    //   1163: aload_2
    //   1164: athrow
    //   1165: astore_1
    //   1166: goto -463 -> 703
    //   1169: astore_1
    //   1170: goto -7 -> 1163
    //   1173: astore_2
    //   1174: goto -15 -> 1159
    //   1177: astore 8
    //   1179: aconst_null
    //   1180: astore_2
    //   1181: goto -496 -> 685
    //   1184: aload_2
    //   1185: astore 8
    //   1187: goto -895 -> 292
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1190	0	paramBoolean	boolean
    //   0	1190	1	paramThread	Thread
    //   0	1190	2	paramThrowable	Throwable
    //   239	148	3	i	int
    //   3	720	4	l1	long
    //   601	526	6	l2	long
    //   11	1134	8	localObject1	Object
    //   1177	1	8	localThrowable1	Throwable
    //   1185	1	8	localThrowable2	Throwable
    //   179	730	9	localObject2	Object
    //   205	171	10	arrayOfStackTraceElement	java.lang.StackTraceElement[]
    // Exception table:
    //   from	to	target	type
    //   578	587	678	java/lang/Throwable
    //   590	595	678	java/lang/Throwable
    //   598	603	678	java/lang/Throwable
    //   606	614	678	java/lang/Throwable
    //   617	624	678	java/lang/Throwable
    //   631	638	678	java/lang/Throwable
    //   641	650	678	java/lang/Throwable
    //   653	667	678	java/lang/Throwable
    //   670	675	678	java/lang/Throwable
    //   796	801	678	java/lang/Throwable
    //   804	840	678	java/lang/Throwable
    //   843	848	678	java/lang/Throwable
    //   851	859	678	java/lang/Throwable
    //   862	889	678	java/lang/Throwable
    //   892	898	678	java/lang/Throwable
    //   906	913	678	java/lang/Throwable
    //   916	921	678	java/lang/Throwable
    //   928	933	678	java/lang/Throwable
    //   936	972	678	java/lang/Throwable
    //   975	980	678	java/lang/Throwable
    //   983	991	678	java/lang/Throwable
    //   994	1024	678	java/lang/Throwable
    //   1027	1063	678	java/lang/Throwable
    //   1066	1071	678	java/lang/Throwable
    //   1074	1082	678	java/lang/Throwable
    //   1085	1097	678	java/lang/Throwable
    //   1100	1105	678	java/lang/Throwable
    //   1108	1144	678	java/lang/Throwable
    //   862	889	924	java/io/IOException
    //   892	898	924	java/io/IOException
    //   906	913	924	java/io/IOException
    //   916	921	924	java/io/IOException
    //   1144	1149	1152	java/lang/Exception
    //   558	575	1156	finally
    //   699	703	1165	java/lang/Exception
    //   1159	1163	1169	java/lang/Exception
    //   578	587	1173	finally
    //   590	595	1173	finally
    //   598	603	1173	finally
    //   606	614	1173	finally
    //   617	624	1173	finally
    //   631	638	1173	finally
    //   641	650	1173	finally
    //   653	667	1173	finally
    //   670	675	1173	finally
    //   687	699	1173	finally
    //   796	801	1173	finally
    //   804	840	1173	finally
    //   843	848	1173	finally
    //   851	859	1173	finally
    //   862	889	1173	finally
    //   892	898	1173	finally
    //   906	913	1173	finally
    //   916	921	1173	finally
    //   928	933	1173	finally
    //   936	972	1173	finally
    //   975	980	1173	finally
    //   983	991	1173	finally
    //   994	1024	1173	finally
    //   1027	1063	1173	finally
    //   1066	1071	1173	finally
    //   1074	1082	1173	finally
    //   1085	1097	1173	finally
    //   1100	1105	1173	finally
    //   1108	1144	1173	finally
    //   558	575	1177	java/lang/Throwable
  }
  
  public static void handlePatchCrash(boolean paramBoolean)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (QMPatchManager.isPatched())
    {
      localObject = new StringBuilder().append("patch_crash_");
      if (!paramBoolean) {
        break label145;
      }
      str = "native_";
      localObject = str + AppConfig.getPatchVersionCode();
      localStringBuilder = new StringBuilder().append("patch_crash_last_time_");
      if (!paramBoolean) {
        break label153;
      }
    }
    int i;
    label145:
    label153:
    for (String str = "native_";; str = "java_")
    {
      str = str + AppConfig.getPatchVersionCode();
      i = SPManager.getSp(SP_NAME).getInt((String)localObject, 0);
      long l = SPManager.getSp(SP_NAME).getLong(str, 0L);
      if (System.currentTimeMillis() - l > 86400000L) {
        break label194;
      }
      if (i < 3) {
        break label161;
      }
      QMPatchManager.revertPatch();
      KvHelper.hotfixCrashRevert(new double[0]);
      return;
      str = "java_";
      break;
    }
    label161:
    SPManager.getEditor(SP_NAME).putInt((String)localObject, i + 1).putLong(str, System.currentTimeMillis()).commit();
    return;
    label194:
    SPManager.getEditor(SP_NAME).putInt((String)localObject, 1).putLong(str, System.currentTimeMillis()).commit();
  }
  
  private boolean handleSpecialException(Throwable paramThrowable, boolean paramBoolean)
  {
    if (isSQLiteFullException(paramThrowable)) {}
    while ((isBadWindowToken(paramThrowable)) || (isGCTimeout(paramThrowable)) || (isOOM(paramThrowable)) || ((!paramBoolean) && (isInputChannel(paramThrowable))) || ((!paramBoolean) && (isCheckStateLoss(paramThrowable))) || (isJobScheduler(paramThrowable)) || (isLBE(paramThrowable)) || (isNativeMethodNotFound(paramThrowable)) || (isMessageNPE(paramThrowable)) || (isRemoteServiceException(paramThrowable)) || (isHwPushServiceNotRegistered(paramThrowable))) {
      return true;
    }
    return false;
  }
  
  public static void init()
  {
    Thread.setDefaultUncaughtExceptionHandler(sInstance);
    Threads.runInBackground(new QMUncaughtExceptionHandler.1(), 10000L);
  }
  
  private boolean isBadWindowToken(Throwable paramThrowable)
  {
    while (paramThrowable != null)
    {
      if ((paramThrowable instanceof WindowManager.BadTokenException)) {
        return true;
      }
      paramThrowable = paramThrowable.getCause();
    }
    return false;
  }
  
  private boolean isCheckStateLoss(Throwable paramThrowable)
  {
    while (paramThrowable != null)
    {
      String str = paramThrowable.getMessage();
      if (((paramThrowable instanceof IllegalStateException)) && (!TextUtils.isEmpty(str)) && (str.contains("Can not perform this action after onSaveInstanceState"))) {
        return true;
      }
      paramThrowable = paramThrowable.getCause();
    }
    return false;
  }
  
  private boolean isGCTimeout(Throwable paramThrowable)
  {
    while (paramThrowable != null)
    {
      if ((paramThrowable instanceof TimeoutException)) {
        return true;
      }
      paramThrowable = paramThrowable.getCause();
    }
    return false;
  }
  
  private boolean isHwPushServiceNotRegistered(Throwable paramThrowable)
  {
    while (paramThrowable != null)
    {
      String str = paramThrowable.getMessage();
      if (((paramThrowable instanceof IllegalArgumentException)) && (!TextUtils.isEmpty(str)) && (str.contains("Service not registered: com.huawei.hms"))) {
        return true;
      }
      paramThrowable = paramThrowable.getCause();
    }
    return false;
  }
  
  private boolean isInputChannel(Throwable paramThrowable)
  {
    while (paramThrowable != null)
    {
      String str = paramThrowable.getMessage();
      if ((!TextUtils.isEmpty(str)) && ((str.contains("input channel")) || (str.contains("InputChannel")))) {
        return true;
      }
      paramThrowable = paramThrowable.getCause();
    }
    return false;
  }
  
  private boolean isJobScheduler(Throwable paramThrowable)
  {
    while (paramThrowable != null)
    {
      String str = paramThrowable.getMessage();
      if ((!TextUtils.isEmpty(str)) && (str.contains("JobStatus.getUid"))) {
        return true;
      }
      paramThrowable = paramThrowable.getCause();
    }
    return false;
  }
  
  private boolean isLBE(Throwable paramThrowable)
  {
    while (paramThrowable != null)
    {
      String str = paramThrowable.getMessage();
      if (((paramThrowable instanceof IllegalArgumentException)) && (!TextUtils.isEmpty(str)) && (str.contains("Service not registered: com.lbe.security.service"))) {
        return true;
      }
      paramThrowable = paramThrowable.getCause();
    }
    return false;
  }
  
  private boolean isMessageNPE(Throwable paramThrowable)
  {
    while (paramThrowable != null)
    {
      String str = paramThrowable.getMessage();
      if (((paramThrowable instanceof NullPointerException)) && (!TextUtils.isEmpty(str)) && (str.contains("Attempt to invoke virtual method 'java.lang.Class java.lang.Object.getClass()' on a null object reference"))) {
        return true;
      }
      paramThrowable = paramThrowable.getCause();
    }
    return false;
  }
  
  private boolean isNativeMethodNotFound(Throwable paramThrowable)
  {
    while (paramThrowable != null)
    {
      String str = paramThrowable.getMessage();
      if (((paramThrowable instanceof UnsatisfiedLinkError)) && (!TextUtils.isEmpty(str)) && (str.contains("Native method not found: com.tencent.qqmail.utilities.encryptionalgorithm.Aes.aesEncode"))) {
        return true;
      }
      paramThrowable = paramThrowable.getCause();
    }
    return false;
  }
  
  private boolean isOOM(Throwable paramThrowable)
  {
    while (paramThrowable != null)
    {
      if ((paramThrowable instanceof OutOfMemoryError)) {
        return true;
      }
      paramThrowable = paramThrowable.getCause();
    }
    return false;
  }
  
  private boolean isRemoteServiceException(Throwable paramThrowable)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = Class.forName("android.app.RemoteServiceException");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label11:
      Throwable localThrowable;
      break label11;
    }
    localObject2 = localObject1;
    localThrowable = paramThrowable;
    if (localObject1 == null) {
      localObject2 = AndroidRuntimeException.class;
    }
    for (localThrowable = paramThrowable; localThrowable != null; localThrowable = localThrowable.getCause())
    {
      paramThrowable = localThrowable.getMessage();
      if ((((Class)localObject2).isInstance(localThrowable)) && (!TextUtils.isEmpty(paramThrowable)) && (paramThrowable.contains("Bad notification posted from package com.tencent.androidqqmail: Couldn't expand RemoteViews for"))) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isSQLiteException(Throwable paramThrowable)
  {
    while (paramThrowable != null)
    {
      if ((paramThrowable instanceof SQLiteException)) {
        return true;
      }
      paramThrowable = paramThrowable.getCause();
    }
    return false;
  }
  
  private boolean isSQLiteFullException(Throwable paramThrowable)
  {
    while (paramThrowable != null)
    {
      if ((paramThrowable instanceof SQLiteFullException)) {
        return true;
      }
      paramThrowable = paramThrowable.getCause();
    }
    return false;
  }
  
  public static boolean reboot()
  {
    Object localObject = null;
    if (QMApplicationContext.sharedInstance().isMainProcess()) {
      if (canReboot()) {}
    }
    for (;;)
    {
      return false;
      if ((AppStatusUtil.isAppOnForeground()) || ((!KeepAliveManager.sShowInvisible) && (AppStatusUtil.isApplicationActive()))) {
        localObject = PendingIntent.getActivity(QMApplicationContext.sharedInstance(), 112915, new Intent(QMApplicationContext.sharedInstance(), LauncherActivity.class).addFlags(268435456), 0);
      }
      while (localObject != null)
      {
        alarm((PendingIntent)localObject);
        System.exit(0);
        return true;
        localObject = new Bundle();
        ((Bundle)localObject).putSerializable("from", QMScheduledJobs.FromType.EXCEPTION_REBOOT);
        localObject = PendingIntent.getService(QMApplicationContext.sharedInstance(), 5194140, QMNotifyService.createScheduledJobsIntent((Bundle)localObject), 0);
        continue;
        if (QMApplicationContext.sharedInstance().isPushProcess())
        {
          if (!canReboot()) {
            return true;
          }
          localObject = QMPushService.createStartIntent(QMPushService.PushStartUpReason.OTHER);
          localObject = PendingIntent.getService(QMApplicationContext.sharedInstance(), 181529, (Intent)localObject, 0);
        }
      }
    }
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    KvHelper.javaCrashByApp(new double[0]);
    dumpCrashLog(false, paramThread, paramThrowable);
    boolean bool2 = handleSpecialException(paramThrowable, QMApplicationContext.sharedInstance().isMainProcess());
    boolean bool1 = true;
    QMLog.log(4, "QMUncaughtExceptionHandler", "uncaughtException, handled: " + bool2);
    QMLog.flush();
    if (bool2) {
      bool1 = reboot();
    }
    QMLog.log(5, "QMUncaughtExceptionHandler", "reboot: " + bool1);
    QMLog.flush();
    if ((!bool2) || (!bool1))
    {
      handlePatchCrash(false);
      QMLog.flush();
      sDefaultHandler.uncaughtException(paramThread, paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.exception.QMUncaughtExceptionHandler
 * JD-Core Version:    0.7.0.1
 */