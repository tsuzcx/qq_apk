package cooperation.qzone;

import anpc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;

final class QzoneVerticalVideoDownloadActivity$8
  implements Runnable
{
  QzoneVerticalVideoDownloadActivity$8(QQAppInterface paramQQAppInterface, String paramString, HashMap paramHashMap) {}
  
  public void run()
  {
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(this.val$app.getCurrentUin(), this.asx, true, 0L, 0L, this.qG, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.QzoneVerticalVideoDownloadActivity.8
 * JD-Core Version:    0.7.0.1
 */