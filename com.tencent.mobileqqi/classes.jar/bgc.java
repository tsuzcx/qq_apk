import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.av.VideoController;

public class bgc
  implements AudioManager.OnAudioFocusChangeListener
{
  public bgc(VideoController paramVideoController) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (paramInt == -1) {}
    while ((paramInt == -2) || (paramInt == -3) || (paramInt != 1)) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bgc
 * JD-Core Version:    0.7.0.1
 */