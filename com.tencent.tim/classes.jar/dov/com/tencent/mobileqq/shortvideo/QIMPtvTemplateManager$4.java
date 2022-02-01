package dov.com.tencent.mobileqq.shortvideo;

import aoll;
import aolm;
import aomi;
import aqhq;
import aqiw;
import axol;
import ayzs;
import ayzt;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QIMPtvTemplateManager$4
  implements Runnable
{
  public QIMPtvTemplateManager$4(ayzs paramayzs, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo) {}
  
  public void run()
  {
    if (this.this$0.a(this.d)) {
      this.d.usable = true;
    }
    for (;;)
    {
      return;
      this.d.usable = false;
      int i = (int)(aqhq.getAvailableInnernalMemorySize() / 1024.0F / 1024.0F);
      int j = (int)(this.d.sizeFree * 1024.0D);
      if (QLog.isColorLevel()) {
        QLog.d("QIMPtvTemplateManager", 2, "preDownloadTemplates getAvailableInnernalMemorySize: " + i + " mSizeFree: " + j);
      }
      if (i < j)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QIMPtvTemplateManager", 2, "preDownloadTemplates return getAvailableInnernalMemorySize: " + i + " mSizeFree: " + j);
        }
      }
      else
      {
        aoll localaoll = new aoll();
        localaoll.f = new ayzt(this);
        localaoll.bZ = this.d.resurl;
        localaoll.mHttpMethod = 0;
        localaoll.atY = new File(ayzs.m(), this.d.name).getPath();
        localaoll.mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
        try
        {
          AppInterface localAppInterface = axol.getAppInterface();
          if (localAppInterface != null)
          {
            ((PeakAppInterface)localAppInterface).getNetEngine(0).a(localaoll);
            if (QLog.isColorLevel())
            {
              QLog.i("QIMPtvTemplateManager", 2, "startDownloadFilterConfigZip, url: " + this.d.resurl);
              return;
            }
          }
        }
        catch (Exception localException) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.4
 * JD-Core Version:    0.7.0.1
 */