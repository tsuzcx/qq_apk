package cooperation.qzone;

import avxl;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;

class QZoneLiveVideoDownLoadActivtyV2$1
  implements Runnable
{
  QZoneLiveVideoDownLoadActivtyV2$1(QZoneLiveVideoDownLoadActivtyV2 paramQZoneLiveVideoDownLoadActivtyV2, PluginBaseInfo paramPluginBaseInfo) {}
  
  public void run()
  {
    try
    {
      if (this.this$0.b != null) {
        this.this$0.b.a(this.b.mID, null, this.this$0.mMode);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QZoneLiveVideoDownLoadActivtyV2", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneLiveVideoDownLoadActivtyV2.1
 * JD-Core Version:    0.7.0.1
 */