import android.media.AudioManager.OnAudioFocusChangeListener;

class xbj
  implements AudioManager.OnAudioFocusChangeListener
{
  xbj(xbg paramxbg) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (((paramInt == -1) || (paramInt == -2) || (paramInt == -3)) && (xbg.a(this.a))) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xbj
 * JD-Core Version:    0.7.0.1
 */