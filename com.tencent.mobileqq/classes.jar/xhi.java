import android.media.AudioManager.OnAudioFocusChangeListener;

class xhi
  implements AudioManager.OnAudioFocusChangeListener
{
  xhi(xhf paramxhf) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (((paramInt == -1) || (paramInt == -2) || (paramInt == -3)) && (xhf.a(this.a))) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xhi
 * JD-Core Version:    0.7.0.1
 */