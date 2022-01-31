import android.media.AudioManager.OnAudioFocusChangeListener;

class vjo
  implements AudioManager.OnAudioFocusChangeListener
{
  vjo(vjl paramvjl) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (((paramInt == -1) || (paramInt == -2) || (paramInt == -3)) && (vjl.a(this.a))) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vjo
 * JD-Core Version:    0.7.0.1
 */