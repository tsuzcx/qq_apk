package com.tencent.mobileqq.activity.qwallet.preload;

import Wallet.JudgeDownloadReq;
import Wallet.ResInfo;
import aaai;
import aacc;
import aacl;
import aacq;
import aacr;
import aadi;
import aadj;
import aagd;
import android.os.Bundle;
import android.text.TextUtils;
import anld;
import anmb;
import aqhq;
import aquy;
import aquz;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import zyb;
import zyn;

public class PreloadResource
  implements Serializable
{
  public static final String ABI_32 = "32";
  public static final String ABI_64 = "64";
  public static final int FILE_MAX_RETRY_FINISHED_TIMES = 5;
  public static final int FROM_TYPE_MOBILE_QQ = 0;
  public static final int FROM_TYPE_MOGGY = 1;
  public static final int FROM_TYPE_NONE = 0;
  public static final int FROM_TYPE_REDBAO = 2;
  public static final String PARAM_KEY_MODULE = "module";
  public static final String PARAM_KEY_RES = "resource";
  public static final String PARAM_KEY_SCENE = "scene";
  public static final int PRELOAD_DOWNLOAD_NOTIFY_THRESHOLD = 1048576;
  public static final int TYPE_GIF = 2;
  public static final int TYPE_MP3 = 3;
  public static final int TYPE_PNG = 1;
  public static final int TYPE_VIDEO = 5;
  public static final int TYPE_ZIP = 4;
  private static final long serialVersionUID = 1L;
  private transient PreloadFlowControlConfig a;
  private transient boolean bvc;
  private transient long ib;
  public String mAbi;
  public String mDownloadTime;
  public int mFilePos;
  public boolean mFlowControl;
  public int mFromType;
  @Deprecated
  public boolean mHasUnzip;
  public String mInvalidTime;
  public boolean mIsFromLocal;
  @Deprecated
  public boolean mIsNeedUnzip;
  public boolean mIsTemp;
  @Deprecated
  public boolean mIsUnzipInside;
  private PreloadTimerTask mReqTask;
  public String mResId;
  public int mRetryTime;
  @Deprecated
  public String mUnzipPrefix;
  public String md5;
  public String netType;
  public int size;
  public int type;
  public String url;
  public String urlPath;
  
  public PreloadResource() {}
  
  public PreloadResource(PreloadResource paramPreloadResource)
  {
    this();
    this.url = paramPreloadResource.url;
    this.urlPath = paramPreloadResource.urlPath;
    this.type = paramPreloadResource.type;
    this.md5 = paramPreloadResource.md5;
    this.mDownloadTime = paramPreloadResource.mDownloadTime;
    this.mInvalidTime = paramPreloadResource.mInvalidTime;
    this.netType = paramPreloadResource.netType;
    this.size = paramPreloadResource.size;
    this.mResId = paramPreloadResource.mResId;
    this.mFlowControl = paramPreloadResource.mFlowControl;
    this.mIsFromLocal = paramPreloadResource.mIsFromLocal;
    this.mIsTemp = paramPreloadResource.mIsTemp;
    this.mRetryTime = paramPreloadResource.mRetryTime;
    this.mIsNeedUnzip = paramPreloadResource.mIsNeedUnzip;
    this.mIsUnzipInside = paramPreloadResource.mIsUnzipInside;
    this.mUnzipPrefix = paramPreloadResource.mUnzipPrefix;
    this.mHasUnzip = paramPreloadResource.mHasUnzip;
    this.mFromType = paramPreloadResource.mFromType;
    this.mFilePos = paramPreloadResource.mFilePos;
    this.mAbi = paramPreloadResource.mAbi;
  }
  
  private void a(aquy paramaquy, PreloadModule paramPreloadModule, PreloadManager paramPreloadManager)
  {
    if (paramaquy == null) {
      return;
    }
    paramPreloadManager = getResDownloadUrl(paramPreloadModule);
    paramPreloadManager = new aquz(paramPreloadManager, new File(PreloadManager.Y(paramPreloadManager, getFilePos())));
    paramPreloadManager.errCode = 0;
    paramPreloadManager.dy(getDownloadParams(paramPreloadModule));
    paramaquy.onDoneFile(paramPreloadManager);
  }
  
  private boolean ai(String paramString1, String paramString2)
  {
    return (isNeedAutoUnzip(paramString2, this.type)) && (!isFolderPathValid(getFolderPath(paramString2, paramString1)));
  }
  
  /* Error */
  public static boolean checkFolderAndUnzip(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic 192	com/tencent/mobileqq/activity/qwallet/preload/PreloadResource:isFolderPathValid	(Ljava/lang/String;)Z
    //   7: istore_2
    //   8: iload_2
    //   9: ifeq +10 -> 19
    //   12: iconst_1
    //   13: istore_2
    //   14: ldc 2
    //   16: monitorexit
    //   17: iload_2
    //   18: ireturn
    //   19: aload_0
    //   20: aload_1
    //   21: invokestatic 196	com/tencent/mobileqq/activity/qwallet/preload/PreloadResource:unzipAtomically	(Ljava/lang/String;Ljava/lang/String;)Z
    //   24: istore_2
    //   25: goto -11 -> 14
    //   28: astore_0
    //   29: ldc 2
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	paramString1	String
    //   0	34	1	paramString2	String
    //   7	18	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	8	28	finally
    //   19	25	28	finally
  }
  
  public static String getFolderPathByMD5AndUrl(String paramString1, String paramString2, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = MD5.toMD5(paramString2 + paramString1);
      return PreloadManager.cT(paramInt) + paramString1;
    }
    return null;
  }
  
  private static boolean iL(String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    long l1 = 0L;
    if (!TextUtils.isEmpty(paramString))
    {
      long l2 = anld.s(paramString);
      l1 = l2;
      if (l2 > 52428800L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreloadResource", 2, "isDiskEnoughToUnzip|true|" + paramString + "|" + l2);
        }
        return true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreloadResource", 2, "isDiskEnoughToUnzip|false|" + paramString + "|" + l1);
    }
    return false;
  }
  
  public static boolean isFolderPathValid(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()) && (aqhq.getFileOrFolderSize(paramString) > 0L);
  }
  
  public static boolean isNeedAutoUnzip(String paramString, int paramInt)
  {
    return (paramInt == 4) || ((paramString != null) && (paramString.length() > 5) && (paramString.substring(paramString.length() - 4).equals(".zip")));
  }
  
  public static boolean isValidToReport(long paramLong1, long paramLong2)
  {
    return Math.abs(paramLong2 - paramLong1) > 1000L;
  }
  
  public static PreloadResource parsePreloadResource(JSONObject paramJSONObject, PreloadModule paramPreloadModule, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = true;
    PreloadResource localPreloadResource = new PreloadResource();
    for (;;)
    {
      try
      {
        localPreloadResource.url = paramJSONObject.optString("url");
        localPreloadResource.urlPath = paramJSONObject.optString("url_path");
        localPreloadResource.type = paramJSONObject.optInt("type");
        localPreloadResource.md5 = paramJSONObject.optString("md5");
        localPreloadResource.mDownloadTime = paramJSONObject.optString("download_time");
        localPreloadResource.mInvalidTime = paramJSONObject.optString("invalid_time");
        localPreloadResource.netType = paramJSONObject.optString("net_type");
        localPreloadResource.size = paramJSONObject.optInt("size");
        if (paramJSONObject.optInt("flow_control") == 1)
        {
          bool1 = true;
          localPreloadResource.mFlowControl = bool1;
          localPreloadResource.mIsFromLocal = paramBoolean;
          if (paramJSONObject.optInt("is_temp") != 1) {
            break label290;
          }
          paramBoolean = true;
          localPreloadResource.mIsTemp = paramBoolean;
          if (paramJSONObject.optInt("is_need_unzip") != 1) {
            break label295;
          }
          paramBoolean = true;
          localPreloadResource.mIsNeedUnzip = paramBoolean;
          if (paramJSONObject.optInt("is_unzip_inside") != 1) {
            break label300;
          }
          paramBoolean = bool2;
          localPreloadResource.mIsUnzipInside = paramBoolean;
          localPreloadResource.mUnzipPrefix = paramJSONObject.optString("unzip_prefix");
          localPreloadResource.mFromType = paramInt;
          localPreloadResource.mFilePos = paramJSONObject.optInt("file_pos", 0);
          localPreloadResource.mAbi = paramJSONObject.optString("abi", "32");
          paramJSONObject = paramJSONObject.optString("res_id");
          if (!TextUtils.isEmpty(paramJSONObject))
          {
            localPreloadResource.mResId = paramJSONObject;
            return localPreloadResource;
          }
          localPreloadResource.mResId = localPreloadResource.getResDownloadUrl(paramPreloadModule);
          return localPreloadResource;
        }
      }
      catch (Throwable paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localPreloadResource;
      }
      boolean bool1 = false;
      continue;
      label290:
      paramBoolean = false;
      continue;
      label295:
      paramBoolean = false;
      continue;
      label300:
      paramBoolean = false;
    }
  }
  
  /* Error */
  public static boolean unzipAtomically(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: iload_3
    //   6: istore_2
    //   7: aload_0
    //   8: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +14 -> 25
    //   14: aload_1
    //   15: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: istore_2
    //   19: iload_2
    //   20: ifeq +10 -> 30
    //   23: iload_3
    //   24: istore_2
    //   25: ldc 2
    //   27: monitorexit
    //   28: iload_2
    //   29: ireturn
    //   30: iload_3
    //   31: istore_2
    //   32: aload_1
    //   33: invokestatic 341	com/tencent/mobileqq/activity/qwallet/preload/PreloadResource:iL	(Ljava/lang/String;)Z
    //   36: ifeq -11 -> 25
    //   39: aload_0
    //   40: aload_1
    //   41: invokestatic 344	aagd:unzipAtomically	(Ljava/lang/String;Ljava/lang/String;)Z
    //   44: istore_2
    //   45: goto -20 -> 25
    //   48: astore_0
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	paramString1	String
    //   0	54	1	paramString2	String
    //   6	39	2	bool1	boolean
    //   1	30	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   7	19	48	finally
    //   32	45	48	finally
  }
  
  /* Error */
  public static boolean unzipToCustomPath(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: iload_3
    //   6: istore_2
    //   7: aload_0
    //   8: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +14 -> 25
    //   14: aload_1
    //   15: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: istore_2
    //   19: iload_2
    //   20: ifeq +10 -> 30
    //   23: iload_3
    //   24: istore_2
    //   25: ldc 2
    //   27: monitorexit
    //   28: iload_2
    //   29: ireturn
    //   30: iload_3
    //   31: istore_2
    //   32: aload_1
    //   33: invokestatic 341	com/tencent/mobileqq/activity/qwallet/preload/PreloadResource:iL	(Ljava/lang/String;)Z
    //   36: ifeq -11 -> 25
    //   39: aload_0
    //   40: aload_1
    //   41: iconst_1
    //   42: invokestatic 348	aagd:a	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   45: istore_2
    //   46: goto -21 -> 25
    //   49: astore_0
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload_0
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramString1	String
    //   0	55	1	paramString2	String
    //   6	40	2	bool1	boolean
    //   1	30	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   7	19	49	finally
    //   32	46	49	finally
  }
  
  public void deleteResFile(PreloadModule paramPreloadModule, PreloadManager paramPreloadManager, int paramInt)
  {
    aqhq.deleteFile(PreloadFlowControlConfig.getConfigPath(this.mResId, paramPreloadManager.mApp));
    paramPreloadModule = getResDownloadUrl(paramPreloadModule);
    paramPreloadManager = PreloadManager.Y(paramPreloadModule, getFilePos());
    if (paramInt == 9) {
      aadi.cS(paramPreloadModule, getFilePos());
    }
    for (;;)
    {
      if (isNeedAutoUnzip(paramPreloadModule, this.type))
      {
        String str = getFolderPath(this.url, paramPreloadManager);
        if (!TextUtils.isEmpty(str)) {
          aqhq.delete(str, false);
        }
      }
      aqhq.deleteFile(paramPreloadManager);
      aadj.cU(paramPreloadModule, getFilePos());
      return;
      aadi.W(paramPreloadModule, paramInt, getFilePos());
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof PreloadResource)))
    {
      paramObject = (PreloadResource)paramObject;
      if (aagd.j(this.mResId, paramObject.mResId)) {
        return true;
      }
    }
    return false;
  }
  
  public Bundle getDownloadParams(PreloadModule paramPreloadModule)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("module", paramPreloadModule);
    localBundle.putSerializable("resource", this);
    return localBundle;
  }
  
  public int getFilePos()
  {
    if (aacl.bvb) {
      return 1;
    }
    return this.mFilePos;
  }
  
  public aquy getFlowControlDownloadListener(long paramLong, aquy paramaquy, PreloadManager paramPreloadManager, int paramInt)
  {
    return new aacq(this, paramInt, new WeakReference(paramPreloadManager), paramaquy, paramLong);
  }
  
  public String getFolderPath(String paramString1, String paramString2)
  {
    if (isNeedAutoUnzip(paramString1, this.type)) {
      return getFolderPathByMD5AndUrl(aadj.i(paramString1, paramString2, getFilePos()), paramString1, getFilePos());
    }
    return null;
  }
  
  public ArrayList<ResInfo> getMyResInfos()
  {
    return getMyResInfos(this.size);
  }
  
  public ArrayList<ResInfo> getMyResInfos(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ResInfo localResInfo = new ResInfo();
    try
    {
      localResInfo.sResId = this.mResId;
      localResInfo.iSize = paramInt;
      localArrayList.add(localResInfo);
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public String getResDownloadUrl(PreloadModule paramPreloadModule)
  {
    if (!TextUtils.isEmpty(this.url)) {
      return this.url;
    }
    return paramPreloadModule.mBaseUrl + "/" + this.urlPath;
  }
  
  public ResourceInfo getResInfo(PreloadModule paramPreloadModule)
  {
    paramPreloadModule = getResDownloadUrl(paramPreloadModule);
    if (!this.mIsNeedUnzip) {}
    for (boolean bool = true;; bool = false)
    {
      paramPreloadModule = aadj.a(paramPreloadModule, bool, this.type, getFilePos());
      paramPreloadModule.type = this.type;
      paramPreloadModule.resId = this.mResId;
      return paramPreloadModule;
    }
  }
  
  public boolean handleAbnormalRetry(PreloadModule paramPreloadModule)
  {
    int i = aadj.T(getResDownloadUrl(paramPreloadModule), getFilePos());
    long l = aadj.h(getResDownloadUrl(paramPreloadModule), getFilePos());
    if (QLog.isColorLevel()) {
      QLog.d("PreloadResource", 2, "[handleAbnormalRetry]:" + this.url + "|" + i + "|" + l + "|" + paramPreloadModule.mRetryTimeInterval + "|" + paramPreloadModule.mRetryCount);
    }
    if (isRetryProtectOpen()) {
      if (i > paramPreloadModule.mRetryCount)
      {
        if (!isResFileExist(paramPreloadModule)) {
          return true;
        }
      }
      else if ((i >= 1) && (Math.abs(NetConnInfoCenter.getServerTimeMillis() - l) < paramPreloadModule.mRetryTimeInterval * 60 * 60 * 1000))
      {
        this.bvc = true;
        if (QLog.isColorLevel()) {
          QLog.d("PreloadResource", 2, "ignore set to true for" + this.mResId);
        }
        return false;
      }
    }
    this.bvc = false;
    return false;
  }
  
  public void handleFlowConfig(PreloadManager paramPreloadManager, PreloadModule paramPreloadModule, aquy paramaquy)
  {
    for (;;)
    {
      long l1;
      try
      {
        if (isResFileExist(paramPreloadModule))
        {
          if (isNeedUnzip(paramPreloadModule, paramPreloadManager)) {
            unzip(PreloadManager.Y(getResDownloadUrl(paramPreloadModule), getFilePos()), getResDownloadUrl(paramPreloadModule));
          }
          if (paramaquy != null) {
            a(paramaquy, paramPreloadModule, paramPreloadManager);
          }
          paramPreloadManager.ctL();
          return;
        }
        if (this.a == null) {
          this.a = PreloadFlowControlConfig.getFlowControlConfig(this.mResId, paramPreloadManager.mApp);
        }
        if (QLog.isColorLevel()) {
          QLog.d("PreloadResource", 2, this.mResId + "handleFlowConfig:" + this.a.mDownloadStatus);
        }
        l1 = paramPreloadManager.mApp.getLongAccountUin();
        switch (this.a.mDownloadStatus)
        {
        case -1: 
          paramPreloadManager.ctL();
          continue;
          startFlowControlReq(JudgeDownloadReq.createReq(getMyResInfos(), l1, 0), paramPreloadManager, paramPreloadModule, paramaquy);
        }
      }
      finally {}
      continue;
      long l2 = NetConnInfoCenter.getServerTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("PreloadResource", 2, this.mResId + "STATUS_NOW_DOWNLOAD|" + l2 + "|" + this.a.mValidDownloadTime);
      }
      if (l2 < this.a.mValidDownloadTime)
      {
        if (isTimeToDownload(paramPreloadManager))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PreloadResource", 2, this.mResId + "begin download");
          }
          startDownloadRes(paramPreloadModule, paramPreloadManager, getFlowControlDownloadListener(l1, paramaquy, paramPreloadManager, this.a.mRetryDownloadTimes), true);
        }
        else
        {
          paramPreloadManager.ctL();
          if (paramaquy != null) {
            notifyListenerDownloadFailInFlowControl(paramaquy, paramPreloadModule, paramPreloadManager);
          }
        }
      }
      else
      {
        startFlowControlReq(JudgeDownloadReq.createReq(getMyResInfos(), l1, 0), paramPreloadManager, paramPreloadModule, paramaquy);
        continue;
        l2 = NetConnInfoCenter.getServerTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("PreloadResource", 2, this.mResId + " STATUS_NOT_DOWNLOAD|" + l2 + "|" + this.a.mNextCanReqTime);
        }
        if (l2 > this.a.mNextCanReqTime)
        {
          startFlowControlReq(JudgeDownloadReq.createReq(getMyResInfos(), l1, 0), paramPreloadManager, paramPreloadModule, paramaquy);
        }
        else
        {
          paramPreloadManager.ctL();
          if (paramaquy != null)
          {
            notifyListenerDownloadFailInFlowControl(paramaquy, paramPreloadModule, paramPreloadManager);
            continue;
            l2 = NetConnInfoCenter.getServerTimeMillis();
            long l3 = this.a.mNextRetryReqTime - l2;
            if (QLog.isColorLevel()) {
              QLog.d("PreloadResource", 2, this.mResId + "STATUS_WAIT_TO_REQ|" + l2 + "|" + this.a.mNextRetryReqTime + "|" + l3);
            }
            if (l3 <= 0L)
            {
              ArrayList localArrayList = getMyResInfos();
              PreloadFlowControlConfig localPreloadFlowControlConfig = this.a;
              int i = localPreloadFlowControlConfig.mRetryReqTimes + 1;
              localPreloadFlowControlConfig.mRetryReqTimes = i;
              startFlowControlReq(JudgeDownloadReq.createReq(localArrayList, l1, i), paramPreloadManager, paramPreloadModule, paramaquy);
            }
            else
            {
              if ((this.mReqTask == null) || (this.mReqTask.isExecuted()))
              {
                this.mReqTask = new PreloadResource.1(this, new WeakReference(paramPreloadManager), paramPreloadModule);
                ThreadManager.getTimer().schedule(this.mReqTask, l3);
              }
              paramPreloadManager.ctL();
              if (paramaquy != null) {
                notifyListenerDownloadFailInFlowControl(paramaquy, paramPreloadModule, paramPreloadManager);
              }
            }
          }
        }
      }
    }
  }
  
  public boolean isAbiMatch()
  {
    if (TextUtils.isEmpty(this.mAbi)) {
      return true;
    }
    String[] arrayOfString = this.mAbi.split("\\|");
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label79;
      }
      String str = arrayOfString[i];
      if (("32".equals(str)) && (!anmb.is64Bit())) {
        break;
      }
      if (("64".equals(str)) && (anmb.is64Bit())) {
        return false;
      }
      i += 1;
    }
    label79:
    return false;
  }
  
  public boolean isChosenToReport()
  {
    int i = 10000;
    QQAppInterface localQQAppInterface = aagd.getQQAppInterface();
    if (localQQAppInterface == null) {
      return false;
    }
    aaai localaaai = (aaai)localQQAppInterface.getManager(245);
    if (localaaai == null) {}
    while (i == 0)
    {
      return false;
      i = localaaai.a("report", 10000, new String[] { "preDownSampleBase" });
    }
    int k = zyn.getInt(localQQAppInterface.getCurrentUin(), "download_report_random", 0);
    int j = k;
    if (k == 0)
    {
      j = new Random(localQQAppInterface.getLongAccountUin()).nextInt();
      zyn.putInt(localQQAppInterface.getCurrentUin(), "download_report_random", j);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreloadResource", 2, "isChosenToReport|" + j + "|" + i);
    }
    return j % i == 0;
  }
  
  public boolean isInValidTime()
  {
    long l1 = aagd.W(this.mInvalidTime);
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    if ((l1 != -1L) && (l1 < l2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadResource", 2, this.mResId + " out of date");
      }
      return false;
    }
    return true;
  }
  
  public boolean isNeedDeleteOldFileWhenUpdate(PreloadModule paramPreloadModule, PreloadResource paramPreloadResource, PreloadManager paramPreloadManager)
  {
    if (getFilePos() != paramPreloadResource.getFilePos()) {}
    do
    {
      return true;
      if (this.md5.equalsIgnoreCase(paramPreloadResource.md5)) {
        break;
      }
      paramPreloadModule = getResDownloadUrl(paramPreloadModule);
      paramPreloadManager = PreloadManager.Y(paramPreloadModule, getFilePos());
    } while ((!TextUtils.isEmpty(paramPreloadResource.md5)) && (!paramPreloadResource.md5.equalsIgnoreCase(aadj.i(paramPreloadModule, paramPreloadManager, getFilePos()))));
    return false;
    return false;
  }
  
  public boolean isNeedReport(String paramString)
  {
    if (!isChosenToReport()) {
      return false;
    }
    if (!this.mIsFromLocal) {
      return true;
    }
    Object localObject1 = aagd.getQQAppInterface();
    if (localObject1 != null)
    {
      Object localObject2 = (aaai)((QQAppInterface)localObject1).getManager(245);
      if (localObject2 != null)
      {
        localObject2 = ((aaai)localObject2).getConfig("preload");
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).contains(paramString))) {
          return true;
        }
      }
      localObject1 = PreloadManager.ib(((QQAppInterface)localObject1).getCurrentUin());
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).contains(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isNeedUnzip(PreloadModule paramPreloadModule, PreloadManager paramPreloadManager)
  {
    if ((paramPreloadManager != null) && (paramPreloadModule != null)) {
      return ai(PreloadManager.Y(getResDownloadUrl(paramPreloadModule), getFilePos()), getResDownloadUrl(paramPreloadModule));
    }
    return false;
  }
  
  public boolean isResChange(PreloadResource paramPreloadResource)
  {
    if (!aagd.j(this.url, paramPreloadResource.url)) {}
    while ((!aagd.j(this.urlPath, paramPreloadResource.urlPath)) || (this.type != paramPreloadResource.type) || (!aagd.j(this.md5, paramPreloadResource.md5)) || (!aagd.j(this.mDownloadTime, paramPreloadResource.mDownloadTime)) || (!aagd.j(this.mInvalidTime, paramPreloadResource.mInvalidTime)) || (!aagd.j(this.netType, paramPreloadResource.netType)) || (this.size != paramPreloadResource.size) || (this.mFlowControl != paramPreloadResource.mFlowControl) || (!aagd.j(this.mResId, paramPreloadResource.mResId)) || (this.mIsFromLocal != paramPreloadResource.mIsFromLocal) || (this.mIsTemp != paramPreloadResource.mIsTemp) || (this.mRetryTime != paramPreloadResource.mRetryTime) || (this.mIsNeedUnzip != paramPreloadResource.mIsNeedUnzip) || (this.mIsUnzipInside != paramPreloadResource.mIsUnzipInside) || (!aagd.j(this.mUnzipPrefix, paramPreloadResource.mUnzipPrefix)) || (this.mHasUnzip != paramPreloadResource.mHasUnzip) || (this.mFromType != paramPreloadResource.mFromType) || (this.mFilePos != paramPreloadResource.mFilePos) || (!TextUtils.equals(this.mAbi, paramPreloadResource.mAbi))) {
      return true;
    }
    return false;
  }
  
  public boolean isResFileExist(PreloadModule paramPreloadModule)
  {
    paramPreloadModule = getResDownloadUrl(paramPreloadModule);
    if (new File(PreloadManager.Y(paramPreloadModule, getFilePos())).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadResource", 2, "ResFileExist|" + this.mResId + "|" + paramPreloadModule);
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreloadResource", 2, "ResFileNotExist|" + this.mResId + "|" + paramPreloadModule);
    }
    return false;
  }
  
  public boolean isRetryProtectOpen()
  {
    return true;
  }
  
  public boolean isTimeToDownload(PreloadManager paramPreloadManager)
  {
    if (this.bvc) {}
    long l1;
    long l2;
    do
    {
      return false;
      l1 = NetConnInfoCenter.getServerTimeMillis();
      l2 = aagd.W(this.mDownloadTime);
    } while (((l2 != -1L) && (l2 >= l1)) || (!paramPreloadManager.iK(this.netType)));
    return true;
  }
  
  public void notifyListenerDownloadFailInFlowControl(aquy paramaquy, PreloadModule paramPreloadModule, PreloadManager paramPreloadManager)
  {
    if (paramaquy == null) {
      return;
    }
    paramPreloadManager = getResDownloadUrl(paramPreloadModule);
    paramPreloadManager = new aquz(paramPreloadManager, new File(PreloadManager.Y(paramPreloadManager, getFilePos())));
    paramPreloadManager.errCode = -5;
    paramPreloadManager.dy(getDownloadParams(paramPreloadModule));
    paramaquy.onDoneFile(paramPreloadManager);
  }
  
  public void reportDownload(String paramString, int paramInt, PreloadModule paramPreloadModule)
  {
    if (isValidToReport(this.ib, System.currentTimeMillis()))
    {
      this.ib = System.currentTimeMillis();
      if (paramInt != 0) {
        break label99;
      }
      paramInt = 0;
      if (paramPreloadModule != null) {
        break label104;
      }
    }
    label99:
    label104:
    for (paramPreloadModule = "";; paramPreloadModule = paramPreloadModule.mid)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt).append("|").append(paramPreloadModule).append("|").append(this.mResId).append("|").append(paramString);
      VACDReportUtil.a(localStringBuilder.toString(), "QWalletStat", "downloadReport", null, null, 0, null);
      return;
      paramInt = 1;
      break;
    }
  }
  
  public void startDownload(PreloadManager paramPreloadManager, PreloadModule paramPreloadModule, aquy paramaquy, boolean paramBoolean)
  {
    if (this.mFlowControl)
    {
      paramPreloadManager.a(this, paramPreloadModule, paramaquy);
      return;
    }
    startDownloadRes(paramPreloadModule, paramPreloadManager, paramaquy, paramBoolean);
  }
  
  public void startDownloadRes(PreloadModule paramPreloadModule, PreloadManager paramPreloadManager, aquy paramaquy, boolean paramBoolean)
  {
    String str1 = getResDownloadUrl(paramPreloadModule);
    String str2 = PreloadManager.Y(str1, getFilePos());
    Bundle localBundle = getDownloadParams(paramPreloadModule);
    if (isResFileExist(paramPreloadModule))
    {
      if (isNeedUnzip(paramPreloadModule, paramPreloadManager)) {
        unzip(str2, str1);
      }
      a(paramaquy, paramPreloadModule, paramPreloadManager);
    }
    while (TextUtils.isEmpty(str1)) {
      return;
    }
    paramPreloadModule = new DownloadParam();
    paramPreloadModule.url = str1;
    paramPreloadModule.filePath = str2;
    paramPreloadModule.isPreDownload = paramBoolean;
    aacc.a().a(paramPreloadModule, new a(paramaquy), localBundle);
  }
  
  public void startFlowControlReq(JudgeDownloadReq paramJudgeDownloadReq, PreloadManager paramPreloadManager, PreloadModule paramPreloadModule, aquy paramaquy)
  {
    zyb.a(paramJudgeDownloadReq, new aacr(this, new WeakReference(paramPreloadManager), paramaquy, paramPreloadModule), 1);
  }
  
  public String toString()
  {
    return "Res [" + this.mResId + "|" + this.mFlowControl + "|" + this.mIsFromLocal + "|" + this.mIsNeedUnzip + "|" + this.mIsUnzipInside + "|" + this.mUnzipPrefix + "|" + this.mHasUnzip + "|" + this.mFromType + "|" + this.mFilePos + "|" + this.mAbi + "]";
  }
  
  public void unzip(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    checkFolderAndUnzip(paramString1, getFolderPath(paramString2, paramString1));
  }
  
  static abstract class PreloadTimerTask
    extends TimerTask
  {
    private boolean bve;
    
    public abstract void exec();
    
    public boolean isExecuted()
    {
      return this.bve;
    }
    
    public void run()
    {
      exec();
      this.bve = true;
    }
  }
  
  public class a
    extends PreloadResource.b
  {
    public a(aquy paramaquy)
    {
      super();
    }
    
    private int h(String paramString, boolean paramBoolean)
    {
      int i = aadi.f(paramString, 0, PreloadResource.this.getFilePos());
      if (i == 0)
      {
        if (paramBoolean) {
          aadi.W(paramString, 1, PreloadResource.this.getFilePos());
        }
        return 1;
      }
      if (i == 1) {
        return 7;
      }
      if (paramBoolean) {
        aadi.W(paramString, 1, PreloadResource.this.getFilePos());
      }
      return i;
    }
    
    public void onDoneFile(aquz paramaquz)
    {
      boolean bool = true;
      Object localObject1;
      PreloadModule localPreloadModule;
      Object localObject2;
      File localFile;
      String str;
      int i;
      if ((paramaquz != null) && (paramaquz.ov != null) && (!TextUtils.isEmpty(paramaquz.key)))
      {
        localObject1 = paramaquz.getParams();
        localPreloadModule = (PreloadModule)((Bundle)localObject1).getSerializable("module");
        localObject2 = (PreloadResource)((Bundle)localObject1).getSerializable("resource");
        localFile = (File)paramaquz.ov.get(paramaquz.key);
        if (localFile != null) {
          break label416;
        }
        localObject1 = "";
        if ((paramaquz.errCode != 0) || (localObject2 == null)) {
          break label474;
        }
        str = MD5Coding.encodeFile2HexStr((String)localObject1);
        if ((localFile == null) || (!localFile.exists()) || (TextUtils.isEmpty(str))) {
          break label474;
        }
        if ((TextUtils.isEmpty(((PreloadResource)localObject2).md5)) || (str.equalsIgnoreCase(((PreloadResource)localObject2).md5))) {
          break label426;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PreloadResource", 2, "preload onDoneFile md5 not match|" + ((PreloadResource)localObject2).mResId + "|" + str + "|" + ((PreloadResource)localObject2).md5);
        }
        aagd.delete((String)localObject1);
        aadi.W(paramaquz.key, 5, PreloadResource.this.getFilePos());
        paramaquz.errCode = -1;
        i = 1;
        label229:
        if (paramaquz.errCode == -118) {
          i = 1;
        }
        if ((i != 0) && (localPreloadModule != null)) {
          localPreloadModule.removeResource((PreloadResource)localObject2);
        }
        localObject2 = paramaquz.key;
        if (paramaquz.errCode != 0) {
          break label479;
        }
      }
      for (;;)
      {
        i = h((String)localObject2, bool);
        paramaquz.getParams().putInt("scene", i);
        if ((i == 7) && (paramaquz.errCode == 0)) {
          aadj.cT(paramaquz.key, PreloadResource.this.getFilePos());
        }
        if (QLog.isColorLevel()) {
          QLog.d("PreloadResource", 2, "preload onDoneFile|" + paramaquz.errCode + "|" + paramaquz.key + "|" + (String)localObject1 + "|" + i);
        }
        super.onDoneFile(paramaquz);
        if (PreloadResource.this.isNeedReport(paramaquz.key)) {
          PreloadResource.this.reportDownload(paramaquz.key, paramaquz.errCode, localPreloadModule);
        }
        return;
        label416:
        localObject1 = localFile.getAbsolutePath();
        break;
        label426:
        aadj.d(paramaquz.key, str, NetConnInfoCenter.getServerTimeMillis(), PreloadResource.this.getFilePos());
        if (PreloadResource.this.ai((String)localObject1, paramaquz.key)) {
          PreloadResource.this.unzip((String)localObject1, paramaquz.key);
        }
        label474:
        i = 0;
        break label229;
        label479:
        bool = false;
      }
    }
  }
  
  public static abstract class b
    extends aquy
  {
    private aquy h;
    
    public b(aquy paramaquy)
    {
      this.h = paramaquy;
    }
    
    public void onDoneFile(aquz paramaquz)
    {
      super.onDoneFile(paramaquz);
      if (this.h != null) {
        this.h.onDoneFile(paramaquz);
      }
    }
    
    public void onProgress(aquz paramaquz)
    {
      super.onProgress(paramaquz);
      if (this.h != null) {
        this.h.onProgress(paramaquz);
      }
    }
    
    public boolean onStart(aquz paramaquz)
    {
      if (this.h != null) {
        this.h.onStart(paramaquz);
      }
      return super.onStart(paramaquz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadResource
 * JD-Core Version:    0.7.0.1
 */