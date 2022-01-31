import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.qphone.base.util.QLog;

public class wtv
  implements SeekBar.OnSeekBarChangeListener
{
  public wtv(VideoPlayerView paramVideoPlayerView) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (VideoPlayerView.a(this.a)) {
      xeo.a("setSeekBar", 100L, new wtw(this, paramSeekBar));
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    VideoPlayerView.a(this.a, true);
    VideoPlayerView.b(this.a, true);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (this.a.a() != null)
    {
      QLog.d("VideoPlayerView", 1, "seek onStopTrackingTouch seekBar progress" + paramSeekBar.getProgress());
      this.a.a((int)(paramSeekBar.getProgress() / (this.a.a.getMax() * 1.0F) * (float)this.a.a().b()));
    }
    VideoPlayerView.a(this.a, false);
    VideoPlayerView.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wtv
 * JD-Core Version:    0.7.0.1
 */