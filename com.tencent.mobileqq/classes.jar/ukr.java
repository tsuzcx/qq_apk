import android.media.AudioManager.OnAudioFocusChangeListener;

class ukr
  implements AudioManager.OnAudioFocusChangeListener
{
  ukr(ukq paramukq) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    uqf.e("WSPlayerAudioControlLog", "[WSPlayerAudioControl.java][requestAudioFocus] onAudioFocusChange focusChange:" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ukr
 * JD-Core Version:    0.7.0.1
 */