package cooperation.qzone.contentbox;

import android.app.Activity;
import avsn;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;

class QZoneMsgFragment$1
  implements Runnable
{
  QZoneMsgFragment$1(QZoneMsgFragment paramQZoneMsgFragment, Activity paramActivity) {}
  
  public void run()
  {
    QLog.i("QZoneMsgManager.QZoneMsgFragment", 1, "onAttach: start to load qzone plugin");
    try
    {
      QzonePluginProxyActivity.c(this.val$activity);
      avsn.d(this.val$activity, this.this$0.app);
      avsn.c(this.val$activity, this.this$0.app);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.w("QZoneMsgManager.QZoneMsgFragment", 1, "onAttach: failed to load qzone plugin", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgFragment.1
 * JD-Core Version:    0.7.0.1
 */