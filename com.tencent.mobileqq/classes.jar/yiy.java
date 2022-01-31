import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.HashMap;

public class yiy
  implements ylm
{
  public yiy(VideoPlayerView paramVideoPlayerView) {}
  
  public void a(boolean paramBoolean, CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (VideoPlayerView.a(this.a) != null)
    {
      yvu.a(VideoPlayerView.a(this.a).poster.id.get(), "auth_video", "half_follow", 0, 0, new String[] { "", "", VideoPlayerView.a(this.a).id.get(), VideoPlayerView.a(this.a).title.get() });
      VideoPlayerView.a(this.a).poster.followState.set(1);
      VideoPlayerView.a(this.a).put(VideoPlayerView.a(this.a).poster.id.get(), Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yiy
 * JD-Core Version:    0.7.0.1
 */