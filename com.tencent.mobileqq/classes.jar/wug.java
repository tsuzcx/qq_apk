import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;

public class wug
  implements View.OnTouchListener
{
  public wug(VideoPlayerView paramVideoPlayerView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    VideoPlayerView.a(this.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wug
 * JD-Core Version:    0.7.0.1
 */