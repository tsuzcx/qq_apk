import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.biz.subscribe.widget.textview.FollowTextView.a;
import com.tencent.mobileqq.pb.PBStringField;

public class sib
  implements FollowTextView.a
{
  public sib(VideoPlayerView paramVideoPlayerView) {}
  
  public void a(boolean paramBoolean, CertifiedAccountMeta.StFeed paramStFeed)
  {
    sqn.b(VideoPlayerView.a(this.this$0).poster.id.get(), "auth_video", "finish_follow", 0, 0, new String[] { "", "", VideoPlayerView.a(this.this$0).id.get(), VideoPlayerView.a(this.this$0).title.get() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sib
 * JD-Core Version:    0.7.0.1
 */