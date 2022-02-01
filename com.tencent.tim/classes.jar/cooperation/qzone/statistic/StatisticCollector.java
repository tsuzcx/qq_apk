package cooperation.qzone.statistic;

import android.os.Build;
import android.os.Build.VERSION;
import avpp;
import avpq;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.statistic.access.WnsCollector;
import cooperation.qzone.statistic.access.concept.Statistic;
import java.util.concurrent.atomic.AtomicBoolean;

public class StatisticCollector
{
  private AtomicBoolean inited = new AtomicBoolean(false);
  
  private String getDevice()
  {
    return Build.MODEL + "(" + Build.VERSION.RELEASE + ")";
  }
  
  public static StatisticCollector getInstance()
  {
    if (!a.a().inited.get()) {}
    try
    {
      if (!a.a().inited.get()) {
        a.a().init();
      }
      return a.a();
    }
    finally {}
  }
  
  private String getSDKVersion()
  {
    return Build.VERSION.SDK;
  }
  
  private void init()
  {
    if (this.inited.get()) {
      return;
    }
    WnsCollector.a().init(BaseApplication.getContext());
    WnsCollector.a().bC(getDevice(), getSDKVersion(), avpp.a().getDeviceInfor());
    WnsCollector.a().bdi();
    this.inited.set(true);
  }
  
  public void forceReport()
  {
    WnsCollector.a().eDa();
  }
  
  public int getAppid()
  {
    return 1000027;
  }
  
  public String getReleaseVersion()
  {
    return avpq.getVersionForHabo();
  }
  
  public Statistic getStatistic()
  {
    return WnsCollector.a().a();
  }
  
  public void put(Statistic paramStatistic)
  {
    WnsCollector.a().b(paramStatistic);
  }
  
  public void reportImmediate()
  {
    WnsCollector.a().eDa();
    WnsCollector.a().flush();
  }
  
  static class a
  {
    private static final StatisticCollector a = new StatisticCollector();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.statistic.StatisticCollector
 * JD-Core Version:    0.7.0.1
 */