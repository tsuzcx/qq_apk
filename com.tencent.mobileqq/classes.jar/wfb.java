import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.biz.subscribe.widget.VideoNextFeedsView;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;

public class wfb
  implements IVideoInnerStatusListener
{
  public wfb(VideoPlayerView paramVideoPlayerView) {}
  
  public void notifyVideoClose(int paramInt)
  {
    VideoPlayerView.c(this.a, false);
    if (VideoPlayerView.a(this.a) != null)
    {
      VideoPlayerView.a(this.a).b();
      VideoPlayerView.a(this.a, null);
    }
    VideoPlayerView.a(this.a, null);
    this.a.g();
  }
  
  public void notifyVideoSeek(int paramInt)
  {
    QLog.d("VideoPlayerView", 4, "notifyVideoSeek seek " + paramInt);
    this.a.a(paramInt * this.a.a().b() / 100L);
  }
  
  public void notifyVideoStart()
  {
    if (VideoPlayerView.a(this.a).a() < VideoPlayerView.a(this.a).b())
    {
      this.a.d();
      return;
    }
    if (VideoPlayerView.b(this.a))
    {
      QLog.d("VideoPlayerView", 4, "has more , wait for auto play next");
      return;
    }
    VideoPlayerView.a(this.a).a(true);
    this.a.f();
    if (VideoPlayerView.a(this.a) != null) {
      VideoPlayerView.a(this.a).onVideoStart((int)VideoPlayerView.a(this.a).b());
    }
    QLog.d("VideoPlayerView", 4, "no more, player repeat");
  }
  
  public void notifyVideoStop()
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wfb
 * JD-Core Version:    0.7.0.1
 */