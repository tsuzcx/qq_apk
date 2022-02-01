import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.data.MessageForPtt;

public class wlx
  implements MediaPlayer.OnCompletionListener
{
  public wlx(MediaPlayerManager paramMediaPlayerManager) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    aqge.d = null;
    if ((MediaPlayerManager.a(this.this$0) != null) && ((MediaPlayerManager.a(this.this$0) instanceof MessageForPtt))) {
      ((MessageForPtt)MediaPlayerManager.a(this.this$0)).playProgress = 0.0F;
    }
    if ((MediaPlayerManager.a(this.this$0) != null) && (MediaPlayerManager.a(this.this$0))) {
      return;
    }
    MediaPlayerManager.a(this.this$0, null);
    this.this$0.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wlx
 * JD-Core Version:    0.7.0.1
 */