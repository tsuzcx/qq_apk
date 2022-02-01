package dov.com.tencent.mobileqq.shortvideo;

import aqhq;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class PtvTemplateManager$2
  implements Runnable
{
  public void run()
  {
    aqhq.z(PtvTemplateManager.aH.getPath() + File.separator, this.val$fileName, this.val$config);
    if (QLog.isColorLevel()) {
      QLog.i("PtvTemplateManager", 2, "save Config to file finish.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.2
 * JD-Core Version:    0.7.0.1
 */