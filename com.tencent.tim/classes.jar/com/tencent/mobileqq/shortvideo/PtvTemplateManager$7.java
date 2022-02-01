package com.tencent.mobileqq.shortvideo;

import ankq;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class PtvTemplateManager$7
  implements Runnable
{
  PtvTemplateManager$7(PtvTemplateManager paramPtvTemplateManager, AppInterface paramAppInterface, File paramFile) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PtvTemplateManager", 4, String.format("rebuildTemplateInfos, runnable[%s]", new Object[] { Integer.valueOf(hashCode()) }));
    }
    List localList = this.this$0.a(this.b, this.T, null);
    if (localList != null) {}
    synchronized (this.this$0.eI)
    {
      if (this.this$0.czW) {
        return;
      }
      this.this$0.As.clear();
      this.this$0.As.addAll(localList);
      this.this$0.cFh = true;
      if ((this.b != null) && ((this.b instanceof QQAppInterface)) && (ankq.axZ())) {
        this.this$0.eS(this.this$0.As);
      }
      PtvTemplateManager.a(this.this$0);
      if (QLog.isDevelopLevel())
      {
        QLog.d("PtvTemplateManager", 4, String.format("rebuildTemplateInfos, [%s] finished", new Object[] { Integer.valueOf(hashCode()) }));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.7
 * JD-Core Version:    0.7.0.1
 */