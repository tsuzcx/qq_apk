import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView.a;

public class ayvn
  implements MediaPlayer.OnCompletionListener
{
  public ayvn(FixedSizeVideoView paramFixedSizeVideoView) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.this$0.a != null)
    {
      this.this$0.removeCallbacks(FixedSizeVideoView.a(this.this$0));
      this.this$0.a.b(paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayvn
 * JD-Core Version:    0.7.0.1
 */