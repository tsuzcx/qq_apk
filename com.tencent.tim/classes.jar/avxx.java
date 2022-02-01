import com.tencent.component.network.downloader.strategy.IPConfigStrategy;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import common.config.service.QzoneConfig.a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class avxx
  extends IPConfigStrategy
  implements QzoneConfig.a
{
  private ReadWriteLock RW_Lock = new ReentrantReadWriteLock();
  private Map<String, String> mConfigs = new HashMap();
  
  public avxx()
  {
    setDefaultIsp(2);
    QzoneConfig.getInstance().addListener(this);
  }
  
  private void addConfigItem(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if ((paramMap == null) || (paramString1 == null) || (paramString2 == null)) {
      return;
    }
    String str = paramString1 + "||" + paramString2;
    paramString1 = QzoneConfig.getInstance().getConfig(paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginDownloadBackupConfig", 2, "addConfigItem, newKey=" + str + ", content=" + paramString1);
    }
    paramMap.put(str, paramString1);
  }
  
  private void initConfig()
  {
    this.mConfigs.clear();
    addConfigItem(this.mConfigs, "PhotoSvrList", "DownloadBackupIP");
    addConfigItem(this.mConfigs, "ExtraConfig", "photo_backupIplist");
    addConfigItem(this.mConfigs, "PhotoABSvrList", "DownloadBackupIP_a");
    addConfigItem(this.mConfigs, "ExtraConfig", "photo_backupIplist_a");
    addConfigItem(this.mConfigs, "PhotoABSvrList", "DownloadBackupIP_b");
    addConfigItem(this.mConfigs, "ExtraConfig", "photo_backupIplist_b");
    addConfigItem(this.mConfigs, "VideoSvrList", "DownloadBackupIPVideo");
    addConfigItem(this.mConfigs, "ExtraConfig", "video_backupIplist");
    super.setConfig(this.mConfigs);
  }
  
  public void onConfigChange()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneIPStracyConfig", 2, "QZonePluginDownloadBackupConfig receive change");
    }
    initConfig();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avxx
 * JD-Core Version:    0.7.0.1
 */