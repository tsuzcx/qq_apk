package com.tencent.mobileqq.shortvideo;

import anfk;
import aoll;
import aolm;
import aomi;
import aqiw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class PtvTemplateManager$5
  implements Runnable
{
  PtvTemplateManager$5(PtvTemplateManager paramPtvTemplateManager, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo) {}
  
  public void run()
  {
    if (this.this$0.a(this.d)) {
      this.d.usable = true;
    }
    do
    {
      QQAppInterface localQQAppInterface;
      do
      {
        return;
        this.d.usable = false;
        localQQAppInterface = this.this$0.getQQAppInterface();
        if (localQQAppInterface != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("PtvTemplateManager", 2, "preDownloadTemplates  null!");
      return;
      aoll localaoll = new aoll();
      localaoll.f = new anfk(this);
      localaoll.bZ = this.d.resurl;
      localaoll.mHttpMethod = 0;
      localaoll.atY = new File(PtvTemplateManager.aH, this.d.name).getPath();
      localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
      localQQAppInterface.getNetEngine(0).a(localaoll);
    } while (!QLog.isColorLevel());
    QLog.i("PtvTemplateManager", 2, "startDownloadTemplate, url: " + this.d.resurl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.5
 * JD-Core Version:    0.7.0.1
 */