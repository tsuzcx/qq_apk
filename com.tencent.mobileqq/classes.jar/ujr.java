import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.AudioPlayer.AudioPlayerListener;
import com.tencent.mobileqq.utils.AudioHelper.AudioPlayerParameter;

public class ujr
  extends Handler
{
  public ujr(AudioPlayer paramAudioPlayer) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1000) && (AudioPlayer.a(this.a) == 0) && (this.a.a()))
    {
      int i = AudioPlayer.a(this.a).getStreamVolume(AudioPlayer.a(this.a).b);
      int j = AudioPlayer.a(this.a).getStreamMaxVolume(AudioPlayer.a(this.a).b);
      if (i / j <= 0.1F) {
        break label126;
      }
      AudioPlayer.a(this.a, 1);
      if (AudioPlayer.a(this.a) != null) {
        AudioPlayer.a(this.a).c(this.a, AudioPlayer.a(this.a));
      }
    }
    return;
    label126:
    AudioPlayer.a(this.a).sendEmptyMessageDelayed(1000, 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ujr
 * JD-Core Version:    0.7.0.1
 */