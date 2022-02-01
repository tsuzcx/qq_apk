import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.biz.subscribe.widget.textview.FollowTextView.a;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.HashMap;

public class sid
  implements FollowTextView.a
{
  public sid(VideoPlayerView paramVideoPlayerView) {}
  
  public void a(boolean paramBoolean, CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (VideoPlayerView.a(this.this$0) != null)
    {
      sqn.b(VideoPlayerView.a(this.this$0).poster.id.get(), "auth_video", "half_follow", 0, 0, new String[] { "", "", VideoPlayerView.a(this.this$0).id.get(), VideoPlayerView.a(this.this$0).title.get() });
      VideoPlayerView.a(this.this$0).poster.followState.set(1);
      VideoPlayerView.a(this.this$0).put(VideoPlayerView.a(this.this$0).poster.id.get(), Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sid
 * JD-Core Version:    0.7.0.1
 */