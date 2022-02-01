package cooperation.qzone;

import avqs;
import avqu;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

public class QZoneStartupMonitor$2$1
  implements Runnable
{
  public QZoneStartupMonitor$2$1(avqu paramavqu, int paramInt) {}
  
  public void run()
  {
    avqs.a(this.a.a);
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "atuoRecoveryQzoneCount", 1) > this.exW)
    {
      QLog.i("QZoneStartupMonitor", 1, "oat 不合法，并且wns配置要自动修复，重新安装qzone=");
      avqs.b(this.a.a);
      LocalMultiProcConfig.putInt("key_recovery_count", this.exW + 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneStartupMonitor.2.1
 * JD-Core Version:    0.7.0.1
 */