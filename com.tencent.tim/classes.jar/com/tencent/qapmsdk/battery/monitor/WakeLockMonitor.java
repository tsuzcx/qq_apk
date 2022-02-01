package com.tencent.qapmsdk.battery.monitor;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.util.Pair;
import com.tencent.qapmsdk.battery.BatteryLog;
import com.tencent.qapmsdk.battery.BatteryUsageItem;
import com.tencent.qapmsdk.battery.HighFrequencyDetector;
import com.tencent.qapmsdk.battery.HighFrequencyDetector.Action;
import com.tencent.qapmsdk.battery.config.WakeLockMeta;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Member;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WakeLockMonitor
  extends BatteryUsageItem
  implements Handler.Callback, HookMethodCallback
{
  private static final String KEY_FLAG = "key_flag";
  private static final String KEY_STACK = "key_stack";
  private static final String KEY_TAG = "key_tag";
  private static final String KEY_TIME = "key_time";
  private static final String METHOD_ACQUIRE = "acquire";
  private static final String METHOD_NEW_WAKELOCK = "newWakeLock";
  private static final String METHOD_RELEASE = "release";
  private static final int MSG_TIMEOUT = 1;
  public static final String RPT_BG_5_WL_COUNT = "bg5WlCount";
  public static final String RPT_BG_5_WL_USE = "bg5WlUse";
  public static final String RPT_FG_30_WL_COUNT = "fg30WlCount";
  public static final String RPT_FG_30_WL_USE = "fg30WlUse";
  public static final String RPT_WL_NOT_RELEASE = "wlNotRelease";
  public static final String RPT_WL_TIMEOUT = "wlTimeout";
  public static final String TAG = "QAPM.WakeLockMonitor";
  private static final String WAKELOCK_ALARM = "wl_alm";
  private static final String WAKELOCK_TIME = "wl_tm";
  private static final String WAKELOCK_USAGE = "wl_usg";
  private HashMap<String, ReportEntity> bg5MinMap = new HashMap();
  private WakeLockMeta config;
  private HashMap<String, ReportEntity> fg30MinMap = new HashMap();
  private long longTime = 7200000L;
  private HashMap<WeakReference<PowerManager.WakeLock>, WakeLockEntity> map = new HashMap();
  private long maxAcquireTime = 30000L;
  private int maxCallTimeInLongTime = 10;
  private int maxCallTimeInShortTime = 3;
  private long shortTime = 600000L;
  private Handler subHandler = new Handler(ThreadManager.getBatteryThreadLooper(), this);
  
  public WakeLockMonitor(WakeLockMeta paramWakeLockMeta)
  {
    this.maxAcquireTime = paramWakeLockMeta.maxAcquireTime;
    this.maxAcquireTime *= 10L;
    this.maxCallTimeInShortTime = paramWakeLockMeta.maxCallTimeInShortTime;
    this.shortTime = paramWakeLockMeta.shortTime;
    this.maxCallTimeInLongTime = paramWakeLockMeta.maxCallTimeInLongTime;
    this.longTime = paramWakeLockMeta.longTime;
  }
  
  private final void doReport(WakeLockEntity paramWakeLockEntity, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_action", paramInt);
    localBundle.putString("key_stack", paramWakeLockEntity.createStack);
    localBundle.putString("key_tag", paramWakeLockEntity.tag);
    localBundle.putInt("key_flag", paramWakeLockEntity.levelAndFlags);
    localBundle.putLong("key_time", paramWakeLockEntity.getHoldTime());
    onOtherProcReport(localBundle);
  }
  
  private final void writeReport(boolean paramBoolean)
  {
    HashMap localHashMap2 = this.fg30MinMap;
    long l2 = 0L;
    long l1 = 0L;
    if (paramBoolean) {}
    for (;;)
    {
      int i;
      int k;
      try
      {
        HashMap localHashMap1 = this.fg30MinMap;
        localObject2 = localHashMap1.values().iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ReportEntity)((Iterator)localObject2).next();
          k = ((ReportEntity)localObject3).useList.size();
          if ((((ReportEntity)localObject3).flag & 0x1) <= 0) {
            break label496;
          }
          j = 1;
          localObject3 = ((ReportEntity)localObject3).useList.iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label501;
          }
          localObject4 = (Pair)((Iterator)localObject3).next();
          l2 += ((Long)((Pair)localObject4).second).longValue();
          if (j == 0) {
            break label493;
          }
          l1 = ((Long)((Pair)localObject4).second).longValue() + l1;
          break label493;
          localHashMap1 = this.bg5MinMap;
          continue;
        }
        if (!paramBoolean) {
          break label512;
        }
        localObject2 = "fg30WlCount";
        writeReportLog(new String[] { localObject2, "|", String.valueOf(i), "|", String.valueOf(l2), "|", String.valueOf(l1) });
        Object localObject4 = localHashMap1.keySet().iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label484;
        }
        String str = (String)((Iterator)localObject4).next();
        localObject3 = (ReportEntity)localHashMap1.get(str);
        StringBuilder localStringBuilder = BatteryLog.getReuseStringBuilder();
        localObject2 = ((ReportEntity)localObject3).useList.iterator();
        i = 0;
        Object localObject5;
        if (((Iterator)localObject2).hasNext())
        {
          localObject5 = (Pair)((Iterator)localObject2).next();
          localStringBuilder.append(String.valueOf(((Pair)localObject5).first)).append(",").append(String.valueOf(((Pair)localObject5).second));
          i += 1;
          if (i >= ((ReportEntity)localObject3).useList.size()) {
            break label509;
          }
          localStringBuilder.append("#");
          break label509;
        }
        if (paramBoolean)
        {
          localObject2 = "fg30WlUse";
          localObject5 = ((ReportEntity)localObject3).tag.replace("|", "_");
          if ((((ReportEntity)localObject3).flag & 0x1) <= 0) {
            break label519;
          }
          localObject3 = "1";
          writeReportLog(new String[] { localObject2, "|", localObject5, "|", localObject3, "|", str, "|", localStringBuilder.toString() });
          continue;
        }
        localObject2 = "bg5WlUse";
      }
      finally {}
      continue;
      label484:
      localObject1.clear();
      return;
      label493:
      continue;
      label496:
      int j = 0;
      continue;
      label501:
      i += k;
      continue;
      label509:
      continue;
      label512:
      Object localObject2 = "bg5WlCount";
      continue;
      label519:
      Object localObject3 = "0";
    }
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if (!"acquire".equals(paramMethodHookParam.method.getName())) {
      onHook(paramMethodHookParam.method.getName(), paramMethodHookParam.thisObject, paramMethodHookParam.args, paramMethodHookParam.result);
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if ("acquire".equals(paramMethodHookParam.method.getName())) {
      onHook(paramMethodHookParam.method.getName(), paramMethodHookParam.thisObject, paramMethodHookParam.args, paramMethodHookParam.result);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      synchronized (this.map)
      {
        paramMessage = (WeakReference)paramMessage.obj;
        paramMessage = (WakeLockEntity)this.map.get(paramMessage);
        if (paramMessage != null)
        {
          doReport(paramMessage, 5);
          writeCommonLog(new String[] { "wl_alm", "|", paramMessage.uuid, "|0|0" });
          onUsageAlarm(4, 1, 0, "Acquire " + paramMessage.tag + " too long time", "CallStack: " + paramMessage.createStack);
          return false;
        }
        Logger.INSTANCE.i(new String[] { "QAPM.WakeLockMonitor", "wake lock is lost ?" });
      }
    }
    return false;
  }
  
  public void onAppBackground()
  {
    super.onAppBackground();
    synchronized (this.fg30MinMap)
    {
      this.bg5MinMap.clear();
      return;
    }
  }
  
  public void onHook(String paramString, Object paramObject1, Object[] paramArrayOfObject, Object paramObject2)
  {
    if (!this.isRunning)
    {
      this.subHandler.removeMessages(1);
      return;
    }
    Object localObject2;
    Object localObject3;
    label286:
    label319:
    long l;
    label514:
    label629:
    do
    {
      for (;;)
      {
        synchronized (this.map)
        {
          if ("newWakeLock".equals(paramString))
          {
            paramObject1 = new WeakReference((PowerManager.WakeLock)paramObject2);
            paramObject2 = new WakeLockEntity();
            paramObject2.levelAndFlags = ((Integer)paramArrayOfObject[0]).intValue();
            paramObject2.tag = ((String)paramArrayOfObject[1]);
            paramObject2.createStack = getAppStack().toString();
            paramObject2.uuid = String.valueOf(paramObject2.hashCode());
            this.map.put(paramObject1, paramObject2);
            writeCommonLog(new String[] { paramString, "|", paramObject2.uuid, "|", String.valueOf(paramObject2.levelAndFlags), "|", paramObject2.tag, "|", paramObject2.createStack });
            return;
          }
        }
        if (!"acquire".equals(paramString)) {
          break;
        }
        paramObject2 = getAppStack().toString();
        localIterator = this.map.keySet().iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (WeakReference)localIterator.next();
          localObject3 = (WakeLockEntity)this.map.get(localObject2);
          if (((WeakReference)localObject2).get() == paramObject1)
          {
            if (paramArrayOfObject == null) {
              break label1171;
            }
            Object localObject4;
            if (paramArrayOfObject.length == 0)
            {
              break label1171;
              localObject4 = ((WakeLockEntity)localObject3).getCallStackIndex(paramObject2);
              String str = ((WakeLockEntity)localObject3).uuid;
              if (!((Boolean)((Pair)localObject4).first).booleanValue()) {
                break label1179;
              }
              paramString = paramObject2;
              Object localObject1;
              writeCommonLog(new String[] { "wl_usg", "|", str, "|0|", paramString, "|", String.valueOf(((Pair)localObject4).second), "|", String.valueOf(localObject1) });
              paramString = ((WakeLockEntity)localObject3).onAcquire((PowerManager.WakeLock)paramObject1, paramObject2, localObject1);
              if (!((Boolean)paramString.first).booleanValue()) {
                break label514;
              }
              localObject4 = this.subHandler.obtainMessage(1);
              ((Message)localObject4).obj = localObject2;
              this.subHandler.sendMessageDelayed((Message)localObject4, this.maxAcquireTime);
            }
            for (;;)
            {
              if (paramString.second == null) {
                break label629;
              }
              onUsageAlarm(4, 0, 0, "Acquire " + ((WakeLockEntity)localObject3).tag + " too frequently", HighFrequencyDetector.getDescription((List)paramString.second));
              break;
              l = ((Long)paramArrayOfObject[0]).longValue();
              break label286;
              if (l >= this.maxAcquireTime)
              {
                writeCommonLog(new String[] { "wl_alm", "|", ((WakeLockEntity)localObject3).uuid, "|0|", String.valueOf(((Pair)localObject4).second) });
                onUsageAlarm(4, 1, 0, "Acquire " + ((WakeLockEntity)localObject3).tag + " too long time", "CallStack: " + ((WakeLockEntity)localObject3).createStack);
              }
            }
          }
          else if (((WeakReference)localObject2).get() == null)
          {
            if (((WakeLockEntity)localObject3).isHeld())
            {
              onUsageAlarm(4, 2, 1, "WakeLock " + ((WakeLockEntity)localObject3).tag + " not release", "CreateStack: " + ((WakeLockEntity)localObject3).createStack);
              writeCommonLog(new String[] { "wl_alm", "|", ((WakeLockEntity)localObject3).uuid, "|1" });
              doReport((WakeLockEntity)localObject3, 4);
            }
            ((WakeLockEntity)localObject3).destroy();
            localIterator.remove();
          }
        }
      }
    } while (!"release".equals(paramString));
    paramObject2 = getAppStack().toString();
    Iterator localIterator = this.map.keySet().iterator();
    label793:
    label849:
    int i;
    if (localIterator.hasNext())
    {
      localObject2 = (WeakReference)localIterator.next();
      paramString = (WakeLockEntity)this.map.get(localObject2);
      if (((WeakReference)localObject2).get() == paramObject1)
      {
        if (paramArrayOfObject == null) {
          break label1186;
        }
        if (paramArrayOfObject.length == 0)
        {
          break label1186;
          localObject3 = paramString.onRelease((PowerManager.WakeLock)paramObject1, i);
          if (((Boolean)((Pair)localObject3).first).booleanValue())
          {
            this.subHandler.removeMessages(1, localObject2);
            writeCommonLog(new String[] { "wl_tm", "|", paramString.uuid, "|", String.valueOf(((Pair)localObject3).second) });
            doReport(paramString, 3);
          }
          localObject2 = paramString.getCallStackIndex(paramObject2);
          localObject3 = paramString.uuid;
          if (!((Boolean)((Pair)localObject2).first).booleanValue()) {
            break label1192;
          }
        }
      }
    }
    label1171:
    label1179:
    label1186:
    label1192:
    for (paramString = paramObject2;; paramString = "")
    {
      writeCommonLog(new String[] { "wl_usg", "|", localObject3, "|1|", paramString, "|", String.valueOf(((Pair)localObject2).second), "|", String.valueOf(i) });
      break label793;
      i = ((Integer)paramArrayOfObject[0]).intValue();
      break label849;
      if (((WeakReference)localObject2).get() != null) {
        break label793;
      }
      if (paramString.isHeld())
      {
        onUsageAlarm(4, 2, 1, "WakeLock " + paramString.tag + " not release", "CreateStack: " + paramString.createStack);
        writeCommonLog(new String[] { "wl_alm", "|", paramString.uuid, "|1" });
        doReport(paramString, 4);
      }
      paramString.destroy();
      localIterator.remove();
      break label793;
      break;
      l = -1L;
      break label286;
      paramString = "";
      break label319;
      i = -1;
      break label849;
    }
  }
  
  public void onOtherProcReport(Bundle paramBundle)
  {
    int i = paramBundle.getInt("key_action");
    if ((this.isRunning) && ((i == 3) || (i == 4) || (i == 5)))
    {
      Logger.INSTANCE.i(new String[] { "QAPM.WakeLockMonitor", "WakeLock.onOtherProcReport:action=", String.valueOf(i), ", tag=", paramBundle.getString("key_tag"), ", stack=", paramBundle.getString("key_stack"), ", time=", String.valueOf(paramBundle.getLong("key_time")) });
      String str = paramBundle.getString("key_stack");
      if (i == 3) {
        synchronized (this.fg30MinMap)
        {
          ReportEntity localReportEntity2;
          ReportEntity localReportEntity1;
          if (this.isBeforeRun30Min)
          {
            localReportEntity2 = (ReportEntity)this.fg30MinMap.get(str);
            localReportEntity1 = localReportEntity2;
            if (localReportEntity2 == null)
            {
              localReportEntity1 = new ReportEntity(null);
              localReportEntity1.flag = paramBundle.getInt("key_flag");
              localReportEntity1.tag = paramBundle.getString("key_tag");
              this.fg30MinMap.put(str, localReportEntity1);
            }
            localReportEntity1.useList.add(new Pair(Long.valueOf(System.currentTimeMillis()), Long.valueOf(paramBundle.getLong("key_time"))));
          }
          if ((this.isAppBackground) && (this.isInFirstBg5min))
          {
            localReportEntity2 = (ReportEntity)this.bg5MinMap.get(str);
            localReportEntity1 = localReportEntity2;
            if (localReportEntity2 == null)
            {
              localReportEntity1 = new ReportEntity(null);
              localReportEntity1.flag = paramBundle.getInt("key_flag");
              localReportEntity1.tag = paramBundle.getString("key_tag");
              this.bg5MinMap.put(str, localReportEntity1);
            }
            localReportEntity1.useList.add(new Pair(Long.valueOf(System.currentTimeMillis()), Long.valueOf(paramBundle.getLong("key_time"))));
          }
          return;
        }
      }
      if (i == 4)
      {
        writeReportLog(new String[] { "wlNotRelease", "|", paramBundle.getString("key_stack"), "|", paramBundle.getString("key_tag"), "|", paramBundle.getInt("key_flag") + "", "|", paramBundle.getLong("key_time") + "" });
        return;
      }
      if (i == 5) {
        writeReportLog(new String[] { "wlTimeout", "|", paramBundle.getString("key_stack"), "|", paramBundle.getString("key_tag"), "|", paramBundle.getInt("key_flag") + "", "|", paramBundle.getLong("key_time") + "" });
      }
    }
  }
  
  public void onProcessBG5Min()
  {
    super.onProcessBG5Min();
    if ((this.isRunning) && (isHookReady())) {
      writeReport(false);
    }
  }
  
  public void onProcessRun30Min()
  {
    super.onProcessRun30Min();
    if ((this.isRunning) && (isHookReady())) {
      writeReport(true);
    }
  }
  
  public void onProcessStart() {}
  
  class ReportEntity
  {
    public int flag;
    public String tag;
    public HashSet<Pair<Long, Long>> useList = new HashSet();
    
    private ReportEntity() {}
  }
  
  class WakeLockEntity
  {
    private Map<String, Integer> callStackMap = new HashMap();
    public String createStack;
    private HighFrequencyDetector detector1 = new HighFrequencyDetector(WakeLockMonitor.this.maxCallTimeInShortTime, WakeLockMonitor.this.shortTime);
    private HighFrequencyDetector detector2 = new HighFrequencyDetector(WakeLockMonitor.this.maxCallTimeInLongTime, WakeLockMonitor.this.longTime);
    private long firstAcquireTimeStamp = 0L;
    private long holdTime = 0L;
    public int levelAndFlags;
    public String tag;
    public String uuid;
    
    public WakeLockEntity() {}
    
    public void destroy()
    {
      this.detector1.trimCache();
      this.detector2.trimCache();
    }
    
    public Pair<Boolean, Integer> getCallStackIndex(String paramString)
    {
      synchronized (this.callStackMap)
      {
        if (this.callStackMap.containsKey(paramString))
        {
          paramString = new Pair(Boolean.valueOf(false), this.callStackMap.get(paramString));
          return paramString;
        }
        int i = this.callStackMap.size();
        this.callStackMap.put(paramString, Integer.valueOf(i));
        paramString = new Pair(Boolean.valueOf(true), Integer.valueOf(i));
        return paramString;
      }
    }
    
    public long getHoldTime()
    {
      if (isHeld()) {
        return SystemClock.uptimeMillis() - this.firstAcquireTimeStamp;
      }
      return this.holdTime;
    }
    
    public boolean isHeld()
    {
      return this.firstAcquireTimeStamp != 0L;
    }
    
    public Pair<Boolean, List<HighFrequencyDetector.Action>> onAcquire(PowerManager.WakeLock paramWakeLock, String paramString, long paramLong)
    {
      boolean bool = false;
      if (!paramWakeLock.isHeld())
      {
        bool = true;
        this.firstAcquireTimeStamp = SystemClock.uptimeMillis();
      }
      this.detector1.onAction(paramString);
      return new Pair(Boolean.valueOf(bool), this.detector2.onAction(paramString));
    }
    
    public Pair<Boolean, Long> onRelease(PowerManager.WakeLock paramWakeLock, int paramInt)
    {
      long l;
      boolean bool;
      if ((!paramWakeLock.isHeld()) && (this.firstAcquireTimeStamp != 0L))
      {
        l = SystemClock.uptimeMillis() - this.firstAcquireTimeStamp;
        this.firstAcquireTimeStamp = 0L;
        this.holdTime = l;
        bool = true;
      }
      for (;;)
      {
        return new Pair(Boolean.valueOf(bool), Long.valueOf(l));
        bool = false;
        l = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.battery.monitor.WakeLockMonitor
 * JD-Core Version:    0.7.0.1
 */