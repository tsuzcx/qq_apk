import android.media.AudioManager.OnAudioFocusChangeListener;

class qgc
  implements AudioManager.OnAudioFocusChangeListener
{
  qgc(qfz paramqfz) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (((paramInt == -1) || (paramInt == -2) || (paramInt == -3)) && (qfz.a(this.this$0))) {
      this.this$0.ahH();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qgc
 * JD-Core Version:    0.7.0.1
 */