package dov.com.tencent.mobileqq.shortvideo;

import ankq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class PtvTemplateManager$8
  implements Runnable
{
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PtvTemplateManager", 4, String.format("rebuildWebTemplateInfos, runnable[%s]", new Object[] { Integer.valueOf(hashCode()) }));
    }
    List localList = this.this$0.a(this.b, this.T, null);
    if (localList != null) {}
    synchronized (this.this$0.eJ)
    {
      if (this.this$0.cFg) {
        return;
      }
      this.this$0.At.clear();
      this.this$0.At.addAll(localList);
      this.this$0.cFh = true;
      if ((this.b != null) && ((this.b instanceof QQAppInterface)) && (ankq.axZ())) {
        this.this$0.c(this.b, this.this$0.At);
      }
      PtvTemplateManager.a(this.this$0);
      if (QLog.isDevelopLevel())
      {
        QLog.d("PtvTemplateManager", 4, String.format("rebuildWebTemplateInfos, [%s] finished", new Object[] { Integer.valueOf(hashCode()) }));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.8
 * JD-Core Version:    0.7.0.1
 */