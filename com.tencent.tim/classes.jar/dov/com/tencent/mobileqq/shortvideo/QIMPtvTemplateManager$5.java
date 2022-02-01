package dov.com.tencent.mobileqq.shortvideo;

import axrf;
import ayzs;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

public class QIMPtvTemplateManager$5
  implements Runnable
{
  public QIMPtvTemplateManager$5(ayzs paramayzs, File paramFile) {}
  
  public void run()
  {
    List localList = this.this$0.f(this.T);
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, String.format("rebuildTemplateInfos, templateInfos[%s]", new Object[] { localList }));
    }
    if (localList != null) {}
    synchronized (this.this$0.eI)
    {
      this.this$0.Fu.clear();
      this.this$0.Fu.addAll(localList);
      if (this.this$0.a() != null) {
        this.this$0.a().notifyObservers(axrf.class, 3, true, null);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QIMPtvTemplateManager", 4, String.format("rebuildTemplateInfos, [%s] finished", new Object[] { Integer.valueOf(hashCode()) }));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.5
 * JD-Core Version:    0.7.0.1
 */