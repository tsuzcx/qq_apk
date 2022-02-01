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
import android.support.annotation.RequiresApi;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.video.bandwidth.BandwidthPredictor.NetworkCallbackImpl.1;
import com.tencent.biz.pubaccount.readinjoy.video.bandwidth.BandwidthPredictor.NetworkCallbackImpl.2;
import com.tencent.biz.pubaccount.readinjoy.video.bandwidth.BandwidthPredictor.NetworkChangeReceiver.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class mzs
  implements Handler.Callback
{
  private static mzs a;
  private final ArrayList<mzw> bandwidthObtainers = new ArrayList();
  private final ArrayList<mzx> bandwidthPredictors = new ArrayList();
  private long currentPrediction;
  private Handler handler = new Handler(ThreadManager.getSubThreadLooper(), this);
  private int idleTimes;
  private long lastBandwidth;
  private long lastRestTimeStamp = SystemClock.elapsedRealtime();
  private long resetTimeThreshold = 600000L;
  private long sampleThreshold;
  private int scene;
  
  private mzs()
  {
    float f = Aladdin.getConfig(230).getFloatFromString("exo_weight_factor", 5.0F);
    this.bandwidthObtainers.add(new mzu());
    this.bandwidthPredictors.add(new mzv(f));
    aUO();
  }
  
  public static mzs a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new mzs();
      }
      return a;
    }
    finally {}
  }
  
  private void aUO()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      ((ConnectivityManager)BaseApplicationImpl.getApplication().getSystemService("connectivity")).registerNetworkCallback(new NetworkRequest.Builder().build(), new mzs.a(null));
      return;
    }
    BaseApplicationImpl.getApplication().registerReceiver(new mzs.b(null), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
  }
  
  private long getCurrentBandwidth()
  {
    Iterator localIterator = this.bandwidthObtainers.iterator();
    long l1 = 0L;
    while (localIterator.hasNext())
    {
      long l2 = ((mzw)localIterator.next()).getCurrentBandwidth();
      l1 = l2;
      if (l2 > 0L) {
        l1 = l2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("BandwidthPredictor", 2, "getCurrentBandwidth: bandwidth=" + l1);
    }
    return l1;
  }
  
  private void predict()
  {
    Iterator localIterator = this.bandwidthPredictors.iterator();
    long l1 = 0L;
    while (localIterator.hasNext())
    {
      mzx localmzx = (mzx)localIterator.next();
      long l2 = Math.max(localmzx.prediction, l1);
      l1 = l2;
      if (QLog.isColorLevel())
      {
        QLog.d("BandwidthPredictor", 2, "predict: predictor=" + localmzx + ", currentPrediction=" + localmzx.currentPredition + ", prediction=" + localmzx.prediction);
        l1 = l2;
      }
    }
    this.sampleThreshold = (((float)l1 / 10.0F));
    this.currentPrediction = l1;
  }
  
  private void reset()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BandwidthPredictor", 2, "reset: ");
    }
    this.lastRestTimeStamp = SystemClock.elapsedRealtime();
    Iterator localIterator = this.bandwidthPredictors.iterator();
    while (localIterator.hasNext()) {
      ((mzx)localIterator.next()).reset();
    }
    if (aqiw.isWifiConnected(BaseApplicationImpl.getContext()))
    {
      this.resetTimeThreshold = (Aladdin.getConfig(230).getIntegerFromString("reset_time_threshold_wifi", 3600) * 1000L);
      return;
    }
    this.resetTimeThreshold = (Aladdin.getConfig(230).getIntegerFromString("reset_time_threshold_xg", 600) * 1000L);
  }
  
  private void sample()
  {
    long l = getCurrentBandwidth();
    Iterator localIterator;
    if (l > this.sampleThreshold)
    {
      this.idleTimes = 0;
      if (this.lastBandwidth > this.sampleThreshold)
      {
        localIterator = this.bandwidthPredictors.iterator();
        while (localIterator.hasNext()) {
          ((mzx)localIterator.next()).sample(this.lastBandwidth);
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
        mzx localmzx = (mzx)localIterator.next();
        if (this.lastBandwidth > localmzx.prediction) {
          localmzx.sample(this.lastBandwidth);
        }
      }
      this.lastBandwidth = 0L;
      this.idleTimes += 1;
      if (this.idleTimes >= 5)
      {
        localIterator = this.bandwidthPredictors.iterator();
        while (localIterator.hasNext()) {
          ((mzx)localIterator.next()).onIdle();
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
  
  public void start(Context paramContext)
  {
    if ((Aladdin.getConfig(230).getIntegerFromString("bandwidth_enable", 1) == 1) && (this.scene <= 0))
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
  public final class a
    extends ConnectivityManager.NetworkCallback
  {
    private a() {}
    
    public void onAvailable(@Nullable Network paramNetwork)
    {
      mzs.a(mzs.this).post(new BandwidthPredictor.NetworkCallbackImpl.1(this));
    }
    
    public void onLost(@Nullable Network paramNetwork)
    {
      mzs.a(mzs.this).post(new BandwidthPredictor.NetworkCallbackImpl.2(this));
    }
  }
  
  public final class b
    extends BroadcastReceiver
  {
    private b() {}
    
    public void onReceive(@NotNull Context paramContext, @NotNull Intent paramIntent)
    {
      mzs.a(mzs.this).post(new BandwidthPredictor.NetworkChangeReceiver.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mzs
 * JD-Core Version:    0.7.0.1
 */