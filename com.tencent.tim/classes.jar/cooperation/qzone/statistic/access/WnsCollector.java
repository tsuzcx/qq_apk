package cooperation.qzone.statistic.access;

import android.content.Context;
import avcb;
import awav;
import awaw;
import awaz;
import awba;
import awbb;
import awbc;
import awbj;
import awbk;
import cooperation.qzone.statistic.access.concept.Collector;
import cooperation.qzone.statistic.access.concept.Key;
import cooperation.qzone.statistic.access.concept.Statistic;

public class WnsCollector
  extends Collector
{
  public static WnsCollector a = new WnsCollector();
  protected Statistic b = new Statistic(WnsKeys.PublicKeys);
  
  public WnsCollector()
  {
    awbc localawbc = new awbc(avcb.Ph(), avcb.Pg(), true);
    awba localawba = new awba(avcb.Pe());
    awav localawav = new awav();
    localawav.a(this.b);
    awbb localawbb = new awbb("https://wspeed.qq.com/w.cgi");
    localawbb.WV(true);
    localawbb.a().WW(true);
    a(localawbc);
    a(localawba);
    a(localawav);
    a(localawbb);
  }
  
  public static WnsCollector a()
  {
    if (a == null) {
      a = new WnsCollector();
    }
    return a;
  }
  
  public Statistic a()
  {
    Statistic localStatistic = new Statistic(WnsKeys.PrivateKeys);
    localStatistic.setValue(WnsKeys.DType, Integer.valueOf(0));
    localStatistic.setValue(WnsKeys.ODetails, "");
    localStatistic.setValue(WnsKeys.Timestamp, Long.valueOf(System.currentTimeMillis() / 1000L));
    Key localKey = WnsKeys.Frequency;
    if (a() == null) {}
    for (int i = 1;; i = a().getFrequency())
    {
      localStatistic.setValue(localKey, Integer.valueOf(i));
      return localStatistic;
    }
  }
  
  public void bC(String paramString1, String paramString2, String paramString3)
  {
    this.b.setValue(WnsKeys.Device, paramString1);
    this.b.setValue(WnsKeys.SDKVersion, paramString2);
    this.b.setValue(WnsKeys.DeviceInfo, paramString3);
  }
  
  public void init(Context paramContext)
  {
    awbj.setContext(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.statistic.access.WnsCollector
 * JD-Core Version:    0.7.0.1
 */