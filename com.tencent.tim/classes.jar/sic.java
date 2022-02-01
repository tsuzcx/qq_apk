import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sic
  implements View.OnClickListener
{
  public sic(VideoPlayerView paramVideoPlayerView) {}
  
  public void onClick(View paramView)
  {
    if (VideoPlayerView.a(this.this$0) != null) {
      VideoPlayerView.a(this.this$0).setVisibility(8);
    }
    VideoPlayerView.a(this.this$0, false);
    VideoPlayerView.access$302(true);
    this.this$0.start();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sic
 * JD-Core Version:    0.7.0.1
 */