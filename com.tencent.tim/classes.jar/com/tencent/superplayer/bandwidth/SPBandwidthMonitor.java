package com.tencent.superplayer.bandwidth;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.superplayer.api.ISPBandwidthMonitor;
import com.tencent.superplayer.api.ISPBandwidthMonitor.Callback;
import com.tencent.superplayer.api.ISPBandwidthMonitor.Stat;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.ThreadUtil;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.datatransport.ITPProxyManagerAdapter;
import com.tencent.thumbplayer.datatransport.TPProxyGlobalManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class SPBandwidthMonitor
  implements ISPBandwidthMonitor
{
  public static final long DEFAULE_INTERVAL = 60000L;
  public static final long DELAY_STOP_INTERVAL = 5000L;
  private static final String TAG = "SPBandwidthMonitor";
  private int busiScene;
  private ISPBandwidthMonitor.Callback callback;
  private final Handler handler;
  private long interval = 60000L;
  private Map<String, ISPBandwidthMonitor.Stat> lastStats = new HashMap();
  private ITPDownloadProxy proxy;
  private boolean running = false;
  private int sceneid;
  private int serviceType;
  
  public SPBandwidthMonitor(int paramInt)
  {
    this.sceneid = paramInt;
    this.handler = new Handler(ThreadUtil.getSubThreadLooper());
    checkPorxy();
  }
  
  private void checkPorxy()
  {
    if ((this.proxy == null) && (this.sceneid > 0))
    {
      this.serviceType = CommonUtil.getDownloadProxyServiceType(this.sceneid);
      ITPProxyManagerAdapter localITPProxyManagerAdapter = TPProxyGlobalManager.getInstance().getPlayerProxy(this.serviceType);
      if (localITPProxyManagerAdapter != null) {
        this.proxy = localITPProxyManagerAdapter.getDownloadProxy();
      }
    }
  }
  
  private long getDelayInterval()
  {
    long l = System.currentTimeMillis();
    return this.interval - l % this.interval;
  }
  
  private Map<String, ISPBandwidthMonitor.Stat> getDiff(Map<String, ISPBandwidthMonitor.Stat> paramMap)
  {
    HashMap localHashMap = new HashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (ISPBandwidthMonitor.Stat)((Map.Entry)localObject).getValue();
      ISPBandwidthMonitor.Stat localStat = (ISPBandwidthMonitor.Stat)this.lastStats.get(str);
      if (localStat != null) {
        localHashMap.put(str, ISPBandwidthMonitor.Stat.diff(localStat, (ISPBandwidthMonitor.Stat)localObject));
      } else {
        localHashMap.put(str, localObject);
      }
    }
    return localHashMap;
  }
  
  private Map<String, ISPBandwidthMonitor.Stat> readCurStats(String paramString)
  {
    localHashMap = new HashMap();
    try
    {
      paramString = new JSONObject(paramString).getJSONObject(String.valueOf(this.serviceType));
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONObject localJSONObject = paramString.getJSONObject(str);
        ISPBandwidthMonitor.Stat localStat = new ISPBandwidthMonitor.Stat();
        localStat.httpBandwidth = localJSONObject.getLong("http");
        localStat.pcdnBandwidth = localJSONObject.getLong("pcdn");
        localStat.p2pBandwidth = localJSONObject.getLong("p2p");
        localHashMap.put(str, localStat);
      }
      return localHashMap;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void runNextTask(long paramLong)
  {
    if (this.running) {
      this.handler.postDelayed(new SPBandwidthMonitor.3(this), paramLong);
    }
  }
  
  private void sampleBandwidth()
  {
    checkPorxy();
    long l = getDelayInterval();
    if ((this.proxy == null) || (this.callback == null))
    {
      LogUtil.d("SPBandwidthMonitor", "sampleBandwidth, proxy or callback null");
      runNextTask(l);
      return;
    }
    Object localObject = this.proxy.getNativeInfo(3);
    LogUtil.d("SPBandwidthMonitor", "sampleBandwidth, info=" + (String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = readCurStats((String)localObject);
      Map localMap = getDiff((Map)localObject);
      this.callback.onBandwidthUpdate(localMap);
      this.lastStats = ((Map)localObject);
    }
    runNextTask(l);
  }
  
  public void start(Context paramContext, ISPBandwidthMonitor.Callback paramCallback, long paramLong)
  {
    if ((this.busiScene <= 0) && (paramCallback != null))
    {
      LogUtil.d("SPBandwidthMonitor", "start, interval=" + paramLong);
      this.busiScene = paramContext.hashCode();
      this.running = true;
      this.callback = paramCallback;
      if (paramLong > 0L) {
        this.interval = paramLong;
      }
      this.handler.removeCallbacksAndMessages(null);
      runNextTask(0L);
    }
  }
  
  public void stop(Context paramContext)
  {
    if ((paramContext.hashCode() == this.busiScene) && (this.running))
    {
      LogUtil.d("SPBandwidthMonitor", "stop");
      this.running = false;
      this.busiScene = 0;
      this.handler.removeCallbacksAndMessages(null);
      this.handler.post(new SPBandwidthMonitor.1(this));
      this.handler.postDelayed(new SPBandwidthMonitor.2(this), 5000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.bandwidth.SPBandwidthMonitor
 * JD-Core Version:    0.7.0.1
 */