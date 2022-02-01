import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;

public class sig
  implements View.OnClickListener
{
  public sig(VideoPlayerView paramVideoPlayerView) {}
  
  public void onClick(View paramView)
  {
    if (sox.i("mLLSkipBackWrapper", 500L))
    {
      VideoPlayerView.e(this.this$0);
      VideoPlayerView.a(this.this$0, VideoPlayerView.b(this.this$0), 0, 1, true);
      if (this.this$0.a() != null) {
        this.this$0.seek(this.this$0.a().getCurrentPositionMs() - 10000L);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sig
 * JD-Core Version:    0.7.0.1
 */