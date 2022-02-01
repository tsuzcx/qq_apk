package com.tencent.qqmini.sdk.report;

import alla;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MiniProgramLpReportDC05115
{
  private static final HashMap<String, ReportModel> MINI_APP_ID_REPORT_MODEL_HASH_MAP = new HashMap();
  private static final String TAG = "MiniProgramLpReportDC05";
  
  private static void doReport(ReportModel paramReportModel)
  {
    if (paramReportModel != null) {
      try
      {
        String str = paramReportModel.toReportRecord();
        QMLog.d("MiniProgramLpReportDC05", "doReport " + str);
        QMLog.d("MiniProgramLpReportDC05", "doReport " + paramReportModel.toString());
        Bundle localBundle = new Bundle();
        localBundle.putStringArray("data", new String[] { str });
        if (QUAUtil.isQQApp()) {}
        for (str = "dc05115";; str = "dc05387")
        {
          localBundle.putString("log_key", str);
          AppBrandCmdProxy.g().sendCmd("cmd_dc_report_log_key_data", localBundle, null);
          paramReportModel.reset();
          return;
        }
        return;
      }
      catch (Exception paramReportModel)
      {
        QMLog.e("MiniProgramLpReportDC05", "doReport ", paramReportModel);
      }
    }
  }
  
  public static void reDispatchReportEvent(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, long paramLong)
  {
    ReportModel localReportModel;
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)) && (paramString1 != null))
    {
      localReportModel = (ReportModel)MINI_APP_ID_REPORT_MODEL_HASH_MAP.get(paramMiniAppInfo.appId);
      if (localReportModel == null) {
        break label131;
      }
      if (!"app_download_result".equals(paramString1)) {
        break label55;
      }
      localReportModel.reportPKGDownloadResult(paramLong, paramString2);
    }
    label55:
    do
    {
      return;
      if ("launch_result".equals(paramString1))
      {
        localReportModel.reportLaunchResult(paramLong, paramString2);
        return;
      }
      if ("game_first_launch_result".equals(paramString1))
      {
        ReportModel.access$002(localReportModel, true);
        return;
      }
      if ("game_twice_launch_result".equals(paramString1))
      {
        localReportModel.reportReLaunchResult(paramLong, paramString2);
        return;
      }
    } while ((!"minigamestaytime".equals(paramString1)) && (!"miniappstaytime".equals(paramString1)));
    localReportModel.setGameUseTime(paramLong);
    return;
    label131:
    MINI_APP_ID_REPORT_MODEL_HASH_MAP.put(paramMiniAppInfo.appId, new ReportModel(paramMiniAppInfo));
  }
  
  public static void reportCPUMemoryFPS(MiniAppInfo paramMiniAppInfo, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      paramMiniAppInfo = (ReportModel)MINI_APP_ID_REPORT_MODEL_HASH_MAP.get(paramMiniAppInfo.appId);
      if (paramMiniAppInfo != null)
      {
        paramMiniAppInfo.reportCPUMemoryFPS(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5);
        doReport(paramMiniAppInfo);
      }
    }
  }
  
  public static void reportCrash(MiniAppInfo paramMiniAppInfo, Throwable paramThrowable)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      paramMiniAppInfo = (ReportModel)MINI_APP_ID_REPORT_MODEL_HASH_MAP.get(paramMiniAppInfo.appId);
      if (paramMiniAppInfo != null)
      {
        ReportModel.access$202(paramMiniAppInfo, 1L);
        if (!(paramThrowable instanceof OutOfMemoryError)) {
          break label59;
        }
      }
    }
    label59:
    for (int i = 1;; i = 0)
    {
      ReportModel.access$302(paramMiniAppInfo, i);
      doReport(paramMiniAppInfo);
      return;
    }
  }
  
  public static void reportDownloadResult(MiniAppInfo paramMiniAppInfo, int paramInt, long paramLong, boolean paramBoolean)
  {
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      paramMiniAppInfo = (ReportModel)MINI_APP_ID_REPORT_MODEL_HASH_MAP.get(paramMiniAppInfo.appId);
      if (paramMiniAppInfo != null) {
        paramMiniAppInfo.reportDownloadRequestResult(paramLong, paramInt, paramBoolean);
      }
    }
  }
  
  public static void reportDownloadResultForSDK(MiniAppInfo paramMiniAppInfo, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      paramMiniAppInfo = (ReportModel)MINI_APP_ID_REPORT_MODEL_HASH_MAP.get(paramMiniAppInfo.appId);
      if (paramMiniAppInfo != null) {
        paramMiniAppInfo.reportDownloadRequestResult(paramLong2, paramLong1, paramBoolean);
      }
    }
  }
  
  public static void reportHttpRequestResult(MiniAppInfo paramMiniAppInfo, int paramInt, long paramLong1, long paramLong2)
  {
    if ((paramMiniAppInfo != null) && (!TextUtils.isEmpty(paramMiniAppInfo.appId)))
    {
      paramMiniAppInfo = (ReportModel)MINI_APP_ID_REPORT_MODEL_HASH_MAP.get(paramMiniAppInfo.appId);
      if (paramMiniAppInfo != null) {
        paramMiniAppInfo.reportHttpRequestResult(paramLong2, paramLong1, paramInt);
      }
    }
  }
  
  public static class ReportModel
  {
    private String androidID = alla.getString(AppLoaderFactory.g().getMiniAppEnv().getContext().getContentResolver(), "android_id");
    private String clientVersion = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion();
    private int cpuAVG;
    private long crashErrorNum = 0L;
    private String deviceManufacturer = Build.MANUFACTURER;
    private String deviceModel = Build.MODEL;
    private String devicePlatform = "android";
    private String deviceVersion = Build.VERSION.RELEASE;
    private long downloadRequestCost;
    private List<Long> downloadRequestCostList = new ArrayList();
    private long downloadRequestErrorNum;
    private long downloadRequestLength;
    private List<Long> downloadRequestLengths = new ArrayList();
    private long downloadRequestNum;
    private int fpsAVG;
    private int fpsVARI = 0;
    private long gamePrepareCost;
    private long gameUseTime;
    private long httpRequestCost;
    private List<Long> httpRequestCostList = new ArrayList();
    private long httpRequestErrorNum;
    private long httpRequestLength;
    private List<Long> httpRequestLengths = new ArrayList();
    private long httpRequestNum;
    private long jsErrorNum = 0L;
    private long launchCost;
    private boolean launchFlag = false;
    private String launchResult;
    private int memAVG;
    private int memINC;
    private MiniAppInfo miniAppConfig;
    private String networkGateWayIP = "null";
    private String networkSSID = NetworkUtil.getCurrentWifiSSID(AppLoaderFactory.g().getMiniAppEnv().getContext());
    private String networkType = MiniProgramReportHelper.getNetworkType();
    private long oomErrorNum = 0L;
    private String openID = "null";
    private long pkgDownloadCost;
    private String pkgDownloadResult;
    private String qua = QUAUtil.getPlatformQUA();
    private long relaunchCost;
    private String sdk_version = QUAUtil.getQUA();
    private String source_app = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getPlatformId();
    private String source_uin_platform = QUAUtil.getLoginType();
    private String source_version = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion();
    private String x5Version = "1.0";
    
    public ReportModel(MiniAppInfo paramMiniAppInfo)
    {
      this.miniAppConfig = paramMiniAppInfo;
    }
    
    private void prepareReportRecord()
    {
      long l2 = 0L;
      try
      {
        this.gamePrepareCost = this.launchCost;
        int i;
        Iterator localIterator;
        long l1;
        if (!this.httpRequestCostList.isEmpty())
        {
          i = this.httpRequestCostList.size();
          localIterator = this.httpRequestCostList.iterator();
          for (l1 = 0L; localIterator.hasNext(); l1 = ((Long)localIterator.next()).longValue() + l1) {}
          this.httpRequestCost = (l1 / i);
        }
        if (!this.httpRequestLengths.isEmpty())
        {
          localIterator = this.httpRequestLengths.iterator();
          for (l1 = 0L; localIterator.hasNext(); l1 = ((Long)localIterator.next()).longValue() + l1) {}
          this.httpRequestLength = (l1 / this.httpRequestLengths.size());
        }
        if (!this.downloadRequestCostList.isEmpty())
        {
          i = this.downloadRequestCostList.size();
          localIterator = this.downloadRequestCostList.iterator();
          for (l1 = 0L; localIterator.hasNext(); l1 = Math.max(((Long)localIterator.next()).longValue(), 0L) + l1) {}
          this.downloadRequestCost = (l1 / i);
        }
        if (!this.downloadRequestLengths.isEmpty())
        {
          localIterator = this.downloadRequestLengths.iterator();
          for (l1 = l2; localIterator.hasNext(); l1 = ((Long)localIterator.next()).longValue() + l1) {}
          this.downloadRequestLength = (l1 / this.downloadRequestLengths.size());
        }
        return;
      }
      finally {}
    }
    
    private void reportCPUMemoryFPS(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
    {
      this.cpuAVG = ((int)paramFloat1);
      this.memAVG = ((int)paramFloat2);
      this.memINC = ((int)paramFloat3);
      this.fpsAVG = ((int)paramFloat4);
      this.fpsVARI = ((int)paramFloat5);
    }
    
    /* Error */
    public void reportDownloadRequestResult(long paramLong1, long paramLong2, boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: aload_0
      //   4: getfield 277	com/tencent/qqmini/sdk/report/MiniProgramLpReportDC05115$ReportModel:downloadRequestNum	J
      //   7: lconst_1
      //   8: ladd
      //   9: putfield 277	com/tencent/qqmini/sdk/report/MiniProgramLpReportDC05115$ReportModel:downloadRequestNum	J
      //   12: iload 5
      //   14: ifeq +16 -> 30
      //   17: aload_0
      //   18: aload_0
      //   19: getfield 279	com/tencent/qqmini/sdk/report/MiniProgramLpReportDC05115$ReportModel:downloadRequestErrorNum	J
      //   22: lconst_1
      //   23: ladd
      //   24: putfield 279	com/tencent/qqmini/sdk/report/MiniProgramLpReportDC05115$ReportModel:downloadRequestErrorNum	J
      //   27: aload_0
      //   28: monitorexit
      //   29: return
      //   30: aload_0
      //   31: getfield 201	com/tencent/qqmini/sdk/report/MiniProgramLpReportDC05115$ReportModel:downloadRequestCostList	Ljava/util/List;
      //   34: lload_1
      //   35: invokestatic 283	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   38: invokeinterface 287 2 0
      //   43: pop
      //   44: aload_0
      //   45: getfield 203	com/tencent/qqmini/sdk/report/MiniProgramLpReportDC05115$ReportModel:downloadRequestLengths	Ljava/util/List;
      //   48: lload_3
      //   49: invokestatic 283	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   52: invokeinterface 287 2 0
      //   57: pop
      //   58: goto -31 -> 27
      //   61: astore 6
      //   63: aload_0
      //   64: monitorexit
      //   65: aload 6
      //   67: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	68	0	this	ReportModel
      //   0	68	1	paramLong1	long
      //   0	68	3	paramLong2	long
      //   0	68	5	paramBoolean	boolean
      //   61	5	6	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	12	61	finally
      //   17	27	61	finally
      //   30	58	61	finally
    }
    
    /* Error */
    public void reportHttpRequestResult(long paramLong1, long paramLong2, int paramInt)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: aload_0
      //   4: getfield 291	com/tencent/qqmini/sdk/report/MiniProgramLpReportDC05115$ReportModel:httpRequestNum	J
      //   7: lconst_1
      //   8: ladd
      //   9: putfield 291	com/tencent/qqmini/sdk/report/MiniProgramLpReportDC05115$ReportModel:httpRequestNum	J
      //   12: iload 5
      //   14: ifge +16 -> 30
      //   17: aload_0
      //   18: aload_0
      //   19: getfield 293	com/tencent/qqmini/sdk/report/MiniProgramLpReportDC05115$ReportModel:httpRequestErrorNum	J
      //   22: lconst_1
      //   23: ladd
      //   24: putfield 293	com/tencent/qqmini/sdk/report/MiniProgramLpReportDC05115$ReportModel:httpRequestErrorNum	J
      //   27: aload_0
      //   28: monitorexit
      //   29: return
      //   30: aload_0
      //   31: getfield 197	com/tencent/qqmini/sdk/report/MiniProgramLpReportDC05115$ReportModel:httpRequestCostList	Ljava/util/List;
      //   34: lload_1
      //   35: invokestatic 283	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   38: invokeinterface 287 2 0
      //   43: pop
      //   44: aload_0
      //   45: getfield 199	com/tencent/qqmini/sdk/report/MiniProgramLpReportDC05115$ReportModel:httpRequestLengths	Ljava/util/List;
      //   48: lload_3
      //   49: invokestatic 283	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   52: invokeinterface 287 2 0
      //   57: pop
      //   58: goto -31 -> 27
      //   61: astore 6
      //   63: aload_0
      //   64: monitorexit
      //   65: aload 6
      //   67: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	68	0	this	ReportModel
      //   0	68	1	paramLong1	long
      //   0	68	3	paramLong2	long
      //   0	68	5	paramInt	int
      //   61	5	6	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	12	61	finally
      //   17	27	61	finally
      //   30	58	61	finally
    }
    
    public void reportLaunchResult(long paramLong, String paramString)
    {
      this.launchResult = paramString;
      this.launchCost = paramLong;
    }
    
    public void reportPKGDownloadResult(long paramLong, String paramString)
    {
      this.pkgDownloadCost = paramLong;
      this.pkgDownloadResult = paramString;
    }
    
    public void reportReLaunchResult(long paramLong, String paramString)
    {
      this.launchResult = paramString;
      this.relaunchCost = paramLong;
    }
    
    public void reset()
    {
      try
      {
        this.downloadRequestErrorNum = 0L;
        this.downloadRequestNum = 0L;
        this.downloadRequestLengths.clear();
        this.downloadRequestCostList.clear();
        this.httpRequestErrorNum = 0L;
        this.httpRequestNum = 0L;
        this.httpRequestLengths.clear();
        this.httpRequestCostList.clear();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void setGameUseTime(long paramLong)
    {
      this.gameUseTime = paramLong;
    }
    
    public void setMiniAppConfig(MiniAppInfo paramMiniAppInfo)
    {
      this.miniAppConfig = paramMiniAppInfo;
    }
    
    public String toReportRecord()
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      prepareReportRecord();
      int i;
      label47:
      StringBuilder localStringBuilder2;
      if (this.miniAppConfig != null)
      {
        localObject = this.miniAppConfig.appId;
        localObject = localStringBuilder1.append((String)localObject).append('|');
        if (!this.launchFlag) {
          break label699;
        }
        i = 1;
        localStringBuilder2 = ((StringBuilder)localObject).append(i).append('|').append(this.launchCost).append('|').append(this.relaunchCost).append('|').append(this.pkgDownloadCost).append('|').append(this.pkgDownloadResult).append('|').append(this.gamePrepareCost).append('|').append(this.fpsAVG).append('|').append(this.fpsVARI).append('|').append(this.cpuAVG).append('|').append(this.memAVG).append('|').append(this.memINC).append('|').append(this.httpRequestCost).append('|').append(this.httpRequestNum).append('|').append(this.httpRequestErrorNum).append('|').append(this.httpRequestLength).append('|').append(this.downloadRequestCost).append('|').append(this.downloadRequestNum).append('|').append(this.downloadRequestErrorNum).append('|').append(this.downloadRequestLength).append('|').append(this.jsErrorNum).append('|').append(this.oomErrorNum).append('|').append(this.crashErrorNum).append('|').append(this.launchResult).append('|').append(this.gameUseTime).append('|');
        if ((this.miniAppConfig == null) || (this.miniAppConfig.launchParam == null)) {
          break label704;
        }
        localObject = Integer.valueOf(this.miniAppConfig.launchParam.scene);
        label366:
        localStringBuilder2 = localStringBuilder2.append(localObject).append('|').append(System.currentTimeMillis()).append('|');
        if (this.miniAppConfig == null) {
          break label710;
        }
        localObject = Integer.valueOf(this.miniAppConfig.getReportType());
        label408:
        localStringBuilder2 = localStringBuilder2.append(localObject).append('|').append(this.networkType).append('|').append(this.qua).append('|').append(this.clientVersion).append('|');
        if (this.miniAppConfig == null) {
          break label716;
        }
        localObject = this.miniAppConfig.version;
        label472:
        localStringBuilder2 = localStringBuilder2.append((String)localObject).append('|');
        if ((this.miniAppConfig == null) || (this.miniAppConfig.baseLibInfo == null)) {
          break label722;
        }
      }
      label699:
      label704:
      label710:
      label716:
      label722:
      for (Object localObject = this.miniAppConfig.baseLibInfo.baseLibVersion;; localObject = "null")
      {
        localStringBuilder2.append((String)localObject).append('|').append(this.x5Version).append('|').append(this.devicePlatform).append('|').append(this.deviceManufacturer).append('|').append(this.deviceModel).append('|').append(this.deviceVersion).append('|').append(this.networkGateWayIP).append('|').append(this.networkSSID).append('|').append(this.androidID).append('|').append(this.openID);
        if (!QUAUtil.isQQApp()) {
          localStringBuilder1.append("|").append(this.sdk_version).append("|").append(this.source_app).append("|").append(this.source_version).append("|").append(this.source_uin_platform);
        }
        return localStringBuilder1.toString();
        localObject = "null";
        break;
        i = 0;
        break label47;
        localObject = "null";
        break label366;
        localObject = "null";
        break label408;
        localObject = "null";
        break label472;
      }
    }
    
    public String toString()
    {
      return "ReportModel{launchFlag=" + this.launchFlag + ", launchCost=" + this.launchCost + ", relaunchCost=" + this.relaunchCost + ", pkgDownloadCost=" + this.pkgDownloadCost + ", pkgDownloadResult='" + this.pkgDownloadResult + '\'' + ", gamePrepareCost=" + this.gamePrepareCost + ", fpsAVG=" + this.fpsAVG + ", fpsVARI=" + this.fpsVARI + ", cpuAVG=" + this.cpuAVG + ", memAVG=" + this.memAVG + ", memINC=" + this.memINC + ", httpRequestCost=" + this.httpRequestCost + ", httpRequestNum=" + this.httpRequestNum + ", httpRequestErrorNum=" + this.httpRequestErrorNum + ", httpRequestLength=" + this.httpRequestLength + ", downloadRequestCost=" + this.downloadRequestCost + ", downloadRequestNum=" + this.downloadRequestNum + ", downloadRequestErrorNum=" + this.downloadRequestErrorNum + ", downloadRequestLength=" + this.downloadRequestLength + ", jsErrorNum=" + this.jsErrorNum + ", oomErrorNum=" + this.oomErrorNum + ", crashErrorNum=" + this.crashErrorNum + ", launchResult='" + this.launchResult + '\'' + ", gameUseTime=" + this.gameUseTime + ", x5Version='" + this.x5Version + '\'' + ", openID='" + this.openID + '\'' + ", clientVersion='" + this.clientVersion + '\'' + ", devicePlatform='" + this.devicePlatform + '\'' + ", deviceManufacturer='" + this.deviceManufacturer + '\'' + ", deviceModel='" + this.deviceModel + '\'' + ", deviceVersion='" + this.deviceVersion + '\'' + ", qua='" + this.qua + '\'' + ", networkType='" + this.networkType + '\'' + ", networkGateWayIP='" + this.networkGateWayIP + '\'' + ", networkSSID='" + this.networkSSID + '\'' + ", androidID='" + this.androidID + '\'' + ", sdk_version='" + this.sdk_version + '\'' + ", source_app='" + this.source_app + '\'' + ", source_version='" + this.source_version + '\'' + ", source_uin_platform='" + this.source_uin_platform + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC05115
 * JD-Core Version:    0.7.0.1
 */