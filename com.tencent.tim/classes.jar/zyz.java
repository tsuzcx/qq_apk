import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.activity.qwallet.RedPacketKSongFragment;

public class zyz
  implements MediaPlayer.OnCompletionListener
{
  public zyz(RedPacketKSongFragment paramRedPacketKSongFragment) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    RedPacketKSongFragment.a(this.this$0, false);
    paramMediaPlayer.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zyz
 * JD-Core Version:    0.7.0.1
 */