import android.media.AudioManager.OnAudioFocusChangeListener;

class vnx
  implements AudioManager.OnAudioFocusChangeListener
{
  vnx(vnu paramvnu) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (((paramInt == -1) || (paramInt == -2) || (paramInt == -3)) && (vnu.a(this.a))) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vnx
 * JD-Core Version:    0.7.0.1
 */