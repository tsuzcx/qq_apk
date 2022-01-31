import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.biz.subscribe.widget.VideoNextFeedsView;

public class wfi
  implements View.OnClickListener
{
  public wfi(VideoPlayerView paramVideoPlayerView) {}
  
  public void onClick(View paramView)
  {
    if (VideoPlayerView.a(this.a) != null)
    {
      VideoPlayerView.a(this.a).b();
      VideoPlayerView.i(this.a);
      VideoPlayerView.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wfi
 * JD-Core Version:    0.7.0.1
 */