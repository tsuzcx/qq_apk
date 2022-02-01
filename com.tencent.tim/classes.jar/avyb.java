import com.tencent.component.network.downloader.strategy.PortConfigStrategy;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import common.config.service.QzoneConfig.a;
import cooperation.qzone.plugin.QZonePluginDownloadPortConfig.1;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;

public class avyb
  extends PortConfigStrategy
  implements QzoneConfig.a
{
  public avyb()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginDownloadPortConfig", 2, "defaultPortStrategy={'a[0-9].qpic.cn':[{'port': '80'},{'port': '14000'}],'m.qpic.cn':[{'port': '80'},{'port': '14000'}]}");
    }
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(new QZonePluginDownloadPortConfig.1(this));
    QzoneConfig.getInstance().addListener(this);
  }
  
  private void Xh()
  {
    String str = QzoneConfig.getInstance().getConfig("PhotoSvrList", "DownloadAccessPortList");
    if (str != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZonePluginDownloadPortConfig", 2, "initPort, ports=" + str);
      }
      setConfig(str);
    }
  }
  
  private void initConfig()
  {
    String str = QzoneConfig.getInstance().getConfig("PhotoSvrList", "DownloadAccessPortList");
    if (str != null) {}
    for (;;)
    {
      setConfig(str);
      return;
      str = "{'a[0-9].qpic.cn':[{'port': '80'},{'port': '14000'}],'m.qpic.cn':[{'port': '80'},{'port': '14000'}]}";
    }
  }
  
  public void onConfigChange()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZonePluginDownloadPortConfig", 2, "QzoneDownloadPortConfig receive change");
    }
    Xh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avyb
 * JD-Core Version:    0.7.0.1
 */