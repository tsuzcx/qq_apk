import android.media.AudioManager.OnAudioFocusChangeListener;

class tuz
  implements AudioManager.OnAudioFocusChangeListener
{
  tuz(tuw paramtuw) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (((paramInt == -1) || (paramInt == -2) || (paramInt == -3)) && (tuw.a(this.a))) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tuz
 * JD-Core Version:    0.7.0.1
 */