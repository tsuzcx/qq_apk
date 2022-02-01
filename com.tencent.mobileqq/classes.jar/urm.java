import android.media.AudioManager.OnAudioFocusChangeListener;

class urm
  implements AudioManager.OnAudioFocusChangeListener
{
  urm(url paramurl) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    uya.e("WSPlayerAudioControlLog", "[WSPlayerAudioControl.java][requestAudioFocus] onAudioFocusChange focusChange:" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     urm
 * JD-Core Version:    0.7.0.1
 */