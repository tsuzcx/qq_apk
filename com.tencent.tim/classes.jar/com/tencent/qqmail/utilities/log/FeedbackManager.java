package com.tencent.qqmail.utilities.log;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.log.AddAccountLocalLogUtil;
import com.tencent.qqmail.activity.compose.ComposeCommUI;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.marcos.ChannelDefine;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.protocol.CloudProtocolHelper;
import com.tencent.qqmail.utilities.BrandUtil;
import com.tencent.qqmail.utilities.QMUtilities;
import com.tencent.qqmail.utilities.deviceid.DeviceInfo;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.qmnetwork.QMGeneralCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class FeedbackManager
{
  private static final int DEBUG_LOG_BIT_DBFILE = 1;
  private static final int DEBUG_LOG_BIT_SUBJECT = 0;
  private static final char DEBUG_LOG_TRUE = '1';
  private static final String SEND_FEED_BACK_COUNT_KEY = "SEND_FEED_BACK_COUNT";
  private static final String SP_NAME = "JNI_CRASH_FEED_BACK";
  private static final String TAG = "QMDebuglogManager";
  private static String[] filters = { "[I]", "[W]", "[E]" };
  
  public static void cheackJniCrashAndSendFeedback()
  {
    if (!AppConfig.isBeta()) {}
    int i;
    do
    {
      File localFile;
      do
      {
        return;
        localFile = new File(LogPathManager.getInstance().getTombstoneDirPath());
      } while ((!localFile.exists()) || (localFile.listFiles().length <= 0));
      i = SPManager.getSp("JNI_CRASH_FEED_BACK").getInt("SEND_FEED_BACK_COUNT", 0);
      Log.d("QMDebuglogManager", "sendFeedbackCount:" + i);
    } while (i >= 3);
    SPManager.getEditor("JNI_CRASH_FEED_BACK").putInt("SEND_FEED_BACK_COUNT", i + 1).apply();
    Threads.runInBackground(new FeedbackManager.3());
  }
  
  /* Error */
  public static boolean compressFeedbackFile(String paramString, List<String> paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: invokestatic 58	com/tencent/qqmail/utilities/log/LogPathManager:getInstance	()Lcom/tencent/qqmail/utilities/log/LogPathManager;
    //   6: astore 10
    //   8: new 133	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 134	java/util/ArrayList:<init>	()V
    //   15: astore 9
    //   17: aload 9
    //   19: new 6	com/tencent/qqmail/utilities/log/FeedbackManager$FileData
    //   22: dup
    //   23: aload 10
    //   25: invokevirtual 137	com/tencent/qqmail/utilities/log/LogPathManager:getAnrTraceFilePath	()Ljava/lang/String;
    //   28: invokespecial 138	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:<init>	(Ljava/lang/String;)V
    //   31: invokeinterface 144 2 0
    //   36: pop
    //   37: aload 9
    //   39: new 6	com/tencent/qqmail/utilities/log/FeedbackManager$FileData
    //   42: dup
    //   43: aload 10
    //   45: invokevirtual 147	com/tencent/qqmail/utilities/log/LogPathManager:getBuildPropFilePath	()Ljava/lang/String;
    //   48: invokespecial 138	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:<init>	(Ljava/lang/String;)V
    //   51: invokeinterface 144 2 0
    //   56: pop
    //   57: new 52	java/io/File
    //   60: dup
    //   61: invokestatic 58	com/tencent/qqmail/utilities/log/LogPathManager:getInstance	()Lcom/tencent/qqmail/utilities/log/LogPathManager;
    //   64: invokevirtual 150	com/tencent/qqmail/utilities/log/LogPathManager:getQMLogSettingFilePath	()Ljava/lang/String;
    //   67: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   70: invokestatic 156	com/tencent/qqmail/model/mail/QMSettingManager:sharedInstance	()Lcom/tencent/qqmail/model/mail/QMSettingManager;
    //   73: invokevirtual 160	com/tencent/qqmail/model/mail/QMSettingManager:getAllSettingItem	()Ljava/util/List;
    //   76: invokestatic 164	com/tencent/qqmail/utilities/log/FeedbackManager:writeLogFileClear	(Ljava/io/File;Ljava/util/List;)V
    //   79: new 52	java/io/File
    //   82: dup
    //   83: invokestatic 58	com/tencent/qqmail/utilities/log/LogPathManager:getInstance	()Lcom/tencent/qqmail/utilities/log/LogPathManager;
    //   86: invokevirtual 167	com/tencent/qqmail/utilities/log/LogPathManager:getSystemSettingDumpPath	()Ljava/lang/String;
    //   89: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   92: invokestatic 156	com/tencent/qqmail/model/mail/QMSettingManager:sharedInstance	()Lcom/tencent/qqmail/model/mail/QMSettingManager;
    //   95: invokevirtual 170	com/tencent/qqmail/model/mail/QMSettingManager:dumpSystemSettings	()Ljava/util/List;
    //   98: invokestatic 164	com/tencent/qqmail/utilities/log/FeedbackManager:writeLogFileClear	(Ljava/io/File;Ljava/util/List;)V
    //   101: new 52	java/io/File
    //   104: dup
    //   105: invokestatic 58	com/tencent/qqmail/utilities/log/LogPathManager:getInstance	()Lcom/tencent/qqmail/utilities/log/LogPathManager;
    //   108: invokevirtual 173	com/tencent/qqmail/utilities/log/LogPathManager:getQMLogAccountFilePath	()Ljava/lang/String;
    //   111: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: astore 11
    //   116: new 133	java/util/ArrayList
    //   119: dup
    //   120: invokespecial 134	java/util/ArrayList:<init>	()V
    //   123: astore 12
    //   125: aload 12
    //   127: invokestatic 178	com/tencent/qqmail/account/log/AddAccountLocalLogUtil:getAllAccountLog	()Ljava/lang/String;
    //   130: invokevirtual 179	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   133: pop
    //   134: aload 11
    //   136: aload 12
    //   138: invokestatic 164	com/tencent/qqmail/utilities/log/FeedbackManager:writeLogFileClear	(Ljava/io/File;Ljava/util/List;)V
    //   141: new 52	java/io/File
    //   144: dup
    //   145: invokestatic 58	com/tencent/qqmail/utilities/log/LogPathManager:getInstance	()Lcom/tencent/qqmail/utilities/log/LogPathManager;
    //   148: invokevirtual 182	com/tencent/qqmail/utilities/log/LogPathManager:getQMLogFolderLogFilePath	()Ljava/lang/String;
    //   151: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   154: invokestatic 187	com/tencent/qqmail/folderlist/QMFolderManager:getAllFolderLog	()Ljava/util/List;
    //   157: invokestatic 164	com/tencent/qqmail/utilities/log/FeedbackManager:writeLogFileClear	(Ljava/io/File;Ljava/util/List;)V
    //   160: aload 10
    //   162: ldc 189
    //   164: invokevirtual 193	com/tencent/qqmail/utilities/log/LogPathManager:getAllFilePath	(Ljava/lang/String;)Ljava/util/List;
    //   167: invokeinterface 197 1 0
    //   172: astore 10
    //   174: aload 10
    //   176: invokeinterface 202 1 0
    //   181: ifeq +72 -> 253
    //   184: aload 9
    //   186: new 6	com/tencent/qqmail/utilities/log/FeedbackManager$FileData
    //   189: dup
    //   190: aload 10
    //   192: invokeinterface 206 1 0
    //   197: checkcast 208	com/tencent/qqmail/utilities/log/LogPathManager$PathData
    //   200: invokespecial 211	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:<init>	(Lcom/tencent/qqmail/utilities/log/LogPathManager$PathData;)V
    //   203: invokeinterface 144 2 0
    //   208: pop
    //   209: goto -35 -> 174
    //   212: astore_1
    //   213: aconst_null
    //   214: astore_0
    //   215: ldc 25
    //   217: new 86	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   224: ldc 213
    //   226: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_1
    //   230: invokevirtual 216	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   233: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 219	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   242: pop
    //   243: aload_0
    //   244: ifnull +7 -> 251
    //   247: aload_0
    //   248: invokevirtual 224	java/util/zip/ZipOutputStream:close	()V
    //   251: iconst_0
    //   252: ireturn
    //   253: invokestatic 228	com/tencent/qqmail/utilities/log/FeedbackManager:getDeviceLogFile	()Ljava/io/File;
    //   256: aload 9
    //   258: invokestatic 231	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:addToList	(Ljava/io/File;Ljava/util/List;)V
    //   261: ldc 233
    //   263: invokestatic 237	com/tencent/qqmail/utilities/log/FeedbackManager:getSharedPrefsFile	(Ljava/lang/String;)Ljava/io/File;
    //   266: aload 9
    //   268: invokestatic 231	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:addToList	(Ljava/io/File;Ljava/util/List;)V
    //   271: ldc 239
    //   273: invokestatic 237	com/tencent/qqmail/utilities/log/FeedbackManager:getSharedPrefsFile	(Ljava/lang/String;)Ljava/io/File;
    //   276: aload 9
    //   278: invokestatic 231	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:addToList	(Ljava/io/File;Ljava/util/List;)V
    //   281: aload 9
    //   283: new 6	com/tencent/qqmail/utilities/log/FeedbackManager$FileData
    //   286: dup
    //   287: new 52	java/io/File
    //   290: dup
    //   291: invokestatic 244	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   294: invokevirtual 247	com/tencent/qqmail/QMApplicationContext:getCacheDir	()Ljava/io/File;
    //   297: ldc 249
    //   299: invokespecial 252	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   302: invokespecial 255	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:<init>	(Ljava/io/File;)V
    //   305: invokeinterface 144 2 0
    //   310: pop
    //   311: ldc_w 257
    //   314: invokestatic 237	com/tencent/qqmail/utilities/log/FeedbackManager:getSharedPrefsFile	(Ljava/lang/String;)Ljava/io/File;
    //   317: aload 9
    //   319: invokestatic 231	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:addToList	(Ljava/io/File;Ljava/util/List;)V
    //   322: ldc_w 259
    //   325: invokestatic 237	com/tencent/qqmail/utilities/log/FeedbackManager:getSharedPrefsFile	(Ljava/lang/String;)Ljava/io/File;
    //   328: aload 9
    //   330: invokestatic 231	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:addToList	(Ljava/io/File;Ljava/util/List;)V
    //   333: ldc_w 261
    //   336: invokestatic 237	com/tencent/qqmail/utilities/log/FeedbackManager:getSharedPrefsFile	(Ljava/lang/String;)Ljava/io/File;
    //   339: aload 9
    //   341: invokestatic 231	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:addToList	(Ljava/io/File;Ljava/util/List;)V
    //   344: ldc_w 263
    //   347: invokestatic 237	com/tencent/qqmail/utilities/log/FeedbackManager:getSharedPrefsFile	(Ljava/lang/String;)Ljava/io/File;
    //   350: aload 9
    //   352: invokestatic 231	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:addToList	(Ljava/io/File;Ljava/util/List;)V
    //   355: invokestatic 268	com/tencent/qqmail/utilities/patch/QMPatchManagerService:getErrorPatchFiles	()[Ljava/io/File;
    //   358: astore 10
    //   360: aload 10
    //   362: ifnull +56 -> 418
    //   365: aload 10
    //   367: arraylength
    //   368: ifle +50 -> 418
    //   371: aload 10
    //   373: arraylength
    //   374: istore 5
    //   376: iconst_0
    //   377: istore_3
    //   378: iconst_0
    //   379: istore 4
    //   381: iload_3
    //   382: iload 5
    //   384: if_icmpge +34 -> 418
    //   387: aload 9
    //   389: new 6	com/tencent/qqmail/utilities/log/FeedbackManager$FileData
    //   392: dup
    //   393: aload 10
    //   395: iload_3
    //   396: aaload
    //   397: invokespecial 255	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:<init>	(Ljava/io/File;)V
    //   400: invokeinterface 144 2 0
    //   405: pop
    //   406: iload 4
    //   408: iconst_1
    //   409: iadd
    //   410: istore 4
    //   412: iload 4
    //   414: iconst_3
    //   415: if_icmplt +162 -> 577
    //   418: ldc_w 270
    //   421: invokestatic 237	com/tencent/qqmail/utilities/log/FeedbackManager:getSharedPrefsFile	(Ljava/lang/String;)Ljava/io/File;
    //   424: aload 9
    //   426: invokestatic 231	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:addToList	(Ljava/io/File;Ljava/util/List;)V
    //   429: ldc_w 272
    //   432: invokestatic 237	com/tencent/qqmail/utilities/log/FeedbackManager:getSharedPrefsFile	(Ljava/lang/String;)Ljava/io/File;
    //   435: aload 9
    //   437: invokestatic 231	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:addToList	(Ljava/io/File;Ljava/util/List;)V
    //   440: ldc_w 274
    //   443: invokestatic 237	com/tencent/qqmail/utilities/log/FeedbackManager:getSharedPrefsFile	(Ljava/lang/String;)Ljava/io/File;
    //   446: aload 9
    //   448: invokestatic 231	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:addToList	(Ljava/io/File;Ljava/util/List;)V
    //   451: ldc_w 276
    //   454: invokestatic 237	com/tencent/qqmail/utilities/log/FeedbackManager:getSharedPrefsFile	(Ljava/lang/String;)Ljava/io/File;
    //   457: aload 9
    //   459: invokestatic 231	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:addToList	(Ljava/io/File;Ljava/util/List;)V
    //   462: ldc_w 278
    //   465: invokestatic 237	com/tencent/qqmail/utilities/log/FeedbackManager:getSharedPrefsFile	(Ljava/lang/String;)Ljava/io/File;
    //   468: aload 9
    //   470: invokestatic 231	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:addToList	(Ljava/io/File;Ljava/util/List;)V
    //   473: ldc_w 280
    //   476: invokestatic 237	com/tencent/qqmail/utilities/log/FeedbackManager:getSharedPrefsFile	(Ljava/lang/String;)Ljava/io/File;
    //   479: aload 9
    //   481: invokestatic 231	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:addToList	(Ljava/io/File;Ljava/util/List;)V
    //   484: invokestatic 286	com/tencent/qqmail/account/AccountManager:shareInstance	()Lcom/tencent/qqmail/account/AccountManager;
    //   487: invokevirtual 290	com/tencent/qqmail/account/AccountManager:getAccountList	()Lcom/tencent/qqmail/account/AccountList;
    //   490: invokevirtual 293	com/tencent/qqmail/account/AccountList:iterator	()Ljava/util/Iterator;
    //   493: astore 10
    //   495: aload 10
    //   497: invokeinterface 202 1 0
    //   502: ifeq +82 -> 584
    //   505: aload 10
    //   507: invokeinterface 206 1 0
    //   512: checkcast 295	com/tencent/qqmail/account/model/Account
    //   515: astore 11
    //   517: aload 11
    //   519: invokevirtual 298	com/tencent/qqmail/account/model/Account:isImapMail	()Z
    //   522: ifeq -27 -> 495
    //   525: new 86	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   532: ldc_w 300
    //   535: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload 11
    //   540: invokevirtual 304	com/tencent/qqmail/account/model/Account:getProfile	()Lcom/tencent/qqmail/protocol/Profile;
    //   543: getfield 309	com/tencent/qqmail/protocol/Profile:mailAddress	Ljava/lang/String;
    //   546: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   552: invokestatic 237	com/tencent/qqmail/utilities/log/FeedbackManager:getSharedPrefsFile	(Ljava/lang/String;)Ljava/io/File;
    //   555: aload 9
    //   557: invokestatic 231	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:addToList	(Ljava/io/File;Ljava/util/List;)V
    //   560: goto -65 -> 495
    //   563: astore_0
    //   564: aload 8
    //   566: astore_1
    //   567: aload_1
    //   568: ifnull +7 -> 575
    //   571: aload_1
    //   572: invokevirtual 224	java/util/zip/ZipOutputStream:close	()V
    //   575: aload_0
    //   576: athrow
    //   577: iload_3
    //   578: iconst_1
    //   579: iadd
    //   580: istore_3
    //   581: goto -200 -> 381
    //   584: ldc_w 311
    //   587: invokestatic 237	com/tencent/qqmail/utilities/log/FeedbackManager:getSharedPrefsFile	(Ljava/lang/String;)Ljava/io/File;
    //   590: aload 9
    //   592: invokestatic 231	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:addToList	(Ljava/io/File;Ljava/util/List;)V
    //   595: aload 9
    //   597: new 6	com/tencent/qqmail/utilities/log/FeedbackManager$FileData
    //   600: dup
    //   601: invokestatic 316	com/tencent/qqmail/utilities/log/RDMCrashReportHelper:getStoreCrashLogPath	()Ljava/lang/String;
    //   604: invokespecial 138	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:<init>	(Ljava/lang/String;)V
    //   607: invokeinterface 144 2 0
    //   612: pop
    //   613: new 52	java/io/File
    //   616: dup
    //   617: invokestatic 321	com/tencent/qqmail/utilities/fileextention/FileUtil:getRqdNativeLogPath	()Ljava/lang/String;
    //   620: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   623: astore 10
    //   625: invokestatic 327	java/lang/System:currentTimeMillis	()J
    //   628: lstore 6
    //   630: aload 10
    //   632: invokevirtual 72	java/io/File:listFiles	()[Ljava/io/File;
    //   635: astore 10
    //   637: aload 10
    //   639: arraylength
    //   640: istore 4
    //   642: iconst_0
    //   643: istore_3
    //   644: iload_3
    //   645: iload 4
    //   647: if_icmpge +60 -> 707
    //   650: aload 10
    //   652: iload_3
    //   653: aaload
    //   654: astore 11
    //   656: aload 11
    //   658: invokevirtual 68	java/io/File:exists	()Z
    //   661: ifeq +610 -> 1271
    //   664: aload 11
    //   666: invokevirtual 330	java/io/File:isDirectory	()Z
    //   669: ifne +602 -> 1271
    //   672: aload 11
    //   674: invokevirtual 333	java/io/File:lastModified	()J
    //   677: lload 6
    //   679: ldc2_w 334
    //   682: lsub
    //   683: lcmp
    //   684: ifle +587 -> 1271
    //   687: aload 9
    //   689: new 6	com/tencent/qqmail/utilities/log/FeedbackManager$FileData
    //   692: dup
    //   693: aload 11
    //   695: invokespecial 255	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:<init>	(Ljava/io/File;)V
    //   698: invokeinterface 144 2 0
    //   703: pop
    //   704: goto +567 -> 1271
    //   707: iload_2
    //   708: ifeq +21 -> 729
    //   711: aload 9
    //   713: new 6	com/tencent/qqmail/utilities/log/FeedbackManager$FileData
    //   716: dup
    //   717: invokestatic 340	com/tencent/qqmail/utilities/memory/MemoryUtil:dumpHprofData	()Ljava/lang/String;
    //   720: invokespecial 138	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:<init>	(Ljava/lang/String;)V
    //   723: invokeinterface 144 2 0
    //   728: pop
    //   729: aload 9
    //   731: new 6	com/tencent/qqmail/utilities/log/FeedbackManager$FileData
    //   734: dup
    //   735: invokestatic 58	com/tencent/qqmail/utilities/log/LogPathManager:getInstance	()Lcom/tencent/qqmail/utilities/log/LogPathManager;
    //   738: invokevirtual 343	com/tencent/qqmail/utilities/log/LogPathManager:getQMJNILogFilePath	()Ljava/lang/String;
    //   741: invokespecial 138	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:<init>	(Ljava/lang/String;)V
    //   744: invokeinterface 144 2 0
    //   749: pop
    //   750: aload 9
    //   752: new 6	com/tencent/qqmail/utilities/log/FeedbackManager$FileData
    //   755: dup
    //   756: invokestatic 58	com/tencent/qqmail/utilities/log/LogPathManager:getInstance	()Lcom/tencent/qqmail/utilities/log/LogPathManager;
    //   759: invokevirtual 346	com/tencent/qqmail/utilities/log/LogPathManager:getTombstoneLogFilePath	()Ljava/lang/String;
    //   762: invokespecial 138	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:<init>	(Ljava/lang/String;)V
    //   765: invokeinterface 144 2 0
    //   770: pop
    //   771: new 348	java/util/GregorianCalendar
    //   774: dup
    //   775: invokespecial 349	java/util/GregorianCalendar:<init>	()V
    //   778: astore 10
    //   780: aload 10
    //   782: invokestatic 327	java/lang/System:currentTimeMillis	()J
    //   785: ldc2_w 350
    //   788: lsub
    //   789: invokevirtual 355	java/util/GregorianCalendar:setTimeInMillis	(J)V
    //   792: invokestatic 58	com/tencent/qqmail/utilities/log/LogPathManager:getInstance	()Lcom/tencent/qqmail/utilities/log/LogPathManager;
    //   795: aload 10
    //   797: aconst_null
    //   798: invokevirtual 359	com/tencent/qqmail/utilities/log/LogPathManager:getQMLogFilePath	(Ljava/util/GregorianCalendar;Ljava/util/GregorianCalendar;)Ljava/util/List;
    //   801: invokeinterface 197 1 0
    //   806: astore 11
    //   808: aload 11
    //   810: invokeinterface 202 1 0
    //   815: ifeq +31 -> 846
    //   818: aload 9
    //   820: new 6	com/tencent/qqmail/utilities/log/FeedbackManager$FileData
    //   823: dup
    //   824: aload 11
    //   826: invokeinterface 206 1 0
    //   831: checkcast 208	com/tencent/qqmail/utilities/log/LogPathManager$PathData
    //   834: invokespecial 211	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:<init>	(Lcom/tencent/qqmail/utilities/log/LogPathManager$PathData;)V
    //   837: invokeinterface 144 2 0
    //   842: pop
    //   843: goto -35 -> 808
    //   846: invokestatic 58	com/tencent/qqmail/utilities/log/LogPathManager:getInstance	()Lcom/tencent/qqmail/utilities/log/LogPathManager;
    //   849: aload 10
    //   851: aconst_null
    //   852: invokevirtual 362	com/tencent/qqmail/utilities/log/LogPathManager:getWtLoginFilePath	(Ljava/util/GregorianCalendar;Ljava/util/GregorianCalendar;)Ljava/util/List;
    //   855: invokeinterface 197 1 0
    //   860: astore 11
    //   862: aload 11
    //   864: invokeinterface 202 1 0
    //   869: ifeq +31 -> 900
    //   872: aload 9
    //   874: new 6	com/tencent/qqmail/utilities/log/FeedbackManager$FileData
    //   877: dup
    //   878: aload 11
    //   880: invokeinterface 206 1 0
    //   885: checkcast 208	com/tencent/qqmail/utilities/log/LogPathManager$PathData
    //   888: invokespecial 211	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:<init>	(Lcom/tencent/qqmail/utilities/log/LogPathManager$PathData;)V
    //   891: invokeinterface 144 2 0
    //   896: pop
    //   897: goto -35 -> 862
    //   900: invokestatic 58	com/tencent/qqmail/utilities/log/LogPathManager:getInstance	()Lcom/tencent/qqmail/utilities/log/LogPathManager;
    //   903: aload 10
    //   905: aconst_null
    //   906: invokevirtual 365	com/tencent/qqmail/utilities/log/LogPathManager:getProtocolFilePath	(Ljava/util/GregorianCalendar;Ljava/util/GregorianCalendar;)Ljava/util/List;
    //   909: invokeinterface 197 1 0
    //   914: astore 11
    //   916: aload 11
    //   918: invokeinterface 202 1 0
    //   923: ifeq +31 -> 954
    //   926: aload 9
    //   928: new 6	com/tencent/qqmail/utilities/log/FeedbackManager$FileData
    //   931: dup
    //   932: aload 11
    //   934: invokeinterface 206 1 0
    //   939: checkcast 208	com/tencent/qqmail/utilities/log/LogPathManager$PathData
    //   942: invokespecial 211	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:<init>	(Lcom/tencent/qqmail/utilities/log/LogPathManager$PathData;)V
    //   945: invokeinterface 144 2 0
    //   950: pop
    //   951: goto -35 -> 916
    //   954: invokestatic 58	com/tencent/qqmail/utilities/log/LogPathManager:getInstance	()Lcom/tencent/qqmail/utilities/log/LogPathManager;
    //   957: aload 10
    //   959: aconst_null
    //   960: invokevirtual 368	com/tencent/qqmail/utilities/log/LogPathManager:getTombstoneFilePath	(Ljava/util/GregorianCalendar;Ljava/util/GregorianCalendar;)Ljava/util/List;
    //   963: invokeinterface 197 1 0
    //   968: astore 10
    //   970: aload 10
    //   972: invokeinterface 202 1 0
    //   977: ifeq +31 -> 1008
    //   980: aload 9
    //   982: new 6	com/tencent/qqmail/utilities/log/FeedbackManager$FileData
    //   985: dup
    //   986: aload 10
    //   988: invokeinterface 206 1 0
    //   993: checkcast 208	com/tencent/qqmail/utilities/log/LogPathManager$PathData
    //   996: invokespecial 211	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:<init>	(Lcom/tencent/qqmail/utilities/log/LogPathManager$PathData;)V
    //   999: invokeinterface 144 2 0
    //   1004: pop
    //   1005: goto -35 -> 970
    //   1008: new 221	java/util/zip/ZipOutputStream
    //   1011: dup
    //   1012: new 370	java/io/BufferedOutputStream
    //   1015: dup
    //   1016: new 372	java/io/FileOutputStream
    //   1019: dup
    //   1020: aload_0
    //   1021: invokespecial 373	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   1024: invokespecial 376	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1027: invokespecial 377	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1030: astore_0
    //   1031: sipush 8192
    //   1034: newarray byte
    //   1036: astore 8
    //   1038: aload 9
    //   1040: invokeinterface 197 1 0
    //   1045: astore 9
    //   1047: aload 9
    //   1049: invokeinterface 202 1 0
    //   1054: ifeq +34 -> 1088
    //   1057: aload_0
    //   1058: aload 9
    //   1060: invokeinterface 206 1 0
    //   1065: checkcast 6	com/tencent/qqmail/utilities/log/FeedbackManager$FileData
    //   1068: aload 8
    //   1070: invokestatic 381	com/tencent/qqmail/utilities/log/FeedbackManager:zipFile	(Ljava/util/zip/ZipOutputStream;Lcom/tencent/qqmail/utilities/log/FeedbackManager$FileData;[B)Z
    //   1073: ifne -26 -> 1047
    //   1076: ldc 25
    //   1078: ldc_w 383
    //   1081: invokestatic 219	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   1084: pop
    //   1085: goto -38 -> 1047
    //   1088: aload_1
    //   1089: ifnull +57 -> 1146
    //   1092: aload_1
    //   1093: invokeinterface 387 1 0
    //   1098: ifle +48 -> 1146
    //   1101: aload_1
    //   1102: invokeinterface 197 1 0
    //   1107: astore_1
    //   1108: aload_1
    //   1109: invokeinterface 202 1 0
    //   1114: ifeq +32 -> 1146
    //   1117: aload_1
    //   1118: invokeinterface 206 1 0
    //   1123: checkcast 31	java/lang/String
    //   1126: astore 9
    //   1128: aload_0
    //   1129: invokestatic 244	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   1132: aload 9
    //   1134: invokevirtual 390	com/tencent/qqmail/QMApplicationContext:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   1137: aload 8
    //   1139: invokestatic 394	com/tencent/qqmail/utilities/log/FeedbackManager:zipDBFile	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;[B)Z
    //   1142: pop
    //   1143: goto -35 -> 1108
    //   1146: invokestatic 399	com/tencent/qqmail/model/mail/QMMailManager:sharedInstance	()Lcom/tencent/qqmail/model/mail/QMMailManager;
    //   1149: invokevirtual 402	com/tencent/qqmail/model/mail/QMMailManager:getRemoteIdForLog	()Ljava/lang/String;
    //   1152: astore_1
    //   1153: aload_0
    //   1154: new 404	java/util/zip/ZipEntry
    //   1157: dup
    //   1158: ldc_w 406
    //   1161: invokespecial 407	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   1164: invokevirtual 411	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   1167: aload_0
    //   1168: aload_1
    //   1169: invokevirtual 415	java/lang/String:getBytes	()[B
    //   1172: invokevirtual 419	java/util/zip/ZipOutputStream:write	([B)V
    //   1175: aload_0
    //   1176: invokevirtual 422	java/util/zip/ZipOutputStream:closeEntry	()V
    //   1179: aload_0
    //   1180: new 404	java/util/zip/ZipEntry
    //   1183: dup
    //   1184: new 424	java/text/SimpleDateFormat
    //   1187: dup
    //   1188: ldc_w 426
    //   1191: invokespecial 427	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   1194: new 429	java/util/Date
    //   1197: dup
    //   1198: invokespecial 430	java/util/Date:<init>	()V
    //   1201: invokevirtual 434	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   1204: invokespecial 407	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   1207: invokevirtual 411	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   1210: aload_0
    //   1211: invokevirtual 422	java/util/zip/ZipOutputStream:closeEntry	()V
    //   1214: aload_0
    //   1215: ifnull +7 -> 1222
    //   1218: aload_0
    //   1219: invokevirtual 224	java/util/zip/ZipOutputStream:close	()V
    //   1222: iconst_1
    //   1223: ireturn
    //   1224: astore_0
    //   1225: ldc 25
    //   1227: ldc_w 436
    //   1230: invokestatic 219	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   1233: pop
    //   1234: iconst_1
    //   1235: ireturn
    //   1236: astore_0
    //   1237: ldc 25
    //   1239: ldc_w 436
    //   1242: invokestatic 219	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   1245: pop
    //   1246: iconst_0
    //   1247: ireturn
    //   1248: astore_1
    //   1249: ldc 25
    //   1251: ldc_w 436
    //   1254: invokestatic 219	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   1257: pop
    //   1258: goto -683 -> 575
    //   1261: astore 8
    //   1263: aload_0
    //   1264: astore_1
    //   1265: aload 8
    //   1267: astore_0
    //   1268: goto -701 -> 567
    //   1271: iload_3
    //   1272: iconst_1
    //   1273: iadd
    //   1274: istore_3
    //   1275: goto -631 -> 644
    //   1278: astore_1
    //   1279: goto -1064 -> 215
    //   1282: astore 8
    //   1284: aload_0
    //   1285: astore_1
    //   1286: aload 8
    //   1288: astore_0
    //   1289: goto -722 -> 567
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1292	0	paramString	String
    //   0	1292	1	paramList	List<String>
    //   0	1292	2	paramBoolean	boolean
    //   377	898	3	i	int
    //   379	269	4	j	int
    //   374	11	5	k	int
    //   628	50	6	l	long
    //   1	1137	8	arrayOfByte	byte[]
    //   1261	5	8	localObject1	Object
    //   1282	5	8	localObject2	Object
    //   15	1118	9	localObject3	Object
    //   6	981	10	localObject4	Object
    //   114	819	11	localObject5	Object
    //   123	14	12	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   3	174	212	java/lang/Exception
    //   174	209	212	java/lang/Exception
    //   253	360	212	java/lang/Exception
    //   365	376	212	java/lang/Exception
    //   387	406	212	java/lang/Exception
    //   418	495	212	java/lang/Exception
    //   495	560	212	java/lang/Exception
    //   584	642	212	java/lang/Exception
    //   656	704	212	java/lang/Exception
    //   711	729	212	java/lang/Exception
    //   729	808	212	java/lang/Exception
    //   808	843	212	java/lang/Exception
    //   846	862	212	java/lang/Exception
    //   862	897	212	java/lang/Exception
    //   900	916	212	java/lang/Exception
    //   916	951	212	java/lang/Exception
    //   954	970	212	java/lang/Exception
    //   970	1005	212	java/lang/Exception
    //   1008	1031	212	java/lang/Exception
    //   3	174	563	finally
    //   174	209	563	finally
    //   253	360	563	finally
    //   365	376	563	finally
    //   387	406	563	finally
    //   418	495	563	finally
    //   495	560	563	finally
    //   584	642	563	finally
    //   656	704	563	finally
    //   711	729	563	finally
    //   729	808	563	finally
    //   808	843	563	finally
    //   846	862	563	finally
    //   862	897	563	finally
    //   900	916	563	finally
    //   916	951	563	finally
    //   954	970	563	finally
    //   970	1005	563	finally
    //   1008	1031	563	finally
    //   1218	1222	1224	java/lang/Exception
    //   247	251	1236	java/lang/Exception
    //   571	575	1248	java/lang/Exception
    //   215	243	1261	finally
    //   1031	1047	1278	java/lang/Exception
    //   1047	1085	1278	java/lang/Exception
    //   1092	1108	1278	java/lang/Exception
    //   1108	1143	1278	java/lang/Exception
    //   1146	1214	1278	java/lang/Exception
    //   1031	1047	1282	finally
    //   1047	1085	1282	finally
    //   1092	1108	1282	finally
    //   1108	1143	1282	finally
    //   1146	1214	1282	finally
  }
  
  private static boolean createAttachFile(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      return true;
    }
    FileUtil.tryMkdirs(paramString.getParentFile());
    try
    {
      boolean bool = paramString.createNewFile();
      return bool;
    }
    catch (IOException paramString)
    {
      QMLog.log(3, "QMDebuglogManager", "create pushlog file err:" + paramString.toString());
    }
    return false;
  }
  
  public static String feedBackDeviceInfos()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    DeviceInfo localDeviceInfo = DeviceUtil.getDeviceInfos();
    Object localObject1 = localDeviceInfo.MANUFACTURER;
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    String str = localDeviceInfo.MODEL;
    localObject1 = str;
    if (str == null) {
      localObject1 = "";
    }
    if (((String)localObject1).toLowerCase(Locale.getDefault()).startsWith(((String)localObject2).toLowerCase(Locale.getDefault())))
    {
      localObject2 = localDeviceInfo.releaseVersion;
      localStringBuilder.append("型号: ").append((String)localObject1).append(";\r\nvid:").append(QMApplicationContext.sharedInstance().getVid());
      localStringBuilder.append("\n");
      localStringBuilder.append("Android 版本: ").append((String)localObject2);
      localStringBuilder.append("\n");
      localObject2 = localStringBuilder.append("运行环境: ");
      if (!QMUtilities.isART()) {
        break label197;
      }
    }
    label197:
    for (localObject1 = "ART";; localObject1 = "Dalvik")
    {
      ((StringBuilder)localObject2).append((String)localObject1);
      if (QMUtilities.isOldART()) {
        localStringBuilder.append("(兼容模式)");
      }
      return localStringBuilder.toString();
      localObject1 = (String)localObject2 + " " + (String)localObject1;
      break;
    }
  }
  
  private static File getDeviceLogFile()
  {
    File localFile = new File(LogPathManager.getInstance().getQMLogDeviceLogFilePath());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("sdcard->");
    localArrayList.add(DeviceUtil.getSDcardSpaceLog());
    localArrayList.add("devicemem->");
    localArrayList.add(DeviceUtil.getInnerMemSpaceLog());
    localArrayList.add("deviceid->");
    localArrayList.add(CloudProtocolHelper.getDeviceId());
    localArrayList.add("vid->");
    localArrayList.add(String.valueOf(QMApplicationContext.sharedInstance().getVid()));
    localArrayList.add("networktype->");
    localArrayList.add(QMNetworkUtils.getNetworkTypeString());
    localArrayList.add("root->" + DeviceUtil.isPhoneRoot());
    boolean[] arrayOfBoolean = DeviceUtil.isScreenReaderActive();
    localArrayList.add("isAccessibilityEnabled:" + arrayOfBoolean[0]);
    localArrayList.add("isExploreByTouchEnabled:" + arrayOfBoolean[1]);
    localArrayList.add("curversion:" + AppConfig.getCodeVersion());
    localArrayList.add(DeviceUtil.getDeviceInfos().toString());
    localArrayList.add("channel:" + ChannelDefine.getChannelId());
    localArrayList.add("ROM: " + BrandUtil.getRom());
    writeLogFileClear(localFile, localArrayList);
    return localFile;
  }
  
  /* Error */
  @androidx.annotation.Nullable
  public static List<String> getQmLog(boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 8
    //   3: aconst_null
    //   4: astore 12
    //   6: iconst_0
    //   7: istore 6
    //   9: iload_0
    //   10: ifne +245 -> 255
    //   13: new 348	java/util/GregorianCalendar
    //   16: dup
    //   17: invokespecial 349	java/util/GregorianCalendar:<init>	()V
    //   20: astore 11
    //   22: aload 11
    //   24: new 429	java/util/Date
    //   27: dup
    //   28: invokespecial 430	java/util/Date:<init>	()V
    //   31: invokevirtual 602	java/util/GregorianCalendar:setTime	(Ljava/util/Date;)V
    //   34: invokestatic 58	com/tencent/qqmail/utilities/log/LogPathManager:getInstance	()Lcom/tencent/qqmail/utilities/log/LogPathManager;
    //   37: aload 11
    //   39: aconst_null
    //   40: invokevirtual 359	com/tencent/qqmail/utilities/log/LogPathManager:getQMLogFilePath	(Ljava/util/GregorianCalendar;Ljava/util/GregorianCalendar;)Ljava/util/List;
    //   43: astore 11
    //   45: aload 11
    //   47: invokeinterface 387 1 0
    //   52: ifne +5 -> 57
    //   55: aconst_null
    //   56: areturn
    //   57: aload 11
    //   59: iconst_0
    //   60: invokeinterface 606 2 0
    //   65: checkcast 208	com/tencent/qqmail/utilities/log/LogPathManager$PathData
    //   68: getfield 609	com/tencent/qqmail/utilities/log/LogPathManager$PathData:path	Ljava/lang/String;
    //   71: astore 11
    //   73: new 611	java/io/RandomAccessFile
    //   76: dup
    //   77: aload 11
    //   79: ldc_w 613
    //   82: invokespecial 616	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: astore 11
    //   87: new 618	java/io/ByteArrayOutputStream
    //   90: dup
    //   91: invokespecial 619	java/io/ByteArrayOutputStream:<init>	()V
    //   94: astore 12
    //   96: aload 11
    //   98: invokevirtual 622	java/io/RandomAccessFile:length	()J
    //   101: lstore 9
    //   103: iconst_0
    //   104: istore 4
    //   106: lload 9
    //   108: lconst_1
    //   109: lsub
    //   110: lstore 9
    //   112: iconst_0
    //   113: istore_3
    //   114: lload 9
    //   116: lconst_0
    //   117: lcmp
    //   118: iflt +57 -> 175
    //   121: iload_3
    //   122: iload_1
    //   123: if_icmpge +52 -> 175
    //   126: aload 11
    //   128: lload 9
    //   130: invokevirtual 625	java/io/RandomAccessFile:seek	(J)V
    //   133: aload 11
    //   135: invokevirtual 628	java/io/RandomAccessFile:read	()I
    //   138: istore 7
    //   140: aload 12
    //   142: iload 7
    //   144: invokevirtual 631	java/io/ByteArrayOutputStream:write	(I)V
    //   147: iload_3
    //   148: istore 5
    //   150: iload 7
    //   152: bipush 13
    //   154: if_icmpne +157 -> 311
    //   157: iload_3
    //   158: istore 5
    //   160: iload 4
    //   162: bipush 10
    //   164: if_icmpne +147 -> 311
    //   167: iload_3
    //   168: iconst_1
    //   169: iadd
    //   170: istore 5
    //   172: goto +139 -> 311
    //   175: aload 12
    //   177: invokevirtual 634	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   180: astore 12
    //   182: aload 12
    //   184: arraylength
    //   185: iconst_1
    //   186: isub
    //   187: istore_1
    //   188: iload 6
    //   190: istore_3
    //   191: goto +136 -> 327
    //   194: iconst_1
    //   195: anewarray 31	java/lang/String
    //   198: dup
    //   199: iconst_0
    //   200: aload 12
    //   202: aload 12
    //   204: arraylength
    //   205: invokestatic 640	moai/core/utilities/string/StringExtention:base64Encode	([BI)Ljava/lang/String;
    //   208: aastore
    //   209: invokestatic 646	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   212: astore 12
    //   214: aload 11
    //   216: invokevirtual 647	java/io/RandomAccessFile:close	()V
    //   219: aload 12
    //   221: areturn
    //   222: astore 11
    //   224: aload 12
    //   226: areturn
    //   227: astore 11
    //   229: aload 12
    //   231: astore 11
    //   233: aload 11
    //   235: invokevirtual 647	java/io/RandomAccessFile:close	()V
    //   238: invokestatic 652	java/util/Collections:emptyList	()Ljava/util/List;
    //   241: areturn
    //   242: astore 12
    //   244: aconst_null
    //   245: astore 11
    //   247: aload 11
    //   249: invokevirtual 647	java/io/RandomAccessFile:close	()V
    //   252: aload 12
    //   254: athrow
    //   255: invokestatic 58	com/tencent/qqmail/utilities/log/LogPathManager:getInstance	()Lcom/tencent/qqmail/utilities/log/LogPathManager;
    //   258: invokevirtual 343	com/tencent/qqmail/utilities/log/LogPathManager:getQMJNILogFilePath	()Ljava/lang/String;
    //   261: astore 11
    //   263: getstatic 39	com/tencent/qqmail/utilities/log/FeedbackManager:filters	[Ljava/lang/String;
    //   266: astore 12
    //   268: iload_0
    //   269: ifne +17 -> 286
    //   272: iload 8
    //   274: istore_0
    //   275: aload 11
    //   277: bipush 60
    //   279: aload 12
    //   281: iload_0
    //   282: invokestatic 656	com/tencent/qqmail/utilities/fileextention/FileUtil:readFileLastLines	(Ljava/lang/String;I[Ljava/lang/String;Z)Ljava/util/List;
    //   285: areturn
    //   286: iconst_0
    //   287: istore_0
    //   288: goto -13 -> 275
    //   291: astore 11
    //   293: goto -55 -> 238
    //   296: astore 11
    //   298: goto -46 -> 252
    //   301: astore 12
    //   303: goto -56 -> 247
    //   306: astore 12
    //   308: goto -75 -> 233
    //   311: lload 9
    //   313: lconst_1
    //   314: lsub
    //   315: lstore 9
    //   317: iload 7
    //   319: istore 4
    //   321: iload 5
    //   323: istore_3
    //   324: goto -210 -> 114
    //   327: iload_1
    //   328: iload_3
    //   329: if_icmple -135 -> 194
    //   332: aload 12
    //   334: iload_1
    //   335: baload
    //   336: istore_2
    //   337: aload 12
    //   339: iload_1
    //   340: aload 12
    //   342: iload_3
    //   343: baload
    //   344: bastore
    //   345: aload 12
    //   347: iload_3
    //   348: iload_2
    //   349: bastore
    //   350: iload_3
    //   351: iconst_1
    //   352: iadd
    //   353: istore_3
    //   354: iload_1
    //   355: iconst_1
    //   356: isub
    //   357: istore_1
    //   358: goto -31 -> 327
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	361	0	paramBoolean	boolean
    //   0	361	1	paramInt	int
    //   336	13	2	i	int
    //   113	241	3	j	int
    //   104	216	4	k	int
    //   148	174	5	m	int
    //   7	182	6	n	int
    //   138	180	7	i1	int
    //   1	272	8	bool	boolean
    //   101	215	9	l	long
    //   20	195	11	localObject1	Object
    //   222	1	11	localException1	Exception
    //   227	1	11	localIOException1	IOException
    //   231	45	11	localObject2	Object
    //   291	1	11	localException2	Exception
    //   296	1	11	localException3	Exception
    //   4	226	12	localObject3	Object
    //   242	11	12	localObject4	Object
    //   266	14	12	arrayOfString	String[]
    //   301	1	12	localObject5	Object
    //   306	40	12	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   214	219	222	java/lang/Exception
    //   73	87	227	java/io/IOException
    //   73	87	242	finally
    //   233	238	291	java/lang/Exception
    //   247	252	296	java/lang/Exception
    //   87	103	301	finally
    //   126	147	301	finally
    //   175	188	301	finally
    //   194	214	301	finally
    //   87	103	306	java/io/IOException
    //   126	147	306	java/io/IOException
    //   175	188	306	java/io/IOException
    //   194	214	306	java/io/IOException
  }
  
  private static File getSharedPrefsFile(String paramString)
  {
    try
    {
      Class localClass = Class.forName("android.app.ContextImpl");
      if (Build.VERSION.SDK_INT < 24) {}
      for (String str = "getSharedPrefsFile";; str = "getSharedPreferencesPath") {
        return (File)localClass.getDeclaredMethod(str, new Class[] { String.class }).invoke(QMApplicationContext.sharedInstance().getBaseContext(), new Object[] { paramString });
      }
      return null;
    }
    catch (Exception paramString)
    {
      QMLog.log(5, "QMDebuglogManager", "getSharedPrefsFile failed", paramString);
    }
  }
  
  private static void handle(long paramLong, String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 1)) {}
    for (String str = paramArrayOfString[1];; str = "")
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramArrayOfString != null)
      {
        localObject1 = localObject2;
        if (paramArrayOfString.length > 2)
        {
          paramArrayOfString = paramArrayOfString[2];
          localObject1 = localObject2;
          if (paramArrayOfString != null) {
            localObject1 = Arrays.asList(paramArrayOfString.split(","));
          }
        }
      }
      Log.i("QMDebuglogManager", "handle subject: " + str + ", dbFiles: " + localObject1);
      handleCollectLog(paramLong, str, (List)localObject1);
      return;
    }
  }
  
  private static void handleCollectLog(long paramLong, String paramString, List<String> paramList)
  {
    Threads.runInBackground(new FeedbackManager.1(paramString, paramList), 1000L * paramLong);
  }
  
  private static void send(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, ArrayList<AttachInfo> paramArrayList, QMGeneralCallback paramQMGeneralCallback)
  {
    AttachInfo localAttachInfo = new AttachInfo();
    localAttachInfo.setAttachName(paramString7);
    localAttachInfo.setUploadDataPath(paramString8);
    paramString7 = new ArrayList();
    paramString7.add(localAttachInfo);
    if (paramArrayList != null)
    {
      paramString8 = paramArrayList.iterator();
      while (paramString8.hasNext())
      {
        localAttachInfo = (AttachInfo)paramString8.next();
        localAttachInfo.setUploadDataPath(localAttachInfo.getAbsAttachPath());
      }
      paramString7.addAll(paramArrayList);
    }
    paramString8 = new MailContent();
    paramString8.setBody(paramString6);
    paramString6 = new MailInformation();
    paramString6.setSubject(paramString5);
    paramString6.setSendContact(new MailContact(paramString2, paramString1));
    paramString2 = new MailContact();
    paramString2.setAddress(paramString4);
    paramString4 = new ArrayList();
    paramString4.add(paramString2);
    paramString6.setToList(paramString4);
    paramString2 = new ComposeMailUI();
    paramString2.setAddAttachInfoList(paramString7);
    paramString2.setContent(paramString8);
    paramString2.setInformation(paramString6);
    paramString2.setComposeCacheFilePath(paramString9);
    QMMailManager.sharedInstance().feedbackMail(paramString2, paramString1, paramString3, "smtp.qq.com", 25, paramQMGeneralCallback);
  }
  
  public static void sendLog(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, List<String> paramList, ArrayList<AttachInfo> paramArrayList, QMGeneralCallback paramQMGeneralCallback)
  {
    AddAccountLocalLogUtil.timeLineAccountChange("OTHER", "send debuglog.");
    String str1 = LogPathManager.getInstance().getFeedbackPushLogZipFilePath();
    String str2 = FileUtil.getExternalComposeCachePathWithKey("pushlogcachefile" + new Date().getTime());
    QMLog.log(4, "QMDebuglogManager", "begin compress debuglog zip");
    if (createAttachFile(str1))
    {
      compressFeedbackFile(str1, paramList, false);
      QMLog.log(4, "QMDebuglogManager", "compress log zip finish. send");
      paramList = new FeedbackManager.2(str1, str2, paramQMGeneralCallback);
      paramQMGeneralCallback = new StringBuilder();
      paramQMGeneralCallback.append(ComposeCommUI.FEED_BACK_SUBJECT).append(" v").append(AppConfig.getCodeVersion());
      if (!TextUtils.isEmpty(paramString5)) {
        paramQMGeneralCallback.append("-").append(paramString5);
      }
      send(paramString1, paramString2, paramString3, paramString4, paramQMGeneralCallback.toString(), paramString6, "pushlog.zip", str1, str2, paramArrayList, paramList);
    }
  }
  
  public static void uploadDebugLog(long paramLong, String paramString)
  {
    if (paramLong <= 0L)
    {
      QMLog.log(5, "QMDebuglogManager", "debug_log_setting_duration invalid");
      return;
    }
    if (paramString == null)
    {
      QMLog.log(5, "QMDebuglogManager", "uploadDebugLog. params null");
      handle(paramLong, null);
      return;
    }
    if (paramString.equals(""))
    {
      QMLog.log(5, "QMDebuglogManager", "uploadDebugLog. params empty");
      handle(paramLong, null);
      return;
    }
    try
    {
      handle(paramLong, paramString.split("\\|"));
      return;
    }
    catch (Exception paramString)
    {
      QMLog.log(6, "QMDebuglogManager", "uploadDebugLog err:" + paramString.toString());
    }
  }
  
  /* Error */
  private static void writeLogFileClear(File paramFile, List<String> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +16 -> 17
    //   4: aload_1
    //   5: invokeinterface 387 1 0
    //   10: ifeq +7 -> 17
    //   13: aload_0
    //   14: ifnonnull +13 -> 27
    //   17: iconst_5
    //   18: ldc 25
    //   20: ldc_w 870
    //   23: invokestatic 461	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   26: return
    //   27: new 872	java/io/BufferedWriter
    //   30: dup
    //   31: new 874	java/io/FileWriter
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 875	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   39: invokespecial 878	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   42: astore_3
    //   43: aload_3
    //   44: astore_2
    //   45: aload_1
    //   46: invokeinterface 197 1 0
    //   51: astore_1
    //   52: aload_3
    //   53: astore_2
    //   54: aload_1
    //   55: invokeinterface 202 1 0
    //   60: ifeq +85 -> 145
    //   63: aload_3
    //   64: astore_2
    //   65: aload_1
    //   66: invokeinterface 206 1 0
    //   71: checkcast 31	java/lang/String
    //   74: astore 4
    //   76: aload_3
    //   77: astore_2
    //   78: aload 4
    //   80: invokestatic 843	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   83: ifne -31 -> 52
    //   86: aload_3
    //   87: astore_2
    //   88: aload_3
    //   89: aload 4
    //   91: invokevirtual 880	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   94: aload_3
    //   95: astore_2
    //   96: aload_3
    //   97: invokevirtual 883	java/io/BufferedWriter:newLine	()V
    //   100: goto -48 -> 52
    //   103: astore_2
    //   104: aload_3
    //   105: astore_1
    //   106: aload_2
    //   107: astore_3
    //   108: aload_1
    //   109: astore_2
    //   110: bipush 6
    //   112: ldc 25
    //   114: new 86	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   121: ldc_w 885
    //   124: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload_0
    //   128: invokevirtual 708	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: aload_3
    //   135: invokestatic 693	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   138: aload_1
    //   139: invokevirtual 886	java/io/BufferedWriter:close	()V
    //   142: return
    //   143: astore_0
    //   144: return
    //   145: aload_3
    //   146: invokevirtual 886	java/io/BufferedWriter:close	()V
    //   149: return
    //   150: astore_0
    //   151: return
    //   152: astore_0
    //   153: aconst_null
    //   154: astore_2
    //   155: aload_2
    //   156: invokevirtual 886	java/io/BufferedWriter:close	()V
    //   159: aload_0
    //   160: athrow
    //   161: astore_1
    //   162: goto -3 -> 159
    //   165: astore_0
    //   166: goto -11 -> 155
    //   169: astore_3
    //   170: aconst_null
    //   171: astore_1
    //   172: goto -64 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	paramFile	File
    //   0	175	1	paramList	List<String>
    //   44	52	2	localObject1	Object
    //   103	4	2	localException1	Exception
    //   109	47	2	localList	List<String>
    //   42	104	3	localObject2	Object
    //   169	1	3	localException2	Exception
    //   74	16	4	str	String
    // Exception table:
    //   from	to	target	type
    //   45	52	103	java/lang/Exception
    //   54	63	103	java/lang/Exception
    //   65	76	103	java/lang/Exception
    //   78	86	103	java/lang/Exception
    //   88	94	103	java/lang/Exception
    //   96	100	103	java/lang/Exception
    //   138	142	143	java/lang/Exception
    //   145	149	150	java/lang/Exception
    //   27	43	152	finally
    //   155	159	161	java/lang/Exception
    //   45	52	165	finally
    //   54	63	165	finally
    //   65	76	165	finally
    //   78	86	165	finally
    //   88	94	165	finally
    //   96	100	165	finally
    //   110	138	165	finally
    //   27	43	169	java/lang/Exception
  }
  
  /* Error */
  private static boolean zipDBFile(java.util.zip.ZipOutputStream paramZipOutputStream, File paramFile, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 68	java/io/File:exists	()Z
    //   8: ifne +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: invokestatic 327	java/lang/System:currentTimeMillis	()J
    //   16: lstore 5
    //   18: new 889	java/io/FileInputStream
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 890	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore 10
    //   28: aload 10
    //   30: astore 9
    //   32: aload_0
    //   33: new 404	java/util/zip/ZipEntry
    //   36: dup
    //   37: aload_1
    //   38: invokevirtual 893	java/io/File:getName	()Ljava/lang/String;
    //   41: invokespecial 407	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   44: invokevirtual 411	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   47: aload 10
    //   49: astore 9
    //   51: invokestatic 244	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   54: invokevirtual 501	com/tencent/qqmail/QMApplicationContext:getVid	()J
    //   57: lstore 7
    //   59: aload 10
    //   61: astore 9
    //   63: aload 10
    //   65: aload_2
    //   66: invokevirtual 896	java/io/FileInputStream:read	([B)I
    //   69: istore 4
    //   71: iload 4
    //   73: ifle +104 -> 177
    //   76: iconst_0
    //   77: istore_3
    //   78: goto +227 -> 305
    //   81: aload 10
    //   83: astore 9
    //   85: aload_0
    //   86: aload_2
    //   87: iconst_0
    //   88: iload 4
    //   90: invokevirtual 899	java/util/zip/ZipOutputStream:write	([BII)V
    //   93: goto -34 -> 59
    //   96: astore 9
    //   98: aload 10
    //   100: astore_2
    //   101: aload 9
    //   103: astore 10
    //   105: aload_2
    //   106: astore 9
    //   108: ldc 25
    //   110: new 86	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   117: ldc_w 901
    //   120: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_1
    //   124: invokevirtual 893	java/io/File:getName	()Ljava/lang/String;
    //   127: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc_w 903
    //   133: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload 10
    //   138: invokevirtual 904	java/io/IOException:getMessage	()Ljava/lang/String;
    //   141: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 219	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   150: pop
    //   151: aload_2
    //   152: ifnull +7 -> 159
    //   155: aload_2
    //   156: invokevirtual 905	java/io/FileInputStream:close	()V
    //   159: aload_0
    //   160: invokevirtual 422	java/util/zip/ZipOutputStream:closeEntry	()V
    //   163: iconst_0
    //   164: ireturn
    //   165: astore_0
    //   166: ldc 25
    //   168: ldc_w 436
    //   171: invokestatic 219	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   174: pop
    //   175: iconst_0
    //   176: ireturn
    //   177: aload 10
    //   179: astore 9
    //   181: invokestatic 327	java/lang/System:currentTimeMillis	()J
    //   184: lstore 7
    //   186: aload 10
    //   188: astore 9
    //   190: ldc 25
    //   192: new 86	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   199: ldc_w 907
    //   202: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_1
    //   206: invokevirtual 893	java/io/File:getName	()Ljava/lang/String;
    //   209: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: ldc_w 909
    //   215: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: lload 7
    //   220: lload 5
    //   222: lsub
    //   223: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   226: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 711	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   232: pop
    //   233: aload 10
    //   235: ifnull +8 -> 243
    //   238: aload 10
    //   240: invokevirtual 905	java/io/FileInputStream:close	()V
    //   243: aload_0
    //   244: invokevirtual 422	java/util/zip/ZipOutputStream:closeEntry	()V
    //   247: iconst_1
    //   248: ireturn
    //   249: astore_0
    //   250: ldc 25
    //   252: ldc_w 436
    //   255: invokestatic 219	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   258: pop
    //   259: iconst_1
    //   260: ireturn
    //   261: astore_1
    //   262: aconst_null
    //   263: astore 9
    //   265: aload 9
    //   267: ifnull +8 -> 275
    //   270: aload 9
    //   272: invokevirtual 905	java/io/FileInputStream:close	()V
    //   275: aload_0
    //   276: invokevirtual 422	java/util/zip/ZipOutputStream:closeEntry	()V
    //   279: aload_1
    //   280: athrow
    //   281: astore_0
    //   282: ldc 25
    //   284: ldc_w 436
    //   287: invokestatic 219	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   290: pop
    //   291: goto -12 -> 279
    //   294: astore_1
    //   295: goto -30 -> 265
    //   298: astore 10
    //   300: aconst_null
    //   301: astore_2
    //   302: goto -197 -> 105
    //   305: iload_3
    //   306: iload 4
    //   308: if_icmpge -227 -> 81
    //   311: aload_2
    //   312: iload_3
    //   313: lload 7
    //   315: l2i
    //   316: i2b
    //   317: aload_2
    //   318: iload_3
    //   319: baload
    //   320: ixor
    //   321: i2b
    //   322: bastore
    //   323: iload_3
    //   324: iconst_1
    //   325: iadd
    //   326: istore_3
    //   327: goto -22 -> 305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	paramZipOutputStream	java.util.zip.ZipOutputStream
    //   0	330	1	paramFile	File
    //   0	330	2	paramArrayOfByte	byte[]
    //   77	250	3	i	int
    //   69	240	4	j	int
    //   16	205	5	l1	long
    //   57	257	7	l2	long
    //   30	54	9	localObject1	Object
    //   96	6	9	localIOException1	IOException
    //   106	165	9	localObject2	Object
    //   26	213	10	localObject3	Object
    //   298	1	10	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   32	47	96	java/io/IOException
    //   51	59	96	java/io/IOException
    //   63	71	96	java/io/IOException
    //   85	93	96	java/io/IOException
    //   181	186	96	java/io/IOException
    //   190	233	96	java/io/IOException
    //   155	159	165	java/lang/Exception
    //   159	163	165	java/lang/Exception
    //   238	243	249	java/lang/Exception
    //   243	247	249	java/lang/Exception
    //   13	28	261	finally
    //   270	275	281	java/lang/Exception
    //   275	279	281	java/lang/Exception
    //   32	47	294	finally
    //   51	59	294	finally
    //   63	71	294	finally
    //   85	93	294	finally
    //   108	151	294	finally
    //   181	186	294	finally
    //   190	233	294	finally
    //   13	28	298	java/io/IOException
  }
  
  /* Error */
  private static boolean zipFile(java.util.zip.ZipOutputStream paramZipOutputStream, FileData paramFileData, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 913	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:file	Ljava/io/File;
    //   4: ifnull +13 -> 17
    //   7: aload_1
    //   8: getfield 913	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:file	Ljava/io/File;
    //   11: invokevirtual 68	java/io/File:exists	()Z
    //   14: ifne +5 -> 19
    //   17: iconst_0
    //   18: ireturn
    //   19: new 889	java/io/FileInputStream
    //   22: dup
    //   23: aload_1
    //   24: getfield 913	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:file	Ljava/io/File;
    //   27: invokespecial 890	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: astore 7
    //   32: aload 7
    //   34: astore 6
    //   36: aload_0
    //   37: new 404	java/util/zip/ZipEntry
    //   40: dup
    //   41: aload_1
    //   42: getfield 916	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:name	Ljava/lang/String;
    //   45: invokespecial 407	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   48: invokevirtual 411	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   51: aload 7
    //   53: astore 6
    //   55: invokestatic 919	com/tencent/qqmail/utilities/qmnetwork/QMNetworkUtils:isWifiConnected	()Z
    //   58: ifne +180 -> 238
    //   61: aload 7
    //   63: astore 6
    //   65: aload 7
    //   67: lconst_0
    //   68: aload_1
    //   69: getfield 913	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:file	Ljava/io/File;
    //   72: invokevirtual 920	java/io/File:length	()J
    //   75: ldc2_w 921
    //   78: lsub
    //   79: invokestatic 928	java/lang/Math:max	(JJ)J
    //   82: invokevirtual 932	java/io/FileInputStream:skip	(J)J
    //   85: lstore 4
    //   87: aload 7
    //   89: astore 6
    //   91: iconst_4
    //   92: ldc 25
    //   94: new 86	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   101: ldc_w 934
    //   104: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_1
    //   108: invokevirtual 708	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   111: ldc_w 936
    //   114: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: lload 4
    //   119: invokevirtual 504	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   122: ldc_w 938
    //   125: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokestatic 941	com/tencent/qqmail/utilities/qmnetwork/QMNetworkUtils:getActiveNetworkName	()Ljava/lang/String;
    //   131: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 461	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   140: aload 7
    //   142: astore 6
    //   144: aload_2
    //   145: iconst_0
    //   146: invokestatic 945	java/util/Arrays:fill	([BB)V
    //   149: aload 7
    //   151: astore 6
    //   153: aload 7
    //   155: aload_2
    //   156: invokevirtual 896	java/io/FileInputStream:read	([B)I
    //   159: istore_3
    //   160: iload_3
    //   161: ifle +106 -> 267
    //   164: aload 7
    //   166: astore 6
    //   168: aload_0
    //   169: aload_2
    //   170: iconst_0
    //   171: iload_3
    //   172: invokevirtual 899	java/util/zip/ZipOutputStream:write	([BII)V
    //   175: goto -26 -> 149
    //   178: astore 6
    //   180: aload 7
    //   182: astore_2
    //   183: aload 6
    //   185: astore 7
    //   187: aload_2
    //   188: astore 6
    //   190: iconst_5
    //   191: ldc 25
    //   193: new 86	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   200: ldc_w 947
    //   203: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_1
    //   207: getfield 913	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:file	Ljava/io/File;
    //   210: invokevirtual 708	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: aload 7
    //   218: invokestatic 693	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   221: aload_2
    //   222: ifnull +7 -> 229
    //   225: aload_2
    //   226: invokevirtual 905	java/io/FileInputStream:close	()V
    //   229: aload_0
    //   230: invokevirtual 422	java/util/zip/ZipOutputStream:closeEntry	()V
    //   233: invokestatic 950	com/tencent/qqmail/utilities/log/QMLog:flush	()V
    //   236: iconst_0
    //   237: ireturn
    //   238: aload 7
    //   240: astore 6
    //   242: aload 7
    //   244: lconst_0
    //   245: aload_1
    //   246: getfield 913	com/tencent/qqmail/utilities/log/FeedbackManager$FileData:file	Ljava/io/File;
    //   249: invokevirtual 920	java/io/File:length	()J
    //   252: ldc2_w 951
    //   255: lsub
    //   256: invokestatic 928	java/lang/Math:max	(JJ)J
    //   259: invokevirtual 932	java/io/FileInputStream:skip	(J)J
    //   262: lstore 4
    //   264: goto -177 -> 87
    //   267: aload 7
    //   269: ifnull +8 -> 277
    //   272: aload 7
    //   274: invokevirtual 905	java/io/FileInputStream:close	()V
    //   277: aload_0
    //   278: invokevirtual 422	java/util/zip/ZipOutputStream:closeEntry	()V
    //   281: invokestatic 950	com/tencent/qqmail/utilities/log/QMLog:flush	()V
    //   284: iconst_1
    //   285: ireturn
    //   286: astore_0
    //   287: ldc 25
    //   289: ldc_w 436
    //   292: invokestatic 219	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   295: pop
    //   296: goto -15 -> 281
    //   299: astore_0
    //   300: ldc 25
    //   302: ldc_w 436
    //   305: invokestatic 219	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   308: pop
    //   309: goto -76 -> 233
    //   312: astore_1
    //   313: aconst_null
    //   314: astore 6
    //   316: aload 6
    //   318: ifnull +8 -> 326
    //   321: aload 6
    //   323: invokevirtual 905	java/io/FileInputStream:close	()V
    //   326: aload_0
    //   327: invokevirtual 422	java/util/zip/ZipOutputStream:closeEntry	()V
    //   330: invokestatic 950	com/tencent/qqmail/utilities/log/QMLog:flush	()V
    //   333: aload_1
    //   334: athrow
    //   335: astore_0
    //   336: ldc 25
    //   338: ldc_w 436
    //   341: invokestatic 219	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   344: pop
    //   345: goto -15 -> 330
    //   348: astore_1
    //   349: goto -33 -> 316
    //   352: astore 7
    //   354: aconst_null
    //   355: astore_2
    //   356: goto -169 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	paramZipOutputStream	java.util.zip.ZipOutputStream
    //   0	359	1	paramFileData	FileData
    //   0	359	2	paramArrayOfByte	byte[]
    //   159	13	3	i	int
    //   85	178	4	l	long
    //   34	133	6	localObject1	Object
    //   178	6	6	localIOException1	IOException
    //   188	134	6	localObject2	Object
    //   30	243	7	localObject3	Object
    //   352	1	7	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   36	51	178	java/io/IOException
    //   55	61	178	java/io/IOException
    //   65	87	178	java/io/IOException
    //   91	140	178	java/io/IOException
    //   144	149	178	java/io/IOException
    //   153	160	178	java/io/IOException
    //   168	175	178	java/io/IOException
    //   242	264	178	java/io/IOException
    //   272	277	286	java/lang/Exception
    //   277	281	286	java/lang/Exception
    //   225	229	299	java/lang/Exception
    //   229	233	299	java/lang/Exception
    //   19	32	312	finally
    //   321	326	335	java/lang/Exception
    //   326	330	335	java/lang/Exception
    //   36	51	348	finally
    //   55	61	348	finally
    //   65	87	348	finally
    //   91	140	348	finally
    //   144	149	348	finally
    //   153	160	348	finally
    //   168	175	348	finally
    //   190	221	348	finally
    //   242	264	348	finally
    //   19	32	352	java/io/IOException
  }
  
  static class FileData
  {
    final File file;
    final String name;
    
    public FileData(LogPathManager.PathData paramPathData)
    {
      this.file = new File(paramPathData.path);
      this.name = paramPathData.suggestedName;
    }
    
    public FileData(File paramFile)
    {
      this.file = paramFile;
      this.name = paramFile.getName();
    }
    
    public FileData(String paramString)
    {
      this(new File(paramString));
    }
    
    public static void addToList(File paramFile, List<FileData> paramList)
    {
      if (paramFile != null) {
        paramList.add(new FileData(paramFile));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.FeedbackManager
 * JD-Core Version:    0.7.0.1
 */