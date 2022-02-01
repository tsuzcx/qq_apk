package com.tencent.superplayer.bandwidth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkRequest.Builder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import com.tencent.superplayer.api.ISPBandwidthPredictor;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.NetworkUtil;
import com.tencent.superplayer.utils.ThreadUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SPBandwidthPredictor
  implements Handler.Callback, ISPBandwidthPredictor, NetworkListener
{
  public static final String CONFIG_ENABLE_SAMPLE_FILTER = "enable_sample_filter";
  public static final String CONFIG_RESET_TIME_SECOND_FOR_WIFI = "reset_time_threshold_wifi";
  public static final String CONFIG_RESET_TIME_SECOND_FOR_XG = "reset_time_threshold_xg";
  private static final float DEFAULT_EXO_WEIGHT = 5.0F;
  private static final int DEFAULT_RESET_TIME_THRESHOLD_WIFI = 3600;
  private static final int DEFAULT_RESET_TIME_THRESHOLD_XG = 600;
  private static final long INTERVAL_SAMPLE = 1000L;
  public static final boolean LOG = false;
  private static final int MSG_SAMPLE = 0;
  private static final int SAMPLE_EXPIRE_DURATION = 5;
  private static final String TAG = "BandwidthPredictor";
  private static volatile NetworkCallbackImpl networkCallback;
  private static volatile NetworkChangeReceiver networkChangeReceiver;
  private static final List<WeakReference<NetworkListener>> networkListeners = new ArrayList();
  private final Context appContext;
  private ArrayList<IBandwidthObtainer> bandwidthObtainers;
  private ArrayList<AbstractPredictor> bandwidthPredictors;
  private Map<String, String> configMap;
  private long currentPrediction = 0L;
  private boolean enableSampleFilter = false;
  private final Handler handler;
  private int idleTimes = 0;
  private long lastBandwidth = 0L;
  private long lastRestTimeStamp = 0L;
  private long resetTimeThreshold = 600000L;
  private long sampleThreshold = 0L;
  private int scene;
  
  public SPBandwidthPredictor(Context paramContext)
  {
    this(paramContext, null, null, null);
  }
  
  public SPBandwidthPredictor(Context paramContext, @Nullable ArrayList<AbstractPredictor> paramArrayList, @Nullable ArrayList<IBandwidthObtainer> paramArrayList1, @Nullable Map<String, String> paramMap)
  {
    this.appContext = paramContext.getApplicationContext();
    this.configMap = paramMap;
    this.handler = new Handler(ThreadUtil.getSubThreadLooper(), this);
    this.lastRestTimeStamp = SystemClock.elapsedRealtime();
    this.bandwidthPredictors = paramArrayList;
    this.bandwidthObtainers = paramArrayList1;
    if (this.bandwidthObtainers == null)
    {
      this.bandwidthObtainers = new ArrayList();
      this.bandwidthObtainers.add(new DefaultBandwidthObtainer());
    }
    if (this.bandwidthPredictors == null)
    {
      this.bandwidthPredictors = new ArrayList();
      this.bandwidthPredictors.add(new ExoPredictor(5.0F));
    }
    if (this.configMap == null) {
      this.configMap = new HashMap();
    }
    if (CommonUtil.parseStr2Int((String)this.configMap.get("enable_sample_filter"), 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.enableSampleFilter = bool;
      networkListeners.add(new WeakReference(this));
      registerNetworkCallback(this.appContext);
      return;
    }
  }
  
  private static void dispatchNetworkChanged()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = networkListeners.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      NetworkListener localNetworkListener = (NetworkListener)localWeakReference.get();
      if (localNetworkListener != null) {
        localNetworkListener.onNetChanged();
      } else {
        localArrayList.add(localWeakReference);
      }
    }
    LogUtil.d("BandwidthPredictor", "dispatchNetworkChanged: toRemoveList.size=" + localArrayList.size());
    try
    {
      networkListeners.removeAll(localArrayList);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private long getCurrentBandwidth()
  {
    Iterator localIterator = this.bandwidthObtainers.iterator();
    long l1 = 0L;
    while (localIterator.hasNext())
    {
      long l2 = ((IBandwidthObtainer)localIterator.next()).getCurrentBandwidth();
      l1 = l2;
      if (l2 > 0L) {
        l1 = l2;
      }
    }
    return l1;
  }
  
  private void predict()
  {
    Iterator localIterator = this.bandwidthPredictors.iterator();
    long l = 0L;
    while (localIterator.hasNext())
    {
      AbstractPredictor localAbstractPredictor = (AbstractPredictor)localIterator.next();
      l = Math.max(localAbstractPredictor.prediction, l);
      LogUtil.d("BandwidthPredictor", "predict: predictor=" + localAbstractPredictor + ", currentPrediction=" + localAbstractPredictor.currentPredition + ", prediction=" + localAbstractPredictor.prediction);
    }
    if (this.enableSampleFilter) {
      this.sampleThreshold = (((float)l / 10.0F));
    }
    this.currentPrediction = l;
  }
  
  private static void registerNetworkCallback(Context paramContext)
  {
    if ((networkCallback == null) && (networkChangeReceiver == null))
    {
      LogUtil.d("BandwidthPredictor", "registerNetworkCallback: ");
      try
      {
        ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if ((Build.VERSION.SDK_INT >= 21) && (localConnectivityManager != null))
        {
          networkCallback = new NetworkCallbackImpl(null);
          localConnectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), networkCallback);
          return;
        }
        networkChangeReceiver = new NetworkChangeReceiver(null);
        paramContext.registerReceiver(networkChangeReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        return;
      }
      catch (Exception paramContext)
      {
        LogUtil.e("BandwidthPredictor", paramContext);
      }
    }
  }
  
  private void reset()
  {
    LogUtil.d("BandwidthPredictor", "reset: ");
    this.lastRestTimeStamp = SystemClock.elapsedRealtime();
    Iterator localIterator = this.bandwidthPredictors.iterator();
    while (localIterator.hasNext()) {
      ((AbstractPredictor)localIterator.next()).reset();
    }
    if (NetworkUtil.isWifiConnected())
    {
      this.resetTimeThreshold = (CommonUtil.parseStr2Int((String)this.configMap.get("reset_time_threshold_wifi"), 3600) * 1000L);
      return;
    }
    this.resetTimeThreshold = (CommonUtil.parseStr2Int((String)this.configMap.get("reset_time_threshold_xg"), 600) * 1000L);
  }
  
  private void sample()
  {
    long l = getCurrentBandwidth();
    LogUtil.d("BandwidthPredictor", "sample: currentBandwidth=" + l + ", lastBandwidth=" + this.lastBandwidth + ", sampleThreshold=" + this.sampleThreshold);
    Iterator localIterator;
    if (l > this.sampleThreshold)
    {
      this.idleTimes = 0;
      if (this.lastBandwidth > this.sampleThreshold)
      {
        localIterator = this.bandwidthPredictors.iterator();
        while (localIterator.hasNext()) {
          ((AbstractPredictor)localIterator.next()).sample(this.lastBandwidth);
        }
      }
      this.lastBandwidth = l;
    }
    for (;;)
    {
      return;
      localIterator = this.bandwidthPredictors.iterator();
      while (localIterator.hasNext())
      {
        AbstractPredictor localAbstractPredictor = (AbstractPredictor)localIterator.next();
        if (this.lastBandwidth > localAbstractPredictor.prediction) {
          localAbstractPredictor.sample(this.lastBandwidth);
        }
      }
      this.lastBandwidth = 0L;
      this.idleTimes += 1;
      if (this.idleTimes >= 5)
      {
        localIterator = this.bandwidthPredictors.iterator();
        while (localIterator.hasNext()) {
          ((AbstractPredictor)localIterator.next()).onIdle();
        }
        if (SystemClock.elapsedRealtime() - this.lastRestTimeStamp > this.resetTimeThreshold) {}
        for (int i = 1; i != 0; i = 0)
        {
          reset();
          return;
        }
      }
    }
  }
  
  public final long getCurrentPrediction()
  {
    return this.currentPrediction;
  }
  
  public long getLastBandwidth()
  {
    return this.lastBandwidth;
  }
  
  public boolean handleMessage(@Nullable Message paramMessage)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessage != null)
    {
      bool1 = bool2;
      if (paramMessage.what == 0)
      {
        sample();
        predict();
        this.handler.removeMessages(0);
        this.handler.sendEmptyMessageDelayed(0, 1000L);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onNetChanged()
  {
    LogUtil.d("BandwidthPredictor", "onNetChanged: ");
    this.handler.post(new SPBandwidthPredictor.1(this));
  }
  
  public void start(Context paramContext)
  {
    if (this.scene <= 0)
    {
      this.scene = paramContext.hashCode();
      this.handler.removeMessages(0);
      this.handler.sendEmptyMessage(0);
    }
  }
  
  public void stop(Context paramContext)
  {
    if (paramContext.hashCode() == this.scene)
    {
      this.handler.removeMessages(0);
      this.scene = 0;
    }
  }
  
  @RequiresApi(21)
  static final class NetworkCallbackImpl
    extends ConnectivityManager.NetworkCallback
  {
    public void onAvailable(@Nullable Network paramNetwork) {}
    
    public void onLost(@Nullable Network paramNetwork) {}
  }
  
  static final class NetworkChangeReceiver
    extends BroadcastReceiver
  {
    public void onReceive(@NonNull Context paramContext, @NonNull Intent paramIntent) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.bandwidth.SPBandwidthPredictor
 * JD-Core Version:    0.7.0.1
 */