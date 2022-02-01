package com.tencent.mobileqq.shortvideo;

import anfj;
import aoll;
import aolm;
import aomi;
import aqiw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class PtvTemplateManager$15
  implements Runnable
{
  PtvTemplateManager$15(PtvTemplateManager paramPtvTemplateManager, PtvTemplateManager.DoodleInfo paramDoodleInfo) {}
  
  public void run()
  {
    if (this.this$0.a(this.a, true)) {
      this.a.doodleUsable = true;
    }
    do
    {
      QQAppInterface localQQAppInterface;
      do
      {
        return;
        localQQAppInterface = this.this$0.getQQAppInterface();
        if (localQQAppInterface != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Doodle_Strokes_PtvTemplateManager", 2, "reqApp:" + localQQAppInterface);
      return;
      aoll localaoll = new aoll();
      localaoll.f = new anfj(this);
      localaoll.bZ = this.a.doodleUrl;
      localaoll.mHttpMethod = 0;
      localaoll.atY = new File(PtvTemplateManager.aL, this.a.doodleName).getPath();
      localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
      localQQAppInterface.getNetEngine(0).a(localaoll);
    } while (!QLog.isColorLevel());
    QLog.i("Doodle_Strokes_PtvTemplateManager", 2, "startDownloadTemplate, url: " + this.a.doodleUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.15
 * JD-Core Version:    0.7.0.1
 */