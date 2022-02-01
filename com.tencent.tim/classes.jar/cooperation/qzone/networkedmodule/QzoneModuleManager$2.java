package cooperation.qzone.networkedmodule;

import anpc;
import com.tencent.qphone.base.util.QLog;

class QzoneModuleManager$2
  implements Runnable
{
  QzoneModuleManager$2(QzoneModuleManager paramQzoneModuleManager) {}
  
  public void run()
  {
    int i = anpc.Kk();
    QLog.i("QzoneModuleManager", 1, "current versionNum is:" + i);
    anpc.Vl(i + 6000);
    QzoneModuleManager.access$102(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.networkedmodule.QzoneModuleManager.2
 * JD-Core Version:    0.7.0.1
 */