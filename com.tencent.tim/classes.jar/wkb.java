import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase.a;
import com.tencent.mobileqq.utils.AudioHelper.a;

public class wkb
  extends Handler
{
  public wkb(AudioPlayerBase paramAudioPlayerBase) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1000) && (this.this$0.bNL == 0) && (this.this$0.isPlaying()))
    {
      int i = this.this$0.audioManager.getStreamVolume(this.this$0.b.dZd);
      int j = this.this$0.audioManager.getStreamMaxVolume(this.this$0.b.dZd);
      if (i / j <= 0.18F) {
        break label125;
      }
      this.this$0.bNL = 1;
      if (this.this$0.a != null) {
        this.this$0.a.c(this.this$0, this.this$0.bNL);
      }
    }
    return;
    label125:
    this.this$0.uiHandler.sendEmptyMessageDelayed(1000, 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wkb
 * JD-Core Version:    0.7.0.1
 */