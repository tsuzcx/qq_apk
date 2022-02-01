package com.tencent.qapmsdk.battery.monitor;

import android.app.Application;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qapmsdk.base.listener.IBatteryReportListener;
import com.tencent.qapmsdk.base.listener.ListenerManager;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.battery.BatteryLog;
import com.tencent.qapmsdk.battery.BatteryUsageItem;
import com.tencent.qapmsdk.battery.HighFrequencyDetector;
import com.tencent.qapmsdk.battery.config.GPSMeta;
import com.tencent.qapmsdk.common.logger.Logger;
import java.lang.reflect.Member;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GPSMonitor
  extends BatteryUsageItem
  implements HookMethodCallback
{
  private static final String BG_5_SDK_COUNT = "bg5SdkCount";
  private static final String BG_5_SDK_DETAIL = "bg5SdkDetail";
  private static final String BG_5_SYS_COUNT = "bg5SysCount";
  private static final String BG_5_SYS_DETAIL = "bg5SysDetail";
  private static final String FG_30_SDK_COUNT = "fg30SdkCount";
  private static final String FG_30_SDK_DETAIL = "fg30SdkDetail";
  private static final String FG_30_SYS_COUNT = "fg30SysCount";
  private static final String FG_30_SYS_DETAIL = "fg30SysDetail";
  private static final String KEY_STACK = "key_stack";
  private static final String KEY_TYPE = "key_type";
  private static final String REQUEST_METHOD_0 = "requestLocationUpdates";
  private static final String REQUEST_METHOD_1 = "requestSingleUpdate";
  public static final String REQUEST_SOSO = "requestSoso";
  private static final String TAG = "QAPM.GPS";
  private Map<String, HashSet<Long>> bg5MinSdkMap = new HashMap();
  private Map<String, HashSet<Long>> bg5MinSysMap = new HashMap();
  private HighFrequencyDetector detector1;
  private HighFrequencyDetector detector2;
  private Map<String, HashSet<Long>> fg30MinSdkMap = new HashMap();
  private Map<String, HashSet<Long>> fg30MinSysMap = new HashMap();
  private LocationManager locationMgr = (LocationManager)BaseInfo.app.getSystemService("location");
  private long longTime = 18000000L;
  private int maxCallTimeInLongTime = 10;
  private int maxCallTimeInShortTime = 3;
  private long shortTime = 900000L;
  private String sosoClassName = null;
  
  public GPSMonitor(GPSMeta paramGPSMeta)
  {
    this.maxCallTimeInShortTime = paramGPSMeta.maxCallTimeInShortTime;
    this.shortTime = paramGPSMeta.shortTime;
    this.maxCallTimeInLongTime = paramGPSMeta.maxCallTimeInLongTime;
    this.longTime = paramGPSMeta.longTime;
    this.detector1 = new HighFrequencyDetector(this.maxCallTimeInShortTime, this.shortTime);
    this.detector2 = new HighFrequencyDetector(this.maxCallTimeInLongTime, this.longTime);
  }
  
  private int getGPSState()
  {
    try
    {
      boolean bool = this.locationMgr.isProviderEnabled("gps");
      if (bool) {
        return 1;
      }
      return 0;
    }
    catch (Throwable localThrowable)
    {
      Logger.INSTANCE.exception("QAPM.GPS", localThrowable);
    }
    return -1;
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam) {}
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam)
  {
    onGPSScan(paramMethodHookParam.method.getName(), paramMethodHookParam.args);
  }
  
  public void onAppBackground()
  {
    super.onAppBackground();
    synchronized (this.fg30MinSdkMap)
    {
      this.bg5MinSdkMap.clear();
      this.bg5MinSysMap.clear();
      return;
    }
  }
  
  public void onGPSScan(String paramString, Object[] paramArrayOfObject)
  {
    if (!this.isRunning) {
      return;
    }
    String str2 = getAppStack().toString();
    if (Logger.debug) {
      printLog("onGPSScan: " + str2);
    }
    Object localObject = ListenerManager.batteryReportListener;
    if ((localObject != null) && (this.sosoClassName == null)) {
      this.sosoClassName = ((IBatteryReportListener)localObject).getSosoClassName();
    }
    int i;
    label94:
    label122:
    String str3;
    if (("requestLocationUpdates".equals(paramString)) || ("requestSingleUpdate".equals(paramString)))
    {
      i = 1;
      if (i != 0)
      {
        if ((TextUtils.isEmpty(this.sosoClassName)) || (!str2.contains(this.sosoClassName))) {
          break label566;
        }
        i = 1;
        if (i != 0) {
          break label569;
        }
      }
      str3 = "location|" + getGPSState() + "|";
      if (!"requestLocationUpdates".equals(paramString)) {
        break label1097;
      }
      if (paramArrayOfObject.length != 5) {
        break label740;
      }
      if (!(paramArrayOfObject[2] instanceof Criteria)) {
        break label571;
      }
      writeCommonLog(new String[] { str3, "0", "|", "0", "|", "{", paramArrayOfObject[0].toString(), "#", paramArrayOfObject[1].toString(), "#", "[", this.locationMgr.getBestProvider((Criteria)paramArrayOfObject[2], true), ",", String.valueOf(((Criteria)paramArrayOfObject[2]).getAccuracy()), ",", String.valueOf(((Criteria)paramArrayOfObject[2]).getPowerRequirement()), "]", "}", "|", str2 });
      label347:
      paramString = new Bundle();
      paramString.putInt("key_action", 2);
      paramString.putString("key_stack", str2);
      onOtherProcReport(paramString);
    }
    label566:
    label569:
    label571:
    label740:
    do
    {
      paramString = this.detector1.onAction(str2);
      if ((paramString != null) && (paramString.size() > 0))
      {
        onUsageAlarm(6, 0, 0, "GPS request update is too frequently(" + this.maxCallTimeInShortTime + " in " + this.shortTime / 60L / 1000L + " seconds", HighFrequencyDetector.getDescription(paramString));
        this.detector1.trimCache();
      }
      paramString = this.detector2.onAction(str2);
      if ((paramString == null) || (paramString.size() <= 0)) {
        break;
      }
      onUsageAlarm(6, 0, 0, "Wifi scan is too frequently(" + this.maxCallTimeInLongTime + " in " + this.longTime / 60L / 1000L + " seconds", HighFrequencyDetector.getDescription(paramString));
      this.detector2.trimCache();
      return;
      i = 0;
      break label94;
      i = 0;
      break label122;
      break;
      if ((paramArrayOfObject[0] instanceof String))
      {
        writeCommonLog(new String[] { str3, "0", "|", "1", "|", "{", paramArrayOfObject[0].toString(), "#", paramArrayOfObject[1].toString(), "#", paramArrayOfObject[2].toString(), "}", "|", str2 });
        break label347;
      }
      writeCommonLog(new String[] { str3, "0", "|", "-1", "|", "{}", "|", str2 });
      break label347;
      if (paramArrayOfObject.length != 6) {
        break label347;
      }
      if ((paramArrayOfObject[2] instanceof Criteria))
      {
        writeCommonLog(new String[] { str3, "0", "|", "2", "|", "{", paramArrayOfObject[0].toString(), "#", paramArrayOfObject[1].toString(), "#", "[", this.locationMgr.getBestProvider((Criteria)paramArrayOfObject[2], true), ",", String.valueOf(((Criteria)paramArrayOfObject[2]).getAccuracy()), ",", String.valueOf(((Criteria)paramArrayOfObject[2]).getPowerRequirement()), "]", "}", "|", str2 });
        break label347;
      }
      if ((paramArrayOfObject[0] instanceof String))
      {
        writeCommonLog(new String[] { str3, "0", "|", "3", "|", "{", paramArrayOfObject[0].toString(), "#", paramArrayOfObject[1].toString(), "#", paramArrayOfObject[2].toString(), "}", "|", str2 });
        break label347;
      }
      writeCommonLog(new String[] { str3, "0", "|", "-1", "|", "{}", "|", str2 });
      break label347;
      if ("requestSingleUpdate".equals(paramString))
      {
        if ((paramArrayOfObject[0] instanceof String)) {
          writeCommonLog(new String[] { str3, "1", "|", "0", "|", "{", paramArrayOfObject[0].toString(), "}", "|", str2 });
        }
        for (;;)
        {
          paramString = new Bundle();
          paramString.putInt("key_action", 2);
          paramString.putString("key_stack", str2);
          onOtherProcReport(paramString);
          break;
          if ((paramArrayOfObject[0] instanceof Criteria)) {
            writeCommonLog(new String[] { str3, "1", "|", "1", "|", "{", "[", this.locationMgr.getBestProvider((Criteria)paramArrayOfObject[0], true), ",", String.valueOf(((Criteria)paramArrayOfObject[0]).getAccuracy()), ",", String.valueOf(((Criteria)paramArrayOfObject[0]).getPowerRequirement()), "]", "}", "|", str2 });
          } else {
            writeCommonLog(new String[] { str3, "1", "|", "-1", "|", "{}", "|", str2 });
          }
        }
      }
    } while (!"requestSoso".equals(paramString));
    label1097:
    String str4;
    label1442:
    String str5;
    if (paramArrayOfObject[2] == null)
    {
      paramString = "none";
      str4 = paramArrayOfObject[0].toString();
      str5 = paramArrayOfObject[1].toString();
      if (paramArrayOfObject[3] != null) {
        break label1649;
      }
      localObject = "-1";
      label1469:
      if (paramArrayOfObject[4] != null) {
        break label1660;
      }
    }
    label1649:
    label1660:
    for (String str1 = "-1";; str1 = paramArrayOfObject[4].toString())
    {
      writeCommonLog(new String[] { str3, "2", "|", "0", "|", "{", str4, "#", str5, "#", paramString, "#", localObject, "#", str1, "#", paramArrayOfObject[5].toString(), "}", "|", str2 });
      paramArrayOfObject = new Bundle();
      paramArrayOfObject.putInt("key_action", 1);
      paramArrayOfObject.putString("key_type", paramString);
      onOtherProcReport(paramArrayOfObject);
      break;
      paramString = paramArrayOfObject[2].toString();
      break label1442;
      localObject = paramArrayOfObject[3].toString();
      break label1469;
    }
  }
  
  public void onOtherProcReport(Bundle paramBundle)
  {
    int i = paramBundle.getInt("key_action");
    if ((i == 1) || (i == 2))
    {
      Logger.INSTANCE.d(new String[] { "QAPM.GPS", "GPS.onOtherProcReport:action=", i + ", type=", paramBundle.getString("key_type"), ", stack=", paramBundle.getString("key_stack") });
      if ((isInQQProcess()) && (this.isRunning))
      {
        Map localMap2 = this.fg30MinSdkMap;
        if (i == 1) {}
        try
        {
          paramBundle = paramBundle.getString("key_type");
          label139:
          HashSet localHashSet2;
          HashSet localHashSet1;
          if (this.isBeforeRun30Min)
          {
            if (i == 1)
            {
              localMap1 = this.fg30MinSdkMap;
              localHashSet2 = (HashSet)localMap1.get(paramBundle);
              localHashSet1 = localHashSet2;
              if (localHashSet2 == null)
              {
                localHashSet1 = new HashSet();
                localMap1.put(paramBundle, localHashSet1);
              }
              localHashSet1.add(Long.valueOf(System.currentTimeMillis()));
            }
          }
          else if ((this.isAppBackground) && (this.isInFirstBg5min)) {
            if (i != 1) {
              break label289;
            }
          }
          label289:
          for (Map localMap1 = this.bg5MinSdkMap;; localMap1 = this.bg5MinSysMap)
          {
            localHashSet2 = (HashSet)localMap1.get(paramBundle);
            localHashSet1 = localHashSet2;
            if (localHashSet2 == null)
            {
              localHashSet1 = new HashSet();
              localMap1.put(paramBundle, localHashSet1);
            }
            localHashSet1.add(Long.valueOf(System.currentTimeMillis()));
            return;
            paramBundle = paramBundle.getString("key_stack");
            break;
            localMap1 = this.fg30MinSysMap;
            break label139;
          }
          return;
        }
        finally {}
      }
    }
  }
  
  public void onProcessBG5Min()
  {
    super.onProcessBG5Min();
    if ((this.isRunning) && (isInQQProcess())) {}
    label500:
    for (;;)
    {
      String str;
      Object localObject2;
      Object localObject3;
      synchronized (this.fg30MinSdkMap)
      {
        Iterator localIterator1 = this.bg5MinSdkMap.values().iterator();
        int i = 0;
        if (localIterator1.hasNext())
        {
          i = ((HashSet)localIterator1.next()).size() + i;
          continue;
        }
        localIterator1 = this.bg5MinSysMap.values().iterator();
        int j = 0;
        if (localIterator1.hasNext())
        {
          j = ((HashSet)localIterator1.next()).size() + j;
          continue;
        }
        writeReportLog(new String[] { "bg5SdkCount", "|", String.valueOf(i) });
        if (isHookReady()) {
          writeReportLog(new String[] { "bg5SysCount", "|", String.valueOf(j) });
        }
        localIterator1 = this.bg5MinSdkMap.keySet().iterator();
        if (localIterator1.hasNext())
        {
          str = (String)localIterator1.next();
          localObject2 = (HashSet)this.bg5MinSdkMap.get(str);
          localObject3 = BatteryLog.getReuseStringBuilder();
          Iterator localIterator3 = ((HashSet)localObject2).iterator();
          i = 0;
          if (localIterator3.hasNext())
          {
            ((StringBuilder)localObject3).append((Long)localIterator3.next());
            i += 1;
            if (i >= ((HashSet)localObject2).size()) {
              break label500;
            }
            ((StringBuilder)localObject3).append("#");
            break label500;
          }
          writeReportLog(new String[] { "bg5SdkDetail", "|", str, "|", ((StringBuilder)localObject3).toString() });
        }
      }
      Iterator localIterator2 = this.bg5MinSysMap.keySet().iterator();
      while (localIterator2.hasNext())
      {
        str = (String)localIterator2.next();
        localObject3 = (HashSet)this.bg5MinSysMap.get(str);
        localObject2 = BatteryLog.getReuseStringBuilder();
        localObject3 = ((HashSet)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((StringBuilder)localObject2).append((Long)((Iterator)localObject3).next()).append("|");
        }
        writeReportLog(new String[] { "bg5SysDetail", "|", str, "|", ((StringBuilder)localObject2).toString() });
      }
      this.bg5MinSdkMap.clear();
      this.bg5MinSysMap.clear();
      return;
    }
  }
  
  public void onProcessRun30Min()
  {
    super.onProcessRun30Min();
    if ((this.isRunning) && (isInQQProcess())) {}
    label500:
    for (;;)
    {
      String str;
      Object localObject2;
      Object localObject3;
      synchronized (this.fg30MinSdkMap)
      {
        Iterator localIterator1 = this.fg30MinSdkMap.values().iterator();
        int i = 0;
        if (localIterator1.hasNext())
        {
          i = ((HashSet)localIterator1.next()).size() + i;
          continue;
        }
        localIterator1 = this.fg30MinSysMap.values().iterator();
        int j = 0;
        if (localIterator1.hasNext())
        {
          j = ((HashSet)localIterator1.next()).size() + j;
          continue;
        }
        writeReportLog(new String[] { "fg30SdkCount", "|", String.valueOf(i) });
        if (isHookReady()) {
          writeReportLog(new String[] { "fg30SysCount", "|", String.valueOf(j) });
        }
        localIterator1 = this.fg30MinSdkMap.keySet().iterator();
        if (localIterator1.hasNext())
        {
          str = (String)localIterator1.next();
          localObject2 = (HashSet)this.fg30MinSdkMap.get(str);
          localObject3 = BatteryLog.getReuseStringBuilder();
          Iterator localIterator3 = ((HashSet)localObject2).iterator();
          i = 0;
          if (localIterator3.hasNext())
          {
            ((StringBuilder)localObject3).append((Long)localIterator3.next());
            i += 1;
            if (i >= ((HashSet)localObject2).size()) {
              break label500;
            }
            ((StringBuilder)localObject3).append("#");
            break label500;
          }
          writeReportLog(new String[] { "fg30SdkDetail", "|", str, "|", ((StringBuilder)localObject3).toString() });
        }
      }
      Iterator localIterator2 = this.fg30MinSysMap.keySet().iterator();
      while (localIterator2.hasNext())
      {
        str = (String)localIterator2.next();
        localObject3 = (HashSet)this.fg30MinSysMap.get(str);
        localObject2 = BatteryLog.getReuseStringBuilder();
        localObject3 = ((HashSet)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((StringBuilder)localObject2).append((Long)((Iterator)localObject3).next()).append("|");
        }
        writeReportLog(new String[] { "fg30SysDetail", "|", str, "|", ((StringBuilder)localObject2).toString() });
      }
      this.fg30MinSdkMap.clear();
      this.fg30MinSysMap.clear();
      return;
    }
  }
  
  public void onProcessStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.battery.monitor.GPSMonitor
 * JD-Core Version:    0.7.0.1
 */