package cooperation.qzone;

import android.os.Handler;
import android.os.Message;
import avqf;

public class QZoneLiveVideoDownLoadActivtyV2$2$1
  implements Runnable
{
  public QZoneLiveVideoDownLoadActivtyV2$2$1(avqf paramavqf, float paramFloat) {}
  
  public void run()
  {
    if ((int)(this.val$progress * 100.0F) > 0)
    {
      this.a.this$0.mHandler.removeMessages(1009);
      this.a.this$0.mHandler.obtainMessage(1004, 100, 0).sendToTarget();
      this.a.this$0.updateTextProgress(false, true);
    }
    while (!this.a.this$0.dnT) {
      return;
    }
    this.a.this$0.mHandler.removeMessages(1009);
    this.a.this$0.updateTextProgress(true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneLiveVideoDownLoadActivtyV2.2.1
 * JD-Core Version:    0.7.0.1
 */