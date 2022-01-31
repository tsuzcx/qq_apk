import android.media.AudioManager.OnAudioFocusChangeListener;

class tuw
  implements AudioManager.OnAudioFocusChangeListener
{
  tuw(tut paramtut) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (((paramInt == -1) || (paramInt == -2) || (paramInt == -3)) && (tut.a(this.a))) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tuw
 * JD-Core Version:    0.7.0.1
 */