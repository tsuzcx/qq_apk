import android.media.MediaPlayer;
import android.os.Handler;
import android.widget.SeekBar;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;

public class cns
  implements Runnable
{
  public cns(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void run()
  {
    if ((ShortVideoPlayActivity.a(this.a) != null) && (ShortVideoPlayActivity.a(this.a).isPlaying()))
    {
      if (ShortVideoPlayActivity.a(this.a) <= 0) {
        ShortVideoPlayActivity.a(this.a);
      }
      int i = ShortVideoPlayActivity.a(this.a).getCurrentPosition();
      ShortVideoPlayActivity.a(this.a).setProgress(i);
    }
    ShortVideoPlayActivity.a(this.a).postDelayed(ShortVideoPlayActivity.a(this.a), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cns
 * JD-Core Version:    0.7.0.1
 */