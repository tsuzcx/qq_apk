package dov.com.tencent.mobileqq.shortvideo;

import aoll;
import aolm;
import aomi;
import aqiw;
import ayzq;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class PtvTemplateManager$5
  implements Runnable
{
  PtvTemplateManager$5(PtvTemplateManager paramPtvTemplateManager, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, AppInterface paramAppInterface) {}
  
  public void run()
  {
    if (this.this$0.a(this.d)) {
      this.d.usable = true;
    }
    do
    {
      return;
      this.d.usable = false;
      aoll localaoll = new aoll();
      localaoll.f = new ayzq(this);
      localaoll.bZ = this.d.resurl;
      localaoll.mHttpMethod = 0;
      localaoll.atY = new File(PtvTemplateManager.aH, this.d.name).getPath();
      localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
      this.b.getNetEngine(0).a(localaoll);
    } while (!QLog.isColorLevel());
    QLog.i("PtvTemplateManager", 2, "startDownloadTemplate, url: " + this.d.resurl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.5
 * JD-Core Version:    0.7.0.1
 */