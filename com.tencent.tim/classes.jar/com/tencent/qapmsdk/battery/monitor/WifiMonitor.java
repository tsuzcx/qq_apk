package com.tencent.qapmsdk.battery.monitor;

import android.net.wifi.WifiManager.WifiLock;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;
import com.tencent.qapmsdk.battery.BatteryLog;
import com.tencent.qapmsdk.battery.BatteryUsageItem;
import com.tencent.qapmsdk.battery.HighFrequencyDetector;
import com.tencent.qapmsdk.battery.config.WifiMeta;
import com.tencent.qapmsdk.common.logger.Logger;
import java.lang.ref.WeakReference;
import java.lang.reflect.Member;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WifiMonitor
  extends BatteryUsageItem
  implements HookMethodCallback
{
  public static final String BG_5_WF_LOCK_COUNT = "bg5WFLCount";
  public static final String BG_5_WF_LOCK_DETAIL = "bg5WFLDetail";
  public static final String BG_5_WF_SCAN_COUNT = "bg5WFSCount";
  public static final String BG_5_WF_SCAN_DETAIL = "bg5WFSDetail";
  public static final String FG_30_WF_LOCK_COUNT = "fg30WFLCount";
  public static final String FG_30_WF_LOCK_DETAIL = "fg30WFLDetail";
  public static final String FG_30_WF_SCAN_COUNT = "fg30WFSCount";
  public static final String FG_30_WF_SCAN_DETAIL = "fg30WFSDetail";
  private static final String KEY_DURATION = "key_duration";
  private static final String KEY_STACK = "key_stack";
  private static final String KEY_TAG = "key_tag";
  public static final String TAG = "Wifi";
  public static final String WF_LOCK_NOT_RELEASE = "wflNotRelease";
  private HashMap<String, ReportEntity> bg5MinLockMap = new HashMap();
  private HashMap<String, HashSet<Long>> bg5MinScanMap = new HashMap();
  private HighFrequencyDetector detector1;
  private HighFrequencyDetector detector2;
  private HashMap<String, ReportEntity> fg30MinLockMap = new HashMap();
  private HashMap<String, HashSet<Long>> fg30MinScanMap = new HashMap();
  private long longTime = 18000000L;
  private HashMap<WeakReference<WifiManager.WifiLock>, WifiLockEntity> map = new HashMap();
  private int maxCallTimeInLongTime = 10;
  private int maxCallTimeInShortTime = 3;
  private long shortTime = 900000L;
  
  public WifiMonitor(WifiMeta paramWifiMeta)
  {
    this.maxCallTimeInShortTime = paramWifiMeta.maxCallTimeInShortTime;
    this.shortTime = paramWifiMeta.shortTime;
    this.maxCallTimeInLongTime = paramWifiMeta.maxCallTimeInLongTime;
    this.longTime = paramWifiMeta.longTime;
    this.detector1 = new HighFrequencyDetector(this.maxCallTimeInShortTime, this.shortTime);
    this.detector2 = new HighFrequencyDetector(this.maxCallTimeInLongTime, this.longTime);
  }
  
  private final void doLockReport(WifiLockEntity paramWifiLockEntity, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_action", paramInt);
    localBundle.putString("key_stack", paramWifiLockEntity.createStack);
    localBundle.putString("key_tag", paramWifiLockEntity.tag);
    if (paramInt == 9) {
      localBundle.putLong("key_duration", SystemClock.uptimeMillis() - paramWifiLockEntity.firstAcquireTimeStamp);
    }
    onOtherProcReport(localBundle);
  }
  
  private final void writeLockReport(boolean paramBoolean)
  {
    HashMap localHashMap2 = this.fg30MinLockMap;
    long l = 0L;
    if (paramBoolean) {}
    for (;;)
    {
      int j;
      try
      {
        HashMap localHashMap1 = this.fg30MinLockMap;
        localObject2 = localHashMap1.values().iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ReportEntity)((Iterator)localObject2).next();
          j = ((ReportEntity)localObject3).useList.size();
          localObject3 = ((ReportEntity)localObject3).useList.iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label430;
          }
          l = ((Long)((Pair)((Iterator)localObject3).next()).second).longValue() + l;
          continue;
          localHashMap1 = this.bg5MinLockMap;
          continue;
        }
        if (!paramBoolean) {
          break label440;
        }
        localObject2 = "fg30WFLCount";
        writeReportLog(new String[] { localObject2, "|", String.valueOf(i), "|", String.valueOf(l), "|0" });
        Iterator localIterator = localHashMap1.keySet().iterator();
        if (!localIterator.hasNext()) {
          break label421;
        }
        String str = (String)localIterator.next();
        localObject3 = (ReportEntity)localHashMap1.get(str);
        StringBuilder localStringBuilder = BatteryLog.getReuseStringBuilder();
        localObject2 = ((ReportEntity)localObject3).useList.iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          Pair localPair = (Pair)((Iterator)localObject2).next();
          localStringBuilder.append(String.valueOf(localPair.first)).append(",").append(String.valueOf(localPair.second));
          i += 1;
          if (i >= ((ReportEntity)localObject3).useList.size()) {
            break label437;
          }
          localStringBuilder.append("#");
          break label437;
        }
        if (paramBoolean)
        {
          localObject2 = "fg30WFLDetail";
          if (((ReportEntity)localObject3).tag != null) {
            break label403;
          }
          localObject3 = "";
          writeReportLog(new String[] { localObject2, "|", localObject3, "|0|", str, "|", localStringBuilder.toString() });
          continue;
        }
        localObject2 = "bg5WFSDetail";
      }
      finally {}
      continue;
      label403:
      Object localObject3 = ((ReportEntity)localObject3).tag.replace("|", "_");
      continue;
      label421:
      localObject1.clear();
      return;
      label430:
      int i = j + i;
      continue;
      label437:
      continue;
      label440:
      Object localObject2 = "bg5WFLCount";
    }
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if (!this.isRunning) {}
    String str;
    label273:
    do
    {
      return;
      for (;;)
      {
        WifiLockEntity localWifiLockEntity;
        try
        {
          str = getAppStack().toString();
          if (!"release".equals(paramMethodHookParam.method.getName())) {
            break label273;
          }
          WeakReference localWeakReference;
          synchronized (this.map)
          {
            localObject2 = this.map.keySet().iterator();
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localWeakReference = (WeakReference)((Iterator)localObject2).next();
            localWifiLockEntity = (WifiLockEntity)this.map.get(localWeakReference);
            if (localWeakReference.get() == paramMethodHookParam.thisObject)
            {
              writeCommonLog(new String[] { "wf_rl|", localWifiLockEntity.uuid, "|", str });
              if (!((WifiManager.WifiLock)paramMethodHookParam.thisObject).isHeld())
              {
                writeCommonLog(new String[] { "wf_time|", localWifiLockEntity.uuid, "|", String.valueOf(SystemClock.uptimeMillis() - localWifiLockEntity.firstAcquireTimeStamp) });
                ((Iterator)localObject2).remove();
              }
              doLockReport(localWifiLockEntity, 9);
            }
          }
          if (localWeakReference.get() != null) {
            continue;
          }
        }
        catch (Throwable paramMethodHookParam)
        {
          Logger.INSTANCE.exception("Wifi", paramMethodHookParam);
          return;
        }
        writeCommonLog(new String[] { "wf_alarm|", localWifiLockEntity.uuid });
        ((Iterator)localObject2).remove();
        doLockReport(localWifiLockEntity, 10);
      }
      return;
    } while (!"createWifiLock".equals(paramMethodHookParam.method.getName()));
    ??? = new WeakReference((WifiManager.WifiLock)paramMethodHookParam.result);
    Object localObject2 = new WifiLockEntity(null);
    ((WifiLockEntity)localObject2).uuid = String.valueOf(localObject2.hashCode());
    ((WifiLockEntity)localObject2).createStack = str;
    if ((paramMethodHookParam.args != null) && (paramMethodHookParam.args.length == 2)) {}
    for (((WifiLockEntity)localObject2).tag = ((String)paramMethodHookParam.args[1]);; ((WifiLockEntity)localObject2).tag = ((String)paramMethodHookParam.args[0])) {
      do
      {
        this.map.put(???, localObject2);
        if (paramMethodHookParam.args.length != 1) {
          break;
        }
        writeCommonLog(new String[] { "wf_new|", ((WifiLockEntity)localObject2).uuid, "|0|", String.valueOf(paramMethodHookParam.args[0]) });
        return;
      } while ((paramMethodHookParam.args == null) || (paramMethodHookParam.args.length != 1));
    }
    writeCommonLog(new String[] { "wf_new|", ((WifiLockEntity)localObject2).uuid, "|", String.valueOf(paramMethodHookParam.args[0]), "|", String.valueOf(paramMethodHookParam.args[1]) });
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if (!this.isRunning) {}
    String str;
    do
    {
      return;
      try
      {
        str = getAppStack().toString();
        if (Logger.debug) {
          printLog(paramMethodHookParam.method.getName() + str);
        }
        if ("startScan".equals(paramMethodHookParam.method.getName()))
        {
          writeCommonLog(new String[] { "wfScan", "|", str });
          paramMethodHookParam = this.detector1.onAction(str);
          if ((paramMethodHookParam != null) && (paramMethodHookParam.size() > 0))
          {
            onUsageAlarm(5, 0, 0, "Wifi scan is too frequently(" + this.maxCallTimeInShortTime + " in " + this.shortTime / 60L / 1000L + " seconds", HighFrequencyDetector.getDescription(paramMethodHookParam));
            this.detector1.trimCache();
          }
          paramMethodHookParam = this.detector2.onAction(str);
          if ((paramMethodHookParam != null) && (paramMethodHookParam.size() > 0))
          {
            onUsageAlarm(5, 0, 0, "Wifi scan is too frequently(" + this.maxCallTimeInLongTime + " in " + this.longTime / 60L / 1000L + " seconds", HighFrequencyDetector.getDescription(paramMethodHookParam));
            this.detector2.trimCache();
          }
          paramMethodHookParam = new Bundle();
          paramMethodHookParam.putInt("key_action", 8);
          paramMethodHookParam.putString("key_stack", str);
          onOtherProcReport(paramMethodHookParam);
          return;
        }
      }
      catch (Throwable paramMethodHookParam)
      {
        Logger.INSTANCE.exception("Wifi", paramMethodHookParam);
        return;
      }
    } while (!"acquire".equals(paramMethodHookParam.method.getName()));
    for (;;)
    {
      Iterator localIterator;
      WeakReference localWeakReference;
      WifiLockEntity localWifiLockEntity;
      synchronized (this.map)
      {
        localIterator = this.map.keySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localWeakReference = (WeakReference)localIterator.next();
        localWifiLockEntity = (WifiLockEntity)this.map.get(localWeakReference);
        if (localWeakReference.get() == paramMethodHookParam.thisObject)
        {
          writeCommonLog(new String[] { "wf_ac|", localWifiLockEntity.uuid, "|", str });
          if (((WifiManager.WifiLock)paramMethodHookParam.thisObject).isHeld()) {
            continue;
          }
          localWifiLockEntity.firstAcquireTimeStamp = SystemClock.uptimeMillis();
        }
      }
      if (localWeakReference.get() == null)
      {
        writeCommonLog(new String[] { "wf_alarm|", localWifiLockEntity.uuid });
        localIterator.remove();
      }
    }
  }
  
  public void onAppBackground()
  {
    super.onAppBackground();
    synchronized (this.fg30MinScanMap)
    {
      this.bg5MinScanMap.clear();
    }
    synchronized (this.fg30MinLockMap)
    {
      this.bg5MinLockMap.clear();
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public void onOtherProcReport(Bundle paramBundle)
  {
    if (!this.isRunning) {}
    int i;
    String str;
    do
    {
      return;
      i = paramBundle.getInt("key_action");
      str = paramBundle.getString("key_stack");
      ??? = paramBundle.getString("key_tag");
      long l = paramBundle.getLong("key_duration");
      Object localObject1;
      if (i == 8)
      {
        Logger.INSTANCE.d(new String[] { "Wifi", "WiFi.onOtherProcReport: scan:", str });
        synchronized (this.fg30MinScanMap)
        {
          if (this.isBeforeRun30Min)
          {
            localObject1 = (HashSet)this.fg30MinScanMap.get(str);
            paramBundle = (Bundle)localObject1;
            if (localObject1 == null)
            {
              paramBundle = new HashSet();
              this.fg30MinScanMap.put(str, paramBundle);
            }
            paramBundle.add(Long.valueOf(System.currentTimeMillis()));
          }
          if ((this.isAppBackground) && (this.isInFirstBg5min))
          {
            localObject1 = (HashSet)this.bg5MinScanMap.get(str);
            paramBundle = (Bundle)localObject1;
            if (localObject1 == null)
            {
              paramBundle = new HashSet();
              this.bg5MinScanMap.put(str, paramBundle);
            }
            paramBundle.add(Long.valueOf(System.currentTimeMillis()));
          }
          return;
        }
      }
      if (i == 9) {
        synchronized (this.fg30MinLockMap)
        {
          if (this.isBeforeRun30Min)
          {
            localObject1 = (ReportEntity)this.fg30MinLockMap.get(str);
            paramBundle = (Bundle)localObject1;
            if (localObject1 == null)
            {
              paramBundle = new ReportEntity(null);
              paramBundle.tag = ((String)???);
              paramBundle.createStack = str;
              this.fg30MinLockMap.put(str, paramBundle);
            }
            paramBundle.useList.add(new Pair(Long.valueOf(System.currentTimeMillis()), Long.valueOf(l)));
          }
          if ((this.isAppBackground) && (this.isInFirstBg5min))
          {
            localObject1 = (ReportEntity)this.bg5MinLockMap.get(str);
            paramBundle = (Bundle)localObject1;
            if (localObject1 == null)
            {
              paramBundle = new ReportEntity(null);
              paramBundle.tag = ((String)???);
              paramBundle.createStack = str;
              this.bg5MinLockMap.put(str, paramBundle);
            }
            paramBundle.useList.add(new Pair(Long.valueOf(System.currentTimeMillis()), Long.valueOf(l)));
          }
          return;
        }
      }
    } while (i != 10);
    writeReportLog(new String[] { "wflNotRelease", "|", str, "|", ???, "|0|0" });
  }
  
  public void onProcessBG5Min()
  {
    super.onProcessBG5Min();
    if ((isInQQProcess()) && (this.isRunning) && (isHookReady())) {}
    label269:
    for (;;)
    {
      synchronized (this.fg30MinScanMap)
      {
        Iterator localIterator1 = this.bg5MinScanMap.values().iterator();
        int i = 0;
        if (localIterator1.hasNext())
        {
          i = ((HashSet)localIterator1.next()).size() + i;
          continue;
        }
        writeReportLog(new String[] { "bg5WFSCount", "|", String.valueOf(i) });
        localIterator1 = this.bg5MinScanMap.keySet().iterator();
        if (localIterator1.hasNext())
        {
          String str = (String)localIterator1.next();
          StringBuilder localStringBuilder = BatteryLog.getReuseStringBuilder();
          HashSet localHashSet = (HashSet)this.bg5MinScanMap.get(str);
          Iterator localIterator2 = localHashSet.iterator();
          i = 0;
          if (localIterator2.hasNext())
          {
            localStringBuilder.append((Long)localIterator2.next());
            i += 1;
            if (i >= localHashSet.size()) {
              break label269;
            }
            localStringBuilder.append("#");
            break label269;
          }
          writeReportLog(new String[] { "bg5WFSDetail", "|", str, "|", localStringBuilder.toString() });
        }
      }
      this.bg5MinScanMap.clear();
      writeLockReport(false);
      return;
    }
  }
  
  public void onProcessRun30Min()
  {
    super.onProcessRun30Min();
    if ((isInQQProcess()) && (this.isRunning) && (isHookReady())) {}
    label269:
    for (;;)
    {
      synchronized (this.fg30MinScanMap)
      {
        Iterator localIterator1 = this.fg30MinScanMap.values().iterator();
        int i = 0;
        if (localIterator1.hasNext())
        {
          i = ((HashSet)localIterator1.next()).size() + i;
          continue;
        }
        writeReportLog(new String[] { "fg30WFSCount", "|", String.valueOf(i) });
        localIterator1 = this.fg30MinScanMap.keySet().iterator();
        if (localIterator1.hasNext())
        {
          String str = (String)localIterator1.next();
          StringBuilder localStringBuilder = BatteryLog.getReuseStringBuilder();
          HashSet localHashSet = (HashSet)this.fg30MinScanMap.get(str);
          Iterator localIterator2 = localHashSet.iterator();
          i = 0;
          if (localIterator2.hasNext())
          {
            localStringBuilder.append((Long)localIterator2.next());
            i += 1;
            if (i >= localHashSet.size()) {
              break label269;
            }
            localStringBuilder.append("#");
            break label269;
          }
          writeReportLog(new String[] { "fg30WFSDetail", "|", str, "|", localStringBuilder.toString() });
        }
      }
      this.fg30MinScanMap.clear();
      writeLockReport(true);
      return;
    }
  }
  
  public void onProcessStart() {}
  
  class ReportEntity
  {
    public String createStack;
    public String tag;
    public HashSet<Pair<Long, Long>> useList = new HashSet();
    
    private ReportEntity() {}
  }
  
  class WifiLockEntity
  {
    public String createStack;
    public long firstAcquireTimeStamp = 0L;
    public String tag;
    public String uuid;
    
    private WifiLockEntity() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.battery.monitor.WifiMonitor
 * JD-Core Version:    0.7.0.1
 */