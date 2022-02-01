package com.tencent.tim.filemanager.fileviewer.presenter;

import android.os.Handler;
import android.os.PowerManager.WakeLock;
import atzy;
import aucd;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class VideoFilePresenter$5
  implements Runnable
{
  public VideoFilePresenter$5(aucd paramaucd) {}
  
  public void run()
  {
    int i;
    if (aucd.a(this.this$0) != null)
    {
      i = 1;
      if (aucd.a(this.this$0) != null) {
        break label63;
      }
      if (i == 0) {
        break label40;
      }
      QLog.e("FileBrowserPresenterBase", 1, "playVideo video, but mediaplay null!");
    }
    label40:
    label63:
    do
    {
      do
      {
        return;
        i = 0;
        break;
      } while (this.this$0.a.bG() != 1);
      QLog.e("FileBrowserPresenterBase", 1, "playVideo online video, but mediaplay null!");
      return;
      aucd.a(this.this$0).acquire();
      this.this$0.requestAudioFocus();
      if (aucd.a(this.this$0))
      {
        aucd.b(this.this$0, false);
        aucd.a(this.this$0).removeCallbacks(this.this$0.eu);
        new HashMap().put("shouq_bus_type", "bus_type_video_file");
      }
      aucd.a(this.this$0).play();
      if (i != 0) {
        aucd.a(this.this$0).postDelayed(this.this$0.eu, 1000L);
      }
      aucd.e(this.this$0);
    } while ((i == 0) || (!QLog.isDevelopLevel()));
    QLog.d("#@#@", 1, "userPos[" + aucd.a(this.this$0) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.fileviewer.presenter.VideoFilePresenter.5
 * JD-Core Version:    0.7.0.1
 */