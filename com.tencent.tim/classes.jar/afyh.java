import android.media.AudioManager.OnAudioFocusChangeListener;

class afyh
  implements AudioManager.OnAudioFocusChangeListener
{
  afyh(afyg paramafyg) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if ((afyg.a(this.this$0) != null) && (paramInt == -1) && (afyg.a(this.this$0) != null)) {
      afyg.a(this.this$0).Iw(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afyh
 * JD-Core Version:    0.7.0.1
 */