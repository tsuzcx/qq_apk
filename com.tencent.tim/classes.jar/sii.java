import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.biz.subscribe.widget.VideoNextFeedsView;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

public class sii
  implements IVideoInnerStatusListener
{
  public sii(VideoPlayerView paramVideoPlayerView) {}
  
  public void notifyVideoClose(int paramInt)
  {
    VideoPlayerView.b(this.this$0, false);
    if (VideoPlayerView.a(this.this$0) != null)
    {
      VideoPlayerView.a(this.this$0).hide();
      VideoPlayerView.a(this.this$0, null);
    }
    VideoPlayerView.a(this.this$0, null);
    this.this$0.release();
  }
  
  public void notifyVideoSeek(int paramInt)
  {
    QLog.d("VideoPlayerView", 4, "notifyVideoSeek seek " + paramInt);
    this.this$0.seek(paramInt * this.this$0.a().getDurationMs() / 100L);
  }
  
  public void notifyVideoStart()
  {
    if (this.this$0.a().getCurrentPositionMs() < this.this$0.a().getDurationMs())
    {
      this.this$0.start();
      return;
    }
    if (VideoPlayerView.b(this.this$0))
    {
      QLog.d("VideoPlayerView", 4, "has more , wait for auto play next");
      return;
    }
    this.this$0.a().setLoopback(true);
    this.this$0.replay();
    if (VideoPlayerView.a(this.this$0) != null) {
      VideoPlayerView.a(this.this$0).onVideoStart((int)this.this$0.a().getDurationMs());
    }
    QLog.d("VideoPlayerView", 4, "no more, player repeat");
  }
  
  public void notifyVideoStop()
  {
    this.this$0.pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sii
 * JD-Core Version:    0.7.0.1
 */