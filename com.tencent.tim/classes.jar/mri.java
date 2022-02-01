import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import java.lang.ref.WeakReference;

class mri
  implements MediaPlayer.OnPreparedListener
{
  mri(mrh parammrh) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      paramMediaPlayer.start();
      mrh.a(this.this$0).isPlaying = true;
      paramMediaPlayer = (mrh.a)mrh.a(this.this$0).get();
      if (paramMediaPlayer != null)
      {
        paramMediaPlayer.a(mrh.a(this.this$0));
        this.this$0.z(true, "ugc voice play");
      }
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      for (;;)
      {
        paramMediaPlayer.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mri
 * JD-Core Version:    0.7.0.1
 */