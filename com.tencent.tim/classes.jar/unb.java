import android.hardware.SensorManager;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.d;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase.a;

public class unb
  implements AudioPlayerBase.a
{
  public unb(ChatHistory paramChatHistory) {}
  
  public void a(AudioPlayerBase paramAudioPlayerBase)
  {
    this.this$0.bJO();
    if (this.this$0.a != null) {
      this.this$0.a.bJV();
    }
    this.this$0.setVolumeControlStream(3);
    this.this$0.mSensorManager.unregisterListener(this.this$0);
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    this.this$0.As(2131697002);
    this.this$0.setVolumeControlStream(3);
    this.this$0.mSensorManager.unregisterListener(this.this$0);
  }
  
  public void b(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    this.this$0.setVolumeControlStream(paramInt);
  }
  
  public void c(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void d(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     unb
 * JD-Core Version:    0.7.0.1
 */