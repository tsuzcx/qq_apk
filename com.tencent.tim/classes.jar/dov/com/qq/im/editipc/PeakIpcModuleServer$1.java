package dov.com.qq.im.editipc;

import aqhq;
import axyu;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class PeakIpcModuleServer$1
  implements Runnable
{
  public PeakIpcModuleServer$1(axyu paramaxyu, String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = ShortVideoUtils.bw(this.cWA, "jpg");
    if ((!aqhq.fileExistsAndNotEmpty(str)) && (!aqhq.copyFile(this.fe, str))) {
      QLog.e("PeakIpcModuleServer", 2, "copy thumbPath fail, exist: " + aqhq.fileExistsAndNotEmpty(this.fe));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.editipc.PeakIpcModuleServer.1
 * JD-Core Version:    0.7.0.1
 */