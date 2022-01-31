import com.tencent.sharp.jni.AudioDeviceInterface;
import com.tencent.sharp.jni.TraeAudioSession.ITraeAudioCallback;

public class hyt
  implements TraeAudioSession.ITraeAudioCallback
{
  public hyt(AudioDeviceInterface paramAudioDeviceInterface) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      AudioDeviceInterface.access$000(this.a, paramString);
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean) {}
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(int paramInt, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3) {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3)
  {
    AudioDeviceInterface.access$000(this.a, paramString1);
  }
  
  public void b(int paramInt, String paramString) {}
  
  public void b(boolean paramBoolean) {}
  
  public void c(int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hyt
 * JD-Core Version:    0.7.0.1
 */