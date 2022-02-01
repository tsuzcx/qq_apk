package dov.com.tencent.mobileqq.shortvideo;

import ankq;
import aqiw;
import ayzs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public class QIMPtvTemplateManager$3
  implements Runnable
{
  public QIMPtvTemplateManager$3(ayzs paramayzs) {}
  
  public void run()
  {
    int i = 1;
    boolean bool1 = ankq.axZ();
    boolean bool2 = aqiw.isNetSupport(BaseApplication.getContext());
    if (BaseApplicationImpl.sProcessId == 1) {
      i = 0;
    }
    if ((bool1) && (bool2) && (i != 0)) {
      this.this$0.lW(this.this$0.Fu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.3
 * JD-Core Version:    0.7.0.1
 */