package dov.com.tencent.mobileqq.shortvideo;

import aqhq;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class PtvTemplateManager$11
  implements Runnable
{
  PtvTemplateManager$11(PtvTemplateManager paramPtvTemplateManager, String paramString) {}
  
  public void run()
  {
    aqhq.z(PtvTemplateManager.aL.getPath() + File.separator, "dov_doodle_template_new.cfg", this.val$config);
    if (QLog.isColorLevel()) {
      QLog.i("DOV_Doodle_Strokes_PtvTemplateManager", 2, "save Config to file finish.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.11
 * JD-Core Version:    0.7.0.1
 */