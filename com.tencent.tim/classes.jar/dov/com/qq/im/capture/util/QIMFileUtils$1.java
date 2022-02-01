package dov.com.qq.im.capture.util;

import aqhq;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class QIMFileUtils$1
  implements Runnable
{
  public QIMFileUtils$1(File paramFile, String paramString1, String paramString2) {}
  
  public void run()
  {
    aqhq.z(this.val$dir.getPath() + File.separator, this.val$fileName, this.val$config);
    if (QLog.isColorLevel()) {
      QLog.i("QIMFileUtils", 2, "paster config save to file " + this.val$dir.getPath() + File.separator + this.val$fileName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.util.QIMFileUtils.1
 * JD-Core Version:    0.7.0.1
 */