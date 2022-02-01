package cooperation.qzone.networkedmodule;

import anpc;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;

public final class QzoneModuleReport$1
  implements Runnable
{
  public QzoneModuleReport$1(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap paramHashMap, String paramString3) {}
  
  public void run()
  {
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance(this.val$uin, this.val$tagName, this.val$success, this.val$duration, this.val$size, this.aK, this.bFV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.networkedmodule.QzoneModuleReport.1
 * JD-Core Version:    0.7.0.1
 */