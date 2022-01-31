import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.av.utils.UITools;
import com.tencent.sharp.jni.TraeAudioSession.ITraeAudioCallback;

public final class bmk
  implements TraeAudioSession.ITraeAudioCallback
{
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(int paramInt, String paramString, boolean paramBoolean) {}
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(int paramInt, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3) {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3) {}
  
  public void b(int paramInt, String paramString) {}
  
  public void b(boolean paramBoolean) {}
  
  public void c(int paramInt, String paramString)
  {
    if (UITools.a != null) {
      UITools.a.onCompletion((MediaPlayer)null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bmk
 * JD-Core Version:    0.7.0.1
 */