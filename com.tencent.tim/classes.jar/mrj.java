import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import java.lang.ref.WeakReference;

class mrj
  implements MediaPlayer.OnCompletionListener
{
  mrj(mrh parammrh) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    mrh.a(this.this$0).isPlaying = false;
    paramMediaPlayer = (mrh.a)mrh.a(this.this$0).get();
    if (paramMediaPlayer != null)
    {
      paramMediaPlayer.b(mrh.a(this.this$0));
      this.this$0.z(false, "ugc voice play");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mrj
 * JD-Core Version:    0.7.0.1
 */