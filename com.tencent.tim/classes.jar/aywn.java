import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import mqq.os.MqqHandler;

public class aywn
  implements MediaPlayer.OnPreparedListener
{
  public aywn(ShortVideoPreviewActivity paramShortVideoPreviewActivity, int paramInt) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreviewActivity", 2, "mMediaPlayer onPrepared: mDuration=" + this.this$0.mDuration);
    }
    paramMediaPlayer = this.this$0.mSurfaceView.getHolder();
    if ((paramMediaPlayer == null) || (!paramMediaPlayer.getSurface().isValid()))
    {
      ahao.OS(2131692345);
      return;
    }
    this.this$0.eTT();
    if ((this.this$0.dBo) && (this.this$0.dBn))
    {
      this.this$0.mMediaPlayer.setDisplay(paramMediaPlayer);
      this.this$0.duration = this.this$0.mMediaPlayer.getDuration();
      if (this.this$0.duration > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPreviewActivity", 2, "此时的时长为" + ShortVideoUtils.stringForTime(this.this$0.duration));
        }
        this.this$0.OX.setText(ShortVideoUtils.stringForTime(this.this$0.duration));
        this.this$0.p.setMax(this.this$0.duration);
      }
      this.this$0.B.post(this.this$0.fo);
    }
    this.this$0.mMediaPlayer.start();
    if (this.eMS > 0) {
      this.this$0.mMediaPlayer.seekTo(this.eMS);
    }
    this.this$0.GR(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aywn
 * JD-Core Version:    0.7.0.1
 */