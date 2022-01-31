import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.mobileqq.pb.PBStringField;

public class yja
  implements View.OnClickListener
{
  public yja(VideoPlayerView paramVideoPlayerView) {}
  
  public void onClick(View paramView)
  {
    if (VideoPlayerView.b(this.a)) {
      VideoPlayerView.c(this.a);
    }
    do
    {
      return;
      VideoPlayerView.d(this.a);
    } while (VideoPlayerView.a(this.a) == null);
    yvu.b(VideoPlayerView.a(this.a).poster.id.get(), "auth_video", "fullscreen", 0, 0, new String[] { "", "", VideoPlayerView.a(this.a).poster.nick.get(), VideoPlayerView.a(this.a).title.get() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yja
 * JD-Core Version:    0.7.0.1
 */