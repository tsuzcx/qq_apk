import android.os.Handler;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView.19.1;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView.19.2;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;

public class wfj
  implements wgf
{
  public wfj(VideoPlayerView paramVideoPlayerView) {}
  
  public void a(boolean paramBoolean)
  {
    VideoPlayerView.f(this.a, paramBoolean);
    if (VideoPlayerView.j(this.a)) {
      this.a.a().post(new VideoPlayerView.19.1(this));
    }
    do
    {
      do
      {
        return;
        if (VideoPlayerView.b(this.a))
        {
          this.a.a().post(new VideoPlayerView.19.2(this));
          return;
        }
      } while (!VideoPlayerView.i(this.a));
      if (VideoPlayerView.a(this.a) != null) {
        VideoPlayerView.a(this.a).a(true);
      }
      this.a.f();
    } while (VideoPlayerView.a(this.a) == null);
    VideoPlayerView.a(this.a).onVideoStart((int)VideoPlayerView.a(this.a).b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wfj
 * JD-Core Version:    0.7.0.1
 */