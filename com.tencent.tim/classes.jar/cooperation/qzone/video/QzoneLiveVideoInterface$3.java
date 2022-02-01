package cooperation.qzone.video;

import arcn.a;
import awhx;
import com.tencent.qphone.base.util.QLog;

final class QzoneLiveVideoInterface$3
  implements Runnable
{
  QzoneLiveVideoInterface$3(awhx paramawhx) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (1 != QzoneLiveVideoInterface.getIntConfig("LiveSetting", "qzone_webview_need_preload_dex_classes", 1)) {
          return;
        }
        if (!QzoneLiveVideoInterface.isBestPerformanceDevice()) {
          break;
        }
        if (!arcn.a.PN())
        {
          long l = System.currentTimeMillis();
          arcn.a.init();
          QLog.i("QzoneLiveVideoInterface", 2, "saxon@ 预加载 TbsAccelerator init cost " + (System.currentTimeMillis() - l));
          if (this.a == null) {
            break;
          }
          this.a.Qw();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("QzoneLiveVideoInterface", 1, localException, new Object[0]);
        return;
      }
      QLog.i("QzoneLiveVideoInterface", 2, "saxon@ 预加载 TbsAccelerator is inited");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.video.QzoneLiveVideoInterface.3
 * JD-Core Version:    0.7.0.1
 */