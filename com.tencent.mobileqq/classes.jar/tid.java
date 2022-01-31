import android.media.AudioManager.OnAudioFocusChangeListener;

class tid
  implements AudioManager.OnAudioFocusChangeListener
{
  tid(tia paramtia) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (((paramInt == -1) || (paramInt == -2) || (paramInt == -3)) && (tia.a(this.a))) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tid
 * JD-Core Version:    0.7.0.1
 */