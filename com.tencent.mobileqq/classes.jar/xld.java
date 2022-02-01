import android.media.AudioManager.OnAudioFocusChangeListener;

class xld
  implements AudioManager.OnAudioFocusChangeListener
{
  xld(xla paramxla) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (((paramInt == -1) || (paramInt == -2) || (paramInt == -3)) && (xla.a(this.a))) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xld
 * JD-Core Version:    0.7.0.1
 */