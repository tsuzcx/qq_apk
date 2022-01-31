import com.tencent.mobileqq.app.PeakAppInterface;
import common.config.service.QzoneConfig;

public class zpb
  implements Runnable
{
  public zpb(PeakAppInterface paramPeakAppInterface) {}
  
  public void run()
  {
    QzoneConfig.getInstance().loadAllConfigs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zpb
 * JD-Core Version:    0.7.0.1
 */