import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sif
  implements View.OnClickListener
{
  public sif(VideoPlayerView paramVideoPlayerView) {}
  
  public void onClick(View paramView)
  {
    if (VideoPlayerView.a(this.this$0)) {
      VideoPlayerView.c(this.this$0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      VideoPlayerView.d(this.this$0);
      if (VideoPlayerView.a(this.this$0) != null) {
        sqn.c(VideoPlayerView.a(this.this$0).poster.id.get(), "auth_video", "fullscreen", 0, 0, new String[] { "", "", VideoPlayerView.a(this.this$0).poster.nick.get(), VideoPlayerView.a(this.this$0).title.get() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sif
 * JD-Core Version:    0.7.0.1
 */