import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService.1;

public class agru
  implements MediaPlayer.OnPreparedListener
{
  public agru(FileViewMusicService.1 param1, MediaPlayer paramMediaPlayer) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    int i = this.f.getDuration();
    this.f.stop();
    this.f.release();
    this.a.a.Ot(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agru
 * JD-Core Version:    0.7.0.1
 */