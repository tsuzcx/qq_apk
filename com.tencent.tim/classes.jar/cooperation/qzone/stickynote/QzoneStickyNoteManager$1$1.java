package cooperation.qzone.stickynote;

import android.os.Handler;
import avsn;
import awbq;
import awbr;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;

public class QzoneStickyNoteManager$1$1
  implements Runnable
{
  public QzoneStickyNoteManager$1$1(awbr paramawbr) {}
  
  public void run()
  {
    try
    {
      QzonePluginProxyActivity.c(this.a.val$activity);
      boolean bool = avsn.d(this.a.val$activity, this.a.val$app);
      if ((avsn.c(this.a.val$activity, this.a.val$app)) && (bool)) {
        awbq.a(this.a.this$0).post(new QzoneStickyNoteManager.1.1.1(this));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.w("QzoneStickyNoteManager", 1, "tryLoadQzonePlugin: failed to load qzone plugin");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.stickynote.QzoneStickyNoteManager.1.1
 * JD-Core Version:    0.7.0.1
 */