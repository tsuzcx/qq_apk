package com.tencent.qapmsdk.battery;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.monitorplugin.QAPMMonitorPlugin;
import com.tencent.qapmsdk.base.reporter.ReporterMachine;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import com.tencent.qapmsdk.battery.config.BatteryConfig;
import com.tencent.qapmsdk.battery.config.CmdMeta;
import com.tencent.qapmsdk.battery.config.CpuMeta;
import com.tencent.qapmsdk.battery.config.GPSMeta;
import com.tencent.qapmsdk.battery.config.LogMeta;
import com.tencent.qapmsdk.battery.config.TrafficMeta;
import com.tencent.qapmsdk.battery.config.WakeLockMeta;
import com.tencent.qapmsdk.battery.config.WifiMeta;
import com.tencent.qapmsdk.battery.listener.BatteryStats;
import com.tencent.qapmsdk.battery.monitor.CmdMonitor;
import com.tencent.qapmsdk.battery.monitor.CpuMonitor;
import com.tencent.qapmsdk.battery.monitor.GPSMonitor;
import com.tencent.qapmsdk.battery.monitor.HookMethodCallback;
import com.tencent.qapmsdk.battery.monitor.LogMonitor;
import com.tencent.qapmsdk.battery.monitor.TrafficMonitor;
import com.tencent.qapmsdk.battery.monitor.WakeLockMonitor;
import com.tencent.qapmsdk.battery.monitor.WifiMonitor;
import com.tencent.qapmsdk.common.activty.LifecycleCallback;
import com.tencent.qapmsdk.common.json.JsonDispose;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.common.util.AppInfo;
import com.tencent.qapmsdk.common.util.AsyncSPEditor;
import com.tencent.qapmsdk.common.util.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BatteryMonitor
  extends QAPMMonitorPlugin
  implements Handler.Callback, BatteryStats
{
  private static boolean DEBUG_MONITOR_TIME = false;
  private static final int GRAY_ENLARGE_RATIO = 50;
  private static final String KEY_LAST_RANDOM_FACTOR = "rand_factor";
  private static final String KEY_LAST_RANDOM_TIMESTAMP = "last_rand_timestamp";
  private static final String KEY_LAST_REPORT_TIMESTAMP = "battery_report_timestamp";
  private static final String KEY_RANDOM_RESULT = "rand_result";
  private static final int MSG_BG_5_MIN = 5;
  private static final int MSG_HOOK_READY = 6;
  private static final int MSG_INIT = 0;
  private static final int MSG_REPORT_CLEAN_LOG = 2;
  private static final int MSG_RUN_30_MIN = 4;
  private static final int MSG_STOP_MONITOR = 3;
  private static final int PUB_ENLARGE_RATIO = 300;
  private static final long REPORT_INTERVAL;
  private static final int STATUS_NOT_MONITOR = 0;
  private static final int STATUS_RUNNING = 1;
  private static final int STATUS_UN_INIT = -1;
  private static final String TAG = "QAPM_battery_BatteryStatsImpl";
  @Nullable
  private static volatile BatteryMonitor instance = null;
  private BatteryForeCallbackImpl batteryForeCallback = new BatteryForeCallbackImpl();
  private List<BatteryUsageItem> batteryUsageList;
  IBatteryStatsCallback callback;
  private CmdMonitor cmdMonitor;
  private BatteryConfig globalConfig;
  private GPSMonitor gpsMonitor;
  private boolean hasAppBg5Min = false;
  private boolean hasCleanLog = false;
  private boolean isBackground = false;
  public boolean isHookReady;
  private LogMonitor logMonitor;
  private int status = -1;
  @NonNull
  private Handler subHandler = new Handler(ThreadManager.getBatteryThreadLooper(), this);
  private WakeLockMonitor wakeLockMonitor;
  private WifiMonitor wifiMonitor;
  
  static
  {
    DEBUG_MONITOR_TIME = false;
    if (Logger.debug) {}
    for (long l = 14400000L;; l = 86400000L)
    {
      REPORT_INTERVAL = l;
      return;
    }
  }
  
  private BatteryMonitor()
  {
    LifecycleCallback.INSTANCE.register(this.batteryForeCallback);
  }
  
  private void addData(String paramString, int[] paramArrayOfInt, String[] paramArrayOfString, JSONArray paramJSONArray)
    throws JSONException
  {
    int j = (int)(Long.valueOf(paramArrayOfString[0]).longValue() / 1000L);
    Object localObject = null;
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        paramString = localObject;
      }
      break;
    }
    for (;;)
    {
      if (paramString != null) {
        paramJSONArray.put(paramString);
      }
      return;
      if (!paramString.equals("fg30Cpu")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("bg5Cpu")) {
        break;
      }
      i = 1;
      break;
      if (!paramString.equals("fg30Trf")) {
        break;
      }
      i = 2;
      break;
      if (!paramString.equals("bg5Trf")) {
        break;
      }
      i = 3;
      break;
      if (!paramString.equals("fg30CmdCount")) {
        break;
      }
      i = 4;
      break;
      if (!paramString.equals("bg5CmdCount")) {
        break;
      }
      i = 5;
      break;
      if (!paramString.equals("fg30LogCount")) {
        break;
      }
      i = 6;
      break;
      if (!paramString.equals("bg5LogCount")) {
        break;
      }
      i = 7;
      break;
      if (!paramString.equals("fg30CmdAlarm")) {
        break;
      }
      i = 8;
      break;
      if (!paramString.equals("bg5CmdAlarm")) {
        break;
      }
      i = 9;
      break;
      if (!paramString.equals("fg30LogAlarm")) {
        break;
      }
      i = 10;
      break;
      if (!paramString.equals("bg5LogAlarm")) {
        break;
      }
      i = 11;
      break;
      paramArrayOfInt[0] += 1;
      paramString = handlerCpuData(j, paramArrayOfString);
      continue;
      paramArrayOfInt[1] += 1;
      paramString = handlerCpuData(j, paramArrayOfString);
      continue;
      paramString = handlerTrafficData(j, paramArrayOfString);
      continue;
      paramString = handlerLogOrCmdData(j, paramArrayOfString);
      continue;
      paramString = handlerLogOrCmdDataAlarm(paramString, paramArrayOfString);
    }
  }
  
  private String combineString(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return paramArrayOfString[paramInt1];
    }
    StringBuilder localStringBuilder = new StringBuilder((paramInt2 - paramInt1) * 10);
    while (paramInt1 < paramInt2 + 1)
    {
      localStringBuilder.append(paramArrayOfString[paramInt1]);
      if (paramInt1 != paramInt2) {
        localStringBuilder.append("|");
      }
      paramInt1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void doQuickFileReport(long paramLong1, long paramLong2)
  {
    File localFile = BatteryLog.getCommonLogFileForReport(paramLong1, paramLong2, 10, 3000L);
    if (localFile != null)
    {
      Logger.INSTANCE.i(new String[] { "QAPM_battery_BatteryStatsImpl", "report battery log: ", localFile.getName() });
      doReport(true, localFile.getAbsolutePath(), null);
      return;
    }
    Logger.INSTANCE.i(new String[] { "QAPM_battery_BatteryStatsImpl", "no battery log to report" });
  }
  
  private void doQuickJsonReport(long paramLong1, long paramLong2)
  {
    Object localObject = BatteryLog.getReportLogFile(paramLong1, paramLong2, 200L);
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      Logger.INSTANCE.e(new String[] { "QAPM_battery_BatteryStatsImpl", "battery report, but reportLogFile is null" });
    }
    JSONObject localJSONObject;
    do
    {
      return;
      localJSONObject = new JSONObject();
      localObject = handlerAllData(localJSONObject, (List)localObject);
    } while ((localObject[0] <= 0) && (localObject[1] <= 0));
    doReport(false, null, localJSONObject);
  }
  
  private void doReport(boolean paramBoolean, String paramString, JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (paramBoolean) {
        localJSONObject.put("fileObj", paramString);
      }
      for (;;)
      {
        localJSONObject.put("plugin", PluginCombination.batteryPlugin.plugin);
        paramString = new ResultObject(0, "Battery target", true, 1L, 1L, JsonDispose.copyJson(BaseInfo.pubJson, localJSONObject), true, true, BaseInfo.userMeta.uin);
        ReporterMachine.INSTANCE.addResultObj(paramString);
        return;
        localJSONObject.put("batterydata", paramJSONObject);
      }
      return;
    }
    catch (Exception paramString)
    {
      Logger.INSTANCE.exception("QAPM_battery_BatteryStatsImpl", paramString);
    }
  }
  
  public static BatteryMonitor getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new BatteryMonitor();
      }
      return instance;
    }
    finally {}
  }
  
  private int[] handlerAllData(JSONObject paramJSONObject, List<File> paramList)
  {
    arrayOfInt = new int[3];
    int[] tmp7_5 = arrayOfInt;
    tmp7_5[0] = 0;
    int[] tmp11_7 = tmp7_5;
    tmp11_7[1] = 0;
    int[] tmp15_11 = tmp11_7;
    tmp15_11[2] = 500;
    tmp15_11;
    try
    {
      paramJSONObject.put("device", Build.MODEL);
      paramJSONObject.put("sdk", Build.VERSION.SDK_INT);
      paramJSONObject.put("uin", BaseInfo.userMeta.uin);
      if (Logger.debug) {}
      for (int i = 3;; i = 2)
      {
        paramList = paramList.iterator();
        int j;
        do
        {
          do
          {
            if (!paramList.hasNext()) {
              break;
            }
            FileUtil.readStreamByLine((File)paramList.next(), new BatteryMonitor.1(this, arrayOfInt, i, paramJSONObject));
          } while (arrayOfInt[0] < i);
          j = arrayOfInt[1];
        } while (j < i);
        return arrayOfInt;
      }
      return arrayOfInt;
    }
    catch (Throwable paramJSONObject)
    {
      Logger.INSTANCE.exception("QAPM_battery_BatteryStatsImpl", paramJSONObject);
    }
  }
  
  private JSONObject handlerCpuData(long paramLong, String[] paramArrayOfString)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("main", paramArrayOfString[2]);
    localJSONObject.put("device", paramArrayOfString[3]);
    localJSONObject.put("time", paramLong);
    if (paramArrayOfString.length >= 5) {
      localJSONObject.put("other", paramArrayOfString[3]);
    }
    return localJSONObject;
  }
  
  private JSONObject handlerLogOrCmdData(long paramLong, String[] paramArrayOfString)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("time", paramLong);
    localJSONObject.put("count", paramArrayOfString[2]);
    return localJSONObject;
  }
  
  private JSONObject handlerLogOrCmdDataAlarm(String paramString, String[] paramArrayOfString)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject = combineString(paramArrayOfString, 2, paramArrayOfString.length - 2);
    if ((paramString.equals("fg30LogAlarm")) || (paramString.equals("bg5LogAlarm"))) {
      localJSONObject1.put("log", localObject);
    }
    for (;;)
    {
      paramString = new JSONArray();
      localJSONObject1.put("detail", paramString);
      paramArrayOfString = paramArrayOfString[(paramArrayOfString.length - 1)].split("#");
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localObject = paramArrayOfString[i].split(",");
        if (localObject.length > 1)
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("time", Long.valueOf(localObject[0]).longValue() / 1000L);
          localJSONObject2.put("count", localObject[1]);
          paramString.put(localJSONObject2);
        }
        i += 1;
      }
      localJSONObject1.put("cmd", localObject);
    }
    return localJSONObject1;
  }
  
  private JSONObject handlerTrafficData(long paramLong, String[] paramArrayOfString)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("time", paramLong);
    localJSONObject.put("qqRecv", paramArrayOfString[2]);
    localJSONObject.put("qqSend", paramArrayOfString[3]);
    localJSONObject.put("devRecv", paramArrayOfString[4]);
    localJSONObject.put("devSend", paramArrayOfString[5]);
    return localJSONObject;
  }
  
  private void initConfig()
  {
    if (this.globalConfig != null) {
      return;
    }
    this.globalConfig = new BatteryConfig(true, 3600L);
    this.globalConfig.cpuConfig = new CpuMeta();
    this.globalConfig.trafficConfig = new TrafficMeta();
    this.globalConfig.logConfig = new LogMeta();
    this.globalConfig.cmdConfig = new CmdMeta();
    this.globalConfig.wakeLockConfig = new WakeLockMeta();
    this.globalConfig.gpsConfig = new GPSMeta();
    this.globalConfig.wifiConfig = new WifiMeta();
  }
  
  private void startMonitor()
  {
    this.batteryUsageList = new ArrayList(10);
    this.logMonitor = new LogMonitor(this.globalConfig.logConfig);
    this.cmdMonitor = new CmdMonitor(this.globalConfig.cmdConfig);
    this.batteryUsageList.add(new CpuMonitor(this.globalConfig.cpuConfig));
    this.batteryUsageList.add(new TrafficMonitor(this.globalConfig.trafficConfig));
    this.batteryUsageList.add(this.cmdMonitor);
    this.batteryUsageList.add(this.logMonitor);
    this.gpsMonitor = new GPSMonitor(this.globalConfig.gpsConfig);
    this.batteryUsageList.add(this.gpsMonitor);
    this.wakeLockMonitor = new WakeLockMonitor(this.globalConfig.wakeLockConfig);
    this.batteryUsageList.add(this.wakeLockMonitor);
    this.wifiMonitor = new WifiMonitor(this.globalConfig.wifiConfig);
    this.batteryUsageList.add(this.wifiMonitor);
    BatteryLog.init(AppInfo.obtainProcessName(BaseInfo.app), BatteryConstants.BATTERY_START_TIME);
    Logger.INSTANCE.i(new String[] { "QAPM_battery_BatteryStatsImpl", "isHookReady = " + this.isHookReady });
    Object localObject = this.batteryUsageList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      BatteryUsageItem localBatteryUsageItem = (BatteryUsageItem)((Iterator)localObject).next();
      localBatteryUsageItem.onProcessStart();
      if (this.isHookReady) {
        localBatteryUsageItem.onHookReady();
      }
    }
    this.status = 1;
    long l = this.globalConfig.monitorEndTime;
    this.subHandler.sendEmptyMessageDelayed(3, (l + 60L) * 1000L);
    localObject = this.subHandler;
    if (DEBUG_MONITOR_TIME) {}
    for (l = 180000L;; l = 1800000L)
    {
      ((Handler)localObject).sendEmptyMessageDelayed(4, l);
      return;
    }
  }
  
  public HookMethodCallback getGPSHook()
  {
    return this.gpsMonitor;
  }
  
  public HookMethodCallback getWakeLockHook()
  {
    return this.wakeLockMonitor;
  }
  
  public HookMethodCallback getWifiHook()
  {
    return this.wifiMonitor;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1: 
    default: 
    case 0: 
      do
      {
        return true;
      } while (this.status != -1);
      BatteryConstants.BATTERY_START_TIME = System.currentTimeMillis();
      try
      {
        initConfig();
        startMonitor();
        return true;
      }
      catch (Exception paramMessage)
      {
        this.status = 0;
        return true;
      }
    case 2: 
      initConfig();
      if (this.globalConfig.reportfile) {
        if (BaseInfo.sharePreference == null) {
          break label499;
        }
      }
      break;
    }
    label165:
    label227:
    label499:
    for (long l1 = BaseInfo.sharePreference.getLong("battery_report_timestamp", 0L);; l1 = 0L)
    {
      for (;;)
      {
        long l2;
        int i;
        if (Math.abs(System.currentTimeMillis() - l1) > REPORT_INTERVAL) {
          if (BatteryConstants.BATTERY_START_TIME != 0L)
          {
            l2 = BatteryConstants.BATTERY_START_TIME - 60000L;
            doQuickJsonReport(l1, l2);
            if (!Logger.debug) {
              break label227;
            }
            i = 50;
            float f = (float)(1.0D / i);
            if (Math.random() < f) {
              doQuickFileReport(l1, l2);
            }
            BaseInfo.editor.putLong("battery_report_timestamp", l2).commit();
          }
        }
        for (;;)
        {
          BatteryLog.cleanStorage(BatteryConstants.BATTERY_START_TIME - 172800000L);
          this.hasCleanLog = true;
          return true;
          l2 = System.currentTimeMillis();
          break;
          i = 300;
          break label165;
          Logger.INSTANCE.i(new String[] { "QAPM_battery_BatteryStatsImpl", "battery want report, but interval is short" });
          continue;
          Logger.INSTANCE.i(new String[] { "QAPM_battery_BatteryStatsImpl", "battery report switch is off" });
        }
        if (this.batteryUsageList != null)
        {
          paramMessage = this.batteryUsageList.iterator();
          while (paramMessage.hasNext()) {
            ((BatteryUsageItem)paramMessage.next()).stop();
          }
        }
        this.status = 0;
        return true;
        if (this.batteryUsageList == null) {
          break;
        }
        try
        {
          paramMessage = this.batteryUsageList.iterator();
          while (paramMessage.hasNext()) {
            ((BatteryUsageItem)paramMessage.next()).onProcessRun30Min();
          }
          if (this.batteryUsageList == null) {
            break label434;
          }
        }
        catch (Exception paramMessage)
        {
          Logger.INSTANCE.exception("QAPM_battery_BatteryStatsImpl", paramMessage);
          return true;
        }
      }
      try
      {
        paramMessage = this.batteryUsageList.iterator();
        while (paramMessage.hasNext()) {
          ((BatteryUsageItem)paramMessage.next()).onProcessBG5Min();
        }
        this.hasAppBg5Min = true;
      }
      catch (Exception paramMessage)
      {
        Logger.INSTANCE.exception("QAPM_battery_BatteryStatsImpl", paramMessage);
      }
      return true;
      if (this.batteryUsageList != null) {
        try
        {
          paramMessage = this.batteryUsageList.iterator();
          while (paramMessage.hasNext()) {
            ((BatteryUsageItem)paramMessage.next()).onHookReady();
          }
          this.hasAppBg5Min = true;
        }
        catch (Exception paramMessage)
        {
          Logger.INSTANCE.exception("QAPM_battery_BatteryStatsImpl", paramMessage);
        }
      }
      return true;
    }
  }
  
  public boolean isHasAppBg5Min()
  {
    return this.hasAppBg5Min;
  }
  
  public boolean isJavaHookReady()
  {
    return this.isHookReady;
  }
  
  public void onAppBackground()
  {
    if ((this.isBackground) || (this.status != 1)) {
      return;
    }
    this.isBackground = true;
    Object localObject = this.batteryUsageList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((BatteryUsageItem)((Iterator)localObject).next()).onAppBackground();
    }
    if (!this.hasAppBg5Min)
    {
      localObject = this.subHandler;
      if (!DEBUG_MONITOR_TIME) {
        break label104;
      }
    }
    label104:
    for (long l = 120000L;; l = 300000L)
    {
      ((Handler)localObject).sendEmptyMessageDelayed(5, l);
      if (this.hasCleanLog) {
        break;
      }
      this.subHandler.sendEmptyMessageDelayed(2, 200L);
      return;
    }
  }
  
  public void onAppForeground()
  {
    this.isBackground = false;
    if (this.status != 1) {
      return;
    }
    Iterator localIterator = this.batteryUsageList.iterator();
    while (localIterator.hasNext()) {
      ((BatteryUsageItem)localIterator.next()).onAppForeground();
    }
    this.subHandler.removeMessages(5);
  }
  
  public void onCmdRequest(String paramString)
  {
    if ((this.status != 1) || (this.cmdMonitor == null)) {
      return;
    }
    this.cmdMonitor.onCmdRequest(paramString);
  }
  
  public void onGPSScan(String paramString, Object[] paramArrayOfObject)
  {
    if (this.gpsMonitor != null) {
      this.gpsMonitor.onGPSScan(paramString, paramArrayOfObject);
    }
  }
  
  public void onPrintLog(String paramString) {}
  
  public void onWriteLog(String paramString1, String paramString2)
  {
    if ((this.status != 1) || (this.logMonitor == null)) {
      return;
    }
    this.logMonitor.onWriteLog(paramString1, paramString2);
  }
  
  public void setCallback(IBatteryStatsCallback paramIBatteryStatsCallback)
  {
    this.callback = paramIBatteryStatsCallback;
  }
  
  public void setCmdWhite(@NonNull List<String> paramList, int paramInt)
  {
    if (this.cmdMonitor != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!TextUtils.isEmpty(str)) {
          this.cmdMonitor.getCmdWhiteMap().put(str, Integer.valueOf(paramInt));
        }
      }
    }
  }
  
  public void setLogWhite(@NonNull List<String> paramList, int paramInt)
  {
    if (this.logMonitor != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!TextUtils.isEmpty(str)) {
          this.logMonitor.getLogWhiteMap().put(str, Integer.valueOf(paramInt));
        }
      }
    }
  }
  
  public void setupConfig(BatteryConfig paramBatteryConfig)
  {
    this.globalConfig = paramBatteryConfig;
  }
  
  public void start()
  {
    if (this.subHandler != null) {
      this.subHandler.sendEmptyMessage(0);
    }
  }
  
  public void stop()
  {
    if ((this.status != 0) && (this.subHandler != null)) {
      this.subHandler.sendEmptyMessage(3);
    }
  }
  
  public static abstract interface IBatteryStatsCallback
  {
    public abstract void onPrintLog(String paramString);
    
    public abstract void onUsageAlarm(String paramString1, String paramString2, String paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.battery.BatteryMonitor
 * JD-Core Version:    0.7.0.1
 */