import android.content.Context;
import android.media.AudioManager;
import com.tencent.common.app.BaseApplicationImpl;

public class axiu
{
  private AudioManager audioManager;
  
  public void acV()
  {
    this.audioManager = ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio"));
    this.audioManager.requestAudioFocus(null, 3, 2);
  }
  
  public void eLC()
  {
    if (this.audioManager != null) {
      this.audioManager.abandonAudioFocus(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axiu
 * JD-Core Version:    0.7.0.1
 */