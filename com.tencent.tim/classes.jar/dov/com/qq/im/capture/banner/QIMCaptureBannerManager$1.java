package dov.com.qq.im.capture.banner;

import axph;
import axrf;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class QIMCaptureBannerManager$1
  implements Runnable
{
  public QIMCaptureBannerManager$1(axph paramaxph) {}
  
  public void run()
  {
    QIMCaptureBannerConfig localQIMCaptureBannerConfig = QIMCaptureBannerConfig.getBannerConfigFromFile(this.this$0.a(), axph.cVD);
    if ((localQIMCaptureBannerConfig != null) && (localQIMCaptureBannerConfig.mBannerList.size() > 0))
    {
      ??? = localQIMCaptureBannerConfig.mBannerList.entrySet().iterator();
      while (((Iterator)???).hasNext())
      {
        QIMCaptureBannerConfig.BannerItem localBannerItem = (QIMCaptureBannerConfig.BannerItem)((Map.Entry)((Iterator)???).next()).getValue();
        long l = NetConnInfoCenter.getServerTimeMillis();
        if (localBannerItem.mEndTime < l) {
          ((Iterator)???).remove();
        }
      }
    }
    synchronized (axph.LOCK)
    {
      this.this$0.b = localQIMCaptureBannerConfig;
      if (QLog.isColorLevel()) {
        QLog.d("QIMCaptureBannerManager", 2, "initBannerFromCache= " + localQIMCaptureBannerConfig);
      }
      this.this$0.a().notifyObservers(axrf.class, 6, true, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.banner.QIMCaptureBannerManager.1
 * JD-Core Version:    0.7.0.1
 */