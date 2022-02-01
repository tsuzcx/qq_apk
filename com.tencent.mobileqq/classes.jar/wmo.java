import android.media.AudioManager.OnAudioFocusChangeListener;

class wmo
  implements AudioManager.OnAudioFocusChangeListener
{
  wmo(wml paramwml) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (((paramInt == -1) || (paramInt == -2) || (paramInt == -3)) && (wml.a(this.a))) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wmo
 * JD-Core Version:    0.7.0.1
 */