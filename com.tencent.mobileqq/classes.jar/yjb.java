import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import java.lang.ref.WeakReference;

public class yjb
  implements View.OnClickListener
{
  public yjb(VideoPlayerView paramVideoPlayerView) {}
  
  public void onClick(View paramView)
  {
    if (ytg.a("mLLSkipBackWrapper", 500L))
    {
      VideoPlayerView.e(this.a);
      VideoPlayerView.a(this.a, new WeakReference(VideoPlayerView.b(this.a)), 0, 1, true);
      if (VideoPlayerView.a(this.a) != null) {
        this.a.a(VideoPlayerView.a(this.a).a() - 10000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yjb
 * JD-Core Version:    0.7.0.1
 */