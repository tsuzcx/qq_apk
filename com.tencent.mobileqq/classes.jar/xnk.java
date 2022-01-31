import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.widget.Toast;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.FileUtils;

public class xnk
  implements MediaPlayer.OnPreparedListener
{
  public xnk(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditLocalVideoActivity", 2, "onPrepared, duration:" + paramMediaPlayer.getDuration());
    }
    EditLocalVideoActivity.a(this.a).removeMessages(9999);
    int i;
    int j;
    if (!EditLocalVideoActivity.a(this.a).a())
    {
      EditLocalVideoActivity.f(this.a, paramMediaPlayer.getDuration());
      if ((FileUtils.a(EditLocalVideoActivity.a(this.a)) / EditLocalVideoActivity.a(this.a).getDuration() * 15000L > this.a.a(EditLocalVideoActivity.a())) && (QLog.isColorLevel())) {
        QLog.d("EditLocalVideoActivity", 2, "prepared, there is not enough space on sdcard");
      }
      i = paramMediaPlayer.getVideoWidth();
      j = paramMediaPlayer.getVideoHeight();
      if ((i <= 0) || (j <= 0)) {
        Toast.makeText(this.a.getApplicationContext(), "获取视频尺寸失败", 1).show();
      }
    }
    else
    {
      return;
    }
    EditLocalVideoActivity.g(this.a, i);
    EditLocalVideoActivity.h(this.a, j);
    EditLocalVideoActivity.a(this.a, i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xnk
 * JD-Core Version:    0.7.0.1
 */