package dov.com.qq.im.capture.banner;

import aoll;
import aolm;
import aomi;
import aqiw;
import axph;
import axpi;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QIMCaptureBannerManager$3
  implements Runnable
{
  public void run()
  {
    if (this.this$0.a(this.a)) {}
    do
    {
      return;
      aoll localaoll = new aoll();
      localaoll.f = new axpi(this);
      localaoll.bZ = this.a.imgUrl;
      localaoll.mHttpMethod = 0;
      localaoll.atY = new File(axph.cVD, this.a.imgMd5).getPath();
      localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
      this.b.getNetEngine(0).a(localaoll);
    } while (!QLog.isColorLevel());
    QLog.i("QIMCaptureBannerManager", 2, "preLoadBannerResources, url: " + this.a.imgUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.banner.QIMCaptureBannerManager.3
 * JD-Core Version:    0.7.0.1
 */