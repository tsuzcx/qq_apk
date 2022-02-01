import android.annotation.SuppressLint;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

class mzu
  implements mzw
{
  private Method getLoopbackRxBytes;
  private Method getRxBytes;
  private long lastLoopBackBytes;
  private long lastTimeStamp;
  private long lastTotalRxBytes;
  
  @SuppressLint({"DiscouragedPrivateApi"})
  private final long getLoopbackRxBytesIn14()
  {
    try
    {
      if (this.getRxBytes == null)
      {
        this.getRxBytes = TrafficStats.class.getDeclaredMethod("getRxBytes", new Class[] { String.class });
        this.getRxBytes.setAccessible(true);
      }
      long l = ((Long)this.getRxBytes.invoke(null, new Object[] { "lo" })).longValue();
      return l;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DefaultBandwidthObtainer", 2, "getLoopbackRxBytesIn14: ", localException);
      }
    }
    return 0L;
  }
  
  @SuppressLint({"DiscouragedPrivateApi"})
  private final long getLoopbackRxBytesIn28()
  {
    try
    {
      if (this.getLoopbackRxBytes == null)
      {
        this.getLoopbackRxBytes = TrafficStats.class.getDeclaredMethod("getLoopbackRxBytes", new Class[0]);
        this.getLoopbackRxBytes.setAccessible(true);
      }
      long l = ((Long)this.getLoopbackRxBytes.invoke(null, new Object[0])).longValue();
      return l;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DefaultBandwidthObtainer", 2, "getLoopbackRxBytesIn28: ", localException);
      }
    }
    return 0L;
  }
  
  public long getCurrentBandwidth()
  {
    int i = Build.VERSION.SDK_INT;
    long l4 = SystemClock.elapsedRealtime();
    long l5 = TrafficStats.getTotalRxBytes();
    long l1;
    long l3;
    if (i >= 28)
    {
      l1 = getLoopbackRxBytesIn28();
      if ((this.lastTotalRxBytes <= 0L) || (this.lastLoopBackBytes <= 0L)) {
        break label236;
      }
      long l6 = l5 - this.lastTotalRxBytes;
      long l7 = l1 - this.lastLoopBackBytes;
      i = (int)Math.max((l4 - this.lastTimeStamp) / 1000L, 1L);
      l3 = Math.max(0L, (l6 - l7) / 1024L) / i;
      l2 = l3;
      if (QLog.isColorLevel()) {
        QLog.d("DefaultBandwidthObtainer", 2, "calculateBandwidth: totalBytes=" + l6 + ", loopbackBytes=" + l7 + ", bandwidth=" + l3 + "kb/s");
      }
    }
    label236:
    for (long l2 = l3;; l2 = 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DefaultBandwidthObtainer", 2, "getCurrentBandwidth: bandwidth=" + l2 + "kb/s");
      }
      this.lastTotalRxBytes = l5;
      this.lastLoopBackBytes = l1;
      this.lastTimeStamp = l4;
      return l2;
      if (i >= 14)
      {
        l1 = getLoopbackRxBytesIn14();
        break;
      }
      l1 = 0L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mzu
 * JD-Core Version:    0.7.0.1
 */