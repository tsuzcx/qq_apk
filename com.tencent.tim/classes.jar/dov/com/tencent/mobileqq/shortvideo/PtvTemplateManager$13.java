package dov.com.tencent.mobileqq.shortvideo;

import aoll;
import aolm;
import aomi;
import aqiw;
import ayzp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class PtvTemplateManager$13
  implements Runnable
{
  PtvTemplateManager$13(PtvTemplateManager paramPtvTemplateManager, PtvTemplateManager.DoodleInfo paramDoodleInfo, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.this$0.a(this.a, true)) {
      this.a.doodleUsable = true;
    }
    do
    {
      return;
      aoll localaoll = new aoll();
      localaoll.f = new ayzp(this);
      localaoll.bZ = this.a.doodleUrl;
      localaoll.mHttpMethod = 0;
      localaoll.atY = new File(PtvTemplateManager.aL, this.a.doodleName).getPath();
      localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
      this.val$app.getNetEngine(0).a(localaoll);
    } while (!QLog.isColorLevel());
    QLog.i("DOV_Doodle_Strokes_PtvTemplateManager", 2, "startDownloadTemplate, url: " + this.a.doodleUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.13
 * JD-Core Version:    0.7.0.1
 */