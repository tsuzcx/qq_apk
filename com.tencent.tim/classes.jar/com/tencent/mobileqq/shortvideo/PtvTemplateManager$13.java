package com.tencent.mobileqq.shortvideo;

import aqhq;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class PtvTemplateManager$13
  implements Runnable
{
  PtvTemplateManager$13(PtvTemplateManager paramPtvTemplateManager, String paramString) {}
  
  public void run()
  {
    aqhq.z(PtvTemplateManager.aL.getPath() + File.separator, "doodle_template_new.cfg", this.val$config);
    if (QLog.isColorLevel()) {
      QLog.i("Doodle_Strokes_PtvTemplateManager", 2, "save Config to file finish.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.13
 * JD-Core Version:    0.7.0.1
 */