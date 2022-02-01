package com.tencent.qqmail.ftn;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.moai.downloader.delegate.HandleErrorDelegate;
import com.tencent.moai.downloader.exception.DownloadTaskError;
import com.tencent.moai.downloader.model.DownloadTask;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.account.watcher.AccountLoginWatcher;
import com.tencent.qqmail.download.DownloadInfoManager;
import com.tencent.qqmail.download.model.BigAttachDownloadError;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.ftn.Ftn.CGIInputHeader;
import com.tencent.qqmail.ftn.Ftn.CGIOutputHeader;
import com.tencent.qqmail.ftn.Ftn.DelFileInput;
import com.tencent.qqmail.ftn.Ftn.GetShareUrlInput;
import com.tencent.qqmail.ftn.Ftn.ItemAddVideoTaskInput;
import com.tencent.qqmail.ftn.Ftn.ItemInput;
import com.tencent.qqmail.ftn.Ftn.ItemInputStoreFile;
import com.tencent.qqmail.ftn.Ftn.ItemViewVideoInput;
import com.tencent.qqmail.ftn.Ftn.ListInput;
import com.tencent.qqmail.ftn.Ftn.LoginOutput;
import com.tencent.qqmail.ftn.Ftn.RenewFileInput;
import com.tencent.qqmail.ftn.Ftn.ShareUrlItemInput;
import com.tencent.qqmail.ftn.Ftn.StoreFileInput;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.utilities.ByteConvert;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmbroadcastreceiver.QMNetworkHandler;
import com.tencent.qqmail.utilities.qmbroadcastreceiver.QMNetworkHandler.NetworkListener;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest.QMHttpMethod;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import com.tencent.qqmail.utilities.thread.QMSchedulers;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import moai.oss.OssHelper;
import rx.Observable;
import rx.Subscriber;

public class FtnManagerImpl
{
  private static final String KEY_SID = "sid";
  private static final String KEY_SID_TIME = "sid_time";
  private static final String SP_NAME = "ftn_info";
  private static final String TAG = "FtnManagerImpl";
  private static ConcurrentHashMap<String, BigAttachDownloadError> bigAttachDownloadErrMap = new ConcurrentHashMap();
  private static volatile Map<Long, Handler> sDownloadHandlers;
  private static volatile Map<Long, DownloadTask> sDownloadTasks;
  private static volatile QMNetworkHandler.NetworkListener sNetworkListener;
  private static Object sNetworkWaiter = new Object();
  private static volatile Map<Long, AtomicBoolean> sUploadTasks;
  
  public static void abort(long paramLong)
  {
    QMLog.log(4, "FtnManagerImpl", "abort, taskid: " + paramLong);
    if ((sUploadTasks != null) && (sUploadTasks.size() > 0))
    {
      ??? = (AtomicBoolean)sUploadTasks.remove(Long.valueOf(paramLong));
      if (??? != null)
      {
        QMLog.log(4, "FtnManagerImpl", "abort upload task");
        ((AtomicBoolean)???).set(true);
      }
    }
    while ((sDownloadTasks == null) || (sDownloadTasks.size() <= 0)) {
      return;
    }
    synchronized (sDownloadTasks)
    {
      DownloadTask localDownloadTask = (DownloadTask)sDownloadTasks.remove(Long.valueOf(paramLong));
      if (localDownloadTask != null)
      {
        QMLog.log(4, "FtnManagerImpl", "abort download task: " + localDownloadTask.getFilePath());
        localDownloadTask.abort();
      }
      return;
    }
  }
  
  public static void autoLogin(String paramString1, String paramString2, boolean paramBoolean, FtnDefine.FtnCallback paramFtnCallback)
  {
    QMLog.log(4, "FtnManagerImpl", "autoLogin, email: " + paramString1 + ", isBiz: " + paramBoolean);
    Log.v("FtnManagerImpl", "ssid: " + paramString2);
    AutoLoginTask.instance.setCallback(paramFtnCallback).run();
  }
  
  public static void createFile(byte[] paramArrayOfByte, FtnDefine.FtnCallback paramFtnCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("createFile, inputLen: ");
    if (paramArrayOfByte == null) {}
    for (int i = -1;; i = paramArrayOfByte.length)
    {
      QMLog.log(4, "FtnManagerImpl", i);
      new CreateFileTask(paramArrayOfByte, paramFtnCallback).run();
      return;
    }
  }
  
  public static void delFile(String[] paramArrayOfString, FtnDefine.FtnCallback paramFtnCallback)
  {
    QMLog.log(4, "FtnManagerImpl", "delFile, fids: " + Arrays.toString(paramArrayOfString));
    new DelFileTask(paramArrayOfString, paramFtnCallback).run();
  }
  
  public static long fileDownload(DownloadInfo paramDownloadInfo, String paramString1, String paramString2, FtnDefine.FtnCallback paramFtnCallback)
  {
    QMLog.log(4, "FtnManagerImpl", "fileDownload, uin: " + getCurrentAccount().getUin() + ", fid: " + paramDownloadInfo.getFid() + ", url: " + paramDownloadInfo.getUrl() + ", filepath: " + paramDownloadInfo.getFilePath() + ", cookie_key: " + paramString1 + ", cookie_val: " + paramString2);
    long l1;
    if ((TextUtils.isEmpty(paramDownloadInfo.getUrl())) || (TextUtils.isEmpty(paramDownloadInfo.getFilePath())))
    {
      ValidateHelper.assertInDebug("DownloadInfo: " + paramDownloadInfo, false);
      QMLog.log(5, "FtnManagerImpl", "fileDownload, invalid params: " + paramDownloadInfo);
      if (paramFtnCallback != null) {
        paramFtnCallback.onError(0, 0, 7, "");
      }
      l1 = -1L;
    }
    long l2;
    do
    {
      return l1;
      l2 = DownloadTask.generateHashId(paramDownloadInfo.getFid(), "ftn");
      if ((sDownloadTasks == null) || (sDownloadTasks.size() <= 0)) {
        break;
      }
      l1 = l2;
    } while (sDownloadTasks.containsKey(Long.valueOf(l2)));
    paramString1 = initDownloadTask(paramDownloadInfo, paramString1, paramString2, paramFtnCallback);
    paramDownloadInfo.setDownloadTask(paramString1);
    paramDownloadInfo.setId(DownloadInfo.generateId(0, paramDownloadInfo.getFid(), paramDownloadInfo.getFileName()));
    DownloadInfoManager.shareInstance().insertDownloadInfo(paramDownloadInfo);
    if (sDownloadTasks == null) {}
    try
    {
      if (sDownloadTasks == null) {
        sDownloadTasks = new ConcurrentHashMap();
      }
      sDownloadTasks.put(Long.valueOf(l2), paramString1);
      paramString1.start();
      return l2;
    }
    finally {}
  }
  
  public static long fileUpload(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, FtnDefine.FtnCallback paramFtnCallback)
  {
    QMLog.log(4, "FtnManagerImpl", "fileUpload, uin: " + getCurrentAccountUin() + ", ip: " + paramString1 + ", port: " + paramInt + ", filePath: " + paramString4 + ", sha: " + paramString3);
    long l = DownloadTask.generateHashId(paramString1 + ":" + paramInt, paramString4);
    if ((sUploadTasks != null) && (sUploadTasks.size() > 0))
    {
      localAtomicBoolean = (AtomicBoolean)sUploadTasks.get(Long.valueOf(l));
      if (localAtomicBoolean != null)
      {
        localAtomicBoolean.set(false);
        return l;
      }
    }
    if (sUploadTasks == null) {
      sUploadTasks = new ConcurrentHashMap();
    }
    AtomicBoolean localAtomicBoolean = new AtomicBoolean();
    sUploadTasks.put(Long.valueOf(l), localAtomicBoolean);
    new FtnManagerImpl.5(paramString1, paramInt, paramString2, paramString3, paramString4, paramFtnCallback, l).start();
    return l;
  }
  
  private static QQMailAccount getCurrentAccount()
  {
    QQMailAccount localQQMailAccount = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
    if (localQQMailAccount != null) {}
    for (boolean bool = true;; bool = false)
    {
      ValidateHelper.assertInDebug("default ftn account is null", bool);
      return localQQMailAccount;
    }
  }
  
  private static String getCurrentAccountUin()
  {
    QQMailAccount localQQMailAccount = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
    if (localQQMailAccount != null) {
      return localQQMailAccount.getUin();
    }
    return "null";
  }
  
  static void getFileDownloadUrl(String paramString1, String paramString2, String paramString3, String paramString4, FtnDefine.FtnCallback paramFtnCallback)
  {
    QMLog.log(4, "FtnManagerImpl", "getFileDownloadUrl, fid: " + paramString1 + ", key: " + paramString2 + ", code: " + paramString3 + ", filename: " + paramString4);
    new GetFileDownloadUrlTask(paramString1, paramString2, paramString3, paramString4, paramFtnCallback).run();
  }
  
  static void getFileRarPreview(String paramString1, String paramString2, String paramString3, String paramString4, FtnDefine.FtnCallback paramFtnCallback)
  {
    QMLog.log(4, "FtnManagerImpl", "getFileRarPreview, fid: " + paramString1 + ", key: " + paramString2 + ", code: " + paramString3 + ", filename: " + paramString4);
    new GetFileRarPreviewTask(paramString1, paramString2, paramString3, paramString4, paramFtnCallback).run();
  }
  
  static void getFileVideoPreview(String paramString1, String paramString2, String paramString3, long paramLong, FtnDefine.FtnCallback paramFtnCallback)
  {
    QMLog.log(4, "FtnManagerImpl", "getFileVideoPreview, sha: " + paramString1 + ", fid: " + paramString2 + ", filename: " + paramString3 + ", size: " + paramLong);
    new GetFileVideoPreviewTask(paramString1, paramString2, paramString3, paramLong, paramFtnCallback).run();
  }
  
  private static HandleErrorDelegate getHandleErrorDelegate()
  {
    return new FtnManagerImpl.4();
  }
  
  public static void getList(long paramLong, boolean paramBoolean1, String paramString, boolean paramBoolean2, FtnDefine.FtnCallback paramFtnCallback)
  {
    QMLog.log(4, "FtnManagerImpl", "getList, lastUpdateTime: " + paramLong + ", isFav: " + paramBoolean1 + ", favPwd: " + paramString + ", isFavPwdEncrypt: " + paramBoolean2);
    new GetListTask(paramLong, paramBoolean1, paramString, paramBoolean2, paramFtnCallback).run();
  }
  
  static void getShareUrl(String[] paramArrayOfString1, String[] paramArrayOfString2, FtnDefine.FtnCallback paramFtnCallback)
  {
    QMLog.log(4, "FtnManagerImpl", "getShareUrl, keys: " + Arrays.toString(paramArrayOfString1) + ", codes: " + Arrays.toString(paramArrayOfString2));
    new GetShareUrlTask(paramArrayOfString1, paramArrayOfString2, paramFtnCallback).run();
  }
  
  private static DownloadTask initDownloadTask(DownloadInfo paramDownloadInfo, String paramString1, String paramString2, FtnDefine.FtnCallback paramFtnCallback)
  {
    AtomicInteger localAtomicInteger = new AtomicInteger();
    DownloadTask localDownloadTask = new DownloadTask();
    localDownloadTask.setUrl(paramDownloadInfo.getUrl());
    localDownloadTask.setFilePath(paramDownloadInfo.getFilePath());
    localDownloadTask.setSingleTaskDownload(true);
    localDownloadTask.setId(DownloadTask.generateHashId(paramDownloadInfo.getFid(), "ftn"));
    localDownloadTask.setFileSize(paramDownloadInfo.getFileSize());
    localDownloadTask.setHandleErrorDelegate(getHandleErrorDelegate());
    localDownloadTask.setListener(new FtnManagerImpl.2(paramFtnCallback, paramDownloadInfo, localAtomicInteger, localDownloadTask));
    localDownloadTask.setRequestInterceptor(new FtnManagerImpl.3(paramString1, paramString2));
    return localDownloadTask;
  }
  
  private static boolean isValidSid()
  {
    String str = SPManager.getSp("ftn_info").getString("sid", null);
    long l = SPManager.getSp("ftn_info").getLong("sid_time", 0L);
    return (!TextUtils.isEmpty(str)) && (System.currentTimeMillis() - l <= 3600000L);
  }
  
  public static boolean logined()
  {
    return isValidSid();
  }
  
  /* Error */
  private static int prepareUpload(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    // Byte code:
    //   0: iconst_3
    //   1: ldc 68
    //   3: new 99	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 523
    //   13: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: iload 4
    //   18: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   21: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 119	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   27: iconst_0
    //   28: istore 10
    //   30: new 525	java/io/FileInputStream
    //   33: dup
    //   34: aload_3
    //   35: invokespecial 527	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   38: astore 14
    //   40: iload 4
    //   42: i2l
    //   43: lstore 11
    //   45: aload 14
    //   47: astore_3
    //   48: aload 14
    //   50: lload 11
    //   52: invokevirtual 531	java/io/FileInputStream:skip	(J)J
    //   55: lstore 11
    //   57: aload 14
    //   59: astore_3
    //   60: aload 14
    //   62: aload 5
    //   64: invokevirtual 535	java/io/FileInputStream:read	([B)I
    //   67: istore 9
    //   69: aload 14
    //   71: astore_3
    //   72: iconst_2
    //   73: ldc 68
    //   75: new 99	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   82: ldc_w 537
    //   85: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: lload 11
    //   90: invokevirtual 109	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   93: ldc_w 539
    //   96: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: iload 9
    //   101: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   104: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 119	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   110: aload 14
    //   112: invokevirtual 542	java/io/FileInputStream:close	()V
    //   115: iload 9
    //   117: ifle +322 -> 439
    //   120: aload_0
    //   121: invokevirtual 548	java/lang/String:getBytes	()[B
    //   124: aload_0
    //   125: invokevirtual 548	java/lang/String:getBytes	()[B
    //   128: arraylength
    //   129: iconst_2
    //   130: idiv
    //   131: invokestatic 552	com/tencent/qqmail/ftn/FtnManagerImpl:trans	([BI)[B
    //   134: astore_0
    //   135: aload_0
    //   136: arraylength
    //   137: istore 10
    //   139: ldc_w 553
    //   142: invokestatic 559	com/tencent/qqmail/utilities/ByteConvert:intToBytes	(I)[B
    //   145: iconst_0
    //   146: aload 6
    //   148: iconst_0
    //   149: iconst_4
    //   150: invokestatic 563	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   153: sipush 1000
    //   156: invokestatic 559	com/tencent/qqmail/utilities/ByteConvert:intToBytes	(I)[B
    //   159: iconst_0
    //   160: aload 6
    //   162: iconst_4
    //   163: iconst_4
    //   164: invokestatic 563	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   167: iconst_0
    //   168: invokestatic 559	com/tencent/qqmail/utilities/ByteConvert:intToBytes	(I)[B
    //   171: iconst_0
    //   172: aload 6
    //   174: bipush 8
    //   176: iconst_4
    //   177: invokestatic 563	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   180: iload 10
    //   182: bipush 36
    //   184: iadd
    //   185: iload 9
    //   187: iadd
    //   188: invokestatic 559	com/tencent/qqmail/utilities/ByteConvert:intToBytes	(I)[B
    //   191: iconst_0
    //   192: aload 6
    //   194: bipush 12
    //   196: iconst_4
    //   197: invokestatic 563	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   200: iload 10
    //   202: i2s
    //   203: invokestatic 567	com/tencent/qqmail/utilities/ByteConvert:shortToBytes	(S)[B
    //   206: iconst_0
    //   207: aload 7
    //   209: iconst_0
    //   210: iconst_2
    //   211: invokestatic 563	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   214: aload_0
    //   215: iconst_0
    //   216: aload 7
    //   218: iconst_2
    //   219: iload 10
    //   221: invokestatic 563	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   224: bipush 20
    //   226: invokestatic 567	com/tencent/qqmail/utilities/ByteConvert:shortToBytes	(S)[B
    //   229: iconst_0
    //   230: aload 7
    //   232: iload 10
    //   234: iconst_2
    //   235: iadd
    //   236: iconst_2
    //   237: invokestatic 563	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   240: aload_1
    //   241: invokevirtual 548	java/lang/String:getBytes	()[B
    //   244: bipush 20
    //   246: invokestatic 552	com/tencent/qqmail/ftn/FtnManagerImpl:trans	([BI)[B
    //   249: iconst_0
    //   250: aload 7
    //   252: iload 10
    //   254: iconst_4
    //   255: iadd
    //   256: bipush 20
    //   258: invokestatic 563	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   261: iload_2
    //   262: invokestatic 559	com/tencent/qqmail/utilities/ByteConvert:intToBytes	(I)[B
    //   265: iconst_0
    //   266: aload 7
    //   268: iload 10
    //   270: bipush 24
    //   272: iadd
    //   273: iconst_4
    //   274: invokestatic 563	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   277: iload 4
    //   279: invokestatic 559	com/tencent/qqmail/utilities/ByteConvert:intToBytes	(I)[B
    //   282: iconst_0
    //   283: aload 7
    //   285: iload 10
    //   287: bipush 28
    //   289: iadd
    //   290: iconst_4
    //   291: invokestatic 563	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   294: iload 9
    //   296: invokestatic 559	com/tencent/qqmail/utilities/ByteConvert:intToBytes	(I)[B
    //   299: iconst_0
    //   300: aload 7
    //   302: iload 10
    //   304: bipush 32
    //   306: iadd
    //   307: iconst_4
    //   308: invokestatic 563	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   311: aload 5
    //   313: iload 9
    //   315: invokestatic 573	com/tencent/qqmail/utilities/stringextention/StringExtention:MD5	([BI)Ljava/lang/String;
    //   318: astore_0
    //   319: new 99	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   326: ldc_w 575
    //   329: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_0
    //   333: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: ldc_w 577
    //   339: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: iload 10
    //   344: bipush 36
    //   346: iadd
    //   347: bipush 16
    //   349: iadd
    //   350: iload 9
    //   352: iadd
    //   353: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   356: ldc_w 579
    //   359: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokevirtual 548	java/lang/String:getBytes	()[B
    //   368: astore_0
    //   369: aload_0
    //   370: iconst_0
    //   371: aload 8
    //   373: iconst_0
    //   374: aload_0
    //   375: arraylength
    //   376: invokestatic 563	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   379: iconst_0
    //   380: aload_0
    //   381: arraylength
    //   382: iadd
    //   383: istore_2
    //   384: aload 6
    //   386: iconst_0
    //   387: aload 8
    //   389: iload_2
    //   390: bipush 16
    //   392: invokestatic 563	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   395: iload_2
    //   396: bipush 16
    //   398: iadd
    //   399: istore_2
    //   400: aload 7
    //   402: iconst_0
    //   403: aload 8
    //   405: iload_2
    //   406: iload 10
    //   408: bipush 36
    //   410: iadd
    //   411: invokestatic 563	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   414: iload_2
    //   415: iload 10
    //   417: bipush 36
    //   419: iadd
    //   420: iadd
    //   421: istore_2
    //   422: aload 5
    //   424: iconst_0
    //   425: aload 8
    //   427: iload_2
    //   428: iload 9
    //   430: invokestatic 563	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   433: iload_2
    //   434: iload 9
    //   436: iadd
    //   437: istore 10
    //   439: iconst_2
    //   440: ldc 68
    //   442: new 99	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   449: ldc_w 581
    //   452: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: iload 10
    //   457: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   460: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: invokestatic 119	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   466: iload 10
    //   468: ireturn
    //   469: astore 13
    //   471: aconst_null
    //   472: astore 14
    //   474: iconst_m1
    //   475: istore 9
    //   477: aload 14
    //   479: astore_3
    //   480: bipush 6
    //   482: ldc 68
    //   484: ldc_w 583
    //   487: aload 13
    //   489: invokestatic 586	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   492: aload 14
    //   494: invokevirtual 542	java/io/FileInputStream:close	()V
    //   497: goto -382 -> 115
    //   500: astore_3
    //   501: goto -386 -> 115
    //   504: astore_0
    //   505: aconst_null
    //   506: astore_3
    //   507: aload_3
    //   508: invokevirtual 542	java/io/FileInputStream:close	()V
    //   511: aload_0
    //   512: athrow
    //   513: astore_3
    //   514: goto -399 -> 115
    //   517: astore_1
    //   518: goto -7 -> 511
    //   521: astore_0
    //   522: goto -15 -> 507
    //   525: astore 13
    //   527: iconst_m1
    //   528: istore 9
    //   530: goto -53 -> 477
    //   533: astore 13
    //   535: goto -58 -> 477
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	538	0	paramString1	String
    //   0	538	1	paramString2	String
    //   0	538	2	paramInt1	int
    //   0	538	3	paramString3	String
    //   0	538	4	paramInt2	int
    //   0	538	5	paramArrayOfByte1	byte[]
    //   0	538	6	paramArrayOfByte2	byte[]
    //   0	538	7	paramArrayOfByte3	byte[]
    //   0	538	8	paramArrayOfByte4	byte[]
    //   67	462	9	i	int
    //   28	439	10	j	int
    //   43	46	11	l	long
    //   469	19	13	localException1	Exception
    //   525	1	13	localException2	Exception
    //   533	1	13	localException3	Exception
    //   38	455	14	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   30	40	469	java/lang/Exception
    //   492	497	500	java/lang/Exception
    //   30	40	504	finally
    //   110	115	513	java/lang/Exception
    //   507	511	517	java/lang/Exception
    //   48	57	521	finally
    //   60	69	521	finally
    //   72	110	521	finally
    //   480	492	521	finally
    //   48	57	525	java/lang/Exception
    //   60	69	525	java/lang/Exception
    //   72	110	533	java/lang/Exception
  }
  
  public static void queryAccount(FtnDefine.FtnCallback paramFtnCallback)
  {
    QMLog.log(4, "FtnManagerImpl", "queryAccount");
    new QueryAccountTask(paramFtnCallback).run();
  }
  
  private static void registerNetworkListener()
  {
    if (sNetworkListener == null) {}
    try
    {
      if (sNetworkListener == null) {
        sNetworkListener = new FtnManagerImpl.1();
      }
      QMNetworkHandler.getInstance().registerNetworkListener(sNetworkListener);
      return;
    }
    finally {}
  }
  
  private static void releaseSocket(Socket paramSocket)
  {
    if (paramSocket == null) {
      return;
    }
    try
    {
      paramSocket.getOutputStream().close();
      try
      {
        label12:
        paramSocket.getInputStream().close();
        try
        {
          label19:
          paramSocket.close();
          return;
        }
        catch (Exception paramSocket) {}
      }
      catch (Exception localException1)
      {
        break label19;
      }
    }
    catch (Exception localException2)
    {
      break label12;
    }
  }
  
  public static void removeTask(long paramLong)
  {
    QMLog.log(4, "FtnManagerImpl", "removeTask, taskid: " + paramLong);
    abort(paramLong);
  }
  
  private static void removeUploadTaskInternal(long paramLong)
  {
    if (sDownloadHandlers != null)
    {
      Handler localHandler = (Handler)sDownloadHandlers.remove(Long.valueOf(paramLong));
      if (localHandler != null) {
        localHandler.getLooper().quit();
      }
    }
    if (sDownloadTasks != null) {
      sDownloadTasks.remove(Long.valueOf(paramLong));
    }
  }
  
  static void renewFile(String[] paramArrayOfString, int[] paramArrayOfInt, FtnDefine.FtnCallback paramFtnCallback)
  {
    QMLog.log(4, "FtnManagerImpl", "renewFile, fids: " + Arrays.toString(paramArrayOfString) + ", expireTimes: " + Arrays.toString(paramArrayOfInt));
    new RenewFileTask(paramArrayOfString, paramArrayOfInt, paramFtnCallback).run();
  }
  
  private static void reportDownloadError(String paramString, DownloadTaskError paramDownloadTaskError, DownloadInfo paramDownloadInfo)
  {
    Object localObject = (BigAttachDownloadError)bigAttachDownloadErrMap.get(paramString);
    bigAttachDownloadErrMap.remove(paramString);
    if (localObject != null)
    {
      paramString = ((BigAttachDownloadError)localObject).getSvrIp();
      if (localObject == null) {
        break label181;
      }
    }
    label181:
    for (localObject = ((BigAttachDownloadError)localObject).getSvrCode();; localObject = "")
    {
      paramString = paramString + ":" + (String)localObject + ":" + paramDownloadTaskError.getErrorCode() + ":" + paramDownloadTaskError.getMessage();
      QMLog.log(6, "FtnManagerImpl", paramString);
      OssHelper.ftnattachDownloadFail(new Object[] { Integer.valueOf(78502591), Integer.valueOf(1), "", "", "", "", "", "FtnManagerImpl", FileUtil.getFileNameSuffix(paramDownloadInfo.getFileName()), paramString });
      return;
      paramString = "";
      break;
    }
  }
  
  public static void saveFile(String[] paramArrayOfString1, String[] paramArrayOfString2, FtnDefine.FtnCallback paramFtnCallback)
  {
    QMLog.log(4, "FtnManagerImpl", "saveFile, keys: " + Arrays.toString(paramArrayOfString1) + ", codes: " + Arrays.toString(paramArrayOfString2));
    new SaveFileTask(paramArrayOfString1, paramArrayOfString2, paramFtnCallback).run();
  }
  
  private static byte trans(byte paramByte)
  {
    int i = paramByte | 0x20;
    if ((i >= 48) && (i <= 57)) {}
    for (paramByte = i - 48;; paramByte = i - 97 + 10)
    {
      return (byte)paramByte;
      if ((i < 97) || (i > 102)) {
        break;
      }
    }
    throw new IllegalArgumentException("byte: " + (paramByte & 0xFF));
  }
  
  private static byte[] trans(byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    byte[] arrayOfByte = new byte[paramArrayOfByte.length / 2];
    int k;
    for (int i = 0;; i = k) {
      if (j < paramArrayOfByte.length)
      {
        k = i + 1;
        int m = j + 1;
        int n = trans(paramArrayOfByte[j]);
        j = m + 1;
        arrayOfByte[i] = ((byte)(trans(paramArrayOfByte[m]) | n << 4));
        if ((paramInt == 0) || (k != paramInt)) {}
      }
      else
      {
        return arrayOfByte;
      }
    }
  }
  
  static void transCodeVideo(String paramString1, long paramLong, String paramString2, String paramString3, FtnDefine.FtnCallback paramFtnCallback)
  {
    QMLog.log(4, "FtnManagerImpl", "trasCodeVideo, sha: " + paramString1 + ", size: " + paramLong + ", filename: " + paramString2 + ", fid: " + paramString3);
    new TransCodeVideoTask(paramString1, paramLong, paramString2, paramString3, paramFtnCallback).run();
  }
  
  /* Error */
  private static void upload(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, FtnDefine.FtnCallback paramFtnCallback, long paramLong)
  {
    // Byte code:
    //   0: getstatic 121	com/tencent/qqmail/ftn/FtnManagerImpl:sUploadTasks	Ljava/util/Map;
    //   3: lload 6
    //   5: invokestatic 133	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   8: invokeinterface 368 2 0
    //   13: checkcast 139	java/util/concurrent/atomic/AtomicBoolean
    //   16: astore 22
    //   18: aload 22
    //   20: ifnonnull +4 -> 24
    //   23: return
    //   24: aload_2
    //   25: invokevirtual 548	java/lang/String:getBytes	()[B
    //   28: arraylength
    //   29: iconst_2
    //   30: idiv
    //   31: bipush 36
    //   33: iadd
    //   34: istore 8
    //   36: bipush 16
    //   38: newarray byte
    //   40: astore 23
    //   42: iload 8
    //   44: newarray byte
    //   46: astore 24
    //   48: ldc_w 712
    //   51: newarray byte
    //   53: astore 25
    //   55: iload 8
    //   57: bipush 16
    //   59: iadd
    //   60: sipush 128
    //   63: iadd
    //   64: ldc_w 712
    //   67: iadd
    //   68: newarray byte
    //   70: astore 26
    //   72: sipush 10240
    //   75: newarray byte
    //   77: astore 27
    //   79: new 714	java/io/File
    //   82: dup
    //   83: aload 4
    //   85: invokespecial 715	java/io/File:<init>	(Ljava/lang/String;)V
    //   88: invokevirtual 718	java/io/File:length	()J
    //   91: l2i
    //   92: istore 13
    //   94: aconst_null
    //   95: astore 19
    //   97: aconst_null
    //   98: astore 20
    //   100: iconst_0
    //   101: istore 11
    //   103: iconst_0
    //   104: istore 10
    //   106: iconst_0
    //   107: istore 8
    //   109: new 54	com/tencent/qqmail/ftn/FtnManagerImpl$UploadRecv
    //   112: dup
    //   113: aconst_null
    //   114: invokespecial 721	com/tencent/qqmail/ftn/FtnManagerImpl$UploadRecv:<init>	(Lcom/tencent/qqmail/ftn/FtnManagerImpl$1;)V
    //   117: astore 28
    //   119: aload 5
    //   121: ifnull +8 -> 129
    //   124: aload 5
    //   126: invokevirtual 724	com/tencent/qqmail/ftn/FtnDefine$FtnCallback:onBeforeSend	()V
    //   129: aconst_null
    //   130: astore 18
    //   132: iconst_0
    //   133: istore 9
    //   135: iload 10
    //   137: ifne +94 -> 231
    //   140: aload 22
    //   142: invokevirtual 726	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   145: ifne +86 -> 231
    //   148: invokestatic 731	com/tencent/qqmail/utilities/qmnetwork/QMNetworkUtils:isNetworkConnected	()Z
    //   151: ifne +41 -> 192
    //   154: getstatic 89	com/tencent/qqmail/ftn/FtnManagerImpl:sNetworkWaiter	Ljava/lang/Object;
    //   157: astore 21
    //   159: aload 21
    //   161: monitorenter
    //   162: invokestatic 731	com/tencent/qqmail/utilities/qmnetwork/QMNetworkUtils:isNetworkConnected	()Z
    //   165: ifne +24 -> 189
    //   168: getstatic 89	com/tencent/qqmail/ftn/FtnManagerImpl:sNetworkWaiter	Ljava/lang/Object;
    //   171: ldc2_w 732
    //   174: invokestatic 739	com/tencent/qqmail/utilities/thread/Threads:waitNoException	(Ljava/lang/Object;J)V
    //   177: aload 21
    //   179: monitorexit
    //   180: goto -45 -> 135
    //   183: astore_0
    //   184: aload 21
    //   186: monitorexit
    //   187: aload_0
    //   188: athrow
    //   189: aload 21
    //   191: monitorexit
    //   192: iload 8
    //   194: ifeq +1000 -> 1194
    //   197: iconst_5
    //   198: ldc 68
    //   200: new 99	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 741
    //   210: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: iload 9
    //   215: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   218: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 119	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   224: iload 9
    //   226: bipush 50
    //   228: if_icmple +80 -> 308
    //   231: iload 10
    //   233: ifeq +840 -> 1073
    //   236: iconst_4
    //   237: ldc 68
    //   239: new 99	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   246: ldc_w 743
    //   249: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload 4
    //   254: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 119	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   263: aload 5
    //   265: ifnull +10 -> 275
    //   268: aload 5
    //   270: aconst_null
    //   271: aconst_null
    //   272: invokevirtual 747	com/tencent/qqmail/ftn/FtnDefine$FtnCallback:onSuccess	([B[B)V
    //   275: aload 5
    //   277: ifnull +8 -> 285
    //   280: aload 5
    //   282: invokevirtual 750	com/tencent/qqmail/ftn/FtnDefine$FtnCallback:onComplete	()V
    //   285: aload 22
    //   287: invokevirtual 726	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   290: ifne -267 -> 23
    //   293: getstatic 121	com/tencent/qqmail/ftn/FtnManagerImpl:sUploadTasks	Ljava/util/Map;
    //   296: lload 6
    //   298: invokestatic 133	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   301: invokeinterface 137 2 0
    //   306: pop
    //   307: return
    //   308: iconst_0
    //   309: istore 12
    //   311: iload 9
    //   313: iconst_1
    //   314: iadd
    //   315: istore 8
    //   317: iload 12
    //   319: istore 9
    //   321: aload_2
    //   322: aload_3
    //   323: iload 13
    //   325: aload 4
    //   327: iload 11
    //   329: aload 25
    //   331: aload 23
    //   333: aload 24
    //   335: aload 26
    //   337: invokestatic 752	com/tencent/qqmail/ftn/FtnManagerImpl:prepareUpload	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I[B[B[B[B)I
    //   340: istore 14
    //   342: iload 14
    //   344: ifgt +23 -> 367
    //   347: iconst_1
    //   348: istore 12
    //   350: ldc2_w 753
    //   353: invokestatic 759	android/os/SystemClock:sleep	(J)V
    //   356: iload 8
    //   358: istore 9
    //   360: iload 12
    //   362: istore 8
    //   364: goto -229 -> 135
    //   367: invokestatic 762	android/os/SystemClock:elapsedRealtime	()J
    //   370: lstore 15
    //   372: aload 18
    //   374: ifnull +35 -> 409
    //   377: aload 18
    //   379: invokevirtual 765	java/net/Socket:isClosed	()Z
    //   382: ifne +27 -> 409
    //   385: aload 18
    //   387: invokevirtual 768	java/net/Socket:isConnected	()Z
    //   390: ifeq +19 -> 409
    //   393: aload 18
    //   395: invokevirtual 771	java/net/Socket:isInputShutdown	()Z
    //   398: ifne +11 -> 409
    //   401: aload 18
    //   403: invokevirtual 774	java/net/Socket:isOutputShutdown	()Z
    //   406: ifeq +773 -> 1179
    //   409: invokestatic 780	javax/net/SocketFactory:getDefault	()Ljavax/net/SocketFactory;
    //   412: invokevirtual 784	javax/net/SocketFactory:createSocket	()Ljava/net/Socket;
    //   415: astore 21
    //   417: aload 21
    //   419: astore 18
    //   421: aload 18
    //   423: sipush 30000
    //   426: invokevirtual 787	java/net/Socket:setSoTimeout	(I)V
    //   429: aload 18
    //   431: new 789	java/net/InetSocketAddress
    //   434: dup
    //   435: aload_0
    //   436: iload_1
    //   437: invokespecial 792	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   440: sipush 15000
    //   443: invokevirtual 796	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   446: iconst_4
    //   447: ldc 68
    //   449: new 99	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   456: ldc_w 798
    //   459: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: aload_0
    //   463: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: ldc_w 359
    //   469: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: iload_1
    //   473: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   476: ldc_w 800
    //   479: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: invokestatic 762	android/os/SystemClock:elapsedRealtime	()J
    //   485: lload 15
    //   487: lsub
    //   488: invokevirtual 109	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   491: ldc_w 802
    //   494: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: invokestatic 805	com/tencent/qqmail/utilities/qmnetwork/QMNetworkUtils:getActiveNetworkName	()Ljava/lang/String;
    //   500: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: ldc_w 807
    //   506: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: invokestatic 810	com/tencent/qqmail/utilities/qmnetwork/QMNetworkUtils:getNetworkLevel	()I
    //   512: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   515: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 119	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   521: aload 18
    //   523: invokevirtual 614	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   526: astore 21
    //   528: aload 21
    //   530: astore 19
    //   532: aload 18
    //   534: invokevirtual 621	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   537: astore 21
    //   539: aload 19
    //   541: astore 20
    //   543: aload 21
    //   545: astore 19
    //   547: invokestatic 762	android/os/SystemClock:elapsedRealtime	()J
    //   550: lstore 15
    //   552: aload 20
    //   554: aload 26
    //   556: iload 14
    //   558: invokestatic 814	com/tencent/qqmail/ftn/FtnManagerImpl:uploadSend	(Ljava/io/OutputStream;[BI)Z
    //   561: istore 17
    //   563: iload 17
    //   565: ifeq +230 -> 795
    //   568: iconst_4
    //   569: istore 12
    //   571: iload 12
    //   573: ldc 68
    //   575: new 99	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   582: ldc_w 816
    //   585: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: iload 17
    //   590: invokevirtual 205	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   593: ldc_w 818
    //   596: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: iload 14
    //   601: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   604: ldc_w 800
    //   607: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: invokestatic 762	android/os/SystemClock:elapsedRealtime	()J
    //   613: lload 15
    //   615: lsub
    //   616: invokevirtual 109	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   619: ldc_w 802
    //   622: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: invokestatic 805	com/tencent/qqmail/utilities/qmnetwork/QMNetworkUtils:getActiveNetworkName	()Ljava/lang/String;
    //   628: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: ldc_w 807
    //   634: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: invokestatic 810	com/tencent/qqmail/utilities/qmnetwork/QMNetworkUtils:getNetworkLevel	()I
    //   640: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   643: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   646: invokestatic 119	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   649: iload 17
    //   651: ifne +150 -> 801
    //   654: aload 18
    //   656: invokestatic 820	com/tencent/qqmail/ftn/FtnManagerImpl:releaseSocket	(Ljava/net/Socket;)V
    //   659: ldc2_w 753
    //   662: invokestatic 759	android/os/SystemClock:sleep	(J)V
    //   665: aload 20
    //   667: astore 21
    //   669: iconst_1
    //   670: istore 12
    //   672: iload 8
    //   674: istore 9
    //   676: iload 12
    //   678: istore 8
    //   680: aload 19
    //   682: astore 20
    //   684: aload 21
    //   686: astore 19
    //   688: goto -553 -> 135
    //   691: astore 21
    //   693: iconst_5
    //   694: ldc 68
    //   696: new 99	java/lang/StringBuilder
    //   699: dup
    //   700: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   703: ldc_w 822
    //   706: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: aload_0
    //   710: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: ldc_w 359
    //   716: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: iload_1
    //   720: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   723: ldc_w 800
    //   726: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: invokestatic 762	android/os/SystemClock:elapsedRealtime	()J
    //   732: lload 15
    //   734: lsub
    //   735: invokevirtual 109	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   738: ldc_w 802
    //   741: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: invokestatic 805	com/tencent/qqmail/utilities/qmnetwork/QMNetworkUtils:getActiveNetworkName	()Ljava/lang/String;
    //   747: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: ldc_w 807
    //   753: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: invokestatic 810	com/tencent/qqmail/utilities/qmnetwork/QMNetworkUtils:getNetworkLevel	()I
    //   759: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   762: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   765: aload 21
    //   767: invokestatic 586	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   770: aload 18
    //   772: invokestatic 820	com/tencent/qqmail/ftn/FtnManagerImpl:releaseSocket	(Ljava/net/Socket;)V
    //   775: iconst_1
    //   776: istore 12
    //   778: ldc2_w 753
    //   781: invokestatic 759	android/os/SystemClock:sleep	(J)V
    //   784: iload 8
    //   786: istore 9
    //   788: iload 12
    //   790: istore 8
    //   792: goto -657 -> 135
    //   795: iconst_5
    //   796: istore 12
    //   798: goto -227 -> 571
    //   801: invokestatic 762	android/os/SystemClock:elapsedRealtime	()J
    //   804: lstore 15
    //   806: aload 28
    //   808: aload 19
    //   810: aload 27
    //   812: iload 13
    //   814: aload 5
    //   816: invokestatic 826	com/tencent/qqmail/ftn/FtnManagerImpl:uploadRecv	(Lcom/tencent/qqmail/ftn/FtnManagerImpl$UploadRecv;Ljava/io/InputStream;[BILcom/tencent/qqmail/ftn/FtnDefine$FtnCallback;)I
    //   819: istore 14
    //   821: aload 28
    //   823: getfield 830	com/tencent/qqmail/ftn/FtnManagerImpl$UploadRecv:error	I
    //   826: ifne +184 -> 1010
    //   829: iconst_1
    //   830: istore 17
    //   832: iload 17
    //   834: ifeq +182 -> 1016
    //   837: iconst_4
    //   838: istore 12
    //   840: iload 12
    //   842: ldc 68
    //   844: new 99	java/lang/StringBuilder
    //   847: dup
    //   848: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   851: ldc_w 832
    //   854: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: iload 17
    //   859: invokevirtual 205	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   862: ldc_w 834
    //   865: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: aload 28
    //   870: getfield 830	com/tencent/qqmail/ftn/FtnManagerImpl$UploadRecv:error	I
    //   873: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   876: ldc_w 836
    //   879: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: iload 14
    //   884: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   887: ldc_w 838
    //   890: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   893: aload 28
    //   895: getfield 841	com/tencent/qqmail/ftn/FtnManagerImpl$UploadRecv:flag	I
    //   898: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   901: ldc_w 843
    //   904: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: aload 28
    //   909: getfield 846	com/tencent/qqmail/ftn/FtnManagerImpl$UploadRecv:nextOffset	I
    //   912: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   915: ldc_w 800
    //   918: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: invokestatic 762	android/os/SystemClock:elapsedRealtime	()J
    //   924: lload 15
    //   926: lsub
    //   927: invokevirtual 109	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   930: ldc_w 802
    //   933: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: invokestatic 805	com/tencent/qqmail/utilities/qmnetwork/QMNetworkUtils:getActiveNetworkName	()Ljava/lang/String;
    //   939: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: ldc_w 807
    //   945: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: invokestatic 810	com/tencent/qqmail/utilities/qmnetwork/QMNetworkUtils:getNetworkLevel	()I
    //   951: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   954: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   957: invokestatic 119	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   960: iload 17
    //   962: ifne +60 -> 1022
    //   965: aload 18
    //   967: invokestatic 820	com/tencent/qqmail/ftn/FtnManagerImpl:releaseSocket	(Ljava/net/Socket;)V
    //   970: aload 28
    //   972: getfield 830	com/tencent/qqmail/ftn/FtnManagerImpl$UploadRecv:error	I
    //   975: ifne -744 -> 231
    //   978: ldc2_w 753
    //   981: invokestatic 759	android/os/SystemClock:sleep	(J)V
    //   984: aload 20
    //   986: astore 21
    //   988: iconst_1
    //   989: istore 12
    //   991: iload 8
    //   993: istore 9
    //   995: iload 12
    //   997: istore 8
    //   999: aload 19
    //   1001: astore 20
    //   1003: aload 21
    //   1005: astore 19
    //   1007: goto -872 -> 135
    //   1010: iconst_0
    //   1011: istore 17
    //   1013: goto -181 -> 832
    //   1016: iconst_5
    //   1017: istore 12
    //   1019: goto -179 -> 840
    //   1022: aload 28
    //   1024: getfield 841	com/tencent/qqmail/ftn/FtnManagerImpl$UploadRecv:flag	I
    //   1027: iconst_1
    //   1028: if_icmpne +148 -> 1176
    //   1031: aload 18
    //   1033: invokestatic 820	com/tencent/qqmail/ftn/FtnManagerImpl:releaseSocket	(Ljava/net/Socket;)V
    //   1036: iconst_1
    //   1037: istore 10
    //   1039: aload 28
    //   1041: getfield 846	com/tencent/qqmail/ftn/FtnManagerImpl$UploadRecv:nextOffset	I
    //   1044: istore 11
    //   1046: aload 20
    //   1048: astore 21
    //   1050: iload 8
    //   1052: istore 12
    //   1054: iload 9
    //   1056: istore 8
    //   1058: iload 12
    //   1060: istore 9
    //   1062: aload 19
    //   1064: astore 20
    //   1066: aload 21
    //   1068: astore 19
    //   1070: goto -935 -> 135
    //   1073: iconst_5
    //   1074: ldc 68
    //   1076: new 99	java/lang/StringBuilder
    //   1079: dup
    //   1080: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   1083: ldc_w 848
    //   1086: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1089: aload 22
    //   1091: invokevirtual 726	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1094: invokevirtual 205	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1097: ldc_w 850
    //   1100: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1103: aload 4
    //   1105: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1108: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1111: invokestatic 119	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1114: aload 22
    //   1116: invokevirtual 726	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1119: ifeq +23 -> 1142
    //   1122: aload 5
    //   1124: ifnull -849 -> 275
    //   1127: aload 5
    //   1129: iconst_5
    //   1130: iconst_0
    //   1131: bipush 6
    //   1133: ldc_w 851
    //   1136: invokevirtual 301	com/tencent/qqmail/ftn/FtnDefine$FtnCallback:onError	(IIILjava/lang/String;)V
    //   1139: goto -864 -> 275
    //   1142: aload 5
    //   1144: ifnull -869 -> 275
    //   1147: aload 5
    //   1149: aload 28
    //   1151: getfield 830	com/tencent/qqmail/ftn/FtnManagerImpl$UploadRecv:error	I
    //   1154: iconst_0
    //   1155: bipush 6
    //   1157: ldc_w 295
    //   1160: invokevirtual 301	com/tencent/qqmail/ftn/FtnDefine$FtnCallback:onError	(IIILjava/lang/String;)V
    //   1163: goto -888 -> 275
    //   1166: astore 21
    //   1168: goto -475 -> 693
    //   1171: astore 21
    //   1173: goto -480 -> 693
    //   1176: goto -137 -> 1039
    //   1179: aload 19
    //   1181: astore 21
    //   1183: aload 20
    //   1185: astore 19
    //   1187: aload 21
    //   1189: astore 20
    //   1191: goto -644 -> 547
    //   1194: iload 9
    //   1196: istore 12
    //   1198: iload 8
    //   1200: istore 9
    //   1202: iload 12
    //   1204: istore 8
    //   1206: goto -885 -> 321
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1209	0	paramString1	String
    //   0	1209	1	paramInt	int
    //   0	1209	2	paramString2	String
    //   0	1209	3	paramString3	String
    //   0	1209	4	paramString4	String
    //   0	1209	5	paramFtnCallback	FtnDefine.FtnCallback
    //   0	1209	6	paramLong	long
    //   34	1171	8	i	int
    //   133	1068	9	j	int
    //   104	934	10	k	int
    //   101	944	11	m	int
    //   309	894	12	n	int
    //   92	721	13	i1	int
    //   340	543	14	i2	int
    //   370	555	15	l	long
    //   561	451	17	bool	boolean
    //   130	902	18	localObject1	Object
    //   95	1091	19	localObject2	Object
    //   98	1092	20	localObject3	Object
    //   157	528	21	localObject4	Object
    //   691	75	21	localIOException1	IOException
    //   986	81	21	localObject5	Object
    //   1166	1	21	localIOException2	IOException
    //   1171	1	21	localIOException3	IOException
    //   1181	7	21	localObject6	Object
    //   16	1099	22	localAtomicBoolean	AtomicBoolean
    //   40	292	23	arrayOfByte1	byte[]
    //   46	288	24	arrayOfByte2	byte[]
    //   53	277	25	arrayOfByte3	byte[]
    //   70	485	26	arrayOfByte4	byte[]
    //   77	734	27	arrayOfByte5	byte[]
    //   117	1033	28	localUploadRecv	UploadRecv
    // Exception table:
    //   from	to	target	type
    //   162	180	183	finally
    //   184	187	183	finally
    //   189	192	183	finally
    //   409	417	691	java/io/IOException
    //   421	528	1166	java/io/IOException
    //   532	539	1171	java/io/IOException
  }
  
  private static int uploadRecv(UploadRecv paramUploadRecv, InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt, FtnDefine.FtnCallback paramFtnCallback)
  {
    paramUploadRecv.reset();
    int k;
    for (;;)
    {
      try
      {
        k = paramInputStream.read(paramArrayOfByte);
        QMLog.log(3, "FtnManagerImpl", "uploadRecv, recvLen: " + k);
        if (k <= 0) {
          break label491;
        }
        paramInputStream = new String(paramArrayOfByte, 0, k);
        if (k >= 256)
        {
          i = 5;
          QMLog.log(i, "FtnManagerImpl", "uploadRecv, response: " + paramInputStream);
          if (k < 256) {
            break;
          }
          paramUploadRecv.error = 4;
          return k;
        }
      }
      catch (IOException paramInputStream)
      {
        QMLog.log(5, "FtnManagerImpl", "uploadRecv socket read error", paramInputStream);
        paramUploadRecv.error = 0;
        return -1;
      }
      i = 3;
    }
    paramInputStream = new BufferedReader(new StringReader(paramInputStream));
    int i = -1;
    for (;;)
    {
      int j;
      try
      {
        String str = paramInputStream.readLine();
        if (str == null) {
          break label499;
        }
        if (str.contains("HTTP"))
        {
          i = Integer.parseInt(str.split(" ")[1]);
          continue;
        }
        if (!str.contains("Content-Length: ")) {
          continue;
        }
        j = Integer.parseInt(str.split(" ")[1]);
        QMLog.log(3, "FtnManagerImpl", "uploadRecv, code: " + i + ", contentLength: " + j);
        if ((i != 200) || (j <= 0) || (k - j <= 0)) {
          break label483;
        }
        paramInputStream = new byte[j];
        System.arraycopy(paramArrayOfByte, k - j, paramInputStream, 0, j);
        i = ByteConvert.bytesToInt(paramInputStream, 0);
        j = ByteConvert.bytesToInt(paramInputStream, 4);
        paramUploadRecv.error = j;
        QMLog.log(3, "FtnManagerImpl", "uploadRecv, magicNum: " + i + ", error: " + j);
        if ((i == -1412589450) && (j == 0))
        {
          i = ByteConvert.bytesToUbyte(paramInputStream, 16);
          j = ByteConvert.bytesToInt(paramInputStream, 17);
          paramUploadRecv.flag = i;
          paramUploadRecv.nextOffset = j;
          QMLog.log(3, "FtnManagerImpl", "uploadRecv, flag: " + i + ", nextOffset: " + j);
          if (paramFtnCallback != null) {
            paramFtnCallback.onProcessData(j, paramInt);
          }
          return k;
        }
      }
      catch (Exception paramInputStream)
      {
        QMLog.log(6, "FtnManagerImpl", "uploadRecv response resolve error", paramInputStream);
        paramUploadRecv.error = 4;
        return k;
      }
      if (j == 0)
      {
        paramUploadRecv.error = 4;
        continue;
        label483:
        paramUploadRecv.error = 4;
        continue;
        label491:
        paramUploadRecv.error = 0;
        continue;
        label499:
        j = -1;
      }
    }
  }
  
  private static boolean uploadSend(OutputStream paramOutputStream, byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramOutputStream.write(paramArrayOfByte, 0, paramInt);
      paramOutputStream.flush();
      return true;
    }
    catch (Exception paramOutputStream)
    {
      QMLog.log(5, "FtnManagerImpl", "upload, send data error, sendLen: " + paramArrayOfByte.length, paramOutputStream);
    }
    return false;
  }
  
  static abstract class AbstractFtnTask
  {
    static final String FTN_BIZ_URL = "https://ftn.exmail.qq.com/cgi-bin/";
    static final String FTN_CGI_FTN = "ftn";
    static final String FTN_CGI_LOGIN = "ftnlogin";
    static final String FTN_CGI_USER_PROFILE = "ftnuserprofile";
    static final int FTN_METHOD_CREATE = 1;
    static final int FTN_METHOD_DELETE = 4;
    static final int FTN_METHOD_READ = 2;
    static final int FTN_METHOD_UPDATE = 3;
    static final String FTN_PATH_ADD_VIDEO = "addvideotask";
    static final String FTN_PATH_CREATE_FILE = "createfile";
    static final String FTN_PATH_DEL_FILE = "DelFile";
    static final String FTN_PATH_FAV_FILE_LIST = "favfilelist";
    static final String FTN_PATH_FILE_LIST = "filelist";
    static final String FTN_PATH_GET_SHARE_URL = "getshareurl";
    static final String FTN_PATH_READ_FILE = "file";
    static final String FTN_PATH_RENEW_FILE = "ReNewFile";
    static final String FTN_PATH_SHOW_USER = "ShowUsr";
    static final String FTN_PATH_STORE_FILE = "storefile";
    static final String FTN_PATH_VIEW_VIDEO = "viewvideo";
    static final String FTN_URL = "https://ftn.mail.qq.com/cgi-bin/";
    protected FtnDefine.FtnCallback mCallback;
    FtnManagerImpl.FtnTaskError mError = new FtnManagerImpl.FtnTaskError(null);
    String mFuncTag;
    
    AbstractFtnTask(String paramString, FtnDefine.FtnCallback paramFtnCallback)
    {
      this.mCallback = paramFtnCallback;
      this.mFuncTag = ("[" + paramString + "--" + FtnManagerImpl.access$1100().getUin() + "]");
    }
    
    abstract QMNetworkRequest buildRequest();
    
    abstract Observable<Void> create();
    
    protected String getUrl(boolean paramBoolean, String paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramBoolean) {}
      for (String str = "https://ftn.exmail.qq.com/cgi-bin/";; str = "https://ftn.mail.qq.com/cgi-bin/") {
        return str + paramString + "?apv=" + AppConfig.getCodeVersion();
      }
    }
    
    abstract void handleResponse(QMNetworkResponse paramQMNetworkResponse, FtnManagerImpl.FtnTaskError paramFtnTaskError);
    
    void handleSessionTimeout(FtnManagerImpl.FtnTaskError paramFtnTaskError)
    {
      SPManager.getEditor("ftn_info").remove("sid").apply();
      paramFtnTaskError.isSessionTimeout = true;
    }
    
    Observable<Void> request()
    {
      QMLog.log(3, "FtnManagerImpl", this.mFuncTag + " create request Observable");
      return Observable.defer(new FtnManagerImpl.AbstractFtnTask.7(this)).observeOn(QMSchedulers.network()).flatMap(new FtnManagerImpl.AbstractFtnTask.6(this)).onErrorReturn(new FtnManagerImpl.AbstractFtnTask.5(this)).observeOn(QMSchedulers.io()).flatMap(new FtnManagerImpl.AbstractFtnTask.4(this));
    }
    
    void run()
    {
      create().subscribe(new FtnManagerImpl.AbstractFtnTask.1(this), new FtnManagerImpl.AbstractFtnTask.2(this), new FtnManagerImpl.AbstractFtnTask.3(this));
    }
  }
  
  static abstract class AbstractSessionTask
    extends FtnManagerImpl.AbstractFtnTask
  {
    private int mRetryCount;
    
    AbstractSessionTask(String paramString, FtnDefine.FtnCallback paramFtnCallback)
    {
      super(paramFtnCallback);
    }
    
    private void handleError(CGIOutputHeader paramCGIOutputHeader, FtnManagerImpl.FtnTaskError paramFtnTaskError)
    {
      if ((paramCGIOutputHeader != null) && (paramCGIOutputHeader.retcode == 0)) {
        return;
      }
      paramFtnTaskError.isError = true;
      paramFtnTaskError.errType = 2;
      if (paramCGIOutputHeader == null) {}
      for (int i = 0;; i = paramCGIOutputHeader.retcode)
      {
        paramFtnTaskError.headerCode = i;
        Log.d("FtnManagerImpl", "handleError headerCode:" + paramFtnTaskError.headerCode);
        return;
      }
    }
    
    abstract byte[] body();
    
    CGIInputHeader buildInputHeader(String paramString1, String paramString2, int paramInt)
    {
      CGIInputHeader localCGIInputHeader = new CGIInputHeader();
      localCGIInputHeader.uin = ((int)Long.parseLong(paramString1));
      localCGIInputHeader.method = paramInt;
      localCGIInputHeader.path = paramString2;
      localCGIInputHeader.appid = 2;
      localCGIInputHeader.appversion = 1200000;
      return localCGIInputHeader;
    }
    
    /* Error */
    QMNetworkRequest buildRequest()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: iconst_0
      //   3: istore_1
      //   4: iconst_3
      //   5: ldc 40
      //   7: new 42	java/lang/StringBuilder
      //   10: dup
      //   11: invokespecial 45	java/lang/StringBuilder:<init>	()V
      //   14: aload_0
      //   15: getfield 103	com/tencent/qqmail/ftn/FtnManagerImpl$AbstractSessionTask:mFuncTag	Ljava/lang/String;
      //   18: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   21: ldc 105
      //   23: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   26: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   29: invokestatic 111	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
      //   32: invokestatic 115	com/tencent/qqmail/ftn/FtnManagerImpl:access$1100	()Lcom/tencent/qqmail/account/model/QQMailAccount;
      //   35: astore 7
      //   37: new 117	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest
      //   40: dup
      //   41: aload_0
      //   42: aload 7
      //   44: invokevirtual 123	com/tencent/qqmail/account/model/QQMailAccount:isBizMail	()Z
      //   47: aload_0
      //   48: invokevirtual 126	com/tencent/qqmail/ftn/FtnManagerImpl$AbstractSessionTask:cgi	()Ljava/lang/String;
      //   51: invokevirtual 130	com/tencent/qqmail/ftn/FtnManagerImpl$AbstractSessionTask:getUrl	(ZLjava/lang/String;)Ljava/lang/String;
      //   54: getstatic 136	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest$QMHttpMethod:QMHttpMethod_MULTIPART	Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest$QMHttpMethod;
      //   57: invokespecial 139	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:<init>	(Ljava/lang/String;Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest$QMHttpMethod;)V
      //   60: astore 6
      //   62: aload 6
      //   64: iconst_1
      //   65: invokevirtual 143	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:setRawResponse	(Z)V
      //   68: aload 6
      //   70: iconst_1
      //   71: invokevirtual 146	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:setRawPost	(Z)V
      //   74: ldc 148
      //   76: invokestatic 154	com/tencent/qqmail/utilities/sharedpreference/SPManager:getSp	(Ljava/lang/String;)Landroid/content/SharedPreferences;
      //   79: ldc 156
      //   81: aconst_null
      //   82: invokeinterface 162 3 0
      //   87: astore 5
      //   89: aload_0
      //   90: aload 7
      //   92: invokevirtual 165	com/tencent/qqmail/account/model/QQMailAccount:getUin	()Ljava/lang/String;
      //   95: aload_0
      //   96: invokevirtual 167	com/tencent/qqmail/ftn/FtnManagerImpl$AbstractSessionTask:path	()Ljava/lang/String;
      //   99: aload_0
      //   100: invokevirtual 170	com/tencent/qqmail/ftn/FtnManagerImpl$AbstractSessionTask:method	()I
      //   103: invokevirtual 172	com/tencent/qqmail/ftn/FtnManagerImpl$AbstractSessionTask:buildInputHeader	(Ljava/lang/String;Ljava/lang/String;I)Lcom/tencent/qqmail/ftn/Ftn/CGIInputHeader;
      //   106: invokevirtual 175	com/tencent/qqmail/ftn/Ftn/CGIInputHeader:toByteArray	()[B
      //   109: astore 4
      //   111: aload 4
      //   113: arraylength
      //   114: istore_2
      //   115: aload_0
      //   116: invokevirtual 177	com/tencent/qqmail/ftn/FtnManagerImpl$AbstractSessionTask:body	()[B
      //   119: astore 8
      //   121: aload 8
      //   123: ifnonnull +187 -> 310
      //   126: iload_2
      //   127: iload_1
      //   128: iadd
      //   129: newarray byte
      //   131: astore 9
      //   133: aload 4
      //   135: iconst_0
      //   136: aload 9
      //   138: iconst_0
      //   139: iload_2
      //   140: invokestatic 183	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   143: iload_1
      //   144: ifle +13 -> 157
      //   147: aload 8
      //   149: iconst_0
      //   150: aload 9
      //   152: iload_2
      //   153: iload_1
      //   154: invokestatic 183	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   157: aload 9
      //   159: aload 5
      //   161: iconst_0
      //   162: bipush 16
      //   164: invokevirtual 189	java/lang/String:substring	(II)Ljava/lang/String;
      //   167: invokestatic 195	com/tencent/qqmail/utilities/encryptionalgorithm/Aes:aesRawEncode	([BLjava/lang/String;)[B
      //   170: astore 8
      //   172: new 197	java/io/ByteArrayOutputStream
      //   175: dup
      //   176: aload 8
      //   178: arraylength
      //   179: bipush 12
      //   181: iadd
      //   182: invokespecial 200	java/io/ByteArrayOutputStream:<init>	(I)V
      //   185: astore 4
      //   187: aload 4
      //   189: iload_2
      //   190: invokestatic 206	com/tencent/qqmail/utilities/ByteConvert:intToBytes	(I)[B
      //   193: invokevirtual 210	java/io/ByteArrayOutputStream:write	([B)V
      //   196: aload 4
      //   198: iload_1
      //   199: invokestatic 206	com/tencent/qqmail/utilities/ByteConvert:intToBytes	(I)[B
      //   202: invokevirtual 210	java/io/ByteArrayOutputStream:write	([B)V
      //   205: aload 4
      //   207: aload 7
      //   209: invokevirtual 165	com/tencent/qqmail/account/model/QQMailAccount:getUin	()Ljava/lang/String;
      //   212: invokestatic 77	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   215: l2i
      //   216: invokestatic 206	com/tencent/qqmail/utilities/ByteConvert:intToBytes	(I)[B
      //   219: invokevirtual 210	java/io/ByteArrayOutputStream:write	([B)V
      //   222: aload 4
      //   224: aload 8
      //   226: invokevirtual 210	java/io/ByteArrayOutputStream:write	([B)V
      //   229: aload 6
      //   231: ldc 212
      //   233: aload 4
      //   235: invokevirtual 213	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   238: invokevirtual 217	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:addMultipartData	(Ljava/lang/String;[B)V
      //   241: new 219	java/util/HashMap
      //   244: dup
      //   245: invokespecial 220	java/util/HashMap:<init>	()V
      //   248: astore_3
      //   249: aload_3
      //   250: ldc 222
      //   252: new 42	java/lang/StringBuilder
      //   255: dup
      //   256: invokespecial 45	java/lang/StringBuilder:<init>	()V
      //   259: ldc 224
      //   261: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   264: aload 8
      //   266: arraylength
      //   267: bipush 12
      //   269: iadd
      //   270: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   273: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   276: invokevirtual 228	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   279: pop
      //   280: aload_3
      //   281: ldc 230
      //   283: aload 5
      //   285: bipush 16
      //   287: bipush 24
      //   289: invokevirtual 189	java/lang/String:substring	(II)Ljava/lang/String;
      //   292: invokevirtual 228	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   295: pop
      //   296: aload 6
      //   298: aload_3
      //   299: invokevirtual 234	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:setRequestHeaders	(Ljava/util/HashMap;)V
      //   302: aload 4
      //   304: invokevirtual 237	java/io/ByteArrayOutputStream:close	()V
      //   307: aload 6
      //   309: areturn
      //   310: aload 8
      //   312: arraylength
      //   313: istore_1
      //   314: goto -188 -> 126
      //   317: astore 4
      //   319: iconst_5
      //   320: ldc 40
      //   322: new 42	java/lang/StringBuilder
      //   325: dup
      //   326: invokespecial 45	java/lang/StringBuilder:<init>	()V
      //   329: aload_0
      //   330: getfield 103	com/tencent/qqmail/ftn/FtnManagerImpl$AbstractSessionTask:mFuncTag	Ljava/lang/String;
      //   333: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   336: ldc 105
      //   338: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   341: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   344: aload 4
      //   346: invokestatic 240	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   349: aload_3
      //   350: invokevirtual 237	java/io/ByteArrayOutputStream:close	()V
      //   353: aload 6
      //   355: areturn
      //   356: astore_3
      //   357: aload 6
      //   359: areturn
      //   360: astore_3
      //   361: aconst_null
      //   362: astore 4
      //   364: aload 4
      //   366: invokevirtual 237	java/io/ByteArrayOutputStream:close	()V
      //   369: aload_3
      //   370: athrow
      //   371: astore_3
      //   372: aload 6
      //   374: areturn
      //   375: astore 4
      //   377: goto -8 -> 369
      //   380: astore_3
      //   381: goto -17 -> 364
      //   384: astore 5
      //   386: aload_3
      //   387: astore 4
      //   389: aload 5
      //   391: astore_3
      //   392: goto -28 -> 364
      //   395: astore 5
      //   397: aload 4
      //   399: astore_3
      //   400: aload 5
      //   402: astore 4
      //   404: goto -85 -> 319
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	407	0	this	AbstractSessionTask
      //   3	311	1	i	int
      //   114	76	2	j	int
      //   1	349	3	localHashMap	java.util.HashMap
      //   356	1	3	localException1	Exception
      //   360	10	3	localObject1	Object
      //   371	1	3	localException2	Exception
      //   380	7	3	localObject2	Object
      //   391	9	3	localObject3	Object
      //   109	194	4	localObject4	Object
      //   317	28	4	localThrowable1	Throwable
      //   362	3	4	localObject5	Object
      //   375	1	4	localException3	Exception
      //   387	16	4	localObject6	Object
      //   87	197	5	str	String
      //   384	6	5	localObject7	Object
      //   395	6	5	localThrowable2	Throwable
      //   60	313	6	localQMNetworkRequest	QMNetworkRequest
      //   35	173	7	localQQMailAccount	QQMailAccount
      //   119	192	8	arrayOfByte1	byte[]
      //   131	27	9	arrayOfByte2	byte[]
      // Exception table:
      //   from	to	target	type
      //   89	121	317	java/lang/Throwable
      //   126	143	317	java/lang/Throwable
      //   147	157	317	java/lang/Throwable
      //   157	187	317	java/lang/Throwable
      //   310	314	317	java/lang/Throwable
      //   349	353	356	java/lang/Exception
      //   89	121	360	finally
      //   126	143	360	finally
      //   147	157	360	finally
      //   157	187	360	finally
      //   310	314	360	finally
      //   302	307	371	java/lang/Exception
      //   364	369	375	java/lang/Exception
      //   187	302	380	finally
      //   319	349	384	finally
      //   187	302	395	java/lang/Throwable
    }
    
    abstract String cgi();
    
    Observable<Void> create()
    {
      QMLog.log(3, "FtnManagerImpl", this.mFuncTag + " create request Observer");
      return FtnManagerImpl.AutoLoginTask.instance.prepareSid().flatMap(new FtnManagerImpl.AbstractSessionTask.4(this)).retryWhen(new FtnManagerImpl.AbstractSessionTask.3(this)).doOnError(new FtnManagerImpl.AbstractSessionTask.2(this)).doOnCompleted(new FtnManagerImpl.AbstractSessionTask.1(this));
    }
    
    /* Error */
    void handleResponse(QMNetworkResponse paramQMNetworkResponse, FtnManagerImpl.FtnTaskError paramFtnTaskError)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 8
      //   3: ldc 148
      //   5: invokestatic 154	com/tencent/qqmail/utilities/sharedpreference/SPManager:getSp	(Ljava/lang/String;)Landroid/content/SharedPreferences;
      //   8: ldc 156
      //   10: aconst_null
      //   11: invokeinterface 162 3 0
      //   16: astore 5
      //   18: aload 5
      //   20: invokestatic 294	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   23: ifeq +38 -> 61
      //   26: iconst_5
      //   27: ldc 40
      //   29: new 42	java/lang/StringBuilder
      //   32: dup
      //   33: invokespecial 45	java/lang/StringBuilder:<init>	()V
      //   36: aload_0
      //   37: getfield 103	com/tencent/qqmail/ftn/FtnManagerImpl$AbstractSessionTask:mFuncTag	Ljava/lang/String;
      //   40: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   43: ldc_w 296
      //   46: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   49: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   52: invokestatic 111	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
      //   55: aload_2
      //   56: iconst_1
      //   57: putfield 299	com/tencent/qqmail/ftn/FtnManagerImpl$FtnTaskError:isSessionTimeout	Z
      //   60: return
      //   61: aload 5
      //   63: iconst_0
      //   64: bipush 16
      //   66: invokevirtual 189	java/lang/String:substring	(II)Ljava/lang/String;
      //   69: astore 6
      //   71: aload_1
      //   72: invokevirtual 304	com/tencent/qqmail/utilities/qmnetwork/QMNetworkResponse:getResponseData	()[B
      //   75: astore_1
      //   76: new 306	java/io/ByteArrayInputStream
      //   79: dup
      //   80: aload_1
      //   81: invokespecial 308	java/io/ByteArrayInputStream:<init>	([B)V
      //   84: astore 7
      //   86: aload 7
      //   88: astore 5
      //   90: iconst_4
      //   91: newarray byte
      //   93: astore 9
      //   95: aload 7
      //   97: astore 5
      //   99: aload 7
      //   101: aload 9
      //   103: invokevirtual 312	java/io/ByteArrayInputStream:read	([B)I
      //   106: pop
      //   107: aload 7
      //   109: astore 5
      //   111: aload 9
      //   113: invokestatic 315	com/tencent/qqmail/utilities/ByteConvert:bytesToInt	([B)I
      //   116: istore_3
      //   117: aload 7
      //   119: astore 5
      //   121: aload 7
      //   123: aload 9
      //   125: invokevirtual 312	java/io/ByteArrayInputStream:read	([B)I
      //   128: pop
      //   129: aload 7
      //   131: astore 5
      //   133: aload 9
      //   135: invokestatic 315	com/tencent/qqmail/utilities/ByteConvert:bytesToInt	([B)I
      //   138: istore 4
      //   140: aload 7
      //   142: astore 5
      //   144: aload 7
      //   146: aload 9
      //   148: invokevirtual 312	java/io/ByteArrayInputStream:read	([B)I
      //   151: pop
      //   152: aload 7
      //   154: astore 5
      //   156: iconst_3
      //   157: ldc 40
      //   159: new 42	java/lang/StringBuilder
      //   162: dup
      //   163: invokespecial 45	java/lang/StringBuilder:<init>	()V
      //   166: aload_0
      //   167: getfield 103	com/tencent/qqmail/ftn/FtnManagerImpl$AbstractSessionTask:mFuncTag	Ljava/lang/String;
      //   170: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   173: ldc_w 317
      //   176: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   179: iload_3
      //   180: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   183: ldc_w 319
      //   186: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   189: iload 4
      //   191: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   194: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   197: invokestatic 111	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
      //   200: aload 7
      //   202: astore 5
      //   204: aload_1
      //   205: arraylength
      //   206: bipush 12
      //   208: isub
      //   209: newarray byte
      //   211: astore_1
      //   212: aload 7
      //   214: astore 5
      //   216: aload 7
      //   218: aload_1
      //   219: invokevirtual 312	java/io/ByteArrayInputStream:read	([B)I
      //   222: pop
      //   223: aload 7
      //   225: astore 5
      //   227: aload_1
      //   228: aload 6
      //   230: invokestatic 322	com/tencent/qqmail/utilities/encryptionalgorithm/Aes:aesRawDecode	([BLjava/lang/String;)[B
      //   233: astore_1
      //   234: aload_1
      //   235: ifnonnull +53 -> 288
      //   238: aload 7
      //   240: astore 5
      //   242: iconst_5
      //   243: ldc 40
      //   245: new 42	java/lang/StringBuilder
      //   248: dup
      //   249: invokespecial 45	java/lang/StringBuilder:<init>	()V
      //   252: aload_0
      //   253: getfield 103	com/tencent/qqmail/ftn/FtnManagerImpl$AbstractSessionTask:mFuncTag	Ljava/lang/String;
      //   256: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   259: ldc_w 324
      //   262: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   265: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   268: invokestatic 111	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
      //   271: aload 7
      //   273: astore 5
      //   275: aload_0
      //   276: aload_2
      //   277: invokevirtual 328	com/tencent/qqmail/ftn/FtnManagerImpl$AbstractSessionTask:handleSessionTimeout	(Lcom/tencent/qqmail/ftn/FtnManagerImpl$FtnTaskError;)V
      //   280: aload 7
      //   282: invokevirtual 329	java/io/ByteArrayInputStream:close	()V
      //   285: return
      //   286: astore_1
      //   287: return
      //   288: aload 7
      //   290: astore 5
      //   292: aload 7
      //   294: invokevirtual 329	java/io/ByteArrayInputStream:close	()V
      //   297: aload 7
      //   299: astore 5
      //   301: new 306	java/io/ByteArrayInputStream
      //   304: dup
      //   305: aload_1
      //   306: invokespecial 308	java/io/ByteArrayInputStream:<init>	([B)V
      //   309: astore_1
      //   310: iload_3
      //   311: ifle +306 -> 617
      //   314: new 23	com/tencent/qqmail/ftn/Ftn/CGIOutputHeader
      //   317: dup
      //   318: invokespecial 330	com/tencent/qqmail/ftn/Ftn/CGIOutputHeader:<init>	()V
      //   321: astore 7
      //   323: iload_3
      //   324: newarray byte
      //   326: astore 9
      //   328: aload_1
      //   329: aload 9
      //   331: invokevirtual 312	java/io/ByteArrayInputStream:read	([B)I
      //   334: pop
      //   335: aload 7
      //   337: aload 9
      //   339: invokevirtual 334	com/tencent/qqmail/ftn/Ftn/CGIOutputHeader:parseFrom	([B)Lcom/tencent/qqmail/ftn/Ftn/CGIOutputHeader;
      //   342: pop
      //   343: iconst_4
      //   344: ldc 40
      //   346: new 42	java/lang/StringBuilder
      //   349: dup
      //   350: invokespecial 45	java/lang/StringBuilder:<init>	()V
      //   353: aload_0
      //   354: getfield 103	com/tencent/qqmail/ftn/FtnManagerImpl$AbstractSessionTask:mFuncTag	Ljava/lang/String;
      //   357: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   360: ldc_w 336
      //   363: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   366: aload 7
      //   368: getfield 26	com/tencent/qqmail/ftn/Ftn/CGIOutputHeader:retcode	I
      //   371: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   374: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   377: invokestatic 111	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
      //   380: aload 7
      //   382: astore 5
      //   384: aload 9
      //   386: astore 6
      //   388: aload 7
      //   390: getfield 26	com/tencent/qqmail/ftn/Ftn/CGIOutputHeader:retcode	I
      //   393: tableswitch	default:+233 -> 626, -2:+131->524, -1:+27->420, 0:+41->434
      //   421: newarray double
      //   423: invokestatic 342	moai/oss/KvHelper:ftnResponseError	([D)V
      //   426: aload 9
      //   428: astore 6
      //   430: aload 7
      //   432: astore 5
      //   434: aload 8
      //   436: astore 7
      //   438: iload 4
      //   440: ifle +16 -> 456
      //   443: iload 4
      //   445: newarray byte
      //   447: astore 7
      //   449: aload_1
      //   450: aload 7
      //   452: invokevirtual 312	java/io/ByteArrayInputStream:read	([B)I
      //   455: pop
      //   456: aload_0
      //   457: aload 5
      //   459: aload_2
      //   460: invokespecial 344	com/tencent/qqmail/ftn/FtnManagerImpl$AbstractSessionTask:handleError	(Lcom/tencent/qqmail/ftn/Ftn/CGIOutputHeader;Lcom/tencent/qqmail/ftn/FtnManagerImpl$FtnTaskError;)V
      //   463: aload_2
      //   464: getfield 32	com/tencent/qqmail/ftn/FtnManagerImpl$FtnTaskError:isError	Z
      //   467: ifne +50 -> 517
      //   470: iconst_4
      //   471: ldc 40
      //   473: new 42	java/lang/StringBuilder
      //   476: dup
      //   477: invokespecial 45	java/lang/StringBuilder:<init>	()V
      //   480: aload_0
      //   481: getfield 103	com/tencent/qqmail/ftn/FtnManagerImpl$AbstractSessionTask:mFuncTag	Ljava/lang/String;
      //   484: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   487: ldc_w 346
      //   490: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   493: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   496: invokestatic 111	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
      //   499: aload_0
      //   500: getfield 350	com/tencent/qqmail/ftn/FtnManagerImpl$AbstractSessionTask:mCallback	Lcom/tencent/qqmail/ftn/FtnDefine$FtnCallback;
      //   503: ifnull +14 -> 517
      //   506: aload_0
      //   507: getfield 350	com/tencent/qqmail/ftn/FtnManagerImpl$AbstractSessionTask:mCallback	Lcom/tencent/qqmail/ftn/FtnDefine$FtnCallback;
      //   510: aload 6
      //   512: aload 7
      //   514: invokevirtual 356	com/tencent/qqmail/ftn/FtnDefine$FtnCallback:onSuccess	([B[B)V
      //   517: aload_1
      //   518: invokevirtual 329	java/io/ByteArrayInputStream:close	()V
      //   521: return
      //   522: astore_1
      //   523: return
      //   524: aload_0
      //   525: aload_2
      //   526: invokevirtual 328	com/tencent/qqmail/ftn/FtnManagerImpl$AbstractSessionTask:handleSessionTimeout	(Lcom/tencent/qqmail/ftn/FtnManagerImpl$FtnTaskError;)V
      //   529: aload_1
      //   530: invokevirtual 329	java/io/ByteArrayInputStream:close	()V
      //   533: return
      //   534: astore_1
      //   535: return
      //   536: astore 6
      //   538: aconst_null
      //   539: astore_1
      //   540: aload_1
      //   541: astore 5
      //   543: iconst_5
      //   544: ldc 40
      //   546: aload_0
      //   547: getfield 103	com/tencent/qqmail/ftn/FtnManagerImpl$AbstractSessionTask:mFuncTag	Ljava/lang/String;
      //   550: aload 6
      //   552: invokestatic 240	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   555: aload_1
      //   556: astore 5
      //   558: aload_0
      //   559: aconst_null
      //   560: aload_2
      //   561: invokespecial 344	com/tencent/qqmail/ftn/FtnManagerImpl$AbstractSessionTask:handleError	(Lcom/tencent/qqmail/ftn/Ftn/CGIOutputHeader;Lcom/tencent/qqmail/ftn/FtnManagerImpl$FtnTaskError;)V
      //   564: aload_1
      //   565: invokevirtual 329	java/io/ByteArrayInputStream:close	()V
      //   568: return
      //   569: astore_1
      //   570: return
      //   571: astore_1
      //   572: aconst_null
      //   573: astore 5
      //   575: aload 5
      //   577: invokevirtual 329	java/io/ByteArrayInputStream:close	()V
      //   580: aload_1
      //   581: athrow
      //   582: astore 5
      //   584: goto -287 -> 297
      //   587: astore_2
      //   588: goto -8 -> 580
      //   591: astore_1
      //   592: goto -17 -> 575
      //   595: astore_2
      //   596: aload_1
      //   597: astore 5
      //   599: aload_2
      //   600: astore_1
      //   601: goto -26 -> 575
      //   604: astore 6
      //   606: aload 7
      //   608: astore_1
      //   609: goto -69 -> 540
      //   612: astore 6
      //   614: goto -74 -> 540
      //   617: aconst_null
      //   618: astore 5
      //   620: aconst_null
      //   621: astore 6
      //   623: goto -189 -> 434
      //   626: goto -206 -> 420
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	629	0	this	AbstractSessionTask
      //   0	629	1	paramQMNetworkResponse	QMNetworkResponse
      //   0	629	2	paramFtnTaskError	FtnManagerImpl.FtnTaskError
      //   116	208	3	i	int
      //   138	306	4	j	int
      //   16	560	5	localObject1	Object
      //   582	1	5	localException	Exception
      //   597	22	5	localQMNetworkResponse	QMNetworkResponse
      //   69	442	6	localObject2	Object
      //   536	15	6	localThrowable1	Throwable
      //   604	1	6	localThrowable2	Throwable
      //   612	1	6	localThrowable3	Throwable
      //   621	1	6	localObject3	Object
      //   84	523	7	localObject4	Object
      //   1	434	8	localObject5	Object
      //   93	334	9	arrayOfByte	byte[]
      // Exception table:
      //   from	to	target	type
      //   280	285	286	java/lang/Exception
      //   517	521	522	java/lang/Exception
      //   529	533	534	java/lang/Exception
      //   76	86	536	java/lang/Throwable
      //   564	568	569	java/lang/Exception
      //   76	86	571	finally
      //   292	297	582	java/lang/Exception
      //   575	580	587	java/lang/Exception
      //   90	95	591	finally
      //   99	107	591	finally
      //   111	117	591	finally
      //   121	129	591	finally
      //   133	140	591	finally
      //   144	152	591	finally
      //   156	200	591	finally
      //   204	212	591	finally
      //   216	223	591	finally
      //   227	234	591	finally
      //   242	271	591	finally
      //   275	280	591	finally
      //   292	297	591	finally
      //   301	310	591	finally
      //   543	555	591	finally
      //   558	564	591	finally
      //   314	380	595	finally
      //   388	420	595	finally
      //   420	426	595	finally
      //   443	456	595	finally
      //   456	517	595	finally
      //   524	529	595	finally
      //   90	95	604	java/lang/Throwable
      //   99	107	604	java/lang/Throwable
      //   111	117	604	java/lang/Throwable
      //   121	129	604	java/lang/Throwable
      //   133	140	604	java/lang/Throwable
      //   144	152	604	java/lang/Throwable
      //   156	200	604	java/lang/Throwable
      //   204	212	604	java/lang/Throwable
      //   216	223	604	java/lang/Throwable
      //   227	234	604	java/lang/Throwable
      //   242	271	604	java/lang/Throwable
      //   275	280	604	java/lang/Throwable
      //   292	297	604	java/lang/Throwable
      //   301	310	604	java/lang/Throwable
      //   314	380	612	java/lang/Throwable
      //   388	420	612	java/lang/Throwable
      //   420	426	612	java/lang/Throwable
      //   443	456	612	java/lang/Throwable
      //   456	517	612	java/lang/Throwable
      //   524	529	612	java/lang/Throwable
    }
    
    abstract int method();
    
    abstract String path();
  }
  
  static class AutoLoginTask
    extends FtnManagerImpl.AbstractFtnTask
  {
    static AutoLoginTask instance = new AutoLoginTask(null);
    volatile Observable<Void> mMailAutoLoginObs;
    volatile Observable<Void> mRequestSidObs;
    
    AutoLoginTask(FtnDefine.FtnCallback paramFtnCallback)
    {
      super(paramFtnCallback);
    }
    
    private String buildAutoLoginBody(QQMailAccount paramQQMailAccount)
    {
      String str1 = paramQQMailAccount.getSid();
      paramQQMailAccount = paramQQMailAccount.getEmail();
      Object localObject = paramQQMailAccount.split("@");
      String str2 = localObject[1].toLowerCase(Locale.getDefault());
      int i = -1;
      switch (str2.hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          localObject = "other";
        }
        break;
      }
      for (;;)
      {
        return "uin=" + paramQQMailAccount + "&pwd=&aliastype=" + (String)localObject + "&ftnlogin=yes&error=app&devicetoken=$devicetoken$&apv=1.2&vt=app&autologinpwd=&ssid=" + str1;
        if (!str2.equals("qq.com")) {
          break;
        }
        i = 0;
        break;
        if (!str2.equals("foxmail.com")) {
          break;
        }
        i = 1;
        break;
        if (!str2.equals("vip.qq.com")) {
          break;
        }
        i = 2;
        break;
        paramQQMailAccount = localObject[0];
        localObject = "@qq.com";
        continue;
        paramQQMailAccount = localObject[0];
        localObject = "fox";
        continue;
        paramQQMailAccount = localObject[0];
        localObject = "vip";
      }
    }
    
    private void handleError(CGIOutputHeader paramCGIOutputHeader, LoginOutput paramLoginOutput, FtnManagerImpl.FtnTaskError paramFtnTaskError)
    {
      if ((paramCGIOutputHeader != null) && (paramLoginOutput != null) && (paramCGIOutputHeader.retcode == 0) && (paramLoginOutput.code == 0)) {
        return;
      }
      paramFtnTaskError.isError = true;
      paramFtnTaskError.errType = 4;
      if ((paramCGIOutputHeader == null) || (paramLoginOutput == null))
      {
        paramFtnTaskError.headerCode = 0;
        paramFtnTaskError.bodyCode = 0;
        return;
      }
      paramFtnTaskError.headerCode = paramCGIOutputHeader.retcode;
      switch (paramLoginOutput.code)
      {
      default: 
        paramFtnTaskError.bodyCode = 0;
        return;
      case 1: 
        paramFtnTaskError.bodyCode = 2;
        paramFtnTaskError.isMailSessionTimeout = true;
        return;
      case 2: 
        paramFtnTaskError.bodyCode = 4;
        return;
      case 3: 
        paramFtnTaskError.bodyCode = 7;
        return;
      case 4: 
        paramFtnTaskError.bodyCode = 6;
        return;
      case 5: 
        paramFtnTaskError.bodyCode = 4;
        return;
      case 6: 
        paramFtnTaskError.bodyCode = 3;
        return;
      case 7: 
        paramFtnTaskError.bodyCode = 5;
        return;
      case 8: 
        paramFtnTaskError.bodyCode = 9;
        return;
      case 10: 
        paramFtnTaskError.bodyCode = 8;
        return;
      }
      paramFtnTaskError.bodyCode = 11;
    }
    
    QMNetworkRequest buildRequest()
    {
      QQMailAccount localQQMailAccount = FtnManagerImpl.access$1100();
      QMNetworkRequest localQMNetworkRequest = new QMNetworkRequest(getUrl(localQQMailAccount.isBizMail(), "ftnlogin"), QMNetworkRequest.QMHttpMethod.QMHttpMethod_POST);
      localQMNetworkRequest.setRawResponse(true);
      localQMNetworkRequest.setRequestParams(buildAutoLoginBody(localQQMailAccount));
      return localQMNetworkRequest;
    }
    
    Observable<Void> create()
    {
      return prepareSid();
    }
    
    /* Error */
    void handleResponse(QMNetworkResponse paramQMNetworkResponse, FtnManagerImpl.FtnTaskError paramFtnTaskError)
    {
      // Byte code:
      //   0: iconst_m1
      //   1: istore 4
      //   3: new 181	java/io/ByteArrayInputStream
      //   6: dup
      //   7: aload_1
      //   8: invokevirtual 187	com/tencent/qqmail/utilities/qmnetwork/QMNetworkResponse:getResponseData	()[B
      //   11: ldc 189
      //   13: invokestatic 195	com/tencent/qqmail/utilities/encryptionalgorithm/Aes:aesRawDecode	([BLjava/lang/String;)[B
      //   16: invokespecial 198	java/io/ByteArrayInputStream:<init>	([B)V
      //   19: astore 6
      //   21: aload 6
      //   23: astore_1
      //   24: iconst_4
      //   25: newarray byte
      //   27: astore 7
      //   29: aload 6
      //   31: astore_1
      //   32: aload 6
      //   34: aload 7
      //   36: invokevirtual 202	java/io/ByteArrayInputStream:read	([B)I
      //   39: pop
      //   40: aload 6
      //   42: astore_1
      //   43: aload 7
      //   45: invokestatic 207	com/tencent/qqmail/utilities/ByteConvert:bytesToInt	([B)I
      //   48: istore_3
      //   49: aload 6
      //   51: astore_1
      //   52: aload 6
      //   54: aload 7
      //   56: invokevirtual 202	java/io/ByteArrayInputStream:read	([B)I
      //   59: pop
      //   60: aload 6
      //   62: astore_1
      //   63: aload 7
      //   65: invokestatic 207	com/tencent/qqmail/utilities/ByteConvert:bytesToInt	([B)I
      //   68: istore 5
      //   70: aload 6
      //   72: astore_1
      //   73: aload 6
      //   75: aload 7
      //   77: invokevirtual 202	java/io/ByteArrayInputStream:read	([B)I
      //   80: pop
      //   81: iload_3
      //   82: ifle +437 -> 519
      //   85: aload 6
      //   87: astore_1
      //   88: new 102	com/tencent/qqmail/ftn/Ftn/CGIOutputHeader
      //   91: dup
      //   92: invokespecial 208	com/tencent/qqmail/ftn/Ftn/CGIOutputHeader:<init>	()V
      //   95: astore 8
      //   97: aload 6
      //   99: astore_1
      //   100: iload_3
      //   101: newarray byte
      //   103: astore 7
      //   105: aload 6
      //   107: astore_1
      //   108: aload 6
      //   110: aload 7
      //   112: invokevirtual 202	java/io/ByteArrayInputStream:read	([B)I
      //   115: pop
      //   116: aload 6
      //   118: astore_1
      //   119: aload 8
      //   121: aload 7
      //   123: invokevirtual 212	com/tencent/qqmail/ftn/Ftn/CGIOutputHeader:parseFrom	([B)Lcom/tencent/qqmail/ftn/Ftn/CGIOutputHeader;
      //   126: pop
      //   127: iload 5
      //   129: ifle +381 -> 510
      //   132: aload 6
      //   134: astore_1
      //   135: new 108	com/tencent/qqmail/ftn/Ftn/LoginOutput
      //   138: dup
      //   139: invokespecial 213	com/tencent/qqmail/ftn/Ftn/LoginOutput:<init>	()V
      //   142: astore 10
      //   144: aload 6
      //   146: astore_1
      //   147: iload 5
      //   149: newarray byte
      //   151: astore 9
      //   153: aload 6
      //   155: astore_1
      //   156: aload 6
      //   158: aload 9
      //   160: invokevirtual 202	java/io/ByteArrayInputStream:read	([B)I
      //   163: pop
      //   164: aload 6
      //   166: astore_1
      //   167: aload 10
      //   169: aload 9
      //   171: invokevirtual 216	com/tencent/qqmail/ftn/Ftn/LoginOutput:parseFrom	([B)Lcom/tencent/qqmail/ftn/Ftn/LoginOutput;
      //   174: pop
      //   175: aload 6
      //   177: astore_1
      //   178: ldc 218
      //   180: new 67	java/lang/StringBuilder
      //   183: dup
      //   184: invokespecial 69	java/lang/StringBuilder:<init>	()V
      //   187: aload_0
      //   188: getfield 222	com/tencent/qqmail/ftn/FtnManagerImpl$AutoLoginTask:mFuncTag	Ljava/lang/String;
      //   191: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   194: ldc 224
      //   196: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   199: aload 10
      //   201: getfield 227	com/tencent/qqmail/ftn/Ftn/LoginOutput:sid	Ljava/lang/String;
      //   204: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   207: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   210: invokestatic 233	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
      //   213: pop
      //   214: aload 6
      //   216: astore_1
      //   217: ldc 235
      //   219: invokestatic 241	com/tencent/qqmail/utilities/sharedpreference/SPManager:getEditor	(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
      //   222: ldc 242
      //   224: aload 10
      //   226: getfield 227	com/tencent/qqmail/ftn/Ftn/LoginOutput:sid	Ljava/lang/String;
      //   229: invokeinterface 248 3 0
      //   234: ldc 250
      //   236: invokestatic 256	java/lang/System:currentTimeMillis	()J
      //   239: invokeinterface 260 4 0
      //   244: invokeinterface 263 1 0
      //   249: aload 6
      //   251: astore_1
      //   252: aload_0
      //   253: aload 8
      //   255: aload 10
      //   257: aload_2
      //   258: invokespecial 265	com/tencent/qqmail/ftn/FtnManagerImpl$AutoLoginTask:handleError	(Lcom/tencent/qqmail/ftn/Ftn/CGIOutputHeader;Lcom/tencent/qqmail/ftn/Ftn/LoginOutput;Lcom/tencent/qqmail/ftn/FtnManagerImpl$FtnTaskError;)V
      //   261: aload 6
      //   263: astore_1
      //   264: new 67	java/lang/StringBuilder
      //   267: dup
      //   268: invokespecial 69	java/lang/StringBuilder:<init>	()V
      //   271: aload_0
      //   272: getfield 222	com/tencent/qqmail/ftn/FtnManagerImpl$AutoLoginTask:mFuncTag	Ljava/lang/String;
      //   275: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   278: ldc_w 267
      //   281: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   284: astore 11
      //   286: aload 8
      //   288: ifnull +136 -> 424
      //   291: aload 6
      //   293: astore_1
      //   294: aload 8
      //   296: getfield 106	com/tencent/qqmail/ftn/Ftn/CGIOutputHeader:retcode	I
      //   299: istore_3
      //   300: aload 6
      //   302: astore_1
      //   303: aload 11
      //   305: iload_3
      //   306: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   309: ldc_w 272
      //   312: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   315: astore 8
      //   317: iload 4
      //   319: istore_3
      //   320: aload 10
      //   322: ifnull +12 -> 334
      //   325: aload 6
      //   327: astore_1
      //   328: aload 10
      //   330: getfield 111	com/tencent/qqmail/ftn/Ftn/LoginOutput:code	I
      //   333: istore_3
      //   334: aload 6
      //   336: astore_1
      //   337: iconst_4
      //   338: ldc 218
      //   340: aload 8
      //   342: iload_3
      //   343: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   346: ldc_w 274
      //   349: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   352: aload_2
      //   353: getfield 117	com/tencent/qqmail/ftn/FtnManagerImpl$FtnTaskError:isError	Z
      //   356: invokevirtual 277	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   359: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   362: invokestatic 283	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
      //   365: aload 6
      //   367: astore_1
      //   368: aload_2
      //   369: getfield 129	com/tencent/qqmail/ftn/FtnManagerImpl$FtnTaskError:isMailSessionTimeout	Z
      //   372: ifeq +12 -> 384
      //   375: aload 6
      //   377: astore_1
      //   378: invokestatic 135	com/tencent/qqmail/ftn/FtnManagerImpl:access$1100	()Lcom/tencent/qqmail/account/model/QQMailAccount;
      //   381: invokevirtual 286	com/tencent/qqmail/account/model/QQMailAccount:autoLogin	()V
      //   384: aload 6
      //   386: astore_1
      //   387: aload_2
      //   388: getfield 117	com/tencent/qqmail/ftn/FtnManagerImpl$FtnTaskError:isError	Z
      //   391: ifne +27 -> 418
      //   394: aload 6
      //   396: astore_1
      //   397: aload_0
      //   398: getfield 290	com/tencent/qqmail/ftn/FtnManagerImpl$AutoLoginTask:mCallback	Lcom/tencent/qqmail/ftn/FtnDefine$FtnCallback;
      //   401: ifnull +17 -> 418
      //   404: aload 6
      //   406: astore_1
      //   407: aload_0
      //   408: getfield 290	com/tencent/qqmail/ftn/FtnManagerImpl$AutoLoginTask:mCallback	Lcom/tencent/qqmail/ftn/FtnDefine$FtnCallback;
      //   411: aload 7
      //   413: aload 9
      //   415: invokevirtual 296	com/tencent/qqmail/ftn/FtnDefine$FtnCallback:onSuccess	([B[B)V
      //   418: aload 6
      //   420: invokevirtual 299	java/io/ByteArrayInputStream:close	()V
      //   423: return
      //   424: iconst_m1
      //   425: istore_3
      //   426: goto -126 -> 300
      //   429: astore 7
      //   431: aconst_null
      //   432: astore 6
      //   434: aload 6
      //   436: astore_1
      //   437: iconst_5
      //   438: ldc 218
      //   440: new 67	java/lang/StringBuilder
      //   443: dup
      //   444: invokespecial 69	java/lang/StringBuilder:<init>	()V
      //   447: aload_0
      //   448: getfield 222	com/tencent/qqmail/ftn/FtnManagerImpl$AutoLoginTask:mFuncTag	Ljava/lang/String;
      //   451: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   454: ldc_w 301
      //   457: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   460: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   463: aload 7
      //   465: invokestatic 304	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   468: aload 6
      //   470: astore_1
      //   471: aload_0
      //   472: aconst_null
      //   473: aconst_null
      //   474: aload_2
      //   475: invokespecial 265	com/tencent/qqmail/ftn/FtnManagerImpl$AutoLoginTask:handleError	(Lcom/tencent/qqmail/ftn/Ftn/CGIOutputHeader;Lcom/tencent/qqmail/ftn/Ftn/LoginOutput;Lcom/tencent/qqmail/ftn/FtnManagerImpl$FtnTaskError;)V
      //   478: aload 6
      //   480: invokevirtual 299	java/io/ByteArrayInputStream:close	()V
      //   483: return
      //   484: astore_1
      //   485: return
      //   486: astore_2
      //   487: aconst_null
      //   488: astore_1
      //   489: aload_1
      //   490: invokevirtual 299	java/io/ByteArrayInputStream:close	()V
      //   493: aload_2
      //   494: athrow
      //   495: astore_1
      //   496: return
      //   497: astore_1
      //   498: goto -5 -> 493
      //   501: astore_2
      //   502: goto -13 -> 489
      //   505: astore 7
      //   507: goto -73 -> 434
      //   510: aconst_null
      //   511: astore 9
      //   513: aconst_null
      //   514: astore 10
      //   516: goto -267 -> 249
      //   519: aconst_null
      //   520: astore 7
      //   522: aconst_null
      //   523: astore 8
      //   525: goto -398 -> 127
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	528	0	this	AutoLoginTask
      //   0	528	1	paramQMNetworkResponse	QMNetworkResponse
      //   0	528	2	paramFtnTaskError	FtnManagerImpl.FtnTaskError
      //   48	378	3	i	int
      //   1	317	4	j	int
      //   68	80	5	k	int
      //   19	460	6	localByteArrayInputStream	java.io.ByteArrayInputStream
      //   27	385	7	arrayOfByte1	byte[]
      //   429	35	7	localThrowable1	Throwable
      //   505	1	7	localThrowable2	Throwable
      //   520	1	7	localObject1	Object
      //   95	429	8	localObject2	Object
      //   151	361	9	arrayOfByte2	byte[]
      //   142	373	10	localLoginOutput	LoginOutput
      //   284	20	11	localStringBuilder	StringBuilder
      // Exception table:
      //   from	to	target	type
      //   3	21	429	java/lang/Throwable
      //   478	483	484	java/lang/Exception
      //   3	21	486	finally
      //   418	423	495	java/lang/Exception
      //   489	493	497	java/lang/Exception
      //   24	29	501	finally
      //   32	40	501	finally
      //   43	49	501	finally
      //   52	60	501	finally
      //   63	70	501	finally
      //   73	81	501	finally
      //   88	97	501	finally
      //   100	105	501	finally
      //   108	116	501	finally
      //   119	127	501	finally
      //   135	144	501	finally
      //   147	153	501	finally
      //   156	164	501	finally
      //   167	175	501	finally
      //   178	214	501	finally
      //   217	249	501	finally
      //   252	261	501	finally
      //   264	286	501	finally
      //   294	300	501	finally
      //   303	317	501	finally
      //   328	334	501	finally
      //   337	365	501	finally
      //   368	375	501	finally
      //   378	384	501	finally
      //   387	394	501	finally
      //   397	404	501	finally
      //   407	418	501	finally
      //   437	468	501	finally
      //   471	478	501	finally
      //   24	29	505	java/lang/Throwable
      //   32	40	505	java/lang/Throwable
      //   43	49	505	java/lang/Throwable
      //   52	60	505	java/lang/Throwable
      //   63	70	505	java/lang/Throwable
      //   73	81	505	java/lang/Throwable
      //   88	97	505	java/lang/Throwable
      //   100	105	505	java/lang/Throwable
      //   108	116	505	java/lang/Throwable
      //   119	127	505	java/lang/Throwable
      //   135	144	505	java/lang/Throwable
      //   147	153	505	java/lang/Throwable
      //   156	164	505	java/lang/Throwable
      //   167	175	505	java/lang/Throwable
      //   178	214	505	java/lang/Throwable
      //   217	249	505	java/lang/Throwable
      //   252	261	505	java/lang/Throwable
      //   264	286	505	java/lang/Throwable
      //   294	300	505	java/lang/Throwable
      //   303	317	505	java/lang/Throwable
      //   328	334	505	java/lang/Throwable
      //   337	365	505	java/lang/Throwable
      //   368	375	505	java/lang/Throwable
      //   378	384	505	java/lang/Throwable
      //   387	394	505	java/lang/Throwable
      //   397	404	505	java/lang/Throwable
      //   407	418	505	java/lang/Throwable
    }
    
    Observable<Void> mailAutoLogin()
    {
      if (this.mMailAutoLoginObs == null) {}
      try
      {
        if (this.mMailAutoLoginObs == null) {
          this.mMailAutoLoginObs = Observable.create(new FtnManagerImpl.AutoLoginTask.2(this)).flatMap(new FtnManagerImpl.AutoLoginTask.1(this)).share();
        }
        return this.mMailAutoLoginObs;
      }
      finally {}
    }
    
    Observable<Void> prepareSid()
    {
      QMLog.log(3, "FtnManagerImpl", this.mFuncTag + " prepareSid");
      return Observable.defer(new FtnManagerImpl.AutoLoginTask.5(this)).doOnError(new FtnManagerImpl.AutoLoginTask.4(this)).doOnCompleted(new FtnManagerImpl.AutoLoginTask.3(this));
    }
    
    Observable<Void> requestSid()
    {
      if (this.mRequestSidObs == null) {}
      try
      {
        if (this.mRequestSidObs == null) {
          this.mRequestSidObs = request().share();
        }
        return this.mRequestSidObs;
      }
      finally {}
    }
    
    AutoLoginTask setCallback(FtnDefine.FtnCallback paramFtnCallback)
    {
      this.mCallback = paramFtnCallback;
      return this;
    }
    
    class RxLoginWatcher
      implements AccountLoginWatcher
    {
      Subscriber<? super Void> mSubscriber;
      
      RxLoginWatcher()
      {
        Object localObject;
        this.mSubscriber = localObject;
      }
      
      public void onError(int paramInt1, long paramLong, QMNetworkError paramQMNetworkError, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
      {
        QMLog.log(5, "FtnManagerImpl", "qqmail autologin onError: " + paramQMNetworkError);
        LoginManager.shareInstance().bindLoginListener(this, false);
        this.mSubscriber.onError(new Throwable("autologin error"));
      }
      
      public void onProcess(int paramInt, long paramLong) {}
      
      public void onSuccess(int paramInt, long paramLong, boolean paramBoolean)
      {
        QMLog.log(4, "FtnManagerImpl", "qqmail autologin onSuccess");
        LoginManager.shareInstance().bindLoginListener(this, false);
        this.mSubscriber.onNext(null);
        this.mSubscriber.onCompleted();
      }
    }
  }
  
  static class CreateFileTask
    extends FtnManagerImpl.AbstractSessionTask
  {
    private byte[] mCreateFileInput;
    
    CreateFileTask(byte[] paramArrayOfByte, FtnDefine.FtnCallback paramFtnCallback)
    {
      super(paramFtnCallback);
      this.mCreateFileInput = paramArrayOfByte;
    }
    
    byte[] body()
    {
      return this.mCreateFileInput;
    }
    
    String cgi()
    {
      return "ftn";
    }
    
    int method()
    {
      return 1;
    }
    
    String path()
    {
      return "createfile";
    }
  }
  
  static class DelFileTask
    extends FtnManagerImpl.AbstractSessionTask
  {
    private String[] mFids;
    
    DelFileTask(String[] paramArrayOfString, FtnDefine.FtnCallback paramFtnCallback)
    {
      super(paramFtnCallback);
      this.mFids = paramArrayOfString;
    }
    
    byte[] body()
    {
      Object localObject = new DelFileInput();
      if ((this.mFids != null) && (this.mFids.length > 0)) {
        Collections.addAll(((DelFileInput)localObject).fids, this.mFids);
      }
      try
      {
        localObject = ((DelFileInput)localObject).toByteArray();
        return localObject;
      }
      catch (Exception localException)
      {
        Log.w("FtnManagerImpl", this.mFuncTag + " body", localException);
        ValidateHelper.assertInDebug(this.mFuncTag, false);
      }
      return null;
    }
    
    String cgi()
    {
      return "ftn";
    }
    
    int method()
    {
      return 4;
    }
    
    String path()
    {
      return "DelFile";
    }
  }
  
  static class FtnTaskError
  {
    int bodyCode = 0;
    String desp;
    int errType = 0;
    int headerCode = 0;
    boolean isError;
    boolean isMailSessionTimeout;
    boolean isSessionTimeout;
  }
  
  static class GetFileDownloadUrlTask
    extends FtnManagerImpl.AbstractSessionTask
  {
    private String mCode;
    private String mFid;
    private String mFilename;
    private String mKey;
    
    GetFileDownloadUrlTask(String paramString1, String paramString2, String paramString3, String paramString4, FtnDefine.FtnCallback paramFtnCallback)
    {
      super(paramFtnCallback);
      this.mFid = paramString1;
      this.mKey = paramString2;
      this.mCode = paramString3;
      this.mFilename = paramString4;
    }
    
    byte[] body()
    {
      Object localObject = new ItemInput();
      ((ItemInput)localObject).action = 1;
      ((ItemInput)localObject).fid = this.mFid;
      ((ItemInput)localObject).key = this.mKey;
      ((ItemInput)localObject).code = this.mCode;
      ((ItemInput)localObject).filename = this.mFilename;
      try
      {
        localObject = ((ItemInput)localObject).toByteArray();
        return localObject;
      }
      catch (Exception localException)
      {
        Log.w("FtnManagerImpl", this.mFuncTag + " body", localException);
        ValidateHelper.assertInDebug(this.mFuncTag, false);
      }
      return null;
    }
    
    String cgi()
    {
      return "ftn";
    }
    
    int method()
    {
      return 2;
    }
    
    String path()
    {
      return "file";
    }
  }
  
  static class GetFileRarPreviewTask
    extends FtnManagerImpl.AbstractSessionTask
  {
    private String mCode;
    private String mFid;
    private String mFilename;
    private String mKey;
    
    GetFileRarPreviewTask(String paramString1, String paramString2, String paramString3, String paramString4, FtnDefine.FtnCallback paramFtnCallback)
    {
      super(paramFtnCallback);
      this.mFid = paramString1;
      this.mKey = paramString2;
      this.mCode = paramString3;
      this.mFilename = paramString4;
    }
    
    byte[] body()
    {
      Object localObject = new ItemInput();
      ((ItemInput)localObject).action = 3;
      ((ItemInput)localObject).fid = this.mFid;
      ((ItemInput)localObject).key = this.mKey;
      ((ItemInput)localObject).code = this.mCode;
      ((ItemInput)localObject).filename = this.mFilename;
      try
      {
        localObject = ((ItemInput)localObject).toByteArray();
        return localObject;
      }
      catch (Exception localException)
      {
        Log.w("FtnManagerImpl", this.mFuncTag + " body", localException);
        ValidateHelper.assertInDebug(this.mFuncTag, false);
      }
      return null;
    }
    
    String cgi()
    {
      return "ftn";
    }
    
    int method()
    {
      return 2;
    }
    
    String path()
    {
      return "file";
    }
  }
  
  static class GetFileVideoPreviewTask
    extends FtnManagerImpl.AbstractSessionTask
  {
    private String mFid;
    private String mFilename;
    private String mSha;
    private long mSize;
    
    GetFileVideoPreviewTask(String paramString1, String paramString2, String paramString3, long paramLong, FtnDefine.FtnCallback paramFtnCallback)
    {
      super(paramFtnCallback);
      this.mSha = paramString1;
      this.mFid = paramString2;
      this.mFilename = paramString3;
      this.mSize = paramLong;
    }
    
    byte[] body()
    {
      ItemViewVideoInput localItemViewVideoInput = new ItemViewVideoInput();
      localItemViewVideoInput.sha = this.mSha;
      localItemViewVideoInput.fid = this.mFid;
      localItemViewVideoInput.filename = this.mFilename;
      localItemViewVideoInput.size = this.mSize;
      localItemViewVideoInput.querytype = 3;
      return null;
    }
    
    String cgi()
    {
      return "ftn";
    }
    
    int method()
    {
      return 2;
    }
    
    String path()
    {
      return "viewvideo";
    }
  }
  
  static class GetListTask
    extends FtnManagerImpl.AbstractSessionTask
  {
    private String mFavPwd;
    private boolean mIsFav;
    private boolean mIsFavPwdEncrypt;
    private long mLastUpdateTime;
    
    GetListTask(long paramLong, boolean paramBoolean1, String paramString, boolean paramBoolean2, FtnDefine.FtnCallback paramFtnCallback)
    {
      super(paramFtnCallback);
      this.mLastUpdateTime = paramLong;
      this.mIsFav = paramBoolean1;
      this.mFavPwd = paramString;
      this.mIsFavPwdEncrypt = paramBoolean2;
    }
    
    byte[] body()
    {
      Object localObject = new ListInput();
      ((ListInput)localObject).lastupdatetime = ((int)this.mLastUpdateTime);
      if ((this.mIsFav) && (!TextUtils.isEmpty(this.mFavPwd)))
      {
        ((ListInput)localObject).encrypt = this.mIsFavPwdEncrypt;
        ((ListInput)localObject).password = this.mFavPwd;
      }
      try
      {
        localObject = ((ListInput)localObject).toByteArray();
        return localObject;
      }
      catch (Exception localException)
      {
        Log.w("FtnManagerImpl", this.mFuncTag + " body", localException);
        ValidateHelper.assertInDebug(this.mFuncTag, false);
      }
      return null;
    }
    
    String cgi()
    {
      return "ftn";
    }
    
    int method()
    {
      return 2;
    }
    
    String path()
    {
      if (this.mIsFav) {
        return "favfilelist";
      }
      return "filelist";
    }
  }
  
  static class GetShareUrlTask
    extends FtnManagerImpl.AbstractSessionTask
  {
    private String[] mCodes;
    private String[] mKeys;
    
    GetShareUrlTask(String[] paramArrayOfString1, String[] paramArrayOfString2, FtnDefine.FtnCallback paramFtnCallback)
    {
      super(paramFtnCallback);
      this.mKeys = paramArrayOfString1;
      this.mCodes = paramArrayOfString2;
      paramFtnCallback = this.mFuncTag;
      if ((paramArrayOfString1 != null) && (paramArrayOfString2 != null) && (paramArrayOfString1.length == paramArrayOfString2.length)) {}
      for (boolean bool = true;; bool = false)
      {
        ValidateHelper.assertInDebug(paramFtnCallback, bool);
        return;
      }
    }
    
    byte[] body()
    {
      Object localObject = new GetShareUrlInput();
      ((GetShareUrlInput)localObject).path = 2;
      int i = 0;
      while (i < this.mKeys.length)
      {
        ShareUrlItemInput localShareUrlItemInput = new ShareUrlItemInput();
        localShareUrlItemInput.key = this.mKeys[i];
        localShareUrlItemInput.code = this.mCodes[i];
        ((GetShareUrlInput)localObject).shareUrlInputList.add(localShareUrlItemInput);
        i += 1;
      }
      try
      {
        localObject = ((GetShareUrlInput)localObject).toByteArray();
        return localObject;
      }
      catch (Exception localException)
      {
        Log.w("FtnManagerImpl", this.mFuncTag + " body", localException);
        ValidateHelper.assertInDebug(this.mFuncTag, false);
      }
      return null;
    }
    
    String cgi()
    {
      return "ftn";
    }
    
    int method()
    {
      return 2;
    }
    
    String path()
    {
      return "getshareurl";
    }
  }
  
  static class QueryAccountTask
    extends FtnManagerImpl.AbstractSessionTask
  {
    QueryAccountTask(FtnDefine.FtnCallback paramFtnCallback)
    {
      super(paramFtnCallback);
    }
    
    byte[] body()
    {
      return null;
    }
    
    String cgi()
    {
      return "ftnuserprofile";
    }
    
    int method()
    {
      return 2;
    }
    
    String path()
    {
      return "ShowUsr";
    }
  }
  
  static class RenewFileTask
    extends FtnManagerImpl.AbstractSessionTask
  {
    private int[] mExpireTimes;
    private String[] mFids;
    
    RenewFileTask(String[] paramArrayOfString, int[] paramArrayOfInt, FtnDefine.FtnCallback paramFtnCallback)
    {
      super(paramFtnCallback);
      this.mFids = paramArrayOfString;
      this.mExpireTimes = paramArrayOfInt;
      paramFtnCallback = this.mFuncTag;
      if ((paramArrayOfString != null) && (paramArrayOfInt != null) && (paramArrayOfString.length == paramArrayOfInt.length)) {}
      for (boolean bool = true;; bool = false)
      {
        ValidateHelper.assertInDebug(paramFtnCallback, bool);
        return;
      }
    }
    
    byte[] body()
    {
      Object localObject = new RenewFileInput();
      int i = 0;
      while (i < this.mFids.length)
      {
        ((RenewFileInput)localObject).fids.add(this.mFids[i]);
        ((RenewFileInput)localObject).expiretime.add(Integer.valueOf(this.mExpireTimes[i]));
        i += 1;
      }
      try
      {
        localObject = ((RenewFileInput)localObject).toByteArray();
        return localObject;
      }
      catch (Exception localException)
      {
        Log.w("FtnManagerImpl", this.mFuncTag + " body", localException);
        ValidateHelper.assertInDebug(this.mFuncTag, false);
      }
      return null;
    }
    
    String cgi()
    {
      return "ftn";
    }
    
    int method()
    {
      return 3;
    }
    
    String path()
    {
      return "ReNewFile";
    }
  }
  
  static class SaveFileTask
    extends FtnManagerImpl.AbstractSessionTask
  {
    private String[] mCodes;
    private String[] mKeys;
    
    SaveFileTask(String[] paramArrayOfString1, String[] paramArrayOfString2, FtnDefine.FtnCallback paramFtnCallback)
    {
      super(paramFtnCallback);
      this.mKeys = paramArrayOfString1;
      this.mCodes = paramArrayOfString2;
      paramFtnCallback = this.mFuncTag;
      if ((paramArrayOfString1 != null) && (paramArrayOfString2 != null) && (paramArrayOfString1.length == paramArrayOfString2.length)) {}
      for (boolean bool = true;; bool = false)
      {
        ValidateHelper.assertInDebug(paramFtnCallback, bool);
        return;
      }
    }
    
    byte[] body()
    {
      Object localObject = new StoreFileInput();
      int i = 0;
      while (i < this.mKeys.length)
      {
        ItemInputStoreFile localItemInputStoreFile = new ItemInputStoreFile();
        localItemInputStoreFile.key = this.mKeys[i];
        localItemInputStoreFile.code = this.mCodes[i];
        ((StoreFileInput)localObject).itemlist.add(localItemInputStoreFile);
        i += 1;
      }
      try
      {
        localObject = ((StoreFileInput)localObject).toByteArray();
        return localObject;
      }
      catch (Exception localException)
      {
        Log.w("FtnManagerImpl", this.mFuncTag + " body", localException);
        ValidateHelper.assertInDebug(this.mFuncTag, false);
      }
      return null;
    }
    
    String cgi()
    {
      return "ftn";
    }
    
    int method()
    {
      return 1;
    }
    
    String path()
    {
      return "storefile";
    }
  }
  
  static class TransCodeVideoTask
    extends FtnManagerImpl.AbstractSessionTask
  {
    private String mFid;
    private String mFilename;
    private String mSha;
    private long mSize;
    
    TransCodeVideoTask(String paramString1, long paramLong, String paramString2, String paramString3, FtnDefine.FtnCallback paramFtnCallback)
    {
      super(paramFtnCallback);
      this.mSha = paramString1;
      this.mSize = paramLong;
      this.mFilename = paramString2;
      this.mFid = paramString3;
    }
    
    byte[] body()
    {
      Object localObject = new ItemAddVideoTaskInput();
      ((ItemAddVideoTaskInput)localObject).sha = this.mSha;
      ((ItemAddVideoTaskInput)localObject).size = this.mSize;
      ((ItemAddVideoTaskInput)localObject).filename = this.mFilename;
      ((ItemAddVideoTaskInput)localObject).fid = this.mFid;
      try
      {
        localObject = ((ItemAddVideoTaskInput)localObject).toByteArray();
        return localObject;
      }
      catch (Exception localException)
      {
        Log.w("FtnManagerImpl", this.mFuncTag + " body", localException);
        ValidateHelper.assertInDebug(this.mFuncTag, false);
      }
      return null;
    }
    
    String cgi()
    {
      return "ftn";
    }
    
    int method()
    {
      return 2;
    }
    
    String path()
    {
      return "addvideotask";
    }
  }
  
  static class UploadRecv
  {
    int error;
    int flag;
    int nextOffset;
    
    void reset()
    {
      this.flag = 0;
      this.nextOffset = 0;
      this.error = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManagerImpl
 * JD-Core Version:    0.7.0.1
 */