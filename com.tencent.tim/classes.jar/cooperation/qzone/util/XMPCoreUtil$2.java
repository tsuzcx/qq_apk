package cooperation.qzone.util;

import awdr;
import awdt;
import cooperation.qzone.networkedmodule.QzoneModuleManager;

public class XMPCoreUtil$2
  implements Runnable
{
  public void run()
  {
    if ((awdr.b(this.this$0)) || (!awdr.c(this.this$0))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        QzoneModuleManager.getInstance().downloadModule("xmpcore.jar", new awdt(this));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.util.XMPCoreUtil.2
 * JD-Core Version:    0.7.0.1
 */