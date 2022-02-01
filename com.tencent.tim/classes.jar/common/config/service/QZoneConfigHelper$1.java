package common.config.service;

import avcb.a;

public final class QZoneConfigHelper$1
  implements Runnable
{
  public QZoneConfigHelper$1(avcb.a parama) {}
  
  public void run()
  {
    int i = QzoneConfig.getInstance().getConfig("PhotoView", "ShowOPDelay", 0);
    this.a.iI(i * 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     common.config.service.QZoneConfigHelper.1
 * JD-Core Version:    0.7.0.1
 */