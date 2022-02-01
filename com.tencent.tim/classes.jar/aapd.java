import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.widget.Toast;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.a;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar;
import com.tencent.qphone.base.util.QLog;

public class aapd
  implements MediaPlayer.OnPreparedListener
{
  public aapd(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditLocalVideoActivity", 2, "onPrepared, duration:" + paramMediaPlayer.getDuration());
    }
    EditLocalVideoActivity.a(this.this$0).removeMessages(9999);
    EditLocalVideoActivity.h(this.this$0);
    EditLocalVideoActivity.a(this.this$0).J(EditLocalVideoActivity.a(this.this$0), EditLocalVideoActivity.a(this.this$0));
    EditLocalVideoActivity.a(this.this$0).gr(EditLocalVideoActivity.c(this.this$0), EditLocalVideoActivity.d(this.this$0));
    EditLocalVideoActivity.a(this.this$0).gH(paramMediaPlayer.getDuration());
    int i;
    int j;
    if (!EditLocalVideoActivity.a(this.this$0).isInited())
    {
      EditLocalVideoActivity.d(this.this$0, paramMediaPlayer.getDuration());
      if ((awcf.getFileSize(EditLocalVideoActivity.b(this.this$0)) / EditLocalVideoActivity.a(this.this$0).getDuration() * 15000L > this.this$0.s(EditLocalVideoActivity.fX())) && (QLog.isColorLevel())) {
        QLog.d("EditLocalVideoActivity", 2, "prepared, there is not enough space on sdcard");
      }
      i = paramMediaPlayer.getVideoWidth();
      j = paramMediaPlayer.getVideoHeight();
      if ((i <= 0) || (j <= 0)) {
        Toast.makeText(this.this$0.getApplicationContext(), acfp.m(2131705415), 1).show();
      }
    }
    else
    {
      return;
    }
    EditLocalVideoActivity.e(this.this$0, i);
    EditLocalVideoActivity.f(this.this$0, j);
    EditLocalVideoActivity.a(this.this$0, i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aapd
 * JD-Core Version:    0.7.0.1
 */