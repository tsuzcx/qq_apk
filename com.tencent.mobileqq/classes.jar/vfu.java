import android.media.AudioManager.OnAudioFocusChangeListener;

class vfu
  implements AudioManager.OnAudioFocusChangeListener
{
  vfu(vft paramvft) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    vmp.e("WSPlayerAudioControlLog", "[WSPlayerAudioControl.java][requestAudioFocus] onAudioFocusChange focusChange:" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfu
 * JD-Core Version:    0.7.0.1
 */