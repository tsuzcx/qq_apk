import com.tencent.component.network.downloader.strategy.ConfigKeepAliveStrategy;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import common.config.service.QzoneConfig.a;

public class avxz
  extends ConfigKeepAliveStrategy
  implements QzoneConfig.a
{
  public avxz()
  {
    loadConfig();
    QzoneConfig.getInstance().addListener(this);
  }
  
  private void loadConfig()
  {
    String str = QzoneConfig.getInstance().getConfig("PhotoDownload", "KpDomainList", "m.qpic.cn,a[0-9].qpic.cn,b\\d+\\.photo\\.store\\.qq\\.com,a\\d+\\.photo\\.store\\.qq\\.com,.*d3g\\.qq\\.com,.*i.gtimg.cn,.*qzonestyle.gtimg.cn,.*qzs.qq.com,qlogo[0-9].store.qq.com,group.store.qq.com,pgdt.gtimg.cn,img[0-7].paipaiimg.com");
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginDownloadConfigKeepAliveStrategy", 2, "loadConfig, kp_domain_list=" + str);
    }
    setConfig(str);
  }
  
  public void onConfigChange()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginDownloadConfigKeepAliveStrategy", 2, "KeepAlive receive change");
    }
    loadConfig();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avxz
 * JD-Core Version:    0.7.0.1
 */