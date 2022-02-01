import android.os.Handler;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView.15.1;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView.15.2;
import com.tencent.biz.subscribe.widget.VideoNextFeedsView.a;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.superplayer.api.ISuperPlayer;

public class sia
  implements VideoNextFeedsView.a
{
  public sia(VideoPlayerView paramVideoPlayerView) {}
  
  public void uL(boolean paramBoolean)
  {
    VideoPlayerView.d(this.this$0, paramBoolean);
    if (VideoPlayerView.d(this.this$0)) {
      this.this$0.getMainHandler().post(new VideoPlayerView.15.1(this));
    }
    do
    {
      do
      {
        return;
        if (VideoPlayerView.b(this.this$0))
        {
          this.this$0.getMainHandler().post(new VideoPlayerView.15.2(this));
          return;
        }
      } while (!VideoPlayerView.e(this.this$0));
      if (this.this$0.a() != null) {
        this.this$0.a().setLoopback(true);
      }
      this.this$0.replay();
    } while (VideoPlayerView.a(this.this$0) == null);
    VideoPlayerView.a(this.this$0).onVideoStart((int)this.this$0.a().getDurationMs());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sia
 * JD-Core Version:    0.7.0.1
 */