import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.videoview.VideoTextureView;
import com.tencent.mobileqq.widget.qqfloatingscreen.videoview.VideoTextureView.a;

public class arlu
  implements MediaPlayer.OnPreparedListener
{
  public arlu(VideoTextureView paramVideoTextureView) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (VideoTextureView.a(this.this$0) != null)
    {
      VideoTextureView.a(this.this$0).start();
      VideoTextureView.a(this.this$0, VideoTextureView.a(this.this$0).getDuration());
    }
    if (VideoTextureView.a() != null)
    {
      VideoTextureView.a().onVideoStart(VideoTextureView.a(this.this$0));
      VideoTextureView.a().onVideoProgressUpdate(0);
      VideoTextureView.a().onVideoSize(VideoTextureView.a(this.this$0).getVideoWidth(), VideoTextureView.a(this.this$0).getVideoHeight());
    }
    if (VideoTextureView.a(this.this$0) != null) {
      VideoTextureView.a(this.this$0).post(this.this$0.eu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arlu
 * JD-Core Version:    0.7.0.1
 */