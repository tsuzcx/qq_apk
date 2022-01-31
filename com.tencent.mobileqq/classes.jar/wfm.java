import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;

public class wfm
  implements View.OnClickListener
{
  public wfm(VideoPlayerView paramVideoPlayerView) {}
  
  public void onClick(View paramView)
  {
    if (VideoPlayerView.a(this.a) != null) {
      VideoPlayerView.a(this.a).setVisibility(8);
    }
    VideoPlayerView.a(this.a, false);
    VideoPlayerView.a(true);
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wfm
 * JD-Core Version:    0.7.0.1
 */