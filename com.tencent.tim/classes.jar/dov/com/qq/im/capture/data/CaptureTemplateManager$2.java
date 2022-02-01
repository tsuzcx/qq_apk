package dov.com.qq.im.capture.data;

import aoll;
import aolm;
import aomi;
import aqiw;
import axpx;
import axpy;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

public class CaptureTemplateManager$2
  implements Runnable
{
  public CaptureTemplateManager$2(axpx paramaxpx, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    if (axpx.a(this.this$0, this.axN, this.val$md5)) {}
    do
    {
      return;
      aoll localaoll = new aoll();
      localaoll.f = new axpy(this);
      localaoll.bZ = this.val$videoUrl;
      localaoll.mHttpMethod = 0;
      localaoll.atY = this.axN;
      localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
      this.this$0.a().getNetEngine(0).a(localaoll);
    } while (!QLog.isColorLevel());
    QLog.i("CaptureTemplateManager", 2, "startDownloadTemplate, url: " + this.val$videoUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.data.CaptureTemplateManager.2
 * JD-Core Version:    0.7.0.1
 */