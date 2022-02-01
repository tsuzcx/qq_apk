package dov.com.qq.im.ae.data;

import aoll;
import aolm;
import aomi;
import aqiw;
import awtn.b.b;
import axbv;
import axbw;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class AEMaterialMgr$1
  implements Runnable
{
  public AEMaterialMgr$1(axbv paramaxbv, MetaMaterial paramMetaMaterial, AppInterface paramAppInterface) {}
  
  public void run()
  {
    if (this.this$0.a(this.a))
    {
      axbv.a(this.this$0, this.a);
      axbv.a(this.this$0).remove(this.a.id);
    }
    do
    {
      return;
      if (this.this$0.isDownloading(this.a.id))
      {
        axbv.a(this.this$0, this.a, 0);
        return;
      }
      String str = awtn.b.b.cSQ;
      aoll localaoll = new aoll();
      localaoll.f = new axbw(this, str);
      localaoll.bZ = this.a.packageUrl;
      localaoll.mHttpMethod = 0;
      localaoll.atY = new File(str, this.a.id).getPath();
      localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
      this.b.getNetEngine(0).a(localaoll);
    } while (!QLog.isColorLevel());
    QLog.i(axbv.access$300(), 2, "startDownloadTemplate, url: " + this.a.packageUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.data.AEMaterialMgr.1
 * JD-Core Version:    0.7.0.1
 */