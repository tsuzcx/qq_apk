package cooperation.qzone;

import anpc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;

final class QzoneVerticalVideoDownloadActivity$7
  implements Runnable
{
  QzoneVerticalVideoDownloadActivity$7(String paramString1, String paramString2, QQAppInterface paramQQAppInterface, String paramString3, int paramInt) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(this.jz, this.val$value);
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(this.val$app.getCurrentUin(), this.tn, true, this.AW, 0L, localHashMap, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.QzoneVerticalVideoDownloadActivity.7
 * JD-Core Version:    0.7.0.1
 */