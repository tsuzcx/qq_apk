import android.hardware.SensorManager;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.PlayingPttHistoryInfo;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.AudioPlayer.AudioPlayerListener;

public class adm
  implements AudioPlayer.AudioPlayerListener
{
  public adm(ChatHistory paramChatHistory) {}
  
  public void a(AudioPlayer paramAudioPlayer)
  {
    this.a.k();
    if (this.a.a != null) {
      this.a.a.b();
    }
    this.a.setVolumeControlStream(3);
    ChatHistory.a(this.a).unregisterListener(this.a);
  }
  
  public void a(AudioPlayer paramAudioPlayer, int paramInt)
  {
    this.a.a(2131363175);
    this.a.setVolumeControlStream(3);
    ChatHistory.a(this.a).unregisterListener(this.a);
  }
  
  public void b(AudioPlayer paramAudioPlayer, int paramInt)
  {
    this.a.setVolumeControlStream(paramInt);
  }
  
  public void c(AudioPlayer paramAudioPlayer, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     adm
 * JD-Core Version:    0.7.0.1
 */