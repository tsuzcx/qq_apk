import android.media.MediaPlayer;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.qphone.base.util.QLog;

public class cnp
  implements SeekBar.OnSeekBarChangeListener
{
  public cnp(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onProgressChanged: progress = " + paramInt + ",fromUser=" + paramBoolean);
    }
    ShortVideoPlayActivity.b(this.a, paramInt);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    int i = ShortVideoPlayActivity.a(this.a).getProgress();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onStartTrackingTouch: progress = " + i);
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    int i = ShortVideoPlayActivity.a(this.a).getProgress();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onStopTrackingTouch: progress = " + i);
    }
    if ((ShortVideoPlayActivity.d(this.a) == 1) || (ShortVideoPlayActivity.d(this.a) == 2))
    {
      if (ShortVideoPlayActivity.a(this.a) != null) {
        ShortVideoPlayActivity.a(this.a).seekTo(i);
      }
      return;
    }
    ShortVideoPlayActivity.c(this.a, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cnp
 * JD-Core Version:    0.7.0.1
 */